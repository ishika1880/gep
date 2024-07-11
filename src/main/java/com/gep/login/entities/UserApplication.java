package com.gep.login.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name="UserApplication")
public class UserApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long app_id;	
	private String xml_data;
	@Temporal(TemporalType.TIMESTAMP)
	private Date received_date;
	@Temporal(TemporalType.TIMESTAMP)
	private Date forwarded_date;
	@Temporal(TemporalType.TIMESTAMP)
	private Date respond_date;
	@Temporal(TemporalType.TIMESTAMP)
	private Date synk_date;
	private int status;
	public UserApplication(long app_id, String xml_data, Date received_date, Date forwarded_date, Date respond_date,
			Date synk_date, int status) {
		super();
		this.app_id = app_id;
		this.xml_data = xml_data;
		this.received_date = received_date;
		this.forwarded_date = forwarded_date;
		this.respond_date = respond_date;
		this.synk_date = synk_date;
		this.status = status;
	}
	public UserApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getApp_id() {
		return app_id;
	}
	public void setApp_id(long app_id) {
		this.app_id = app_id;
	}
	public String getXml_data() {
		return xml_data;
	}
	public void setXml_data(String xml_data) {
		this.xml_data = xml_data;
	}
	public Date getReceived_date() {
		return received_date;
	}
	public void setReceived_date(Date received_date) {
		this.received_date = received_date;
	}
	public Date getForwarded_date() {
		return forwarded_date;
	}
	public void setForwarded_date(Date forwarded_date) {
		this.forwarded_date = forwarded_date;
	}
	public Date getRespond_date() {
		return respond_date;
	}
	public void setRespond_date(Date respond_date) {
		this.respond_date = respond_date;
	}
	public Date getSynk_date() {
		return synk_date;
	}
	public void setSynk_date(Date synk_date) {
		this.synk_date = synk_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}
