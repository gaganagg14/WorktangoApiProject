package com.worktango.database;

import javax.mail.Session;

/**
 * Created by cmadhavareddy on 1/22/18.
 */
public class CassandraThreadLocal {
    public static ThreadLocal<Session> myThreadLocal = ThreadLocal.withInitial((() -> null));
}
