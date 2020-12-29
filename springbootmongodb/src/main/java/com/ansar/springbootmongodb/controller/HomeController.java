package com.ansar.springbootmongodb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ansar.springbootmongodb.model.Student;
import com.ansar.springbootmongodb.repository.StudentRepository;

@RestController
public class HomeController {

	@Autowired
	private StudentRepository studRepo;

	@PostMapping("/saveStudent")
	public ResponseEntity<?> saveStudent(@RequestBody Student stud){

		try {
			stud.setCreated(new Date(System.currentTimeMillis()));
			studRepo.save(stud);
			return new ResponseEntity<>(stud,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}			
	}
	@GetMapping("/getStudentList")
	public ResponseEntity<?> getAllStudentList(){

		try {
			List<Student> findAll = studRepo.findAll();
			if(findAll.size()>0) {
				return new ResponseEntity<>(findAll,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new ArrayList<Student>(),HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@GetMapping("/findStudent/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable String id){

		Optional<Student> findById = studRepo.findById(id);
		if(findById.isPresent()) {
			Student student = findById.get();
			return new ResponseEntity<>(student,HttpStatus.OK);

		}else {
			return new ResponseEntity<>("Record not found with ID- "+id,HttpStatus.NOT_FOUND);
		}

	}
	@PutMapping("/updateStudent")
	public ResponseEntity<?> updateStudent(@RequestBody Student student){
		Optional<Student> findById=null;
		try {
			findById= studRepo.findById(student.getId());
			Student student2 = findById.get();
			student2.setName(student.getName()==null ? student2.getName():student.getName());
			student2.setCity(student.getCity()==null? student2.getCity():student.getCity());
			student2.setState(student.getState()==null? student2.getState():student.getState());
			student2.setGeder(student.getGeder()==null?student2.getGeder():student.getGeder());
			student2.setCollegeName(student.getCollegeName()==null?student2.getCollegeName():student.getCollegeName());
			student2.setUpdated(new Date(System.currentTimeMillis()));
			studRepo.save(student2);


			return new ResponseEntity<>(student2,HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteStudet/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable String id){
		
		studRepo.deleteById(id);
		return new ResponseEntity<>("Resord successfully deleted with the ID: " +id, HttpStatus.OK);
		
		
	}

}
