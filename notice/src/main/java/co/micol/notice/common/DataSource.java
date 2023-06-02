package co.micol.notice.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {//싱글톤 클래스입니다
//	private static DataSource dataSource;
//	private String driver = "oracle.jdbc.driver.OracleDriver"; //conn객체를 얻기위해서
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; //conn일으킬때는 db의 물리적주소, id, pw필요함
//	private String user = "micol";
//	private String password = "1234";
//	private Connection conn; //connection이라는 interface가 있음
//	
//	private DataSource(){
//		
//	}
//	
//	public static DataSource getInstance() {
//		if(dataSource == null) {
//			dataSource = new DataSource();
//		}
//		return dataSource;
//	}
//	
//	
//	public Connection getConnection() { //토글링
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//		}catch(ClassNotFoundException | SQLException e){
//			e.printStackTrace();
//		}
//		return conn;
//	}
	
	//위는 전통적인 방식(모델과 DB연결)
	
	//아래는 Mabatis와 DB연결
	//Mabatis로 연결하기
	private static SqlSessionFactory sqlSessionFactory; //이건 마이바티스 라이브러리가 제공하는거
	private DataSource() {
		
	}
	
	public static SqlSessionFactory getInstance() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream;
		try{
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			 
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
	
	
}
