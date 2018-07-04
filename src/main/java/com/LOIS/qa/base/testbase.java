package com.LOIS.qa.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LOIS.qa.testdata.readexceldata;
import com.LOIS.qa.utilities.Utilities;
import com.google.common.base.Function;

public class testbase
{ 
		public static XWPFDocument doc=new XWPFDocument();
	 	public static XWPFParagraph p;
	 	public static XWPFRun r;
	 	public static FileInputStream pic;
	 	public static FileOutputStream out;
	 	public static File src;
        public static  File scrFile;  
        public static String loanNumber;
	    public static WebDriver driver;
        public static Properties prop;
        public static Utilities ul=new Utilities();
                
        public static boolean elementFound;
        public  readexceldata readData;
        public  int reqrow;
        public static By Next=By.id("scenario-bottomnav-next");
                
        public static String Url,role,excelpath,sheetname,CurrentTitle,selection,proccntr,proptype,propdesc,propuse,entity,chnl,branch,subchnl,lastName;
                
                
                //Instantiate properties
                
                public testbase()
                {
                                prop=new Properties();
                                try {
                                                
                                                FileInputStream input= new FileInputStream(".\\Config\\config.properties");
                                                prop.load(input);
                                    } 
                                catch (FileNotFoundException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                } catch (IOException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                                
                                
                                
                                
                                
                 
                }
                
                
                //Instantiate properties
                
                public void initialize()
                {
                    String browsertype=prop.getProperty("browser"); 
                    String chromedriver=prop.getProperty("ChromeDriver");
                    switch (browsertype)
                    {
                                case "chrome":
                                                System.setProperty("webdriver.chrome.driver",chromedriver);
                                                driver=new ChromeDriver();                                      
                                                break;

                                default:
                                                System.out.println("Not a valid browser");
                                                break;
                                }
                    
                   
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageloadtimeout")), TimeUnit.SECONDS);
                    driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitwaittimeout")), TimeUnit.SECONDS);
                    
                  
                    
                    
                    
        }
                
                
    //Set Explicit wait
                
    public WebElement Explicitwait(WebElement Element,int timeTowait){
    WebDriverWait wait = new WebDriverWait(driver, timeTowait);
    	 
   	  WebElement Element1=wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(Element));
   	  return Element1;
   	  
   	  
   	  
    }
    
    //Action performed by different WebElement
    
    public static void setSelectCLick(By locator, String value) throws InterruptedException
    {
       testbase.spinnerWait();
         String tagOfLocator=driver.findElement(locator).getTagName();
         
         switch (tagOfLocator.toLowerCase())
         {
            case "input":
            		 driver.findElement(locator).sendKeys(value);
                 
                      
            	
                  
                  break;
            
            case "a":case "td":case "button":case "label":case "h1":
                     
            		 driver.findElement(locator).click();
                 
                      
            	
                  
                      break;
                
            case "select":
                
                WebElement dropdown= driver.findElement(locator);
                Select select= new Select(dropdown);
                List<WebElement> options= select.getOptions();
                System.out.println(options.size());
                for(int i=0; i<options.size(); i++)
                {
                            String optionsvalue =options.get(i).getText();
                            System.out.println(options.get(i).getText());
                            if(optionsvalue.contains(value))
                            {
                                            options.get(i).click();
                                           
                                            break;
                            }
                }

                break;
                
              default:
                     System.out.println("Not a valid tag");
                     break;
            
            
            
         }
 
       

}
 
    //Click on Continue Button
    
    public static void clickOnContinue() throws Exception{
    	testbase.setSelectCLick(Next,"");
    }
    
    //ADD wait for spinner
    
    @SuppressWarnings("deprecation")
	public static void spinnerWait() throws InterruptedException
    {
       
       FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
              wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
              wait.withTimeout(500, TimeUnit.SECONDS);
              wait.ignoring(NoSuchElementException.class);

              Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
                           {
                                  public Boolean apply(WebDriver arg0) {
                                         List<WebElement> spinncollectn=driver.findElements(By.className("spinner"));
                                         int spincount =spinncollectn.size();
                                         
                                         if(spincount==1)
                                         {
                                                if(!spinncollectn.get(0).isDisplayed())
                                                {
                                                   return true;
                                                }
                                                else
                                                {
                                                       return false;
                                                }
                                         }
                                         else
                                         {
                                                return true;
                                         }
                                         
                                  }
                           };

              wait.until(function);
    }


