package com.jdbc.utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils_Use {
    public static void main(String[] args) {
//        testDML();
    }

    @Test
    public void testDML() {
        String sql = "update user_test set name=? where id = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;


        try {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "周星驰");
            preparedStatement.setInt(2, 4);
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
    @Test
    public void testSelect() {
        String sql = "select * from user_test order by id desc  limit 10";
        PreparedStatement preparedStatement = null;
        Connection connection = null;


        try {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
//                resultSet.getDate("");
                System.out.println("id="+id+"\t"+"name="+name+"\t");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
