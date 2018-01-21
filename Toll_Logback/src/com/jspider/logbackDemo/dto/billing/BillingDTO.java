package com.jspider.logbackDemo.dto.billing;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="billing_table")
public class BillingDTO implements Serializable
{
	@Id
	@GenericGenerator(name="id", strategy="increment")
	@GeneratedValue(generator="id")
	@Column(name="b_id")
	private int id;
	@Column(name="b_vehicleType")
	private String vehicleType;
	@Column(name="b_vehicleNumber")
	private String vehicleNumber;
	@Column(name="b_way")
	private String way;
	@Column(name="b_time")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date time;
	@Column(name="b_amount")
	private double amount;
	
	@Transient
	Logger log=LoggerFactory.getLogger(BillingDTO.class);
	
	public BillingDTO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BillingDTO [vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber + ", way=" + way
				+ ", time=" + time + ", amount=" + amount + "]";
	}
	
}