    //Check Page Load
    
    @SuppressWarnings("deprecation")
	public static boolean checkPageLoad(String pageName) throws InterruptedException
    {
      
    	
    	elementFound=false; 
       Thread.sleep(5000);
              testbase.spinnerWait();
       FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
              wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
              wait.withTimeout(50, TimeUnit.SECONDS);
              wait.ignoring(NoSuchElementException.class);

              Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
                           {
                                  public Boolean apply(WebDriver arg0) {
                                         String actualPageName=driver.findElement(By.xpath("//*[starts-with(@class,'page-title')]")).getText();
                                         
                                         if(pageName.equals("PST"))
                                         {
                                        	 switch (testbase.role)
                                        	 {
                                        	     case "SA1":
                                        	     case "SA2":
                                        	    	 //logic for SA1 and SA2
                                        		   break;
                                        		 default:
                                        			  if (driver.findElements(By.xpath("//*[@id='applyButton']")).size()>=1)
                                        			  {
                                        				  elementFound=true;
                                        				  System.out.println("Product selection screen sucessfully opened");
                                        				  
                                        				//  System.out.println("hello"+driver.findElements(By.xpath("//*[@id='applyButton']")).size());
                                        			  }
                                        			 // System.out.println("hello"+driver.findElements(By.xpath("//*[@id='applyButton']")).size());
                                        			 break;
                                        	 }
                                           return elementFound;
                                         }
                                        else if(actualPageName.equals(pageName))
                                         {
                                                elementFound=true;
                                                System.out.println("Page "+actualPageName+" is displayed successfully");
                                                try {
													
													Utilities.screenPrint(actualPageName, actualPageName);
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
                                                return true;
                                                
                                         }
                                         else
                                         {
                                                return false;
                                         }
                                         
                                         
                                  }
                           };

              wait.until(function);
              
              return elementFound;
       
    }

    //Read Excel Data 
    
    public void readExceldata() throws Exception{
    	excelpath=prop.getProperty("Excelpath");
        sheetname=prop.getProperty("SheetName");
       
   
        readData=new readexceldata(excelpath);
        reqrow= readData.getrowbypurpose(sheetname, "LOIS_FOURTEEN_MKT");
        
        //#######################Read Excel data #####################################################
        
        if (reqrow!=-1)
             
       {
            Url=readData.getcelldata(sheetname, reqrow, "sEnvironment") ;
            role=readData.getcelldata(sheetname, reqrow, "Role");
            selection = readData.getcelldata(sheetname, reqrow, "Flow");
            proptype = readData.getcelldata(sheetname, reqrow, "sPropType");
            propdesc = readData.getcelldata(sheetname, reqrow, "sPropDesc");
            propuse = readData.getcelldata(sheetname, reqrow, "sPropUse");
            entity = readData.getcelldata(sheetname, reqrow, "sEntity");
            chnl = readData.getcelldata(sheetname, reqrow, "sChannel");
            subchnl = readData.getcelldata(sheetname, reqrow, "sSubChannel");
            branch = readData.getcelldata(sheetname, reqrow, "sBranch");
            proccntr = readData.getcelldata(sheetname, reqrow, "sProcessingCenter");
            lastName =readData.getcelldata(sheetname, reqrow, "LastName") ;
      
            
       }
        
        else
             
        {
        System.out.println("Test Purpose not present in Datasheet");
        System.exit(0);
        
        }              
        
    }
    
    //Take Screenshot
    
  public static void screenshot(String name) throws Exception{
	  scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// Now you can do whatever you need to do with it, for example copy somewhere
	FileUtils.copyFile(scrFile, new File("c:\\tmp\\"+name+".png"));
	 
  }
    
    


 

}