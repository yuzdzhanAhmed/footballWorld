package com.footballWorld.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomeController {


	@RequestMapping(value = { "/index", "/" }, method = RequestMethod.GET)
	public String homePage(Model model, HttpServletRequest req)  {
		
				return "index";
	}
	@RequestMapping(value = { "/live" }, method = RequestMethod.GET)
	public String live(Model model, HttpServletRequest req)  {
		
				return "livescore";
	}

	

}
