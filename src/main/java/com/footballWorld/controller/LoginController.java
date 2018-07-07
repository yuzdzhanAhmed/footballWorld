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
import com.footballWorld.model.dao.user.IUserDAO;
import com.footballWorld.pojo.User;

@Controller
public class LoginController {

	@Autowired
	private IUserDAO userDao;
	
	@RequestMapping(value = { "/login"}, method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest req)  {
		
		
				return "login";
	}
	@RequestMapping(value = { "/login"}, method = RequestMethod.POST)
	public String signIn(Model model, HttpSession session,
		                          @RequestParam(value = "username", required = true) String username,
		                         @RequestParam(value = "password", required = true) String password){
	  
		try {
			User user= userDao.loginUser(new User(username,password));
			session.setAttribute("user", user);
		    return "index";
		} catch (IllegalInputException | DataBaseException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "login";
		}
	    
	}
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signOut(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "index";
	}
     
	}
