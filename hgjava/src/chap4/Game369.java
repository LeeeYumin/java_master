package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		// 1 ~ 50 : 369����
		
		int count = 0; // 3, 6, 9 ������ ���� üũ ����
		// ���ڴ� 1~50 (�ݺ���)
		for(int i=1; i <= 50; i++){ 
			count = 0;
			if(i%10 == 3 || i%10 == 6 || i%10 ==9) {  // ���� �ڸ��� 3,6,9 �ִ��� ���� üũ. ||�� OR �ǹ�
			count ++;
			}
			int ten = (int)(i/10);  // ���� �ڸ��� 3,6,9 ���� üũ
			if(ten%10 == 3 || ten%10 == 6 || ten%10 == 9) {
				count ++;
			}
			switch(count) {		
			case 0 : System.out.print(i+"\t"); break; // ������ 0 -> ���� ���
			case 1 : System.out.print("��\t"); break; // ������ 1 -> ��
			case 2 : System.out.print("����\t"); // ������ 2 -> ����
			}
			if(i % 10 ==0) { // �� �ٿ� 10���� ���
				System.out.println();
			}
		}
		// if(i%10 == 3 || i%10 == 6 || 1%10 == 9) count++;
		// if(i/10 == 3 || i/10 == 6 || 1/10 == 9) count++; �̷��Ե� ����.
			
		
		//���� ��ȯ
		Scanner scr = new Scanner(System.in);
		System.out.println("##��ȯ�� �ݾ� : ");
		int money = scr.nextInt();
		int remoney = 0;
		
		System.out.println("500�� ¥�� : " + money/500 + "��");
		remoney = money%500;
		System.out.println("100�� ¥�� : " + remoney/100 + "��");
		remoney %= 100; 
		System.out.println("50�� ¥�� : " + remoney/50 + "��");
		remoney %= 50;
		System.out.println("10�� ¥�� : " + remoney/10 + "��");
		remoney %= 10;
		System.out.println("��ȯ �ݾ� : " +(money-remoney) + "��");
		System.out.println("���� �ݾ� : " + remoney + "��");
		
		
		//������������ : 1���� 100 ���� �� �߻�
		//int com ���ڹ߻� = (int)(Math.random()*100)+1; �ϰ� while(true) { }
		//�ݺ��� �����ϸ� ���� �Է� ����
			//if(my number == com) {�����մϴ� break;} ���� ��� ���� �־��ְ� �ݺ��� Ż��.
			//�ؿ� �Է� ���� > com -> down �ϼ��� �˸�
			//�Է� ���� < com -> up �ϼ��� �˸�	
		Scanner myNum = new Scanner(System.in);
		System.out.println("���� �Է� : ");
		int com = (int)(Math.random()*100)+1;
		
		//11.27����� �ϰ� �ƹ��ų� �ẽ!!
		
 
	} // end main

} // end class
