package com.qa.testcase;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.KiwiSaverCalc;


public class KiwiSaverCalctest extends TestBase{
	
	public WebDriver driver;
	public KiwiSaverCalc kiwisaverpage;
		
	
	public KiwiSaverCalctest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initialization();
						
	}
	
	@Test

	public void TC1_ShowInfoMessageForAge()
	{	  
		kiwisaverpage.ClickonCalc();
		 String actualCurrentAgeMessage = kiwisaverpage.VerifyInfomessage();

	        String expectedTitlePage = "This calculator has an age limit of 18 to 64 years old.";
	        Assert.assertEquals(actualCurrentAgeMessage, expectedTitlePage);		
		    
	}
	
	 @DataProvider(name = "data1")
	    public Object[][] createData1() {
	     return new Object[][] {
	       { "30", "82000" }
	     };
	    }
	
	
	@Test(dataProvider="data1")
		
	public  void VerifyUS1TC1(String ageval, String salary) {
		
		kiwisaverpage.ClickonCalc();
        boolean  balance= kiwisaverpage.US2TC1(ageval, salary);
        
       Assert.assertTrue(balance, "KiwiSaver balance is estimated to be:$436,365" );
	}
	
	@DataProvider(name = "data2")
    public Object[][] createData2() {
     return new Object[][] {
       { "45","100000","90", "290000" }
     };
    }
	
     @Test(dataProvider="data2") 
     
	public  void VerifyUS2TC2(String ageval, String kiwi_saver_balanceVal, String voluntary_contributionVal,
            String goal_requirementVal) {
		
		
		kiwisaverpage.ClickonCalc();
        boolean  balance= kiwisaverpage.US2TC2(ageval, kiwi_saver_balanceVal, voluntary_contributionVal, goal_requirementVal);
        
       Assert.assertTrue(balance, "KiwiSaver balance is estimated to be:$259,581" );
	}
     
     @DataProvider(name = "data3")
     public Object[][] createData3() {
      return new Object[][] {
        { "55","1400000","10", "200000" }
      };
     }

     @Test(dataProvider="data3") 
     
     public  void VerifyUS2TC3(String ageval, String kiwi_saver_balanceVal, String voluntary_contributionVal,
             String goal_requirementVal) {
 		
 		
 		kiwisaverpage.ClickonCalc();
         boolean  balance= kiwisaverpage.US2TC3(ageval, kiwi_saver_balanceVal, voluntary_contributionVal, goal_requirementVal);
         
        Assert.assertTrue(balance, "KiwiSaver balance is estimated to be:$1,975,033" );
 	}
     

	@AfterMethod
	public void CloseApplication()
	{
		TearDown();
	}
	

}
