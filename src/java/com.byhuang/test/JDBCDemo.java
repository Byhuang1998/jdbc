package com.byhuang.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 数据库连接地址，注意格式 jdbc:mysql://ip:port/db_name
        String url = "jdbc:mysql://114.115.200.239:3306/test";
        // 数据库用户
        String user = "by";
        // 数据库密码
        String password = "hxx20011013";
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取数据库连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 定义sql
        String sql = "update user set phone = '234' where id = 1";
        // 获取执行sql的对象
        Statement statement = connection.createStatement();
        // 执行更新语句
        int i = statement.executeUpdate(sql);
        // 释放资源
        connection.close();
        statement.close();

    }
}
