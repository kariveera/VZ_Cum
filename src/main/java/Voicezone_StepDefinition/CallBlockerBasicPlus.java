package Voicezone_StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class CallBlockerBasicPlus extends Commonfiles{
    String table, tns[];
    String tlimit,username,pwd;
    int tncount,tlim;                                                    
                                
    String phoneline,phoneline_ac,Acccode;
                int rank[]= new int[50];
                int c_sequence;
                String name_for_rank[]= new String[40];
                String price, rank_channels;

	@Given("^CallBlockerBasicPlus Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void CallBlockerBasicPlus_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
		String schk="Fail";
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("CallBlockerBasicPlus", "Execution Report of CallBlockerBasicPlus");
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
			focusClick(driver, driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[1]")),br);
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//div[@id='ContentRefresh']/ul/li[2]/a")).click();
	                    	    
	        Thread.sleep(5000);
	          try
	          {
	          if( driver.findElement(By.id("EACRActivated")).isDisplayed())
	          
	         EACRValidation(br,driver,test);
	          else
	           ACRValidation(br,driver,test);
	          }
	          catch(Exception e)
	          {
	        	  test.info("EACR Feature not present");
	        	  i=statusTracker(i,"Pass","EACR Feature not present","","","");
	        	  
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
        	 i=statusTracker(i,"","Feature Complete","","","End");
	          PrintResult("CallBlockerBasicPlus");
	         extent.flush();
	       }
         
	     }
	
	}	               
	                
	 public String ACRValidation( String br,WebDriver driver,ExtentTest test) throws Exception
	    	    {
	    	    	String schk="Fail";
	    	    	  Boolean status = driver.findElement(By.id("ACROn")).isSelected();
	        		  System.out.println("Initial state: "+status);
	        		  Boolean status1=false;
	            if (status.equals(false))
	             {
	        		 status1=true;
	        		  
	        		  focusClick(driver, driver.findElement(By.id("ACROn")),br);
	        		  
	        		  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	    				
	    			  schk=orderprocess(driver,br);;
	        		  
	        			  if(schk.equals("Pass")){
	        				  test.pass("ACR Order process is Sucess & Status changed from "+ status +" to "+status1);
	        				  i=statusTracker(i,"Pass","Verify if enabling ACR is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
	        			  }else{
	        				  test.fail("ACR Enable Order process is Failed");
	        				  i=statusTracker(i,"Fail","Verify if enabling ACR is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	        			  }
	        				  status = driver.findElement(By.id("ACROn")).isSelected();
	        				  System.out.println(status);
	        				  System.out.println("m here");
	        				  if ((status==true)&&(schk=="Pass"))
	        				  {
	        					  focusClick(driver, driver.findElement(By.id("ACREACROff")),br);
	        					 
	        				  
	        				  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	          				
	        				  schk=orderprocess(driver,br);;
	        				  System.out.println(status);
	        				  status1=false;
	        				  }
	        				
	        				  if(schk.equals("Pass"))
	        				  {
	        					  test.pass("ACR Order process is Sucess & Status changed from "+ status +" to "+status1);
	        					  i=statusTracker(i,"Pass","Verify if disabling ACR is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
	        				  }
	        				  else
	        				  {
	        					  test.fail("ACR Disable Order process is Failed");
	        					  i=statusTracker(i,"Fail","Verify if disabling ACR is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	        				  }  
	        		  }
	        		  else
	        		  {
	        			  
	        			
	    				  System.out.println("m here");
	    				  if ((status==true)&&(schk=="Pass"))
	    				    {
	    					  focusClick(driver, driver.findElement(By.id("ACREACROff")),br);
	    					 
	    				  
		    				  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
		      				
		    				  schk=orderprocess(driver,br);;
		    				  System.out.println(status);
		    				  status1=false;
		    				  }
		    				
		    				  if(schk.equals("Pass"))
		    				  {
		    					  test.pass("ACR Order process is Sucess & Status changed from "+ status +" to "+status1);
		    					  i=statusTracker(i,"Pass","Verify if disabling ACR is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
		    				  }
		    				  else
		    				  {
		    					  test.fail("ACR Disable Order process is Failed");
		    					  i=statusTracker(i,"Fail","Verify if disabling ACR is processed successfully","Order is not successfully processed","Order should be successfully processed","");
		    				  }  
		    				  status1=true;
		            		  
		            		  focusClick(driver, driver.findElement(By.id("ACROn")),br);
		            		  
		            		  focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
		        				
		        			  schk=orderprocess(driver,br);;
		            		  
		            			  if(schk.equals("Pass")){
		            				  test.pass("ACR Order process is Sucess & Status changed from "+ status +" to "+status1);
		            				  i=statusTracker(i,"Pass","Verify if enabling ACR is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
		            			  }
		            			  else{
		            				  test.fail("ACR Enable Order process is Failed");
		            				  i=statusTracker(i,"Fail","Verify if enabling ACR is processed successfully","Order is not successfully processed","Order should be successfully processed","");
		            			  }
	        		  }
	         return schk;		  
	    	    }  
	    	    
     public String flowrun( String br,WebDriver driver,String id,ExtentTest test) throws Exception
	    	    {
	    	      String schk="Fail";
	    	      
	    	      
	    	    boolean statusdisabled = driver.findElement(By.id("ACREACROff")).isSelected();
	  			System.out.println("val" +statusdisabled);
	  			boolean statuscw = driver.findElement(By.id("ACROn")).isSelected();
	  			System.out.println(statuscw);
	  			boolean statuscwcid = driver.findElement(By.id("EACRActivated")).isSelected();
	  			System.out.println(statuscwcid);
	  			
	        		String from,to;
	        		if(statusdisabled)
	        			from = "Disabled";
	        		else if (statuscw)
	        			from = "ACR";
	        		else
	        			from = "EACR";
	        			 
	        		System.out.println("after selection");
	        		to=id;
	        		if(to.contains("Off"))
	        			to="Disabled";
	        		
	        		else if(to.contains("On"))
	        			to="ACR";
	        		else
	        			to="EACR";
	        		System.out.println("xpath assignment");
	        		
	        		driver.findElement(By.id(id)).click();
	        		 focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	        	  	schk=orderprocess(driver,br);;
	        	  	
	        	  	if(schk.equals("Fail"))
	          		{
	          			i=statusTracker(i,"Fail","Verify order processing when switching from "+from+" to "+to,"Order processing has failed","Order should be processed successfully","");
	          			test.fail("The Order process is Sucess switching from "+from+" to "+to);
	          		}
	          		else
	          		{
	          			test.pass("The Order process is Sucess switching from "+from+" to "+to);
	          			System.out.println("Mpass");
	          			i=statusTracker(i,"Pass","Verify order processing when switching from "+from+" to "+to,"Order processing has completed successfully","Order should be processed successfully","");
	          		}  
	    	    return schk;	
	    	    }
 
     public String EACRValidation( String br,WebDriver driver,ExtentTest test) throws Exception
	    	    {
	    	    	System.out.println("In EACR Validation1");
	    	    	String schk="Fail";
	    	    	boolean statusdisabled = driver.findElement(By.id("ACREACROff")).isSelected();
	    			System.out.println(statusdisabled);
	    			boolean statusacr = driver.findElement(By.id("ACROn")).isSelected();
	    			System.out.println(statusacr);
	    			boolean statuseacr = driver.findElement(By.id("EACRActivated")).isSelected();
	    			System.out.println(statuseacr);
	    			
	    			
	    			if(statusdisabled)
	    			{
	    				driver.findElement(By.id("ACROn")).click();
	    				 focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);
	    				
	    				schk=orderprocess(driver,br);;
	    				
	    			}
	    		try
	   	          {
	   	          if( driver.findElement(By.id("PlayAudio")).isDisplayed())
	   	          {
	   	        	System.out.println("In EACR Validation with VM"); 
	   	        	schk =flowrun(br,driver, "ACREACROff",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver, "ACROn",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"EACRActivated",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"PlayAudio",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver, "ACROn",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver, "EACRActivated",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"PlayAudio",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver, "EACRActivated",test);
					if(schk.equals("Pass"))
					schk =flowrun(br,driver, "ACREACROff",test);
					
					if(schk.equals("Pass"))
						schk =flowrun(br,driver, "EACRActivated",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"PlayAudio",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver, "ACROn",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver, "ACREACROff",test);
	   	          }
	   	         
	   	          else
	   	          {
	   	        	System.out.println("In EACR Validation without VM"); 
	   	        	schk =flowrun(br,driver, "ACREACROff",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver, "ACROn",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"EACRActivated",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"ACREACROff",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"ACROn",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"EACRActivated",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"ACREACROff",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"EACRActivated",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"ACROn",test);
					if(schk.equals("Pass"))
						schk =flowrun(br,driver,"ACREACROff",test);
	   	          }
	   	          
	   	          }
	   	          catch(Exception e)
	   	          {
	   	        	  test.info("This is not VM Account");
	   	        	  i=statusTracker(i,"Pass","This is not VM Account","","","");
	   	        	  
	   	          }		  
	        return schk; 
	}  
}