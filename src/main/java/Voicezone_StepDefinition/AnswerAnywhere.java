package Voicezone_StepDefinition;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class AnswerAnywhere extends Commonfiles{
	String table, tns[];
    String tlimit,username,pwd;
    String ac1,midtn1,lastfour1;
    String phoneline,phoneline_ac,phoneline_midtn,phoneline_lastfour;
    int chk123=0;
    int tncount,tlim;
	
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
	@Given("^AnswerAnywhere Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void AnswerAnywhere_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
		String schk="Fail";
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("AnswerAnywhere", "Execution Report of AnswerAnywhere");
	    if(Exe.equals("Yes")){
	      try{
	       if(first==0) 
	        {
	         login(Username,Password,br,tlim);	
	        }
	        else
	       {
	   	      focusClick(driver,driver.findElement(By.id("settings-summary")),br);
	        }
		driver=getDriver();
		 System.out.println("Voicetotext Inprogress");
		 int chk=0;
		    do{
		        Thread.sleep(1000);       
		        chk++;
	        System.out.println(chk);
		              }
		 while(driver.findElement(By.xpath("//*[@id='progress']")).isDisplayed());
		 Thread.sleep(20000);
		 index=i;
		  focusClick(driver, driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[4]")),br);
          Thread.sleep(5000);

                                         boolean status =driver.findElement(By.id("AnswerAnywhereOn")).isSelected();
                                         System.out.println("chk000"+status);
                                        
                                         String status1="off";
                                         if(!status)
                                              status1="true";
                                         
                                         System.out.println("line 623");
                                         
                                         
                                         schk=deleteall(br,driver,test);
                                         
                                         
                                         if(schk.equals("Pass"))
                                                         schk=flowrun(br,driver,test);
                                         
                                         if(schk.equals("Pass"))
                                         {
                                                         status = driver.findElement(By.id("AnswerAnywhereOn")).isSelected();
                                                         test.info("Verify TN add/remove when feature is "+status);
                                                         i=statusTracker(i,"","Verify TN add/remove when feature is "+status,"","","");
                                                         schk=flowrun1(br,driver,test);
                                         }
                                         
                                         if(schk.equals("Pass"))
                                                         schk=flowrun(br,driver,test);
                                         
                                         if(schk.equals("Pass"))
                                         {
                                                         status = driver.findElement(By.id("AnswerAnywhereOn")).isSelected();
                                                         test.info("Verify TN add/remove when feature is "+status);
                                                         i=statusTracker(i,"","Verify TN add/remove when feature is "+status,"","","");
                                                         schk=flowrun1(br,driver,test);
                                         }
                                         
                                         if(schk.equals("Pass"))
                                         {
                                        	 	test.info("Verify TN Validation");
                                                         i=statusTracker(i,"","Verify TN Validation","","","");
                                                         
                                                         schk=TNValidation(br,driver,test);
                                         }
                                         
                                      /*   if(schk.equals("Pass"))
                                         {
                                                         statusTracker(br,"","Verify maximum TN operations","","");
                                                         schk=flowrunmaxtn(br,driver);                  
         
                                         }
                                         */
                                         
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
	    	PrintResult("Answer Anywhere");
	        extent.flush();
	    }
	 }
	}
	
	  public String TNValidation(String br,WebDriver driver,ExtentTest test) throws Exception
	  {
	                  String schk ="Pass";
	                  schk=TNcheck(br,"022","300","4000","first digit 0",driver,test);
	                  Thread.sleep(2000);
	                  schk=TNcheck(br,"222","000","4000","fourth digit 0",driver,test);
	                  Thread.sleep(2000);
	                  schk=TNcheck(br,"122","300","4000","first digit 1",driver,test);
	                  Thread.sleep(2000);
	                  schk=TNcheck(br,"222","152","4000","fourth digit 1",driver,test);
	                  Thread.sleep(2000);
	                 schk=TNcheck(br,"222","000","4000","fourth digit 0",driver,test);
	                 Thread.sleep(2000);
	                  schk=TNcheck(br,"976","222","4000","976 TN",driver,test);
	                  Thread.sleep(2000);
	                  schk=TNcheck(br,"976","222","4000","900 TN",driver,test);
	                  Thread.sleep(2000);
	                  schk=TNcheck(br,"","","","blank",driver,test);
	                  Thread.sleep(2000);
	                // schk=TNcheck(br,ac1,midtn1,lastfour1,"existing",driver);
	                  schk=TNcheck(br,"99","9","99","Invalid",driver,test);
	                  Thread.sleep(2000);
 
	                  schk="Pass";
	                  return schk;
	  }
	  
	  public String TNcheck(String br,String ac, String midtn, String lastfour, String check,WebDriver driver,ExtentTest test) throws Exception
	  {
	                  String schk="Fail";
	                  int limit =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
	                  System.out.println("limit is"+limit);
	                  int count;
	                  String tn;

	                  driver.findElement(By.id("txtAreaCode")).clear();
	                    driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
	                    driver.findElement(By.id("txtExchange")).clear();
	                    driver.findElement(By.id("txtExchange")).sendKeys(midtn);
	                    driver.findElement(By.id("txtTelNum")).clear();
	                    driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);
	                    Thread.sleep(5000);
	                    
	                    driver.findElement(By.id("AddToPhoneNumbers")).click();
	                    Thread.sleep(5000);
	                    boolean errmesg= driver.findElement(By.cssSelector("span.help-block.error")).isDisplayed();
	                      if(errmesg)
	                      {
	                             Thread.sleep(2000);
	                             test.pass("Error Message for Condition"+check+" :"+  driver.findElement(By.cssSelector("div.modal-body > p")).getText());
	                                  i=statusTracker(i,"Pass","Verify if error message is displayed on clicking the friendly icon when adding "+check+" TN","Error message is displayed: "+  driver.findElement(By.cssSelector("div.modal-body > p")).getText(),"Error message should be displayed","");
	                           
	                             System.out.println("Error message"+ driver.findElement(By.cssSelector("div.modal-body > p")).getText());
	                             schk="Pass";
	                      }
	                      else
	                      {
	                    	  test.fail("Error Message not displayed for Condition"+check);
	                             i=statusTracker(i,"Fail","Verify if error message is displayed on clicking the friendly icon when adding "+check+" TN","Error message is not displayed","Error message should be displayed","");
	                             schk="Fail";
	                      }
	                      
	                      Thread.sleep(4000);
	                   
	                  

	                  tn=ac+midtn+lastfour;
	                  count=driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
	                
	                  System.out.println(count);
	                  if(errmesg && count==limit)
	                  {
	                	  test.info("The Error Message Displayed for the Condition"+check+" :"+driver.findElement(By.xpath(".//*[@id='ValidationBlock']/div/span")).getText());
	                                  i=statusTracker(i,"Pass","Verify if error message is displayed when adding "+check+" TN","Error message is displayed: "+ driver.findElement(By.xpath(".//*[@id='ValidationBlock']/div/span")).getText(),"Error message should be displayed","");
	                                  schk="Pass";
	                  }
	                  else
	                  {
	                	  test.fail("The Error Message Not Displayed for the Condition"+check);
	                                  i=statusTracker(i,"Fail","Verify if error message is displayed when adding "+check+" TN","Error message is not displayed","Error message should be displayed","");
	                                  schk="Fail";
	                  }
	                  
	                  
	                  return schk;
	  }
	  public String flowrun(String br,WebDriver driver,ExtentTest test) throws Exception
	  {
	                                boolean status = driver.findElement(By.id("AnswerAnywhereOn")).isSelected();
	                                
	                                boolean status1 = driver.findElement(By.id("AnswerAnywhereOff")).isSelected();
	                                
	                                String from="",to="";
	                                if(status)
	                                {
	                                                from = "Enabled";
	                                                to="Disabled";
	                                                driver.findElement(By.id("AnswerAnywhereOff")).click();
	                                }
	                                else if (!status)
	                                {
	                                                from = "Disabled";
	                                                to="Enabled";
	                                                driver.findElement(By.id("AnswerAnywhereOn")).click();
	                                  }
	                                                
	                                  Thread.sleep(5000);            
	                                  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);   
	                
	                                  Thread.sleep(20000);
	                

	                                String schk=orderprocess(driver,br);
	                                Thread.sleep(2000);
	                  
	                                if(schk.equals("Fail"))
	                                {
	                                	test.fail("The Order Failed switching " +from+" to "+to);
	                                                i=statusTracker(i,"Fail","Verify order processing when switching from "+from+" to "+to,"Order processing has failed","Order should be processed successfully","");
	                                                if(isElementPresent(driver,(By.id("modalContinueButton"))))
	                                                {  
	                                                	Thread.sleep(2000);
	                                                                focusClick(driver, driver.findElement(By.id("modalContinueButton")),br);              
	                                                }
	                                }
	                                else
	                                {
	                                	test.fail("The Order Sucess switching " +from+" to "+to);
	                                                i=statusTracker(i,"Pass","Verify order processing when switching from "+from+" to "+to,"Order processing has completed successfully","Order should be processed successfully","");
	                                }
	                                return schk;
	  }
	   
	  public String flowrun1(String br,WebDriver driver,ExtentTest test) throws Exception
	  {
	                  String schk ="Fail";
	                  
	                  
	                  String ac;
	                  String midtn;
	                  String lastfour;
	                  String tn;
	                  int count;
	                   ac=randomNO(999,200);
	                                  midtn=randomNO(999,200);
	                                  //String midtn="345";
	                                  lastfour= randomNO(9999,1000);
	                                // ac=phoneline_ac;   
	                                  //midtn=phoneline_midtn; 
	                                  driver.findElement(By.id("txtAreaCode")).clear();
	                                 
	                                    driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
	                                    driver.findElement(By.id("txtExchange")).clear();	                                    
	                                    driver.findElement(By.id("txtExchange")).sendKeys(midtn);
	                                    driver.findElement(By.id("txtTelNum")).clear();
	                                   driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);
	                                    focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);           
	                                    Thread.sleep(5000);
	                                   focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);                                      
	                                  Thread.sleep(5000);
	                                  schk=orderprocess(driver,br);
	                  
	                  tn=ac+midtn+lastfour;
	                  count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
	                  System.out.println("tns present: " +count);
	                  int chk=0;
	                  for(int i=1;i<=count;i++)
	                  {
	                                  Thread.sleep(5000);
	                                  String value=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr["+i+"]/td")).getText();
	                                  System.out.println(value+tn);
	                                  value=value.replaceAll(" ","");
	                                  value=value.replaceAll("\\(","");
	                                  value=value.replaceAll("\\)","");
	                                  value=value.replaceAll("-","");
	                                  if(value.equals(tn))
	                                  {
	                                	  test.pass("Added TN is present in the list");
	                                                  i=statusTracker(i,"Pass","Verify if added TN is present in the list","Added TN is present in the list","Added TN should be present in the list","");
	                                                  chk=1;
	                                                  schk="Pass";
	                                  }
	                  }
	                  if(chk==0)
	                  {
	                	  test.fail("Added TN is Not present in the list");
	                                                i=statusTracker(i,"Fail","Verify if added TN is present in the list","Added TN is not present in the list","Added TN should be present in the list","");
	                                                schk="Fail";
	                  }
	                  if(schk.equals("Pass"))
	                  {
	                                  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);   
	                                  Thread.sleep(5000);
	                                  schk=orderprocess(driver,br);
	                                  Thread.sleep(5000);
	                                  //schk="Pass";
	                                  if(schk.equals("Pass"))
	                                  {
	                                	  test.pass("Order Sucess on Adding the TN");
	                                                  i=statusTracker(i,"Pass","Verify if add TN order is processed successfully","Order is successfully processed","Order should be successfully processed","");  
	                                                  //int count1 =selenium.getXpathCount("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div/div/div[5]/table/tbody//tr").intValue();
	                                                  
	                                  }
	                                  else
	                                  {
	                                	  test.fail("Order Failed on Adding the TN");
	                                                  i=statusTracker(i,"Fail","Verify if add TN order is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	                                                  if(isElementPresent(driver,(By.id("mainSubmitButton"))))
	                                                  {
	                                                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);      
	                                                                                
	                                                  }
	                                                  schk="Fail";
	                                  }
	                 }         
	                                  
	                  if(schk.equals("Pass"))
	                  {               Thread.sleep(5000);
	                                  driver.findElement(By.id("DeleteNumber_"+ tn)).click();
	                                  do{
	                                                  
	                                  }while((isElementPresent(driver,(By.xpath("//div[13]")))&&chk123==0));
	                                  chk123=0;
	                                Thread.sleep(5000);
	                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);      
	                                Thread.sleep(4000);
	                                  schk=orderprocess(driver,br);
	                                
	                                  Thread.sleep(5000);
	                                  if(schk.equals("Pass"))
	                                  {
	                                                  i=statusTracker(i,"Pass","Verify if remove TN order is processed successfully","Order is successfully processed","Order should be successfully processed","");  
	                                                  test.pass("Order Sucess on Deleting the TN");
	                                                  
	                                  }
	                                  else
	                                  {
	                                                  i=statusTracker(i,"Fail","Verify if remove TN order is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	                                                  test.fail("Order failed on Deleting the TN");
	                                                  schk="Fail";
	                                  }
	                                  
	                                  
	                  }
	                  
	                  return schk;
	  }
	  
	  public String deleteall(String br,WebDriver driver,ExtentTest test) throws Exception
	  {
	                  System.out.println("Starting deleteall");
	                  String schk ="false";
	                  int chk;
	                  
	                                                                                                                                                                 
	                  int count = driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
	                  System.out.println("count"+count);
	                  String tn;
	                  
	                  if(isElementPresent(driver, By.cssSelector("td.phone")))
	                  {
	                                  for(int i=1;i<=count;i++)
	                                  {
	                                                  
	                                                  Thread.sleep(2000);
	                                                  String s= driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr["+i+"]/td")).getText();
	                                                  s=s.replaceAll(" ","");
	                                                  s=s.replaceAll("\\(","");
	                                                  s=s.replaceAll("\\)","");
	                                                  s=s.replaceAll("-","");
//	                                              System.out.println(selenium.getValue("//html/body/div/section/form/div[2]/div/div["+i+"]/table/tbody/tr/td//input"));
	                                                  
	                                                  tn=s;
	                                                  System.out.println(tn);
	                                                  //selenium.click("//*[@id='DeleteNumber_"+ tn + "']");
	                                                  Thread.sleep(5000);
	                                                  driver.findElement(By.id("DeleteNumber_"+ tn)).click();
	                                                  Thread.sleep(5000);
	                                                
	                                                  i=0;
	                                                  count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
	                                                  System.out.println("ss: "+count);
	                                                
	                                  
	                                  }
	                                
	                                  boolean status =driver.findElement(By.id("AnswerAnywhereOn")).isSelected();
	                                  System.out.println(status);
	                                  if(status)
	                                  {    
	                                                  driver.findElement(By.id("AnswerAnywhereOff")).click();
	                                                  System.out.println("rrr"); 
	                                  }
	                                  Thread.sleep(2000);
	                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);      
	                                Thread.sleep(20000);
	                                  schk=orderprocess(driver,br);
	                
	                                  count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
	                                  System.out.println(count);
	                                  
	                                  status = driver.findElement(By.id("AnswerAnywhereOn")).isSelected();
	                                  System.out.println(status);
	                                  if(!status)
	                                  {
	                                                  focusClick(driver,driver.findElement(By.id("AnswerAnywhereOn")),br);
	                                                  
	                                                  System.out.println("rrra"); 
	                                                  
	                                                  
	                                                  /*do{
	                                                                  
	                                                                }while((drive.findElements(By.xpath("//div[13]")).size()!=0));*/
	                                  }
	                                  Thread.sleep(5000);
	                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);      
	                       
	                                
	                                  if(driver.findElement(By.xpath("//div[@id='ValidationBlock']/div/span")).isDisplayed())
	                                  {
	                                	test.pass("Error Message displayed On Enabling without Tn is: "+driver.findElement(By.cssSelector("span.help-block.error")).getText());
	                                                  i=statusTracker(i,"Pass","Verify if error message is displayed when trying to enable feature with no TNs","Error message is displayed: " + driver.findElement(By.cssSelector("span.help-block.error")).getText(),"Error message should be displayed","");
	                                  }
	                                  else
	                                  {
	                                                  i=statusTracker(i,"Fail","Verify if error message is displayed when trying to enable feature with no TNs","Error message is not displayed","Error message should be displayed","");
	                                                  schk="Fail";
	                                                  test.fail("Able to Enable Without Number");
	                                  }
	                                  
	                                  
	                  }
	                  System.out.println("chk222");
	                  if(!(isElementPresent(driver, By.cssSelector("td.phone"))))
	                  {
	                                  
	                                 ac1=randomNO(999,200);
	                                  midtn1=randomNO(999,200);
	                                  //String midtn="345";
	                                  lastfour1= randomNO(9999,1000);
	                                  //ac1=phoneline_ac;  //-------------------------------------------------------------
	                                  //midtn1=phoneline_midtn; //-------------------------------------------------------
	                                   driver.findElement(By.id("txtAreaCode")).clear();
	                                    driver.findElement(By.id("txtAreaCode")).sendKeys(ac1);
	                                    driver.findElement(By.id("txtExchange")).clear();
	                                    driver.findElement(By.id("txtExchange")).sendKeys(midtn1);
	                                    driver.findElement(By.id("txtTelNum")).clear();
	                                    driver.findElement(By.id("txtTelNum")).sendKeys(lastfour1);
	                                    focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
	                                  Thread.sleep(5000);
	                

	                                  
	                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);      
	                                Thread.sleep(15000);
	                                  schk=orderprocess(driver,br);
	                
	                  }
	  return schk;
	}
	  
	  public String flowrunmaxtn(String br,WebDriver driver,ExtentTest test) throws Exception
	  {
	                  String schk ="Fail";
	                  
	                  
	                  String ac;
	                  String midtn;
	                  String lastfour;
	                  String tn;
	                  int count;
	                  
//	              TN=TN+lastfour;
	                // int limit =selenium.getXpathCount("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div/div/div[5]/table/tbody//tr").intValue();
	                  
	                  do{
	                                  ac=randomNO(999,200);
	                                  if(ac.equals("900") || ac.equals("976"))
	                                                  ac=randomNO(999,200);  
	                                  midtn=randomNO(999,200);
	                                  //String midtn="345";
	                                  lastfour= randomNO(9999,1000);
	                                  ac=phoneline_ac;  //-------------------------------------------------------------
	                                  midtn=phoneline_midtn; //-------------------------------------------------------
	                                  driver.findElement(By.id("txtAreaCode")).clear();
	                                    driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
	                                    driver.findElement(By.id("txtExchange")).clear();
	                                    driver.findElement(By.id("txtExchange")).sendKeys(midtn);
	                                    driver.findElement(By.id("txtTelNum")).clear();
	                                    driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);
	                                    
	                                    focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
	                                    
	                                  Thread.sleep(2000);
	                
	                                
	                                  
	                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	                                  Thread.sleep(2000);
	                                  schk=orderprocess(driver,br);
	                
	                  
	                  tn=ac+midtn+lastfour;
	                  //do{
	                  //}while(selenium.isElementPresent("//body/div[10]"));
	                
	                  
	                  //System.out.println(selenium.getXpathCount("//*[@id='TNGridRefresh']/div"));
	                  count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
	                  int chk=0;
	                  for(int i=1;i<=count;i++)
	                  {
	                                  String value=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr["+i+"]/td")).getText();
	                                  System.out.println(value);
	                                
	                                  value=value.replaceAll(" ","");
	                                  value=value.replaceAll("\\(","");
	                                  value=value.replaceAll("\\)","");
	                                  value=value.replaceAll("-","");
	                                  if(value.equals(tn))
	                                  {
	                                                  i=statusTracker(i,"Pass","Verify if added TN is present in the list","Added TN is present in the list. Added TN: "+count,"Added TN should be present in the list","");
	                                                  chk=1;
	                                                  schk="Pass";
	                                                  test.pass("Added TN is present in the list. Added TN: "+count);
	                                  }
	                  }
	                  if(chk==0)
	                  {
	                	  	test.fail("Added TN is present in the list. Total Tns present "+count);
	                                                i=statusTracker(i,"Fail","Verify if added TN is present in the list","Added TN is not present in the list. Total Tns present "+count,"Added TN should be present in the list","");
	                                                schk="Fail";
	                  }
	                  if(isElementPresent(driver,By.cssSelector("span.help-block.error")))
	                  {
	                	  test.fail("Unable to Add 5 Tns");
	                                                                i=statusTracker(i,"Fail","Verify if 5 TNs can be added to the list","Error message is present before the 5 TNs are completed added","TN should be added to the list","");
	                                                                schk="Fail";
	                  }
	                  }while(count<5 && schk.equals("Pass"));
	                                  
	                  if(schk.equals("Pass"))
	                  {
	                                  ac=randomNO(999,200);
	                                  midtn=randomNO(999,200);
	                                  //String midtn="345";
	                                  lastfour= randomNO(9999,1000);
	                                  ac=phoneline_ac;  //-------------------------------------------------------------
	                                  midtn=phoneline_midtn; //-------------------------------------------------------
	                                  
	                                  driver.findElement(By.id("txtAreaCode")).clear();
	                                    driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
	                                    driver.findElement(By.id("txtExchange")).clear();
	                                    driver.findElement(By.id("txtExchange")).sendKeys(midtn);
	                                    driver.findElement(By.id("txtTelNum")).clear();
	                                    driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);
	                                    focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
	                                    
	                                    Thread.sleep(2000);
	                
	                                  
	                                  if(isElementPresent(driver,By.cssSelector("span.help-block.error")))
	                                  {
	                                	  test.pass("Error displayed on adding 6th Tn");
	                                                  i=statusTracker(i,"Pass","Verify if error message is displayed when adding 6th TN","Error message is displayed","Error message should be displayed","");
	                                  }
	                                  else
	                                  {
	                                                  i=statusTracker(i,"Fail","Verify if error message is displayed when adding 6th TN","Error message is not displayed","Error message should be displayed","");
	                                                  schk="Fail";
	                                                  test.fail("Error displayed on adding 6th Tn");
	                                  }
	                  }
	                  
	                  if(schk.equals("Pass"))
	                  {
	           
	                                  
	                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);      
	                                  schk=orderprocess(driver,br);
	                                  if(schk.equals("Pass"))
	                                  {
	                                	  test.pass("Able To add 5 Tns & process Sucessfully");
	                                                  i=statusTracker(i,"Pass","Verify if adding 5 TNs is processed successfully","Order is successfully processed","Order should be successfully processed","");
	                                                  int count1 =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
	                                                  if(count1==5)
	                                                  {
	                                                	  test.pass("Added 5 Tns present after process");
	                                                                  i=statusTracker(i,"Pass","Verify if 5 TNs are displayed after order process","5 TNs are displayed after order process","TN is displayed after order process","");  
	                                                  }
	                                                  else
	                                                  {
	                                                	  test.fail("Added 5 Tns Not present after process");
	                                                                  i=statusTracker(i,"Fail","Verify if 5 TNs are displayed after order process","5 TNs are not displayed after order process","TN is displayed after order process","");
	                                                                  schk="Fail";
	                                                  }
	                                  }
	                                  else
	                                  {
	                                	  test.pass("Able To add 5 Tns & process Failed");
	                                                  i=statusTracker(i,"Fail","Verify if adding 5 TNs is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	                                                  if(isElementPresent(driver,By.id("modalContinueButton")))
	                                                  {
	                                                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);      
	                                                  }
	                                                  schk="Fail";
	                                  }
	                  }
	                  
	                  return schk;
	  }
}