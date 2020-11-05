package au.usyd.elec5619.service;

import java.io.Serializable;

import au.usyd.elec5619.domain.product_prices;

public interface ProductManager extends Serializable {
	//To add the product 
	public void addProduct(product_prices product_prices);
	
}