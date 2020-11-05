package au.usyd.elec5619.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="retailer_details")
public class retailer implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="id")
	//@JoinColumn(name = "retailer_id")
	private double id;
	@Column(name="name")
	private String name;
	@Column(name="contact")
	private String contact;
	@Column(name="tag")
	private String tag;
	@Column(name="location")
	private String location;
	@Column(name="post_code")
	private int post_code;
	
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPost_code() {
		return post_code;
	}
	public void setPost_code(int post_code) {
		this.post_code = post_code;
	}
	
}
