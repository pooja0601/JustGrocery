package au.usyd.elec5619.web;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import au.usyd.elec5619.domain.wish_list;
import au.usyd.elec5619.service.WishListManager;
import au.usyd.elec5619.service.WishListServiceManager;



@Controller
@RequestMapping(value = "/wishlist/**")
public class WishlistController { 
	
	@Resource(name="wishlistManager")
	public WishListManager wishlistManager;
	
		
	@Resource(name="wishlistServiceManager")
	public WishListServiceManager wishlistServiceManager;
	
	
	@RequestMapping(value = "/") //Redirects to wishList page
	public ModelAndView wishlist(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String email=session.getAttribute("user").toString();
		List wishlists = wishlistServiceManager.getAllWishlists(email);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("wishlists",wishlists);
		return new ModelAndView("wishlist","model",myModel);
	}
	
	@RequestMapping(value = "/newWishlist") // To create new wishList
	public ModelAndView createNewWishlist() {
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("products", this.wishlistManager.getRetailers());
    	return new ModelAndView("createwishlist","model",myModel);
    	
	}
	
	@RequestMapping(value = "/saveWishlist", method = RequestMethod.POST)
	public String createNewWishlist(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		  
        String wishlistname=request.getParameter("wishlistName");  // Getting WishList name
		String productList=request.getParameter("productList"); //Taking code from input area to save as product List
		String email=session.getAttribute("user").toString();
		Map<String, Object> myModel=wishlistServiceManager.saveWishList(wishlistname,productList,email);	
    	return "redirect:/wishListComparison";
	}
	
	
	@RequestMapping(value = "/editWishList", method=RequestMethod.POST)
	public ModelAndView editWishlist(HttpServletRequest httpServletRequest, HttpSession session) { // Code when Clicked on Edit Single WishList	Card	
		String email=session.getAttribute("user").toString();
		String wishlistname = httpServletRequest.getParameter("wishlist_name");
		List details = wishlistManager.getOneWishList(wishlistname, email);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("wishlistdetails", details);
		myModel.put("retailers", this.wishlistManager.getRetailers());
		
		return new ModelAndView("editWishList","model",myModel);
	}
	
	
	@RequestMapping(value = "/saveEditedWishList", method=RequestMethod.POST)
	public String saveEditedWishList(HttpServletRequest httpServletRequest,HttpSession session) {	
		
		String oldwishlist_name= httpServletRequest.getParameter("oldwishlist_name");
		String isActive = httpServletRequest.getParameter("isActive");
		String email=session.getAttribute("user").toString();
		
		 String is_Active;
		
		
		wish_list wishlist1=new wish_list();
        wishlist1.setWishlist_name(httpServletRequest.getParameter("wishlistName"));
        wishlist1.setList_of_products(httpServletRequest.getParameter("form-control"));
        
        wishlist1.setEmail_id(email);
        
        Date updated_time=(new Date());
        wishlist1.setUpdated_time(updated_time);
        
        if(isActive.equals("inactive")) {
           is_Active="false";
           wishlist1.setIs_active(is_Active);
           wishlistManager.makeWishListInActive(wishlist1);
        }
        else {
        	is_Active="true";
        }
        wishlist1.setIs_active(is_Active);
		
        wishlistManager.saveEditedWishList(wishlist1,oldwishlist_name);
		return "redirect:/wishlist/";
		
		
	}
	
	
}





