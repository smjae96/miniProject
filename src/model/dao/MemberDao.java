package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import model.vo.Member;

public class MemberDao {

	
	public int insertMember(Member m, Connection conn) {
		// PreparedStatement 객체 사용
		
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO MEMBERLIST VALUES(SEQ_MEM.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPw());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getSsn());
			pstmt.setInt(6, m.getAge());
			pstmt.setString(7, m.getPhone());
			pstmt.setDouble(8, m.getHeight());
			pstmt.setDouble(9, m.getWeight());
			
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public Member searchId(Connection conn, String userId) {
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBERLIST WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("GENDER"), rset.getString("SSN"), rset.getInt("AGE"), rset.getString("PHONE"), rset.getDouble("HEIGHT"), rset.getDouble("WEIGHT"),
						rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	public int updateMember(Member m, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBERLIST SET USERPW = ? , PHONE = ? , HEIGHT = ?, WEIGHT = ? WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPw());
			pstmt.setString(2, m.getPhone());
			pstmt.setDouble(3, m.getHeight());
			pstmt.setDouble(4, m.getWeight());
			pstmt.setString(5, m.getUserId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Member m, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBERLIST WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}
	
	public Member foundId(Connection conn, String userName, String phone) {
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBERLIST WHERE USERNAME = ? AND PHONE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, phone);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("GENDER"), rset.getString("SSN"), rset.getInt("AGE"), rset.getString("PHONE"), rset.getDouble("HEIGHT"), rset.getDouble("WEIGHT"),
						rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
		
	}
	
	public Member foundPw(Connection conn, String userId, String phone, String ssn) {
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBERLIST WHERE USERID = ? AND PHONE = ? AND SSN = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, phone);
			pstmt.setString(3, ssn);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("GENDER"), rset.getString("SSN"), rset.getInt("AGE"), rset.getString("PHONE"), rset.getDouble("HEIGHT"), rset.getDouble("WEIGHT"),
						rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
		
	}
}
