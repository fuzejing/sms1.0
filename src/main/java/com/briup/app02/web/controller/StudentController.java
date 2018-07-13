package com.briup.app02.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.service.IStudentService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/student")
public class StudentController {
	// 注入studentService的实例
	@Autowired
	private IStudentService studentService;
	
	@PostMapping("saveStudent")
	public String saveStudent(Student student){
		try {
			studentService.save(student);
			return "保存数据成功！";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	
	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("/findAllStudent")
	public MsgResponse findAllStudent(){
		try {
			List<Student> list = studentService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findStudentById")
	public MsgResponse findStudentById(long id){
		try {
			Student student = studentService.findById(id);
			return MsgResponse.success("找到该学生", student);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			studentService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	
	@PostMapping("updateStudent")
	public String updateStudent(Student student){
		try {
			studentService.update(student);
			return "修改成功";
		
		
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

}








