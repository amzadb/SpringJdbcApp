package com.spring.practice;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CoffeBeverageMapper implements RowMapper<CoffeeBeverage> {

	@Override
	public CoffeeBeverage mapRow(ResultSet rs, int row) throws SQLException {
		return new CoffeeBeverage(rs.getInt("ID"), rs.getString("COFFEE_NAME"), rs.getString("COFFEE_DESCRIPTION"));
	}

}
