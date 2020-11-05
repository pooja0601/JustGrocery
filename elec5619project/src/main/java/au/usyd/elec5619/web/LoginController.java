package au.usyd.elec5619.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.*;
import au.usyd.elec5619.service.LoginManager;
import au.usyd.elec5619.service.LoginService;
import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.mvc.Controller;
import javax.annotation.*;

@Controller
@RequestMapping(value = "/**")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	  @Resource(name="loginManager")
	  private LoginManager loginManager;

	  @Resource(name="loginService")
	  private LoginService loginService;
	
	  @RequestMapping(value = "/")
	  public String addUserDetails(Model uiModel)
	  { System.out.println("im in get login");
	  return "login"; }
	 
	  @RequestMapping(value = "/login", method = RequestMethod.POST) 
	  public String addUserDetails(HttpServletRequest httpServletRequest,  HttpSession session) {
	  
		 
	  System.out.println("im in post login");
	  
	  String email;
	  email=httpServletRequest.getParameter("email_id");
	  String password=httpServletRequest.getParameter("passwd");
	  String logged_in=this.loginService.LoginValidator(email,password);
	  System.out.println(logged_in);
	  
	  Map<String,Object> myModel=new HashMap<String,Object>();
	  myModel.put("logged", logged_in);
	  if(logged_in.equals("success")) {
		  if(email.equals("admin@justgrocery.com")) {
			  session.setAttribute("user", email);
			  return  "redirect:/userlogininfo";     //new ModelAndView("logsuccess");
		  } else {
			  session.setAttribute("user", email);
			  return  "redirect:/wishListComparison";   
		  }
	 } else {
		  return   "redirect:/login_failure";   //new ModelAndView("login","model",myModel);
	  }
	 }
	 
	  
	  @RequestMapping(value="/login_failure", method= RequestMethod.GET) 
	  public ModelAndView login_failure(Locale locale,Model model) {
	  logger.info("Welcome register! {}. ",locale); 
	  String myModel=new String();
	  myModel="In correct email/password. Please check!";
	  return new ModelAndView("login","model",myModel);
	  }
	  
	  @RequestMapping(value="/register", method= RequestMethod.GET) 
	  public String register(Locale locale,Model model) {
	  logger.info("Welcome register! {}. ",locale); 
	  return "register"; 
	  }
	  
	  @RequestMapping(value="/forgotPassword/{usid}", method= RequestMethod.GET) 
	  public String forgot_password(@PathVariable("usid") String usid, Locale locale,Model model, HttpSession session) {
	  usid+=".com";
	  String logged_in=this.loginService.checkUsername(usid);
	  if(logged_in.equals("success"))
	  {
		  session.setAttribute("user", usid);
		  return "forgotPassword";     //new ModelAndView("logsuccess");
	  }
	  else {
		  return   "wrongUsername";   //new ModelAndView("login","model",myModel);
	  }
	  
	  }
	  
	  @RequestMapping(value="/resetPassowrd", method=RequestMethod.POST)
	  public String reset_password(HttpServletRequest httpServletRequest,  HttpSession session) {
		  
		  String password = httpServletRequest.getParameter("passwd");
		  String email = session.getAttribute("user").toString();
		  
		  this.loginService.resetPassword(email, password);
		  
		  
		  return "redirect:/";
		  
	  }

	  public void setLoginManager(LoginManager loginManager) { 
		  this.loginManager = loginManager; 
	  }
	 
	  public void setLoginService(LoginService loginService) { this.loginService =
			  loginService; }
	 	  

}