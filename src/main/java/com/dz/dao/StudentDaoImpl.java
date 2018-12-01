package com.dz.dao;

import com.dz.model.Student;
import com.dz.service.StudentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    private final Logger log = LogManager.getLogger(StudentServiceImpl.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * IN this we add data in list
     *
     * @param student
     * @return
     * @throws SQLException
     */
    @Override
    public void addStudent(Student student) throws SQLException {
        String query = "insert into STUDENT_DATA values ( '" + student.getId() + "','" + student.getName() + "','" + student.getAge() + "')";

        jdbcTemplate.update(query);

    }

    /**
     * In this we display our list
     *
     * @return
     */
    @Override
    public List<Student> display() {
        return jdbcTemplate.query("select * from STUDENT_DATA", new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                List<Student> studentList = new ArrayList<>();

                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setAge(rs.getInt(3));
                    studentList.add(student);

                }
                return studentList;

            }
        });
    }

    /**
     * In this we delete data
     *
     * @param stu_id
     * @return
     */
    @Override
    public int deleteData(int stu_id) {
        String query = ("DELETE FROM STUDENT_DATA where id=" + stu_id + ";");
        return jdbcTemplate.update(query);
    }

    /**
     * in this we update data
     *
     * @param student
     * @return
    /* *//*
    @Override
    public boolean updateData(Student student) {

        String query = ("update STUDENT_DATA  set name=? ,age=? where id =?");
        jdbcTemplate.update(query);
        log.info("update");
        return true;
    }*/
@Override
    public boolean updateData(Student student) {
        log.info("id from controller" + student.getId());
        String sql = "update STUDENT_DATA set name='" + student.getName() + "',age=" + student.getAge() + " where ID=" + student.getId() + "";
        log.info("message" + sql);
        jdbcTemplate.update(sql);
        return true;
    }
    public Student getStudentById(int id) {
        log.info("here is getStudentById");
        return jdbcTemplate.queryForObject("SELECT * from STUDENT_DATA  WHERE id=? ", new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
    }

}
