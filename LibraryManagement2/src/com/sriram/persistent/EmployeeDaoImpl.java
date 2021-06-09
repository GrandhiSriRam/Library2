package com.sriram.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.sriram.bean.Book;

import com.sriram.bean.Employee;
import com.sriram.helper.MySQLConnection;

public class EmployeeDaoImpl implements EmployeeDao{	

	@Override
	public ArrayList<Book> showAvailableDataAnalytics() throws SQLException, ClassNotFoundException{
		ArrayList<Book> books = null;
		Connection connection = MySQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from BOOKS where category=? and quantity>?");
		statement.setString(1, "DATA ANALYTICS");
		statement.setInt(2, 0);
		ResultSet resultset = statement.executeQuery();

		Book book = null;
		books = new ArrayList<Book>();
		
		while(resultset.next()) {
			book=new Book();
			book.setBookID(resultset.getInt("id"));
			book.setBookCategory(resultset.getString("category"));
			book.setTitle(resultset.getString("title"));
			book.setAuthor(resultset.getString("author"));
			book.setQuantity(resultset.getInt("quantity"));
			
			books.add(book);
		}
		connection.close();
		return books;
	}


	@Override
	public ArrayList<Book> showAvailableTechnology() throws SQLException, ClassNotFoundException {
		ArrayList<Book> books = null;
		Connection connection = MySQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from BOOKS where category=? and quantity>?");
		statement.setString(1, "TECHNOLOGY");
		statement.setInt(2, 0);
		ResultSet resultset = statement.executeQuery();

		Book book = null;
		books = new ArrayList<Book>();
		
		while(resultset.next()) {
			book=new Book();
			book.setBookID(resultset.getInt("id"));
			book.setBookCategory(resultset.getString("category"));
			book.setTitle(resultset.getString("title"));
			book.setAuthor(resultset.getString("author"));
			book.setQuantity(resultset.getInt("quantity"));
			
			books.add(book);
		}
		connection.close();
		return books;
	}
	
	@Override
	public ArrayList<Book> showAvailableManagement() throws SQLException, ClassNotFoundException {
		ArrayList<Book> books = null;
		Connection connection = MySQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from BOOKS where category=? and quantity>?");
		statement.setString(1, "MANAGEMENT");
		statement.setInt(2, 0);
		ResultSet resultset = statement.executeQuery();

		Book book = null;
		books = new ArrayList<Book>();
		
		while(resultset.next()) {
			book=new Book();
			book.setBookID(resultset.getInt("id"));
			book.setBookCategory(resultset.getString("category"));
			book.setTitle(resultset.getString("title"));
			book.setAuthor(resultset.getString("author"));
			book.setQuantity(resultset.getInt("quantity"));
			books.add(book);
		}
		connection.close();
		return books;
	}


	@Override
	public boolean selectDataAnalytics(int id) throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("update books set quantity=quantity-? where id=?");
		statement.setInt(1, 1);
		statement.setInt(2, id);
		
		int rows = statement.executeUpdate();

		if (rows > 0)
			return true;

		connection.close();
		return false;
	}


	@Override
	public boolean selectTechnology(int id) throws SQLException, ClassNotFoundException {
		
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("update books set quantity=quantity-? where id=?");
		statement.setInt(1, 1);
		statement.setInt(2, id);
		
		int rows = statement.executeUpdate();

		if (rows > 0)
			return true;

		connection.close();
		return false;
	}


	@Override
	public boolean selectManagement(int id) throws SQLException, ClassNotFoundException {
		
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("update books set quantity=quantity-? where id=?");
		statement.setInt(1, 1);
		statement.setInt(2, id);
		
		int rows = statement.executeUpdate();

		if (rows > 0)
			return true;

		connection.close();
		return false;
	}


	@Override
	public void updateTransaction(int empId,int bookId) throws SQLException,ClassNotFoundException {
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("insert into transaction values(?,?)");
		statement.setInt(1, empId);
		statement.setInt(2, bookId);
		
		
		
		
	}


	@Override
	public boolean authenticate(String username, String password) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select * from auth");
		
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()){
			if(username.equals(resultSet.getString(1)) && password.equals(resultSet.getString(2))) {
				return true;
			}
		}
		
		return false;
	}


	@Override
	public boolean isValidEmployee(int empId) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select id from employee");
		
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()){
			if(empId == Integer.parseInt(resultSet.getString(1))) {
				return true;
			}
		}
		return false;
	}
	
		
//		HashMap<Integer,Book>books=bookList.getBooks();
//		Collection<Book>bo=books.values();
//		
//		ArrayList<Book>data=new ArrayList<>();
//		for(Book b:bo) {
//			if(b.getBookType().equalsIgnoreCase("Data Analytics")) {
//				data.add(b);
//			}
//		}
//		return data;
//	}

//	@Override
//	public ArrayList<Book> showAvailableTechnology() throws SQLException, ClassNotFoundException{
//		HashMap<Integer,Book>books=bookList.getBooks();
//		Collection<Book>bo=books.values();
//		
//		ArrayList<Book>data=new ArrayList<>();
//		for(Book b:bo) {
//			if(b.getBookType().equalsIgnoreCase("Technology")) {
//				data.add(b);
//			}
//		}
//		return data;
//	}
//
//	@Override
//	public ArrayList<Book> showAvailableManagement() throws SQLException, ClassNotFoundException{
//		HashMap<Integer,Book>books=bookList.getBooks();
//		Collection<Book>bo=books.values();
//		
//		ArrayList<Book>data=new ArrayList<>();
//		for(Book b:bo) {
//			if(b.getBookType().equalsIgnoreCase("Management")) {
//				data.add(b);
//			}
//		}
//		return data;
//		
//	}
//
//	@Override
//	public boolean selectDataAnalytics(int id) throws SQLException, ClassNotFoundException{
//		HashMap<Integer,Book>books=bookList.getBooks();
//		Collection<Book>bo=books.values();
//		
//		for(Book b:bo) {
//			if(b.getBookID()==id) {
//				if(b.getQuantity()-1>=0) {
//					b.setQuantity(b.getQuantity()-1);
//					return true;
//				}		
//			}
//		}	
//		return false;
//	}
//
//	@Override
//	public boolean selectTechnology(int id) throws SQLException, ClassNotFoundException{
//		HashMap<Integer,Book>books=bookList.getBooks();
//		Collection<Book>bo=books.values();
//		
//		for(Book b:bo) {
//			if(b.getBookID()==id) {
//				if(b.getQuantity()-1>=0) {
//					b.setQuantity(b.getQuantity()-1);
//					return true;
//				}		
//			}
//		}	
//		return false;
//	}
//
//	@Override
//	public boolean selectManagement(int id) {
//		HashMap<Integer,Book>books=bookList.getBooks();
//		Collection<Book>bo=books.values();
//		
//		for(Book b:bo) {
//			if(b.getBookID()==id) {
//				if(b.getQuantity()-1>=0) {
//					b.setQuantity(b.getQuantity()-1);
//					return true;
//				}		
//			}
//		}	
//		return false;
//	}

//	@Override
//	public void returnBook(int id) {
//		HashMap<Integer,Book>books=bookList.getBooks();
//		Collection<Book>bo=books.values();
//		for(Book b:bo) {
//			if(b.getBookID()==id) {
//				b.setQuantity(b.getQuantity()+1);	
//			}
//		}
//		System.out.println(books);
//		
//	}

	
}
