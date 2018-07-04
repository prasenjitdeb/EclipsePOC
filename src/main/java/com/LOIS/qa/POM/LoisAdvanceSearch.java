/**
 * 
 */
package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

/**
 * @all functions of advance search are handled here
 *
 */
public class LoisAdvanceSearch extends testbase {
	By loiscitiLname = By.id("LOISCitiLinkSearchLastName");
	By loiscitiSearch = By.xpath("//*[@id=\"LOISCitiLinkSearchBorrowerName\"]/button[1]");
	By loisCitiLinkSearch = By.xpath("//*[@id=\"headingThree\"]/h1");
	By loisFstCurSrc = By.xpath("//*[@id='loisResultsdataTable']/tbody/tr[2]/td[2]");
//By loisFstCustSrc = By.className("btn btn-link btn-double-chevron js-recordNumber js-Overflow-Tooltip text-ellipsis OverflowTextToolTipName");
	public void LoisAdSrc(String lname) throws InterruptedException{
		testbase.spinnerWait();
		testbase.setSelectCLick(loiscitiLname,lname);
		testbase.setSelectCLick(loiscitiSearch,"");
		Thread.sleep(2000);
		testbase.spinnerWait();
		Thread.sleep(2000);
		testbase.setSelectCLick(loisFstCurSrc,"");
		 
		
	}
	
}







