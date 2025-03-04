package com.stu.mhl.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Mark He
 * @version 1.0
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;
    //在静态代码块完成ds初始化
    static{
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("/Users/mark1/IdeaProjects/mhl/src/druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    //关闭连接。在数据池连接技术中，close不是真的断掉连接，而是把使用的connection对象放回连接池
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
