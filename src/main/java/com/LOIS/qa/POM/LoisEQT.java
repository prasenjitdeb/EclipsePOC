/**
 * 
 */
package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

/**
 * @author Lois EQT page is handled
 *
 */
public class LoisEQT  extends testbase{
	By sEntitysource= By.name("source.entity");
	By sEntityChannel= By.name("source.channel");
	By sEntitySubchannel= By.name("source.subChannel");
	By sEntityBranch= By.name("source.branch");
	By sEntityprocessingCenter= By.name("source.processingCenter");
	By sSourceLookup= By.id("EQTPrimarySourceLookup");
	By iSn= By.xpath("//*[@id='resultsTable']/tbody/tr[1]/td[4]");
	By iSnAddSource= By.id("addSource");
	By spromationcode= By.name("source.promoCode");
	By propertyZip= By.name("propertyAddress.zipCode");
	By propertyType= By.name("propertyInformation.type");
	By propertydescription= By.name("propertyInformation.description");
	By propertyUse= By.name("propertyInformation.usage");
	By purchaseprice= By.name("dma.firstMortgage.purchasePrice");
	By calculateLTV= By.id("calculateLTV");
	By creditScore= By.name("mortgageInformation.actualCreditScore");
	By selEctproduct=By.xpath("//*[@id='ProductOptionsDiv']/div/div[2]/div[1]/div[2]/div/fieldset/div[1]/div[1]/label");
	By iNcome= By.xpath("//*[@id='IncomeExpensesHeading']/h1");
	By BaseIncome= By.id("BASE1_Text");
	By GetProducts= By.id("scenario-bottomnav-runrss");
	By relationship=By.xpath("//*[@id='relationshipOfferDiv']/div/div/fieldset/div[2]/label");
	
	
	public void fillEQTPage(String entity,String channel,String subchannel,String branch,String processingcenter,String Protype,String propertydesc,String proUse) throws InterruptedException{
		
		if(driver.findElements(relationship).size()!=0){
			if(driver.findElement(relationship).isDisplayed()){
			System.out.println(driver.findElements(relationship).size());
		testbase.setSelectCLick(relationship,"");
			}
		}
		else{
			System.out.println("relationship not present");
		}
		
		
		
		testbase.setSelectCLick(sEntitysource, entity);
		testbase.setSelectCLick(sEntityChannel, channel);
		testbase.setSelectCLick(sEntitySubchannel, subchannel);
		testbase.setSelectCLick(sEntityBranch, branch);
		testbase.setSelectCLick(sEntityprocessingCenter, processingcenter);
		testbase.setSelectCLick(sSourceLookup,"");
		testbase.spinnerWait();
		Thread.sleep(7000);
		testbase.setSelectCLick(iSn,"");
		testbase.setSelectCLick(iSnAddSource,"");
		testbase.setSelectCLick(spromationcode,"ACQ15 - ACQ $1500 off closing costs");
		testbase.setSelectCLick(propertyZip,"74132");
		testbase.setSelectCLick(propertyType, Protype);
		testbase.setSelectCLick(propertydescription, propertydesc);
		testbase.setSelectCLick(propertyUse, proUse);
		testbase.setSelectCLick(purchaseprice,"60000");
		testbase.setSelectCLick(calculateLTV,"");
		testbase.setSelectCLick(creditScore,"750");
		testbase.setSelectCLick(selEctproduct,"");
		testbase.setSelectCLick(iNcome,"");
		testbase.setSelectCLick(BaseIncome,"760000");
		testbase.setSelectCLick(GetProducts,"");
		
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	









