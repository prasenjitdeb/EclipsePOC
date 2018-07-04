package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

public class LoisEmployment extends testbase {
	
	By Employment=By.name("employmentStatusCode");
	By Years=By.name("currentEmpYears");
	By Months=By.name("currentEmpMonths");
	
	
	
	
	
	public void fillEmploymentInfo() throws Exception{
		

		testbase.spinnerWait();
		testbase.checkPageLoad("Employment Information");
		testbase.setSelectCLick(Employment, "Unemployed");
		testbase.spinnerWait();
		testbase.setSelectCLick(Years, "12");
		testbase.setSelectCLick(Months, "03");
		testbase.clickOnContinue();
		
		
		
	}
	
	
	
	

}
