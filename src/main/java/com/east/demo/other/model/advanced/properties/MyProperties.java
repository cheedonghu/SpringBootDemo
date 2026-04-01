package com.east.demo.other.model.advanced.properties;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 配置文件类
 *
 * @author: east
 * @date: 2023/10/25
 */

public class MyProperties {
    private String oracleUrl;
    private String oracleUser;
    private String oraclePassword;

    private String reflectTest = "test";


    public MyProperties() {
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
            properties.load(fileInputStream);
            this.oracleUrl = properties.getProperty("ds.ds1.url");
            this.oracleUser = properties.getProperty("ds.ds1.user");
            this.oraclePassword = properties.getProperty("ds.ds1.password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOracleUrl() {
        return oracleUrl;
    }

    public String getOracleUser() {
        return oracleUser;
    }

    public String getOraclePassword() {
        return oraclePassword;
    }

    public String getReflectTest() {
        return reflectTest;
    }

    private void setReflectTest(String reflectTest) {
        this.reflectTest = reflectTest;
    }
}
