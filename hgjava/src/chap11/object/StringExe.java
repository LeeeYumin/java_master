package chap11.object;

public class StringExe {
	public static void main(String[] args) {

		String[] fileNames = { "c:/images/prod/sample.jpg", "d:/test/sample/americano.jpg",
				"d:goods/test/2023/moka.jpg" };
		for (String file : fileNames) {
			System.out.println(findFileName(file));
		}

		String[] numbers = { "980309-1234567", "980304-2234567", "020101-3456789", "020104-4456789", "0301053545678" };
		for (String no : numbers) {
			System.out.println(findGender(no));
		}

		byte[] b1 = "Hello".getBytes(); // byte 배열로 문자열에 해당하는 하나하나의 값을 가져옴
		for (byte b : b1) {
			System.out.println(b);
		}

		String name = new String(new byte[] { 65, 66, 67, 68, 69 }); // 아스키값을 문자열로?
		name = new String(b1); // 배열값을 문자값으로 바꿔준다
		System.out.println(name);

		char c1 = name.charAt(0); // c1이란 변수에 담아서 charAt : n번째 위치의 값을 들고오겠다
		System.out.println(c1);
	}// end of main

	// 성별을 반환
	static String findGender(String ssn) {
		// 생년월일-1, 2, 3, 4 으로 return 남 또는 여로.
		char a = ssn.charAt(7);
		String b = "";
		if (ssn.indexOf("-") == -1) { // 5번째 주민번호는 -가 없음. 찾는 문자에 -가 없어서 = -1로 조건을 걸어줌. indexOf는 찾는 문자가 없으면 -1을 줌.
			a = ssn.charAt(6); // 인덱스 6번째 값으로 가져오겠다
		}
		switch (a) {
		case '1':
		case '3':
			b = "남";
			break;
		case '2':
		case '4':
			b = "여";
			break;
		}
		return b;
	} // end of findGender

	// 교수님풀이
//	static String findGender(String ssn) {
//		int pos = ssn.length() -7;
//		switch (ssn.charAt(pos)) {
//		case '1': 
//		case '3':
//			return "남";
//			break;
//		case '2': 
//		case '4':
//			return "여";
//		}
//		return "오류";
//	} //end of findGender

	// 파일명을 가지고 오는 메소드. 안된다!^^
//	static String findFileName(String file) {
		// 파일명.확장자명 으로 가져오게 해보기
//		int name = file.lastIndexOf(4);
//		String extension = file.substring(name + 1);
//		return extension;
//	} // end of findFileName

	// 파일명을 가지고 오는 메소드 교수님 풀이.
	static String findFileName(String file) {
		int pos = 0;
		while (true) {
			int pos2 = file.indexOf("/", pos);
			if (pos2 == -1) {
				break;
			}
			pos2++;
			pos = pos2;
		}
		return file.substring(pos);
	} // end of findFileName

}// end of class
