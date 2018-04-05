package Voicezone_StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class CallWaiting extends Commonfiles {
	@Given("^CallWaiting Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void CallWaiting_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
		String schk="Pass";
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("CallWaiting", "Execution Report of CallWaiting");
		    if(Exe.equals("Yes"))
		    {
		      try{
		       if(first==0) {
		    	login(Username,Password,br,tlim);	
		        }else{
			   	 focusClick(driver,driver.findElement(By.id("settings-summary")),br);
			    }
		        
		     driver=getDriver();
			 System.out.println("Notify by Email Inprogress");
			 int chk=0;
			    do{
			         Thread.sleep(1000);       
			        chk++;
			        System.out.println(chk);
			              }
			    while(driver.findElement(By.xpath("//*[@id='progress']")).isDisplayed());
			 Thread.sleep(20000);
			 index=i;
			 focusClick(driver, driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[5]")),br);
		      Thread.sleep(5000);
					boolean statusdisabled = driver.findElement(By.id("cwdisabled")).isSelected();
					System.out.println("Disablecallwaiting"+statusdisabled);
				
					boolean statuscw = driver.findElement(By.id("cw")).isSelected();
					System.out.println("EnableCallwaiting"+statuscw);
				
					boolean statuscwcid = driver.findElement(By.id("cwcid")).isSelected();
					System.out.println("CallWaitingwith CallerID"+statuscwcid);
					
					
					System.out.println("Process Inititiated");
					if(statusdisabled)
					{
						driver.findElement(By.id("cwdisabled")).click();
						 focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
						System.out.println("ffghfh");
						schk=orderprocess(driver,br);;
						System.out.println("fgjjfghgdjgldglaadgj1");
						if(schk.equals("Fail"))
						{
							test.fail("Disable Call Waiting Failed");
							i=statusTracker(i,"Fail","Verify order processing to disable Call Waiting","Order processing has Failed","Order should be processed successfully","");
							if(assertTrue(isElementPresent(driver.findElement(By.id("modalContinueButton")))))
							{
								 focusClick(driver,driver.findElement(By.id("modalContinueButton")),br);
								
							}
						}
					}
					System.out.println("run");
					if(schk.equals("Pass"))
						schk =flowrun(br,driver, "cw",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver, "cwdisabled",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"cwcid",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"cwdisabled",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"cw",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"cwcid",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"cwdisabled",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"cwcid",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"cw",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"cwdisabled",test);
					 focusClick(driver,driver.findElement(By.id("mainCancelButton")),br);

					 i=10;
					first=1;       

			     } 
			   catch (Exception e){
	             exceptionHandler(br,e,driver);
	             }
	       finally {
	    //wb.close();
	    	 i=statusTracker(i,"","","","","End");
	    	PrintResult("CallWaiting");
	        extent.flush();
	    }
	 }
	}
		    
	  public String flowrun( String br,WebDriver driver,String xpath,ExtentTest test) throws Exception
      {
      	boolean statusdisabled = driver.findElement(By.id("cwdisabled")).isSelected();
			System.out.println("val" +statusdisabled);
			boolean statuscw = driver.findElement(By.id("cw")).isSelected();
			System.out.println(statuscw);
			boolean statuscwcid = driver.findElement(By.id("cwcid")).isSelected();
			System.out.println(statuscwcid);
			
    		String from,to;
    		if(statusdisabled)
    			from = "Disabled";
    		else if (statuscw)
    			from = "Call Waiting";
    		else
    			from = "Call Waiting Caller ID";
    			 
    		System.out.println("after selection");
    		to=xpath;
    		if(to.contains("1"))
    			to="Disabled";
    		
    		else if(to.contains("2"))
    			to="Call Waiting";
    		else
    			to="Call Waiting Caller ID";
    		System.out.println("xpath assignment");
    		
    		driver.findElement(By.id(xpath)).click();
    		 focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
    	  	String schk=orderprocess(driver,br);;
    	  	System.out.println("test");
    	    Thread.sleep(8000);
    	 
    	  	if(schk.equals("Fail"))
    		{
    	  		test.fail("order processing Failed when switching from "+from+" to "+to);
    			i=statusTracker(i,"Fail","Verify order processing when switching from "+from+" to "+to,"Order processing has failed","Order should be processed successfully","");
    			if((assertTrue(isElementPresent(driver.findElement(By.id("modalContinueButton"))))))
    			{
    				focusClick(driver,driver.findElement(By.id("modalContinueButton")),br);
    			}
    		}
    		else
    		{
    			test.pass("order processed Sucess when switching from "+from+" to "+to);
    			System.out.println("Mpass");
    			i=statusTracker(i,"Pass","Verify order processing when switching from "+from+" to "+to,"Order processing has completed successfully","Order should be processed successfully","");
    		}
    	  	return schk;
      }
	private Object isElementPresent(WebElement findElement) {
		// TODO Auto-generated method stub
		return null;
	}
      
}