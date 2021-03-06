package com.footballWorld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.footballWorld.controller.exceptions.DataBaseException;
import com.footballWorld.controller.exceptions.IllegalInputException;
import com.footballWorld.controller.service.SignUpService;
import com.footballWorld.pojo.User;

@Controller
public class SignUpController {
 
	@Autowired
	private SignUpService signUpService;
	
	@RequestMapping(value = { "/register"}, method = RequestMethod.GET)
	public String register(Model model, HttpServletRequest req)  {
		       
				return "register";
	}
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String signUp(@RequestParam(value = "username", required = true) String username,
						 @RequestParam(value = "password", required = true) String password,
						 @RequestParam(value = "email", required = true) String email, 
						 HttpSession session, Model model) throws Exception {

		try {
			signUpService.register(username, password, email);
			model.addAttribute("message", "Sign Up successful. Please login!");
			return "login";
		} catch (IllegalInputException | DataBaseException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "register";
		}
		
	}

}
