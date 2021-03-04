package com.task.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.task.demo.dal.AadharDAO;
import com.task.demo.modal.UserAadharBean;
import com.task.demo.modal.UserDetails;

@Service
public class AadharServiceImpl implements AadharService {

	private static Logger logger = LogManager.getLogger(AadharServiceImpl.class.getName());

	@Autowired
	AadharDAO aadharDAO;

	@Override
	public Object processAadharDetails(List<UserAadharBean> listUserAadharBean) {
		List<UserDetails> listOfUserDetailsToBeSaved = new ArrayList<>();
		try {
			for (UserAadharBean userAadharBean : listUserAadharBean) {
				UserDetails userDetail = new UserDetails();
				Map<String, Object> aadharFrontSideData = new HashMap<>(), aadharBackSideData = new HashMap<>();
				List<Map<String, Object>> listOfImageData = new ArrayList<Map<String, Object>>();
				List<MultipartFile> imageFileList = userAadharBean.getImageFile();
				if (imageFileList != null && imageFileList.get(0) != null && imageFileList.get(1) != null) {
					aadharFrontSideData.put("FrontImage", new String(Base64.encodeBase64(imageFileList.get(0).getBytes())));
					aadharBackSideData.put("BackImage", new String(Base64.encodeBase64(imageFileList.get(1).getBytes())));
					listOfImageData.add(aadharFrontSideData);
					listOfImageData.add(aadharBackSideData);
					userDetail.setAadharNumber(userAadharBean.getAadharNumber());
					userDetail.setName(userAadharBean.getName());
					userDetail.setAddress(userAadharBean.getAddress());
					userDetail.setInsertDate(new Date());
					userDetail.setAadharPhotoinBase64(listOfImageData);
					listOfUserDetailsToBeSaved.add(userDetail);
				}
			}
			return aadharDAO.saveUserData(listOfUserDetailsToBeSaved);
		} catch (Exception e) {
			logger.info("Exception_in_processAadharDetails_Service: " + e.getMessage());
			return e.getMessage();
		}
	}

}
