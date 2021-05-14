package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show the initial form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	
	// need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read from data and 
	
	// add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from html form
		String theName = request.getParameter("studentName");
		
		//convert that data to all caps
		theName = theName.toUpperCase();
		
		// create the msg
		String result = "Yo! " + theName;
		
		// add msg to the model
		model.addAttribute("message", result);
		
		return "helloworld";
		
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
	
		
		//convert that data to all caps
		theName = theName.toUpperCase();
		
		// create the msg
		String result = "Hey My Friend from v3!  " + theName;
		
		// add msg to the model
		model.addAttribute("message", result);
		
		return "helloworld";
		
	}
	
	

}
