package com.edu.test.stateless;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource { //직접하드코딩 하지 않고 이방법을 쓴당
	private static DataSource dataSource = new DataSource();
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;

	
	private DataSource() { }
	
	public static DataSource getIncetance() {
		return dataSource;
		
	}
	
	public Connection getConnection() {
		dbConfig(); //환경파일을 불러 DB정보를 담는다.
		try {
			Class.forName(driver);
			conn =DriverManager.getConnection(url,user,password);
			
		}catch(ClassNotFoundException | SQLException e ) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void dbConfig() { //환경파일을 불러오는 메소드
		String resource = getClass().getResource("db.properties").getPath();
		Properties properties = new Properties(); //ProPerties 객체 생성(키와 값을 가지고있다)
		
		try {
			properties.load(new FileReader(resource)); 	//환경파일을 Reader 객체를 통해 읽음
			
			driver = properties.getProperty("driver");	// 변수에 환경파일의 값을 적용 
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");	
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
	
	
	

