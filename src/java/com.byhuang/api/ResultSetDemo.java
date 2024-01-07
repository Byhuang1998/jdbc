package com.byhuang.api;

import com.byhuang.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 查询语句返回结果对象
 */
public class ResultSetDemo {

    public static void main(String[] args) throws SQLException {

        Connection connection = JDBCUtil.getConnection();
        Statement statement = null;

        // 定义sql
        String sql = "select * from user";

        // 获取执行sql的对象
        statement = connection.createStatement();
        // 执行更新语句
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            String phone = resultSet.getString("phone");
            System.out.println(id + name + gender + phone);
        }

        // 释放资源
        connection.close();
        statement.close();
    }
}
