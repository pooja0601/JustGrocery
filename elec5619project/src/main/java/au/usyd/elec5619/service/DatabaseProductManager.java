package au.usyd.elec5619.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.product_prices;

@Service(value="productManager")
@Transactional
public class DatabaseProductManager implements ProductManager {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void addProduct(product_prices product_prices) {
		this.sessionFactory.getCurrentSession().save(product_prices);
	}
}