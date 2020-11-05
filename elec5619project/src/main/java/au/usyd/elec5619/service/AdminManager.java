package au.usyd.elec5619.service;
import java.io.Serializable; 
import java.util.List;
import java.util.Map;

import au.usyd.elec5619.domain.product_prices;
import au.usyd.elec5619.domain.retailer;
import au.usyd.elec5619.domain.user;

public interface AdminManager extends Serializable {
	
	public List<retailer> getRetailers();

	public void addProduct(product_prices newproduct); 
	
	public List<user> updateuserprofile(String test );
	
	public void modifiedUserProfile(user user, String test);
	
	public int addRetailer(retailer retailer);
	
	public List<Map<Object,Object>> getUserInfo();
	
	public List<Map<Object,Object>> getProductInfo();
	
	public List<Map<Object,Object>> getNumberOfLogs();
	
	public List<Map<Object,Object>> getProductByDay();
	

}
