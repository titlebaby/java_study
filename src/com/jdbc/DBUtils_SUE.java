package com.jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_SUE {
    //使用apache-DBUtils + druid 完成对表的crud 操作


    @Test
    public void testQueryMany() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnect();

        //2. 使用DBUtils 类和接口， 先引入DBUtils相关jar 加入到本项目

        // 3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4.就可以执行查询
        String sql = "select * from students where age > ?";
        /**
         * (1) query 方法就是执行sql语句，得到resultset --- 封装到----> ArrayList 集合中
         * （2）返回集合
         * （3）connection： 链接
         * （4）sql ：执行的sql语句
         * （5）new BeanListHandler<>(Students.class) 在将resultSet-> Students对象 -> 封装到 ArrayList
         * 底层使用反射机制 去获取 Students类的属性，然后惊醒封装
         * （6） 15 就是给sql 语句中的 ? 赋值，可以多个复制，因为是可变参数 object ...params
         */
        List<Students> list =
                queryRunner.query(connection, sql, new BeanListHandler<>(Students.class), 15);
        System.out.println("输出集合的信息");
        for (Students students : list) {
            System.out.println(students);
        }
        JDBCUtilsByDruid.close(null, null, connection);

    }


    // 使用apache-DBUtils + druid  返回单条记录
    @Test
    public void testQuerySingle() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnect();

        //2. 使用DBUtils 类和接口， 先引入DBUtils相关jar 加入到本项目

        // 3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4.就可以执行查询
        String sql = "select * from students where id = ?";
        // 我们知道是单行 BeanHandler
        Students student = queryRunner.query(connection, sql, new BeanHandler<>(Students.class), 1);
        System.out.println(student);
        JDBCUtilsByDruid.close(null, null, connection);

    }

    // 使用apache-DBUtils + druid  返回单条记录
    @Test
    public void testQueryScalar() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnect();

        //2. 使用DBUtils 类和接口， 先引入DBUtils相关jar 加入到本项目

        // 3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4.就可以执行查询
        String sql = "select name from students where id = ?";

        // 因为返回的是一个对象
        Object object = queryRunner.query(connection, sql, new ScalarHandler<>(), 1);
        System.out.println(object);


        JDBCUtilsByDruid.close(null, null, connection);

    }

    // 使用apache-DBUtils + druid dml update insert delete
    @Test
    public void testQueryDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnect();

        //2. 使用DBUtils 类和接口， 先引入DBUtils相关jar 加入到本项目

        // 3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4.就可以执行查询
//        String sql = "update students set name =? where id = ?";
//        String sql = "INSERT INTO students VALUES (NULL ,?,?,?,?)";
        String sql = "delete from students where id =?";

        // 因为返回的是一个对象
//        int rows = queryRunner.update(connection, sql, "林青霞", 3);
//        int rows = queryRunner.update(connection, sql, 30,1,"李四",1236547899);
        int rows = queryRunner.update(connection, sql,  3);
        System.out.println(rows);

        JDBCUtilsByDruid.close(null, null, connection);

    }
}
