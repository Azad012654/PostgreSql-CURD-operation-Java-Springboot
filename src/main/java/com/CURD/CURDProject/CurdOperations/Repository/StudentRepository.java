package com.CURD.CURDProject.CurdOperations.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CURD.CURDProject.CurdOperations.Student.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	
	@Transactional
	@Query("Select s from Student s where s.email=:email")
    Optional<Student> FindStudentNameByEmail(String email);
	
}
