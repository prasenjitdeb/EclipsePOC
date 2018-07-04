package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

public class LoisBorrower extends testbase {
	By Edelivery=By.xpath("//*[@id='eDeliveryQuestionFieldset']/div/div[2]/label");
	By Reasson=By.name("eDeliveryOptOutReasonCode");
	By Property=By.xpath("//*[@id='BorrowerOwnedPropertyDiv_1']/fieldset/div/div[2]/label");
    By MaritalStatus=By.name("maritalStatus");
    By Dependents=By.name("numOfDependents");
    By YearsofEducation= By.name("yearsOfEducation");
    
    
    public void fillBorrowerInfo() throws Exception{

testbase.spinnerWait();
testbase.checkPageLoad("Borrower's Information");
testbase.setSelectCLick(Edelivery,"");
testbase.setSelectCLick(Reasson,"Visually impaired");
testbase.setSelectCLick(Property,"");
testbase.setSelectCLick(MaritalStatus,"Married");
testbase.setSelectCLick(Dependents,"0");
testbase.setSelectCLick(YearsofEducation,"13");
testbase.clickOnContinue();
testbase.spinnerWait();
    }
    		
}
