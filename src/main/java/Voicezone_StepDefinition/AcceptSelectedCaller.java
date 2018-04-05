package Voicezone_StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class AcceptSelectedCaller extends Commonfiles{
	@Given("^Accept Selected Callers Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void accept_Selected_Callers_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
		String schk="Fail";
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("AcceptSelectedCaller", "Execution Report of AcceptSelectedCaller");
	    if(Exe.equals("Yes"))
	    {
	     try{
	       if(first==0) {
	    	login(Username,Password,br,tlim);	
	        }else{
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
		   
		   focusClick(driver,driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[1]")),br);
      	  Thread.sleep(5000);
      	  focusClick(driver,driver.findElement(By.xpath("//div[@id='ContentRefresh']/ul/li[4]/a")),br);
      	  Thread.sleep(5000);
      
        boolean status = driver.findElement(By.id("Activated")).isSelected();
        System.out.println("radio"+status);
        String status1="off";
        if(status)
          status1="on";
                                  
         schk="Pass"; 
                                  
         schk=deleteall(driver,br,test);
                 System.out.println("delete all done");                 
      //  schk=flowrun(driver,br);
                                  
        if(schk.equals("Pass"))
            schk=flowrun(driver,br,test);
                                  
       if(schk.equals("Pass"))
           {
              status = driver.findElement(By.id("Activated")).isSelected();   
              Thread.sleep(5000);
              i=statusTracker(i,"","Verify TN add/remove when feature is "+status,"","","");
              schk=flowrun1(driver,br,test);
             }
            
        if(schk.equals("Pass"))
              schk=flowrun(driver,br,test);
                                  
          if(schk.equals("Pass"))
              {
                 status = driver.findElement(By.id("Activated")).isSelected();                               
                     i=statusTracker(i,"","Verify TN add/remove when feature is "+status,"","","");
                      schk=flowrun1(driver,br,test);      
               }
                                  
               if(schk.equals("Pass"))
                {
                  i=statusTracker(i,"","Verify TN Validation","","","");
                   schk=TNValidation(driver,br,test);
                 }
                                  
               /*  if(schk.equals("Pass"))
                   {
                     statusTracker(br,"","Verify maximum TN operations","","");
                      schk=flowrunmaxtn(driver,br);
                    }*/
                 
                 int count2=driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr")).size();
                 if(count2==0)
                 {	
                 String ac2=randomNO(999,200);
                 String midtn2=randomNO(999,200);
                 String lastfour2=randomNO(999,200);
                 driver.findElement(By.id("txtAreaCode")).clear();
                 driver.findElement(By.id("txtAreaCode")).sendKeys(ac2);
                 driver.findElement(By.id("txtExchange")).clear();
                 driver.findElement(By.id("txtExchange")).sendKeys(midtn2);
                 driver.findElement(By.id("txtTelNum")).clear();
                 driver.findElement(By.id("txtTelNum")).sendKeys(lastfour2);
                 Thread.sleep(1000);
                 focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
                 }
                                
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
    	PrintResult("AcceptSelectedCallers");
    	
        extent.flush();
    }
 }
}
	
	 public String flowrun(WebDriver driver,String br,ExtentTest test) throws Exception
	  {
		                            boolean status = driver.findElement(By.id("Activated")).isSelected();
	                                System.out.println("radio"+status);
	                                String status1="Disabled";
	                                System.out.println("status"+status);
	                                System.out.println("status1"+status1);
	                                String from="",to="";
	                                if(status)
	                                {
	                                                from = "Enabled";
	                                                to="Disabled";
	                                                focusClick(driver,driver.findElement(By.xpath("(//input[@id='Activated'])[2]")),br);
	                                }
	                                else if (!(status))
	                                {
	                                                from = "Disabled";
	                                                to="Enabled";
	                                                focusClick(driver,driver.findElement(By.id("Activated")),br);
	                                                Thread.sleep(3000);
	                                                if(driver.findElement(By.xpath("//html/body/div[4]")).isDisplayed())
	                                                {
	                                                	test.pass("the 911 Warning popup is displayed");
	                                                	i=statusTracker(i,"Pass","Verify if the 911 warning message is displayed","The 911 warning message is being displayed","The 911 warning message should be displayed","");
	                                                                Thread.sleep(2000);
	                                                                focusClick(driver,driver.findElement(By.cssSelector(("#dialog > div.modal-footer > #scaWarningYes"))),br);
	                                                               int chk=0;
	                                                     		      do{
	                                                     		           Thread.sleep(1000);       
	                                                     		          chk++;
	                                                     		          System.out.println(chk);
	                                                     		                }
	                                                     		      while(driver.findElement(By.cssSelector("#dialog > div.modal-footer > #scaWarningYes")).isDisplayed());
	                                                            
	                                                }
	                                                else{
	                                                	test.fail("the 911 Warning popup is displayed");
	                                                	i=statusTracker(i,"Fail","Verify if the 911 warning message is displayed","The 911 warning message is not being displayed","The 911 warning message should be displayed","");
	                                                }
	                                }
	                                Thread.sleep(1000);
	                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	                                String schk=orderprocess(driver,br);
	                  //OMG
	                                //schk="Pass";
	                                if(schk.equals("Fail"))
	                                {
	                                	test.pass("Order is Sucess when switching from "+from+" to "+to);
	                                	i=statusTracker(i,"Fail","Verify order processing when switching from "+from+" to "+to,"Order processing has failed","Order should be processed successfully","");
	                                }
	                                else
	                                {
	                                	test.fail("Order is Failed when switching from "+from+" to "+to);
	                                	i=statusTracker(i,"Pass","Verify order processing when switching from "+from+" to "+to,"Order processing has completed successfully","Order should be processed successfully","");
	                                }
	                                return schk;
	  }
	   
	  protected boolean assertTrue(Object elementPresent) {
	                // TODO Auto-generated method stub
	                return false;
	}

	private Object isElementPresent(WebElement webElement) {
	                // TODO Auto-generated method stub
	                return null;
	}

	public String flowrun1(WebDriver driver,String br,ExtentTest test) throws Exception
	  {
	                  String schk ="Fail";
	                String ac;
	                  String midtn;
	                  String lastfour;
	                  String tn;
	                  int count;
	                 int limit =driver.findElements(By.xpath("//html/body/div[3]/section/form/div[2]/div/div//tr")).size();
	       
	              ac=randomNO(999,200);
	               midtn=randomNO(999,200);
	              //String midtn="345";
	              lastfour= randomNO(9999,1000);
	                  
	                driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
	               driver.findElement(By.id("txtExchange")).sendKeys(midtn);
	                driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);
	                // System.out.println(selenium.getXpathCount("//*[@id='TNGridRefresh']/div"));
	                  Thread.sleep(5000);
	                  focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
	                  Thread.sleep(4000);
	                  tn=ac+midtn+lastfour;
	                  
	                
	                  //System.out.println(selenium.getXpathCount("//*[@id='TNGridRefresh']/div"));
	                  
	                  count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr")).size();
	                  System.out.println("tns present: " +count);
	                  int chk=0;
	                  for(int i=1;i<=count;i++)
	                  {
	                                String a=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr["+i+"]/td/input")).getAttribute("value");                                
	                                 //System.out.println(selenium.getValue("//html/body/div/section/form/div[2]/div/div["+(i+1)+"]/table/tbody/tr/td//input"));
	                                  if(a.equals(tn))
	                                  //if((selenium.getValue("//html/body/div/section/form/div[2]/div/div/div["+(i+1)+"]/table/tbody/tr/td//input")).equals(tn))
	                                  {
	                                	  test.pass("The Added TN is present in the List");
	                                	  i=statusTracker(i,"Pass","Verify if added TN is present in the list","Added TN is present in the list","Added TN should be present in the list","");
	                                                  chk=1;
	                                                  schk="Pass";
	                                  }
	                  }
	                  if(chk==0)
	                  {
	                	  test.fail("The Added TN not present in the List");
	                	  i=statusTracker(i,"Fail","Verify if added TN is present in the list","Added TN is not present in the list","Added TN should be present in the list","");
	                                                schk="Fail";
	                  }
	                  if(schk.equals("Pass"))
	                  {
	                	  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	                                  schk=orderprocess(driver,br);
	                                  boolean chk1=false;
	                                  //schk="Pass";
	                                  if(schk.equals("Pass"))
	                                  {
	                                	  test.pass("The Order is Sucess for Add Number");
	                                	  i=statusTracker(i,"Pass","Verify if add TN order is processed successfully","Order is successfully processed","Order should be successfully processed","");  
	                                                  int count1 =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr")).size();
	                                                 
	                                                  String elem="TN_"+ tn;
	                                                  System.out.println("elem"+elem);
	                                                  for(int cn=1;cn<=count1;cn++)
	                                                  {
	                                                	 String ck= driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr["+cn+"]/td/input")).getAttribute("value");
	                                                	 if(ck.equals(tn))
	                                                	 {
	                                                		  chk1=true;
	                                                	 }
	                                                	 Thread.sleep(5000);
	                                                  }
	                                                  if(chk1)
	                                                  {
	                                                	  test.pass("The Order is Sucess & TN is present after Add");
	                                                	  i=statusTracker(i,"Pass","Verify if TN is displayed after order process","TN is displayed after order process","TN is displayed after order process","");  
	                                                  }
	                                                  else
	                                                  {
	                                                	  test.pass("The Order is Sucess & TN is not present after Add");
	                                                	  i=statusTracker(i,"Fail","Verify if TN is displayed after order process","TN is not displayed after order process","TN is displayed after order process","");
	                                                                  schk="Fail";
	                                                  }
	                                  }
	                                  else
	                                  {
	                                	  test.pass("The Order is Failed for Add Number");
	                                	  i=statusTracker(i,"Fail","Verify if add TN order is processed successfully","Order is not successfully processed","Order should be successfully processed","");                                                  
	                                                  schk="Fail";
	                                  }
	                  }                         
	                                  
	                  if(schk.equals("Pass"))
	                  {
	                	  Thread.sleep(5000);
	                	  focusClick(driver,driver.findElement(By.id("DeleteNumber_"+ tn )),br);                                 
	                                  Thread.sleep(5000);
	                                  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	                                  schk=orderprocess(driver,br);
	                                  boolean chk2=false;
	                                ///OMG
	                                  //schk="Pass";
	                                  if(schk.equals("Pass"))
	                                  {
	                                	  test.pass("The Order is Sucess for Delete Number");
	                                	  i=statusTracker(i,"Pass","Verify if remove TN order is processed successfully","Order is successfully processed","Order should be successfully processed","");  
	                                                  //int count1 =selenium.getXpathCount("//*[@id='TNGridRefresh']/div").intValue();
	                                                  int count1 =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr")).size();
	                                                  
	                                                  String elem="TN_"+tn;
	                                                  System.out.println("elem1"+elem);
	                                                  for(int cn1=1;cn1<=count1;cn1++)
	                                                  {
	                                                	 String ck1= driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr["+cn1+"]/td/input")).getAttribute("value");
	                                                	 if(ck1.equals(tn))
	                                                	 {
	                                                		  chk2=true;
	                                                	 }
	                                                  }
	                                                  if(!(chk2))
	                                                  {
	                                                	  test.pass("The Order is Sucess & TN is not present after Delete");
	                                                	  i=statusTracker(i,"Pass","Verify if TN is not displayed after order process","TN is not displayed after order process","TN is not displayed after order process","");  
	                                                  }
	                                                  else
	                                                  {
	                                                	  test.fail("The Order is Sucess & TN is present after Delete");
	                                                	  i=statusTracker(i,"Fail","Verify if TN is not displayed after order process","TN is displayed after order process","TN is not displayed after order process","");
	                                                                  schk="Fail";
	                                                  }
	                                  }
	                                  else
	                                  {
	                                	  test.fail("The Order is failed for Delete Number");
	                                                  i=statusTracker(i,"Fail","Verify if remove TN order is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	                                                  schk="Fail";
	                                  }
	                                  
	                                  
	                  }
	                  
	                  return schk;
	  }
	  
	  private Object isElementPresent(List<WebElement> findElements) {
	                // TODO Auto-generated method stub
	                return null;
	}

	public String deleteall(WebDriver driver,String br,ExtentTest test) throws Exception
	  {
	                  String schk ="Fail";
	                  int chk;
	                  
	                int count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr")).size();
	                  System.out.println("count"+count);
	                  String tn;
	                  
	                  if(count!=0)
	                  {
	                                  for(int i=1;i<=count;i++)
	                                  {
	                                                 Thread.sleep(2000); 
	                                                  tn=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr["+i+"]/td/input")).getAttribute("value");
	                                                  System.out.println(tn);
	                                                  //selenium.click("//*[@id='DeleteNumber_"+ tn + "']");
	                                                  Thread.sleep(5000);
	                                                  focusClick(driver,driver.findElement(By.id("DeleteNumber_"+ tn )),br);
	                                                  Thread.sleep(5000);
	                                                  i=0;
	                                                  count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr")).size();
	                                                  System.out.println("ss: "+count);
	                                  }
	                                  System.out.println("outside the loop");
	                                  boolean status = driver.findElement(By.id("Activated")).isSelected();
	                                  if(!(status))
	                                  {
	                                	  focusClick(driver,driver.findElement(By.xpath("(//input[@id='Activated'])[2]")),br);                                                            
	                                  }
	                                  Thread.sleep(2000);
	                                  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	                                  schk=orderprocess(driver,br);
	                                  
	                                  status = driver.findElement(By.id("Activated")).isSelected();
	                                  if(status)
	                                  {
	                                	  focusClick(driver,driver.findElement(By.id("Activated")),br);
	                                       Thread.sleep(3000);
	                                       focusClick(driver,driver.findElement(By.cssSelector("#dialog > div.modal-footer > #scaWarningYes")),br);
	                                 
	                                        chk=0;
	                           		      do{
	                           		           Thread.sleep(1000);       
	                           		          chk++;
	                           		          System.out.println(chk);
	                           		                }
	                           		      while(driver.findElement(By.cssSelector("#dialog > div.modal-footer > #scaWarningYes")).isDisplayed());
	                                  
	                                  }
	                                  Thread.sleep(2000);
	  
	                                  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	                                 
	                                  //schk=orderprocess();
	                                  if(driver.findElement(By.cssSelector("span.help-block.error")).isDisplayed())
	                                  {
	                                	  test.pass("Error message is displayed: "+ driver.findElement(By.cssSelector(("span.help-block.error"))).getText());
	                                                  i=statusTracker(i,"Pass","Verify if error message is displayed when trying to enable feature with no TNs","Error message is displayed: "+ driver.findElement(By.cssSelector(("span.help-block.error"))).getText(),"Error message should be displayed","");
	                                  }
	                                  else
	                                  {
	                                	  test.fail("Error message is Not displayed when ON without Number");
	                                                  i=statusTracker(i,"Fail","Verify if error message is displayed when trying to enable feature with no TNs","Error message is not displayed","Error message should be displayed","");
	                                                  schk="Fail";
	                                  }
	                                  
	                                  
	                  }
	                  if(!((assertTrue(isElementPresent(By.cssSelector("td.phone"))))))
	                  {

	                        String ac1 = randomNO(999,200);
	                        String midtn1 = randomNO(999,200);
	                        //String midtn="345";
	                        String lastfour1 = randomNO(9999,1000);
	                        System.out.println("ac1"+ac1);
	                        System.out.println("midtn1"+midtn1);
	                        System.out.println("lastfour1"+lastfour1);
	                        driver.findElement(By.id("txtAreaCode")).sendKeys(ac1);
	                        driver.findElement(By.id("txtExchange")).sendKeys(midtn1);
	                        driver.findElement(By.id("txtTelNum")).sendKeys(lastfour1);
	                        Thread.sleep(3000);
	                        focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
	                        Thread.sleep(3000);
	                        focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	                        schk=orderprocess(driver,br);
	                  }
	  return schk;
	}
	  
	  protected Object isElementPresent(By xpath) {
	                // TODO Auto-generated method stub
	                return null;
	}

	public String flowrunmaxtn(WebDriver driver,String br,ExtentTest test) throws Exception
	  {
	                  String schk ="Fail";
	                                    
	                  String ac0;
	                  String midtn0;
	                  String lastfour0;
	                  String tn;
	                  int count;
//	              TN=TN+lastfour;
	                   count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr")).size();
	                  if (count==30)
	                	  schk ="Pass";
	                  
	                  while(count<30){
	                                  ac0=randomNO(999,200);
	                                  if(ac0.equals("900") || ac0.equals("976"))
	                                       ac0=randomNO(999,200);  
	                                  
	                                  midtn0=randomNO(999,200);
	                                  //String midtn="345";
	                                  lastfour0= randomNO(9999,1000);
	                      driver.findElement(By.id("txtAreaCode")).clear();
	                      driver.findElement(By.id("txtAreaCode")).sendKeys(ac0);
	                      driver.findElement(By.id("txtExchange")).clear();
	                      driver.findElement(By.id("txtExchange")).sendKeys(midtn0);
	                      driver.findElement(By.id("txtTelNum")).clear();
	                      driver.findElement(By.id("txtTelNum")).sendKeys(lastfour0);
	                      Thread.sleep(5000);
	                      focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
	                      //driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	                      tn=ac0+midtn0+lastfour0;
	                      System.out.println("tn"+tn);
	                      Thread.sleep(4000);
	                    count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr")).size();
	                    System.out.println("count"+count);
	                    int chk=0;
	                    for(int i=1;i<=count;i++)
	                    {
	                      Thread.sleep(5000);
	                	  String tn1=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div[5]/table/tbody/tr["+i+"]/td/input")).getAttribute("value");
	                	  System.out.println("tn1"+tn1);
	                	  System.out.println("tn"+tn);
	                	  Thread.sleep(5000);
	                                if(tn1.equals(tn))
	                                  {
	                                		test.pass("The Added TNs are present in the list");
	                                                  i=statusTracker(i,"Pass","Verify if added TN is present in the list","Added TN is present in the list. Added TN: "+count,"Added TN should be present in the list","");
	                                                  chk=1;
	                                                  schk="Pass";
	                                  }
	                    }
	                    if(chk==0)
	                    {
	                    	test.pass("The Added TNs are Not present in the list");
	                                                i=statusTracker(i,"Fail","Verify if added TN is present in the list","Added TN is not present in the list. Total Tns present "+count,"Added TN should be present in the list","");
	                                                schk="Fail";
	                    }
	                    int errmesg1= driver.findElements(By.cssSelector("span.help-block.error")).size();
	                    if(errmesg1>0)
	                    {
	                    	test.fail("The Error displayed on adding TN when list is not 30");
	                                                 i=statusTracker(i,"Fail","Verify if 30 TNs can be added to the list","Error message is present before the 30 TNs are completed added","TN should be added to the list","");
	                                                 schk="Fail";
	                    }
	                  }
	                                  
	                  if(schk.equals("Pass"))
	                  {
	                                  ac0=randomNO(999,200);
	                                  midtn0=randomNO(999,200);
	                                  //String midtn="345";
	                                  lastfour0= randomNO(9999,1000);
	                                  driver.findElement(By.id("txtAreaCode")).sendKeys(ac0);
	                                  driver.findElement(By.id("txtExchange")).sendKeys(midtn0);
	                                  driver.findElement(By.id("txtTelNum")).sendKeys(lastfour0);
	                                  //System.out.println(selenium.getXpathCount("//*[@id='TNGridRefresh']/div"));
	                                  Thread.sleep(5000);
	                                  focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
	                                  
	                                  tn=ac0+midtn0+lastfour0;

	                                  Thread.sleep(2000);
	                                  int errmesg2=driver.findElements(By.cssSelector("span.help-block.error")).size();                                  
	                                  if(errmesg2>0)
	                                  {
	                                	  test.pass("The Error message is displayed on adding 31st TN");
	                                                  i=statusTracker(i,"Pass","Verify if error message is displayed when adding 31st TN","Error message is displayed","Error message should be displayed","");
	                                  }
	                                  else
	                                  {
	                                	  test.fail("The Error message is displayed on adding 31st TN");
	                                                  i=statusTracker(i,"Fail","Verify if error message is displayed when adding 31st TN","Error message is not displayed","Error message should be displayed","");
	                                                  schk="Fail";
	                                  }
	                  }
	                  
	                  if(schk.equals("Pass"))
	                  { 
	                	  Thread.sleep(5000);
	                	  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	                                  schk=orderprocess(driver,br);
	                                
	                                  ///OMG
	                                  //schk="Pass";
	                                  if(schk.equals("Pass"))
	                                  {
	                                	  test.pass("The order process is sucess for adding 30 TNs");
	                                                  i=statusTracker(i,"Pass","Verify if adding 30 TNs is processed successfully","Order is successfully processed","Order should be successfully processed","");  
	                                                  int count1 =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div/div/div[5]/table/tbody//tr")).size();
	                                                  if(count1==30)
	                                                  {
	                                                	  test.pass("The order process is sucess & all 30 TNs are present");
	                                                                  i=statusTracker(i,"Pass","Verify if 30 TNs are displayed after order process","30 TNs are displayed after order process","TN is displayed after order process","");  
	                                                  }
	                                                  else
	                                                  {
	                                                	  test.fail("The order process is not sucess & all 30 TNs are not present");
	                                                                  i=statusTracker(i,"Fail","Verify if 30 TNs are displayed after order process","30 TNs are not displayed after order process","TN is displayed after order process","");
	                                                                  schk="Fail";
	                                                  }
	                                  }
	                                  else
	                                  {
	                                	  test.fail("The order process is not sucess for adding 30 TNs");
	                                                  i=statusTracker(i,"Fail","Verify if adding 30 TNs is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	                                                  schk="Fail";
	                                  }
	                  }
	                  
	                  return schk;
	  }
	  
	  public String TNcheck(String ac, String midtn, String lastfour, String check ,WebDriver driver,String br,ExtentTest test) throws Exception
	  {
	                  String schk="Fail";
	                  int limit =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div/div/div[5]/table/tbody//tr")).size();
	                  int count;
	                  String tn;
	                  driver.findElement(By.id("txtAreaCode")).clear();
	                  driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
	                  driver.findElement(By.id("txtExchange")).clear();
	                  driver.findElement(By.id("txtExchange")).sendKeys(midtn);
	                  driver.findElement(By.id("txtTelNum")).clear();
	                  driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);
	                 
	                  focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
	                  Thread.sleep(5000);
	                  tn=ac+midtn+lastfour;
	                
	                  count=driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div/div/div/div[5]/table/tbody//tr")).size();
	                  Thread.sleep(3000);
	                  boolean errmesg= driver.findElement(By.cssSelector("span.help-block.error")).isDisplayed();
	                  System.out.println("error"+errmesg);
	                  
	                  if(errmesg && count==limit)
	                  {
	                	  test.pass("Error message is displayed: "+check+ " " + driver.findElement(By.cssSelector("span.help-block.error")).getText());
	                                  i=statusTracker(i,"Pass","Verify if error message is displayed when adding "+check+" TN","Error message is displayed: "+ driver.findElement(By.cssSelector("span.help-block.error")).getText(),"Error message should be displayed","");
	                                  schk="Pass";
	                  }
	                  else
	                  {
	                	  test.fail("Error message is Not displayed: "+check);
	                                  i=statusTracker(i,"Fail","Verify if error message is displayed when adding "+check+" TN","Error message is not displayed","Error message should be displayed","");
	                                  schk="Fail";
	                  }
	                  
	                  
	                  return schk;
	  }
	  
	  public String TNValidation(WebDriver driver,String br,ExtentTest test) throws Exception
	  {
	                  String schk ="Pass";
	                  String ac1 = null;
	                  String midtn1 = null;
	                  String lastfour1=null;
	                  schk=TNcheck("022","300","4000","first digit 0",driver,br,test);
	                  Thread.sleep(5000);
	                  schk=TNcheck("222","000","4000","fourth digit 0",driver,br,test);
	                  Thread.sleep(5000);
	                  schk=TNcheck("122","300","4000","first digit 1",driver,br,test);
	                  Thread.sleep(5000);
	                  schk=TNcheck("222","152","4000","fourth digit 1",driver,br,test);
	                  Thread.sleep(5000);
	                  schk=TNcheck("222","000","4000","fourth digit 0",driver,br,test);
	                  Thread.sleep(5000);
	                 // schk=TNcheck("","","","blank",driver,br);
	                 // Thread.sleep(5000);
	                //  schk=TNcheck(ac1,midtn1,lastfour1,"existing",driver,br);
	                //  Thread.sleep(5000);
	                  schk=TNcheck("99","9","99","Invalid",driver,br,test);  
	                  Thread.sleep(5000);
	                  schk="Pass";
	                  return schk;
	}
}
