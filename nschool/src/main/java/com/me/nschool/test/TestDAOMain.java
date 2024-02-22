package com.me.nschool.test;

import java.util.List;

import com.me.nschool.dao.TeacherDAO;
import com.me.nschool.pojo.Teacher;

public class TestDAOMain {
	public static void main(String[] args) {
		TeacherDAO tdao = new TeacherDAO();
		List<Teacher> list = tdao.list();
		
		for (var teac : list)
			System.out.println(teac.getName());
		
		System.out.println("DONE");
	}

}
