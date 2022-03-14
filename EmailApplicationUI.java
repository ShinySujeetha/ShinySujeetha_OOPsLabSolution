package com.greatlearning.emailapp.ui;
import java.util.Scanner;
import com.greatlearning.emailapps.*;
import com.greatlearning.emailapp.service.*;
public class EmailApplicationUI {
	
	    public void init() {
	    	Employee employee=buildUI();
	    	call(employee);
	    }
	
	    private Employee buildUI() {
	    	welcomeSection();
	    	Employee employee=buildUserDetails();
	    	return employee;
	    }
	
		private void welcomeSection(){
		System.out.println("************************");
		System.out.println("Welcome to EmailApp..!!!");
		System.out.println("************************");
		System.out.println();
		}
		
		private Employee buildUserDetails() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your first name");
		String firstName=sc.next();
		System.out.println("Enter your last name");
		String lastName=sc.next();
		System.out.println();
		
		System.out.println("Please enter the department from the following");
		System.out.println("1.Technical" + "\n2.Admin" + "\n3.Human Resources" + "\n4.Legal");
		System.out.println("Enter the option as 1/2/3/4");
		int departmentId=sc.nextInt();
		String department=getDepartment(departmentId);
		Employee employee=new Employee(firstName,lastName,department);
		
		sc.close();
		return employee;
	}	
				
		private String getDepartment(int departmentId) {
		
		switch(departmentId){
		
		case 1:return "Technical";
		case 2:return "Admin";
		case 3:return "Human Resources";
		case 4:return "Legal";	
		
		}
		return "";
			
		}
		
		private void call(Employee employee) {
			CredentialService credentialService=new CredentialService(employee);
			
			credentialService.generateEmail();
			credentialService.generatePassword();
			credentialService.showCredentials();
			
			
			
		}

}
