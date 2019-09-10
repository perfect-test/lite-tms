package com.perfecttest.tms.storage.utils;

import com.perfecttest.tms.storage.exceptions.StorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DBClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBClient.class);

    private String connectionUrl;
    private String user;
    private String password;

    private Connection connection;
    private Statement statement;

    public DBClient withConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
        return this;
    }

    public DBClient withUser(String user) {
        this.user = user;
        return this;
    }

    public DBClient withPassword(String password) {
        this.password = password;
        return this;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public DBClient init() {
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new StorageException("Error while init db connection", e);
        }
        return this;
    }

    /**
     * execute select query to db
     *
     * @param query query to db
     * @return {@link java.sql.ResultSet} object
     */
    public ResultSet executeQuery(String query) {
        try {
            LOGGER.info("Query to db: " + query);
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new StorageException(String.format("Error while execute query '%s'", query), e);
        }
    }

    /**
     * execute update(INSERT,UPDATE,DELETE) query to db
     *
     * @param query query to db
     * @return updated rows count
     */
    public int executeUpdateQuery(String query) {
        try {
            LOGGER.info("Query to db: " + query);
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new StorageException(String.format("Error while execute query '%s'", query), e);
        }
    }


    public DBClient close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new StorageException("Error while close db connection", e);
        }
        return this;
    }

    public static boolean isUpdateQuery(String query){
        query = query.toLowerCase();
        if(query.contains("update") || query.contains("insert") || query.contains("truncate") || query.contains("delete")) {
            return true;
        }
        return false;
    }
}
