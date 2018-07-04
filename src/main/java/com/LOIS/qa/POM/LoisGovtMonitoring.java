package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

public class LoisGovtMonitoring extends testbase {

	By Application= By.name("applicationTakenCode");
	By Sex=By.xpath("//*[@id='borrower-1-Sex-Group']/div[1]/label");
	By Ethinticity=By.xpath("//*[@id='borrower-1-Ethnicity-Group']/div[2]/label");
	By Race=By.xpath("//*[@id='borrower-1-Race-Group']/div[5]/label");
	
	
	public void fillgovtMonitoring() throws Exception{

testbase.spinnerWait();
testbase.checkPageLoad("Government Monitoring Information");
testbase.setSelectCLick(Application, "Internet");
testbase.setSelectCLick(Sex, "");
testbase.setSelectCLick(Ethinticity, "");
testbase.setSelectCLick(Race, "");
testbase.clickOnContinue();
testbase.spinnerWait();
	}
}
