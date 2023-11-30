package chap7;

public class FriendExe {
	Friend[] storage = new Friend[10];
	
	//1:등록 2:목록 3:조회
	
	public boolean addFriend(Friend friend) { //매개변수. 등록
		for(int i = 0; i < storage.length; i++) {
			if(storage[i] == null) {
				storage[i] = friend;
				return true;
			}
		}
		return false;
	} //
	
	public Friend[] friendList() { //조회 (매칭되면)
		for(int i = 0; i < storage.length; i++) {
			if(storage[i] != null) {
				System.out.println(storage[i].showInfo());
			}
		}
		return storage;
	}
	
	//결과값이 null여부로 체크X
	public Friend[] searchFriend(String name) { //이름으로 찾기
		Friend[] result = new Friend[10]; //새로운 배열로 반환해줘야됨 (반환유형은 정해져있음) 
		for(Friend fnd : storage) {
			if(fnd.getName().equals(name)); {
				System.out.println(result);
			}
		}
		return null;
	}
	
	public Friend searchPhone(String phone) { //번호로 찾기. 결과값이 null 여부로 체크함
		for(Friend fnd : storage) {
			if(fnd != null && fnd.getPhone().equals(phone)); {
				System.out.println(fnd.showInfo());
			}
		}
		return null; 
	}
	
} //end of class
