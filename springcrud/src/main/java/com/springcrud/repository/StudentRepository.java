package com.springcrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.springcrud.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
