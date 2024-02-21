package view;


import java.util.Scanner;

import controller.HealthController;
import controller.MemberController;



public class MemberMenu {
	 // 필드 : 입력용 객체(Scanner), Controller 객체
	 // 입력용 객체 - Scanner	(전역변수, 바로 입력받을 수 있도록 선언)
	 private Scanner sc = new Scanner(System.in);
	 // Controller 객체 (전역변수, 전반적으로 바로 요청할 수 있도록 선언)
	 private MemberController mc = new MemberController();
	 private HealthController hc = new HealthController();
	 
	 // 생성자 생략.. -> 기본 생성자만 사용
	 
	 // 메소드 -> 메뉴, 화면 출력, 입력받거나 기능들을 수행할 메소드
	 /**
	  *  사용자가 보게 될 첫 화면 (메인 화면)
	  */
	 public void mainMenu() {
		 
		 while(true) {	
			 System.out.println("\r\n"
					+ "=======================================================================================================\n" 
			 		+ " _   __  _   _    ___  ___  _____    ___    _         _____   _____   _____   _   __  _____   _____ \r\n"
			 		+ "| | / / | | | |   |  \\/  | |  ___|  / _ \\  | |       |_   _| |_   _| /  __ \\ | | / / |  ___| |_   _|\r\n"
			 		+ "| |/ /  | |_| |   |      | | |__   / /_\\ \\ | |         | |     | |   | /  \\/ | |/ /  | |__     | |  \r\n"
			 		+ "|    \\  |  _  |   | |\\/| | |  __|  |  _  | | |         | |     | |   | |     |    \\  |  __|    | |  \r\n"
			 		+ "| |\\  \\ | | | |   | |  | | | |___  | | | | | |____     | |    _| |_  | \\__/\\ | |\\  \\ | |___    | |  \r\n"
			 		+ "\\_| \\_/ \\_| |_/   \\_|  |_/ \\____/  \\_| |_/ \\_____/     \\_/    \\___/   \\____/ \\_| \\_/ \\____/    \\_/  \r\n"
			 		+ "                                                                                                    \r\n"
			 		+ "=======================================================================================================\r\n"
			 		+ "");
//			 System.out.println("\r\n"
//			 		+ "===============================================================================\r\n"
//			 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
//			 		+ "⠀⠀⠀⣀⠀⠀⠀⣀⡀⠀⠀⣀⣀⣀⣀⠀⠀⣀⠀⠀⠀⠀⠀⢀⡀⠀⠀⣀⠀⢀⡀⠀⠀⣀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⠀⠀⢀⣀⣀⣀⣀⣀⣀⡀⠀⠀⢀⣀⣀⣀⣀⣀⣀⠀⠀⢀⣀⣀⣀⡀⣀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
//			 		+ "⠀⠀⣸⣿⡀⠀⠀⣿⡇⠀⠈⠛⠛⠛⢻⣧⣼⣿⠀⠀⠀⠀⠀⢸⡷⠶⠶⣿⠀⢸⣧⣤⠀⠛⠛⠛⠛⠛⠛⣿⡇⠀⠀⠀⠀⠈⠛⣿⠛⠛⠛⣿⠛⠀⠀⠈⠛⠛⠛⠛⠛⣻⡇⠀⠀⠙⠛⠛⠛⠛⠛⣿⠀⢈⣉⣉⣿⡇⣿⣤⣿⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
//			 		+ "⠠⠾⠟⠉⠻⠶⠀⣿⡇⠀⢠⣤⣤⣤⣼⣧⢸⣿⠀⠀⠀⠀⠀⠘⠛⠛⠛⠛⠀⠸⠏⠀⠰⠶⠶⠶⠶⠶⠶⠿⠇⠀⠀⠀⠀⢀⣤⣿⣤⣤⣤⣿⣤⠀⠀⢸⡟⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀ ⠸⣿⣭⣭⣴⣿⠉⣿⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
//			 		+ "⠀⠴⠶⠶⠶⠶⠶⣶⡆⠀⠀⣤⠸⠿⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⣛⣛⣛⣛⣛⣻⡇⠀⠀⣶⣤⣤⣤⣤⣤⣶⡆⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠀⠀⠘⠛⠛⢻⡿⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀ ⠀⣿⠀⠀⣶⠶⠶⠶⠿⢶⣿⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
//			 		+ "⠀⠀⠀⠀⠀⠀⠀ ⣿⡇⠀⠀⣿⣤⣤⣤⣤⣤⣤⠀⠀⠀⠀⠀⠀⣿⣭⣭⣭⣭⣭⡅⠀⠀⣿⣧⣤⣤⣤⣤⣿⡇⠀⠀⠀⢰⣶⣶⣶⣶⣶⣶⣶⡆⠀⣶⣶⣶⣾⣷⣶⣶⣶⠀⢰⣶⣶⣶⣶⣶⣶⣶⡆ ⣿⣤⣤⣤⣤⣴⣿⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
//			 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
//			 		+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
//			 		+ "===============================================================================\r\n"
//			 		+ "");
			 
			 System.out.println("1. 회원 가입");
			 System.out.println("2. 로그인");
			 System.out.println("3. 회원 아이디 찾기");
			 System.out.println("4. 회원 비밀번호 찾기");
			 System.out.println("5. 비회원으로 식권 발급");
			 System.out.println("0. 프로그램 종료");
			 
			 System.out.print(">> 메뉴 선택 : ");
			 int menu = sc.nextInt();
			 
			 sc.nextLine();		
			 
			 switch(menu) {
			 case 1:
				 
				 inputMember();
				 break;
			 case 2:
				 logIn();
				 break;
			 case 3:
				 foundId();
				 break;
			 case 4:
				 foundPw();
				 break;
			 case 5:
				 nonMember();
				 break;
			 case 0:
				 return;	// 프로그램 종료 => 메소드 종료
			 default:
				 System.out.println("잘못 선택했습니다. 다시 선택해주세요.");
			 }
		 }
	 }
	 
