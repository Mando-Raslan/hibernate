package com.mohamed.req;


import javax.validation.constraints.NotNull;

import com.mohamed.entity.Custom;

public class DetailReq {

	private Integer detailId;
	
	@NotNull(message = "address required")
	private String address;
	
	@NotNull(message = "facebook Acount required")
	private String facebook;
	

	private Custom custom;

	
	
	
	public DetailReq() {
		super();
	}

	public DetailReq(String address, String facebook) {
		
		this.address  = address;
		this.facebook = facebook;
	}

	public Integer getDetailId() {
		return detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	
	
}
