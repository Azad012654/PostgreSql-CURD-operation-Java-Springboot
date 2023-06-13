package com.CURD.CURDProject.CurdOperations.Controllers;

import java.time.LocalDate;
import java.time.Month;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CURD.CURDProject.CurdOperations.Service.StudentService;
import com.CURD.CURDProject.CurdOperations.Student.Student;

@RestController
@RequestMapping("/api/v1/student")
public class Controller {
	@Autowired
	private StudentService studentService;
	
@GetMapping("/get-students")
public List<Student> getStudent(){
 
	return studentService.getStudents();
//	return List.of(new Student(1L, "Azad", "azadchauhan012654@gmail.com", LocalDate.of(1994, Month.AUGUST, 15), 28));
}

@PostMapping("save-student")
public ResponseEntity<?> saveStudents(@RequestBody Student student){
	String response = studentService.saveStudents(student);
	return new ResponseEntity<>(response,HttpStatus.OK);
	
}
@DeleteMapping("{id}")
public ResponseEntity<?> deleteStudent(@PathVariable ("id") String id){
	
	long idreceived = Long.parseLong(id); 
	String response = studentService.deleteStudent(idreceived);
	return new ResponseEntity<>(response,HttpStatus.OK);
}

@PutMapping("update/{id}")
public ResponseEntity<?> updateStudent(@PathVariable ("id") String id, @RequestBody Student student){
	
	long idreceived = Long.parseLong(id); 
	String response = studentService.updateStudent(idreceived,student);
	return new ResponseEntity<>(response,HttpStatus.OK);
}

@GetMapping("get-student/{email}")
public ResponseEntity<?> GetStudent(@PathVariable ("email") String email){
	
	Optional optional = studentService.getSingleUser(email);
	if(optional.isPresent()) {
	Student data = (Student) optional.get();
	return new ResponseEntity<>(data,HttpStatus.OK);
	} else {
		return new ResponseEntity<>("Data Not Found",HttpStatus.OK);
	}
}





	
}
