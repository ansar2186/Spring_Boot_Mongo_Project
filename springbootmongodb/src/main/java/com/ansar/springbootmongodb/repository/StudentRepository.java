package com.ansar.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.ansar.springbootmongodb.model.Student;


@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

}
