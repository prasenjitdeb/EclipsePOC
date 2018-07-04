package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

public class LoginPage extends testbase {
	
	
	public By Uname = By.name("USER");
	public By Pwd =   By.name("PASSWORD");
	public By Signon = By.id("sign"); 
	public String UserName;
	public String Password;
	
	//Set Username and Password for LOIS depends on Role
	
	public void setUsernamePwd(String Role){
		 
    	
    	switch (Role)
    	{
    		case "MC": 
    			UserName=prop.getProperty("MCusername");
    			Password=prop.getProperty("MCpassword");
    			break;
    		
    		case "Manager":
    		 UserName=prop.getProperty("Mgrusername");
            Password=prop.getProperty("Mgrpassword");
            break;
    		
    		case "SA1":
    			 UserName=prop.getProperty("SA1username");
            	 Password=prop.getProperty("SA1password");
            	 break;
    		
    		case "SA2":
    		UserName=prop.getProperty("SA2username");
            Password=prop.getProperty("SA2password");
            break;
    		
    		
    	}
	}
	
	//login to LOIS using username and password
	
	public void login(String Username, String Password) throws InterruptedException {
		
		
		testbase.setSelectCLick(Uname, Username);
		testbase.setSelectCLick(Pwd, Password);
		testbase.setSelectCLick(Signon, "");
		Thread.sleep(4000);
	
		
	}
}
