package com.task.demo.modal;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UserAadharBean {
	private String name;
	private String address;
	private Long aadharNumber;
	private List<MultipartFile> imageFile;

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

	public List<MultipartFile> getImageFile() {
		return imageFile;
	}

	public void setImageFile(List<MultipartFile> imageFile) {
		this.imageFile = imageFile;
	}

}
