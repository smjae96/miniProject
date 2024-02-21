package model.vo;

public class Health {
	private int infoNo;
	private int userNo;
	private double bmi;
	private double avgWeight;
	private double reqKcal;
	
	
	public Health() {
		
	}
	public Health(int infoNo, int userNo, double bmi, double avgWeight, double reqKcal) {
		super();
		this.infoNo = infoNo;
		this.userNo = userNo;
		this.bmi = bmi;
		this.avgWeight = avgWeight;
		this.reqKcal = reqKcal;
	}
	
	
	public Health(int userNo, double bmi, double avgWeight, double reqKcal) {
		super();
		this.userNo = userNo;
		this.bmi = bmi;
		this.avgWeight = avgWeight;
		this.reqKcal = reqKcal;
	}
	public int getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public double getBmi() {
		return bmi;
	}
	public double getAvgWeight() {
		return avgWeight;
	}
	public double getReqKcal() {
		return reqKcal;
	}
	
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public void setAvgWeight(double avgWeight) {
		this.avgWeight = avgWeight;
	}
	public void setReqKcal(double reqKcal) {
		this.reqKcal = reqKcal;
	}
	
	@Override
	public String toString() {
		return "Health [infoNo=" + infoNo + ", userNo=" + userNo + ", bmi=" + bmi + ", avgWeight=" + avgWeight
				+ ", reqKcal=" + reqKcal + "]";
	}

	
	
	
	
	
}
