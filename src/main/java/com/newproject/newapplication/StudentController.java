package com.newproject.newapplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.Student.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {
    public static List<Student> Students = new ArrayList<Student>();


    public StudentController(){
        Students.add(new Student("BINIYAM", "ABEBE"));
        Students.add(new Student("ROEBL", "KASSA"));
        Students.add(new Student("BIRUK", "MESFIN"));
        Students.add(new Student("TARIKU", "DEBEBE"));
    }

    @GetMapping("/students")
    public List<Student> returnstuednts(){
        return Students;
    }


    @PostMapping("/addstudent")
    public String postMethodName(@RequestBody String entity) {
        Students.add(new Student(entity,entity));
        
        return entity;
    }
    


    
}
