package service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import model.dao.FoodDao;
import model.vo.MemberSelection;

public class FoodService {
	public int insertFood(MemberSelection ms) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FoodDao().insertFood(ms, conn);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {				
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public ArrayList<MemberSelection> checkList(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<MemberSelection> list = new FoodDao().checkList(conn, userNo);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	public ArrayList<MemberSelection> showFoodList(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<MemberSelection> list = new FoodDao().showFoodList(conn, userNo);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
}
