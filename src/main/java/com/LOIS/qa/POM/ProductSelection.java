package com.LOIS.qa.POM;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LOIS.qa.base.testbase;

public class ProductSelection extends testbase {

	By Apply=By.xpath("//*[@id='applyButton']");
	By Continue=By.xpath("//*[@id='inconclusiveProductModal']/div/div/div[3]/button[1]");
	  WebElement ApplyB;
	
	public void productSelection() throws Exception{
		
		Thread.sleep(30000);
		//testbase.checkPageLoad("Government Monitoring Information");
		WebElement ApplyButton=driver.findElement(Apply);
		
//		 WebDriverWait wait = new WebDriverWait(driver, 30000);
//    	 
//	   	  ApplyB=wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(ApplyButton));
		
		ApplyButton.click();
		
		testbase.spinnerWait();
		Thread.sleep(3000);
		if(driver.findElements(Continue).size()!=0){
			testbase.setSelectCLick(Continue,"");
			testbase.spinnerWait();
		}
	}
}
