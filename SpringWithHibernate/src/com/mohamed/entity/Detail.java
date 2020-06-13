package com.mohamed.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail")
public class Detail {
  
	@Override
	public String toString() {
		return "Detail [detailId=" + detailId + ", address=" + address + ", facebook=" + facebook + ", custom=" + custom
				+ "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DETAIL_ID")
	private Integer detailId;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "FACEBOOK")
	private String facebook;
	
	@OneToOne(mappedBy = "detailcustomer" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private Custom custom;

	
	
	
	public Detail() {
		super();
	}

	public Detail(String address, String facebook) {
		super();
		this.address = address;
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
