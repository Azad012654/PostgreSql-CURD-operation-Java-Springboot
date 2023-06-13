package com.CURD.CURDProject.CurdOperations.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CURD.CURDProject.CurdOperations.Repository.StudentRepository;
import com.CURD.CURDProject.CurdOperations.Student.Student;

@Component
public class StudentService {
	
	@Autowired
	private StudentRepository studentrepo;
	
	@Autowired
	private Student studentdata;
	
	public List<Student>getStudents() {
//		return List.of(new Student(1L,"Azad","azadchauhan012654@gmail.com",LocalDate.of(1994, Month.AUGUST, 15),28));
	return studentrepo.findAll();
	}
	
	public String saveStudents(Student student)throws NullPointerException  {
		System.out.println("Hellllllllllllooooooooooo"+student.getName());
		if(student.getName().isEmpty()) {
			
			return "Name Cannot be Empty";
			
		} else {
		 studentrepo.save(student);
		 return "Data Saved Successfully";
		}
	}
	
	public String deleteStudent(long id) {
		Optional<Student> optional =  studentrepo.findById(id);
		if(optional.isPresent()) {
			studentrepo.deleteById(id);	
			return "Student With ID "+id+" Deleted Successfully";
		} else {
			return " Student with ID "+id+" is Not present in database";
		}
	}
	
	public String updateStudent(long id, Student data) {
		
		Optional<Student> optional =  studentrepo.findById(id);
		if(optional.isPresent()) {
			Student datatosave = optional.get();
		    datatosave.setAge(data.getAge()!=0? data.getAge():datatosave.getAge() );
		    datatosave.setName(data.getName()!=null? data.getName():datatosave.getName() );
		    datatosave.setEmail(data.getEmail()!=null? data.getEmail():datatosave.getEmail() );
		    datatosave.setDob(data.getDob()!=null? data.getDob():datatosave.getDob() );
			
			studentrepo.save(datatosave);
			return "Data Updated Successfully";
		} else {
			return "Data is not present";
		}	
	}
	
	public Optional<Student> getSingleUser(String email) {
	Optional<Student> optional = studentrepo.FindStudentNameByEmail(email);
	return optional;
	}
}
