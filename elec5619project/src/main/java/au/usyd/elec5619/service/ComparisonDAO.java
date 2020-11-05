package au.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.product_prices;
import au.usyd.elec5619.domain.retailer;
import au.usyd.elec5619.domain.wish_list;
//import au.usyd.elec5619.web.HomeController;

//@Service(value="retailerManager")
@Service(value="comparisonDAO")
@Transactional
public class ComparisonDAO implements ComparisonDAOInt {
	private static final Logger logger = LoggerFactory.getLogger(ComparisonDAO.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
	this.sessionFactory=sf;	
	}
	
	@Override
	public List<product_prices> getRetailers(String tag, String loc,String products) {
		logger.info("in get retailers DB one.");

		  return this.sessionFactory.getCurrentSession().createQuery(
		  " from product_prices pp join fetch pp.retailer as r " +
		  " where pp.price_date='2019-10-20' " +
		  " and r.location = '" + loc + "' "+
		  " and r.tag = '" + tag + "' " +
		  " order by pp.product_id").list();
	}
	
	@Override
	public List<retailer> getUniqueRetailers(String loc) {
		logger.info("in get retailers DB one.");
	
		  return this.sessionFactory.getCurrentSession().createQuery(
		  "from retailer where location = '"+loc+"'").list();
	}
	
	
	/*
	 * @Override public List<product_prices> getAllProductPrices(String loc) {
	 * logger.info("in get retailers DB one.");
	 * 
	 * return this.sessionFactory.getCurrentSession().createQuery(
	 * " from product_prices pp join fetch pp.retailer as r " +
	 * " where pp.price_date='2019-10-20' " + " and r.location = '" + loc + "' "+
	 * " order by pp.product_id").list(); }
	 */
	
	@Override
	public List<String> getWishLists(String email_id) {
		logger.info("in get wishlists DB one.");
		
		List<Object> rows=this.sessionFactory.getCurrentSession().createQuery("select distinct wishlist_name"
		  		+ " from wish_list"
		  		+ " where email_id='"
		  		+ email_id +"' and is_active='true' order by updated_time desc").list();
		List<String> wishlists_name = new ArrayList<String>();
		for (int i=0;i<rows.size();i++) {
			 String wishlist_name=rows.get(i).toString();
			 wishlists_name.add(wishlist_name);
		 }
		return wishlists_name;
	}
	
	public String getProductsList(String wishlist_name, String email_id) {
		logger.info("in get wishlists DB one.");
		
		List<Object> rows=this.sessionFactory.getCurrentSession().createQuery("select distinct list_of_products"
		  		+ " from wish_list"
		  		+ " where email_id='"
		  		+ email_id +"'"
		  				+ " AND wishlist_name='"+ wishlist_name + "'").list();
			 String products_list=rows.get(0).toString();
		 
		return products_list;
	}
	
	public List<String> getLocations() {
		logger.info("in get wishlists DB one.");
		
		 List<Object> rows=this.sessionFactory.getCurrentSession().createQuery("select distinct location"
		  		+ " from retailer").list();
		 List<String> locations = new ArrayList<String>();
		 for (int i=0;i<rows.size();i++) {
			 String loc_val=rows.get(i).toString();
			 locations.add(loc_val);
		 }
		 return locations;
	}
	
}
