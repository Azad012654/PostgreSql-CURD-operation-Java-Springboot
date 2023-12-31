package com.CURD.CURDProject.CurdOperations.Student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Student {
	
	@javax.persistence.Id
	@SequenceGenerator(name="student_sequence",
		sequenceName="student_sequence",
		allocationSize = 1
			)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="student_sequence")
	private long Id;
	private String name;
	private String email;
	private LocalDate dob;
	private int age;
	
	public Student() {
		
	}
	public Student(long id, String name, String email, LocalDate dob, int age) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
	}
	
}
