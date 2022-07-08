package com.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springcrud.model.Student;
import com.springcrud.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	//post mapping for create the Student detail in database
	
	@PostMapping("/insert")
	public Student saveStudent(@RequestBody Student student) {
		
		 return studentService.saveStudent(student);
	
	}

	//creating a get mapping that retrieves the detail of all students from the database
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	//creating a get request that retrieves the specific student detail
	@GetMapping("/student/{studentid}")
	public Student getStudentById(@PathVariable("studentid") Integer studentid ) {
		
		return studentService.getStudentById(studentid);
		
	}
	
	//creating put mapping that updates the Student detail
	@PutMapping("/students/{studentid}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("studentid") Integer studentid  ){
		
		studentService.updateStudent(student);
		return student;
		
		
	}
		
	//creating delete mapping that delete the student detail
	@DeleteMapping("/student/{studentid}")
	public String deleteStudent(@PathVariable("studentid") Integer studentid){
		studentService.deleteStudent(studentid);
		
		return "Deleted successfully";
		
	}
	

}
