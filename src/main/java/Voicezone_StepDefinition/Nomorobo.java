package Voicezone_StepDefinition;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import cucumber.api.java.en.Given;

public class Nomorobo extends Commonfiles{
	public String tlimit,AAVal,NMVal;
	@Given("^Nomorobo Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void nomorobo_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
		String state = "Fail";String schk="Fail";boolean status,status1;
		//String tlimit,AAVal,NMVal;
	    int tncount;                                                    
		ArrayList<String> str = new ArrayList<String>();
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
		   Thread.sleep(5000);
           
           AAVal= driver.findElement(By.xpath("//html/body/div[3]/form/div/div/div[3]/div[4]/ul/li[1]/p/span")).getAttribute("class");
           System.out.println("Answer Anywhere status "+AAVal);
           
          NMVal= driver.findElement(By.xpath("//html/body/div[3]/form/div/div/div[3]/div[1]/ul/li[4]/p/span[1]")).getAttribute("class");
          System.out.println("NomoRobo status "+NMVal);
          Thread.sleep(5000);
          focusClick(driver, driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[1]")),br);  
          Thread.sleep(5000);
          focusClick(driver,driver.findElement(By.xpath("//div[@id='ContentRefresh']/ul/li[3]/a")),br);
          chk=0;

          do{
        	  Thread.sleep(1000);       
        	  chk++;
        	  System.out.println(chk);
          }while(!(driver.findElement(By.xpath(".//*[@id='NomoroboRefresh']/div[1]/div/h2")).isDisplayed()));

          System.out.println("Iam here");

          if (NMVal.contains("off") && AAVal.contains("off") )
          {
        	  state =flowrun(br,driver, "NomoroboOn",1,test);   
        	  if(state.equals("Pass"))
        		  str = CheckAAStatus(br,driver,test);


        	  if(state.equals("Pass"))               
        		  state =flowrun(br,driver, "NomoroboOff",2,test);

        	  if(state.equals("Pass"))
        		  str = CheckAAStatus(br,driver,test);

        	  if(str.get(1).equals("Pass")&& str.get(0).contains("off"))
        		  state =flowrun(br,driver, "NomoroboOn",1,test);
        	  else
        		  state =flowrun(br,driver, "NomoroboOn",2,test);   

        	  if(state.equals("Pass"))
        		  state=DisableNMRBfrmAA(br,driver,test);   

          } 
          else if(NMVal.contains("off") && AAVal.contains("on") )
          {
        	  state =flowrun(br,driver, "NomoroboOn",2,test);

        	  if(state.equals("Pass"))
        		  str = CheckAAStatus(br,driver,test);

        	  if(state.equals("Pass"))
        		  state =flowrun(br,driver, "NomoroboOff",2,test);

        	  if(state.equals("Pass"))
        		  str = CheckAAStatus(br,driver,test);

        	  if(state.equals("Pass"))
        		  state =flowrun(br,driver, "NomoroboOn",2,test);

        	  if(state.equals("Pass"))
        		  state=DisableNMRBfrmAA(br,driver,test);    
          }
          else
          {
        	  state =flowrun(br,driver, "NomoroboOff",2,test);

        	  if(state.equals("Pass"))
        		  str  = CheckAAStatus(br,driver,test);

        	  if(str.get(1).equals("Pass")&& str.get(0).contains("off"))
        		  state =flowrun(br,driver, "NomoroboOn",1,test);
        	  else
        		  state =flowrun(br,driver, "NomoroboOn",2,test);

        	  if(state.equals("Pass"))
        		  state=DisableNMRBfrmAA(br,driver,test);   
          }

          focusClick(driver,driver.findElement(By.id("mainCancelButton")),br);
          
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
	    	PrintResult("Nomorobo");
	        extent.flush();
	    }
	 }
	}
	
		public String flowrun( String br,WebDriver driver,String id,int flag,ExtentTest test) throws Exception
		{
			String schk="Fail";

			boolean statusdisabled = driver.findElement(By.xpath("//input[@id='NomoroboOff']")).isSelected();
			System.out.println("val" +statusdisabled);
                                //boolean statusnb = driver.findElement(By.xpath("//input[@id='NomoroboOn']")).isSelected();
                                //System.out.println(statusnb);
                                
                                
                                String from ="",to;
                                if(statusdisabled)
                                                from = " Nomorobo Disabled";
                                else 
                                                from = " Nomorobo Enabled";

                                System.out.println("after selection");
                                
                                to=id;
                                if(to.contains("Off"))
                                                to=" Nomorobo Disabled";
                                else
                                                to=" Nomorobo Enable";
                                
                                System.out.println("xpath assignment");
                                System.out.println("flag value"+flag);
                                
                                if(flag==1)
                                {
                                                if(driver.findElement(By.id("TermsandConditions")).isEnabled())
                                                {
                                                System.out.println("Check box not selected");
                                                Thread.sleep(2000);
                                                focusClick(driver,driver.findElement(By.id("TermsandConditions")),br);  
                                                }
                                                Thread.sleep(2000);
                                                focusClick(driver,driver.findElement(By.id(id)),br);
                                                int chk=0;
                                                Thread.sleep(2000);
                                                               
               if(driver.findElement(By.xpath("//html/body/div[10]")).isDisplayed())
               { 
            	test.pass("The Nomorobo Popup is displayed");
                i=statusTracker(i,"Pass","Verify if the Nomorobo Popup is displayed","The Nomorobo Popup is displayed","The Nomorobo Popup should be displayed","");
                Thread.sleep(2000);
                focusClick(driver,driver.findElement(By.cssSelector("#dialog > div.modal-footer > #TermsandConditionsYes")),br);
                System.out.println("Its working");
                Thread.sleep(2000);
               } 
                                }
                                else 
                                {
                                	            Thread.sleep(2000);
                                                focusClick(driver,driver.findElement(By.id(id)),br);
                                }
                                Thread.sleep(5000);
                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
                                schk=orderprocess(driver,br);
                                Thread.sleep(2000);
                                driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
                                if(schk.equals("Fail"))
                                {
                                	test.pass("The order is Sucess when switching from "+from+" to "+to);
                                                i=statusTracker(i,"Fail","Verify order processing when switching from "+from+" to "+to,"Order processing has failed","Order should be processed successfully","");
                                                
                                }
                                else
                                {
                                	test.fail("The order is Sucess when switching from "+from+" to "+to);
                                                System.out.println("Mpass");
                                                i=statusTracker(i,"Pass","Verify order processing when switching from "+from+" to "+to,"Order processing has completed successfully","Order should be processed successfully","");
                                }                
         return schk;   
      }
    
      public String DisableNMRBfrmAA( String br,WebDriver driver,ExtentTest test) throws Exception
       {
                 String schk="Fail";
                 Thread.sleep(2000);
                 focusClick(driver, driver.findElement(By.xpath("//*[@id='settings-tabs']/div/ul/li[4]/a")),br);
               Thread.sleep(2000); 
               focusClick(driver, driver.findElement(By.id("AnswerAnywhereOff")),br);
               int chk=0;
          do {
                  Thread.sleep(1000);
          chk++;
          System.out.println(chk);
                                }while(!(driver.findElement(By.xpath("//html/body/div[9]")).isDisplayed()));
                
               if(driver.findElement(By.xpath("//html/body/div[9]")).isDisplayed())
               {  
            	   test.pass("The Nomorobo Popup is displayed Enabling Service ");
            	   i=statusTracker(i,"Pass","Verify if the Nomorobo Popup is displayed for Enabling Service","The Nomorobo Popup is displayed Enabling Service ","The Nomorobo Popup should be displayed","");
            	   Thread.sleep(2000);
            	   focusClick(driver, driver.findElement(By.cssSelector("#dialog > div.modal-footer > #NomoroboOffYes")),br);
            	   Thread.sleep(2000);
               }
                                
                                
                                Thread.sleep(2000);
                                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
                                schk=orderprocess(driver,br);
                                driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
                                if(schk=="Pass")
                                  {
                                	test.pass("Sucess Disabling NMRB from AA");
                                	i=statusTracker(i,"Pass","Verify if Nomorobo can be disabled from AA","Nomorobo can be disabled from AA","Nomorobo should  be disabled from AA","");
                                	schk="Pass";
                                  }
                                  else 
                                  {
                                	  test.fail("Sucess Disabling NMRB from AA");
                                                  i=statusTracker(i,"Fail","Verify if Nomorobo can be disabled from AA","Nomorobo cannot be disabled from AA","Nomorobo should be disabled from AA","");
                                                  schk="Fail";
                                  }
                                int count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
                    int f=1;
                    for ( int i=1;i<=count;i++)
                     {             
                    	          Thread.sleep(2000);
                                  String value=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr["+i+"]/td")).getText();
                                  System.out.println(value);
                                
                                  value=value.replaceAll(" ","");
                                  value=value.replaceAll("\\(","");
                                  value=value.replaceAll("\\)","");
                                  value=value.replaceAll("-","");
                                  if(value.equals("6467988400"))
                                     {
                                                  f=0;
                                                  break;
                                                  }
                                  
                     }
                                  if(f==1)
                                  {
                                	  test.pass("NMRB number is not present in the list");
                                	  i=statusTracker(i,"Pass","Verify if Nomorobo TN is present in the list","Nomorobo TN is not present in the list.","Nomorobo TN should not be present in the list","");
                                	  schk="Pass";
                                  }
                                  else 
                                  {
                                	  test.fail("NMRB number is present in the list");
                                                  i=statusTracker(i,"Fail","Verify if Nomorobo TN is present in the list","Nomorobo TN is  present in the list.","Nomorobo TN should not be present in the list","");
                                                  schk="Fail";
                                  }

                 
                 return schk;       
       }
    
    public ArrayList<String> CheckAAStatus( String br,WebDriver driver,ExtentTest test) throws Exception
      {
                ArrayList<String> str = new ArrayList<String>();
                //String tlimit,AAVal,NMVal;
                 int f=1;
                 Thread.sleep(2000);
                 focusClick(driver, driver.findElement(By.linkText("Settings")),br);
                 Thread.sleep(5000);
                 
                 if(driver.findElement(By.id("notSavedAlertAnchor")).isDisplayed()) {
                	 Thread.sleep(2000);
                     focusClick(driver, driver.findElement(By.id("notSavedAlertAnchor")),br);
                 }
                    NMVal= driver.findElement(By.xpath("//html/body/div[3]/form/div/div/div[3]/div[1]/ul/li[4]/p/span[1]")).getAttribute("class");
                    System.out.println("NomoRobo status "+NMVal);
                    AAVal= driver.findElement(By.xpath("//html/body/div[3]/form/div/div/div[3]/div[4]/ul/li[1]/p/span")).getAttribute("class");
                    System.out.println("Answer Anywhere status "+AAVal);
                                      
                str.add(AAVal);
                Thread.sleep(3000);
                focusClick(driver, driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[4]")),br);      
                Thread.sleep(3000);   
                if(NMVal.equals("on"))
                {
                 int count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
                
                      for(int i=1;i<=count;i++)
                      {
                    	  Thread.sleep(4000);
                                   String value=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr["+i+"]/td")).getText();
                                   System.out.println(value);
                                 
                                   value=value.replaceAll(" ","");
                                   value=value.replaceAll("\\(","");
                                   value=value.replaceAll("\\)","");
                                   value=value.replaceAll("-","");
                                   if(value.equals("6467988400"))
                                      {
                                           f=0;
                                           break;
                                       }
                      } 
                                  if(f==0) 
                                  {
                                	  test.pass("NMRB number is present in the AnswerAnywhere list");
                                	  i=statusTracker(i,"Pass","Verify if Nomorobo TN is present in the  AnswerAnywhere list","Nomorobo TN is present in the  AnswerAnywhere list.","Nomorobo TN should be present in the AnswerAnywhere list","");
                                                str.add("Pass"); 
                                  }
                                  else
                                  {
                                	  test.fail("NMRB number is not present in the AnswerAnywhere list");
                                                i=statusTracker(i,"Fail","Verify if Nomorobo TN is present in the  AnswerAnywhere list","Nomorobo TN is not present in the  AnswerAnywhere list.","Nomorobo TN should be present in the AnswerAnywhere list",""); 
                                                str.add("Fail");   
                      }
                                }
                     
            else
                {
                                System.out.println("NMRB is off") ; 

                   int count =driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr")).size();
                    f=1;
                    for(int i=1;i<=count;i++)
                     {            Thread.sleep(2000);
                                  String value=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div[4]/table/tbody/tr["+i+"]/td")).getText();
                                  System.out.println(value);
                                
                                  value=value.replaceAll(" ","");
                                  value=value.replaceAll("\\(","");
                                  value=value.replaceAll("\\)","");
                                  value=value.replaceAll("-","");
                                  if(value.equals("6467988400"))
                                     {
                                                  f=0;
                                                  break;
                                                  }
                                  
                      }
                                  if(f==1)
                                  {
                                	  test.pass("NMRB number is not present in the AnswerAnywhere list");
                                   i=statusTracker(i,"Pass","Verify if Nomorobo TN is present in  AnswerAnywhere list","Nomorobo TN is not present in the  AnswerAnywhere list.","Nomorobo TN should not be present in the  AnswerAnywhere list","");
                                   str.add("Pass");
                                  }
                                  else 
                                  {
                                	  test.fail("NMRB number is present in the AnswerAnywhere list");
                                                  i=statusTracker(i,"Pass","Verify if Nomorobo TN is present in  AnswerAnywhere list","Nomorobo TN is  present in the  AnswerAnywhere list.","Nomorobo TN should not be present in the AnswerAnywhere list","");
                                                  str.add("Pass");
                                  }
                   }
                                Thread.sleep(2000);
                                focusClick(driver, driver.findElement(By.xpath("//div[@id='settings-tabs']/div/ul/li[1]/a")),br);
                                int chk=0;

                      do{
                           Thread.sleep(1000);       
                          chk++;
                          System.out.println(chk);
                                }while(!(driver.findElement(By.xpath(".//*[@id='Call-Blocking']/div/div/div[1]/div[2]/h2")).isDisplayed()));
                                Thread.sleep(2000);
                                focusClick(driver, driver.findElement(By.xpath("//a[contains(text(), 'Nomorobo')]")),br);
                                chk=0;

                      do{
                           Thread.sleep(1000);       
                          chk++;
                          System.out.println(chk);
                                }
                      while(!(driver.findElement(By.xpath(".//*[@id='NomoroboRefresh']/div[1]/div/h2")).isDisplayed()));
                
        return str;    
      }
}
