package com.stu.mhl.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mark He
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
