package com.task.demo.dal;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.task.demo.modal.UserDetails;

@Repository
public class AadharDAOImpl implements AadharDAO {

	private static Logger logger = LogManager.getLogger(AadharDAOImpl.class.getName());

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Object saveUserData(List<UserDetails> listOfUserDetailsToBeSaved) {
		try {
			mongoTemplate.save(listOfUserDetailsToBeSaved);
			return null;
		} catch (Exception e) {
			logger.info("Exception_in_saveUserData: " + e.getMessage());
			return e.getMessage();
		}
	}

}
