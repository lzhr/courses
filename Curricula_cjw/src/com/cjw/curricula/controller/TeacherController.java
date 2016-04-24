package com.cjw.curricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjw.curricula.entity.Course;
import com.cjw.curricula.service.AdminService;
import com.cjw.curricula.service.StudentService;
import com.cjw.curricula.service.TeacherService;

@Controller
@RequestMapping("/teacher/{tid}")
public class TeacherController extends BaseController  {
	
	@RequestMapping("")
	public String index(){
		return "redirect:/teacher/{tid}/course";
	}
	
	@RequestMapping("/course")
	public String teach(@PathVariable int tid,Model model){
		List<Course> courses=teacherService.findCourses(tid);
		model.addAttribute("courses",courses);
		return "teacher/course";
	}

	@RequestMapping(value={"/course/c{cid}","/c{cid}"})
	public String editCourse(@PathVariable("tid") int tid,@PathVariable("cid") int cid,
			Model model){
		Course course=teacherService.findCourseById(cid);
		model.addAttribute("course",course);
		return "teacher/course-edit";
	}
	
	@RequestMapping(value={"/course/c{cid}","/c{cid}"},method=RequestMethod.POST)
	public String doeditCourse(@PathVariable("tid") int tid,@PathVariable("cid") int cid,
			@RequestParam("c_time")String c_time,@RequestParam("credit")Integer credit,
			@RequestParam("c_details")String c_details,@RequestParam("cname")String cname,
			Model model){
		Course course=new Course(cid,cname,credit,c_time,c_details);
		teacherService.editCourse(course);
		return "redirect:/teacher/{tid}/course";
	}
	
	protected StudentService studentService;
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService  = studentService;
	}

	protected TeacherService teacherService;
	@Autowired
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService=teacherService;
	}
	
	protected AdminService adminService;
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService=adminService;
	}
}
