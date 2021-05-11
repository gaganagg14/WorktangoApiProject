package com.worktango.database;

/**
 * Created by cmadhavareddy on 1/12/18.
 */

//import com.ibatis.common.jdbc.ScriptRunner;
public class DBHelper {
    public static enum DBTYPE {
        MARIADB,
        MARIADBPEM,
        MARIADBPB,
        //CASSANDRADB,
        CASSANDRA_NEW
    }

    DBTYPE dbtype;
    String sKeySpace;
    DBInterface dbInterface;

    public DBHelper(DBTYPE dbtype) {
        this.dbtype = dbtype;
        //this.sKeySpace = sKeySpace;
    }

    public Object[][] readDataFromDB(String sQuery) {
        Object[][] readdata = null;
        if (dbtype == DBTYPE.MARIADB) {
            dbInterface = new MariaDBClient();
        } else if (dbtype == DBTYPE.MARIADBPEM) {
            dbInterface = new MariaDBClient(true);
        } else if (dbtype == DBTYPE.MARIADBPB) {
            dbInterface = new MariaDBClient("PB");
        } else if (dbtype == DBTYPE.CASSANDRA_NEW) {
            dbInterface = new CassandraDBClient();
        }
        dbInterface.openConnection();
        readdata = dbInterface.retrieveData(sQuery);
        dbInterface.closeConnection();

        return readdata;
    }

    public int writeDataToDb(String sQuery) {
        int no_of_rows_updated;
        if (dbtype == DBTYPE.MARIADB) {
            dbInterface = new MariaDBClient();
        } else if (dbtype == DBTYPE.MARIADBPEM) {
            dbInterface = new MariaDBClient(true);
        } else if (dbtype == DBTYPE.CASSANDRA_NEW) {
            dbInterface = new CassandraDBClient();
        }
        dbInterface.openConnection();
        no_of_rows_updated = dbInterface.updateData(sQuery);
        dbInterface.closeConnection();

        return no_of_rows_updated;
    }

    public void executeScriptFile(String filePath) {
        if (dbtype == DBTYPE.MARIADB) {
            dbInterface = new MariaDBClient();
        } else if (dbtype == DBTYPE.MARIADBPEM) {
            dbInterface = new MariaDBClient(true);
        } else if (dbtype == DBTYPE.CASSANDRA_NEW) {
            dbInterface = new CassandraDBClient();
        }
        dbInterface.openConnection();
        dbInterface.executeSqlFile(filePath);
        dbInterface.closeConnection();

    }
}
