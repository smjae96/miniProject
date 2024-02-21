package model.vo;

import java.sql.Date;

/*
 *  * VO (Value Object)
 *    한 명의 회원 (db 테이블의 한 행 데이터)에 대한 데이터를 기록하기 위한 저장용 객체
 */
public class Member {
	// 필드
	// : 기본적으로 DB 컬럼명과 유사하게 작성 (소문자로 시작, 낙타표기법)
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String gender;
	private String ssn;
	private int age;
	private String phone;
	private double height;
	private double weight;
	private Date enrollDate;
	
	//	생성자
	// : 기본적으로 기본생성자, 매개변수 있는 생성자(모든 필드 데이터)
	public Member() {};
	
	// Alt + Shift + S / +O


	public Member(int userNo, String userId, String userPw, String userName, String gender, String ssn, int age,
			String phone, double height, double weight, Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.ssn = ssn;
		this.age = age;
		this.phone = phone;
		this.height = height;
		this.weight = weight;
		this.enrollDate = enrollDate;
	}

	public Member(String userId, String userPw, String phone, double height, double weight) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.phone = phone;
		this.height = height;
		this.weight = weight;
	}

	public Member(String userId, String userPw, String userName, String gender, String ssn, int age, String phone, double height,
			double weight) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.ssn = ssn;
		this.age = age;
		this.phone = phone;
		this.height = height;
		this.weight = weight;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender.toUpperCase();
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", gender=" + gender + ", ssn=" + ssn + ", age=" + age + ", phone=" + phone + ", height=" + height
				+ ", weight=" + weight + ", enrollDate=" + enrollDate + "]";
	}



	

	
	
}
