package com.me.nschool.dao;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;

import com.me.nschool.exception.SchoolException;
import com.me.nschool.pojo.Student;



@Component
public class StudentDAO extends DAO {

	public StudentDAO() {
    }

    public void save(Student student) throws SchoolException {
        try {
            begin();
            getSession().save(student);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new SchoolException("Could not delete user " + student.getName(), e);
        }
    }
}
