package chap5;

public class Array {
	public static void main(String[] args) {
		int a = 10;
		int[] ary = {10, 20, 33, 25, 34}; //�����ϸ鼭 �迭�� ��� ���
		int sum = 0;
//		sum = ary[0] + ary[1] + ary[2]; //�迭�� �����ͼ� �հ� ���ϴ� ��. �������� �ݺ��� ���.
		for(int i=0; i < ary.length; i++) {
			sum = sum + ary[i];
		}
		System.out.println("�հ�� " + sum + "�Դϴ�.");
		
		String[] names = new String[10]; //�ּҰ��� names ��� �������� ��ڴ�
		int[] intAry = new int[5]; //ũ�⸸ ����
		System.out.println(intAry[0]); 
		double[] heights = new double[3];
		System.out.println(heights[0]);
		
		names[0] = "ȫ�浿"; //�����̸�[�ε�����(���°��ġ�ϴ���). 0�� ù��°��ġ]
		names[1] = "��浿"; //1�� �ι�°��ġ
		System.out.println(names[0]);
		System.out.println(names[2]); //null����(class��)
		
	}
}
