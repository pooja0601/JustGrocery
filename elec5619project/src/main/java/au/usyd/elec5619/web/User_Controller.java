package au.usyd.elec5619.web;

import java.util.ArrayList;
import java.util.List;

import au.usyd.elec5619.domain.user;
import au.usyd.elec5619.service.AdminManager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.mvc.Controller;


@Controller
@RequestMapping(value="/**")
public class User_Controller  {
	/*
	@Resource(name="retailerManager")
	private RetailerManager retailerManager;
	
	@RequestMapping(value="/user_details")
	public String getForm(Model uiModel ) {
		
		
		System.out.println("In get method");
		return "user_details";
	}
	
	@RequestMapping(value="/user_details", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest httpServletRequest) {
		System.out.println("In post method");
		user userdetails = new user();
		userdetails.setFirst_name(httpServletRequest.getParameter("first_name"));
		userdetails.setLast_name(httpServletRequest.getParameter("last_name"));
		userdetails.setEmail_id(httpServletRequest.getParameter("email_id"));
		
		userdetails.setMobile_no(httpServletRequest.getParameter("mobile_no"));
		userdetails.setPostcode(httpServletRequest.getParameter("postcode"));
		
		userdetails.setPassword(httpServletRequest.getParameter("password"));
		
		this.retailerManager.updateuserprofile(userdetails);
		
		
		return "redirect:/user_details";*/
	}
