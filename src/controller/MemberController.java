package controller;



import model.vo.Member;
import service.MemberService;
import view.FoodMenu;
import view.MemberMenu;

public class MemberController {
	

	public void insertMember(String userId, String userPw, String userName, String gender, String ssn, int age, String phone, double height, double weight) {
		Member m = new Member(userId, userPw, userName, gender, ssn, age, phone, height, weight);
		
		int result = new MemberService().insertMember(m);
		
		if (result > 0) {	// 회원 추가 성공
			new MemberMenu().displaySuccess(m.getUserName() + " 회원님이 가입에 성공했습니다.");
		} else {			// 회원 추가 실패
			new MemberMenu().displayFailed(m.getUserName() + "님이 가입에 실패했습니다.");
		}
	}
	
	public String checkId(String userId) {
		Member m = new MemberService().searchId(userId);
		if(m == null) {
			return "";
		} else {
		return m.getUserId();
		} 
	}
	
	public String checkPw(String userId) {
		Member m = new MemberService().searchId(userId);
		if(m == null) {
			return "";
		} else {
		return m.getUserPw();
		} 
	}
	
	public int checkuserNo(String userId) {
		Member m = new MemberService().searchId(userId);
		if(m == null) {
			return 0;
		} else {
		return m.getUserNo();
		} 
	}
	
	public String checkName(String userId) {
		Member m = new MemberService().searchId(userId);
		if(m == null) {
			return "";
		} else {
		return m.getUserName();
		} 
	}
	
	public double checkHeight(String userId) {
		Member m = new MemberService().searchId(userId);
		if(m == null) {
			return 0;
		} else {
		return m.getHeight();
		} 
	}
	
	public double checkWeight(String userId) {
		Member m = new MemberService().searchId(userId);
		if(m == null) {
			return 0;
		} else {
		return m.getWeight();
		} 
	}
	
	
	public String checkGender(String userId) {
		Member m = new MemberService().searchId(userId);
		if(m == null) {
			return "";
		} else {
		return m.getGender();
		} 
	}
	
	public void updateMember(String userId, String newPw, String phone, double height, double weight) {
		Member m = new Member(userId, newPw,  phone, height, weight);

		int result = new MemberService().updateMember(m);
		
		if (result > 0) {	// 회원 정보 변경 성공
			new MemberMenu().displaySuccess(m.getUserId() + "님의 회원 정보 변경에 성공했습니다.");
		} else {			// 회원 정보 변경 실패
			new MemberMenu().displayFailed(m.getUserId() + "님의 회원 정보 변경에 실패했습니다.");
		}
	}
	
	public void deleteMember(String userId, String userPw) {
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPw(userPw);
		int result = new MemberService().deleteMember(m);
		
		if (result > 0) {	// 회원 탈퇴 성공
			new MemberMenu().displaySuccess(m.getUserId() + "님의 회원 탈퇴에 성공했습니다.");
		} else {			// 회원 탈퇴 실패
			new MemberMenu().displayFailed(m.getUserId() + "님의 회원 탈퇴에 실패했습니다.");
		}
	}
	
	public void foundId(String userName, String phone) {
		Member m = new MemberService().foundId(userName, phone);
		
		if (m != null) {
			System.out.println("\n"+userName + "님의 아이디는 " + m.getUserId() + "입니다!");
		} else {
			new MemberMenu().displayNoData("존재하지 않는 회원입니다!!");
		}
	}
	
	public void foundPw(String userId, String phone, String ssn) {
		Member m = new MemberService().foundPw(userId, phone, ssn);
		
		if (m != null) {
			System.out.println("\n"+userId + "님의 비밀번호는 " + m.getUserPw()+ "입니다!");
		} else {
			new MemberMenu().displayNoData("비밀번호를 찾을 수 없습니다!!");
		}
	}
}
