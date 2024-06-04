package com.newproject.Student;

public class Student {
    private String FirstName;
    private String LastName;


    public Student(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return "Student [FirstName=" + FirstName + ", LastName=" + LastName + "]";
    }

    public Student() {
        super();
    }
    
}
