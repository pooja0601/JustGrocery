package au.usyd.elec5619.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.*;
import au.usyd.elec5619.web.*;

@Service(value = "loginManager")
@Transactional
public class DbLoginManager implements LoginManager {

	private static final Logger logger = LoggerFactory.getLogger(DbLoginManager.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public String addUserDetails(login_details_ad login_details_ad) {
		logger.info("in login DB.");

		System.out.println("hi user is added into audit");
		System.out.println(login_details_ad.getEmail_id());
		System.out.println(login_details_ad.getLogin_time());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		this.sessionFactory.getCurrentSession().save(login_details_ad);
		commitTransaction(tx, session);
		return this.sessionFactory.getCurrentSession().toString();
	}

	@Override
	public String addRegDetails(user user) {

		logger.info("in reg DB.");

		
		System.out.println("hi user is registered");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		this.sessionFactory.getCurrentSession().save(user);
		commitTransaction(tx, session);
		return this.sessionFactory.getCurrentSession().toString();
	}

	public void commitTransaction(Transaction tx, Session session) {
		// TODO Auto-generated method stub
		try {
			System.out.println("I came into commit transaction");
			session.flush();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}
	
	public List<user> fetchPassword(String email) {
		return this.sessionFactory.getCurrentSession().createQuery("from user where email_id='"+ email + "'").list();
	}
	
	@Override
	public void resetPassword(String email, String password) {
		String query = "UPDATE user SET passwd='"+ password + "' where email_id='"+ email + "'";
		
		this.sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
	}
	
	
}
