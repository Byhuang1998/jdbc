package com.byhuang.api;

import com.byhuang.util.JDBCUtil;

import java.sql.Connection;
import java.sql.Statement;

/**
 * 连接数据库对象
 */
public class ConnectionDemo {

    public static void main(String[] args) throws Exception {

        Connection connection = JDBCUtil.getConnection();
        Statement statement = null;

        // 关闭自动提交：true为自动提交事务；false为手动提交事务，即为开启事务
        connection.setAutoCommit(false);
        try {

            // 定义sql
            String sql1 = "update user set phone = '666' where id = 1";

            String sql2 = "update user set phone = '666' where id = 2";

            // 获取执行sql的对象
            statement = connection.createStatement();
            // 执行更新语句
            statement.executeUpdate(sql1);

            // 若放开这一行，出现了异常，事务会回滚，相当于两条sql都没有执行
             int x = 9 / 0;

            statement.executeUpdate(sql2);
            // 提交事务
            connection.commit();
        } catch (Exception e) {
            // 回滚
            connection.rollback();
            e.printStackTrace();
        } finally {

            // 释放资源
            connection.close();
            statement.close();
        }
    }
}
