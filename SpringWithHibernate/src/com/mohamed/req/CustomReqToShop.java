package com.mohamed.req;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mohamed.entity.Custom;

public class CustomReqToShop {

	
	
	

	private Integer reqId;
	@Size(min = 10 , max = 100 , message = "enter valid request")
	@NotNull(message = "reqired please")
	private String req;

	
	private Custom custom;

	@NotNull(message = "reqired please")
	private String  date;
	
	@NotNull(message = "reqired please")
	private String price;
	

	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


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
		return "CustomReqToShop [reqId=" + reqId + ", req=" + req + ", custom=" + custom + "]";
	}
	
	
	

}
