package com.examples.school.controller;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.examples.school.model.Student;
import com.examples.school.repository.StudentRepository;
import com.examples.school.repository.mongo.StudentMongoRepository;
import com.examples.school.view.StudentView;
import com.mongodb.MongoClient;

public class SchoolControllerIT {
	
private static final String SCHOOL_DB_NAME = "school";
private static final String STUDENT_COLLECTION_NAME = "student";

 @Mock
 private StudentView studentView;

 private StudentRepository studentRepository;

 private SchoolController schoolController;

 @Before
 public void setUp() {
 MockitoAnnotations.initMocks(this);
 studentRepository = new StudentMongoRepository(new MongoClient("localhost"), SCHOOL_DB_NAME, STUDENT_COLLECTION_NAME);
 // explicit empty the database through the repository
 for (Student student : studentRepository.findAll()) {
 studentRepository.delete(student.getId());
 }
 schoolController = new SchoolController(studentView, studentRepository);
}
 
 @Test
 public void testAllStudents() {
 Student student = new Student("1", "test");
 studentRepository.save(student);
 schoolController.allStudents();
 verify(studentView)
 .showAllStudents(asList(student));
 }

 @Test
 public void testNewStudent() {
 Student student = new Student("1", "test");
 schoolController.newStudent(student);
 verify(studentView).studentAdded(student);
 }

 @Test
 public void testDeleteStudent() {
 Student studentToDelete = new Student("1", "test");
 studentRepository.save(studentToDelete);
 schoolController.deleteStudent(studentToDelete);
 verify(studentView).studentRemoved(studentToDelete);
 }
 
}