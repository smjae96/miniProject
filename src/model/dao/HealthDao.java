package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import model.vo.Health;

public class HealthDao {

	public int insertHealthInfo(Health h, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO HEALTHINFO VALUES(SEQ_HEALTH.NEXTVAL,?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, h.getUserNo());
			pstmt.setDouble(2, h.getBmi());
			pstmt.setDouble(3, h.getAvgWeight());
			pstmt.setDouble(4, h.getReqKcal());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateHealthInfo(Health h, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE HEALTHINFO SET BMI = ?, AVGWEIGHT = ?, REQKCAL = ? WHERE USERNO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, h.getBmi());
			pstmt.setDouble(2, h.getAvgWeight());
			pstmt.setDouble(3, h.getReqKcal());
			pstmt.setInt(4, h.getUserNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
}
