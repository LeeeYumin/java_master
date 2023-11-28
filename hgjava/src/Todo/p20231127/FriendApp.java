package Todo.p20231127;

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {
		// ����!!!! ģ���� ������ �Է��ϴ� app 
		// ģ���� ������ 1. ģ���� 2. �Է� 3. ��� 4. ���� 5. ����(FriendApp) Public class FriendApp\
		//�����ؾߵ�,,, ����������...
	
		Scanner scn = new Scanner(System.in);
		int friendNum = 0;
		int[] scores = null;
		String[] names = null;
		
		boolean run = true;
		while(run) {
			System.out.println("1.ģ���� 2.�Է� 3.��� 4.���� 5. ����");
			int menu = scn.nextInt(); 
			scn.nextLine();
			
			switch(menu) { 
			case 1 : 
				System.out.println("ģ����>");
				friendNum = scn.nextInt();
				scores = new int[friendNum];
				names = new String[friendNum];
				break;
			case 2 : 
				System.out.println("�Է�>>"); 
				for (int i=0; i < scores.length; i++) {
					System.out.println("names[" + i + "]>> ");
					names[i] = scn.nextLine();
					System.out.println("scores[" + i + "]>> ");
					scores[i] = scn.nextInt();
					scn.nextLine();
				}
				break;
			case 3 : 
				System.out.println("���>>");
				for (int i=0; i < scores.length; i++) {
					System.out.println("�̸��� " + names[i] + ", ������ " + scores[i] + "\n");
				}
				break;
			case 4 : 
				System.out.println("����>>");
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
				System.out.println(maxName + "�� " + ", ���� " + maxScore + ", ��� : " + avg);
				break;
			case 5 : 
				System.out.println("����>>");
				run = false;
				break;
			} //end of switch.
		} //end of while.
		System.out.println("end of prog.");	
		
	}//

}//
