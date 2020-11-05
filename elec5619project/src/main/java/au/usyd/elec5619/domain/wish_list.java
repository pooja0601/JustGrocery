package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="Wishlist")
public class wish_list implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="email_id")
	String email_id;
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	@Column(name="wishlist_name")
	public
	String wishlist_name;

	@Column(name="list_of_products")
	public
	String list_of_products;
	
	@Column(name="updated_time")
	Date updated_time;

	@Column(name="is_active")
	public
	String is_active;
	
	public Date getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}
	
	public String getWishlist_name() {
		return wishlist_name;
	}
	public void setWishlist_name(String wishlist_name) {
		this.wishlist_name = wishlist_name;
	}
	public String getList_of_products() {
		return list_of_products;
	}
	public void setList_of_products(String test_listofproducts) {
		this.list_of_products = test_listofproducts;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	
}