package com.dz.dao;

import com.dz.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * this is dao interdace which is implement by studentimpdao
 */
public interface StudentDao {

    void addStudent(Student student) throws SQLException;

    List<Student> display();

    int deleteData(int stu_id);

    boolean updateData(Student student);


}
