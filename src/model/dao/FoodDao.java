package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import common.JDBCTemplate;
import model.vo.MemberSelection;

public class FoodDao {

	public int insertFood(MemberSelection ms, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO MEMBERSELECTION VALUES(SEQ_MS.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ms.getUserNo());
			pstmt.setString(2, ms.getBurgerking());
			pstmt.setString(3, ms.getHansot());
			pstmt.setString(4, ms.getHomeCook());
			pstmt.setDouble(5, ms.getTotalKcal());
			pstmt.setInt(6, ms.getTotalPrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<MemberSelection> checkList(Connection conn, int userNo) {
		ArrayList<MemberSelection> list = new ArrayList<>();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		PreparedStatement pstmt = null;	// SQL문 실행할 객체
		ResultSet rset = null;		   // SQL 실행 결과 타입
		
		String sql = "SELECT * FROM MEMBERSELECTION WHERE USERNO = ? AND TO_CHAR(INSERTDATE, 'yyyy-mm-dd') = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setString(2, today);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				MemberSelection ms = new MemberSelection(rset.getInt("SELECTIONNO"), rset.getInt("USERNO"), rset.getString("BURGERKING"), rset.getString("HANSOT"), 
						rset.getString("HOMECOOK"),	rset.getDouble("TOTALKCAL"), rset.getInt("TOTALPRICE"), rset.getDate("INSERTDATE"));
				list.add(ms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	
	}
	
	public ArrayList<MemberSelection> showFoodList(Connection conn, int userNo) {
		ArrayList<MemberSelection> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;	// SQL문 실행할 객체
		ResultSet rset = null;		   // SQL 실행 결과 타입
		
		String sql = "SELECT * FROM MEMBERSELECTION WHERE USERNO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				MemberSelection ms = new MemberSelection(rset.getInt("SELECTIONNO"), rset.getInt("USERNO"), rset.getString("BURGERKING"), rset.getString("HANSOT"), 
						rset.getString("HOMECOOK"),	rset.getDouble("TOTALKCAL"), rset.getInt("TOTALPRICE"), rset.getDate("INSERTDATE"));
				list.add(ms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}
	
}
