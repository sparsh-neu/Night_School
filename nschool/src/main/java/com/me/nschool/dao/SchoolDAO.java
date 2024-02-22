package com.me.nschool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.me.nschool.exception.SchoolException;
import com.me.nschool.pojo.School;


@Component
public class SchoolDAO extends DAO {

	public void save(School school) throws SchoolException {
        try {
            begin();
            getSession().save(school);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new SchoolException("Could not delete school", e);
        }
    }
    
    public List<School> list() {
		Query<School> query = getSession().createQuery("FROM School");
		List<School> list = query.list();
		return list;
	}
}
