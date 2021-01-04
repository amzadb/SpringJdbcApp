package com.spring.practice;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		NamedParameterJdbcTemplate template = JdbcUtil.getNamedParameterJdbcTemplate();

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 2);
		String pubName = template.queryForObject("SELECT PUB_NAME FROM PUBLISHER WHERE PUB_ID = :id", namedParameters,
				String.class);
		System.out.println("Publisher: " + pubName);

		int count = template.queryForObject("SELECT Count(*) FROM BOOK WHERE PUB_ID = :id", namedParameters,
				Integer.class);
		System.out.println("No. of books published: " + count);
	}


}
