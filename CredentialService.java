package com.greatlearning.emailapp.service;
import com.greatlearning.emailapps.*;

import java.util.Random;


public class CredentialService {
	     private String generatedEmailId;
	     private char[] generatedPassword=new char[8];
	     private Employee employee;
	    
	    public CredentialService(Employee employee) {
	    	this.employee=employee;
		}
	    private String getDepartmentShortName() {
	    	String departmentName=employee.getDepartment();
	    	switch(departmentName) {
	    	case "Technical" :return "tech";
	    	case "Admin" :return "admin";
	    	case "Human Resources" :return "hr";
	    	case "Legal" :return "legal";
	    	}
	    	return "";
	    }
		public void generateEmail(){		
			String departmentShortName=getDepartmentShortName();
			String emailId=employee.getFirstName().toLowerCase() + "." +employee.getLastName().toLowerCase() +"@" +departmentShortName+".abc.com";
			this.generatedEmailId=emailId;
		}
		
		public void generatePassword() {	
				
			String capitalLetters="ABCDEFGHIJKLMNOPQRSTUVWXWZ";
			String smallLetters="abcdefghijklmnopqrstuvwxyz";
			String number="0123456789";
			String specialCharacter="!@#$%^&*_?.<>";
			String allValues=capitalLetters+smallLetters+number+specialCharacter;
			
			Random randomObj=new Random();
			
			for(int i=0;i<8;i++) {
				int boundValue=allValues.length();
				int randomIndex=randomObj.nextInt(boundValue);
				char randomChar=allValues.charAt(randomIndex);
				this.generatedPassword[i]=randomChar;
			}
		}
		public void showCredentials() {
			System.out.println("Dear " +employee.getFirstName() +" your generated credentials are as follows" );
			System.out.println("Email Id: " +generatedEmailId);
			System.out.print("Password:");
			System.out.print(generatedPassword);
		}


}
