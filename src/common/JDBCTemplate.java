package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// 공통 템플릿 : 매번 반복적으로 작성될 코드를 메소드로 정의해두는 것
public class JDBCTemplate {
	// * 모든 메소드들은 [static] 메소드로 작성할 것.
	//	 싱글톤 패턴 : 메모리 영역에 단 한 번만 올려두고 매번 재사용하는 것.
	
	// 1. Connection 객체 생성 (DB 접속) 한 후 해당 Connection 객체를 반환해주는 메소드
	//		JDBC 작업 순서 중 [1], [2] 해당
	public static Connection getConnection() {
		
		Connection conn = null;
		
		Properties prop = new Properties();
		try {
			//prop.load(new FileInputStream("resources/driver.properties"));
			
			//Class.forName(prop.getProperty("driver"));
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			//conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
			//System.out.println("접속 성공");
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} //catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		return conn;
	}
	
	// 2. commit 처리 해주는 메소드 (Connection 객체를 전달받아서)
	public static void commit(Connection conn) {
		try {
			// Connection 객체가 null이 아니고 close되지 않은 상태에서 commit
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3. rollback 처리 해주는 메소드 (Connection 객체를 전달받아서)
	public static void rollback(Connection conn) {
		try {
			// Connection 객체가 null이 아니고 close되지 않은 상태에서 rollback
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// JDBC 관련 객체들 반납 -> ResultSet, [Prepared]Statement, Connection
	// 4. Statement 관련 객체를 반밥하는 메소드
	//		PreparedStatement 객체도 전달받을 수 있음! => Statement 클래스의 자식클래스이므로, 다형성 적용되어 가능.
	public static void close(Statement stmt) {
		try {
			// Statement 관련 객체가 null이 아니고 close되어 있지 않은 상태라면 close처리(반납)
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 5. Connection 객체 반납ㅎ나느 메소드
	public static void close(Connection conn) {
		try {
			// Connection 관련 객체가 null이 아니고 close되어 있지 않은 상태라면 close처리(반납)
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 6. ResultSet 객체 반납하는 메소드
	public static void close(ResultSet rset) {
		try {
			// ResultSet 관련 객체가 null이 아니고 close되어 있지 않은 상태라면 close처리(반납)
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
