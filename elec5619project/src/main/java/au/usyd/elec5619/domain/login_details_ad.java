package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="login_details_ad")

public class login_details_ad implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="login_number")
	private int login_number;
	
	@Column(name="email_id")
	private String  email_id;
	
	@Column(name="login_time")
	private Timestamp login_time;
	
	@Column(name ="logout_time")
	private Timestamp logout_time;
	
	@Column(name ="elapsed_minutes")
	private double elapsed_minutes;
	
	public int getLogin_number() {
		return login_number;
	}
	public void setLogin_number(int login_number) {
		this.login_number = login_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Timestamp getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Timestamp login_time) {
		this.login_time = login_time;
	}
	public Timestamp getLogout_time() {
		return logout_time;
	}
	public void setLogout_time(Timestamp logout_time) {
		this.logout_time = logout_time;
	}
	public double getElapsed_minutes() {
		return elapsed_minutes;
	}
	public void setElapsed_minutes(double elapsed_minutes) {
		this.elapsed_minutes = elapsed_minutes;
	}
	
}