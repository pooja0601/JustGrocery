package au.usyd.elec5619.service;

import java.io.Serializable;
import au.usyd.elec5619.domain.admin_product_history;
import java.util.List;

import au.usyd.elec5619.domain.product_prices;

public interface ProductService extends Serializable {

	public List<product_prices> getProducts(String name, admin_product_history searched_product);
	public List<String> getProductsList(String query);
	public List<String> getWishlists(String username);
	public void addProducts(String wishlist, String product, String username);
}
