package com.example.membershipmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.generic.IGenericDAO;
import com.example.generic.IModel;
import com.example.membershipmanagement.user.UserData;

public class MembershipDAO {
	
	@Autowired
	IGenericDAO genericDAO;
	
	public void createUser(IModel oData) {
		genericDAO.save(oData);
	}
	
	public UserData getUser (IModel oData) {
		UserData oUserData = (UserData) oData;
		oUserData = (UserData) genericDAO.findOne(oUserData.getM_nUserId());
		return oUserData;
	}

	public List<IModel> getAllUsers() {
		List<IModel> arrUserData = genericDAO.findAll();
		return arrUserData;
	}
}
