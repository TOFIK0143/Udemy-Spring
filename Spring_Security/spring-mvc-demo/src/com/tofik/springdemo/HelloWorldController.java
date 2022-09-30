package com.tofik.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show  the initial HTML form
	@RequestMapping("/showForm")
	public String showform() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// need a controller method to read data and
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("StudentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		// convert the message
		String result = "YO! " + theName;

		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// need a controller method to read data and
		// add data to the model
		@RequestMapping("/processFormVersionThree")
		public String processFormVersionThree(@RequestParam("StudentName") String theName, Model model) {
			
			
			// convert the data to all caps
			theName = theName.toUpperCase();
			// convert the message
			String result = "Hey My Friend! " + theName;

			// add message to the model
			model.addAttribute("message", result);
			
			return "helloworld";
		}
		
		@RequestMapping("/showBackPage")
		public String showBackPage() {
			return "main-menu";
		}
		
}
