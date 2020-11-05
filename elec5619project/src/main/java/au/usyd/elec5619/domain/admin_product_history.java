package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="admin_product_history")
public class admin_product_history implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="serachID")

	private int searchID;
	@Column(name="product")
	private String product;
	@Column(name="searched_date")
	private Date searched_date;
	public int getSearchID() {
		return searchID;
	}
	public void setSearchID(int searchID) {
		this.searchID = searchID;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	public Date getSearched_date() {
		return searched_date;
	}
	public void setSearched_date(Date searched_date) {
		this.searched_date = searched_date;
	}
	
		
}