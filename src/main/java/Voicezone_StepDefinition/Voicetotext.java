package Voicezone_StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;


public class Voicetotext extends Commonfiles {
	@Given("^Voicetotext Get\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and (\\d+)$")
	public void Voicetotext_Get_and_and_and_and(String Username, String Password, String Exe, String br, int tlim) throws Throwable {
		String schk="Fail";
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("VoicetoText", "Execution Report of VoicetoText");
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
		 driver.findElement(By.xpath(".//*[@id='ContentRefresh']/div/div[3]/div[2]/div/a")).click();
		 Thread.sleep(5000);
		 index=i;
		 Boolean status = driver.findElement(By.id("VoicemailToText")).isSelected();
		 if(status==true)
		 {
			 String status1 = "On", status2="Off";
			 flowrunVM(driver,br,test,status1,status2);
			 flowrunVM(driver,br,test,status1,status2);
		 }
		 else
		 {
			 String status1 = "Off", status2="On";
			 flowrunVM(driver,br,test,status1,status2);
			 flowrunVM(driver,br,test,status1,status2);
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
 	PrintResult("Voicetotext");
     extent.flush();
 }
}
}
	
    public void flowrunVM(WebDriver driver,String br,ExtentTest test,String status1, String status2) throws Exception {
    	 //Boolean status = driver.findElement(By.id("VoicemailToText")).isSelected();
         System.out.println("Iam running");
         String schk="Fail";
         System.out.println("yessssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
         driver.findElement(By.id("VoicemailToText")).click();
         System.out.println("after state status: "+status1);
         System.out.println("Before state status1: "+status2);
         driver.findElement(By.id("mainSubmitButton")).click();
         Thread.sleep(5000);
         schk=orderprocess(driver,br);
         System.out.println(schk);
         if(schk.equals("Pass"))
		    {
        	 	test.pass("voice2text Status changed Sucessfully from"+status1+"to"+status2);
        	 	i=statusTracker(i,"Pass","Verify if voice2text Status changed from"+status1+"to"+status2,"Status was saved successfully","Status should be saved successfully","");
		    }
		    else
		    {
		    	test.fail("voice2text Status not changed Sucessfully from"+status1+"to"+status2);
		    	i=statusTracker(i,"Fail","Verify if voice2text Status changed from"+status1+"to"+status2,"Status was not saved successfully","Status should be saved successfully",""); 
		    	
		    }
         }

}
