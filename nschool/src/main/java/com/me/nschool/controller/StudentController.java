package com.me.nschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.me.nschool.dao.StudentDAO;
import com.me.nschool.exception.SchoolException;
import com.me.nschool.pojo.Student;

@Controller
public class StudentController {

	@GetMapping("/addstudent.htm")
	public String addStudentGet(ModelMap model, Student student) {
		// command object
		model.addAttribute("student", student);

		// return form view
		return "addStudentForm";
	}

	@PostMapping("/addstudent.htm")
	public String addStudentPost(@ModelAttribute("student") Student student, BindingResult result, SessionStatus status, StudentDAO studentdao) {
		try {
			studentdao.save(student);
		} catch (SchoolException e) {
			System.out.println("Student cannot be Added: " + e.getMessage());
		}
		
		status.setComplete(); //mark it complete
		return "addedStudent";
	}
}
