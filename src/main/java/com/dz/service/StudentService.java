package com.dz.service;

import com.dz.model.Student;

import java.util.List;

/**
 * student service interface
 */
public interface StudentService {

    void addStudent(Student student);

    List<Student> display();

   void deletedata(Student student);

    boolean updatedata(Student student);

    Student getStudentById(int id);
}
