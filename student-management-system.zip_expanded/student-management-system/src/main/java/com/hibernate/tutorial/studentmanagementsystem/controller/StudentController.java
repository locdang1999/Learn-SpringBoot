package com.hibernate.tutorial.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hibernate.tutorial.studentmanagementsystem.entity.Student;
import com.hibernate.tutorial.studentmanagementsystem.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	// Handler method to handle list student andreturn model and view
	@GetMapping("/students")
	private String listStudent(Model model) {
		model.addAttribute("student", service.getAllStudent());
		return "student"; // trả về file name html
	}

	@GetMapping("/students/new")
	private String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	private String saveStudent(@ModelAttribute("student") Student student) {
		service.save(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String getStudentById (Model model, @PathVariable Long id) {
		model.addAttribute("student", service.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		//Get student from database by id
		Student studentEdit = service.getStudentById(id);
		studentEdit.setId(id);
		studentEdit.setFirstName(student.getFirstName());
		studentEdit.setLastName(student.getLastName());
		studentEdit.setEmail(student.getEmail());
		//save update student object
		service.updateStudent(studentEdit);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return "redirect:/students";
	}
}
