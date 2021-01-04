package com.spring.practice;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class StoredProcedureTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc-config.xml");
		DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("myDataSource");
		
		JdbcTemplate template = JdbcUtil.getJdbcTemplate();
		
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(template);
		List<Map<String, Object>> rows = jdbcCall.getJdbcTemplate().queryForList("select * from find_all_coffee_beverages()", new Object[] {  });
		System.out.println(rows.size());
		
		//int id = 3;
//	SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource)
//			.withFunctionName("find_all_coffee_beverages")
//			.returningResultSet("coffees", new CoffeBeverageMapper());
//	
	
		//SqlParameterSource in = new MapSqlParameterSource().addValue("in_book_id", id);
		//Map<String, Object> out = jdbcCall.execute();
		//List<CoffeeBeverage> list = (List<CoffeeBeverage>) out.get("coffees");
		
		
	}

}
