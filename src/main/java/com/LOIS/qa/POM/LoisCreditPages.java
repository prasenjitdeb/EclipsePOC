package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

public class LoisCreditPages extends testbase {
	By Permission=By.xpath("//*[@id='CreditPullConsentSection']/div/div/div/div[1]/label");
	By Confirm=By.xpath("//*[@id='NavigationalModal']/div/div/div[3]/button[2]");
	
	
	public void orderCredit() throws Exception{
		
		testbase.spinnerWait();
		testbase.checkPageLoad("Order Credit");
		testbase.setSelectCLick(Permission,"");
		Thread.sleep(3000);
		testbase.clickOnContinue();
		testbase.spinnerWait();
		Thread.sleep(3000);
		testbase.setSelectCLick(Confirm,"");
		testbase.spinnerWait();
		Thread.sleep(3000);
		testbase.spinnerWait();
		testbase.checkPageLoad("Credit Report");
		testbase.clickOnContinue();
		testbase.spinnerWait();
		testbase.checkPageLoad("Credit Pull History");
		testbase.clickOnContinue();
		testbase.spinnerWait();
		testbase.checkPageLoad("Credit Summary");
		testbase.clickOnContinue();
		testbase.spinnerWait();
		
		
	}
}





