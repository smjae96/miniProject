package service;

import java.sql.Connection;

import common.JDBCTemplate;
import model.dao.HealthDao;
import model.vo.Health;

public class HealthService {

	public int insertHealthInfo(Health h) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new HealthDao().insertHealthInfo(h, conn);
		
		if(result>0) {		// 건강정보 기입 성공
			JDBCTemplate.commit(conn);
		} else {			// 건강정보 기입 실패	
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int updateHealthInfo(Health h) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new HealthDao().updateHealthInfo(h, conn);
		
		if(result>0) {		// 건강정보 변경 성공
			JDBCTemplate.commit(conn);	
		} else {			// 건강정보 변경 실패
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
