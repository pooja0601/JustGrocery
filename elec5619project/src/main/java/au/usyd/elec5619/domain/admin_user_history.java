package au.usyd.elec5619.domain;

import java.util.Date;
import java.io.Serializable;

public class admin_user_history implements Serializable {
	
	private String email;
	private Date logged_date;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLogged_date() {
		return logged_date;
	}
	public void setLogged_date(Date logged_date) {
		this.logged_date = logged_date;
	}
	
	
}