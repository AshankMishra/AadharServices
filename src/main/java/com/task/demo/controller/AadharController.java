package com.task.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.demo.modal.UserAadharBean;
import com.task.demo.modal.UserDetails;
import com.task.demo.service.AadharService;

@RestController
public class AadharController {
	private static Logger logger = LogManager.getLogger(AadharController.class.getName());

	@Autowired
	UserDetails userAadharDetails;

	@Autowired
	UserAadharBean userAadharBean;

	@Autowired
	AadharService aadharService;

	@GetMapping(value = "/")
	public String start() {
		return "Successfully Logged!!!";
	}

	@PostMapping(value = "/saveAadharDetails")
	public Object saveAadharDetails(List<UserAadharBean> listUserAadharBean) {
		try {
			return aadharService.processAadharDetails(listUserAadharBean);
		} catch (Exception e) {
			logger.info("Exception_in_saveAadharDetails_Controller: " + e.getMessage());
			return e.getMessage();
		}
	}
}
