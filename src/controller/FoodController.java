package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.vo.MemberSelection;
import model.vo.food.Food;
import service.FoodService;
import service.MemberService;
import view.MemberMenu;

public class FoodController {

	
	public static double calculateTotalCalories(ArrayList<Food> selectedFoods) {
		int totalCalories = 0;
		for(Food food : selectedFoods) {
			totalCalories += food.calculateCalories();
		}
		return totalCalories;
	}
	
	public ArrayList<MemberSelection> checkList(int userNo) {
		ArrayList<MemberSelection> list = new FoodService().checkList(userNo);
		
		return list;
	}
	
	public void insertFood(ArrayList<Food> selectedFoods, double totalKcal, int totalPrice, int userNo) {
		MemberSelection ms = new MemberSelection(userNo, selectedFoods.get(0).getName(), selectedFoods.get(1).getName(), selectedFoods.get(2).getName(), totalKcal, totalPrice);
		int result = new FoodService().insertFood(ms);
		
		if(result >0) {
			System.out.println("\n음식 리스트 추가에 성공했습니다.");
		} else {
			System.out.println("\n음식 리스트 추가에 실패했습니다.\n");
		}
	}
	
	public void showFoodList(int userNo) {
		ArrayList<MemberSelection> list = new FoodService().showFoodList(userNo);
		
		if(list.isEmpty()) {
			System.out.println("\n선택하신 음식 리스트가 없습니다.\n");
		} else {
			for(MemberSelection m : list) {
				 System.out.println(m);
			 }
		}
	}
	
	
	
	public void saveMenuFile(String userName, ArrayList<Food> selectedFoods, double totalCalories, int price) {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String today = formatter.format(d);
	    String fileName = today + " " +userName + "님 식권.txt";

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	        writer.write("===== "+userName + "님의 식권 =====\n");
	        writer.write("\n버거킹 : " + selectedFoods.get(0).getName() + "\n");
	        writer.write("한솥도시락 : " + selectedFoods.get(1).getName() + "\n");
	        writer.write("엄마카세 : " + selectedFoods.get(2).getName() + "\n");

	        writer.write("\n총 칼로리 : " + totalCalories + " kcal\n");
	        writer.write("총 금액 : " +price + "원\n");
	        
	    } catch (IOException e) {
	       e.printStackTrace();
	    }
	}
}

	
