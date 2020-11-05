package au.usyd.elec5619.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.user;
import au.usyd.elec5619.service.LoginManager;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = "/register/**")
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Resource(name="loginManager")
	private LoginManager loginManager;
	
	
	@RequestMapping(value = "/")
	public String addUserDetails(Model uiModel) {
	System.out.println("im in get register"); 
	return "register"; 
	  }


	@RequestMapping(value = "/", method = RequestMethod.POST) 
	public String addUserDetails(HttpServletRequest httpServletRequest) {  
	String pass;
	System.out.println("im in post register"); 
	user us1 = new user();
	  us1.setPasswd(httpServletRequest.getParameter("passwd"));
	  us1.setEmail_id(httpServletRequest.getParameter("email_id"));
	  us1.setFirst_name(httpServletRequest.getParameter("first_name"));
	  us1.setLast_name(httpServletRequest.getParameter("last_name"));
	
	  System.out.println(us1.getPasswd());
	  System.out.println(us1.getEmail_id());
	  System.out.println(us1.getPost_code());
	  System.out.println(us1.getFirst_name());
	  System.out.println(us1.getLast_name());
	  System.out.println(us1.getMobile_no());
	 
	  this.loginManager.addRegDetails(us1); 
	  return "redirect:/";
	  }
	

	  public void setLoginManager(LoginManager loginManager) { 
		  this.loginManager = loginManager; 
		  }
 
}
