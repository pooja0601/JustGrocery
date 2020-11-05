package au.usyd.elec5619.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

//import au.usyd.elec5619.service.RetailerManagerService;

public class retailerTest extends TestCase {

	private retailer final_ret;
	private static Double id = new Double(1);
	private static String name  = "Woolworths";
	//private static String CHAIR_DESCRIPTION = 'Chair'; 
	private static String tag = "wow";
	private static String location = "CBD";
	private static String contact = "0478757655";
	private static Integer post_code = new Integer(2008);

	
	protected void setUp() throws Exception {
		System.out.println(name);
		retailer retailer_val = new retailer();
		retailer_val.setName(name);
		retailer_val.setTag(tag);
		retailer_val.setLocation(location);
		retailer_val.setContact(contact);
		retailer_val.setPost_code(post_code);
		final_ret=retailer_val;
		

	}
	
	
	public void testGetId() {
		
		assertNotNull(final_ret.getId());
		//assertEquals(retailer_val.getId(),new Double(1));
	}
	public void testGetName() {
		assertNotNull(final_ret.getName());
		assertEquals(final_ret.getName(),name);
	}
	public void testGetContact() {
		assertNotNull(final_ret.getContact());
		assertEquals(final_ret.getContact(),contact);
		
	}
	public void testGetTag() {
		assertNotNull(final_ret.getTag());
		assertEquals(final_ret.getTag(),tag);
	}
	public void testGetLocation() {
		assertNotNull(final_ret.getLocation());
		assertEquals(final_ret.getLocation(),location);
	}
	public void testGetPost_code() {
		assertNotNull(final_ret.getPost_code());
	//	assertEquals(retailer_val.getPost_code(),post_code);
	}
}
