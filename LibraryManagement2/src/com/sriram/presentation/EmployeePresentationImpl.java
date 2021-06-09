package com.sriram.presentation;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import com.sriram.bean.Book;
import com.sriram.service.EmployeeService;
import com.sriram.service.EmployeeServiceImpl;


public class EmployeePresentationImpl implements EmployeePresentation{
	
	Scanner sc=new Scanner(System.in);
	private EmployeeService employeeService=new EmployeeServiceImpl();

	@Override
	public void showMenuEmp() {
		
		System.out.println("1. Lend a book");
		System.out.println("2. Return a book");
		System.out.println("3. View all books");
		System.out.println("4. Exit");
		
	}
	
	@Override
	public boolean authenticate(String username, String password) {
		
		try {
			if(employeeService.authenticate(username,password)) {
				System.out.println("Login successfull");
				return true;
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void performMenuEmp(int choice) {
		System.out.println("Enter you ID");
		int empId=sc.nextInt();sc.nextLine();
		try {
			if(employeeService.isValidEmployee(empId)) {
				switch(choice) {
				case 1:
					System.out.println("Please enter the type of book you want:\na. Data Analytics\nb. Technology\nc. Management");
					String s=sc.next();
					if(s.equals("a")) {
						ArrayList<Book>books=null;
						try {
							books = employeeService.showDataAnalytics();
						} catch (ClassNotFoundException | SQLException e) {
							
							e.printStackTrace();
						}
						
						for(Book b:books) {
							System.out.println(b);
						}
						System.out.println("=============================================================================");
						System.out.println("Please select the book id from the above available books");
						System.out.println("=============================================================================");
						int id=sc.nextInt();
						
						
						boolean success=true;
						try {
							success=employeeService.selectDataAnalytics(id);
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						if(success) {
							System.out.println("Book issued successfully!!");
							try {
								employeeService.updateTransaction(empId,id);
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
						}
						else {
							System.out.println("Book issue failed!!");
						}
					}
					else if(s.equals("b")) {
						ArrayList<Book>books=null;
						try {
							books = employeeService.showTechnology();
						} catch (ClassNotFoundException | SQLException e) {
							
							e.printStackTrace();
						}
						
						for(Book b:books) {
							System.out.println(b);
						}
						
						System.out.println("Please select the book id from the above available books");
						int id=sc.nextInt();
				
						boolean success=true;
						try {
							success=employeeService.selectDataAnalytics(id);
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						if(success) {
							System.out.println("Book issued successfully!!");
							try {
								employeeService.updateTransaction(empId,id);
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
						}
						else {
							System.out.println("Book issue failed!!");
						}
					}
					else if(s.equals("c")) {
						ArrayList<Book>books=null;
						try {
							books = employeeService.showManagement();
						} catch (ClassNotFoundException | SQLException e) {
							
							e.printStackTrace();
						}
						
						for(Book b:books) {
							System.out.println(b);
						}
						System.out.println("Please select the book id from the above available books");
						int id=sc.nextInt();
				
						boolean success=true;
						try {
							success=employeeService.selectDataAnalytics(id);
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						if(success) {
							System.out.println("Book issued successfully!!");
							try {
								employeeService.updateTransaction(empId,id);
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
						}
						else {
							System.out.println("Book issue failed!!");
						}
					}	
						break;
				case 4:
					System.exit(0);
			
				}
			}
			else {
				System.out.println("Please enter valid id");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
