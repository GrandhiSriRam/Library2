package com.sriram.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sriram.bean.Book;

public interface EmployeeService {
//	Book lendBook(int id);
	ArrayList<Book> showDataAnalytics() throws ClassNotFoundException, SQLException;
	ArrayList<Book> showTechnology() throws ClassNotFoundException, SQLException;
	ArrayList<Book> showManagement() throws ClassNotFoundException, SQLException;
	boolean selectDataAnalytics(int id) throws ClassNotFoundException, SQLException;
	boolean selectTechnology(int id) throws ClassNotFoundException, SQLException;
	boolean selectManagement(int id) throws ClassNotFoundException, SQLException;
//	void returnBook(int id);
//	void returnBook();
//	ArrayList<Book> viewAllBooks();
	void updateTransaction(int empId,int bookId) throws ClassNotFoundException, SQLException;
	boolean authenticate(String username, String password) throws ClassNotFoundException, SQLException;
	boolean isValidEmployee(int empId) throws ClassNotFoundException, SQLException;
}
