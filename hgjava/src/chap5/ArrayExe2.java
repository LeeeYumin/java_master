package chap5;

public class ArrayExe2 {

	public static void main(String[] args) {
		// ������ ���� �� �ִ� �迭�� ����(ũ��� 10���� ������ ����).
		// ���� �̸��� intAry 10, 20, ... ,100 ����.
		// ���
		int[] intAry = new int[10]; //{10, 20 ,30, 40, 50, 60, 70, 80, 90, 100} ��� ��... �̰͵� �Ǳ� ��.
		for(int i=0; i<intAry.length; i++) {
			intAry[i] = (i + 1) * 10; //i*10+10
		}
		//���. Ȯ��for����. �迭�� ũ�� ��ŭ�� ��ȯ�ϰڴ�? 
		int sum = 0; // 50���� ū ���� ����
		double avg = 0;
		int count = 0;
		for (int num : intAry) {
			System.out.println(num);
			if(num > 50) { //50���� ū ���� ������. sum�� 60���� �����ؼ� 70 ���ϸ� 130. 130���� 80���ϸ� 210... �̷���.
				sum = sum + num;
				count++;
			}
		}
//		for (int num : intAry) {
//			System.out.println(avg);
//			if(avg = intAry.length) {
//				count = intAry.length;
//			}
//		} ���� �����Ѱ� ���� �߸���...
		avg = sum / count;
		System.out.println("50���� ū ���� �հ�: " + sum);
		System.out.println("50���� ū ���� ���: " + (sum/count));
	} //

} //
