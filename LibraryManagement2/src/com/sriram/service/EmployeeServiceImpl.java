package com.sriram.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sriram.bean.Book;
import com.sriram.persistent.EmployeeDao;
import com.sriram.persistent.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao=new EmployeeDaoImpl();

//	@Override
//	public Book lendBook(int id) {
//		
//		return employeeDao.reserveBook(id);
//	}

	@Override
	public ArrayList<Book> showDataAnalytics() throws SQLException, ClassNotFoundException {
		
		return employeeDao.showAvailableDataAnalytics();
		
	}

	@Override
	public ArrayList<Book> showTechnology() throws SQLException, ClassNotFoundException{
		
		 return employeeDao.showAvailableTechnology();
	}
	
	@Override
	public ArrayList<Book> showManagement() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return employeeDao.showAvailableManagement();
	}
//
//	@Override
//	public ArrayList<Book> showManagement() {
//		
//		 return employeeDao.showAvailableManagement();
//	}
//
//	@Override
//	public boolean selectDataAnalytics(int id) {
//		
//		return employeeDao.selectDataAnalytics(id);
//		
//	}
//
//	@Override
//	public boolean selectTechnology(int id) {
//		
//		return employeeDao.selectTechnology(id);
//	}
//
//	@Override
//	public boolean selectManagement(int id) {
//		
//		return employeeDao.selectManagement(id);
//	}
//
//	@Override
//	public void returnBook(int id) {
//		
//		 employeeDao.returnBook(id);
//		
//	}

	@Override
	public boolean selectDataAnalytics(int id) throws ClassNotFoundException, SQLException {
	
		return employeeDao.selectDataAnalytics(id);
	}

	@Override
	public boolean selectTechnology(int id) throws ClassNotFoundException, SQLException {
		return employeeDao.selectTechnology(id);
	}

	@Override
	public boolean selectManagement(int id) throws ClassNotFoundException, SQLException {
		return employeeDao.selectDataAnalytics(id);
	}

	@Override
	public void updateTransaction(int empId,int bookId) throws ClassNotFoundException, SQLException{
		employeeDao.updateTransaction(empId,bookId);
		
	}

	@Override
	public boolean authenticate(String username, String password) throws ClassNotFoundException, SQLException {
		
		return employeeDao.authenticate(username,password);
	}

	@Override
	public boolean isValidEmployee(int empId) throws ClassNotFoundException, SQLException {
		
		return employeeDao.isValidEmployee(empId);
	}

	

	


	
}