	 /**
	  * 회원 가입 창(서브 화면). 추가하고자 하는 회원의 정보를 입력받아 회원을 추가 요청하는 창
	  */
	 public void inputMember() {
		 System.out.println("\n== 회원 가입 ==");
		 
		 System.out.print("아이디 : ");
		 String userId = sc.nextLine().trim().replace(" ", "");
		 
		 System.out.print("비밀번호 : ");
		 String userPw = sc.nextLine().trim().replace(" ", "");
		 
		 System.out.print("이름 : ");
		 String userName = sc.nextLine().trim().replace(" ", "");
		 
		 System.out.print("성별(M 또는 F) : ");
		 String gender = sc.nextLine().toUpperCase().trim();
		 if(gender.charAt(0) != 'M' && gender.charAt(0) != 'F') {
			 System.out.println("성별을 잘못입력하셨습니다. 최초화면으로 돌아갑니다!");
			 return;
		 }
		 
		 System.out.print("주민번호(- 빼고 입력) : ");
		 String ssn = sc.nextLine().trim().replace(" ", "").replace("-", "");
		 
		 System.out.print("나이 : ");
		 int age = sc.nextInt();
		 sc.nextLine();
				 
		 System.out.print("전화번호(- 빼고 입력) : ");
		 String phone = sc.nextLine().trim().replace(" ", "").replace("-", "");
		 
		 System.out.print("신장(cm) : ");
		 double height = sc.nextDouble();
		 sc.nextLine();
		 
		 System.out.print("체중(kg) : ");
		 double weight = sc.nextDouble();
		 sc.nextLine();
		 double bmi = weight/((height/100)*(height/100));
		 if(bmi >= 35) {
			 System.out.printf("회원 가입을 원하시는 고객님의 체질량 지수는 %.1f입니다.\n", bmi);
			 System.out.println("죄송합니다. 체질량 지수(BMI)가 35 이상이실 경우 3단계 비만으로 저희 식권 발급 프로그램에 가입하실 수 없습니다.");
			 return;
		 }
		 
		 // 사용자에게 입력받은 정보를 MemberController에 전달해야 한다!
		 System.out.print("회원 가입을 확정하시겠습니까?(확정 하시려면 'Y', 취소 하시려면 다른 키를 눌러주세요.) : ");
		 String confirm = sc.nextLine().toUpperCase().trim();
		 if(confirm.equals("Y")) {
		 mc.insertMember(userId, userPw, userName, gender, ssn, age, phone, height, weight);
		 } else {
			 return;
		 }
		 
		double avgWeight = 0;
		
		if(gender.trim().equals("M")) {
			 avgWeight = (height/100)*(height/100)*22;
		 } else {
			 avgWeight = (height/100)*(height/100)*21;
		 }
		double reqKcal = avgWeight*30;
		bmi = weight/((height/100)*(height/100));
		hc.insertHealthInfo(mc.checkuserNo(userId), Math.round((bmi*10)/10.0), Math.round((avgWeight*10)/10.0), Math.round((reqKcal*10)/10.0));
		 
	 }
	 
	 
	 public void logIn() {
			
		 System.out.println("\n== 로그인 ==");
			 while(true) {
					System.out.print("아이디를 입력하세요. : ");
					String userId = sc.nextLine();
					System.out.print("비밀번호를 입력하세요. : ");
					String userPw = sc.nextLine();
				 
				 if(userId.equals(mc.checkId(userId))) {
					 if(userPw.equals(mc.checkPw(userId))) {
						 System.out.println("\r\n"
						 		+ "==================================================================================================================================\n"
						 		+ " _       _____   _____   _____   _   _     _____   _   _   _____   _____   _____   _____   _____  _____ ______   _  _ \r\n"
						 		+ "| |     |  _  | |  __ \\ |_   _| | \\ | |   /  ___| | | | | /  __ \\ /  __ \\ |  ___| /  ___| /  ___||  ___||  _  \\ | || |\r\n"
						 		+ "| |     | | | | | |  \\/   | |   |  \\| |   \\ `--.  | | | | | /  \\/ | /  \\/ | |__   \\ `--.  \\ `--. | |__  | | | | | || |\r\n"
						 		+ "| |     | | | | | | __    | |   | . ` |    `--. \\ | | | | | |     | |     |  __|   `--. \\  `--. \\|  __| | | | | | || |\r\n"
						 		+ "| |____ \\ \\_/ / | |_\\ \\  _| |_  | |\\  |   /\\__/ / | |_| | | \\__/\\ | \\__/\\ | |___  /\\__/ / /\\__/ /| |___ | |/ /  |_||_|\r\n"
						 		+ "\\_____/  \\___/   \\____/  \\___/  \\_| \\_/   \\____/   \\___/   \\____/  \\____/ \\____/  \\____/  \\____/ \\____/ |___/   (_)(_)\r\n"
						 		+ "                                                                                                                      \r\n"
						 		+ "==================================================================================================================================\r\n"
						 		+ "");
						 
						 FoodMenu.mainMenu(userId);
						 return;
						 
					 } else {
						 System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
						 return;
					 }
				 } else {
					 System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
					 return;
				 }
			 }
			
	 }
	 
