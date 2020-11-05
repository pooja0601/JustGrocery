package au.usyd.elec5619.service;

import java.util.List;

import au.usyd.elec5619.domain.admin_product_history;
import au.usyd.elec5619.domain.product_prices;

public interface ProductDAO {

	public List<product_prices> getProductsDAO(String name);
	public void storeSearchHistoryDAO(admin_product_history searched_product);
	public List<String> getProductsList(String query);
	public List<String> getWishlists(String username);
	public void addProducts(String wishlist, String product, String username);
}
