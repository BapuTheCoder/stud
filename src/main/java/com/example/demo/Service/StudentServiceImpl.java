package com.example.demo.Service;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.StudentException.StudentException;
import com.example.demo.StudentRepo.StudentRepo;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired 
	StudentRepo sr;

	@Override
	public void savetudent(Student student) {
	try {	
		validation(student);
		sr.save(student);
	}catch(Exception e)
	{
		throw new StudentException("failed to save this record "+"  "+e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	}

	private void validation(Student student) {
		// TODO Auto-generated method stub
		
		if(!student.getEmail().contains("@"))
		{
		 throw new RuntimeException("2 please enter valid email address");	
		}
		if(student.getAge()<15)
		{
			throw new RuntimeException("2 candidate age is below 15 so not eligible to join");
		}
	}

	@Override
	public Student getStudentinfo(int id) {
		
	Optional<Student> o =	sr.findById(id);
	if(o.isEmpty())
	{
		throw new StudentException("not found(from StudentException custom exception)", HttpStatus.BAD_REQUEST);
	}
		return o.get();
		
		
		
	}
	
	

}
