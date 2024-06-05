package com.newproject.newapplication.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.newproject.newapplication.Model.Student;

@RestController
public class StudentController {

    public static List<Student> Students = new ArrayList<>();

    public StudentController() {
        Students.add(new Student("BINIYAM", "ABEBE"));
        Students.add(new Student("ROEBL", "KASSA"));
        Students.add(new Student("BIRUK", "MESFIN"));
        Students.add(new Student("TARIKU", "DEBEBE"));
    }

    
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return Students;
    }

    
    @GetMapping("/students/{firstName}")
    public ResponseEntity<Student> getStudentByFirstName(@PathVariable String firstName) {
        Optional<Student> student = Students.stream().filter(s -> s.getFirstName().equalsIgnoreCase(firstName)).findFirst();
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST method to create a new student
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Students.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // PUT method to update an existing student by first name
    @PutMapping("/students/{firstName}")
    public ResponseEntity<Student> updateStudent(@PathVariable String firstName, @RequestBody Student studentDetails) {
        Optional<Student> studentOptional = Students.stream().filter(s -> s.getFirstName().equalsIgnoreCase(firstName)).findFirst();
        
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to remove a student by first name
    @DeleteMapping("/students/{firstName}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String firstName) {
        Optional<Student> studentOptional = Students.stream().filter(s -> s.getFirstName().equalsIgnoreCase(firstName)).findFirst();
        
        if (studentOptional.isPresent()) {
            Students.remove(studentOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
