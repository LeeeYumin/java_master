package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		// ���� 2 : 3�� ����� ��
		//1. ���� ������ ����
		int sum = 0 ;
		//1���� 100���� �� �߻� �ݺ���
		for(int i=1; i<=100; i++) {
			if(i % 3 == 0){          //3�� ������� ���ǹ�
				sum += i;
			}
		}
		System.out.println("3�� ����� : " + sum);  //������ �� ���
		
		//���� 3 : �ֻ��� ���� �� 5
		while(true) {
			int dice1 = (int)(Math.random()*6) +1;
			int dice2 = (int)(Math.random()*6) +1;
			System.out.printf("(%d,%d)\n", dice1, dice2);
			if(dice1 + dice2 == 5) {
				break;
			}
		}
		System.out.println("����");
		
		//����4 : ������. x�� y�� 1~10 �ݺ��ϰ� 4*x + 5*y = 60�� �� ã��
		
		for(int x=1; x<=10; x++) {
				for(int y=1; y<=10; y++) {
					int r = 4*x + 5*y;
					if(r==60) {
						System.out.printf("(%d,%d)\n", x, y);					
					}
				}
		}
		
		//����5 : �� ���
		for(int i=0; i<5; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.println("*");
			}
			System.out.println("");
		}
		
		
		//����6 : �� ���
		
		

		//����7 : ���� �ܰ� Ȯ�� + ���� �߰�
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		int money = 0;
		
		while(run) {
			System.out.println("-----------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("-----------------------");
			System.out.print("���� > ");
			int sNum = sc.nextInt();
			
			switch(sNum) {
			case 1 :
				System.out.print("���ݾ� > ");
				money = sc.nextInt();
				balance += money;
				break;
			case 2 :
				System.out.print("��ݾ� > ");
				money = sc.nextInt();
				if(money > balance) {
					System.out.println("�ܰ����");
				}else {
					balance -= money;					
				}
				break;
			case 3 :
				System.out.println("�ܰ� > " + balance);
				break;
			case 4 :
				System.out.println("���α׷� ����");
				run = false;
			}
		}	
		
		
	}//end main

}//end class
