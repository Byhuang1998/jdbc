package com.byhuang.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtil {

    public static Connection getConnection() {

        Connection connection = null;

        try {

            Properties prop = new Properties();
            prop.load(new FileInputStream("src/druid.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
