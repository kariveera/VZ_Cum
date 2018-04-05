package Voicezone_StepDefinition;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.java.en.Given;

public class BlockOutboundCallerID extends Commonfiles{
		
	@Given("^Block Outbound Caller ID Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void block_Outbound_Caller_ID_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Exception {
		String schk="Fail";boolean status,status1;
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("BlockOutboundCallerID", "Execution Report of BlockOutboundCallerID");
		
	    if(Exe.equals("Yes"))
	    {
	     try{
	       if(first==0) {	    	    
	   		test.log(Status.INFO, "This step shows Portal Login");
	    	login(Username,Password,br,tlim);	
	        }
	        else{
		   focusClick(driver,driver.findElement(By.id("settings-summary")),br);
		    }	 
	       
	      driver=getDriver();
		  
		  int chk=0;
		    do{
		         Thread.sleep(1000);       
		        chk++;
		        System.out.println(chk);
		        }while(driver.findElement(By.xpath("//*[@id='progress']")).isDisplayed());
		   Thread.sleep(3000);
		   index=i;

		   focusClick(driver, driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[1]")),br);
           Thread.sleep(1000);
           driver.findElement(By.xpath("//div[@id='ContentRefresh']/ul/li[5]/a")).click();
  
           status = driver.findElement(By.id("bocActivated")).isSelected();
          System.out.println("Initial state: "+status);
          status1=false;
          
      if (status==(false))
      {
    	  test.log(Status.INFO, "The Initial State: Off");
           schk="Fail";
           focusClick(driver,driver.findElement(By.id("bocActivated")),br);
           focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);            
                  schk=orderprocess(driver,br);
                  status1=true;
           
                  if(schk.equals("Pass"))
                  {
                	  test.pass("Turned On is Pass");
                        i=statusTracker(i,"Pass","Verify if enabling OutBoundCallerid calling is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
                  }
                  else
                  {
                	  test.fail("Turned On is Fail", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
                        i=statusTracker(i,"Fail","Verify if enabling OutBoundCallerid calling is processed successfully","Order is not successfully processed","Order should be successfully processed","");
                  }
                  status = driver.findElement(By.id("bocActivated")).isSelected();
                  focusClick(driver,driver.findElement(By.id("bocDeActivated")),br);
                  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);     
                  System.out.println(status);
                  schk=orderprocess(driver,br);
                  status1=false;

                  if(schk.equals("Pass"))
                  {
                	  test.pass("Turned Off is Pass");
                        i=statusTracker(i,"Pass","Verify if disabling OutBoundCallerid calling is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
                  }
                  else
                  {
                	  test.fail("Turned On is Fail", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
                        i=statusTracker(i,"Fail","Verify if disabling OutBoundCallerid calling is processed successfully","Order is not successfully processed","Order should be successfully processed","");
                  }
           }
          else
            {
        	  test.log(Status.INFO, "The Initial State: On");
                        schk="Fail";
                        status = driver.findElement(By.id("bocActivated")).isSelected();
                        System.out.println(status);
                        focusClick(driver,driver.findElement(By.id("bocDeActivated")),br);
                  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);     
                  schk=orderprocess(driver,br);
                  status1=false;

                        if(schk.equals("Pass"))
                        {
                        	test.pass("Turned Off is Pass");
                               i=statusTracker(i,"Pass","Verify if disabling OutBoundCallerid calling is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
                        }
                        else
                        {
                        	test.fail("Turned On is Fail", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
                               i=statusTracker(i,"Fail","Verify if disabling OutBoundCallerid calling is processed successfully","Order is not successfully processed","Order should be successfully processed","");
                        }
                        status = driver.findElement(By.id("bocActivated")).isSelected();
                        focusClick(driver,driver.findElement(By.id("bocActivated")),br);
                       focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);                     
                        schk=orderprocess(driver,br);
                        status1=true;
                       System.out.println(status);
                        if(schk.equals("Pass"))
                        {
                        	test.pass("Turned On is Pass");
                               i=statusTracker(i,"Pass","Verify if enabling OutBoundCallerid calling is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
                        }
                        else
                        {
                        	test.fail("Turned On is Fail", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
                               i=statusTracker(i,"Fail","Verify if enabling OutBoundCallerid calling is processed successfully","Order is not successfully processed","Order should be successfully processed","");
                        }
                  }      
         
      		driver.findElement(By.id("mainCancelButton")).click();
           first=1; 
           i=10;
           test.addScreenCaptureFromPath("screenshot.png");
   		   
	     }
	     catch (Exception e){
	                  exceptionHandler(br,e,driver);
	      }
	     finally {
	         //wb.close();
	           i=statusTracker(i,"","","","","End");  
	           PrintResult("BlockOutboundCallerID");
	         extent.flush();
	       }

       }
   }
	
}
