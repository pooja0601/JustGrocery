package au.usyd.elec5619.domain;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product_prices")
public class product_prices implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="uniqueid")
	private int id;
	
	@Column(name="price_date")
	private Date price_date;
	
	@Column(name="product_id")
	private int product_id;
	//@JoinColumn(name="product_prices_v")

	@Column(name="category")
	private String category;
	
	@Column(name="product_image")
	private String product_image;
	@OneToOne
	private retailer retailer;
	
	@Column(name="product_name")
	private String product_name;
	
	@Column(name="price")
	private double price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getPrice_date() {
		return price_date;
	}
	
	public void setPrice_date(Date price_date) {
		this.price_date = price_date;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public retailer getRetailer() {
		return retailer;
	}
	public void setRetailer(retailer retailer) {
		this.retailer = retailer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getProduct_image() {
		return product_image;
	}
	
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	
	
}