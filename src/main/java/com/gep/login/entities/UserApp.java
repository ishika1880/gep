/*
package com.gep.login.entities;

import java.util.Date;

import org.hibernate.annotations.ColumnTransformer;
import org.springframework.data.annotation.Persistent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="UserApp")
public class UserApp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long app_id;
	
	// @Lob
	@ColumnTransformer(read = "to_clob(xml_data)", write = "?")
	@Column(name="xml_data", columnDefinition ="XMLType")
	//@Persistent
	//@Strategy("org.apache.openjpa.xmlmapping.XmlValueHandler")
	//@Column(name="xml_data")
	private String xml_data;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date received_date;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date forwarded_date;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date respond_date;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date synk_date;
	private int status;
	public UserApp() {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public UserApp(long app_id, String xml_data, int status) {
		super();
		this.app_id = app_id;
		this.xml_data = xml_data;
		this.status = status;
	}
	
	

}
*/