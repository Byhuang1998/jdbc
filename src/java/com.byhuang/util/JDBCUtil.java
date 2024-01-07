package com.byhuang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC工具类
 */
public class JDBCUtil {

    public static Connection connection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        if (connection == null) {
            // 数据库连接地址，注意格式 jdbc:mysql://ip:port/db_name
            String url = "jdbc:mysql://114.115.200.239:3306/test";
            // 数据库用户
            String user = "by";
            // 数据库密码
            String password = "hxx20011013";
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取数据库连接
            connection = DriverManager.getConnection(url, user, password);
        }

        return connection;
    }
}
