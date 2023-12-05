package chap13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
	private String todo;
	private Date dueDate;
	
	//생성자
	Todo(String todo){ //오늘날짜를 두번째 매개값으로
		this.todo = todo;
		this.dueDate = new Date() ; //호출 시점의 년,월,일,시:분:초
	}
	Todo(String todo, Date dueDate){
		this.todo = todo;
		this.dueDate = dueDate;
	}
	
	
	
	 
	//toString
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return todo + " " + sdf.format(dueDate);

	}
	
} //end of class
