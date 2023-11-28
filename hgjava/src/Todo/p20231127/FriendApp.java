package Todo.p20231127;

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {
		// 과제!!!! 친구의 정보를 입력하는 app 
		// 친구의 정보를 1. 친구수 2. 입력 3. 목록 4. 수정 5. 종료(FriendApp) Public class FriendApp\
		//수정해야됨,,, 과제안했음...
	
		Scanner scn = new Scanner(System.in);
		int friendNum = 0;
		int[] scores = null;
		String[] names = null;
		
		boolean run = true;
		while(run) {
			System.out.println("1.친구수 2.입력 3.목록 4.수정 5. 종료");
			int menu = scn.nextInt(); 
			scn.nextLine();
			
			switch(menu) { 
			case 1 : 
				System.out.println("친구수>");
				friendNum = scn.nextInt();
				scores = new int[friendNum];
				names = new String[friendNum];
				break;
			case 2 : 
				System.out.println("입력>>"); 
				for (int i=0; i < scores.length; i++) {
					System.out.println("names[" + i + "]>> ");
					names[i] = scn.nextLine();
					System.out.println("scores[" + i + "]>> ");
					scores[i] = scn.nextInt();
					scn.nextLine();
				}
				break;
			case 3 : 
				System.out.println("목록>>");
				for (int i=0; i < scores.length; i++) {
					System.out.println("이름은 " + names[i] + ", 점수는 " + scores[i] + "\n");
				}
				break;
			case 4 : 
				System.out.println("수정>>");
				int maxScore = 0;
				String maxName = "";
				double avg = 0;
				int sum = 0;
				
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if (maxScore < scores[i]) {
						maxScore = scores[i];
						maxName = names[i];
					}
				}
				avg = sum * 1.0 / scores.length;
				System.out.println(maxName + "의 " + ", 점수 " + maxScore + ", 평균 : " + avg);
				break;
			case 5 : 
				System.out.println("종료>>");
				run = false;
				break;
			} //end of switch.
		} //end of while.
		System.out.println("end of prog.");	
		
	}//

}//
