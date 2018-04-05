package Voicezone_StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class Pinskip extends Commonfiles{
	@Given("^Pinskip Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void Pinskip_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
		String schk="Fail";
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Pinskip", "Execution Report of Pinskip");
		    if(Exe.contains("Yes"))
		    {
		      try{	
		        if(first==0) {
		    	login(Username,Password,br,tlim);	
		        }else
			    {
			   	 focusClick(driver,driver.findElement(By.id("settings-summary")),br);
			    }
		        
		     driver=getDriver();
			 System.out.println("Pinskip Inprogress");
			 int chk=0;
			    do{
			         Thread.sleep(1000);       
			        chk++;
			        System.out.println(chk);
			              }
			    while(driver.findElement(By.xpath("//*[@id='progress']")).isDisplayed());
			    Thread.sleep(20000);
				driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[2]")).click();
				Thread.sleep(10000);
				driver.findElement(By.linkText("Voicemail PIN Settings")).click();
				Thread.sleep(5000);
			 index=i;
			 Boolean status = driver.findElement(By.id("PinSkipStatus")).isSelected();
			 schk=flowrunPK(driver,br,test);
		     i=10;

		      } 
			   catch (Exception e){
	             exceptionHandler(br,e,driver);
	             }
	       finally {
	    //wb.close();
	    	 i=statusTracker(i,"","","","","End");
	    	PrintResult("Pinskip");
	        extent.flush();
	    }
	 }
	}
	
	public String flowrunPK(WebDriver driver,String br,ExtentTest test) throws Exception {
	    String schk="Fail";
		  Thread.sleep(5000);
	      Boolean status = driver.findElement(By.id("PinSkipStatus")).isSelected();
	   	  System.out.println("Initial state: "+status);
	   	  Boolean status1=false;
	   	
	   	  if(status==(true))
	   	  {
	   		  driver.findElement(By.id("PinSkipStatus")).click();
	   		  Thread.sleep(5000);
	   		  driver.findElement(By.id("mainSubmitButton")).click();
	   	      schk=orderprocess(driver,br);
	   	      Thread.sleep(5000);
	   	     status1 = driver.findElement(By.id("PinSkipStatus")).isSelected();
	   	     System.out.println(schk);
	   		 if(schk.equals("Pass"))
			  {
	   			 test.pass("Order is successfully processed from "+ status +" to "+status1);
				  i=statusTracker(i,"Pass","Verify if disabling pin skip order is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
			  }
			  else
			  {
				  test.fail("Order is successfully processed from "+ status +" to "+status1);
				  i=statusTracker(i,"Fail","Verify if disabling pin skip order is processed successfully","Order is not successfully processed","Order should be successfully processed","");
			  }
	   		
	   		  status = driver.findElement(By.id("PinSkipStatus")).isSelected();
	   		  driver.findElement(By.id("PinSkipStatus")).click();
	   		   Thread.sleep(5000);
			  driver.findElement(By.cssSelector("#dialog > div.modal-footer > #ok_PinSkip")).click();
			  Thread.sleep(10000);
	   		  driver.findElement(By.id("mainSubmitButton")).click();
	   		  schk=orderprocess(driver,br);
	   		  Thread.sleep(5000);
	   		  status1 = driver.findElement(By.id("PinSkipStatus")).isSelected();
	   		System.out.println(schk);
	   		if(schk.equals("Pass"))
			  {
	   			test.pass("Order is successfully processed from "+ status +" to "+status1);
				  i=statusTracker(i,"Pass","Verify if enabling pin skip order is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","End");
			  }
			  else
			  {
				  test.fail("Order is successfully processed from "+ status +" to "+status1);
				  i=statusTracker(i,"Fail","Verify if enabling pin skip order is processed successfully","Order is not successfully processed","Order should be successfully processed","End");
			  }
	   		  
	 
	   	  }  
	   	 else
	   	  {
	   		     status = driver.findElement(By.id("PinSkipStatus")).isSelected();
	   			 driver.findElement(By.id("PinSkipStatus")).click();
	   			  Thread.sleep(5000);
			      driver.findElement(By.cssSelector("#dialog > div.modal-footer > #ok_PinSkip")).click();
			      Thread.sleep(10000);
	   			  driver.findElement(By.id("mainSubmitButton")).click();
	   			  schk=orderprocess(driver,br);
	   			Thread.sleep(5000);
	   			  status1 = driver.findElement(By.id("PinSkipStatus")).isSelected();
	   			System.out.println(schk);
	   			  if(schk.equals("Pass"))
				  {
	   				  test.pass("Order is successfully processed from "+ status +" to "+status1);
					  i=statusTracker(i,"Pass","Verify if enabling pin skip order is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
				  }
				  else
				  {
					  test.fail("Order is successfully processed from "+ status +" to "+status1);
					  i=statusTracker(i,"Fail","Verify if enabling pin skip order is processed successfully","Order is not successfully processed","Order should be successfully processed","");
				  }
	   			
	   			  
	   			 status = driver.findElement(By.id("PinSkipStatus")).isSelected();
	   			  driver.findElement(By.id("PinSkipStatus")).click();
	   			  Thread.sleep(5000);
	   			  driver.findElement(By.id("mainSubmitButton")).click();   
	   			  schk=orderprocess(driver,br);
	   			  Thread.sleep(5000);
	   			 status1 = driver.findElement(By.id("PinSkipStatus")).isSelected();
	   			 System.out.println(schk);
	   			  if(schk.equals("Pass"))
				  {
	   				  test.pass("Order is successfully processed from "+ status +" to "+status1);
					  i=statusTracker(i,"Pass","Verify if disabling pin skip order is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","End");
				  }
				  else
				  {
					  test.fail("Order is successfully processed from "+ status +" to "+status1);
					  i=statusTracker(i,"Fail","Verify if disabling pin skip order is processed successfully","Order is not successfully processed","Order should be successfully processed","End");
				  }
	   			 
	   	  }
		return schk; 

	    }
}
