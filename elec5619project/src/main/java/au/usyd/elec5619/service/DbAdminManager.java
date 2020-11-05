package au.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.product_prices;
import au.usyd.elec5619.domain.retailer;
import au.usyd.elec5619.domain.user;

@Service(value="adminManager")
@Transactional
public class DbAdminManager implements AdminManager, ProductManager {
	private static final Logger logger = LoggerFactory.getLogger(DbAdminManager.class);
	private SessionFactory sessionFactory;
	String email_id;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
	this.sessionFactory=sf;	
	}
	
	@Override
	public List<retailer> getRetailers() {
		logger.info("in get retailers DB one.");
		return this.sessionFactory.getCurrentSession().createQuery("from product_prices where price_date='2019-10-23'").list();
	}
	public void addProduct(product_prices product_prices) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(product_prices.getId());
		System.out.println(product_prices.getPrice());
		System.out.println(product_prices.getProduct_id());
		System.out.println(product_prices.getProduct_image());
		System.out.println(product_prices.getProduct_name());
		System.out.println(product_prices.getCategory());
		System.out.println(product_prices.getRetailer());
		String string= (String) this.sessionFactory.getCurrentSession().save(product_prices);
		Integer result = Integer.valueOf(string);		
		commitTransaction(tx, session);
	}
	public void commitTransaction(Transaction tx, Session session) {	
		try {
			System.out.println("I came into commit transaction");
		   session.flush();
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}
	}

	@Override
	public List<user> updateuserprofile(String test) {
		
		this.email_id =test;
		return this.sessionFactory.getCurrentSession().createQuery("FROM user where email_id ='"+ email_id +"'").list();
	}

	@Override
	public void modifiedUserProfile(user userdetails, String email_id) {
		email_id = this.email_id;
		Session currentSession = this.sessionFactory.getCurrentSession();
		String hql = "delete from user where email_id =:name";
		currentSession.createQuery(hql).setString("name", email_id).executeUpdate();
		
		System.out.println("hello, i am from modified userproigle");
		this.sessionFactory.getCurrentSession().save(userdetails);
	}

	@Override
	public int addRetailer(retailer retailer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		this.sessionFactory.getCurrentSession().save(retailer);
		int result =0;	
		System.out.println(result);
		
		commitTransaction(tx, session);
		
		return result;
	}
	public List<Map<Object,Object>> getUserInfo() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery a = session.createSQLQuery("SELECT EXTRACT(MONTH from login_time) as 'month' ,email_id," + 
				"COUNT(login_number) totalcount " + 
				"from oof.login_details_ad" + 
				" GROUP BY EXTRACT(month from login_time),email_id" + 
				" order by month;");
		List<Object[]> rows = a.list();
		
		  Map<Object,Object> map = null;  
		  List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>(); System.out.println(rows);
		  
		  
		  for (Object[] row : rows) { System.out.println(row[0] + " "
		  +row[1]+" "+row[2]); map = new HashMap<Object,Object>(); map.put("y",
		  row[2]); map.put("label", row[1]); list.add(map);
		  
		  }
		 
	    return list;
	}
	public List<Map<Object,Object>> getProductInfo() {
		Session session = sessionFactory.openSession();
		SQLQuery a = session.createSQLQuery("SELECT EXTRACT(MONTH from searched_date) as month ,product, " + 
				"COUNT(serachID) totalcount " + 
				"from oof.admin_product_history " + 
				"GROUP BY EXTRACT(month from searched_date),product " + 
				"order by totalcount;");
		List<Object[]> rows = a.list();
		Map<Object,Object> map = null;
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		System.out.println(rows);
		
		for (Object[] row : rows) { 
			  System.out.println(row[0] + " " +row[1]+" "+row[2]);
			  map = new HashMap<Object,Object>(); map.put("y", row[2]); map.put("label", row[1]); list.add(map);
		  }
		 
	    return list;
	}

	@Override
	public List<Map<Object, Object>> getNumberOfLogs() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		SQLQuery a = session.createSQLQuery("SELECT EXTRACT(MONTH from login_time) as month, " + 
				"COUNT(login_number) totalcount " + 
				"from oof.login_details_ad " + 
				"GROUP BY EXTRACT(month from login_time) " + 
				"order by month;");
		List<Object[]> rows = a.list();
		Map<Object,Object> map = null;
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		for(Object[] row: rows) {
			int i = (Integer) row[0];
			map = new HashMap<Object,Object>(); map.put("y", row[1]); map.put("label", months[i+1]); list.add(map);		
		}
	return list;
	}

	@Override
	public List<Map<Object, Object>> getProductByDay() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		SQLQuery a = session.createSQLQuery("Select EXTRACT(DAY from searched_date) as day," + 
				"COUNT(serachID) totalcount " + 
				"from oof.admin_product_history " + 
				"GROUP BY EXTRACT(day from searched_date) " + 
				"order by totalcount;");
		List<Object[]> rows = a.list();
		Map<Object,Object> map = null;
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		
		for(Object[] row: rows) {
			System.out.println(row[0] + " " +row[1]);
			map = new HashMap<Object,Object>(); map.put("y", row[1]); map.put("label", row[0]); list.add(map);
			
		}
		return list;
	}	
}
