package com.perfecttest.tms.config;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;

public class Configuration {

    private static Configuration CONFIG;

    public Configuration() {
        PropertyLoader.populate(this);
    }

    public static Configuration getConfig(){
        if (CONFIG == null){
            CONFIG = new Configuration();
        }
        return CONFIG;
    }


    /*
     * Database
     */
    @Property("db.server.url")
    private String dbServerUrl = "jdbc:mysql://mysql:3306/lite_tms?useUnicode=yes&characterEncoding=UTF-8";

    @Property("db.name")
    private String dbName = "lite-tms";

    @Property("db.user")
    private String dbUser = "tms";

    @Property("db.password")
    private String dbPassword = "secret";


    public String getDbServerUrl() {
        return dbServerUrl;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}
