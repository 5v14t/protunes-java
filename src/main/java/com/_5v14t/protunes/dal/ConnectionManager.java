package com._5v14t.protunes.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class ConnectionManager {
    private final SQLServerDataSource ds = new SQLServerDataSource();

    public ConnectionManager() {
        ds.setServerName("10.176.111.34");
        ds.setPortNumber(1433);
        ds.setDatabaseName("HenAnd03_MyTunes");
        ds.setUser("CS2026b_e_10");
        ds.setPassword("CS2026bE10#26");
        ds.setTrustServerCertificate(true);
    }

    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        }
    }

}