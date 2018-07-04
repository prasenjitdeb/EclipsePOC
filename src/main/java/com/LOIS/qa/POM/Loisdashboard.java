package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

public class Loisdashboard extends testbase{
	
	By customerContactCorrect = By.id("validateCustomer");
	By startapurchase = By.id("startPurchaseScenario");
	
	
	public void startScenario(String selection) throws InterruptedException{
		Thread.sleep(6000);
		if (driver.findElements(customerContactCorrect).size()!=0){
			testbase.setSelectCLick(customerContactCorrect, "");
		}
		
		switch (selection.toLowerCase()){
		case "purchase":
			testbase.setSelectCLick(startapurchase, "");
			testbase.spinnerWait();
		break;
		
		 default:
             System.out.println("invalid selection");
             break;
		
		}
		
		
	}
}

