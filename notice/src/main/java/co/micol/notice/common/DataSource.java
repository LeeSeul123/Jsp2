package co.micol.notice.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {//싱글톤 클래스입니다
	private static DataSource dataSource;
	private String driver = "oracle.jdbc.driver.OracleDriver"; //conn객체를 얻기위해서
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; //conn일으킬때는 db의 물리적주소, id, pw필요함
	private String user = "micol";
	private String password = "1234";
	private Connection conn; //connection이라는 interface가 있음
	
	private DataSource(){
		
	}
	
	public static DataSource getInstance() {
		if(dataSource == null) {
			dataSource = new DataSource();
		}
		return dataSource;
	}
	
	
	public Connection getConnection() { //토글링
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
}
