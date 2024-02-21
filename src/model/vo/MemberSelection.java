package model.vo;

import java.sql.Date;

public class MemberSelection {
	private int selectionNo;
	private int userNo;
	private String burgerking;
	private String hansot;
	private String homeCook;
	private double totalKcal;
	private int totalPrice;
	private Date insertDate;
	
	public MemberSelection() {
	
	}
	
	public MemberSelection(String burgerking, String hansot, String homeCook, double totalKcal, int totalPrice) {
		super();
		this.burgerking = burgerking;
		this.hansot = hansot;
		this.homeCook = homeCook;
		this.totalKcal = totalKcal;
		this.totalPrice = totalPrice;
	}



	public MemberSelection(int userNo, String burgerking, String hansot, String homeCook, double totalKcal,
			int totalPrice) {
		super();
		this.userNo = userNo;
		this.burgerking = burgerking;
		this.hansot = hansot;
		this.homeCook = homeCook;
		this.totalKcal = totalKcal;
		this.totalPrice = totalPrice;
	}



	@Override
	public String toString() {
		return "\n===== "+insertDate + " =====\n버거킹 : " +burgerking + " / 한솥도시락 : " + hansot + " / 엄마카세 : " +homeCook+ "\n" + "총 칼로리 : " +totalKcal+ "kcal / 총 금액 : " + totalPrice+"원\n";
	}



	public int getSelectionNo() {
		return selectionNo;
	}



	public void setSelectionNo(int selectionNo) {
		this.selectionNo = selectionNo;
	}



	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getBurgerking() {
		return burgerking;
	}

	public void setBurgerking(String burgerking) {
		this.burgerking = burgerking;
	}

	public String getHansot() {
		return hansot;
	}

	public void setHansot(String hansot) {
		this.hansot = hansot;
	}

	public String getHomeCook() {
		return homeCook;
	}

	public void setHomeCook(String homeCook) {
		this.homeCook = homeCook;
	}

	public double getTotalKcal() {
		return totalKcal;
	}

	public void setTotalKcal(double totalKcal) {
		this.totalKcal = totalKcal;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public MemberSelection(int selectionNo, int userNo, String burgerking, String hansot, String homeCook,
			double totalKcal, int totalPrice, Date insertDate) {
		super();
		this.selectionNo = selectionNo;
		this.userNo = userNo;
		this.burgerking = burgerking;
		this.hansot = hansot;
		this.homeCook = homeCook;
		this.totalKcal = totalKcal;
		this.totalPrice = totalPrice;
		this.insertDate = insertDate;
	}


	
}
