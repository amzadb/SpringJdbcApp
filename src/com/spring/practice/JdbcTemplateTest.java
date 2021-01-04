package com.spring.practice;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {

	public static void main(String[] args) {
		JdbcTemplate template = JdbcUtil.getJdbcTemplate();

//		List<?> books = listBooks(template);
//		printBooks(books);
		
//		insertPublisher(template);
//		updatePublisher(template);
		//deletePublisher(template);
		
		List<?> publishers = listPublishers(template);
		printPublishers(publishers);

	}

	private static void deletePublisher(JdbcTemplate template) {
		String sqlQuery = "delete from PUBLISHER where PUB_ID = ?";
		template.update(sqlQuery, new Object[] { 6 });		
	}

	private static void updatePublisher(JdbcTemplate template) {
		String sqlQuery = "update PUBLISHER set PUB_NAME = ? where PUB_ID = ?";
		template.update(sqlQuery, new Object[] { "China Publishers", 6 });		
	}

	private static void insertPublisher(JdbcTemplate template) {
		String sqlQuery = "insert into PUBLISHER (PUB_ID, PUB_NAME) values (?, ?)";
		template.update(sqlQuery, new Object[] { 6, "Corona Publishers" });		
	}

	private static void printPublishers(List<?> publishers) {
		publishers.forEach(publisher -> System.out.println(publisher));		
	}

	private static List<?> listPublishers(JdbcTemplate template) {
		String sqlQuery = "select * from PUBLISHER";
		List<?> publishers = template.queryForList(sqlQuery);
		return publishers;
	}

	private static void printBooks(List<?> books) {
		books.forEach(book -> System.out.println(book));
	}

	private static List<?> listBooks(JdbcTemplate template) {
		String sqlQuery = "select * from BOOK";
		List<?> books = template.queryForList(sqlQuery);
		return books;
	}

}
