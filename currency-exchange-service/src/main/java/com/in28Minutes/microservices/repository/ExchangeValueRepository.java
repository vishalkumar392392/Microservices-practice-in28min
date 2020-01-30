package com.in28Minutes.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28Minutes.microservices.controller.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long>{

	
	public ExchangeValue findByFromAndTo(String name,String to);
}
