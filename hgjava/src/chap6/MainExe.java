package chap6;

import Todo.p20231128.BoardApp;

public class MainExe {
	public static void main(String[] args) {
		
		BoardApp app = BoardApp.getInstance();
		BoardApp app1 = BoardApp.getInstance();
		//System.out.println(app == app1); true값나옴
		
		app.start();
		

		
	}//end of main

}//end of class
