package au.usyd.elec5619.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import au.usyd.elec5619.domain.login_details_ad;
import au.usyd.elec5619.domain.user;

@Service(value = "loginService")
public class LoginService {
	
	@Resource(name="loginManager")
	private LoginManager loginManager;
	
	public String LoginValidator(String email,String password) {
		user us= new user();
		us.setEmail_id(email);
		List<user> user_row=this.loginManager.fetchPassword(email);
		if (user_row.size() > 0) {
			String dbpassword=user_row.get(0).getPasswd();
			if(password.equals(dbpassword)) {
				System.out.println("pass match");
				  login_details_ad ld=new login_details_ad();
				  Date date= new Date();
				  
				  long time = date.getTime();
				      System.out.println("Time in Milliseconds: " + time);
				  
				  Timestamp ts = new Timestamp(time);
				  ld.setEmail_id(email);
				  ld.setLogin_time(ts);
	 
				  this.loginManager.addUserDetails(ld); 
				  return "success";
			}
			else {
				System.out.println("pass doesn't match");
				System.out.println(dbpassword);
				System.out.println(password);
				return "fail";
			}
		} else {
			System.out.println("user doesn't match");
			return "fail";
		}
		
	}
	
	public String checkUsername(String username) {
		user us= new user();
		us.setEmail_id(username);
		List<user> user_row=this.loginManager.fetchPassword(username);
		if (user_row.size() > 0) { 
			return "success";
		} else {
			return "failure";
		}
	}
	
	public void resetPassword(String email, String password) {
		
		loginManager.resetPassword(email, password);
	}
	
}
