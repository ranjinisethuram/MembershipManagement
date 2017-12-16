package com.example.membershipmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.generic.IGenericDAO;
import com.example.generic.IModel;
import com.example.membershipmanagement.subscription.SubscriptionData;

public class SubscriptionDAO {
	@Autowired
	IGenericDAO genericDAO;
	
	public void createSubscription(IModel oData) {
		SubscriptionData oSubscritionData = (SubscriptionData) oData;
		genericDAO.save(oSubscritionData);
	}
	
	public List<IModel> getAllSubscriptions() {
		List<IModel> arrSubscriptions = genericDAO.findAll();
		return arrSubscriptions;
	}
}
