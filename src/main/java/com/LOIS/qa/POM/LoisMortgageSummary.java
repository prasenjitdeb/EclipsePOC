package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;
import com.LOIS.qa.utilities.Utilities;

public class LoisMortgageSummary extends testbase {
	
	By submit=By.id("submitToLPM");
	By lock=By.id("lockModalContinueButton");
	By SignOut=By.id("signout");
	     
	public void submitToLPM() throws Exception{
		testbase.spinnerWait();
		testbase.checkPageLoad("Mortgage Request Summary");
		testbase.setSelectCLick(submit,"");
		testbase.spinnerWait();
		Thread.sleep(3000);
		testbase.setSelectCLick(lock,"");
		testbase.spinnerWait();
		testbase.loanNumber=driver.findElements(By.xpath("//div[@class='col-xs-12']/p")).get(1).getText();
		String[] loannoline=driver.findElements(By.xpath("//div[@class='col-xs-12']/p")).get(1).getText().split("\\s+");
		//System.out.println("hello2"+driver.findElements(By.xpath("//div[@class='col-xs-12']/p")).get(1).getText());
		testbase.loanNumber= loannoline[loannoline.length-1];
		System.out.println("LOIS LOAN NUMBER:" +testbase.loanNumber);
		Utilities.screenPrint("LOIS LOAN NUMBER:"+testbase.loanNumber, testbase.loanNumber);
		
		Thread.sleep(3000);
		testbase.setSelectCLick(SignOut,"");
	//	testbase.spinnerWait();
	}

}
