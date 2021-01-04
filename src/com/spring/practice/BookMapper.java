package com.spring.practice;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Book book = new Book();

		book.setId(resultSet.getInt(1)); // BOOK_ID
		book.setName(resultSet.getString(2)); // BOOK_NAME
		book.setPrice(resultSet.getDouble(4)); // BOOK_PRICE

		return book;
	}

}
