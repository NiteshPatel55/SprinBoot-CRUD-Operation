package com.springcrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrud.model.Student;
import com.springcrud.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	
	
	// save the record using save method
		public Student saveStudent(Student student) {
			
			 studentRepository.save(student);
			return student;
		}
	
	//get all student record by using the method find all
	
	public List<Student> getAllStudents() {
		
		List<Student> list = new ArrayList<Student>();
		studentRepository.findAll().forEach(student1 -> list.add(student1));
		
		return list;
		
	}
	
	// get the specified record  by using getbyid() method
	
	public Student getStudentById(int id) {
		
	return	studentRepository.findById(id).get();
			
	}
	
	
	
	//update student using student id 
	public Student updateStudent(Student student) {
		
		studentRepository.findById(student.getStudentId()).get();
		return student;
	}
	
	
	//delete student using student id
	public void deleteStudent(Integer studentid){
		
		studentRepository.deleteById(studentid);
	}
	
	

}
