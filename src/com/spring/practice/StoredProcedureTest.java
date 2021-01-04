package com.spring.practice;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StoredProcedureTest {

	public static void main(String[] args) {
		JdbcTemplate template = JdbcUtil.getJdbcTemplate();

		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(template);
		List<Map<String, Object>> rows = jdbcCall.getJdbcTemplate()
				.queryForList("select * from find_all_coffee_beverages()", new Object[] {});

		for (Map<String, Object> map : rows) {
			Set<String> keys = map.keySet();
			for (String key : keys) {
				System.out.println(key + " - " + map.get(key));
			}
		}

		// int id = 3;
//	SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource)
//			.withFunctionName("find_all_coffee_beverages")
//			.returningResultSet("coffees", new CoffeBeverageMapper());
//	

		// SqlParameterSource in = new MapSqlParameterSource().addValue("in_book_id",
		// id);
		// Map<String, Object> out = jdbcCall.execute();
		// List<CoffeeBeverage> list = (List<CoffeeBeverage>) out.get("coffees");

	}

}
