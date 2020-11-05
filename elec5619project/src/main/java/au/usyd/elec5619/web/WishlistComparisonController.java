package au.usyd.elec5619.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import au.usyd.elec5619.service.ComparisonDAOInt;
import au.usyd.elec5619.service.ComparisonServiceInt;
import javax.annotation.*;


@Controller
public class WishlistComparisonController
{
	  private static final Logger logger = LoggerFactory.getLogger(WishlistComparisonController.class);
	
	  @Resource(name="comparisonDAO")
	  private ComparisonDAOInt comparisonDAO;
	
	  @Resource(name="comparisonServiceLayer")
  	  private ComparisonServiceInt comparisonServiceLayer;
	  private String email;
	  
	  
	  @RequestMapping(value = "/wishListComparison", method = RequestMethod.GET)
	  public ModelAndView handleRequest_new_again(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException,IOException {
	  
	  Object user_email = session.getAttribute("user");
	  logger.info(" "+ user_email.toString());
	  Map<Object, Object> myModel = new HashMap<Object, Object>();
	  email=user_email.toString();
	  if (email.equals(null)) {
		  
		  logger.info("Couldn't capture email_id. User not logged in!");
		  return new ModelAndView("NotLogged", "msg_val","User should login first"); 
	  }
	  else {
	  List<String> Loc = this.comparisonDAO.getLocations();
	  List<String> wishlist_names=this.comparisonDAO.getWishLists(email);
	  if(wishlist_names.size()>0) {
	  String Location=Loc.get(0).toString();
	  String wishList_val=wishlist_names.get(0).toString();
	  String wishList = this.comparisonDAO.getProductsList(wishList_val, email) ;
	  Map<Object,Object> myModel_ret=this.comparisonServiceLayer.formatDataCharts(myModel, Location, wishList);
	  Map<Object,Object> myModel_ret_final=this.comparisonServiceLayer.formatDataTable(myModel_ret, Location, wishList);
	  myModel_ret_final.put("location", Loc); 
	  myModel_ret_final.put("WLnames", wishlist_names); 
	  myModel_ret_final.put("selected_wl", wishList_val);
	  myModel_ret_final.put("selected_loc", Location);
	  return new ModelAndView("fetchComparisonPage", "model", myModel_ret_final); }
	  else {
		  Map<Object,Object> myModel_ret_final= new HashMap<Object, Object>();
		  myModel_ret_final.put("msg", "No wishlists yet! Please go to wishlist tab and create one.");
		  return new ModelAndView("fetchComparisonPage", "model", myModel_ret_final); }
	  }
	  }
	 
	
	@RequestMapping(value = "/wishListComparison", method = RequestMethod.POST)
	public ModelAndView handleRequest_new_again_post(HttpServletRequest request,
	HttpServletResponse response) throws ServletException,IOException {
	Map<Object, Object> myModel = new HashMap<Object, Object>();
	String Location =request.getParameter("loc");
	String wishList_val =request.getParameter("wishlist");
	//String email="pooja@gmail.com";
	String wishList = this.comparisonDAO.getProductsList(wishList_val, email) ;
	logger.info("Products from WishList are "+ wishList);
	//Map<Object,Object> myModel_ret=this.comparisonServiceLayer.formatDataChartsTable(myModel, Location, wishList);
	Map<Object,Object> myModel_ret=this.comparisonServiceLayer.formatDataCharts(myModel, Location, wishList);
	Map<Object,Object> myModel_ret_final=this.comparisonServiceLayer.formatDataTable(myModel_ret, Location, wishList);
	myModel_ret_final.put("selected_wl", wishList_val);
	myModel_ret_final.put("selected_loc", Location);
	List<String> Loc = this.comparisonDAO.getLocations();
	List<String> wishlist_names=this.comparisonDAO.getWishLists(email);
	myModel_ret_final.put("location", Loc); 
	myModel_ret_final.put("WLnames", wishlist_names); 
	return new ModelAndView("postComparison", "model", myModel_ret_final);
	}
	
	public void setComparisonDAO(ComparisonDAOInt comparisonDAO) {
		this.comparisonDAO = comparisonDAO;
	}
	
	public void setComparisonServiceLayer(ComparisonServiceInt comparisonServiceLayer) {
		this.comparisonServiceLayer = comparisonServiceLayer;
	}
}