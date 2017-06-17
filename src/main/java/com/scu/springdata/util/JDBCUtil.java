package com.scu.springdata.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author xing
 * @date 2017年6月15日
 * @time 下午9:10:15
 * jdbc工具类：
 * 1） 获取connection
 * 2) 释放资源
 */
public class JDBCUtil {

	/**
	 * @return Connection
	 * @throws Exception
	 * 获取connection
	 */
	public static Connection getConnection() throws Exception{
		
//		String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
//		String user = "root";
//		String password = "123456";
//		String driverClass = "com.mysql.jdbc.Driver";
		
		InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		
		String url = properties.getProperty("jdbc_url");
		String user = properties.getProperty("jdbc_username");
		String password = properties.getProperty("jdbc_password");
		String driverClass = properties.getProperty("jdbc_driver");
		
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url,user,password);
		return connection;
	}
	
	/**
	 * 释放JDBC相关的资源
	 */
	public static void release(ResultSet resultSet,
			                   Statement statement,
			                   Connection connection){
		try {
			if(resultSet!=null){
				resultSet.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}
}
