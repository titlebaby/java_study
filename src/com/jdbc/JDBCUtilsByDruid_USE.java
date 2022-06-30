package com.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCUtilsByDruid_USE {
    /**
     * 返回 ResultSet
     * 问题
     * 1. 结果集合connection是关联的，即如果关闭链接，就不能使用结果集
     * 2. 结果集不利于数据管理【只能用一次】
     * 3. 使用返回信息也不方便
     * =>
     * 封装成一个有“表”对象的ArrayList集合中
     */
    // 用土方法来解决ResultSet  问题 封装到ArrayList
    @Test
    public void testSelect() {
        String sql = "select * from students where age > ?";
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Students> list = new ArrayList<Students>();

        try {
            connection = JDBCUtilsByDruid.getConnect();
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 10); // 给 ? 赋值
            set = preparedStatement.executeQuery();
//            connection.close();
            while (set.next()) {
                int id = set.getInt("id");
                int age = set.getInt("age");
                int class_id = set.getInt("class_id");
                String name = set.getString("name");
                String create_time = set.getString("create_time");
                //把得到的resultSet的记录，封装到 Actor对象， 放入到list集合
                list.add(new Students(id, age, class_id, name, create_time));
            }
            System.out.println("list集合输出");
            for (Students students : list) {
                System.out.println("id=" + students.getId()+ "\t" + "name=" + students.getAge());
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }


    }
}
