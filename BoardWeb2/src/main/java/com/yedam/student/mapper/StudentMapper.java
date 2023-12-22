package com.yedam.student.mapper;

import java.util.List;

import com.yedam.student.vo.Student;

public interface StudentMapper {
	//CRUD
	List<Student> studentList();
	int addStudent(Student std); //addStudent 이게 메소드.. ID값. #{stuNo} 처럼 필드이름
	int remStudent(String sno); //서블릿 만들어야 할수있음... 21일 안한거임. #{sno} 로.
}
