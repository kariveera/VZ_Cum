package Voicezone_StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class CallForwardingNoAnswer extends Commonfiles{
	   String table, tns[];
	    String tlimit,username,pwd;
	    int tncount;                                                    
	                                
	    String phoneline,phoneline_ac,Acccode,slftn,phoneline_midtn,phoneline_lastfour;
	                int rank[]= new int[50];
	                

	                int c_sequence;
	                String name_for_rank[]= new String[40];
	                String price, rank_channels;
	                
	@Given("^CallForwardingNoAnswer Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void CallForwardingNoAnswer_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
	String schk="Fail";
	extent.attachReporter(htmlReporter);
	ExtentTest test = extent.createTest("CallBlockerBasicPlus", "Execution Report of CallBlockerBasicPlus");
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
	            			   focusClick(driver,driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[4]")),br);
	            		  	      Thread.sleep(5000);
	            		    	
	            					do{
	            					}while(assertTrue(isElementPresent(By.cssSelector("#Answer-Anywhere > h1"))));
	            					
	            					focusClick(driver,driver.findElement(By.xpath("//div[@id='ContentRefresh']/ul/li[2]/a")),br);
	            					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	            		         String status = driver.findElement(By.id("CFNAActivatedOn")).getAttribute("class");
	            		         System.out.println(status);
	            		         Thread.sleep(2000);
	            		        if(status.equals("btn"))
	            		         {
	            		        	 System.out.println("Loop1");
	            		        	 flowrun1(driver,br,test);
	            		         }
	            		         else if(status.equals("btn active"))
	            		         {
	            		        	 System.out.println("Loop2");
	            		        	 flowrun(driver,br,test);
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
	            	        	 PrintResult("CallForwardingNoAnswer");
	            	          extent.flush();
	            	      }
	            	   }
	            	}

	private Object isElementPresent(By cssSelector) {
		// TODO Auto-generated method stub
		return null;
	}

	public String TNcheck(WebDriver driver,String ac, String midtn, String lastfour, String check,String br,ExtentTest test) throws Exception
	  {
	         String schk="Fail";
	         //int limit =selenium.getXpathCount("//html/body/div[4]/form/div/div[3]/div[2]/div/div/div/div/div/div/div/div[5]/table/tbody//tr").intValue();
	        // int count;
	         String tn;
	         
	         if(check.equals("no dropdown"))
	         {
	        	 focusClick(driver,driver.findElement(By.id("CFNAStatusdrop")),br);	        	 
	        	 Thread.sleep(5000);
	        	 //selenium.click("id=ddlCFUnum");
	         }
	         else
	         {
	        	 focusClick(driver,driver.findElement(By.id("CFNAStatus")),br);	         
		         Thread.sleep(5000);
		         
		         driver.findElement(By.id("txtAreaCode3")).clear();
		         driver.findElement(By.id("txtAreaCode3")).sendKeys(ac);
		         driver.findElement(By.id("txtExchange3")).clear();
		         driver.findElement(By.id("txtExchange3")).sendKeys(midtn);
		         driver.findElement(By.id("txtTelNum3")).clear();
		         driver.findElement(By.id("txtTelNum3")).sendKeys(lastfour);

		         //System.out.println(selenium.getXpathCount("//*[@id='TNGridRefresh']/div"));
		         Thread.sleep(5000);
	         }
	        focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);

	     	/*do{
	        }while(selenium.isElementPresent("//body/div[10]"));
	        */
	         Thread.sleep(3000);
	         
	         tn=ac+midtn+lastfour;
	         //do{
	         //}while(selenium.isElementPresent("//body/div[10]"));
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        // count=selenium.getXpathCount("//html/body/div[4]/form/div/div[3]/div[2]/div/div/div/div/div/div/div/div[5]/table/tbody//tr").intValue();
	         boolean errmesg= driver.findElement(By.cssSelector("span.help-block.error")).isDisplayed();
	         System.out.println("error"+errmesg);
	         if(errmesg)
	         {
	        	 test.pass("The Error is Diaplyed for Condition "+check+" "+driver.findElement(By.cssSelector("span.help-block.error")).getText());
	                i=statusTracker(i,"Pass","Verify if error message is displayed when adding "+check+" TN","Error message is displayed: "+ driver.findElement(By.cssSelector("span.help-block.error")).getText(),"Error message should be displayed","");
	                schk="Pass";
	         }
	         else
	         {
	        	 test.fail("The Error is Not Diaplyed for Condition "+check);
	                i=statusTracker(i,"Fail","Verify if error message is displayed when adding "+check+" TN","Error message is not displayed","Error message should be displayed","");
	                schk="Fail";
	         }
	                 
	     /*    focusClick(driver,driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div/div[7]/span/span[2]/a")),br);
	         driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	         //boolean errmesg1= driver.findElements(By.cssSelector("div.modal-body > p")).size();
	         //System.out.println("error123"+errmesg1);
	         if(driver.findElements(By.xpath("//html/body/div[4]/div")).size()!=0)
	         {
	                statusTracker(br,"Pass","Verify if error message is displayed on clicking the friendly icon when adding "+check+" TN","Error message is displayed: "+ driver.findElement(By.cssSelector("div.modal-body > p")).getText(),"Error message should be displayed");
	                schk="Pass";
	         }
	         else
	         {
	                statusTracker(br,"Fail","Verify if error message is displayed on clicking the friendly icon when adding "+check+" TN","Error message is not displayed","Error message should be displayed");
	                schk="Fail";
	         }
	         Thread.sleep(5000);
	         focusClick(driver,driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")),br);*/
	         
	         return schk;
	  }
	  
	 private Object isTextPresent(By cssSelector) {
		// TODO Auto-generated method stub
		return null;
	}

	public String TNValidation(WebDriver driver,String br,ExtentTest test) throws Exception
	  {	 	 
			focusClick(driver,driver.findElement(By.id("CFNAActivatedOn")),br);
		 	Thread.sleep(1000);
		 	phoneline_ac=slftn.substring(0,3);
		 	phoneline_midtn=slftn.substring(3,6);
		 	phoneline_lastfour=slftn.substring(6,10);
	         String schk ="Pass";
	         schk=TNcheck(driver,"022","300","4000","first digit 0",br,test);
	         Thread.sleep(5000);
	         schk=TNcheck(driver,"222","000","4000","fourth digit 0",br,test);
	         schk=TNcheck(driver,"122","300","4000","first digit 1",br,test);
	         schk=TNcheck(driver,"222","152","4000","fourth digit 1",br,test);
	         schk=TNcheck(driver,"900","700","4000","Toll Free",br,test);
	         schk=TNcheck(driver,"976","700","4000","Informative",br,test);
	         schk=TNcheck(driver,"","","","blank",br,test);
	         schk=TNcheck(driver,"99","9","99","Invalid",br,test);
	         schk=TNcheck(driver,phoneline_ac,phoneline_midtn,phoneline_lastfour,"self",br,test);
	         schk=TNcheck(driver,"","","","no dropdown",br,test);
	         schk="Pass";
	         return schk;
	  }
	 
	 public String EditTN(WebDriver driver,String br,ExtentTest test)throws Exception
	 {
		  slftn=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[2]/div/button/span")).getAttribute("data-friendlyname-contact");
			System.out.println("selftn"+slftn);
		    String ac=slftn.substring(0,3);
			String midtn=slftn.substring(3,6);
			String schk="Fail";
			//ac=phoneline_ac;
			//midtn=phoneline_midtn;
			//String midtn="345";
			String lastfour= randomNO(9999,1000);
			System.out.println("selftn"+ac);
			System.out.println("selftn"+midtn);
			System.out.println("selftn"+lastfour);
			driver.findElement(By.id("txtAreaCode3")).sendKeys(ac);
			driver.findElement(By.id("txtExchange3")).sendKeys(midtn);
			driver.findElement(By.id("txtTelNum3")).sendKeys(lastfour);
			

			Thread.sleep(2000);
			focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
			schk=orderprocess(driver,br);
			if(schk.equals("Fail"))
		    {
		           i=statusTracker(i,"Fail","Verify if order processing is successful while adding Alternate TN","Order processing has failed","Order should be processed successfully","");
		           test.fail("Order Processing is Failed while adding Alternate TN");
		    }
			else
		    {
				test.pass("Order Processing is Sucess while adding Alternate TN");
		    	i=statusTracker(i,"Pass","Verify if order processing is successful while adding Alternate TN","Order processing has completed successfully","Order should be processed successfully","");
		    	
		    	System.out.println("check"+ac);
		    	System.out.println("check"+midtn);
		    	System.out.println("check"+lastfour);
		    	System.out.println("check"+driver.findElement(By.id("txtAreaCode3")).getAttribute("value"));
		    	System.out.println("check"+driver.findElement(By.id("txtExchange3")).getAttribute("value"));
		    	System.out.println("check"+driver.findElement(By.id("txtTelNum3")).getAttribute("value"));
		    	if(((driver.findElement(By.id("txtAreaCode3")).getAttribute("value")).equals(ac))&&((driver.findElement(By.id("txtExchange3")).getAttribute("value")).equals(midtn))&&((driver.findElement(By.id("txtTelNum3")).getAttribute("value")).equals(lastfour)))
		    	{
		    		test.pass("The Order is Sucess while adding alternate TN");
					i=statusTracker(i,"Pass","Verify if the TN is reflected in the field after order processing","User is able to add alternate TN"," User should be  able to add alternate TN","");
					schk="Pass";
		    	}
				else{
					test.fail("The Order is Failed while adding alternate TN");
					i=statusTracker(i,"Fail","Verify if the TN is reflected in the field after order processing","User is not able to add alternate TN"," User should be  able to add alternate TN",""); 
				Thread.sleep(2000);
				}   
		    }				        
			
			return schk;
	 }
	 
	 public String SelectTN(WebDriver driver,String br,ExtentTest test)throws Exception
	 { 
		String schk="Fail";
		focusClick(driver,driver.findElement(By.id("CFNAStatusdrop")),br);//Dropdown
		Thread.sleep(5000);
		int listcount=driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div/div[12]/div/div/ul/li")).size();			
		System.out.println("listcount"+listcount);
		String text[]=new String[listcount+1];
		for(int i=1;i<=listcount;i++)
		{
			WebElement labelNode = driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div/div[12]/div/div/ul/li["+i+"]//a")); 
			String labelNodeText = (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML",labelNode);
			labelNodeText=labelNodeText.substring(21,labelNodeText.length()-16);
			labelNodeText=labelNodeText.replaceAll("\\n","");
			text[i]=labelNodeText;
			System.out.println("String: "+labelNodeText);	
			System.out.println("TN "+text[i]);
		}
		String j=randomNO(9,1);
		int k=Integer.parseInt(j);
		focusClick(driver,driver.findElement(By.id("ddlCFNAnum")),br);
		Thread.sleep(2000);
		focusClick(driver,driver.findElement(By.linkText(text[k])),br);
		Thread.sleep(2000);
		
		focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
		schk=orderprocess(driver,br);
		if(schk.equals("Fail"))
	    {
			test.fail("The Order process Failed on adding the Number from dropdown");
	           i=statusTracker(i,"Fail","Verify if order processing is successful while adding TN from dropdown","Order processing has failed","Order should be processed successfully","");          
	    }
		else
	    {
			test.pass("The Order process Sucess on adding the Number from dropdown");
			i=statusTracker(i,"Pass","Verify if order processing is successful while adding TN from dropdown","Order processing has completed successfully","Order should be processed successfully","");
			String s1=text[k].substring(1, 4);
			System.out.println(s1);
			String s2=text[k].substring(6, 9);
			System.out.println(s2);
			String s3=text[k].substring(10,14);
			System.out.println(s3);
			
			System.out.println("check"+s1);
	    	System.out.println("check"+s2);
	    	System.out.println("check"+s3);
	    	System.out.println("check"+driver.findElement(By.id("txtAreaCode3")).getAttribute("value"));
	    	System.out.println("check"+driver.findElement(By.id("txtExchange3")).getAttribute("value"));
	    	System.out.println("check"+driver.findElement(By.id("txtTelNum3")).getAttribute("value"));
			if(((driver.findElement(By.id("txtAreaCode3")).getAttribute("value")).equals(s1))&&((driver.findElement(By.id("txtExchange3")).getAttribute("value")).equals(s2))&&((driver.findElement(By.id("txtTelNum3")).getAttribute("value")).equals(s3)))
			{
				test.pass("User is able to see changes in the alternate TN field");
				i=statusTracker(i,"Pass","Verify if the TN is reflected in the field after order processing","User is able to see changes in the alternate TN field","User should be able to see changes in the alternate TN field","");
				schk="Pass";
			}
			else{
				test.fail("User is able to see changes in the alternate TN field");
				i=statusTracker(i,"Fail","Verify if the TN is reflected in the field after order processing","User is able to see changes in the alternate TN field","User should be able to see changes in the alternate TN field","");
			 }
			}
		
		if(listcount==10)
		{	test.pass("The list contains max 10TN");	
			i=statusTracker(i,"Pass","Verify if the TN list contains max 10TN","User is able to see max 10 TN's","User should be able to see max of 10 TN's in the drop down list","");			
			for(int ik=1;ik<=listcount;ik++)
			{
			test.info("TN list is"+text[ik]);
			i=statusTracker(i,"","TN list is",text[ik],"","");					
			}
		}
		else if(listcount<10)
		{
			for(int jk=1;jk<=(10-listcount);jk++)
			{
				EditTN(driver,br,test);
			}		
			int listcount1=driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div/div[12]/div/div/ul/li")).size();					
			if(listcount1==10)
			{
				test.pass("User is able to see max 10 TN's");
				i=statusTracker(i,"Pass","Verify if the TN list contains max 10TN","User is able to see max 10 TN's","User should be able to see max of 10 TN's in the drop down list","");			
				for(int ij=1;ij<=listcount;ij++)
				{
				i=statusTracker(i,"","TN list is",text[ij],"","");					
				}
			}
		}
		else
		{
			for(int j1=1;j1<=listcount;j1++)
			{
			test.fail("User is able to see more than 10 TN's"+text[j1]);
			i=statusTracker(i,"Fail","Verify if the TN list contains max 10TN","User is able to see more than 10 TN's"+text[j1],"User should be able to see max of 10 TN's in the drop down list","");			
			}
		}
		
		return schk;
	 }
	 
	 public String voicemail(WebDriver driver,String br,ExtentTest test)throws Exception
	 { 
		 	String schk="Fail";
		 	focusClick(driver,driver.findElement(By.id("CFNAVMStatus")),br);
			Thread.sleep(2000);
			focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
			schk=orderprocess(driver,br);
			if(schk.equals("Fail"))
		    {
				test.pass("Order is Failed to change to Voicemail");
		           i=statusTracker(i,"Fail","Verify if order processing is successful when changing option to Voicemail","Order processing has failed","Order should be processed successfully","");	           
		    }
			else
			{
				test.pass("Sucessfully able to change to Voicemail");
				i=statusTracker(i,"Pass","Verify if order processing is successful when changing option to Voicemail","Order processing has processed successfully","Order should be processed successfully","");
				WebElement a=driver.findElement(By.id("CFNAVMStatus"));
				if(a.isSelected())
				{
					test.pass("Enable with Voicemail is Sucess");
					i=statusTracker(i,"Pass","Verify if Voicemail option is enabled after order processing","User is able to enable Voicemail","User should be able to enable Voicemail","");
					schk="Pass";
				}
				else{
					test.fail("Enable with Voicemail is Failed");
					i=statusTracker(i,"Fail","Verify if Voicemail option is enabled after order processing","User is not able to enable Voicemail","User should be able to enable Voicemail","");
				   }
				}
			return schk;
	 }
	 
	 public String NumberofRings(WebDriver driver,String br,ExtentTest test)throws Exception
	 {
		 String schk="Fail";
		 focusClick(driver,driver.findElement(By.id("ddlCFNArings")),br);
		//Thread.sleep(5000);
		int listcount=driver.findElements(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div/div/div/div[2]/div/div/ul/li")).size();
		String text[]=new String[listcount+1];
		for(int i=1;i<=listcount;i++)
		{
			WebElement labelNode1 = driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div/div/div/div[2]/div/div/ul/li["+i+"]//a"));
			String labelNodeText1 = (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML",labelNode1);
			text[i]=labelNodeText1;
			text[i]=text[i].substring(0,text[i].length());
			System.out.println("String: "+labelNodeText1);	
			System.out.println("TN "+text[i]);
			//text[i]=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[3]/div[2]/div/div/div/div/div[3]/div/div/div[3]/div/div/div/ul/li["+i+"]")).getText();
		}
		String j=randomNO(9,1);	
		int k=Integer.parseInt(j);
		//driver.findElement(By.id("ddlCFNArings")).click();
		Thread.sleep(2000);
		focusClick(driver,driver.findElement(By.linkText(text[k])),br);
		Thread.sleep(2000);
		focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
		//Thread.sleep(2000);
		orderprocess(driver,br);
		
		if(!(driver.findElement(By.id("ddlCFNArings")).getText().equals(text[k]))){
			test.fail("Number of Rings Unable to Set To: "+text[k]);
			i=statusTracker(i,"Fail","Verify is number of rings could be set to any number","Number of rings was unable to be set to: "+text[k],"Number of rings should be set to: "+text[k],"");
		}else
		{
			test.pass("Number of Rings Set To: "+text[k]);
			i=statusTracker(i,"Pass","Verify is number of rings could be set to any number","Number of rings is set to: "+text[k],"Number of rings should be set to: "+text[k],"");
			focusClick(driver,driver.findElement(By.id("ResetnoOfRings")),br);		
			Thread.sleep(5000);
			focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
			schk=orderprocess(driver,br);
			System.out.println("resetnumofrings"+driver.findElement(By.id("ddlCFNArings")).getText());
			if(driver.findElement(By.id("ddlCFNArings")).getText().equals("After 5 rings") && schk.equals("Pass"))
			 {
				test.pass("The Number of Rings RESET is Sucess");
				i=statusTracker(i,"Pass","Verify if the Number of rings could be resetted successfully","Number of rings were successfully reset","Number of rings should be successfully reset","");
				schk="Pass";
			  }
			else
			{
				test.fail("The Number of Rings RESET is Failed");
				i=statusTracker(i,"Fail","Verify if the Number of rings could be resetted successfully","Number of rings were not successfully reset","Number of rings should be successfully reset","");
			}
			}
		return schk;
	    }
	 
	 public void flowrun(WebDriver driver,String br,ExtentTest test) throws Exception{
			System.out.println("First");
			//selenium.click("id=CFNAActivatedOff");
			//Thread.sleep(3000);
			focusClick(driver,driver.findElement(By.id("CFNAActivatedOff")),br);		
			driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
			String status2 = driver.findElement(By.id("CFNAActivatedOff")).getAttribute("class");
			focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
			String schk=orderprocess(driver,br);
			System.out.println(schk);
			System.out.println(status2);
			if(schk.equals("Fail"))
			{
				test.fail("The CFNA Disable is failed");
				i=statusTracker(i,"Fail","Verify order processing for disabling Call Forwarding No Answer","Call Forwarding No Answer section is not disabled","Call Forwarding No Answer section should be disabled","");
			}
			else
			{
				test.pass("The CFNA Disable is Sucess");
				i=statusTracker(i,"Pass","Verify order procssing for disabling Call Forwarding No Answer","Call Forwarding No Answer section is disabled","Call Forwarding No Answer section should be disabled","");
				String status1 = driver.findElement(By.id("CFNAActivatedOff")).getAttribute("class");
				System.out.println(status1);
				focusClick(driver,driver.findElement(By.id("CFNAActivatedOn")),br);	
				
				String statu = driver.findElement(By.id("CFNAActivatedOn")).getAttribute("class");
				System.out.println(statu);
				//if(statu=="btn")
		//			statusTracker("Fail","Verify Call Forwarding No Answer section can be enabled"," Call Forwarding No Answer section cannot be enabled","Call Forwarding No Answer section should can be enabled"); 
				//else
		//			statusTracker("Pass","Verify Call Forwarding No Answer section can be enabled"," Call Forwarding No Answer section can be enabled","Call Forwarding No Answer section should can be enabled");		
				if(driver.findElement(By.id("CFNAVMStatus")).isSelected())
				{
					System.out.println("loop1");
					if(schk.equals("Pass"))
					{
						focusClick(driver,driver.findElement(By.id("CFNAStatus")),br);						
						Thread.sleep(5000);
						if(driver.findElement(By.cssSelector("div.field.clearfix > span")).isDisplayed()){
							test.pass("The Warning Message is displayed when voicemail radio button is changed");
							i=statusTracker(i,"Pass","Verify if the warning message is present when voicemail radio button is changed"," Warning message is present when voicemail radio button is changed","Warning message should be  present when voicemail radio button is changed","");
						}else{
							test.fail("The Warning Message is displayed when voicemail radio button is changed");
							i=statusTracker(i,"Fail","Verify if the warning message is present when voicemail radio button is changed"," Warning message is not present when voicemail radio button is changed","Warning message should not be present when voicemail radio button is changed","");
							schk="Fail";
						}
					}
					if(schk.equals("Pass"))
						schk=EditTN(driver,br,test);//Add TN
					if(schk.equals("Pass"))
						schk=SelectTN(driver,br,test);//Select Dropdown
					if(schk.equals("Pass"))
						schk=NumberofRings(driver,br,test);//Set Number of rings
					if(schk.equals("Pass"))
						schk=voicemail(driver,br,test);
					i=statusTracker(i,"","Verify TN Validation","","","");
					test.info("Verify TN Validation");
					TNValidation(driver,br,test);
				}
				else
				{
					schk=voicemail(driver,br,test);
					if(schk.equals("Pass"))
					{
						focusClick(driver,driver.findElement(By.id("CFNAStatus")),br);	
						Thread.sleep(3000);
						if(driver.findElement(By.cssSelector("div.field.clearfix > span")).isDisplayed()){
							test.pass("The warning is displayed when voicemail radio button is changed");
							i=statusTracker(i,"Pass","Verify if the warning message is present when voicemail radio button is changed","Warning message is present when voicemail radio button is changed","Warning message should be  present when voicemail radio button is changed","");
					}else{
						test.fail("The warning is Not displayed when voicemail radio button is changed");
							i=statusTracker(i,"Fail","Verify if the warning message is present when voicemail radio button is changed","Warning message is not present when voicemail radio button is changed","Warning message should not be present when voicemail radio button is changed","");
							schk="Fail";
						}
					}
					if(schk.equals("Pass"))
						schk=EditTN(driver,br,test);//Add TN
					if(schk.equals("Pass"))
						schk=SelectTN(driver,br,test);//Select Dropdown
					if(schk.equals("Pass"))
						schk=NumberofRings(driver,br,test);//Set Number of rings
					i=statusTracker(i,"","Verify TN Validation","","","");
					TNValidation(driver,br,test);
				}
			}
	 }
	 
	 public void flowrun1(WebDriver driver,String br,ExtentTest test) throws Exception
	 { 
		String schk="Pass";
		focusClick(driver,driver.findElement(By.id("CFNAActivatedOn")),br);
		
		Thread.sleep(3000);
		String status1 = driver.findElement(By.id("CFNAActivatedOn")).getAttribute("class");
		System.out.println(status1); 
		/*if(status1=="btn")
			statusTracker("Fail","Verify Call Forwarding No Answer section can be enabled"," Call Forwarding No Answer section cannot be enabled","Call Forwarding No Answer section should not be enabled"); 
		else
			statusTracker("Pass","Verify Call Forwarding No Answer section can be  enabled"," Call Forwarding No Answer section can be enabled","Call Forwarding No Answer section should  be enabled");		
		*/	 
		
		if(driver.findElement(By.id("CFNAVMStatus")).isSelected())
		{ 
			System.out.println("vm");
			focusClick(driver,driver.findElement(By.id("CFNAStatus")),br);		
			Thread.sleep(5000);
			if(driver.findElement(By.cssSelector("div.field.clearfix > span")).isDisplayed()){
				test.pass("The warning is displayed while changing from Voicemail to Phone Number");
				i=statusTracker(i,"Pass","Verify if the warning message is present while browsing away from the voicemail radio button"," Warning message is present when voicemail radio button is changed","Warning message  should be  present when voicemail radio button is changed","");
			}else{
				test.fail("The warning is Not displayed while changing from Voicemail to Phone Number");
				i=statusTracker(i,"Fail","Verify if the warning message is present while browsing away from the voicemail radio button"," Warning message is not present when voicemail radio button is changed","Warning message  should not be present when voicemail radio button is changed","");
				schk="Fail";
			}
		}
		if(schk.equals("Pass"))
			schk=EditTN(driver,br,test);//Add TN
		if(schk.equals("Pass"))
			schk=SelectTN(driver,br,test);//Select Dropdown
		if(schk.equals("Pass"))
			schk=voicemail(driver,br,test);
		if(schk.equals("Pass"))
			schk=NumberofRings(driver,br,test);//Set Number of rings
		i=statusTracker(i,"","Verify TN Validation","","","");
		test.info("Verify TN Validation");
		TNValidation(driver,br,test);
		if(schk.equals("Pass"))
		{
			focusClick(driver,driver.findElement(By.id("CFNAActivatedOff")),br);
			Thread.sleep(3000);
			String status2 = driver.findElement(By.id("CFNAActivatedOff")).getAttribute("class");
			focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
			schk=orderprocess(driver,br);
			System.out.println(status2);
			if(status2=="btn"){
				test.fail("The Order for CFNA Disable is Failed");
				i=statusTracker(i,"Fail","Verify order processing for disabling Call Forwarding No Answer","Call Forwarding No Answer section is not be disabled","Call Forwarding No Answer section should be disabled",""); 
			}else{
				test.pass("The Order for CFNA Disable is Sucess");
				i=statusTracker(i,"Pass","Verify order processing for disabling Call Forwarding No Answer","Call Forwarding No Answer section is be disabled","Call Forwarding No Answer section should be disabled","");
			}
			}
	}
}