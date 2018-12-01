package com.dz.service;

import com.dz.dao.StudentDaoImpl;
import com.dz.model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * serviceimp class
 */
@Service

public class StudentServiceImpl implements StudentService {
    private final Logger log = LogManager.getLogger(StudentServiceImpl.class);
    private final StudentDaoImpl studentDao;

    @Autowired
    public StudentServiceImpl(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent(Student student) {

        try {
            studentDao.addStudent(student);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    public List<Student> display() {


        return studentDao.display();
    }

    public int deletedata(int stu_id) {
        studentDao.deleteData(stu_id);


        return stu_id;
    }

    public boolean updatedata(Student student) {

        studentDao.updateData(student);

        return false;
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

}
