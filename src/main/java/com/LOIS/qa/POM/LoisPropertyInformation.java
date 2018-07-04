package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

public class LoisPropertyInformation extends testbase {
	
	 By Tiitle=By.id("MannerTitleHeldSelect");
	 By Rent= By.xpath("//*[@id='ClosingDetails']/div/div[2]/div/div/fieldset/div[2]/label");		 

	
	
	public void fillPropertyInfo() throws Exception{
		testbase.spinnerWait();
		testbase.checkPageLoad("Property Information");
		testbase.setSelectCLick(Tiitle, "A Married Person");
		testbase.setSelectCLick(Rent, "");
		testbase.clickOnContinue();
		testbase.spinnerWait();
	}
}
