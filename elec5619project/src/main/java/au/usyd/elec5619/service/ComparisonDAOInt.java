package au.usyd.elec5619.service;
import java.io.Serializable; 
import java.util.List;

import au.usyd.elec5619.domain.product_prices;
import au.usyd.elec5619.domain.retailer;

public interface ComparisonDAOInt extends Serializable {
	
	public List<product_prices> getRetailers(String tag, String loc, String products);
	public List<retailer> getUniqueRetailers(String loc);
	//public List<product_prices> getAllProductPrices(String loc);
	public List<String> getWishLists(String email_id);
	public List<String> getLocations();
	public String getProductsList(String wishlist_name, String email_id);
	
}
