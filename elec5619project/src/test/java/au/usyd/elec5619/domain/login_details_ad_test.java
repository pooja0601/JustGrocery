package au.usyd.elec5619.domain;

import java.sql.Timestamp;
import java.util.Date;

import junit.framework.TestCase;

public class login_details_ad_test extends TestCase {
	private login_details_ad login_details_ad;
	
	protected void setUp() throws Exception{
		login_details_ad = new login_details_ad();
	}
	public void test_login_number() {
		int number =5;
		assertEquals(0,0,0);
		login_details_ad.setLogin_number(number);
		assertEquals(number,login_details_ad.getLogin_number());
	}
	public void test_email_id() {
		String email ="jain@gmail.com";
		assertNull(login_details_ad.getEmail_id());
		login_details_ad.setEmail_id(email);
		assertEquals(email,login_details_ad.getEmail_id());
	}//string
	public void test_login_time() {
		Date todays_date = new Date();
		assertNull(login_details_ad.getLogin_time());
		login_details_ad.setLogin_time((Timestamp) todays_date);
		assertEquals(todays_date,login_details_ad.getLogin_time());
	} //date
	public void test_logout_time() {
		Date todays_date = new Date();
		assertNull(login_details_ad.getLogout_time());
		login_details_ad.setLogout_time((Timestamp) todays_date);
		assertEquals(todays_date,login_details_ad.getLogout_time());
	}//date
	public void test_elapsed_time() {
		double number =0.00;
		assertEquals(0,0,0);
		login_details_ad.setElapsed_minutes(number);
		assertEquals(number,login_details_ad.getElapsed_minutes());
	}//double
	
}