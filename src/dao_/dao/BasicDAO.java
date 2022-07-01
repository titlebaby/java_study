package dao_.dao;

import dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> { //泛型指定具体类型
    private QueryRunner qr = new QueryRunner();

    //开发通用的dml方法，针对任意的表
    public int update(String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnect();
            int rows = qr.update(connection, sql, params);
            return rows; //受影响的行数
        } catch (SQLException e) {
            throw new RuntimeException(e);// 将编译异常 -> 运行异常，抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    // 返回多个对象

    /**
     *
     * @param sql sql语句可以有 占位符 ?
     * @param claz 传入类的class 对象
     * @param params ？对应的参数 可以是多个
     * @return 根据Students.class 返回对应的ArrayList集合
     */
    public List<T> queryMultiply(String sql, Class<T> claz, Object... params){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnect();
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(claz), params);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);// 将编译异常 -> 运行异常，抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    public T querySingle(String sql, Class<T> claz, Object... params){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnect();
            return qr.query(connection, sql, new BeanHandler<>(claz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);// 将编译异常 -> 运行异常，抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    public Object queryScalar(String sql, Object... params){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnect();
            return qr.query(connection, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);// 将编译异常 -> 运行异常，抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

}
