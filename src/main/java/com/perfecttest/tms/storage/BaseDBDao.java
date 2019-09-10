package com.perfecttest.tms.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.perfecttest.tms.config.Configuration;
import com.perfecttest.tms.storage.utils.DBClient;

public class BaseDBDao {

    private Configuration configuration = new Configuration();
    protected static final Gson GSON = new GsonBuilder().create();

    protected DBClient getDbClient(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //TODO: fix!!!!! remove from here!!!
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DBClient dbClient =
                new DBClient()
                        .withConnectionUrl(configuration.getDbServerUrl())
                        .withUser(configuration.getDbUser())
                        .withPassword(configuration.getDbPassword());
        dbClient.init();
        return dbClient;
    }
}
