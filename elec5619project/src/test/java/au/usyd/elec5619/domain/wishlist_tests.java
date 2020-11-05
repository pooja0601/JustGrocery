package au.usyd.elec5619.domain;

import java.util.Date;

import junit.framework.TestCase;

public class wishlist_tests extends TestCase{
	
	private wish_list wish_list;
	
	protected void setUp() throws Exception{
		wish_list = new wish_list();
	}

	public void testSetAndGetUsername() {
		String test_username = "Frank@gmail.com";
		assertNull(wish_list.getEmail_id());
		wish_list.setEmail_id(test_username);
		assertEquals(test_username,wish_list.getEmail_id());
	}
	public void testSetAndGetWishlist_name() {
		String test_wishlistname = "JustGrocery";
		assertNull(wish_list.getWishlist_name());
		wish_list.setWishlist_name(test_wishlistname);
		assertEquals(test_wishlistname,wish_list.getWishlist_name());
	}
	
	public void testSetAndGetList_of_products() {
		String test_listofproducts = "Milk,Yogurt";
		assertNull(wish_list.getList_of_products());
		wish_list.setList_of_products(test_listofproducts);
		assertEquals(test_listofproducts,wish_list.getList_of_products());
	}
	
	public void testSetAndGetIs_active() {
		
		String test_isactive="true";
		assertNull(wish_list.getIs_active());
		wish_list.setIs_active(test_isactive);
		assertEquals(test_isactive,wish_list.getIs_active());
	}
	public void testSetAndGetUpdatedtime() {
		Date today_date= new Date();
		Date test_updatedtime=today_date;
		assertNull(wish_list.getUpdated_time());
		wish_list.setUpdated_time(test_updatedtime);
		assertEquals(test_updatedtime,wish_list.getUpdated_time());
	}
}
