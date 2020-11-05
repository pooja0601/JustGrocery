
package au.usyd.elec5619.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.wish_list;
import junit.framework.Assert;
import junit.framework.TestCase;


@Configuration(value = "classpath:persistence-context-test.xml")
public class WishlistDAOTest extends TestCase{
	
	@Autowired
	private WishListManager wishlistManager;
	
	private SessionFactory sf;
	private wish_list wishlist1;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sf=sf;
	}
	
	protected void setUp() throws Exception{
		wishlistManager=new DbWishlistManager();
		this.setSessionFactory(sf);
		String wishlist_name="TestWishList";
		String emailid="test@gmail.com";
		String List_of_products="test1,test2";
		Date Updated_time=new Date();	
		
		wishlist1 = new wish_list();
		wishlist1.setWishlist_name(wishlist_name);
		wishlist1.setEmail_id(emailid);
		wishlist1.setIs_active("true");
		 wishlist1.setList_of_products("test1,test2");
		 Date updated_time=(new Date());
		 wishlist1.setUpdated_time(updated_time);
		
	}
	
	@Test
	@Transactional
	public void testGetRetailers()
	{
		System.out.println("In test retailers");
		System.out.println(wishlistManager);
		System.out.println(wishlist1.getEmail_id());
		//wishlistManager.saveWishlist(wishlist1);
		List wishlists = this.wishlistManager.getAllWishlists("test@gmail.com");
		Assert.assertEquals(1, wishlists.size());
}
}
	
	
	
	
	
	
	/*
	 * public WishListManager wishlistManager;
	 * 
	 * @Test
	 * 
	 * @Transactional public void testWishList() {
	 * 
	 * wish_list wishlist1 = new wish_list();
	 * wishlist1.setWishlist_name("TestWishList");
	 * wishlist1.setEmail_id("test@gmail.com"); wishlist1.setIs_active("true");
	 * wishlist1.setList_of_products("test1,test2"); Date updated_time=(new Date());
	 * wishlist1.setUpdated_time(updated_time);
	 * 
	 * System.out.println(wishlist1.getWishlist_name().toString());
	 * System.out.println(this.wishlistManager);
	 * this.wishlistManager.saveWishlist(wishlist1);
	 * 
	 * List<String> wishlists =
	 * this.wishlistManager.getAllWishlists("test@gmail.com");
	 * 
	 * Assert.assertEquals(1, wishlists.size());
	 * 
	 * 
	 * 
	 * }
	 * 
	 * public void setWishlistManager(WishListManager wishlistManager) {
	 * this.wishlistManager=wishlistManager; }
	 */
	