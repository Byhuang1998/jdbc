package com.byhuang.api;

import com.byhuang.util.JDBCUtil;

import java.sql.*;

/**
 * 预编译执行SQL对象
 */
public class PreparedStatementDemo {

    public static void main(String[] args) throws SQLException {

        Connection connection = JDBCUtil.getConnection();

        // 定义sql，用？作为占位符表示查询的参数
        String sql = "select * from user where name = ? and phone = ?";

        // 需要传入sql作为参数
        PreparedStatement statement = connection.prepareStatement(sql);

        // 第一个参数表示第几个占位符，设置？的值
        statement.setString(1, "zs");
        statement.setString(2, "777");

        // 执行更新语句
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            String phone = resultSet.getString("phone");
            System.out.println(id + name + gender + phone);
        }

        // 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
