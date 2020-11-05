package au.usyd.elec5619.service;
import java.io.Serializable;
import java.util.List;
import au.usyd.elec5619.domain.wish_list;

public interface WishListManager extends Serializable {
	
	public void saveWishlist(wish_list wishlist1); 
	
	public List<String> retrieveWishlist();

 
	public List getAllWishlists(String email);
	
	public List getOneWishList(String wishlistname, String email);
	
	public void saveEditedWishList(wish_list wishlist1,String old_wishlistname);

	public void makeWishListInActive(wish_list wishlist1);

	public List<String> getRetailers();
}
