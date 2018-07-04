package Testrunner;


import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
			features= "C:\\Users\\PD26696\\workspace\\EclipsePOC\\Features\\Newtest.feature",
			glue= {"com.LOIS.qa.testcases"},
			plugin="pretty",
			monochrome= true
			
			
			)
			

public class Testrunner {
	
            public void Runresult(){
		
	}

}
