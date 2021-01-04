package com.spring.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcUtil {
	public static JdbcTemplate getJdbcTemplate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc-config.xml");
		DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("myDataSource");

		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template;
	}
	
	public static NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc-config.xml");
		DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("myDataSource");

		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
		return template;
	}
}
