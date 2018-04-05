package Voicezone_StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;

public class Pinchange extends Commonfiles{
                @Given("^Pinchange Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
                public void Pinchange_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
                    String schk="Fail";
                    extent.attachReporter(htmlReporter);
            		ExtentTest test = extent.createTest("Pinchange", "Execution Report of Pinchange");
                    if(Exe.equals("Yes")){
                      try{
                        if(first==0) 
                         {
                         login(Username,Password,br,tlim); 
                         }else
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
                     driver.findElement(By.xpath("(//a[contains(text(),'(edit)')])[2]")).click();
                     Thread.sleep(10000);
                                driver.findElement(By.linkText("Voicemail PIN Settings")).click();
                                Thread.sleep(5000);
                                  index=i;
                                schk=flowrun(driver,br,test); 
                     Thread.sleep(5000);
                     schk=Pinvalidation(driver,br,test);
                     Thread.sleep(5000);
                     first=1;
                     i=10;

             	     } 
           		   catch (Exception e){
                        exceptionHandler(br,e,driver);
                        }
                  finally {
               //wb.close();
               	 i=statusTracker(i,"","Feature Complete","","","End");
               	PrintResult("Pinchange");
                   extent.flush();
               }
            }
           }  
                   public String flowrun(WebDriver driver,String br,ExtentTest test) throws Exception {
                                   String schk="Fail";
                                   System.out.println("flowrun Inprogress");
                                 String pin1 = randomNO(9999,1000);
                                 System.out.println("flowrun");
                                 driver.findElement(By.id("PasswordForNewPin")).clear();
                                 driver.findElement(By.id("PasswordForNewPin")).sendKeys(pin1);
                                 driver.findElement(By.id("PasswordForConfirmPin")).clear();
                                 driver.findElement(By.id("PasswordForConfirmPin")).sendKeys(pin1);
                                 Thread.sleep(5000);
                                 driver.findElement(By.id("mainSubmitButton")).click();
                                 schk=orderprocess(driver,br);
                                 if(schk.equals("Pass")){
                                	 test.pass("Order is successfully processed for changing the new pin to "+ pin1);
                                                  i=statusTracker(i,"Pass","Verify if changing pin order is processed successfully","Order is successfully processed for changing the new pin to "+ pin1,"Order should be successfully processed","");
                                 }else{
                                	 test.fail("Order is not successfully processed for changing the new pin to "+ pin1);
                                                  i=statusTracker(i,"Fail","Verify if changing pin order is processed successfully","Order is not successfully processed for changing the new pin to "+ pin1,"Order should be successfully processed","");
                                 } return schk;
                    }


                    public String Pinvalidation(WebDriver driver,String br,ExtentTest test) throws Exception {
                                System.out.println("iam cumng");
                
                                  String schk ="Fail";
                                  String pin,pin2;
                                  
                                  schk=Pincheck(br,"","1234","Blank New ",driver,test);
                                  
                                  schk=Pincheck(br,"1234","","Blank Confirm",driver,test);
                                  
                                  String seftn=driver.findElement(By.xpath("//html/body/div[3]/form/div/div[2]/div/button/span")).getAttribute("data-friendlyname-contact");
                                  seftn=seftn.substring(6);
                                  schk=Pincheck(br,seftn,seftn,"Self",driver,test);
                                  
                                  schk=Pincheck(br,"1234","1234","consecutive",driver,test);
                                  System.out.println("order done");
                                 
                                  
                                  pin=randomNO(9,1);
                                  pin=pin+pin+pin+pin;
                                  System.out.println("m not hapenning"+pin);
                                  schk=Pincheck(br,pin,pin,"same digits",driver,test);
                                 
                                  pin=randomNO(999,100);
                                  schk=Pincheck(br,pin,pin,"less than 4 digit",driver,test);
                                  System.out.println("4 digits");
                                
                                  
                                  pin=randomNO(9999,1000);
                                  pin2=randomNO(9999,1000);
                                  schk=Pincheck(br,pin,pin2,"different confirm",driver,test);
                                  System.out.println("different");
                        
                                  schk="Pass";
                
                                  return schk;

                   }
                    
                    public String Pincheck(String br,String pin, String cpin, String check,WebDriver driver,ExtentTest test) throws Exception
                    {
                      String schk="Fail";
                                  Thread.sleep(5000);
                                  System.out.println("Iam cumng too");
                                  System.out.println("Befor entering pins");
                                  driver.findElement(By.id("PasswordForNewPin")).clear();
                                  driver.findElement(By.id("PasswordForNewPin")).sendKeys(pin);
                                  driver.findElement(By.id("PasswordForConfirmPin")).clear();
                                  driver.findElement(By.id("PasswordForConfirmPin")).sendKeys(cpin);
                                 Thread.sleep(2000);
                                  driver.findElement(By.id("mainSubmitButton")).click();
                                  schk=orderprocess(driver,br);
                                  
                                 if((driver.findElement(By.cssSelector("span.help-block.error")).isDisplayed()))
                                 {
                                	 test.pass("Error Message when adding "+check+ "message is displayed:"+driver.findElement(By.cssSelector("span.help-block.error")).getText());
                                  System.out.println("printing");
                                  i=statusTracker(i,"Pass","Verify if error message is displayed when adding "+check+" PIN","Error message is displayed:"+driver.findElement(By.cssSelector("span.help-block.error")).getText(),"Error message should be displayed","");
                                 } 
                                 else if(driver.findElement(By.xpath("//div[@id='pin-reset-form']/div[5]/span")).isDisplayed())
                                 {
                                	 test.pass("Error Message when adding "+check+ "message is displayed:"+driver.findElement(By.cssSelector("//div[@id='pin-reset-form']/div[5]/span")).getText());
                                	 i=statusTracker(i,"Pass","Verify if error message is displayed when adding "+check+" PIN","Error message is displayed: "+ driver.findElement(By.xpath("//div[@id='pin-reset-form']/div[5]/span")).getText(),"Error message should be displayed","");
                                 }  
                                 else
                                 {
                                	 test.fail("Error Message when adding "+check+"is not displayed");
                                	 i=statusTracker(i,"Fail","Verify if error message is displayed when adding "+check+" PIN","Error message is not displayed","Error message should be displayed","");
                                 }
                                return schk;
                    }
                
}
