package com.spring.practice;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CoffeeService {

	String findCoffeeBeverage(Integer input);

	List<CoffeeBeverage> findAllCoffeeBeverages();
}
