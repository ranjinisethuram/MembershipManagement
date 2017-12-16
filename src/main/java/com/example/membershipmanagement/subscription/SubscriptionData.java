package com.example.membershipmanagement.subscription;

import javax.persistence.*;

import com.example.generic.IModel;

@Entity
@Table(name="subscription")
public class SubscriptionData implements IModel{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int m_nId;
	
	@Column(name="subscriptionName")
	private String m_strSubscriptionName;
	
	@Column(name="description")
	private String m_strDescription;
	
	public SubscriptionData () {
		m_nId = -1;
		m_strSubscriptionName = "";
		m_strDescription = "";
	}

	public int getM_nId() {
		return m_nId;
	}

	public void setM_nId(int m_nId) {
		this.m_nId = m_nId;
	}

	public String getM_strSubscriptionName() {
		return m_strSubscriptionName;
	}

	public void setM_strSubscriptionName(String m_strSubscriptionName) {
		this.m_strSubscriptionName = m_strSubscriptionName;
	}

	public String getM_strDescription() {
		return m_strDescription;
	}

	public void setM_strDescription(String m_strDescription) {
		this.m_strDescription = m_strDescription;
	}
}
