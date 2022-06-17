package com.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConn {
    public static void main(String[] args) {

    }
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();

        //创建url 和 user password
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        DriverManager.registerDriver(driver);


        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第三种方式="+ connection);


    }


    @Test
    public void connect04() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        //在加载这个driver类时，会自动完后曾注册
        Class.forName("com.mysql.jdbc.cj.Driver");


        //创建url 和 user password
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";


        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第三种方式="+ connection);


    }
}
