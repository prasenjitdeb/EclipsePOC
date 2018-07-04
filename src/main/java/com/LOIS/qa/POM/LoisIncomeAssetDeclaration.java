package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

public class LoisIncomeAssetDeclaration extends testbase {
	
	By Income=By.id("BASE1_Text");
	
	
	
	public void fillIncomeInfo() throws Exception{
		
		
        testbase.spinnerWait();
        testbase.checkPageLoad("Income");
		testbase.setSelectCLick(Income, "78000");
		testbase.clickOnContinue();
		testbase.spinnerWait();
		testbase.checkPageLoad("Asset Information");
		testbase.clickOnContinue();
		testbase.spinnerWait();
		testbase.checkPageLoad("Declarations");
		testbase.clickOnContinue();
	}

}
