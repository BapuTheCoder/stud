package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentService ss;
	
     @PostMapping
	public ResponseEntity addStudent(@RequestBody Student student)
	{
//		try {
		ss.savetudent(student);
		return new ResponseEntity(student,HttpStatus.CREATED);
//		}catch(Exception e)
//		{
//			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
//		}
	}
     
     @GetMapping("/{id}")
     public ResponseEntity getStudent(@PathVariable("id")int id)
     {
//    	 try {
    	 Student s=ss.getStudentinfo(id);
    	 return new ResponseEntity(s,HttpStatus.OK) ;
//    	 }catch(Exception e)
//    	 {
//    		 return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
//    	 }
     }
     
}
