package Todo.p20231201;
//쉬어가는...? 느낌으로 만들어보기
//주석 풀어서 적용해보면서 감잡기
public class MainExe {
	public static void main(String[] args) { //배열이2개. 2차원배열
		int[][] numAry = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		//System.out.println(numAry[0].length); //첫번째위치 1~4값 반환. [0][3]
		//for (int i = 0; i < 4; i++) { 
		for (int i = 3; i >= 0; i--) {//하면 역으로 숫자 올라감
			for(int j = 0; j < 4; j++) {
				//System.out.println(numAry[i][j] + " ");
				//System.out.printf("%3d", numAry[j][i]);
				System.out.printf("%3d", numAry[i][j]); //i랑 j랑 바꿔도 배열 바뀜
			}
			System.out.println(); //줄바꿈해줌
		}
		System.out.println("=====end=====");
		
				
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.println(numAry);
//			}
//		}
		
		
		
	} //end of main

} //end of class
