package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
@Service
public interface StudentService {
	
	public void savetudent(Student student);
	public Student getStudentinfo(int id);
	

}
