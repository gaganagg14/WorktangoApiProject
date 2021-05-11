package com.worktango.database;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.coreWrapper.LoggerInfo;
import com.worktango.common.SystemProperties;
import com.worktango.common.Utility;

/**
 * Created by cmadhavareddy on 1/12/18.
 */
public class MariaDBClient implements DBInterface {
    private String MARIA_DB_DIR = "database/mariadb.properties";
    Connection connection;
    Utility utility;
    String filePath = null;
    LoggerInfo info = LoggerInfo.getInstance();

    public MariaDBClient() {
        utility = new Utility();
    }

    public MariaDBClient(Boolean isPemDB) {
        if (isPemDB)
            MARIA_DB_DIR = "database/mariadbpem.properties";
        utility = new Utility();
    }

    public MariaDBClient(String isPbDB) {
        MARIA_DB_DIR = "database/mariadbpb.properties";
        utility = new Utility();
    }

    @Override
    public void openConnection() {
        try {
            if (MariaThreadLocal.myThreadLocal.get() == null || MariaThreadLocal.myThreadLocal.get().isClosed()) {
                initConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() {
        String sHostName = null;
        String sUserName = null;
        String sPassword = null;
        String sKeySpace = null;
        Properties properties = utility.loadPropertyFromFile(MARIA_DB_DIR);

        if (SystemProperties.env.equalsIgnoreCase("pdn")) {
            String sPDN = utility.findPDNByIP();
            sHostName = properties.get(sPDN + ".Host").toString();
            sUserName = properties.get(sPDN + ".Username").toString();
            sPassword = properties.get(sPDN + ".Password").toString();
            sKeySpace = properties.get(sPDN + ".DefaultKeyspace").toString();
        } else {
            sHostName = properties.get(SystemProperties.env.toUpperCase() + ".Host").toString();
            sUserName = properties.get(SystemProperties.env.toUpperCase() + ".Username").toString();
            sPassword = properties.get(SystemProperties.env.toUpperCase() + ".Password").toString();
            sKeySpace = properties.get(SystemProperties.env.toUpperCase() + ".DefaultKeyspace").toString();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mariadb://" + sHostName + "/" + sKeySpace + "",
                    sUserName, sPassword);
            MariaThreadLocal.myThreadLocal.set(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object[][] retrieveData(String sQuery) {
        ResultSet rs = null;
        Statement stmt = null;
        try {
            stmt = MariaThreadLocal.myThreadLocal.get().createStatement();
            rs = stmt.executeQuery(sQuery);
            System.out.println("Query executed = " + sQuery);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            Object[] header = new Object[columnCount];
            for (int i = 0; i < columnCount; ++i) {
                final Object label = rsMetaData.getColumnLabel(i + 1);
                header[i] = label;
            }

            List<Object[]> result = new ArrayList<Object[]>();
            while (rs.next()) {
                Object[] str = new Object[columnCount];
                for (int i = 1; i <= columnCount; ++i) {
                    Object obj = null;
                    if (rsMetaData.getColumnTypeName(i-0) == "TINYINT") {
                        obj = rs.getInt(i);
                    } else
                        obj = rs.getObject(i);
                    str[i - 1] = obj;
                }
                result.add(str);
            }
            int resultLength = result.size() + 1;
            Object[][] finalResult = new Object[resultLength][columnCount];
            finalResult[0] = header;
            for (int i = 1; i < resultLength; ++i) {
                Object[] row = result.get(i - 1);
                finalResult[i] = row;
            }
            return finalResult;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) { /* ignored */ }
            try {
                stmt.close();
            } catch (Exception e) { /* ignored */ }
        }
        return null;
    }

    @Override
    public int updateData(String sQuery) {
        Statement stmt = null;
        int recordsAffected = 0;
        try {
            stmt = MariaThreadLocal.myThreadLocal.get().createStatement();
            recordsAffected = stmt.executeUpdate(sQuery);
            System.out.println("Query executed = " + sQuery);
            System.out.println("Records updated :" + recordsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e) { /* ignored */ }
        }
        return recordsAffected;
    }

    /**
     * Executes a file containing sql queries.
     *
     * @param filePath
     */
    @Override
    public void executeSqlFile(String filePath) {
        BufferedReader reader = null;
        Connection con = null;
        Statement statement = null;
        try {
            info.Info("Running data setup file" + filePath);
            statement = MariaThreadLocal.myThreadLocal.get().createStatement();
            reader = new BufferedReader(new FileReader(filePath));
            String line = null;
            // read script line by line
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("-") && !line.equals("")) {
                    try {
                        info.Info("Query executed =" + line);
                        statement.execute(line);
                    } catch (Exception e) {
                        info.Error("Error in executing Query=" + line + " Error=" + e.getMessage());
                        continue;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (Exception e) {
            }

        }

    }

}
