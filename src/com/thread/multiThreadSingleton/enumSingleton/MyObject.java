package com.thread.multiThreadSingleton.enumSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum MyObject {
    connectionFactory;
    private Connection connection;
    private MyObject(){
        try {
            System.out.println("调用MyObject的构造");
            String url = "jdbc:mysql://localhost:3306";
            String username = "sa";
            String password = "";
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
