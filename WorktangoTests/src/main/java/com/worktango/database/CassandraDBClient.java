package com.worktango.database;


import java.io.BufferedReader;
import java.io.FileReader;
import java.net.InetSocketAddress;
import java.util.*;

import com.worktango.common.SystemProperties;
import com.worktango.common.Utility;

/**
 * Created by cmadhavareddy on 1/12/18.
 */
public class CassandraDBClient implements DBInterface {
    private String CASSANDRA_DB_DIR;

    Utility utility;
    public CassandraDBClient(){
        CASSANDRA_DB_DIR = "test";

        utility = new Utility();
    }

    private List<InetSocketAddress> getWhiteListAsInetSocketAddressList(
            List<String> hostnames, int port) {
        List<InetSocketAddress> inetList = new ArrayList<InetSocketAddress>();
        for (String hostname : hostnames) {
            inetList.add(new InetSocketAddress(hostname, port));
        }
        return inetList;
    }

    @Override
    public void openConnection() {
/*
        if(CassandraThreadLocal.myThreadLocal.get() == null || CassandraThreadLocal.myThreadLocal.get().isClosed()){
            initCluster();
        }*/
    }

    public void initCluster(){
        Properties properties = utility.loadPropertyFromFile(CASSANDRA_DB_DIR);
        List<String> lsHostName = new ArrayList<String>();
        Integer sPortNumber = null;

        if(SystemProperties.env.equalsIgnoreCase("pdn")){
            String sPDN = utility.findPDNByIP();
            String[] sHostNames = properties.get(sPDN+".Host").toString().split("\\|");
            Collections.addAll(lsHostName, sHostNames);
            sPortNumber = Integer.parseInt(properties.get(sPDN+".Port").toString());
        }else{
            String[] sHostNames = properties.get(SystemProperties.env.toUpperCase()+".Host").toString().split("\\|");
            Collections.addAll(lsHostName, sHostNames);
            sPortNumber = Integer.parseInt(properties.get(SystemProperties.env.toUpperCase()+".Port").toString());
        }
/*
        Cluster.Builder builder = Cluster.builder();
        List<InetSocketAddress> whiteList = getWhiteListAsInetSocketAddressList(lsHostName, sPortNumber);

        builder = builder.addContactPointsWithPorts(whiteList);
        initSession(builder.build());*/
    }
/*
    public void initSession(Cluster cluster){
        try {
            CassandraThreadLocal.myThreadLocal.set(cluster.connect());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
*/
    @Override
    public void closeConnection() {
        // if(cluster!=null) cluster.close();
    }
/*
    @Override
    public Object[][] retrieveData(String sQuery) {
    	
        ResultSet resultSet = CassandraThreadLocal.myThreadLocal.get().execute(sQuery);
        System.out.println("Query executed = "+sQuery);

        Iterator<Row> iterator = resultSet.iterator();
        List<Object[]> result = new ArrayList<Object[]>();

        Object[] header = new Object[resultSet.getColumnDefinitions().size()];
        for (int i = 0; i < resultSet.getColumnDefinitions().size(); ++i) {
            final Object label = resultSet.getColumnDefinitions().getName(i);
            header[i] = label;
        }

        while (!resultSet.isExhausted() & iterator.hasNext())
        {
            Row row = iterator.next();
            if(row!=null) {

                Object[] str = new Object[resultSet.getColumnDefinitions().size()];
                for (int i = 0; i < resultSet.getColumnDefinitions().size(); ++i) {
                    if (resultSet.getColumnDefinitions().getType(i) == DataType.uuid()) {
                        str[i] = String.valueOf(row.getUUID(resultSet.getColumnDefinitions().getName(i)));
                    } else if (resultSet.getColumnDefinitions().getType(i) == DataType.text() ||
                            resultSet.getColumnDefinitions().getType(i) == DataType.varchar()) {
                        str[i] = row.getString(resultSet.getColumnDefinitions().getName(i));
                    } else if (resultSet.getColumnDefinitions().getType(i) == DataType.cint() ||
                            resultSet.getColumnDefinitions().getType(i) == DataType.varint()) {
                        str[i] = String.valueOf(row.getInt(resultSet.getColumnDefinitions().getName(i)));
                    } else if (resultSet.getColumnDefinitions().getType(i) == DataType.cboolean()) {
                        str[i] = String.valueOf(row.getBool(resultSet.getColumnDefinitions().getName(i)));
                    } else if (resultSet.getColumnDefinitions().getType(i) == DataType.cdouble()) {
                        str[i] = String.valueOf(row.getDouble(resultSet.getColumnDefinitions().getName(i)));
                    } else if (resultSet.getColumnDefinitions().getType(i) == DataType.timestamp()) {
                        str[i] = String.valueOf(row.getTimestamp(resultSet.getColumnDefinitions().getName(i)));
                    } else if (resultSet.getColumnDefinitions().getType(i) == DataType.date()){
                        str[i] = String.valueOf(row.getDate(resultSet.getColumnDefinitions().getName(i)));
                    } else if (resultSet.getColumnDefinitions().getType(i).equals(DataType.CollectionType.map(DataType.varchar(), DataType.varchar(), false))){
                        str[i] = String.valueOf(row.getMap(resultSet.getColumnDefinitions().getName(i), String.class, String.class));
                    }
                }
                result.add(str);




                        
            }
        }

        int resultLength = result.size() + 1;
        Object[][] finalResult = new Object[resultLength][resultSet.getColumnDefinitions().size()];
        finalResult[0] = header;
        for (int i = 1; i < resultLength; ++i) {
            Object[] row = result.get(i - 1);
            finalResult[i] = row;
        }
        return finalResult; 
    }

    @Override
    public int updateData(String sQuery) {
        int no_of_rows = 0;
        try {
            CassandraThreadLocal.myThreadLocal.get().execute(sQuery);
            System.out.println("Query executed = " + sQuery);
            return no_of_rows + 1;
        }catch (Exception e){
            System.out.println("Error in running Query = "+sQuery);
            System.out.println(e.getStackTrace());
            return no_of_rows;
        }

    }
*/
    /**
     * This method would execute cassandra scripts
     * @param filePath
     */
    @Override
    public void executeSqlFile(String filePath){
        BufferedReader reader = null;
        java.sql.Connection con = null;
        java.sql.Statement statement = null;
        try {
            System.out.println("Running data setup file" + filePath);
            reader = new BufferedReader(new FileReader(filePath));
            String line = null;
            // read script line by line
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("-") && !line.equals("")) {
                    try {
                        System.out.println("Query executed =" + line);
                        updateData(line);
                    } catch (Exception e) {

                        System.out.println("Error in executing Query=" + line + " Error=" + e.getMessage());
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

	@Override
	public Object[][] retrieveData(String sQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateData(String sQuery) {
		// TODO Auto-generated method stub
		return 0;
	}
}