	 public void foundId() {
		 	System.out.println("\n == 회원 아이디 찾기 ==");
			System.out.print("이름을 입력하세요. : ");
			String userName = sc.nextLine();
			System.out.print("전화번호를 입력하세요(-빼고 입력).  : ");
			String phone = sc.nextLine();
			mc.foundId(userName, phone);
	 }
	 
	 public void foundPw() {
		 	System.out.println("\n == 회원 비밀번호 찾기 ==");
			System.out.print("아이디를 입력하세요. : ");
			String userId = sc.nextLine();
			System.out.print("전화번호를 입력하세요(반드시 '-'빼고 입력).  : ");
			String phone = sc.nextLine();
			System.out.print("주민번호를 입력하세요(반드시 '-'빼고 입력). : ");
			String ssn = sc.nextLine();
			mc.foundPw(userId, phone, ssn);
	 }
	
	 public void nonMember() {
		 System.out.println("\n***비회원으로 식권 발급 시 고객님의 건강정보(권장섭취량)와 관계없이 메뉴를 선택하실 수 있습니다.***");
		 System.out.println("   또한 비회원 주문 시 추가요금이 2000원 더 발생합니다.");
		 System.out.print("\n비회원으로 식권을 발급하시겠습니까?(Y/N) : ");
		 String choice = sc.nextLine().toUpperCase();
		 while(true) {
			 if(choice.trim().equals("Y")) {
				 FoodMenu.nonMemselectFoods();
				 return;
			 } else if(choice.trim().equals("N")) {
				 return;
			 } else {
				 System.out.println("잘못 입력하셨습니다. Y 또는 N으로만 입력해주세요.");
				 continue;
			 }
		 }
	 }
	 
	 
	 
	 
	 // --------------------------------------- 응답화면 -------------------------------------------
	 /**
	  * 요청 처리 후 성공했을 경우 사용자가 보게될 화면
	  * @param message : 객체 별 성공 메시지
	  */
	 public void displaySuccess(String message) {
		 System.out.println("\n요청 성공 : " +message);
	 }
	 
	 /**
	  * 요청 처리 후 실패했을 경우 사용자가 보게될 화면
	  * @param message : 객체 별 실패 메시지
	  */
	 public void displayFailed(String message) {
		 System.out.println("\n요청 실패 : " +message);
	 }
	 
	 /**
	  * 조회 요청 후 조회 결과가 없을 때 사용자가 보게될 화면
	  * @param message : 객체 별 조회 결과에 대한 메시지
	  */
	 public void displayNoData(String message) {
		 System.out.println("\n결과 없음 : " +message);
	 }


}	

