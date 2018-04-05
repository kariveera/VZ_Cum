package Voicezone_StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class NotifybyEmail extends Commonfiles {
	@Given("^NotifybyEmail Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void notifybyemail_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
		String schk="Fail";
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("NotifybyEmail", "Execution Report of NotifybyEmail");
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
			 driver.findElement(By.xpath(".//*[@id='ContentRefresh']/div/div[3]/div[2]/div/a")).click();
			 Thread.sleep(5000);
			 index=i;
			 schk=deleteall(driver,br,test);
			 Thread.sleep(5000);
			 if(schk.equals("Pass"))
	         schk=emailvalidation(driver,br,test);
	         Thread.sleep(5000);
	         if(schk.equals("Pass"))
		     schk=add(driver,br,test);      
	         
	         i=statusTracker(i,"","","","","End");
		     PrintResult("NotifybyEmail");
		     i=10;
	         first=1;
	         test.addScreenCaptureFromPath("screenshot.png");
	 		 extent.flush();
		     } 
			   catch (Exception e){
	             exceptionHandler(br,e,driver);
	             }
	       finally {
	    //wb.close();
	    	 i=statusTracker(i,"","","","","End");
	    	PrintResult("NotifybyEmail");
	        extent.flush();
	    }
	 }
	}
	
	public String deleteall(WebDriver driver,String br,ExtentTest test) throws Exception{
		String schk="Fail"; 
		System.out.println("gain inside Deleteall"); 
		 int count= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[3]/div/div[2]/table/tbody/tr/td[5]/label")).size();
		 System.out.println("count"+count);
		 Thread.sleep(5000);
		 for(int i=1;i<=count;i++)
		  {
			  driver.findElement(By.cssSelector("button.close-delete.poping")).click();
			  Thread.sleep(5000);
		  }
		  driver.findElement(By.id("mainSubmitButton")).click();
		  schk=orderprocess(driver,br);
		  System.out.println(schk);
		  if(schk.equals("Pass"))
		  {
			  test.pass("Sucessfully Deleted the Email Address");
		   i=statusTracker(i,"Pass","Verify if all the emails could be removed","Email addresses were removed successfully","Email address should be removed successfully","");
		  }
		  else
		  {
			  test.fail("Failed to Delete the Email Address");
		   i=statusTracker(i,"Fail","Verify if all the emails could be removed","Email addresses were not removed successfully","Email address should be removed successfully","");  
		  }
	      System.out.println("Delete operation Complete");
		return schk;
		
	}
	public String add(WebDriver driver,String br,ExtentTest test) throws Exception {
		 String schk="Fail";
		 String email;
		 int count1 = 0;
		  System.out.println("goin inside addremove");
		  if(!(assertTrue(isElementPresent("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[2]/table/thead/tr"))))
		  {
			  int rand=Integer.parseInt("5");
			  for(int i=1;i<=rand;i++)
			  {
				  	String num=randomNO(9999,1000);
				  	driver.findElement(By.id("txtEmailAddress")).clear();
				  	driver.findElement(By.id("txtEmailAddress")).sendKeys("test"+num+"@test.tst");
				  	Thread.sleep(5000);
				  	driver.findElement(By.id("btnAddtolist")).click();
			  		Thread.sleep(3000);
			  		if(i==rand)
			  			  email="test"+num+"@test.tst";
			  }
			  driver.findElement(By.id("mainSubmitButton")).click();
			  schk=orderprocess(driver,br);
			
			  if(schk.equals("Pass"))
			  {
				  test.pass("The Email Address Added Sucessfully: "+rand);
				 i=statusTracker(i,"Pass","Verify if emails could be added", rand+ " Email addresses were added successfully","Email address should be added successfully","");
				 String rands2=randomNO(2,1);
		  
			  int rand2=Integer.parseInt(rands2);
		
				  for(int i=1;i<=rand2;i++)
				  {
					  Thread.sleep(5000);
					  driver.findElement(By.cssSelector("button.close-delete.poping")).click();
					  Thread.sleep(5000);
					  count1= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[3]/div/div[2]/table/tbody/tr/td[5]/label")).size();
					  System.out.println(count1);
					  Thread.sleep(5000);
				  }
				  driver.findElement(By.id("mainSubmitButton")).click();
				  schk=orderprocess(driver,br);
				  
				  Thread.sleep(3000);
				  int count= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[3]/div/div[2]/table/tbody/tr/td[5]/label")).size();
				  System.out.println(count);
			
				 
				  if(schk.equals("Pass"))
				  {
					  test.pass("The Email address removed sucessfully: "+rand2);
					  i=statusTracker(i,"Pass","Verify if emails could be removed", rand2+ " Email addresses were removed successfully","Email address should be removed successfully","");
					  int schk2=1;
					 // for(int i=1;i<=count;i++)
					 // {
						  if(count1==count)
						  {
							  schk2=0;
						  }
					 // }  
					  if(schk2==0)
					  {
						  test.pass("Email addresses are the same after order process");
						  i=statusTracker(i,"Pass","Verify if email addresses are the same after order process", "Email addresses are the same after order process","Email address should be the same after order process","End");
						  schk="Pass";
					  }
					  else
					  {
						  test.fail("Email addresses are not the same after order process");
						  i=statusTracker(i,"Fail","Verify if email addresses are the same after order process", "Email addresses are not the same after order process","Email address should be the same after order process","End");
						  schk="Fail";
					  }
				  }
				  else
				  {
					  test.fail("The Email address removed sucessfully: "+rand2);
					 i=statusTracker(i,"Fail","Verify if emails could be removed", rand2+ " Email addresses were not removed successfully","Email address should be removed successfully","End");
					 schk="Fail";
				  }
				  
			  }
			  else
			  {
				  test.fail("The Email Address Added Sucessfully: "+rand);
				 i=statusTracker(i,"Fail","Verify if emails could be added", rand+ " Email addresses were not added successfully","Email address should be added successfully","End");
				 schk="Fail";
			  }
		  }
		  else
		  {
			  schk="Pass";
			  System.out.println("goin inside addremove2");
		  }
		  
		return schk;
	}
	  private Object isElementPresent(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String emailvalidation(WebDriver driver,String br,ExtentTest test) throws Exception{
		 String schk ="Pass";
		 String email;
		  int count= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[3]/div/div[2]/table/tbody/tr/td[5]/label")).size();
			 if(count==0)
				{
				  driver.findElement(By.id("txtEmailAddress")).clear();	  
				  driver.findElement(By.id("txtEmailAddress")).sendKeys("aa@gmail.com");
				  Thread.sleep(5000);
				  driver.findElement(By.id("btnAddtolist")).click();
				} 
		  Thread.sleep(5000);
		  schk=TNcheck(br,"","blank",driver,test);
		  Thread.sleep(5000);
		  schk=TNcheck(br,"ss.com","invalid",driver,test);
		  Thread.sleep(5000);
		
		  String self=driver.findElement(By.xpath(".//*[@id='EmailGridRefresh']/div[2]/table/tbody/tr[1]/td[1]")).getText(); 
		  System.out.println(self);
		  schk=TNcheck(br,self,"Same",driver,test);
		  Thread.sleep(5000);
		  schk=deleteall(driver,br,test);
		  int rand=Integer.parseInt("5");
		  for(int i=1;i<=rand;i++)
		  {
			  	String num=randomNO(9999,1000);
			  	driver.findElement(By.id("txtEmailAddress")).clear();
			  	driver.findElement(By.id("txtEmailAddress")).sendKeys("test"+num+"@test.tst");
			  	Thread.sleep(5000);
			  	driver.findElement(By.id("btnAddtolist")).click();
		  		Thread.sleep(3000);
		  		if(i==rand)
		  			  email="test"+num+"@test.tst";
		  }
		  Thread.sleep(5000);
		  driver.findElement(By.id("mainSubmitButton")).click();
		  schk=orderprocess(driver,br);
		  System.out.println(schk);
		  schk=TNcheck(br,"eodi@odi.com","max",driver,test);
	      driver.findElement(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[5]/div/button[1]")).click();
	      schk=deleteall(driver,br,test);              
	     return schk;
		
	}
	  public String TNcheck(String br,String email, String check,WebDriver driver,ExtentTest test) throws Exception{ 
		  System.out.println("TNcheck");
		  String schk="Fail";
		  System.out.println("Befor entering pins");
		  driver.findElement(By.id("txtEmailAddress")).clear();	  
		  driver.findElement(By.id("txtEmailAddress")).sendKeys(email);
		  Thread.sleep(5000);
			driver.findElement(By.id("btnAddtolist")).click();
	        System.out.println("after submitting");
	      Thread.sleep(5000);
	      if((driver.findElement(By.cssSelector("span.help-inline.error")).isDisplayed()))
	     {
		  System.out.println("printing");
			  i=statusTracker(i,"Pass","Verify if error message is displayed when adding "+check+" email","Error message is displayed: "+ driver.findElement(By.cssSelector("span.help-inline.error")).getText(),"Error message should be displayed","");
			  schk="Pass";
			  test.pass("The Error Message for Condition"+check+"is displayed as: "+driver.findElement(By.cssSelector("span.help-inline.error")).getText());
		  }
		  else
		  {
			  i=statusTracker(i,"Fail","Verify if error message is displayed when adding "+check+" email","Error message is not displayed","Error message should be displayed","");
			  schk="Fail";
			  test.fail("The Error Message for Condition"+check+"is not displayed");
		  }
		  return schk;
	}

}
