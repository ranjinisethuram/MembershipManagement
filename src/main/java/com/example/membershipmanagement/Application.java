package com.example.membershipmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.membershipmanagement.dao.SubscriptionDAO;
import com.example.membershipmanagement.subscription.SubscriptionData;

@SpringBootApplication
public class Application {
	
//	@Bean
//	public SubscriptionData getSubscriptionData() {
//		return new SubscriptionData();
//	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
