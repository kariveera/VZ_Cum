package Voicezone_StepDefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Voicezone_Runner.TestRunner;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Commonfiles extends TestRunner {
	public static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("TestExtent.html");
	public static ExtentReports extent = new ExtentReports();
	public static int index;
    public static String Keyword = null;
	public static String TestScenario[] = new String[200];
	public static String Actual[] = new String[200];
	public static String Expected[] = new String[200];
	public static String Result[] = new String[200];
	public static String Gap[]=new String[200];
	public static String FeatureName[]=new String[200];
	public static int i=10;
	public static int first=0;
	public static int int_screenshot = 1;
	public static WebDriver driver;
    public static WebDriver getDriver()
    {
			return driver;
    }
    public static WebDriver getdriver(String browserName) {
    	if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			return new ChromeDriver();
		}
		else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			return new FirefoxDriver();
		}
		return null;
    }

    public void login(String Username,String Password,String Browser,int tlim) throws BiffException, InterruptedException {	
    	    driver=getdriver(Browser);
		 	driver.manage().window().maximize();
		 	driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
		    driver.get("http://voicezone.timewarnercable.com");
			Thread.sleep(5000); 
		    driver.findElement(By.id("cc-username")).sendKeys(Username);
			System.out.println("qtest1");
			driver.findElement(By.id("cc-user-password")).sendKeys(Password);
			Thread.sleep(10000);
			driver.findElement(By.id("login-form-button")).click();
			Thread.sleep(10000);
			
		    
    }
    public String randomNO(int max, int min)
    {
  	  	int Max=max;
  	  	int Min=min;
  	  	double random1=Min + (int)(Math.random() * ((Max - Min) + 1));
  		System.out.println(random1);
  		int random2=(int)random1;
  		System.out.println(random2);
  		String s1 = new Integer(random2).toString();
  		return(s1);
  		
  }
    protected boolean assertTrue(Object elementPresent) {
		// TODO Auto-generated method stub
		return false;
	}
   
	public String orderprocess(WebDriver driver,String br) throws Exception {
		
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int chk=0;
	      do{
	           Thread.sleep(1000);       
	          chk++;
	          System.out.println(chk);
	                }
	      while(driver.findElement(By.xpath("//*[@id='progress']")).isDisplayed());
		
		Thread.sleep(2000);
		if ((driver.findElements(By.id("modalContinueButton")).size() != 0)
				&& (driver.findElement(By.id("modalContinueButton"))
						.isDisplayed()))
		{
			Thread.sleep(5000);
			focusClick(driver,driver.findElement(By.id("modalContinueButton")),br);
			return "Fail";
					} 
		else if (!((driver.findElements(
				By.cssSelector("div.validation-summary-errors > ul > li")).size() != 0))) {
			// selenium.click("id=modalContinueButton");
			logger.info("Checkpoint in orderprocessing");
			return "Pass";
		} 
		else {
			return "Fail";
		}
		
	}
	
	
	
	public void focusClick(WebDriver driver,WebElement elementToClick,String br) throws Exception
	{
		System.out.println("element to click"  +elementToClick);
		
		
		Actions actions = new Actions(driver);
		if(br.equals("chrome"))
		{					
				try{
				Thread.sleep(500);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().y+")");
				}
				catch(Exception e){}
				elementToClick.click();
		}
		else if(br.equals("IE"))
		{
			actions.moveToElement(elementToClick);
			System.out.println("Here2");
			elementToClick.click();
		}
		else
		{
			actions.moveToElement(elementToClick);
			System.out.println("Here3");
			elementToClick.click();
			
		}
	}
	
    public int statusTracker(int i,String result,String testScenario,String actual,String expected,String gap) {
    	TestScenario[i]=testScenario;
    	Expected[i]=expected;
    	Actual[i]=actual;
    	Result[i]=result;
        Gap[i]=gap;
    	i=i+1;		
    	return i;
    }
    
    public void PrintResult(String Feature) throws BiffException, InterruptedException, Exception {
        status(TestScenario,Expected,Actual,Result,Gap,Feature);
    }
    
    public String exceptionHandler(String br,Exception ex, WebDriver driver) throws IOException {
		String s = "";
		//String name = "image";

		if (ex.getLocalizedMessage().contains("being used by another process"))
		{
					logger.info(""+"Please try again after closing the result sheet");
					i=statusTracker(i,"Fail","", ex.getMessage(),
							"Result Sheet Not accessible","");
					s="Test case not executed as IO file is not accessible - " + ex.getMessage();
 
		}
		else if (ex.getLocalizedMessage().contains("The system cannot find the file specified"))
		{
			logger.info(""+"Please check the input sheet");
			i=statusTracker(i,   "Fail","", ex.getMessage(),
					"Input Sheet Not accessible","");
			s="Test case not executed as IO file is not accessible - " + ex.getMessage();
		}
		else
		try {
				throw ex;
			} catch (NullPointerException e) {
			s = "Selenium is trying to access an object which is not present";
			i=statusTracker(i, "Fail", " ", s, "","");
			} catch (Exception e) {

			Date dNow;
			String imagename = "output\\Exception";
			SimpleDateFormat ft = new SimpleDateFormat("'_'MMMM dd'_'hh.mma");
			dNow = new Date();
			imagename = imagename + int_screenshot + ft.format(dNow) + ".png";
			int_screenshot++;			      				
			try {
				File scrFile1 = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile1, new File(imagename));
				// seleniu.captureEntirePageScreenshot(imagename, "");
			} catch (Exception f) {
				imagename = "Unable to capture a screenshot";
			}

			if (e.getMessage().contains("ids.eng.rr.com")) {
				logger.info("loop1_exception");
				s = "IDMS issue";
			} else if (e.getMessage().contains("sso-hrndva")) {
				logger.info("loop1a_exception");
				s = "SSO Gateway issue";
			}

			else if (e.getMessage().contains("not found")) {
				// logger.info("loop2_exception");
				// logger.info("I called excption handler");
				// logger.info(ex.getMessage());
				i=statusTracker(i, "Fail", "", e.getMessage(),
						"Element should be displayed","");
				s = "Selenium has stopped because an element was not found - "
						+ e.getMessage();
				// driver.quit();
				first = 0;
			} else if (e.getMessage().contains("terminal")
					|| driver.getCurrentUrl().contains("Terminal")) {
				// logger.info("loop3_exception");
				s = "Terminal error page has stopped execution";
				driver.quit();
				first = 0;
			} else if (driver.getCurrentUrl().contains("CLAReconcile.aspx")) {
				// logger.info("loop4_exception");
				s = "There was an error in the Reconciliation. Please retry";
				driver.quit();
				first = 0;
			} else if (driver.getCurrentUrl().contains("ids.eng.rr.com")) {
				// logger.info("loop5_exception");
				s = "IDMS issue has prevented the page from proceeding further";
				driver.quit();
				first = 0;
			} else if (driver.getCurrentUrl().contains("erminal")) {
				// logger.info("loop6_exception");
				s = "Terminal error page has prevented the automation from proceeding further";
				driver.quit();
				first = 0;
			} else if ((driver.findElements(By.id("css=h1")).size() != 0)
					&& (driver.findElements(By.id("id=imgLogo")).size() != 0)) {
				// logger.info("loop7_exception");
				s = "Top Error has prevented the page from proceeding further";
				driver.quit();
				first = 0;
			} else {
				// logger.info("loop8_exception");
				s = "The browser has taken too long to respond or an intermediate error has occurred "
						+ e.getMessage();

				// logger.info(e.getMessage());
				// driver.quit();
				// first=0;
				i=statusTracker(i, "Fail", " ", s, " ","");

			}
			// s=s+" Refer to screenshot: "+imagename;
			// statusTracker(br, "Fail"," ",s," ");
		}
		return s;
	}

    public void status(String TestScenario[],String Expected[],String Actual[],String Result[],String Gap[],String Feature) throws BiffException, InterruptedException, Exception 
    {
    	int t = 0;
    	WritableWorkbook myFirstWbook = null;
        
        try {
      	
             myFirstWbook = Workbook.createWorkbook(new File("output\\"+Feature+".xls"));
             WritableSheet Sheet = myFirstWbook.createSheet("Sheet 1",0);
             
             WritableFont TableFormat = new WritableFont(WritableFont.ARIAL, 10,
    					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
             
             WritableFont TableFormat1 = new WritableFont(WritableFont.ARIAL, 9,
    					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
            WritableCellFormat tfb;
             tfb = new WritableCellFormat();
             WritableCellFormat tfb1;
             tfb1=new WritableCellFormat();
             WritableCellFormat tfb2;
             tfb2 = new WritableCellFormat();
             WritableCellFormat tfb3;
             tfb3 = new WritableCellFormat();
           
             tfb.setBorder(Border.NONE,BorderLineStyle.NONE);
             tfb.setBackground(Colour.GREY_25_PERCENT);
            
                tfb1.setBackground(Colour.DARK_RED);
    			tfb1.setBorder(Border.ALL, BorderLineStyle.NONE);
    			 tfb1.setFont(TableFormat);
    			 tfb1.setAlignment(Alignment.CENTRE);
    			
    			tfb2.setBackground(Colour.INDIGO);
    			tfb2.setBorder(Border.ALL, BorderLineStyle.NONE);
    			tfb2.setFont(TableFormat);
    			tfb2.setAlignment(Alignment.CENTRE);
    			
    			 tfb3.setBorder(Border.ALL,BorderLineStyle.NONE);
    	         tfb3.setFont(TableFormat1);
    	     	 tfb3.setAlignment(Alignment.LEFT);
             
            Sheet.setColumnView(0, 20);
            Sheet.setColumnView(1, 40);
           	Sheet.setColumnView(2, 20);
           	Sheet.setColumnView(3, 40);
           	Sheet.setColumnView(4, 50); 
           	
           	Sheet.mergeCells(0,0,4,0);
    		Sheet.mergeCells(0,1,1,8);
    		Sheet.mergeCells(2,1,3,1);
    		Sheet.mergeCells(2,8,3,8);
    		Sheet.mergeCells(4,1,4,8);
    		
    		Label lbl = new Label(0, 0, "Voicezone - TEST RESULTS",tfb1);
    		Sheet.addCell(lbl);
    		lbl = new Label(2,1, "",tfb);
    		Sheet.addCell(lbl);
    		lbl = new Label(0,1, "",tfb);
    		Sheet.addCell(lbl);
    		lbl = new Label(2,8, "",tfb);
    		Sheet.addCell(lbl);
    		lbl = new Label(4,1, "",tfb);
    		Sheet.addCell(lbl);
    		   
    		Sheet.mergeCells(2,2,3,2);
    		
    		lbl = new Label(2, 2, "Execution Summary", tfb2);
    		Sheet.addCell(lbl);
    		tfb.setFont(TableFormat);
    		lbl = new Label(0, 9, "Test Case",	tfb2);
    		Sheet.addCell(lbl);
    		lbl = new Label(1, 9, "Test Scenario", tfb2);
    		Sheet.addCell(lbl);

    		lbl = new Label(2, 9, "Status", tfb2);
    		Sheet.addCell(lbl);
    		lbl = new Label(3, 9, "Actual Result", tfb2);
    		Sheet.addCell(lbl);
    		lbl = new Label(4, 9, "Expected Result", tfb2);
    		Sheet.addCell(lbl);
	
    		lbl = new Label(2,3, "Scripts Executed:", tfb3);
    		Sheet.addCell(lbl);
    		lbl = new Label(2,4, "Scripts Passed: ", tfb3);
    		Sheet.addCell(lbl);
    		lbl = new Label(2,5, "Scripts Failed: ", tfb3);
    		Sheet.addCell(lbl);
    		lbl = new Label(2,6, "Scripts Not Executed: ", tfb3);
    		Sheet.addCell(lbl);
    		lbl = new Label(2,7, "Execution Time: ", tfb3);
    		Sheet.addCell(lbl);
             
    		
    		  WritableCellFormat tfb4;
              WritableCellFormat tfb5;
              WritableCellFormat tfb6;
              WritableCellFormat tfb7;
           
         	 
              tfb4 = new WritableCellFormat();
         	  tfb5=new WritableCellFormat();
         	  tfb6=new WritableCellFormat();
         	  tfb7=new WritableCellFormat();

         	WritableFont TableFormat2 = new WritableFont(WritableFont.ARIAL, 10,
  				WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
  				Colour.AUTOMATIC);
         	
         	//Pass Sceanrio
            tfb4.setBackground(Colour.GREEN);
            tfb4.setFont(TableFormat2);
      	     tfb4.setBorder(Border.ALL, BorderLineStyle.THIN);
        	  tfb4.setAlignment(Alignment.LEFT);
        	  tfb4.setVerticalAlignment(VerticalAlignment.TOP);
        	  tfb4.setWrap(true);
        	 
        	  //Fail Style
        	 tfb5.setFont(TableFormat2);
        	  tfb5.setBackground(Colour.RED);
           tfb5.setAlignment(Alignment.LEFT);
     	     tfb5.setVerticalAlignment(VerticalAlignment.TOP);
     	     tfb5.setWrap(true);
     	     tfb5.setBorder(Border.ALL, BorderLineStyle.THIN);
     	     
     	     //Heading Scenario
     	     tfb6.setBackground(Colour.GREY_25_PERCENT);
     	     tfb6.setFont(TableFormat2);
  	     tfb6.setBorder(Border.ALL, BorderLineStyle.THIN);
    	     tfb6.setAlignment(Alignment.LEFT);
    	     tfb6.setVerticalAlignment(VerticalAlignment.TOP);
    	     tfb6.setWrap(true);
    	     
    	     //Normal Sceanrio
  	     tfb7.setBorder(Border.ALL, BorderLineStyle.THIN);
  	     tfb7.setAlignment(Alignment.LEFT);
  	     tfb7.setVerticalAlignment(VerticalAlignment.TOP);
  	     tfb7.setWrap(true);
     	        
       //Printing Status       
          
    for(int a=index;a<i;a++) 
      {     	      
             Label label = new Label(1, a,TestScenario[a],tfb7);
             Sheet.addCell(label);   
             
             label = new Label(4, a,Expected[a],tfb7);
             Sheet.addCell(label);
   
              label = new Label(3, a,Actual[a],tfb7);
              Sheet.addCell(label);
              
              if(Result[a].contains("Pass")) {
              	  label = new Label(2, a,Result[a],tfb4);
                    Sheet.addCell(label);
              }
              else if(Result[a].contains("Fail")) {
              	  label = new Label(2, a,Result[a],tfb5);
                   Sheet.addCell(label);
              } 
                          
        /*    if(Gap[a].contains("Start")) {
          	   t=a;
            }  */
              Date dNow;String actual = null;
              SimpleDateFormat ft = new SimpleDateFormat("'_'MMMM dd'_'hh.mma");
              String imagename = "output\\Fail";
              Actual[a]=actual;
              if (Result[a].equals("Fail")) {
      			// ||r.equals("refer_screenshot")
      			dNow = new Date();
      			logger.info(""+ft.format(dNow));
      			imagename = imagename + int_screenshot + ft.format(dNow) + ".png";
      			int_screenshot++;
      			try {
      				File scrFile1 = ((TakesScreenshot) driver)
      						.getScreenshotAs(OutputType.FILE);
      				FileUtils.copyFile(scrFile1, new File(imagename));
      				// selenium.captureEntirePageScreenshot(imagename, "");
      			} catch (Exception e) {
      				imagename = "Unable to capture screenshot";
      			}
      			Actual[a] = actual + " Refer screenshot: "
      					+ imagename;
      		}
              imagename = "output\\Pass";
              if (Result[a].equals("Pass")) {
        			// ||r.equals("refer_screenshot")
        			dNow = new Date();
        			logger.info(""+ft.format(dNow));
        			imagename = imagename + int_screenshot + ft.format(dNow) + ".png";
        			int_screenshot++;
        			try {
        				File scrFile1 = ((TakesScreenshot) driver)
        						.getScreenshotAs(OutputType.FILE);
        				FileUtils.copyFile(scrFile1, new File(imagename));
        				// selenium.captureEntirePageScreenshot(imagename, "");
        			} catch (Exception e) {
        				imagename = "Unable to capture screenshot";
        			}
        			Actual[a] = actual + " Refer screenshot: "
        					+ imagename;
        		}
            
        
             if(Gap[a].contains("End"))
             {
         	    //Mentioning FeatureName 
                 Sheet.mergeCells(0, 10, 0,a);
                 label = new Label(0, 10,Feature,tfb7);
                 Sheet.addCell(label);   
                 
                 //Page break
                 Sheet.mergeCells(0,a+1,4,a+1); 
                 label = new Label(0, a+1,"",tfb6);
                 Sheet.addCell(label); 
             }
     }	
    		
             myFirstWbook.write();
             

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }


        }
    }
   
}
