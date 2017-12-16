package com.example.membershipmanagement.user;

import javax.persistence.*;

import com.example.generic.IModel;
import com.example.membershipmanagement.subscription.SubscriptionData;

@Entity
@Table(name="user")
public class UserData implements IModel{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	private int m_nUserId;
	
	@Column(name="userName",nullable=false)
	private String m_strName;
	
	@Column(name="email")
	private String m_strEmail;
	
	@Column(name="phoneNumber")
	private String m_strPhoneNumber;
	
	@Column(name="location")
	private int[] m_arrLocation;
	
	private SubscriptionData m_oSubscription;
	
	private boolean m_bisActive;
	
	public UserData() {
		m_nUserId = -1;
		m_strName = "";
		m_strEmail = "";
		m_strPhoneNumber = "";
		setM_arrLocation(new int[2]);
		m_oSubscription = null;
		m_bisActive = false;
	}

	public int getM_nUserId() {
		return m_nUserId;
	}

	public void setM_nUserId(int m_nUserId) {
		this.m_nUserId = m_nUserId;
	}

	public String getM_strName() {
		return m_strName;
	}

	public void setM_strName(String m_strName) {
		this.m_strName = m_strName;
	}

	public String getM_strEmail() {
		return m_strEmail;
	}

	public void setM_strEmail(String m_strEmail) {
		this.m_strEmail = m_strEmail;
	}

	public String getM_strPhoneNumber() {
		return m_strPhoneNumber;
	}

	public void setM_strPhoneNumber(String m_strPhoneNumber) {
		this.m_strPhoneNumber = m_strPhoneNumber;
	}

	public int[] getM_arrLocation() {
		return m_arrLocation;
	}

	public void setM_arrLocation(int[] m_arrLocation) {
		this.m_arrLocation = m_arrLocation;
	}

	public SubscriptionData getM_oSubscription() {
		return m_oSubscription;
	}

	public void setM_oSubscription(SubscriptionData m_oSubscription) {
		this.m_oSubscription = m_oSubscription;
	}

	public boolean isM_bisActive() {
		return m_bisActive;
	}

	public void setM_bisActive(boolean m_bisActive) {
		this.m_bisActive = m_bisActive;
	}

}
