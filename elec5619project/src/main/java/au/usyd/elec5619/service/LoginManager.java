package au.usyd.elec5619.service;
import java.io.Serializable; 
import java.util.List;


import au.usyd.elec5619.domain.*;

public interface LoginManager extends Serializable{

	//public Boolean loginValid(user user);
	public String addUserDetails(login_details_ad login_details_ad);
	public String addRegDetails(user user);
	public List<user> fetchPassword(String email);
	public void resetPassword(String email, String password);
}
