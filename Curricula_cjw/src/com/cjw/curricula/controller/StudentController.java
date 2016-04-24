package com.cjw.curricula.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.Student;
import com.cjw.curricula.entity.StudentCourse;
import com.cjw.curricula.service.AdminService;
import com.cjw.curricula.service.StudentService;
import com.cjw.curricula.service.TeacherService;

@Controller
@RequestMapping("/student/{sid}")
public class StudentController extends BaseController {
	
	@RequestMapping("")
	public String index(){
		return "redirect:/student/{sid}/info";
	}
	
	@RequestMapping("/info")
	public String info(@PathVariable int sid,Model model){
		Student s=studentService.findInfo(sid);
		model.addAttribute("student", s);
		return "student/info";
	}
	
	@RequestMapping("/courses")
	public String courses(@PathVariable int sid,Model model){
		List<StudentCourse> sct=studentService.findStudying(sid);
		model.addAttribute("sct", sct);
		return "student/courses";
	}
	
	@RequestMapping(value="/courses/select",method=RequestMethod.GET)
	public String selectcourse(@PathVariable int sid,Model model){

		model.addAttribute("selectedcourses", studentService.findCourse(sid)); 
		model.addAttribute("unselectedcourses", studentService.findUnslectedCourse(sid)); 
		return "course/select";
	}
	
	@RequestMapping(value="/courses/select",method=RequestMethod.POST)
	public String selectcourse(@PathVariable int sid,
			@RequestParam("cid")int[] cids,@RequestParam("tid")int[] tid,
			Model model){
		for(int i=0;i<cids.length;i++){
			 
			studentService.selectCourse(sid, cids[i],tid[i]);
		}
		return "redirect:/student/"+sid+"/info";
	}
	
	@RequestMapping(value="/courses/delete")
	public String deleteSCT(@PathVariable int sid,@RequestParam("cid")int cid,
			Model model){
		studentService.dropCourse(sid, cid);
		return "redirect:/student/"+sid+"/info";
	}
	
	private StudentService studentService;
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService  = studentService;
	}

	private TeacherService teacherService;
	@Autowired
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService=teacherService;
	}

	private AdminService adminService;
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService=adminService;
	}
}