package au.usyd.elec5619.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface WishListServiceManager extends Serializable {


	public Map<String, Object> saveWishList(String wishlistname, String productList,String email);

	public void saveEditedWishList(String oldwishlist_name, String newwishlist_name, String list_of_products,
			String isActive);

	public List getAllWishlists(String email);
	

}
