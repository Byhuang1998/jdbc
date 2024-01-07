package com.byhuang.test;

import com.byhuang.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC连接数据库
 */
public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = JDBCUtil.getConnection();
        // 定义sql
        String sql = "update user set phone = '444' where id = 1";
        // 获取执行sql的对象
        Statement statement = connection.createStatement();
        // 执行更新语句
        int i = statement.executeUpdate(sql);
        // 释放资源
        connection.close();
        statement.close();

    }
}
