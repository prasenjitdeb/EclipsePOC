/**
 * 
 */
package com.LOIS.qa.POM;

import org.openqa.selenium.By;

import com.LOIS.qa.base.testbase;

/**
 * @All functions of Home page
 *
 */
public class LoisHome  extends testbase{
By advanceSrc= By.id("advSearchLink");

public void clkOnAdvSrc() throws InterruptedException{
testbase.setSelectCLick(advanceSrc,"");
}
	
}
