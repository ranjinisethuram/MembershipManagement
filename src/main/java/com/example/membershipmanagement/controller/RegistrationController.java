package com.example.membershipmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.generic.IModel;
import com.example.membershipmanagement.dao.MembershipDAO;
import com.example.membershipmanagement.dao.SubscriptionDAO;
import com.example.membershipmanagement.subscription.SubscriptionData;
import com.example.membershipmanagement.user.UserData;
import com.example.membershipmanagement.validator.RequestValidator;

@Controller
@RequestMapping("/membership")
public class RegistrationController {
	
	@Autowired
	MembershipDAO oMembershipDAO;
	
	@Autowired
	SubscriptionDAO oSubscriptionDAO;
	
	@Autowired
	RequestValidator oRequestValidator;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public void register(@RequestBody UserData oData) {
		try {
			boolean isValidUser = oRequestValidator.validateCreateUser(oData);
			if(isValidUser) {
				oMembershipDAO.createUser(oData);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/multiregistration", method=RequestMethod.POST)
	@ResponseBody
	public void registerMultipleUsers(@RequestBody ArrayList<UserData> oData) {
		ArrayList<UserData> validUsersToCreate = oRequestValidator.getValidUsersToCreate(oData);
	}
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	@ResponseBody
	public UserData getUser(@RequestBody UserData oData) {
		return oData;
	}
	
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
	@ResponseBody
	public List<IModel> getAllUsers() {
		List<IModel> arrUserData = oMembershipDAO.getAllUsers();
		return arrUserData;
	}

	@RequestMapping(value="/getUser",method=RequestMethod.PUT)
	@ResponseBody	
	public UserData update(@RequestBody UserData oData) {
		return oData;
	}
	
	@RequestMapping(value="/deactivate",method=RequestMethod.POST)
	@ResponseBody	
	public void deactivate (@RequestBody UserData oDat) {
		//deactivate user.set isActive to false
	}

	@RequestMapping(value="/listSubscriptions",method=RequestMethod.GET)
	@ResponseBody
	public List<IModel> listSubscriptions() {
		List<IModel> oSubscriptionData = oSubscriptionDAO.getAllSubscriptions();
		return oSubscriptionData;
	}

}
