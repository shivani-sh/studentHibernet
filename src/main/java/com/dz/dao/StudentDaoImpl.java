package com.dz.dao;

import com.dz.model.Student;
import com.dz.service.StudentServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    private final Logger logger = LogManager.getLogger(StudentServiceImpl.class);


    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * IN this we add data in list
     *
     * @param student
     * @return
     * @throws SQLException
     */
    @Override
    public void addStudent(Student student) {
        logger.info(student.getId() + "','" + student.getName() + "','" + student.getAge());
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();

            session.saveOrUpdate(student);

            transaction.commit();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            session.close();
        }
        System.out.println("add data");
        transaction.rollback();


    }

    /**
     * In this we display our list
     *
     * @return
     */
    @Override
    public List<Student> display() {
        try {

            Query query = sessionFactory.getCurrentSession().createQuery("From Student");
            List<Student> studentList = query.list();

            System.out.println("disply data");
            return studentList;

        } catch (HibernateException e) {
            logger.error(e.getMessage(), e);

        }


        return null;
    }


    /**
     * In this we delete data
     *
     * @param student
     * @return
     */
    @Override
    public void deleteData(Student student) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        System.out.println("delete in student dao");
        try {
            transaction.begin();
            session.delete(student);
            transaction.commit();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            session.close();
        }

        logger.info("come to delete");

    }

    /**
     * in this we update data
     *
     * @param student
     * @return
     */

    @Override
    public boolean updateData(Student student) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        logger.info("id from controller" + student.getId());
        logger.info(student.getId() + "','" + student.getName() + "','" + student.getAge());
        try {
            transaction.begin();

            session.saveOrUpdate(student);

            transaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return true;
    }

    /**
     * get student by id
     *
     * @param id
     * @return
     */
    public Student getStudentById(int id) {
        logger.info("here is getStudentById");
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        try {

            criteria.add(Restrictions.eq("id", id));
            Student student = (Student) criteria.uniqueResult();
            logger.info(student.getId() + "','" + student.getName() + "','" + student.getAge());
            return student;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }


        return null;

    }

}
