package au.usyd.elec5619.service;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//import javax.servlet.http.HttpServletRequest;
import au.usyd.elec5619.domain.admin_product_history;
import au.usyd.elec5619.domain.product_prices;

@Service(value="productService")
public class ProductServiceImplementation implements ProductService {
	@Resource(name="productDao")
	public ProductDAO productDao;
//	private HttpServletRequest request;
	
	@Override
	public List<product_prices> getProducts(String name, admin_product_history searched_product) {
		System.out.println(name + searched_product);
		productDao.storeSearchHistoryDAO(searched_product);
		List<product_prices> productPrices = productDao.getProductsDAO(name);
		return productPrices;
	}

	
	@Override
	public List<String> getProductsList(String query) {
		String pro = null;
		List<String> products = productDao.getProductsList(query);
		query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for(int i=0; i < products.size(); i++) {
            pro = products.get(i).toLowerCase();
            if(pro.startsWith(query)) {
                matched.add(products.get(i));
            }
        }
		return matched;
	}
	
	@Override
	public List<String> getWishlists(String username) {
		List<String> wishlists = productDao.getWishlists(username);
		
		
		return wishlists;
	}
	
	@Override
	public void addProducts(String wishlist, String product, String username) {
		System.out.println("Product Service");
		productDao.addProducts(wishlist, product, username);
	}
	
}
