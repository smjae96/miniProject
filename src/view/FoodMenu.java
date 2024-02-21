package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.FoodController;
import controller.HealthController;
import controller.MemberController;
import model.vo.food.Food;
import model.vo.food.MenuCreator;

public class FoodMenu {

	private static Scanner sc = new Scanner(System.in);
	public static FoodController fc = new FoodController();
	public static MemberController mc = new MemberController();
	public static HealthController hc = new HealthController();
	
	public static void mainMenu(String userId) {
		System.out.println("\n===== " +mc.checkName(userId)+"님 환영합니다! ===== \n");
		double avgWeight = 0;
		
		System.out.println("<<<<< 고객님의 건강정보 >>>>>\n");
		if(mc.checkGender(userId).trim().equals("M")) {
			 avgWeight = (mc.checkHeight(userId)/100)*(mc.checkHeight(userId)/100)*22;
		 } else {
			 avgWeight = (mc.checkHeight(userId)/100)*(mc.checkHeight(userId)/100)*21;
		 }
		double reqKcal = avgWeight*30;
		double bmi = mc.checkWeight(userId)/((mc.checkHeight(userId)/100)*(mc.checkHeight(userId)/100));
		hc.bmiCheck(userId);
		System.out.printf("\n%s님의 표준 체중은 %.1fkg입니다.\n", mc.checkName(userId),avgWeight);
		System.out.println();
		System.out.printf("%s님의 일일 권장섭취량은 %.1fkcal입니다.\n", mc.checkName(userId), reqKcal);
		System.out.println();
		System.out.println();
		while(true) {
			System.out.println("<<<<< 메뉴 선택 >>>>>\n");
			System.out.println("1. 오늘의 식사 메뉴 선택하기");
			System.out.println("2. 내가 선택한 음식 리스트 확인하기");
			System.out.println("3. 회원 정보 변경");
			System.out.println("4. 회원 탈퇴");
			System.out.println("0. 로그아웃");
			System.out.print("메뉴를 선택하세요 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) {
				if(fc.checkList(mc.checkuserNo(userId)).isEmpty()) {
					selectFoods(userId, reqKcal);
				}else {
					System.out.println("\n*** 오늘 이미 식권을 발급받으신 회원입니다. 내일 새로 발급받아주세요!! ***\n");
					continue;
				}
			} else if(choice == 2) {
				showFoodList(userId);
			} else if(choice == 3) {
				updateMember(userId);
				break;
			} else if(choice == 4) {
				deleteMember(userId);
				break;
			}else if(choice == 0) {
				return;
			} else {
				System.out.println("메뉴 번호를 잘못 선택하셨습니다. 다시 선택해 주세요.");
				continue;
			}
		}
		
	}
	
	
	public static ArrayList<Food> selectFoods(String userId, double reqKcal) {
		ArrayList<Food> selectedFoods = new ArrayList<>();
		System.out.println();
		System.out.println("*****주의!!*****");
		System.out.println("식권은 하루에 한 장만 발급 받으실 수 있습니다.");
		System.out.println("선택하시는 음식들의 총 칼로리 합은 회원님의 일일 권장섭취량을 초과할 수 없습니다.");
		while(true) {
			int price = 0;
			System.out.println();
			System.out.println("===== 버거킹 메뉴 / 칼로리(kcal) / 가격 =====");
			System.out.println("1. 콰트로 치즈 와퍼 / 769.0kcal / 7900원");
			System.out.println("2. 통새우 와퍼 / 740.9kcal / 7900원");
			System.out.println("3. 롱치킨 버거 / 571.1kcal / 4700원");
			System.out.println("4. 바삭킹 4조각 / 544.2kcal / 5800원");
			System.out.println("5. 스태커 4와퍼 / 1724.2kcal / 12500원");
			System.out.println("6. 선택 x");
			System.out.print("메뉴를 선택하세요(1~6) : ");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice<1 || choice > 6) {
				System.out.println("메뉴를 잘못 선택하셨습니다. 처음부터 다시 선택해주세요!");
				continue;
			}
			Food selectedBurgerking = MenuCreator.BurgerkingMenu().get(choice - 1);
			selectedFoods.add(selectedBurgerking);
			
			
			System.out.println();
			
			System.out.println("===== 한솥 메뉴 / 칼로리(kcal) =====");
			System.out.println("1. 치킨마요덮밥 / 686.0kcal / 4400원");
			System.out.println("2. 돈까스 도련님 / 746.0kcal / 4900원");
			System.out.println("3. 돈까스 카레 / 563.7kcal / 4800원");
			System.out.println("4. 소불고기 도시락 / 894.2kcal / 5700원");
			System.out.println("5. 참치야채고추장 / 463.7kcal / 3700원");
			System.out.println("6. 선택 x");
			System.out.print("메뉴를 선택하세요(1~6) : ");
			choice = sc.nextInt();
			sc.nextLine();
			if(choice<1 || choice > 6) {
				System.out.println("메뉴를 잘못 선택하셨습니다. 처음부터 다시 선택해주세요!");
				continue;
			}
			Food selectedHansot = MenuCreator.HansotMenu().get(choice-1);
			selectedFoods.add(selectedHansot);
			
			System.out.println();
			
			System.out.println("===== 엄마카세 메뉴 / 칼로리(kcal) / 엄마카세 메뉴는 모두 무료 제공입니다! =====");
			System.out.println("1. 된장찌개 + 밥 한 공기 / 477.3kcal");
			System.out.println("2. 리코타 샐러드 / 240.7kcal");
			System.out.println("3. 고등어 구이 + 밥 한 공기 / 677.2kcal");
			System.out.println("4. 신라면 + 밥 한 공기 / 799.7kcal");
			System.out.println("5. 블랙페퍼 닭가슴살 / 114.4kcal");
			System.out.println("6. 선택 x");
			System.out.print("메뉴를 선택하세요(1~6) : ");
			choice = sc.nextInt();
			sc.nextLine();
			if(choice<1 || choice > 6) {
				System.out.println("메뉴를 잘못 선택하셨습니다. 처음부터 다시 선택해주세요!");
				continue;
			}
			Food selectedHomeCook = MenuCreator.HomeCookMenu().get(choice-1);
			selectedFoods.add(selectedHomeCook);
			
			double totalCalories = FoodController.calculateTotalCalories(selectedFoods);
			
			if(totalCalories > reqKcal) {
				System.out.println("\n회원님의 일일 권장섭취량 초과입니다. 메뉴를 다시 선택하십시오! ");
				selectedFoods.clear();
				continue;
			} else {
				System.out.println("\n<< "+mc.checkName(userId)+"님이 선택한 음식 >> ");
				for(int i=0; i<selectedFoods.size(); i++) {
					if(i<2) {
					System.out.print(selectedFoods.get(i).getName() + " / ");
					} else {
						System.out.println(selectedFoods.get(i).getName());
					}
			}
				price = selectedFoods.get(0).getPrice() + selectedFoods.get(1).getPrice() + selectedFoods.get(2).getPrice();
				System.out.println();
				System.out.print("선택하신 음식의 총 칼로리 : " +totalCalories + "kcal\n");
				System.out.print("선택하신 음식의 총 가격 : " +price + "원");
				System.out.println();
				
				System.out.print("선택하신 음식으로 주문을 확정하시겠습니까?(주문 확정을 원하시면 'Y' 버튼을, 취소를 원하시면 다른 버튼을 눌러주세요.) :");
				String confirm = sc.nextLine().toUpperCase();
				if(confirm.equals("Y")) {
					fc.insertFood(selectedFoods, totalCalories, price, mc.checkuserNo(userId));
					fc.saveMenuFile(mc.checkName(userId), selectedFoods, totalCalories, price);
					System.out.println("\n식권이 출력되었습니다. 확인해주세요!\n");
				} else {
					selectedFoods.clear();
					continue;
				}
			}
			
			return selectedFoods;
		}
	}
	
	public static void nonMemselectFoods() {
		ArrayList<Food> selectedFoods = new ArrayList<>();
		System.out.println();
		while(true) {
			int price = 0;
			System.out.print("식권에 출력될 이름 혹은 닉네임을 입력하세요 : ");
			String name = sc.nextLine();
			System.out.println();
			System.out.println("===== 버거킹 메뉴 / 칼로리(kcal) / 가격 =====");
			System.out.println("1. 콰트로 치즈 와퍼 / 769.0kcal / 7900원");
			System.out.println("2. 통새우 와퍼 / 740.9kcal / 7900원");
			System.out.println("3. 롱치킨 버거 / 571.1kcal / 4700원");
			System.out.println("4. 바삭킹 4조각 / 544.2kcal / 5800원");
			System.out.println("5. 스태커 4와퍼 / 1724.2kcal / 12500원");
			System.out.println("6. 선택 x");
			System.out.print("메뉴를 선택하세요(1~6) : ");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice<1 || choice > 6) {
				System.out.println("메뉴를 잘못 선택하셨습니다. 처음부터 다시 선택해주세요!");
				continue;
			}
			Food selectedBurgerking = MenuCreator.BurgerkingMenu().get(choice - 1);
			selectedFoods.add(selectedBurgerking);
			
			
			System.out.println();
			
			System.out.println("===== 한솥 메뉴 / 칼로리(kcal) =====");
			System.out.println("1. 치킨마요덮밥 / 686.0kcal / 4400원");
			System.out.println("2. 돈까스 도련님 / 746.0kcal / 4900원");
			System.out.println("3. 돈까스 카레 / 563.7kcal / 4800원");
			System.out.println("4. 소불고기 도시락 / 894.2kcal / 5700원");
			System.out.println("5. 참치야채고추장 / 463.7kcal / 3700원");
			System.out.println("6. 선택 x");
			System.out.print("메뉴를 선택하세요(1~6) : ");
			choice = sc.nextInt();
			sc.nextLine();
			if(choice<1 || choice > 6) {
				System.out.println("메뉴를 잘못 선택하셨습니다. 처음부터 다시 선택해주세요!");
				continue;
			}
			Food selectedHansot = MenuCreator.HansotMenu().get(choice-1);
			selectedFoods.add(selectedHansot);
			
			System.out.println();
			
			System.out.println("===== 엄마카세 메뉴 / 칼로리(kcal) / 엄마카세 메뉴는 모두 무료 제공입니다! =====");
			System.out.println("1. 된장찌개 + 밥 한 공기 / 477.3kcal");
			System.out.println("2. 리코타 샐러드 / 240.7kcal");
			System.out.println("3. 고등어 구이 + 밥 한 공기 / 677.2kcal");
			System.out.println("4. 신라면 + 밥 한 공기 / 799.7kcal");
			System.out.println("5. 블랙페퍼 닭가슴살 / 114.4kcal");
			System.out.println("6. 선택 x");
			System.out.print("메뉴를 선택하세요(1~6) : ");
			choice = sc.nextInt();
			sc.nextLine();
			if(choice<1 || choice > 6) {
				System.out.println("메뉴를 잘못 선택하셨습니다. 처음부터 다시 선택해주세요!");
				continue;
			}
			Food selectedHomeCook = MenuCreator.HomeCookMenu().get(choice-1);
			selectedFoods.add(selectedHomeCook);
			
			double totalCalories = FoodController.calculateTotalCalories(selectedFoods);
			
			
			System.out.println("\n<< "+name+"님이 선택한 음식 >> ");
			for(int i=0; i<selectedFoods.size(); i++) {
				if(i<2) {
				System.out.print(selectedFoods.get(i).getName() + " / ");
				} else {
					System.out.println(selectedFoods.get(i).getName());
				}
			}
			price = selectedFoods.get(0).getPrice() + selectedFoods.get(1).getPrice() + selectedFoods.get(2).getPrice() + 2000;
			System.out.println();
			System.out.print("선택하신 음식의 총 칼로리 : " +totalCalories + "kcal\n");
			System.out.print("선택하신 음식의 총 가격(추가요금 포함) : " +price + "원");
			System.out.println();
			
			System.out.print("선택하신 음식으로 주문을 확정하시겠습니까?(주문 확정을 원하시면 'Y' 버튼을, 취소를 원하시면 다른 버튼을 눌러주세요.) :");
			String confirm = sc.nextLine().toUpperCase();
			if(confirm.equals("Y")) {
				fc.saveMenuFile(name, selectedFoods, totalCalories, price);
				System.out.println("\n식권이 출력되었습니다. 확인해주세요!\n");
				return;
			} else {
				selectedFoods.clear();
				continue;
			}
		
			
		}
	}
	
	public static void showFoodList(String userId) {
		fc.showFoodList(mc.checkuserNo(userId));
	}
	
	public static void updateMember(String userId) {
		 System.out.println("\n== 회원 정보 변경 ==");
		 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하실 시 자동으로 로그아웃되며 초기화면으로 돌아갑니다!!\n");
		 int i=0;
		 while(true) {
			 System.out.print("회원 정보 변경을 원하시면 회원님의 아이디를 입력하세요 : ");
			 String inputId = sc.nextLine();
			 
			 System.out.print("회원님의 비밀번호를 입력하세요 : ");
			 String userPw = sc.nextLine();
			 
			 if(inputId.equals(mc.checkId(userId))) {
				 if(userPw.equals(mc.checkPw(userId))) {
					 System.out.print("변경할 비밀번호 : ");
					 String newPw = sc.nextLine().trim().replace(" ", "");
					 
					 System.out.print("변경할 전화번호(-빼고 입력) : ");
					 String phone = sc.nextLine().trim().replace(" ", "").replace("-", "");
					 
					 System.out.print("변경할 신장(cm) : ");
					 double height = sc.nextDouble();
					 sc.nextLine();
					 
					 System.out.print("변경할 체중(kg) : ");
					 double weight = sc.nextDouble();
					 sc.nextLine();
					 
					 mc.updateMember(userId, newPw, phone, height, weight);
					 hc.updateHealthInfo(mc.checkuserNo(userId), mc.checkGender(userId), height, weight);
					 System.out.println("\n** 회원 정보 변경 성공!! **\n자동으로 로그아웃되며 초기화면으로 돌아갑니다!\n");
					 return;
					 
				 } else {
					 i++;
					 if(i<5) {
						 System.out.println("\n**아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하십시오.\n");
						 continue;
					 } else {
						 System.out.println("\n***** 경고!! *****");
						 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하셨습니다. 자동으로 로그아웃되며 초기화면으로 돌아갑니다!");
						 return;
					 }
				 }
			 } else {
				 i++;
				 if(i<5) {
					 System.out.println("\n**아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하십시오.\n");
					 continue;
				 } else {
					 System.out.println("\n***** 경고!! *****");
					 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하셨습니다. 자동으로 로그아웃되며 초기화면으로 돌아갑니다!");
					 return;
				 }
				 
			 }
		 }
	}
	
	 public static void deleteMember(String userId) {
		 System.out.println("\n == 회원 탈퇴 ==");
		 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하실 시 자동으로 로그아웃되며 초기화면으로 돌아갑니다!!\n");
		 int i= 0;
		 while(true) {
			 System.out.print("탈퇴를 원하시면 회원님의 아이디를 입력하세요 : ");
			 String inputId = sc.nextLine();
			 
			 System.out.print("회원님의 비밀번호를 입력하세요 : ");
			 String userPw = sc.nextLine();
			 
			 if(inputId.equals(mc.checkId(userId))) {
				 if(userPw.equals(mc.checkPw(userId))) {
					 System.out.print("\n정말로 탈퇴하시겠습니까? ('Y' 입력 시 탈퇴 확정 / 다른 키 입력 시 탈퇴 취소) : ");
					 String del = sc.nextLine().toUpperCase();
					 if(del.equals("Y")) {
					 mc.deleteMember(userId, userPw);
					 return;
					 } else {
						 System.out.println("\n탈퇴를 취소하셨으므로 자동으로 로그아웃되며 초기화면으로 돌아갑니다!");
						 return;
					 }
				 }else {
					 i++;
					 if(i < 5) {
					 System.out.println("\n**아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하세요.\n");
					 }
					 else {
						 System.out.println("\n***** 경고!! *****");
						 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하셨습니다. 자동으로 로그아웃되며 초기화면으로 돌아갑니다!");
						 return;
					 }
					 continue;
				 }
			 }else {
				 i++;
				 if(i < 5) {
				 System.out.println("\n**아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하세요.\n");
				 }
				 else {
					 System.out.println("\n***** 경고!! *****");
					 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하셨습니다. 자동으로 로그아웃되며 초기화면으로 돌아갑니다");
					 return;
				 }
				 continue;
			 }

		 }
	 }
}
