package com.dz.service;

import com.dz.dao.StudentDaoImpl;
import com.dz.model.Student;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * service imp class
 */
@Service

public class StudentServiceImpl implements StudentService {
    private final Logger logger= LogManager.getLogger(StudentServiceImpl.class);
    private StudentDaoImpl studentDao;

    @Autowired
    public StudentServiceImpl(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent(Student student) {

        try {
            studentDao.addStudent(student);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    public List<Student> display() {


        return studentDao.display();
    }

    public void deletedata(Student student) {
        studentDao.deleteData(student);



    }

    public boolean updatedata(Student student) {

        studentDao.updateData(student);

        return false;
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }


}
