package com.jspider.logbackDemo.dto.admin;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="admin_table")
public class AdminDTO implements Serializable
{
	
	@Id
	@GenericGenerator(name="myid",strategy="increment")
	@GeneratedValue(generator="myid")
	@Column(name="a_id")
	private int id;
	@Column(name="a_username")
	private String username;
	@Column(name="a_password")
	private String password;
	@Column(name="a_contact_num")
	private long contactNum;
	@Column(name="a_email")
	private String email;
	@Column(name="a_tollbooth_name")
	private String tollbooth_name;
	@Column(name="a_expiry_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expiry_date;
	@Column(name="a_status")
	private boolean status;
	@Column(name="a_role")
	private boolean role;
	
	@Transient
	Logger log=LoggerFactory.getLogger(AdminDTO.class);
	
	public AdminDTO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContactNum() {
		return contactNum;
	}

	public void setContactNum(long contactNum) {
		this.contactNum = contactNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTollbooth_name() {
		return tollbooth_name;
	}

	public void setTollbooth_name(String tollbooth_name) {
		this.tollbooth_name = tollbooth_name;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", username=" + username + ", password=" + password + ", contactNum=" + contactNum
				+ ", email=" + email + ", tollbooth_name=" + tollbooth_name + ", expiry_date=" + expiry_date
				+ ", status=" + status + ", role=" + role + ", log=" + log + "]";
	}
	
}