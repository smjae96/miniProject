package controller;

import model.vo.Health;
import service.HealthService;

public class HealthController {
	private MemberController mc = new MemberController();
	public void bmiCheck(String userId) {
		double bmi = mc.checkWeight(userId)/((mc.checkHeight(userId)/100)*(mc.checkHeight(userId)/100));
		System.out.printf("%s님의 BMI지수는 %.1f 입니다.\n", mc.checkName(userId), bmi);
		if(bmi<18.5) {
			System.out.print("[저체중]이니 많이 좀 드세요!!");
		} else if(bmi>=18.5 && bmi<23) {
			System.out.print("[정상체중]입니다.");
		} else if(bmi>=23 && bmi <25) {
			System.out.print("[비만위험단계]이니 적절한 식습관을 유지하세요!!");
		} else if(bmi >=25 && bmi <30) {
			System.out.print("[1단계 비만]입니다. 오늘부터 다이어트는 어떨까요?");
		} else {
			System.out.print("[2단계 비만]으로 당뇨 등 성인병 위험이 있으니 각별한 주의가 필요합니다!!");
		}
		System.out.println();
	}
	
	public void insertHealthInfo(int userNo, double bmi, double avgWeight, double reqKcal) {
		Health h = new Health(userNo, bmi, avgWeight, reqKcal);
		int result = new HealthService().insertHealthInfo(h);
	}

	public void updateHealthInfo(int userNo, String gender, double height, double weight) {
		double bmi = weight/((height/100)*(height/100));
		double avgWeight = 0;
		if(gender.trim().equals("M")) {
			 avgWeight = (height/100)*(height/100)*22;
		 } else {
			 avgWeight = (height/100)*(height/100)*21;
		 }
		double reqKcal = avgWeight*30;
		
		Health h = new Health(userNo, Math.round((bmi*10) / 10.0), Math.round((avgWeight*10) / 10.0), Math.round((reqKcal*10) / 10.0));
		int result = new HealthService().updateHealthInfo(h);
	}
}
