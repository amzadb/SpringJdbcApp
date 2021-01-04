package com.spring.practice;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookMapperTest {

	public static void main(String[] args) {
		JdbcTemplate template = JdbcUtil.getJdbcTemplate();
		List<Book> books = listBooks(template);
		printBooks(books);
	}

	private static void printBooks(List<Book> books) {
		for (Book book : books) {
			System.out.println("ID: " + book.getId() + "\t Name: " + book.getName() + "\t Price: " + book.getPrice());
		}
	}

	private static List<Book> listBooks(JdbcTemplate template) {
		String sqlQuery = "select * from BOOK";
		List<Book> books = template.query(sqlQuery, new BookMapper());
		return books;
	}

}
