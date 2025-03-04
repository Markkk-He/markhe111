package com.stu.mhl.dao;

import com.stu.mhl.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mark He
 * @version 1.0
 * 开发BasicDAO, 作为其他DAO的父类
 */
public class BasicDao<T> {
    //泛型指定具体类型
    private QueryRunner queryRunner = new QueryRunner();
    //开发通用的dml方法，针对任意的表
    public int update(String sql, Object... params) {
        Connection conn = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            int update = queryRunner.update(conn, sql, params);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null, null, conn);
        }
    }
    //返回多个对象，针对任意表

    /**
     *
     * @param sql sql语句，可以有？
     * @param clazz 传入一个类的class对象，比如Actor.class
     * @param params 传入具体的值，可以是多个
     * @return 根据Actor.class返回对应的ArrayList集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params) {

        Connection conn = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(conn, sql,new BeanListHandler<T>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null, null, conn);
        }
    }
    //返回单行结果
    public T querySingle(String sql,Class<T> clazz ,Object... params) {

        Connection conn = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(conn,sql,new BeanHandler<T>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null, null, conn);
        }

    }
    //返回单个值的方法
    public Object queryScalar(String sql, Object... params) {

        Connection conn = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(conn,sql,new ScalarHandler(),params);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null, null, conn);
        }
    }
}
