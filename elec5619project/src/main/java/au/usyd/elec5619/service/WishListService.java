package au.usyd.elec5619.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.wish_list;

@Service(value="wishlistServiceManager")
@Transactional
public class WishListService implements WishListServiceManager {
	
	@Resource(name="wishlistManager")
	public WishListManager wishlistManager;

	@Override
	public List getAllWishlists(String email) {
     	  List wishlists= wishlistManager.getAllWishlists(email);
		  return wishlists;
	}

	@Override
	public Map<String, Object> saveWishList(String wishlistname, String productList, String email) { //Code to Save  WishList
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("productList", productList);
		myModel.put("wishlistname", wishlistname);
		
        wish_list wishlist1=new wish_list();
        wishlist1.setWishlist_name(wishlistname);
        wishlist1.setList_of_products(productList);
        wishlist1.setEmail_id(email); //Adding email Id here
        
        Date updated_time=(new Date());  //Setting Current Time
        wishlist1.setUpdated_time(updated_time);
        
        String is_active="true";
        wishlist1.setIs_active(is_active);
        
        List<String> allwishLists = wishlistManager.retrieveWishlist();
        String message;
		if(allwishLists.contains(wishlistname)) {
			message="Wishlist Name Already exists";
		}else {
			message = "Successfull";
		}
        
        if(message=="Wishlist Name Already exists")
        {
        	myModel.put("message",message);
        }
        
        else{
        	wishlistManager.saveWishlist(wishlist1);
        }
        
        return myModel;
		
	}

	@Override
	public void saveEditedWishList(String oldwishlist_name, String newwishlist_name, String list_of_products,
			String isActive) {
		
		
	}


	
	
	
	
}

