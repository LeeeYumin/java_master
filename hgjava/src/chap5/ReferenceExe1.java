package chap5;

//�������� ������ ������ ����.
class Friend {
	String name; //�ʵ�
	int age; //�ʵ�
	double height; //�ʵ�
}

public class ReferenceExe1 {
	public static void main(String[] args) {
		
		//�������� : �������� ��°��� �ƴ�. ���� ���� �ּҸ� ��� ����.
		Friend myFriend = new Friend(); //new ��� Ű����� ��ü ����.
		myFriend.name = "��ö��";
		myFriend.age = 20;
		myFriend.height = 178.3; //�� ��ġ�� ���� ���� �� ����
		
//		Friend ourFriend = myFriend;
//		
//		myFriend.name = "ȫ�浿";
//		
//		System.out.println(ourFriend.name);
//		System.out.println(ourFriend.age);
//		System.out.println(ourFriend.height); //������ �ϴٺ��� ���� �ٲ�� ��ó�� ������...?
		
		Friend yourFriend = new Friend(); //new ��� Ű����� ��ü ����.
		yourFriend.name = "��ö��";
		yourFriend.age = 20;
		yourFriend.height = 178.3; 
		
		System.out.println(myFriend == yourFriend); //�ּҰ��� ���ϱ⶧���� ����� �׻� false. �Ӽ����� ���ؾ� ��...
		
		yourFriend = null;
		System.out.println(myFriend.name);
		try {
		System.out.println(yourFriend.name);
		} catch(Exception e) { //try catch ����ó�� (���߿����)
			System.out.println("null���� �����մϴ�.");
		}
		
	//�⺻ Ÿ��. 
	int a = 10;
//	int b =a;
	
	a = 20;
	
	//����Ÿ�� : �� ���� ��� �ִ� �ּҰ��� ����(�ּҰ��� ������ ����)
	String name = "�ſ��"; //name �� ����. �ſ���� ��ü. // new String("�ſ��") // �ſ���� ������ �ִ� ��ü�� ���� 23dbdae34334
//	String hobby = "����";
	
	String name1 = "�ſ��"; //new String("�ſ��");
	System.out.println("name: " + name);
	System.out.println("name1: " + name1);
	
	
	System.out.println(name == name1); //�񱳿����� equals()�޼ҵ� Ȱ��. ex. name.equals(name1)
	
	
	
	} //
} //
