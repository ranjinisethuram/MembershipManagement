package com.example.membershipmanagement.validator;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.membershipmanagement.dao.MembershipDAO;
import com.example.membershipmanagement.user.UserData;

public class RequestValidator {
	@Autowired
	MembershipDAO oMembershipDAO;
	
	public static final double RANGE = 6.0;

	public boolean validateCreateUser(UserData oData) throws Exception {
		boolean isValidUserToCreate = true;
		UserData oUserData = oMembershipDAO.getUser(oData);
		if(null == oUserData) {
			if(!isLocationInRange(oData)) {
				throw new Exception("Location is outside range! Cannot Register.");
			}
		}
		else if(!oUserData.isM_bisActive()){
			//Reactivate
			oData.setM_bisActive(true);
			isValidUserToCreate = false;
			//call update user
		}
		else {
			throw new Exception("User Already Exists and is Active!");
		}
		return isValidUserToCreate;
	}
	
	private boolean isLocationInRange(UserData oData) {
		boolean isInRange = true;
		int[] arrLoction = oData.getM_arrLocation();
		int nMain = arrLoction[0];
		int nCross = arrLoction[1];
		if(Math.sqrt((nMain*nMain) + (nCross*nCross)) > RANGE)
			isInRange = false;
		return isInRange;
	}

	public ArrayList<UserData> getValidUsersToCreate(ArrayList<UserData> oData) {
		// TODO Auto-generated method stub
		return null;
	}
}
