package com.cjw.curricula.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjw.curricula.entity.*;
import com.cjw.curricula.service.*;

@Controller
@RequestMapping("/admin/{aid}")
public class AdminController extends BaseController{
	
	@RequestMapping("")
	public String index(@PathVariable int aid,Model model){
		model.addAttribute(aid);
		return "/admin/admin";
	}
	
	@RequestMapping(value={"/course"})
	public String courselist(Model model){
		List<Course> courses=adminService.findCourses();
		model.addAttribute("courses", courses);
		return "admin/course/list";
	}
	
	@RequestMapping(value={"/course/add","/addcourse"},method=RequestMethod.GET)
	public String addCourse(){
		return "admin/course/add";
	}
	
	@RequestMapping(value={"/course/add","/addcourse"},method=RequestMethod.POST)
	public String addCourse(@PathVariable int aid,@RequestParam("cname")String cname,
			@RequestParam("c_time")String c_time,@RequestParam("tid")int tid,
			Model model){
		adminService.addCourse(cname,c_time,tid);
		return "redirect:/admin/"+aid+"/course";
	}
	
	@RequestMapping(value={"/course/{cid}","/c{cid}"},method=RequestMethod.GET)
	public String editCourse(@PathVariable("cid")int cid,Model model){		
		Course course=adminService.findOne(cid);
		model.addAttribute("course",course);
//		List<CourseTeacher> ct=course.getCt();
//		for(CourseTeacher t:ct){
//			System.out.println(t.getTeacher().getTname());
//		}
		return "admin/course/edit";
	}
	
	@RequestMapping(value={"/course/{cid}","/c{cid}"},method=RequestMethod.POST)
	public String doeditCourse(@PathVariable("cid")int cid,@RequestParam("cname")String cname,
			@RequestParam("c_time")String c_time,@RequestParam("credit")Integer credit,
			@RequestParam("tid")int[] tid,@RequestParam("c_details")String c_details,
			Model model){		
		Course course=new Course(cid,cname,credit,c_time,c_details);
		adminService.editCourse(course,tid);

		return "redirect:/admin/{aid}/course/{cid}";
	}
	
	@RequestMapping("/student")
	public String studentList(Model model){
		List<Student> s=adminService.studentList();
		model.addAttribute("students",s);
		return "admin/student/studentlist";
	}
	
	@RequestMapping(value={"/student/add","addstudent"},method=RequestMethod.GET)
	public String addstudent(){
		return "admin/student/add";
	}
	
	@RequestMapping(value={"/student/add","addstudent"},method=RequestMethod.POST)
	public String addStudent(@PathVariable("aid") int aid,@RequestParam("sname") String sname,
			Model model){
		Student s=new Student();
		s.setSname(sname);
		adminService.addStudent(s);;	 
		return "redirect:/admin/"+aid+"/student";
	}
	
	@RequestMapping(value="/student/edit/{sid}",method=RequestMethod.GET)
	public String editStudent(@PathVariable int sid,Model model){
		
		model.addAttribute("student", studentService.findInfo(sid));
		return "admin/student/edit";
	}
	
	@RequestMapping(value="/student/edit/{sid}",method=RequestMethod.POST)
	public String editstudent(@PathVariable("aid") int aid,
			@PathVariable("sid") int sid,
			@RequestParam("sname") String sname,
			Model model){
		adminService.updateStudentName(sid,sname);;	 
		return "redirect:/admin/"+aid+"/student";
	}
	
	@RequestMapping("/student/delete")
	public String deletestudent(@PathVariable("aid") int aid,@PathParam("sid")int sid,Model model){
		adminService.deleteStudentById(sid);
		return "redirect:/admin/"+aid+"/student";
	}
	
	@RequestMapping("/teacher")
	public String teachers(Model model){
		List<Teacher> ts=adminService.findTeachers();
		model.addAttribute("teachers",ts);
		return "admin/teacher/list";
	}
	
	@RequestMapping("teacher/delete")
	public String deleteTeacher(@PathVariable("aid") int aid){
		Teacher teacher=teacherService.findById(3004);
		adminService.deleteTeacher(teacher);
		return "redirect:/admin/teacher";
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
