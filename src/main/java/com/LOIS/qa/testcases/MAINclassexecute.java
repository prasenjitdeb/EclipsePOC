
package com.LOIS.qa.testcases;

//Import all the classes



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LOIS.qa.POM.LoisAdvanceSearch;
import com.LOIS.qa.POM.LoisBorrower;
import com.LOIS.qa.POM.LoisCreditPages;
import com.LOIS.qa.POM.LoisEQT;
import com.LOIS.qa.POM.LoisEmployment;
import com.LOIS.qa.POM.LoisGovtMonitoring;
import com.LOIS.qa.POM.LoisHome;
import com.LOIS.qa.POM.LoginPage;
import com.LOIS.qa.POM.LoisIncomeAssetDeclaration;
import com.LOIS.qa.POM.LoisMortgageSummary;
import com.LOIS.qa.POM.LoisPropertyInformation;
import com.LOIS.qa.POM.Loisdashboard;
import com.LOIS.qa.POM.ProductSelection;
import com.LOIS.qa.base.testbase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class MAINclassexecute extends testbase { 
       
       //variable declaration
                
 // public  static String Url,role,excelpath,sheetname,CurrentTitle,selection,proccntr,proptype,propdesc,propuse,entity,chnl,branch,subchnl;
   
                                // TODO Auto-generated method stub
                     
        testbase a=new testbase();  
        
        @Given("^Login to LOIS$")
        public void login_to_LOIS() throws Exception{
        	
        	
        a.initialize();
        a.readExceldata();
          
      //###################################Open URL##########################################   
         driver.get(prop.getProperty(testbase.Url));
         
              
              
     //#############################Login functionality #################################################
              
              LoginPage login1=new LoginPage();
              login1.setUsernamePwd(testbase.role);
              
              if (driver.findElement(login1.Uname).isDisplayed()){
                if(driver.findElement(login1.Pwd).isDisplayed()){
                       if(driver.findElement(login1.Signon).isDisplayed()){
                             
                               login1.login(login1.UserName,login1.Password);
                       }
                }
              }
                            
                             
                             CurrentTitle=driver.getTitle();
                             
                             if(CurrentTitle.equals("LOIS")){
                                    System.out.println("Lois login sucessfull");
                             }
                             else{
                                    System.out.println("Lois login unsucessfull");
                                    System.exit(0);
                                    
                             }
        }
        
        @When("^Navigate to Home page$")
        public void navigate_to_Home_page() throws InterruptedException{
        	
                             
   WebDriverWait wait = new WebDriverWait(driver, 30);

   WebElement Elementhome = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='homeLink']")));
  
   LoisHome loisHomePage= new LoisHome();
   
   

   if(driver.findElements(By.id("EditProfileSave")).size()!=0){
        System.out.println(driver.findElements(By.id("EditProfileSave")).size());
        Thread.sleep(2000);                     
        Elementhome.click();
                              
              }
                                   
                  else{
                        System.out.println("user already in Home Screen");
                            }
   
                           testbase.checkPageLoad("Home: Your Personalized Dashboard");
                         
        }           
                           //############Click On Advance Search screen###################################
        @When("^search customer in advance search screen$")
        public void search_customer_in_advance_search_screen() throws InterruptedException{
        	
        	 LoisHome loisHomePage= new LoisHome();
        	
                           Thread.sleep(2000);
                           loisHomePage.clkOnAdvSrc();
                           
                           Thread.sleep(2000);
                           testbase.checkPageLoad("Advanced Search");
                           
                      
                           //##########Search for a Customer in Advance screen#############################
                           LoisAdvanceSearch LoisAdvSrch = new LoisAdvanceSearch();
                           
                           LoisAdvSrch.LoisAdSrc(testbase.lastName);
                           
        }
                          //##############Select Flow####################################################### 
                          
        
        @Then("^Start a scenario$")
        public void start_a_scenario() throws Exception{
        	
        Loisdashboard dashboard= new Loisdashboard();
                           dashboard.startScenario(testbase.selection);
                           testbase.spinnerWait();
                           
                           
                           
                           //################### Fill all the information in EQT page###############################################
                           testbase.checkPageLoad("Purchase");
                           LoisEQT eqt=new LoisEQT();
                           eqt.fillEQTPage(testbase.entity , testbase.chnl , testbase.subchnl , testbase.branch , testbase.proccntr , testbase.proptype , testbase.propdesc , testbase.propuse );
                          
                           
                           
                           //##########Product Selection##################################
                           //testbase.checkPageLoad("PST");
                           ProductSelection pd=new ProductSelection ();
                           pd.productSelection();
                           
                           
                           
                           
                           //#########Borrower############################################
                           LoisBorrower brw=new LoisBorrower();
                           brw.fillBorrowerInfo();
                           
                           
                           //##########Credit Pages#######################################
                           
                           LoisCreditPages credit=new LoisCreditPages();
                           credit.orderCredit();
                           
                           
                           
                           
                           //#########Property Information###############################
                           
                           LoisPropertyInformation prop=new LoisPropertyInformation();
                           prop.fillPropertyInfo();
                           
                           
                           //#########Employment#########################################
                           LoisEmployment emp=new LoisEmployment();
                           emp.fillEmploymentInfo();
                           
                           //#########Income,Asset and Declaration#############################################
                           
                           LoisIncomeAssetDeclaration Inc=new LoisIncomeAssetDeclaration();
                           Inc.fillIncomeInfo();
                           
                           //#########Govt Monitoring#################################
                           LoisGovtMonitoring gvt=new LoisGovtMonitoring();
                           gvt.fillgovtMonitoring();
                           //#########SubmitTOLPM####################################
                           
                           LoisMortgageSummary mtg=new LoisMortgageSummary();
                           mtg.submitToLPM();
                           //#########Close Browser##################################
                           testbase.spinnerWait();
                           driver.quit();
                           
        }
                           
    }
    
    
    
    

                       









