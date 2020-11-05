package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import au.usyd.elec5619.domain.wish_list;


import au.usyd.elec5619.domain.retailer;

@Service(value="wishlistManager")
@Transactional
public class DbWishlistManager implements WishListManager {
	private static final Logger logger = LoggerFactory.getLogger(DbWishlistManager.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
	this.sessionFactory=sf;	
	}
	
	@Override
	public void saveWishlist(wish_list wishlist1) {
		logger.info("in get wishlist DB one.");
		
         this.sessionFactory.getCurrentSession().save(wishlist1);
	}
	@Override
	public List<String> retrieveWishlist(){
		logger.info("in get wishlist DB one.");
	
         return this.sessionFactory.getCurrentSession().createQuery("SELECT distinct wishlist_name FROM wish_list where is_active='true' ").list();
	}
	

	@Override
	public List getAllWishlists(String email) {
		
		
		 return this.sessionFactory.getCurrentSession().createQuery("FROM wish_list where is_active='true' and email_id ='"+ email +"'").list();
		
		
	}

	@Override
	public List getOneWishList(String wishlistname, String email) {
		 return this.sessionFactory.getCurrentSession().createQuery("FROM wish_list where wishlist_name='"+wishlistname+"' and email_id='"+email+"'").list();
		 
	}

	@Override
	public void saveEditedWishList(wish_list wishlist1,String old_wishlistname) {		
		
		Query query = this.sessionFactory.getCurrentSession().createQuery("UPDATE wish_list SET wishlist_name = :wishlistname , list_of_products = :listofproducts "+" WHERE wishlist_name = :oldwishlistname");
		query.setParameter("wishlistname", wishlist1.wishlist_name);
		query.setParameter("oldwishlistname",old_wishlistname);
		query.setParameter("listofproducts",wishlist1.list_of_products);
		query.executeUpdate();
		
		
	}

	@Override
	public void makeWishListInActive(wish_list wishlist1) {
		
			
		Query query =this.sessionFactory.getCurrentSession().createQuery("UPDATE wish_list SET is_active = :isActive "+" WHERE wishlist_name = :wishListName");
		query.setParameter("isActive",wishlist1.is_active);
		query.setParameter("wishListName",wishlist1.wishlist_name);
		query.executeUpdate();
	}
	
	
	@Override
	public List<String> getRetailers() {
		
		return this.sessionFactory.getCurrentSession().createQuery("select distinct product_name from product_prices where price_date='2019-10-20'").list();
		
		}


	
	
}
