package com.example.generic;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenericDAO extends JpaRepository<IModel, Serializable> {
	
}
