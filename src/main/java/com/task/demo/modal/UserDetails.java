package com.task.demo.modal;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "userDetails")
public class UserDetails {

	@Id
	private String id;
	private String name;
	private String address;
	private Long aadharNumber;
	private List<Map<String, Object>> aadharPhotoinBase64;
	private Date insertDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public List<Map<String, Object>> getAadharPhotoinBase64() {
		return aadharPhotoinBase64;
	}

	public void setAadharPhotoinBase64(List<Map<String, Object>> aadharPhotoinBase64) {
		this.aadharPhotoinBase64 = aadharPhotoinBase64;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", address=" + address + ", aadharNumber=" + aadharNumber
				+ ", aadharPhotoinBase64=" + aadharPhotoinBase64 + ", insertDate=" + insertDate + "]";
	}
}
