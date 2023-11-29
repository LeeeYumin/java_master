package chap6;

public class MainExe {
	public static void main(String[] args) {

		String[] strs = { "1aa", "2ss", "3dd", "4ff", "5gg", "6hh", "7jj" };
		int page = 1;
		int start = (page - 1) * 5;
		int end = page * 5;

		for (int i = 0; i < strs.length; i++) {
			if (i >= start && i < end) {
				System.out.println(strs[i]);
			}
		}

		int cnt = 36;

		int totalPage = (int) Math.ceil(cnt / 5.0); // 올림
		System.out.println(totalPage); // 토탈페이지계산

		for (int i = 1; i <= totalPage; i++) {
			System.out.println(i + " ");
		} // 페이지 건수 기준으로 보여주는 부분

	}//

}//
