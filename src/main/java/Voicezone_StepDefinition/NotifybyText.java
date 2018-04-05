package Voicezone_StepDefinition;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class NotifybyText extends Commonfiles {
	
	  String table, tns[];
	    String tlimit,username,pwd;
	    int tncount;                                                    
	                                
	    String phoneline,phoneline_ac,Acccode,phoneline_midtn,phoneline_lastfour;
	                int rank[]= new int[50];
	                int c_sequence;
	                String name_for_rank[]= new String[40];
	                String price, rank_channels;
	                int count1;
	                
	                private boolean isElementPresent(WebDriver driver, By by)
	          	  {
	          		  try{
	          			  driver.findElement(by);
	          			  return true;
	          		  }
	          		  catch(NoSuchElementException e){
	          			  return false;
	          		  }
	          	  } 
	@Given("^NotifybyText Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void notifybyText_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
		String schk="Fail";
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("NotifybyText", "Execution Report of NotifybyText");
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
			 driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[2]")).click();
             Thread.sleep(2000);
             schk=deleteall(driver,br,test);
			if(schk.equals("Pass"))
				schk=addremove(driver,br,test);
		    if(schk.equals("Pass"))
		    schk=emailvalidation(driver,br,test);
		    focusClick(driver,driver.findElement(By.id("mainCancelButton")),br);
             first=1;      
             i=10;

		     } 
			   catch (Exception e){
	             exceptionHandler(br,e,driver);
	             }
	       finally {
	    //wb.close();
	    	 i=statusTracker(i,"","","","","End");
	    	PrintResult("NotifybyText");
	        extent.flush();
	    }
	 }
	}
	
	public String addremove(WebDriver driver,String br,ExtentTest test) throws Exception
	  {
	                  String schk="Fail";
	                  System.out.println("goin inside addremove");
	                  if((driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr/td")).size()==0))
	                  { 
	                                  String ac;
	                                  String midtn;
	                                  String lastfour;
	                                  String rands=randomNO(5,3);
	                                  System.out.println(rands);
	                                  int rand=Integer.parseInt(rands);
	                                  for(int i=1;i<=rand;i++)
	                                  {
	                                                                ac=randomNO(999,200);
	                                                                midtn=randomNO(999,200);
	                                                                lastfour= randomNO(9999,1000);
	                                                                
	                                                                driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
	                                       
	                                                                driver.findElement(By.id("txtExchange")).sendKeys(midtn);
	                                                          
	                                                                driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);
	                                                           
	                                                     System.out.println("added");
	                                                     Thread.sleep(5000);
	                                                                driver.findElement(By.id("SelectMobileProvider")).click();
	                                                                String j=randomNO(15,1);
	                                                                int k=Integer.parseInt(j);
	                                                                
	                                                    Thread.sleep(2000);
	                                                    driver.findElement(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div/div/div/div/ul/li["+k+"]/a")).click();
	                                                    Thread.sleep(2000);
	                                                             
	                                                                driver.findElement(By.id("btnAddNumbertolist")).click();
	                                                                Thread.sleep(3000);
	                                                                if(i==rand)
	                                                                {
	                                                                                String ac1 = ac;
	                                                                                String midtn1 = midtn;
	                                                                                String lastfour1 = lastfour;
	                                                                                Thread.sleep(3000);
	                                                                }
	                                  }
	                                  
	                                  driver.findElement(By.id("mainSubmitButton")).click();
	                                  schk=orderprocess(driver,br);
	                                  String s[]=new String[rand];
	                                  if(schk.equals("Pass"))
	                                  {
	                                	  test.pass("The TNs are added Sucessfully: "+rand);
	                                                i=statusTracker(i,"Pass","Verify if TNs could be added", rand+ " TNS were added successfully","TNS were added successfully","");
	                                                String rands2=randomNO(2,1);
	                                                int rand2=Integer.parseInt(rands2);
	                                       
	                                                                  
	                                                                  for(int i=1;i<=rand2;i++)
	                                                                  {              Thread.sleep(5000);
	                                                                                  driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr[1]/td[3]/button")).click();
	                                                                                  int count1= driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr/td")).size();
	                                                                                
	                                                                                  System.out.println("count"+count1);
	                                                                                  Thread.sleep(3000);
	                                                                  }
	                                                                  driver.findElement(By.id("mainSubmitButton")).click();
	                                                                  schk=orderprocess(driver,br);
	                                                                  
	                                                                  
	                                                                  int count= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr/td")).size();
	                                                                  System.out.println(count);
	                                                                  for(int i=1;i<=count;i++)
	                                                                  {
	                                                                               
	                                                                                count= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[3]/div/div[2]/table/tbody/tr/td[5]/label")).size();
	                                                                               
	                                                                                  System.out.println(count);
	                                                                  }
	                                                                  
	                                                                
	                                                                  if(schk.equals("Pass"))
	                                                                  {
	                                                                	  test.pass("The TNs are removed Sucessfully: "+rand2);
	                                                                                  i=statusTracker(i,"Pass","Verify if TNS could be removed", rand2+ " TNS were removed successfully","TNS should be removed successfully","");
	                                                                                  
	                                                                                  count= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr/td")).size();
	                                                                                  int schk2=0;
	                                                                                  for(int i=1;i<=count;i++)
	                                                                                  {
	                                                                                                
																									if(count1==count)
	                                                                                                  {
	                                                                                                                  schk2=1;
	                                                                                                  }
	                                                                                  }  
	                                                                                  if(schk2==0)
	                                                                                  {
	                                                                                	  test.pass("TNs are the same after order process");
	                                                                                                  i=statusTracker(i,"Pass","Verify if TNS are the same after order process", "TNS are the same after order process","TNS should be the same after order process","");
	                                                                                                  schk="Pass";
	                                                                                  }
	                                                                                  else
	                                                                                  {
	                                                                                	  test.fail("TNS are Not the same after order process");
	                                                                                                  i=statusTracker(i,"Fail","Verify if email addresses are the same after order process", "Email addresses are not the same after order process","Email address should be the same after order process","");
	                                                                                                  schk="Fail";
	                                                                                  }
	                                                                  }
	                                                                  else
	                                                                  {
	                                                                	  test.fail("Th eTNs are removed Sucessfully: "+rand2);
	                                                                                i=statusTracker(i,"Fail","Verify if emails could be removed", rand2+ " Email addresses were not removed successfully","Email address should be removed successfully","");
	                                                                                schk="Fail";
	                                                                  }
	                                                                  
	                                                  }
	                                                  else
	                                                  {
	                                                	  test.fail("The TNs are Not added Sucessfully: "+rand);
	                                                                i=statusTracker(i,"Fail","Verify if emails could be added", rand+ " Email addresses were not added successfully","Email address should be added successfully","");
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

	     public String deleteall(WebDriver driver,String br,ExtentTest test) throws Exception
	                {
	                                  String schk="Fail";
	                                  System.out.println(schk);
	                                
	                                                  System.out.println("goin inside notify email"); 
	                                                 int count= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr")).size();
	                                                
	                                                  System.out.println("count"+count);
	                                                  String s[]=new String[count];
	                                                  if (count!=0)
	                                                  {
	                                                                  System.out.println("inside loop");
	                                         
	                                                  
	                                                  for(int i=1;i<=count;i++)
	                                                  {
	                                                	      System.out.println("value"+i);  
	                                                  driver.findElement(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr[1]/td[3]/button")).click();
	                                                  System.out.println("value1"+i);        
	                                                          System.out.println("here");     
	                                                                  Thread.sleep(2000);
	                                                  }
	                                                  
	                                                  driver.findElement(By.id("mainSubmitButton")).click();
	                                                  schk=orderprocess(driver,br);
	                                                  
	                                                  if(schk.equals("Pass"))
	                                                  {
	                                                	  test.pass("The TNs are Deleted Sucessfully");
	                                                                  i=statusTracker(i,"Pass","Verify if all the TNS could be removed", "TNS were removed successfully","TNS should be removed successfully","");
	                                                                  schk="Pass";
	                                                  }
	                                                  else
	                                                  {
	                                                	  test.fail("The TNs are Not Deleted Sucessfully");
	                                                                  i=statusTracker(i,"Fail","Verify if all the emails could be removed", "Email addresses were not removed successfully","Email address should be removed successfully","");
	                                                  }
	                                               
	                                  }
	                                  else
	                                                  schk="Pass";
	                                  System.out.println(schk);
	                                  return schk;
	                }
	     
	   public String TNcheck(String br,String ac, String midtn, String lastfour, String check,WebDriver driver,ExtentTest test) throws Exception
	                  {
	                                  String schk="Fail";
	                                  
	                                  int limit= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr")).size();
	                                  int count;
	                                  String tn;
	          
	                                  count=driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr")).size();
	                                  System.out.println("count"+count);
	                                  //do{

	                                  if(check.equals("max") && count<5)
	                                  {
	                                                  String num;
	                                                  String rands=randomNO(5,3);
	                                                  for(int i=count;i<5;i++)
	                                                  {
	                                                     String ac2,midtn2,lastfour2;
	                                                      ac=randomNO(999,200);
	                                                      midtn=randomNO(999,200);
	                                                       lastfour= randomNO(9999,1000);
	                                                        num=randomNO(14,1);
	                                                                                int num1=Integer.parseInt(num);
	                                                                                driver.findElement(By.id("txtAreaCode")).clear();
	                                                                                driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
	                                                                                driver.findElement(By.id("txtExchange")).clear();
	                                                                                driver.findElement(By.id("txtExchange")).sendKeys(midtn);
	                                                                                driver.findElement(By.id("txtTelNum")).clear();
	                                                                                driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);
	                                                                     System.out.println("added");
	                                                                                driver.findElement(By.id("SelectMobileProvider")).click();
	                                                                                String j=randomNO(15,1);
	                                                                                int k=Integer.parseInt(j);
	                                                                    Thread.sleep(5000);
	                                                                    driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div/div/div/div/ul/li["+k+"]/a")).click();
	                                                                                driver.findElement(By.id("btnAddNumbertolist")).click();
	                                                                    Thread.sleep(8000);
	                                                  }
	                                  }
	                                  
	                                  driver.findElement(By.id("txtAreaCode")).clear();
	                                  driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
	                                  driver.findElement(By.id("txtExchange")).clear();
	                                  driver.findElement(By.id("txtExchange")).sendKeys(midtn);
	                                  driver.findElement(By.id("txtTelNum")).clear();
	                                  driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);
	                                  driver.findElement(By.id("SelectMobileProvider")).click();
	                                 
	                                  if(check.equals("blank carrier"))
	                                  {  
	                                	  System.out.println(" blank carrier");
	                                    driver.findElement(By.id("btnAddNumbertolist")).click();    
	                                    count= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr")).size();
	                                    Thread.sleep(10000);
	                                    do
	                                	{
	                                    	Thread.sleep(1000);
	                                	 System.out.println("new7");	
	                                	}while(!(isElementPresent(driver,By.cssSelector("#MobileGridRefresh > #text-message-form > div.label-wrapper.clearfix > span.help-inline.error")) && driver.findElement(By.cssSelector("#MobileGridRefresh > #text-message-form > div.label-wrapper.clearfix > span.help-inline.error")).isDisplayed()));
	                                
	                                    if((isElementPresent(driver,By.cssSelector("#MobileGridRefresh > #text-message-form > div.label-wrapper.clearfix > span.help-inline.error"))) && (count==limit || check.equals("max")))
	                            	     {
	                                    	test.pass("Error Message for Condition"+check +" is "+driver.findElement(By.cssSelector("#MobileGridRefresh > #text-message-form > div.label-wrapper.clearfix > span.help-inline.error")).getText());
	                            		  i=statusTracker(i,"Pass","Verify if error message is displayed when adding "+check+" email","Error message is displayed: "+driver.findElement(By.cssSelector("#MobileGridRefresh > #text-message-form > div.label-wrapper.clearfix > span.help-inline.error")).getText(),"Error message should be displayed","");
	                            		  schk="Pass";
	                            	      }
	                            	   else
	                            	    { 
	                            		   test.fail("Error Message Not Displayed for Condition"+check);
	                            		  i=statusTracker(i,"Fail","Verify if error message is displayed when adding "+check+" email","Error message is not displayed","Error message should be displayed","");
	                            		  schk="Fail";
	                            	     }
	                                  }
	                                  else             
	                                   {
	                                           System.out.println("Not blank carrier");
	                                                
	                                               String num;
	                                      	  		num=randomNO(14,1);
	                                      	  		int num1=Integer.parseInt(num);
	                                      	  		
	                                      	  	driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div/div/div/div/ul/li["+num1+"]/a")).click();
	                                                             
	                                  
	                                  driver.findElement(By.id("btnAddNumbertolist")).click();                      
	                                    
	                                  count= driver.findElements(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[4]/div/div[2]/table/tbody/tr")).size();
	                                  
	                                  
	                                  do{
	                                    Thread.sleep(5000);
	                              	    System.out.println("new7");	
	                              	}while(!(isElementPresent(driver,By.cssSelector("#text-message-form > span.help-inline.error")) && driver.findElement(By.cssSelector("#text-message-form > span.help-inline.error")).isDisplayed()));
	                                  
	                                  
	                                  if((isElementPresent(driver,By.cssSelector("#text-message-form > span.help-inline.error"))) && (count==limit || check.equals("max")))
	                            	  {
	                                	test.pass("Error Message for Condition"+check +" "+driver.findElement(By.cssSelector("#text-message-form > span.help-inline.error")).getText());
	                            		  i=statusTracker(i,"Pass","Verify if error message is displayed when adding "+check+" email","Error message is displayed: "+driver.findElement(By.cssSelector("#text-message-form > span.help-inline.error")).getText(),"Error message should be displayed","");
	                            		  schk="Pass";
	                            	  }
	                            	  else
	                            	  { 
	                            		  test.fail("Error Message Not Displayed for Condition"+check);
	                            		  i=statusTracker(i,"Fail","Verify if error message is displayed when adding "+check+" email","Error message is not displayed","Error message should be displayed","");
	                            		  schk="Fail";
	                            	  }
	                                }              
	                                                  
	                               return schk;
	                                  
	                  }
	         
	                                 
	                 
	   public String emailvalidation(WebDriver driver,String br,ExtentTest test) throws Exception
	          {
	                String schk ="Pass";
	                schk=TNcheck(br,"938","493","4837","blank carrier",driver,test);
	                Thread.sleep(5000);
	                schk=TNcheck(br,"022","300","4000","first digit 0",driver,test);
	                Thread.sleep(5000);
	                schk=TNcheck(br,"222","000","4000","fourth digit 0",driver,test);
	                Thread.sleep(5000);
	                schk=TNcheck(br,"122","300","4000","first digit 1",driver,test);
	                Thread.sleep(5000);
	                schk=TNcheck(br,"222","152","4000","fourth digit 1",driver,test);
	                Thread.sleep(5000);
	                schk=TNcheck(br,"222","000","4000","fourth digit 0",driver,test);
	                Thread.sleep(5000);
	           
	                schk=TNcheck(br,"","","","Empty",driver,test);
	                Thread.sleep(5000);
	                schk=TNcheck(br,"99","9","99","Invalid",driver,test);   
	                Thread.sleep(5000);
	                schk=TNcheck(br,"923","329","4399","max",driver,test);  
	                Thread.sleep(5000);
	                driver.findElement(By.xpath("/html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div[5]/div/button[1]")).click();
	                schk="Pass";
	                return schk;
	         }	
}