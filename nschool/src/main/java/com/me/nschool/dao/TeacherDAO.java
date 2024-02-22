package com.me.nschool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.me.nschool.exception.SchoolException;
import com.me.nschool.pojo.Teacher;


@Component
public class TeacherDAO extends DAO {

	public TeacherDAO() {
		System.out.println("*** Teacher DAO");
		//default constructor
	}
	
	public List<Teacher> list() {
		Query<Teacher> query = getSession().createQuery("FROM Teacher");
		List<Teacher> list = query.list();
		return list;
	}

    public void save(Teacher teacher) throws SchoolException {
        try {
            begin();
            getSession().save(teacher);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new SchoolException("Could not delete teacher", e);
        }
    }
}
