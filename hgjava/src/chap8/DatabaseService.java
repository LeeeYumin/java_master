package chap8;

// 추상클래스처럼 추상메소드
// Oracle : insert(), update() / MySQL : add(), modify()
//add->insert, modify->update로 바꿔주는 과정에서 번거로움
//규칙만 제시
public interface DatabaseService {
	public static final String name = ""; //상수만 사용 가능.
	
	//입력, 수정, 삭제 기능
	public void add();
	public void modify();
	public void remove();

}
