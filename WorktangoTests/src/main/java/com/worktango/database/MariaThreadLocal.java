package com.worktango.database;


import java.sql.Connection;

/**
 * Created by cmadhavareddy on 1/22/18.
 */
public class MariaThreadLocal {
    public static ThreadLocal<Connection> myThreadLocal = ThreadLocal.withInitial((() -> null));
}
