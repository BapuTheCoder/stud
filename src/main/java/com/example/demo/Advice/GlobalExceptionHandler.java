package com.example.demo.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.StudentException.StudentException;

@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(StudentException.class)
	public ResponseEntity StudentExceptionH(StudentException s,WebRequest w)
	{
		
		return new ResponseEntity(s.getErrorMessage(),s.getErrorCode());
	}
   @ExceptionHandler(Exception.class)
   public ResponseEntity  Exception(Exception e, WebRequest w)
   {
	   return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	   
   }
   
	
}
