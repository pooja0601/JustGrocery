package au.usyd.elec5619.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="auth_register")
public class user implements Serializable {

@Id
@GeneratedValue
@Column(name="id")
private int id;

@Column(name="username")
private String username;

@Column(name="passwd")
private String passwd;

@Column(name="email_id")
private String email_id;

@Column(name="first_name")
private String first_name;

@Column(name="last_name")
private String last_name;

@Column(name="post_code")
private String post_code;


@Column(name="mobile_no")
private String mobile_no;

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getUsername()
{
return this.username;
}
public void setUsername (String username)
{
this.username=username;
}
public String getPasswd()
{
return passwd;
}
public void setPasswd (String passwd)
{
this.passwd=passwd;
}
public String getEmail_id()
{
return email_id;
}
public void setEmail_id(String email_id)
{
this.email_id=email_id;
}
public String getFirst_name() {
return first_name;
}
public void setFirst_name(String first_name) {
this.first_name = first_name;
}
public String getLast_name() {
return last_name;
}
public void setLast_name(String last_name) {
this.last_name = last_name;
}
public String getPost_code() {
return post_code;
}
public void setPost_code(String post_code) {
this.post_code = post_code;
}
public String getMobile_no() {
return mobile_no;
}
public void setMobile_no(String mobile_no) {
this.mobile_no = mobile_no;
}

}
