package Voicezone_StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class SelectiveCallForwarding extends Commonfiles {
	  
    String table, tns[];
String tlimit,username,pwd;
int tncount;                                                    
                    
String phoneline,phoneline_ac,Acccode;
    int rank[]= new int[50];
    

    int c_sequence;
    String name_for_rank[]= new String[40],slftn,phoneline_midtn,phoneline_lastfour,ac1,midtn1,lastfour1;
    String price, rank_channels;

    @Given("^SelectiveCallForwarding Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void SelectiveCallForwarding_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
		String schk="Fail";
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("AcceptSelectedCaller", "Execution Report of AcceptSelectedCaller");
		    if(Exe.equals("Yes"))
		    {
		    try{
		       if(first==0) {
		    	login(Username,Password,br,tlim);	
		       }
		        else
			    {
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
			 focusClick(driver,driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[4]")),br);
        	  Thread.sleep(5000);
        	  focusClick(driver,driver.findElement(By.xpath("//div[@id='ContentRefresh']/ul/li[4]/a")),br);			
        	  Thread.sleep(3000);
              driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

              String status=driver.findElement(By.id("SCFActivatedOn")).getAttribute("class");			
              String status1="off";
              if(status.equals("btn"))
            	  status1="on";
              Thread.sleep(5000);
              schk=deleteall(driver,br,test);

              if(schk.equals("Pass"))
            	  schk=flowrun(driver,br,test);

              if(schk.equals("Pass"))
            	  schk=flowrun(driver,br,test);

              if(schk.equals("Pass"))
              {
            	  status = driver.findElement(By.id("SCFActivatedOn")).getAttribute("class");
            	  if(status.equals("btn"))
            		  status="Off";
            	  else
            		  status="On";
            	  test.info("Verify TN add/remove when feature is "+status);
            	  i=statusTracker(i,"","Verify TN add/remove when feature is "+status,"","","");
            	  schk=flowrun1(driver,br,test);
              }

              if(schk.equals("Pass"))
              {
            	  focusClick(driver,driver.findElement(By.id("SCFActivatedOff")),br);				
            	  status = driver.findElement(By.id("SCFActivatedOn")).getAttribute("class");
	
            	  if(status.equals("btn"))
            		  status="Off";
            	  else
            		  status="On";
            	  test.info("Verify TN add/remove when feature is "+status);
            	  i=statusTracker(i,"","Verify TN add/remove when feature is "+status,"","","");
            	  schk=flowrun1(driver,br,test);
              }

              if(schk.equals("Pass"))
              {
            	  test.info("Verify From TN Validation");
            	  i=statusTracker(i,"","Verify From TN Validation","","","");
            	  schk=TNValidation(driver,br,test);
              }

              if(schk.equals("Pass"))
              {
            	  test.info("Verify To TN Validation");
            	  i=statusTracker(i,"","Verify To TN Validation","","","");
            	  schk=TNValidation2(driver,br,test);
              }
              Thread.sleep(2000);
              focusClick(driver,driver.findElement(By.id("mainCancelButton")),br);

/*if(schk.equals("Pass"))
{
	statusTracker(br,"","Verify maximum TN operations","","");
	schk=flowrunmaxtn(driver,br);
}*/
	Thread.sleep(2000);
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
	    	PrintResult("SelectiveCallForwarding");
	        extent.flush();
	    }
	 }
	}
    
    public String flowrun(WebDriver driver,String br,ExtentTest test) throws Exception
    {
  	  	focusClick(driver,driver.findElement(By.id("SCFStatusdrop")),br);//Dropdown
  		Thread.sleep(5000);
  		int listcount=driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div/div[7]/div/div/ul/li")).size();			
  		System.out.println("listcount"+listcount);
  		String text[]=new String[listcount+1];
  		for(int i=1;i<=listcount;i++)
  		{
  			WebElement labelNode = driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div/div[7]/div/div/ul/li["+i+"]//a")); 
  			String labelNodeText = (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML",labelNode);
  			labelNodeText=labelNodeText.substring(21,labelNodeText.length()-16);
  			labelNodeText=labelNodeText.replaceAll("\\n","");
  			text[i]=labelNodeText;
  			System.out.println("String: "+labelNodeText);	
  			System.out.println("TN "+text[i]);
  		}
  		String j=randomNO(listcount,2);
  		int k=Integer.parseInt(j);
  		focusClick(driver,driver.findElement(By.id("ddlSCFnum")),br);
  		Thread.sleep(2000);
  		focusClick(driver,driver.findElement(By.linkText(text[k])),br);
  		Thread.sleep(2000);
  	
  	Thread.sleep(2000);
  	focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);	
  	String schk=orderprocess(driver,br);
  	
  	if(schk.equals("Fail"))
  	{
  		test.fail("Failed: switching from Alternate TN to dropdown");
  		i=statusTracker(i,"Fail","Verify order processing when switching from Alternate TN to dropdown","Order processing has failed","Order should be processed successfully","");	
  	}
  	else
  	{
  		test.pass("Sucess: switching from Alternate TN to dropdown");
  		i=statusTracker(i,"Pass","Verify order processing when switching from Alternate TN to dropdown","Order processing has processed successfully","Order should be processed successfully","");
  		Thread.sleep(1000);
  		String acchk=driver.findElement(By.id("txtAreaCode2")).getAttribute("value");
  		String midtnchk=driver.findElement(By.id("txtExchange2")).getAttribute("value");
  		String lastfourchk=driver.findElement(By.id("txtTelNum2")).getAttribute("value");
  		
  		String tn = acchk+midtnchk+lastfourchk;
  		tn="("+tn.substring(0,3)+") "+tn.substring(3,6)+"-"+tn.substring(6);
  		text[k]=text[k].substring(0, 14);
  		System.out.println(text[k]+" SSS "+tn);
  		if(tn.equals(text[k]))
  		{
  			i=statusTracker(i,"Pass","Verify if the TN selected from the dropdown is reflected in the Alternate TN field","After order processing, the TN is reflected in the Alternate TN field","After order processing, the TN should be reflected in the Alternate TN field","");
  			schk="Pass";
  			test.pass("TN selected from the dropdown is reflected in the Alternate TN field");
  		}
  		else{
  			test.fail("TN selected from the dropdown is Not reflected in the Alternate TN field");
  			i=statusTracker(i,"Fail","Verify if the TN selected from the dropdown is reflected in the Alternate TN field","After order processing, the TN is not reflected in the Alternate TN field","After order processing, the TN should be reflected in the Alternate TN field","");
  		  }
  		}
  	
  	return schk;
   }
     
    public String flowrun1(WebDriver driver,String br,ExtentTest test) throws Exception
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
  		  driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
  		  driver.findElement(By.id("txtExchange")).sendKeys(midtn);
  		  driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);
  	 // System.out.println(selenium.getXpathCount("//*[@id='TNGridRefresh']/div"));
  	  Thread.sleep(1000);
  	  focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
  	  
  	  tn=ac+midtn+lastfour;
  	  
  	  Thread.sleep(5000);
  	  
  	  count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr")).size();		
   	
  	  int chk=0;
  	  for(int i=1;i<=count;i++)
  	  {
  		  
  		  
  		  if((driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr["+i+"]/td/input")).getText()).equals(tn));		
  	  	  {
  	  		  test.pass("Added TN is present in the list");
  			  i=statusTracker(i,"Pass","Verify if added TN is present in the list","Added TN is present in the list","Added TN should be present in the list","");
  			  chk=1;
  			  schk="Pass";
  		  }
  	  }
  	  if(chk==0)
  	  {
  		  test.fail("Added TN is not present in the list");
  		  	i=statusTracker(i,"Fail","Verify if added TN is present in the list","Added TN is not present in the list","Added TN should be present in the list","");
  		  	schk="Fail";
  	  }
  	  if(schk.equals("Pass"))
  	  {
  		  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
  		 
  		  schk=orderprocess(driver,br);
  		  Thread.sleep(5000);
  		
  		  if(schk.equals("Pass"))
  		  {
  			test.pass("Add Tn Order is Sucess");
  			  i=statusTracker(i,"Pass","Verify if add TN order is processed successfully","Order is successfully processed","Order should be successfully processed","");  
  			  int count1 =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr")).size();		
  			  
  			  String elem="DeleteNumber_"+ tn;
  			  System.out.println("elem"+elem);
  			  if(driver.findElement(By.id(elem)).isDisplayed())
  			  {
  				test.pass("Sucess: TN Present After Add Tn Order");
  				  i=statusTracker(i,"Pass","Verify if TN is displayed after order process","TN is displayed after order process","TN is displayed after order process","");  
  			  }
  			  else
  			  {
  				test.fail("Failed: TN Not Present After Add Tn Order");
  				  i=statusTracker(i,"Fail","Verify if TN is displayed after order process","TN is not displayed after order process","TN is displayed after order process","");
  				  schk="Fail";
  			  }
  		  }
  		  else
  		  {
  			test.fail("Add Tn Order is Failed");
  			  i=statusTracker(i,"Fail","Verify if add TN order is processed successfully","Order is not successfully processed","Order should be successfully processed","");			  
  			  schk="Fail";
  		  }
  	  }
 		  
  	  if(schk.equals("Pass"))
  	  {
  		  focusClick(driver,driver.findElement(By.id("DeleteNumber_"+ tn )),br);
  		  
  		  Thread.sleep(3000);
  		  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
  		  schk=orderprocess(driver,br);

  		  if(schk.equals("Pass"))
  		  {
  			  i=statusTracker(i,"Pass","Verify if remove TN order is processed successfully","Order is successfully processed","Order should be successfully processed","");  
  			 test.pass("Remove Tn Order is Sucess");
  			  int count1 =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr")).size();		
  			  
  			  String elem="TN_"+ tn;
  			  
  			  if(!(assertTrue(isElementPresent(By.cssSelector(elem)))))
  			  {
  				test.pass("Sucess: TN Not Present After Remove Tn Order");
  				  i=statusTracker(i,"Pass","Verify if TN is not displayed after order process","TN is not displayed after order process","TN is not displayed after order process","");  
  			  }
  			  else
  			  {
  				test.fail("Failed: TN Present After Remove Tn Order");
  				  i=statusTracker(i,"Fail","Verify if TN is not displayed after order process","TN is displayed after order process","TN is not displayed after order process","");
  				  schk="Fail";
  			  }
  		  }
  		  else
  		  {
  			  i=statusTracker(i,"Fail","Verify if remove TN order is processed successfully","Order is not successfully processed","Order should be successfully processed","");
  			  test.fail("Remove Tn Order is Failed");
  		  }
		  
  	  }
  	  
  	  return schk;
    }
    
    public String deleteall(WebDriver driver,String br,ExtentTest test) throws Exception
    {
  	  String schk ="Fail";
  	  int chk;
  	  
  	  int count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr")).size();		
  	  System.out.println("count"+count);
  	  String tn;
  	  	  
  	  Thread.sleep(2000);
  	  
  	  boolean chk1=assertTrue(isElementPresent(By.cssSelector("td.phone.carddiv")));
  	  
  
  	  if(count!=0)
  	  {
  		  for(int i=1;i<=count;i++)
  		  {
  			  
  			
  			  tn=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr["+i+"]/td/input")).getAttribute("value");
  			  
  			  System.out.println("tn"+tn);
  			  Thread.sleep(3000);
  			
  			  focusClick(driver,driver.findElement(By.id("DeleteNumber_"+ tn)),br);
  			  
  			
  			  Thread.sleep(1000);			  
  			  count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[4]/table/tbody//tr")).size();		
  			  System.out.println("ss: "+count);
  			 
  		  }
  		  
  		  String status= driver.findElement(By.id("SCFActivated")).getAttribute("class");
  		  System.out.println("class is : "+status);


  		  if(!(status.equals("btn active")))
  		  {
  			  System.out.println("class is : off");
  			  focusClick(driver,driver.findElement(By.id("SCFActivatedOff")),br);
  			  
  		  }
  		  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
  		  schk=orderprocess(driver,br);
  		  if(schk.equals("Fail"))
  		  {
  			  test.fail("Order Failed for Delete All");
  			  i=statusTracker(i,"Fail","Verify if order processing is being done successfully","Order processing was not successfully completed","Order processing should be successfully completed","");
  		  }
  	  }
  	  else 
  		  schk="Pass";
  	  
  	  System.out.println("outside");
  	  
  	  if(!(assertTrue(isElementPresent(By.cssSelector("td.phone")))) && schk.equals("Pass"))
  	  {
  		 
  		  count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[4]/table/tbody//tr")).size();		
  		  System.out.println(count);
  		  
  		  System.out.println("inside");
  		  
  		  String status= driver.findElement(By.id("SCFActivated")).getAttribute("value");
  		  System.out.println("status"+status);
  		  System.out.println("after");
  		  if(status.equals("false"))
  		  {
  			  focusClick(driver,driver.findElement(By.id("SCFActivatedOn")),br);
  		  }
    
  		  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
  		  schk=orderprocess(driver,br);
  		  
  		  if(driver.findElement(By.cssSelector("span.help-block.error")).isDisplayed())
  		  {
  			  test.pass("Error Displayed enable feature with no Forward To TN");
  			  i=statusTracker(i,"Pass","Verify if error message is displayed when trying to enable feature with no Forward To TN","Error message is displayed: " + driver.findElement(By.cssSelector("span.help-block.error")).getText(),"Error message should be displayed","");
  		  }
  		  else
  		  {
  			  test.fail("No Error Displayed enable feature with no Forward To TN");
  			  i=statusTracker(i,"Fail","Verify if error message is displayed when trying to enable feature with no Forward To TN","Error message is not displayed","Error message should be displayed","");
  			  schk="Fail";
  		  }
  		  
  		  
  		  status= driver.findElement(By.id("SCFActivated")).getAttribute("value");
  		  if(status.equals("true"))
  		  {
  			  focusClick(driver,driver.findElement(By.id("SCFActivatedOn")),br);
  		  }
  		  
  		  slftn=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[2]/div/button/span")).getAttribute("data-friendlyname-contact");
  			System.out.println("selftn"+slftn);
  		    String ac=slftn.substring(0,3);
  			String midtn=slftn.substring(3,6);
  		  
  		 
  		  String lastfour= randomNO(9999,1000);
  	  
  		  driver.findElement(By.id("txtAreaCode2")).sendKeys(ac);
  		  driver.findElement(By.id("txtExchange2")).sendKeys(midtn);
  		  driver.findElement(By.id("txtTelNum2")).sendKeys(lastfour);
  		  Thread.sleep(1000);
  		 
  		  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
  		  
  		  String a1="";
  		  do{
  			  try{
  				  
  			  a1=driver.findElement(By.cssSelector("span.help-block.error")).getText();
  			  System.out.println("aaaaaaa0.5");
  			  }
  			  catch(Exception e)
  			  {
  				  System.out.println("Exception caught");
  				  a1="";
  			  }
  		  }while(a1.equals(""));
  		  
  		  Thread.sleep(1000);
  		 		  
  	
  		  if(driver.findElement(By.cssSelector("span.help-block.error")).isDisplayed())
  		  {			 
  			  
  			  i=statusTracker(i,"Pass","Verify if error message is displayed when trying to enable feature with no TNs","Error message is displayed: " + driver.findElement(By.cssSelector("span.help-block.error")).getText(),"Error message should be displayed","");
  			  test.pass("Error Displayed on Enabling without Tn:"+driver.findElement(By.cssSelector("span.help-block.error")).getText());
  			  slftn=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[2]/div/button/span")).getAttribute("data-friendlyname-contact");
  				System.out.println("selftn"+slftn);
  			    String ac2=slftn.substring(0,3);
  				String midtn2=slftn.substring(3,6);
  			 
  			  String lastfour2= randomNO(9999,1000);
  		  
  			  driver.findElement(By.id("txtAreaCode")).sendKeys(ac2);
  			  driver.findElement(By.id("txtExchange")).sendKeys(midtn2);
  			  driver.findElement(By.id("txtTelNum")).sendKeys(lastfour2);
  		
  			  Thread.sleep(1000);
  			  focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);		
  			  Thread.sleep(3000);
  			  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);			  
  			  schk=orderprocess(driver,br);
  			  if(schk.equals("Pass"))
  			  {
  				  test.pass("Order Process is Sucess for Add Tn");
  				  i=statusTracker(i,"Pass","Verify if order processing is done successfully for adding a TN","Order processing is done successfully","Order processing should be done successfully","");
  				  schk="Pass";
  			  }
  			  else
  			  {
  				test.fail("Order Process is Failed for Add Tn");
  				  i=statusTracker(i,"Fail","Verify if order processing is done successfully for adding a TN","Order processing is not done successfully","Order processing should be done successfully","");
  			  }
  			  
  		  }
  		  else
  		  {
  			  test.fail("No Error Message on enabling without Tn");
  			  i=statusTracker(i,"Fail","Verify if error message is displayed when trying to enable feature with no TNs","Error message is not displayed","Error message should be displayed","");
  			  schk="Fail";
  		  }
  	
  	  }
    return schk;
  }
    protected Object isElementPresent(By cssSelector) {
    	// TODO Auto-generated method stub
    	return null;
    }
    public String flowrunmaxtn(WebDriver driver,String br,ExtentTest test) throws Exception
    {
  	  String schk ="Fail";
  	  String ac;
  	  String midtn;
  	  String lastfour;
  	  String tn;
  	  int count;
  	  

  	  int limit =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr")).size();		
  	  
  	  do{
  		  ac=randomNO(999,200);
  		  midtn=randomNO(999,200);
  	
  		  lastfour= randomNO(9999,1000);
  	  
  		  driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
  		  driver.findElement(By.id("txtExchange")).sendKeys(midtn);
  		  driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);

  		
  		  Thread.sleep(5000);
  		  focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);		
  		  
  		  tn=ac+midtn+lastfour;
  		 
  		  Thread.sleep(10000);
  		  
  		 
  		  count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr")).size();		
  		  int chk=0;
  		  for(int i=1;i<=count;i++)
  		  {
  			  Thread.sleep(3000);
  			 
  			  System.out.println(driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr["+i+"]/td/input")).getText());
  			  if((driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr["+i+"]/td/input")).getText()).equals(tn))
  			  {
  				  test.pass("Added TN is present in the list. Added TN: "+count);
  				  i=statusTracker(i,"Pass","Verify if added TN is present in the list","Added TN is present in the list. Added TN: "+count,"Added TN should be present in the list","");
  				  chk=1;
  				  schk="Pass";
  			  }
  		  }
  		  if(chk==0)
  		  {
  			test.fail("Added TN is not present in the list. Total Tns present "+count);
  			  	i=statusTracker(i,"Fail","Verify if added TN is present in the list","Added TN is not present in the list. Total Tns present "+count,"Added TN should be present in the list","");
  			  	schk="Fail";
  		  }
  		  if(assertTrue(isElementPresent(By.cssSelector("span.help-block.error"))))
  		  {
  			  test.fail("Error Present before adding 30 Tns");
  			  		i=statusTracker(i,"Fail","Verify if 30 TNs can be added to the list","Error message is present before the 30 TNs are completed added","TN should be added to the list","");
  			  		schk="Fail";
  		  }
  	  }while(count<30 && schk.equals("Pass"));
  		  
  	  if(schk.equals("Pass"))
  	  {
  		  ac=randomNO(999,200);
  		  midtn=randomNO(999,200);
  		  
  		  lastfour= randomNO(9999,1000);
  		  driver.findElement(By.id("txtAreaCode")).sendKeys(ac);
  		  driver.findElement(By.id("txtExchange")).sendKeys(midtn);
  		  driver.findElement(By.id("txtTelNum")).sendKeys(lastfour);

  		 
  		  Thread.sleep(2000);
  		  focusClick(driver,driver.findElement(By.id("AddToPhoneNumbers")),br);
  		  
  		  tn=ac+midtn+lastfour;
  		
  		  
  		  Thread.sleep(3000);
  		  if(assertTrue(isElementPresent(By.cssSelector("span.help-block.error"))))
  		  {
  			  test.pass("Error Message displayed for Adding 31 Tns"+driver.findElement(By.cssSelector("span.help-block.error")).getText());
  			  i=statusTracker(i,"Pass","Verify if error message is displayed when adding 31st TN","Error message is displayed: " + driver.findElement(By.cssSelector("span.help-block.error")).getText(),"Error message should be displayed","");
  		  }
  		  else
  		  {
  			  test.fail("Error Message not Displayed for adding 31 Tns");
  			  i=statusTracker(i,"Fail","Verify if error message is displayed when adding 31st TN","Error message is not displayed","Error message should be displayed","");
  			  schk="Fail";
  		  }
  	  }
  	  
  	  if(schk.equals("Pass"))
  	  {   Thread.sleep(2000);
  		  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
  		  
  		  schk=orderprocess(driver,br);
  		 
  		  if(schk.equals("Pass"))
  		  {
  			  test.pass("The order Sucess for Adding 30 Tns");
  			  i=statusTracker(i,"Pass","Verify if adding 30 TNs is processed successfully","Order is successfully processed","Order should be successfully processed","");  
  			  int count1 =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/table/tbody/tr")).size();		
  			  if(count1==30)
  			  {
  				  test.pass("The 30 Tns present after process");
  				  i=statusTracker(i,"Pass","Verify if 30 TNs are displayed after order process","30 TNs are displayed after order process","TN is displayed after order process","");  
  			  }
  			  else
  			  {
  				test.fail("The 30 Tns Not present after process");
  				  i=statusTracker(i,"Fail","Verify if 30 TNs are displayed after order process","30 TNs are not displayed after order process","TN is displayed after order process","");
  				  schk="Fail";
  			  }
  		  }
  		  else
  		  {
  			  test.fail("The Order failed for Adding 30 Tns");
  			  i=statusTracker(i,"Fail","Verify if adding 30 TNs is processed successfully","Order is not successfully processed","Order should be successfully processed","");			 
  			  schk="Fail";
  		  }
  	  }
  	  
  	  return schk;
    }
    
    public String TNcheck(WebDriver driver,String ac, String midtn, String lastfour, String check,String br,ExtentTest test) throws Exception
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
        	test.pass("The Error Message is Displayed for the Condition"+check+" "+driver.findElement(By.cssSelector("span.help-block.error")).getText());
                        i=statusTracker(i,"Pass","Verify if error message is displayed when adding "+check+" TN","Error message is displayed: "+ driver.findElement(By.cssSelector("span.help-block.error")).getText(),"Error message should be displayed","");
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
    
    public String TNValidation(WebDriver driver,String br,ExtentTest test) throws Exception
    {
  	  String status= driver.findElement(By.id("SCFActivated")).getAttribute("value");
  	  if(status.equals("false"))
  	  {
  		  focusClick(driver,driver.findElement(By.id("SCFActivatedOn")),br);
  	  }
  	  String schk ="Pass";
  	  schk=TNcheck(driver,"022","300","4000","first digit 0",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck(driver,"222","000","4000","fourth digit 0",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck(driver,"122","300","4000","first digit 1",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck(driver,"222","152","4000","fourth digit 1",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck(driver,"","","","blank",br,test);
  	  Thread.sleep(5000);
  	//  schk=TNcheck(driver,ac1,midtn1,lastfour1,"existing",br);
  	//  Thread.sleep(5000);
  	  schk=TNcheck(driver,"99","9","99","Invalid",br,test);
  	
  	  Thread.sleep(5000);
  	  focusClick(driver,driver.findElement(By.id("mainCancelButton")),br);
  	  Thread.sleep(5000);
  	  schk="Pass";
  	  return schk;
	  
    }
    
    public String TNcheck2(WebDriver driver,String ac, String midtn, String lastfour, String check,String br,ExtentTest test) throws Exception
    {
  	  String schk="Fail";
  	  String tn;
  	  if(check.equals("no dropdown"))
        {
  		  focusClick(driver,driver.findElement(By.id("SCFStatusdrop")),br);
       	  Thread.sleep(3000);
        }
  	  else
  	  {
  		  driver.findElement(By.id("txtAreaCode2")).clear();
  		  driver.findElement(By.id("txtAreaCode2")).sendKeys(ac);
  		  
  		  driver.findElement(By.id("txtExchange2")).clear();
  		  driver.findElement(By.id("txtExchange2")).sendKeys(midtn);
  		  
  		  driver.findElement(By.id("txtTelNum2")).clear();
  		  driver.findElement(By.id("txtTelNum2")).sendKeys(lastfour);
  		  Thread.sleep(1000);
  	  }
  	  Thread.sleep(5000);
  	  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);	
  	  tn=ac+midtn+lastfour;
  	
  	  Thread.sleep(3000);
  	  boolean errmesg= driver.findElement(By.cssSelector("span.help-block.error")).isDisplayed();
        System.out.println("error"+errmesg);
  	  if(errmesg)
  	  {
  		  test.pass("The Error Message is Displayed for the Condition"+check+" "+driver.findElement(By.cssSelector("span.help-block.error")).getText());
  		  i=statusTracker(i,"Pass","Verify if error message is displayed when adding "+check+" TN to the To TN","Error message is displayed: "+ driver.findElement(By.cssSelector("span.help-block.error")).getText(),"Error message should be displayed","");
  		  schk="Pass";
  	  }
  	  else
  	  {
  		  test.fail("The Error Message Not Displayed for the Condition"+check);
  		  i=statusTracker(i,"Fail","Verify if error message is displayed when adding "+check+" TN to the To TN","Error message is not displayed","Error message should be displayed","");
  		  schk="Fail";
  	  }
  	                                                   
  	  return schk;
    }
    
    public String TNValidation2(WebDriver driver,String br,ExtentTest test) throws Exception
    {	
  		  String status= driver.findElement(By.id("SCFActivated")).getAttribute("value");
  		  if(status.equals("false"))
  		  {
  			  focusClick(driver,driver.findElement(By.id("SCFActivatedOn")),br);
  		  }
  			
  	  String schk ="Pass";
  	  schk=TNcheck2(driver,"022","300","4000","first digit 0",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck2(driver,"222","000","4000","fourth digit 0",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck2(driver,"122","300","4000","first digit 1",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck2(driver,"222","152","4000","fourth digit 1",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck2(driver,"900","800","4000","toll free",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck2(driver,"976","800","4000","toll free",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck2(driver,"","","","blank",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck2(driver,"99","9","99","Invalid",br,test);
  	  Thread.sleep(5000);
  	  schk=TNcheck2(driver,"","","","no dropdown",br,test);
  	  Thread.sleep(5000);
  	  focusClick(driver,driver.findElement(By.id("mainCancelButton")),br);
  	  Thread.sleep(5000);
  	  schk="Pass";
  	  return schk; 	 
    }   
}