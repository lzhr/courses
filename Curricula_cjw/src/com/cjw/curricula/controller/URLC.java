package com.cjw.curricula.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;

@Controller
@RequestMapping("/url")
public class URLC {
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@RequestMapping(value = {""})
	@ResponseBody
	public void list(HttpServletResponse response) {
		response.setCharacterEncoding("unicode");
		response.setHeader("Content-type", " charset=UTF-8");
		
		StringBuilder sb = new StringBuilder();
		sb.append("URL地址").append("--").append("Method").append("---").append("Controller--").append("Function功能").append('\n');
		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
		for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
			RequestMappingInfo info = m.getKey();
			HandlerMethod method = m.getValue();
			sb.append(info.getPatternsCondition()).append("--");
			sb.append(info.getMethodsCondition()).append("------");
			sb.append(method.getMethod().getDeclaringClass().getSimpleName()).append("--");
			sb.append(method.getMethod().getName()).append('\n');
		}
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

}

//	    public void pw1(String type,HttpServletResponse response){
//	        StringBuilder sb = new StringBuilder();  
//	        sb.append("URL").append("--").append("Method").append("--\n--")
//	        	.append("--").append("Function").append('\n');  
//		    Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();  
//	        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {  
//	            RequestMappingInfo info = m.getKey();  
//	            HandlerMethod method = m.getValue();
//	            String c=method.getMethod().getDeclaringClass().getName();
//	            String a="com.cjw.curricula.controller.AdminController";
//	            String s="com.cjw.curricula.controller.StudentController";
//	            String t="com.cjw.curricula.controller.TeacherController";
//	            char n = 0;
//	            if(c==a){
//	            	n='a';
//	            	if(c==s){
//	            		n='s';
//	            	}
//	            }else{
//	            	n='t';
//	            } 
//	            switch (n){
//	            	case 'a':append1(sb, info, method, c);break;
//	            	case 's':append1(sb, info, method, c);break;
//	            	case 't':append1(sb, info, method, c);break;
//	            }         
//	        }  
//	        PrintWriter writer = null;  
//	        try {  
//	            writer = response.getWriter();  
//	            writer.print(sb.toString());  
//	        } catch (IOException e) {  
//	            e.printStackTrace();  
//	        } finally {  
//	            writer.close();  
//	        }      	        
//	    }
//
//	    void append1(StringBuilder sb,RequestMappingInfo info,HandlerMethod method,String c){
//	    	 	sb.append(info.getPatternsCondition()).append("--");  
//	            sb.append(info.getMethodsCondition()).append("--\n------");  
//	            sb.append(method.getMethod().getName()).append('\n'); 
//	    }
