package chap3;

import java.util.*;

public class Exam128 {

	public static void main(String[] args) {
		// ����4��
		int penNum = 534;
		int stuNum = 30;
		
		int ppsNum = penNum / stuNum;
		int rempNum = penNum % stuNum;
		
		System.out.printf("�л��� ���� �� : %d, ���� ���� �� : %d\n", ppsNum, rempNum);
		
		// ���� 5�� -> ���� Ÿ�Ժ�ȯ
		
		// ���� 6��
		int value = 356;
		System.out.println(value/100*100);
		
		// ���� 7�� -> �ε��Ҽ��� ǥ�� ����� ����. 0.1�� 0.1���� ū ��
		//���� Ÿ�� ��ȯ (float)0.1
		
		// ���� 8��
		//��ٸ����� �ʺ� = (���� + �Ʒ���) * ���� /2
		int lTop = 5;
		int lBottom = 10;
		int height = 7;
		double area = (((lTop)+(lBottom))*height /2.0);
		System.out.println(area); 
		
		//���� 9��
		Scanner sc = new Scanner(System.in); //sc �� ��ü��������
		System.out.print("ù��° �� : ");
		double num1 = sc.nextDouble();
		
		System.out.println("�ι�° �� : ");
		double num2 = sc.nextDouble();
		
		if(num2 == 0 ) { //num2 == 0.0 �� ����
			System.out.print("���:���Ѵ�");
		}else {
			System.out.print("���: " + (num1 / num2));
		}
		
		//���� 10��
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("���� ����:" + var4);
		
		//���� 11�� : �⺻Ÿ�� ������ �� (==), ����Ÿ�� ��(equals()
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���̵�:");
		String name = scanner.nextLine();
		
		System.out.print("�н�����:");
		String strPassword = scanner.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password == 12345) {
				System.out.println("�α��� ����");
			}else {
				System.out.println("�α��� ����:�н����尡 Ʋ��");
			}
		} else {
			System.out.println("�α��� ����:���̵� �������� ����");
		}
		
		//���� 13��
			
		
	}//end main

}//end class
