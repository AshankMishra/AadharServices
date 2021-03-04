package com.task.demo.dal;

import java.util.List;

import com.task.demo.modal.UserDetails;

public interface AadharDAO {

	Object saveUserData(List<UserDetails> listOfUserDetailsToBeSaved);

}
