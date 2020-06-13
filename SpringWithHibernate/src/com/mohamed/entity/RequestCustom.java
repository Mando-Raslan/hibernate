package com.mohamed.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "requests")
public class RequestCustom {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REQ_ID")
	private Integer reqId;
	
	@Column(name = "REQ")
	private String  req;
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE")
	private Date  date;
	
	@Column(name = "PRICE")
	private String price;
	
	
	
	
	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	





	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}








	@JoinColumn(name    = "CUSTOM_PK")
	@ManyToOne( fetch   = FetchType.EAGER , 
			    cascade = {CascadeType.DETACH , CascadeType.MERGE ,
			              CascadeType.PERSIST , CascadeType.REFRESH})
	private Custom custom;


	public Integer getReqId() {
		return reqId;
	}


	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}


	public String getReq() {
		return req;
	}


	public void setReq(String req) {
		this.req = req;
	}


	public Custom getCustom() {
		return custom;
	}


	public void setCustom(Custom custom) {
		this.custom = custom;
	}


	@Override
	public String toString() {
		return "RequestCustom [reqId=" + reqId + ", req=" + req + ", custom=" + custom + "]";
	}
	
	
	
	
	
	
	    
	
	

}
