package com.worktango.database;

/**
 * Created by cmadhavareddy on 1/12/18.
 */
public interface DBInterface {
    public void openConnection();
    public void closeConnection();
    public Object[][] retrieveData(String sQuery);
    public int updateData(String sQuery);
    public void executeSqlFile(String filePath);
}