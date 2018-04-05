package Voicezone_StepDefinition;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class ThreeWayCalling extends Commonfiles{
	  String table, tns[];
	    String tlimit,username,pwd;
	    int tncount;                                                    
	       boolean status,status1;                         
	    String phoneline,phoneline_ac,Acccode;
	                int rank[]= new int[50];
	                

	                int c_sequence;
	                String name_for_rank[]= new String[40];
	                String price, rank_channels;
	                
  @Given("^ThreeWayCalling Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
  public void ThreeWayCalling_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
	            		String schk="Fail";
	            		extent.attachReporter(htmlReporter);
	            		ExtentTest test = extent.createTest("ThreeWayCalling", "Execution Report of ThreeWayCalling");
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
	            			 System.out.println("ThreeWayCalling Inprogress");
	            			 int chk=0;
	            			    do{
	            			         Thread.sleep(1000);       
	            			        chk++;
	            			        System.out.println(chk);
	            			   }while(driver.findElement(By.xpath("//*[@id='progress']")).isDisplayed());
	            			 Thread.sleep(20000);
	            			 index=i;
	            			 focusClick(driver, driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[7]")),br);
	            	                Thread.sleep(5000);
	            	                status1=false;
	            	                status = driver.findElement(By.id("threewayActivated")).isSelected();
	            	               System.out.println("Initial state: "+status);
	            	             
	            	               
	            	           if (status==(false))
	            	           {
	            	                Thread.sleep(5000);
	            	                focusClick(driver,driver.findElement(By.id("threewayActivated")),br);
	            	                Thread.sleep(5000);
	            	                focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);            
	            	                       schk=orderprocess(driver,br);
	            	                       status1=true;
	            	                
	            	                       if(schk.equals("Pass"))
	            	                       {
	            	                    	   test.pass("3-way Calling Enable is Sucess");
	            	                             i=statusTracker(i,"Pass","Verify if enabling 3 way calling is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
	            	                       }
	            	                       else
	            	                       {
	            	                    	   test.fail("3-way Calling Enable is Failed");
	            	                             i=statusTracker(i,"Fail","Verify if enabling 3 way calling is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	            	                       }
	            	           
	            	                     status = driver.findElement(By.id("threewayActivated")).isSelected();
	            	                     Thread.sleep(5000);
	            	                       focusClick(driver,driver.findElement(By.id("threewayActivated")),br);
	            	                       Thread.sleep(5000);
	            	                       focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);     
	            	                       System.out.println(status);
	            	                       schk=orderprocess(driver,br);
	            	                       status1=false;

	            	                       if(schk.equals("Pass"))
	            	                       {
	            	                    	   test.pass("3-way Calling Disable is Sucess");
	            	                             i=statusTracker(i,"Pass","Verify if disabling 3 way calling is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
	            	                       }
	            	                       else
	            	                       {
	            	                    	   test.fail("3-way Calling Disable is Failed");
	            	                             i=statusTracker(i,"Fail","Verify if disabling 3 way calling is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	            	                       }
	            	          }
	            	                     
	            	           
	            	           else{
	            	                            
	            	                             status = driver.findElement(By.id("threewayActivated")).isSelected();
	            	                             System.out.println(status);
	            	                             focusClick(driver,driver.findElement(By.id("threewayActivated")),br);
	            	                             Thread.sleep(5000);
	            	                       focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);     
	            	                       schk=orderprocess(driver,br);
	            	                       status1=false;

	            	                             if(schk.equals("Pass"))
	            	                             {
	            	                            	 test.pass("3-way Calling Disable is Sucess");
	            	                                    i=statusTracker(i,"Pass","Verify if disabling 3 way calling is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
	            	                             }
	            	                             else
	            	                             {
	            	                            	 test.fail("3-way Calling Disable is Failed");
	            	                                    i=statusTracker(i,"Fail","Verify if disabling 3 way calling is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	            	                             }
	            	                             status = driver.findElement(By.id("threewayActivated")).isSelected();
	            	                             focusClick(driver,driver.findElement(By.id("threewayActivated")),br);
	            	                             Thread.sleep(5000);
	            	                             focusClick(driver,driver.findElement(By.id("mainSubmitButton")),br);                     
	            	                             schk=orderprocess(driver,br);
	            	                             status1=true;
	            	                            System.out.println(status);
	            	                             if(schk.equals("Pass"))
	            	                             {
	            	                            	 test.pass("3-way Calling Enable is Sucess");
	            	                                    i=statusTracker(i,"Pass","Verify if enabling 3 way calling is processed successfully","Order is successfully processed from "+ status +" to "+status1,"Order should be successfully processed","");
	            	                             }
	            	                             else
	            	                             {
	            	                            	 test.fail("3-way Calling Enable is Failed");
	            	                                    i=statusTracker(i,"Fail","Verify if enabling 3 way calling is processed successfully","Order is not successfully processed","Order should be successfully processed","");
	            	                             }
	            	                       }      
	            	              first=1;  
	            	              i=10;
	            		     } 
	            			   catch (Exception e){
	            	             exceptionHandler(br,e,driver);
	            	             }
	            	       finally {
	            	    //wb.close();
	            	    	 i=statusTracker(i,"","","","","End");
	            	    	PrintResult("ThreeWayCalling");
	            	        extent.flush();
	            	    }
	            	 }
	            }
}