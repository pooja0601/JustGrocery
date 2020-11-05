package au.usyd.elec5619.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.service.LoginManager;
import au.usyd.elec5619.service.LoginService;

@Controller
//@RequestMapping(value="/**")
public class LogoutController {
	
	
	@Resource(name="loginManager")
	  private LoginManager loginManager;

	  @Resource(name="loginService")
	  private LoginService loginService;
	  
	  @RequestMapping(value = "/logout")
	  public String logOutHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		  
			  HttpSession session = httpServletRequest.getSession(false);
			  if(session != null) {
				    session.invalidate();
			  }
			  return "login";
	  }
}

