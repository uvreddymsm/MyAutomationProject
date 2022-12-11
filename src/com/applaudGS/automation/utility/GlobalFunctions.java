package com.applaudGS.automation.utility;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.applaudGS.automation.objectrepository.Locators;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoSize;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class GlobalFunctions extends ReportManager{
	
///	public static WebDriver driver;
	public static Map<String, String> data;
	static public final int DRIVER_IMPLICIT_WAIT = 20;
    static public final int PAGE_LOAD_WAIT = 30;
    static public final int Element_LOAD_WAIT = 20;
    public String fileInput;
    public static String inputfield;
    public static String ScroolBarStatus;
    public static String textbox;
    private static ScreenRecorder screenRecorder;
	private static Object Static;
   
	public static By getLocator(String input){
			  By value = null;
			  if(input.startsWith("XPH::"))
				  value = By.xpath(input.substring(5));      
			  if(input.startsWith("ID::"))
				  value = By.id(input.substring(4));
			  if(input.startsWith("PLT::"))
				  value = By.partialLinkText(input.substring(5));
			  if(input.startsWith("CSS::"))
				  value = By.cssSelector(input.substring(5));
			  if(input.startsWith("CLASSNAME::"))
				  value = By.xpath(input.substring(11));
			  if(input.startsWith("NAME::"))
				  value = By.xpath(input.substring(6));
			  if(input.startsWith("TGN::"))
				  value = By.xpath(input.substring(5));
			
			  return value;
			  
			 
			  
		  }
	
	
	
	/** Method Deals To Launch Browser  **/
	//    @Parameters("browser")
		 public static WebDriver launchBrowser(WebDriver driver) throws Exception {
			
			 String firefox="firefox";
			 String chrome="chrome";
		     String ie="ie";
		     
		     System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");  
		  //    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Library\\chromedriver.exe");
		    //  System.setProperty("webdriver.chrome.driver","C:\\Users\\Yuvaraju Reddy\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		    // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Library\\chromedriver.exe");	
		     System.setProperty("webdriver.ie.driver","E:\\\\Workspace\\\\AppLaud\\\\Library\\\\chromedriver.exe");
		     
		        
		        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Library\\geckodriver.exe");
				
				if(firefox.equals(launchProperties("browser"))){
					  driver=new FirefoxDriver();
					  driver.manage().window().maximize();
				
					  
				  }
			   else if(chrome.equals(launchProperties("browser"))) {
				   ChromeOptions options = new ChromeOptions();
				   options.addArguments("disable-infobars");
				  
				   
				   // add parameter which will disable the extension
				 //  options.addArguments("--disable-extensions");
					driver=new ChromeDriver(options);
			    	driver.manage().window().maximize(); 
				
					//waitForPageToLoad( driver);
				}
			   else if(ie.equals(launchProperties("browser"))) {
					driver=new InternetExplorerDriver();
					driver.manage().window().maximize();
					
					//waitForPageToLoad( driver);
				}
				return driver;
	  }
	    
    /** Method Deals To Open URL Browser  **/
		 public static WebDriver openUrl(WebDriver driver, String url) throws Exception{
			 driver.get(launchProperties(url));
			 waitForPageToLoad( driver);
			 return driver;
		  }
		 
		 public static WebDriver launchUrl(WebDriver driver, String url) throws Exception{
			 driver.get(url);
			 waitForPageToLoad( driver);
			 
			 return driver;  
		  }
		 
		 public static WebElement waitforElementUsingFluent(WebDriver driver, By by, int timeOutInSeconds){
		        
		        WebElement element;
		        FluentWait  wait = new FluentWait(driver).withTimeout(timeOutInSeconds,TimeUnit.SECONDS).pollingEvery(200,TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		        element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		        return element;


		    }
		 
		 /** Handling Synchronization Using fluentWait **/
		 public WebElement fluentWait(final String EnterLocator){
		        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		                .withTimeout(30, TimeUnit.SECONDS)
		                .pollingEvery(5, TimeUnit.SECONDS)
		                .ignoring(NoSuchElementException.class);

		        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		            public WebElement apply(WebDriver driver) {
		                return driver.findElement(getLocator(EnterLocator));
		            }
		        });

		        return foo;
		    };
	
		 public static WebDriver tableColumn(WebDriver driver, String Columns) throws Exception{
			 driver.get(launchProperties(Columns));
			 waitForPageToLoad( driver);
			 
			return driver;      
		  }
		 
		 
		 /**Method Deals To Login For AppLaudGS**/
		 public static WebDriver appLogin(WebDriver driver ) throws Exception{
						 
			 GlobalFunctions.enterText(driver, Locators.UserName, GlobalFunctions.launchProperties("username"));
			 GlobalFunctions.enterText(driver, Locators.Password, GlobalFunctions.launchProperties("password"));
			 GlobalFunctions.click(driver, Locators.loginBtn);
			 GlobalFunctions.waitForPageToLoad(driver);
			 return driver;
		      
		  }
		 

		 /** Method Deals To WaitForPageToLoad **/
		 public static WebDriver waitForPageToLoad(WebDriver driver) {
				
				
		        JavascriptExecutor js = (JavascriptExecutor)driver;
		        String command = "return document.readyState";
		        try {
		            for (int i = 0; i < PAGE_LOAD_WAIT; i++) {
		            	
		            	
		            	Thread.sleep(1000);
		                
		                if (js.executeScript(command).toString().equals("complete")) {
		                    break;
		                }
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
				return driver;
		    }

		 
		 /** Method Deals To Click And WaitForPageToLoad **/
		 
		 public static WebDriver clickAndwaitForPageToLoad(WebDriver driver, String Locator){
			 try {
				click(driver, Locator);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 waitForPageToLoad(driver);
			 
			return driver;
			 
		 }
		 
		 
		 
		
		 
		 
		    public static List<WebElement> waitUntilListIsPopulated(String parent, String xpath, long timeout) {
		    		int count = 0;
		    		WebElement ele =driver.findElement(getLocator(parent));
		    		List<WebElement> webElements = new LinkedList<WebElement>();
		    		long startTime = System.currentTimeMillis();
		    		while (true) {
		    			try {
		    				webElements = ele.findElements(getLocator(xpath));
		    			} catch (NoSuchElementException e) {
		    			}
		    			if (webElements.size() == count && webElements.size() > 0)
		    				break;
		    			else
		    				count = webElements.size();

		    			if (System.currentTimeMillis() >= startTime + timeout)
		    				break;
		    		}

		    		return webElements;
		    }


			
		 
		 
		 
		 /** Method Deals To Synchronization **/
			public static WebDriver threadSleep(WebDriver driver,By input) throws Exception{
				int seconds =60;
				  while(seconds>=1){
				   try{
				    
				    boolean visible =  driver.findElement(input).isDisplayed();
				    
				    if(visible)
				     break;
				    else{
				     Thread.sleep(2000);
				     seconds--;
				    }
				     
				     
				   }
				   catch(Exception e){
				    Thread.sleep(1000);
				    seconds--;
				   }
				   
				  }
				
				return driver;				
			}
			
			
			
			
			/** Method Deals To Upload File **/
			public static WebDriver fileUpload(WebDriver driver, String EnterLocator, String filepath) throws Exception{
				
				  threadSleep(driver, getLocator(EnterLocator));
		      	  driver.findElement(getLocator(EnterLocator)).sendKeys(GlobalFunctions.launchProperties(filepath));
				
				return driver;
				
			}
			
			
			/** File Upload Using Robot Class **/
			public static WebDriver fileUploadUsingRobot(WebDriver driver, String EnterLocator, String fileLocation) throws Exception{
			//	GlobalFunctions.waitForPageToLoad(driver);
				StringSelection sel = new StringSelection(GlobalFunctions.launchProperties("DIFilePath"));
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
				 System.out.println("selection" +sel);
				 
				 GlobalFunctions.clickUsingActions(driver, EnterLocator);
				 
				// Create object of Robot class
				 Robot robot = new Robot();
				 Thread.sleep(1000);
				      
				  // Press Enter
				 robot.keyPress(KeyEvent.VK_ENTER);
				 
				// Release Enter
				 robot.keyRelease(KeyEvent.VK_ENTER);
				 
				  // Press CTRL+V
				 robot.keyPress(KeyEvent.VK_CONTROL);
				 robot.keyPress(KeyEvent.VK_V);
				 
				// Release CTRL+V
				 robot.keyRelease(KeyEvent.VK_CONTROL);
				 robot.keyRelease(KeyEvent.VK_V);
				 Thread.sleep(1000);
				        
				      //   Press Enter 
				 robot.keyPress(KeyEvent.VK_ENTER);
				 robot.keyRelease(KeyEvent.VK_ENTER);
				
		            
					return driver;
		        }
				
			
			
			
					
			
			 
		
			/** Method Deals To Take Screnshot **/
			public static WebDriver takeScreenshot(String EnterScreenName) throws Exception {
				//File ff=new File("ScreenShorts");
			//	ff.mkdir();
				
				DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
				  Date d=new Date();
				  String time=df.format(d);
				//  System.out.println(time);
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\Data\\"+ "\\Screen Shorts\\"+EnterScreenName+time+".png"));
		return driver;		
			}

			/** Purpose This Method For Attaching Screenshot In To Reports **/
			public static WebDriver CaptureScreenShot(ITestResult result, String methodname){
		    	
		    	  DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
				  Date d=new Date();
				  String time=df.format(d);
		    	//  WebDriver driver=ReportManager.driver;   
		          File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		                                        
		          try {
		                 FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Data\\"+ "\\Failed Screen Shots\\"+methodname+" "+time+".png"));
		                 test.log(
		         				LogStatus.INFO,
		         				"Error Snapshot : "
		         						+ test.addScreenCapture(System.getProperty("user.dir")+"\\Data\\"+ "\\Failed Screen Shots\\"+methodname+" "+time+".png"));
		          }
		          catch (IOException e) {
		               e.printStackTrace();
		          }
				return driver;
		     }		
				
			/** Method To Read Values From Properties File **/
      public static String launchProperties(String prop){
	
	  
	     Properties properties = new Properties();
	   try{
		   
		
		  //   FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"\\src\\Config.properties");
		   FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"\\ConfigFiles\\Config.properties");

		   properties.load(fileInput);
		
	      }catch(Exception e){
		      e.printStackTrace();
	     }
	
	         return properties.getProperty(prop);
}
      
      
      
      /** For Double Click **/
      public static WebDriver doubleClick(WebDriver driver,String input){
    	  Actions a=new Actions(driver);
	    //    a.moveToElement(driver.findElement(input)).doubleClick().build().perform();
	        a.moveToElement(driver.findElement(getLocator(input))).doubleClick().build().perform();
    	  
		return driver;
    	  
      }
      
      
      
      /** Click using Actions **/
     
      
      public static WebDriver clickUsingActions(WebDriver driver, String locator) throws Exception{
    	  
    	  threadSleep(driver,getLocator(locator));
    	  WebElement element = driver.findElement(GlobalFunctions.getLocator(locator));
    	  Actions a=new Actions(driver);
		  a.moveToElement(element).click().perform();
    	  
    	  
		return driver;
    	  
      }
      
      
      /** Click Using JavaScript Executor **/
      public static WebDriver clickUsingJavaScript(WebDriver driver,String Locator) throws Exception {
    	  GlobalFunctions.waitForPageToLoad(driver);
    	  GlobalFunctions.threadSleep(driver, getLocator(Locator));
    	  WebElement element = driver.findElement(getLocator(Locator));
    	  JavascriptExecutor executor = (JavascriptExecutor)driver;
    	  executor.executeScript("arguments[0].click();", element);
    	  
    	return driver;
     }
      /** For Double Click RND **/
      public static WebDriver double_Click(WebDriver driver,String input){
    	  Actions a=new Actions(driver);
    	  WebElement dc=(WebElement) getLocator(input);
	      a.moveToElement(dc).doubleClick().build().perform();
	      
		return driver;
    	  
      }
      
    /*  *//** Deals for Send Email **//*
      public static WebDriver sendEmail(WebDriver driver) throws Exception{
    	    
    	    
    		final String username=launchProperties("emaild");
    		final String pwd=launchProperties("password");
    		Properties props = new Properties();
    	    props.put("mail.smtp.auth", true);
    	    props.put("mail.smtp.starttls.enable", true);
    	    props.put("mail.smtp.host", "smtp.gmail.com");
    	    props.put("mail.smtp.port", "587");

    	    Session session = Session.getInstance(props,
    	            new javax.mail.Authenticator() {
    	                protected PasswordAuthentication getPasswordAuthentication() {
    	                    return new PasswordAuthentication(username,pwd);
    	                }
    	            });

    	    try {

    	        Message message = new MimeMessage(session);
    	        message.setFrom(new InternetAddress(launchProperties("emaild")));
    	        message.setRecipients(Message.RecipientType.TO,
    	                InternetAddress.parse(launchProperties("ToAddress")));
    	        message.setSubject("Applaud PRODUCT AUTOMATION REPORTS");
    	        message.setText("PFA");

    	        MimeBodyPart messageBodyPart = new MimeBodyPart();

    	        Multipart multipart = new MimeMultipart();

    	        messageBodyPart = new MimeBodyPart();
    	        
    	
    	    
    	        String time=GlobalFunctions.getTime();
    	        String file=System.getProperty("user.dir")+"\\Data\\"+ "\\Report Manager\\"+"CA Tracker"+time+".html";
    	    
    	       
    	        
    	        String fileName = "Crud Screens Automation Reports";
    	        DataSource source = new FileDataSource(file);
    	        messageBodyPart.setDataHandler(new DataHandler(source));
    	        messageBodyPart.setFileName(fileName);
    	        multipart.addBodyPart(messageBodyPart);

    	        message.setContent(multipart);

    	        System.out.println("Sending");

    	        Transport.send(message);

    	        System.out.println("Done");

    	    } catch (MessagingException e) {
    	        e.printStackTrace();
    	    }
			return driver;
			
    	    
    	  }*/
      
      /**This method is used For Verification Scroll Bar  **/
      public static  String  scroolBarVerification(WebDriver driver){
    	  String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
			JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
			Boolean b = (Boolean) (scrollBarPresent.executeScript(execScript));
			
			if (b == true) {
				test.log(LogStatus.INFO, GlobalUserDefinedMessages.ScrollBarPresentY);
				//return ScrollBarPresent;
				
				
			} else if (b == false){
				test.log(LogStatus.WARNING, GlobalUserDefinedMessages.ScrollBarPresentN);
				//System.out.print("Scrollbar is not present.");
			}
			
			/*JavascriptExecutor scrollBarWorking = (JavascriptExecutor) driver;
		
			scrollBarWorking.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        if(b==true){
	        	//System.out.println("Scroll Bar Is Working");
	        	test.log(LogStatus.INFO, GlobalUserDefinedMessages.ScrollBarPresentY);
	        }else{
	        //	System.out.println("Scrool Bar Is Not Working"); 
	        //	test.log(LogStatus.INFO, GlobalUserDefinedMessages.ScrollBarPresentN);
	        }*/
	        
	        
			ScroolDown(driver);
		//	ScroolUp(driver);
			
			return execScript;
    	  
    	  
		
    	  
      }
      
      /**This method is used For Validation Scroll Bar  **/
      public static boolean scroolBarValidation(WebDriver driver){
    	  String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
			JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
			Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
    	  JavascriptExecutor scrollBarWorking = (JavascriptExecutor) driver;
  		
			scrollBarWorking.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        if(test==true){
	        	System.out.println("Scroll Bar Is Working");
	        }else{
	        	System.out.println("Scrool Bar Is Not Working"); 
	        }
			return test;
      }
      
     
      
      
      
    /** This Method Is Used For Getting Values From List  **/
      public static WebDriver gettingListValues(WebDriver driver,By Input) throws Exception{
    	//  GlobalFunctions.threadSleep(driver, driver.findElement(Input));
    //	  driver.findElement(getLocator(Locators.listBoxIcon)).click();
    	  Thread.sleep(2000);
    //	  GlobalFunctions.click(driver, GlobalFunctions.getLocator(Locators.listBoxIcon));
    	  List<WebElement> options1=	 new Select(driver.findElement(Input)).getOptions();
		   for(int i=0;i<options1.size();i++){
			  options1.get(i).getText();
			  System.out.println("The List Values Are	:	"+options1.get(i).getText()); 
			
		   }
		 //  System.out.println("The List Values Are	:	"+values);
    	  
		return driver;
    	  
      }
      
      
    /** This Method Is Used For Getting Values From DropDown  **/
      public static WebDriver gettingDropDownValues(WebDriver driver,String enterlocator) throws Exception{
    	 
    	    data=DataReader.readData();
    	    System.out.println("The Values In The Drop Down Are : ");
  	        GlobalFunctions.threadSleep(driver, getLocator(enterlocator));
  		List<WebElement> s=    new Select(driver.findElement(getLocator(enterlocator))).getOptions();
  		
  		for(int i=0;i<s.size();i++){
  			System.out.println( s.get(i).getText());
  		}
  		
	    	return driver;
	 		
		   }
		
    	  
		
    	  
     
      
      
      
     
      
      
    /** This Method Is Used For Click On Any Element **/
      public static WebDriver click(WebDriver driver,String EnterLocator) throws Exception{
     // 	  data=DataReader.readData();
    	//  GlobalFunctions.waitForPageToLoad(driver);
      	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
      	  driver.findElement(getLocator(EnterLocator)).click();
      	  	  
      	  return driver; 
      	  
      }
      
      
      /** This Method Is Used For Enter Text To TextBox (Data fetching from properties file)**/
      public static WebDriver getpropertiesData(WebDriver driver,String EnterLocator,String EnterText) throws Exception{
      	  data=DataReader.readData();
      	  
      	 threadSleep(driver, getLocator(EnterLocator));
      	  driver.findElement(getLocator(EnterLocator)).sendKeys(GlobalFunctions.launchProperties(EnterText));
      	  	  
      	  return driver;
      	  
      }

      /** This Method Is Used For Enter Text To TextBox (Static data need to be enter) **/
      public static WebDriver enterText(WebDriver driver,String EnterLocator , String username) throws Exception{
      	  threadSleep(driver, getLocator(EnterLocator));
      	  driver.findElement(getLocator(EnterLocator)).sendKeys(username);    	 
      	  return driver;
      	  
      }
      
      /** This Method Is Used For Enter Text To TextBox (Data getting from External File ie:excel sheet) **/
      public static WebDriver sendkeys(WebDriver driver,String PassLocator,String EnterText) throws Exception{
      	  
    	  data=DataReader.readData();
      	  GlobalFunctions.threadSleep(driver, GlobalFunctions.getLocator(PassLocator));
      	  driver.findElement(GlobalFunctions.getLocator(PassLocator)).sendKeys(data.get(EnterText));
      	  	  
      	  return driver;
      	  
      }
      
      /** Checking Table Exists / Not In Database 
     * @throws IOException 
     * @throws BiffException **/
      public static WebDriver tableExits(WebDriver driver,String TableName) throws ClassNotFoundException, SQLException, BiffException, IOException{
    	  data=DataReader.readData();
    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	  Connection connection = DriverManager.getConnection("jdbc:sqlserver://Applaud.Net;database=Applaud_QA;","applaud", "aplaud@2017");
    	  Statement stmt = connection.createStatement();
    	  String TableNames=data.get(TableName);
    	  System.out.println("This Is The Table Name "+TableNames);
    	  ResultSet tables = connection.getMetaData().getTables(null, null, TableNames, null);
          if (tables.next()) {
        	  
              test.log(LogStatus.INFO, GlobalUserDefinedMessages.TableStatusInDBY+" :: "+TableNames);
        	// System.out.println("Table Created & It Exists");
        	}
        	else {
        	  test.log(LogStatus.ERROR, GlobalUserDefinedMessages.TableStatusInDBN);
        	// System.out.println("Table Not Created");
        	}
    	  
		return driver; 
    	  
      }
      
      
    /** This Method Is Used For Send Text To TextBox Through Actions **/
      public static WebDriver sendKeysThroughActions(WebDriver driver,String EnterLocator,String EnterText) throws Exception{
      	  data=DataReader.readData();
      	  
      	  
      	WebElement actions = driver.findElement(getLocator(EnterLocator));
  	   
   	  Actions navigator = new Actions(driver);
         navigator.click(actions)
             .sendKeys(Keys.END)
             .keyDown(Keys.SHIFT)
             .sendKeys(Keys.HOME)
             .keyUp(Keys.SHIFT)
             .sendKeys(Keys.BACK_SPACE)
            //.sendkeys("9");
             .sendKeys(data.get(EnterText))
             .perform();
      	  
     // 	  GlobalFunctions.threadSleep(driver, GlobalFunctions.getLocator(EnterLocator));
      //	  driver.findElement(GlobalFunctions.getLocator(EnterLocator)).sendKeys(data.get(EnterText));
      	  	  
      	  return driver;
      	  
      }
      
      
      /** This Method Is Used For Clear Text in To TextBox **/
      public static WebDriver clearText(WebDriver driver,String EnterLocator) throws Exception{
      	  data=DataReader.readData();
      	  
      	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
      	  driver.findElement(getLocator(EnterLocator)).clear();
      	  	  
      	  return driver;
      	  
      }
      
      

     

      

				
    /** This Method Is Used To Get Text From Text Box and soon  **/
      public static  String getText(WebDriver driver,String EnterLocator ) throws Exception{
      	  
      	  
      	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
      	  String gettext=  driver.findElement(getLocator(EnterLocator)).getText();
      	//  test.log(LogStatus.INFO,""+message +" :: "+gettext);
      	  return gettext;
      	  
      }
      
      
      /** This Method Is Used To Get Text From Text Box and soon  **/
      public static  String getTextSendToReport(WebDriver driver,String EnterLocator,String message) throws Exception{
      	  
      	  		
      	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
      	  String gettext=  driver.findElement(getLocator(EnterLocator)).getText();
      	//  System.out.println("Context Id Is : "+gettext);
      	  test.log(LogStatus.INFO,""+message +" :: "+gettext);
      	  return gettext;
      	  
      }
     
      
      /** This Method Is Used to Check Wheather An Element Is Displayed or not  **/
      public static boolean elementIsDisplayed(WebDriver driver,String EnterLocator) throws Exception{
    	  
    	 // data=DataReader.readData();
    	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
	     boolean b=  driver.findElement(getLocator(EnterLocator)).isDisplayed();
	   	        
	        try{
	        	 if(b==true){
	 	        	System.out.println("Element Is Displayed");
	 		
	 	        }
	        }catch(Exception e){
	        	System.out.println(e);
	        	System.out.println("Element Is Not Displayed");
	        }
    	  return b;
    	  
      }
      
      
      /** This Method Is Used to Check Wheather An Element Is Enabled or not **/
      public static boolean elementIsEnabled( WebDriver driver,String EnterLocator) throws Exception{
    	  
    	 // data=DataReader.readData();
    	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
	     boolean b=  driver.findElement(getLocator(EnterLocator)).isEnabled();
	   	        
	        try{
	        	 if(b==true){
	 	        	System.out.println("Element Is Enabled");
	 		
	 	        }
	        }catch(Exception e){
	        	System.out.println(e);
	        	System.out.println("Element Is Not Enabled");
	        }
			return b;
    	  
    	  
      }
      
      
    /** This Method Is Used to Check Wheather An Element Is Selected or not **/
      public static boolean elementIsSelected(WebDriver driver,String EnterLocator) throws Exception{
    	  
    	 // data=DataReader.readData();
    	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
	     boolean b=  driver.findElement(getLocator(EnterLocator)).isSelected();
	   	        
	        try{
	        	 if(b==true){
	 	        	System.out.println("Element Is Selected");
	 		
	 	        }
	        }catch(Exception e){
	        	System.out.println(e);
	        	System.out.println("Element Is Not Selected");
	        }
    	  return b;
    	  
      }
      
     /** Verifying Dropdown selected value 
     * @throws Exception **/
      public WebDriver isDropdownSelectedValue(WebDriver driver, String Locator) throws Exception {
    	 System.out.println("Dropdown Logic For Element Validation");
    	 String id="ctl00_mainContent_ddl_Adult";
    	 GlobalFunctions.threadSleep(driver, getLocator(Locator));  
    	 List<WebElement> s=new Select(driver.findElement(getLocator(Locator))).getOptions();
    	  System.out.println(s.size());
    	  for (int i = 0; i < s.size(); i++) {
    	  
    	   if(s.get(i).isSelected())
    	   {
    	   System.out.println(s.get(i).getText());
    	   
    	   }else
    	   {
    	    System.out.println("Element Is Disabled");
    	   }
    	  }
		return driver;
      }
      
      /** Verifying List selected value 
       * @throws Exception **/
        public static WebDriver isListSelectedValue(WebDriver driver, String Locator, String Value) throws Exception {
      	
      	 data=DataReader.readData();
      	 String listValue=data.get(Value);
      	 GlobalFunctions.threadSleep(driver, getLocator(Locator));  
      	List<WebElement> s= driver.findElements(GlobalFunctions.getLocator(Locator));
      	  System.out.println(s.size());
      	  for (int i = 0; i < s.size(); i++) {
      	  Thread.sleep(2000);
      		  WebElement ele=s.get(i);
      		  
      		
      	   if(s.get(i).isSelected())
      	   {
      		 System.out.println("Sucess Exact Value Is Selected"+s.get(i).getText());
      		  
      	   
      	   
      	   }else
      	   {
      	    System.out.println("Element Is Disabled");
      	   }
      	  }
  		return driver;
        }


			
      
      
   // Unchecking
      
      public static boolean checkbox_Unchecking(WebDriver driver,String EnterLocator) throws Exception {
            threadSleep(driver, getLocator(EnterLocator));
    	  
            WebElement ele=driver.findElement(getLocator(EnterLocator));
    	  boolean checkstatus=  ele.isSelected();
      
      
      if (checkstatus == true) {
    	  ele.click();
      System.out.println("Checkbox is unchecked");
      } else {
      System.out.println("Checkbox is already unchecked");
      }
	return checkstatus;
      }
      
      public static boolean radioButton_Deselect(WebDriver driver,String EnterLocator) throws Exception {
       threadSleep(driver, getLocator(EnterLocator));
  	  
          WebElement ele=driver.findElement(getLocator(EnterLocator));
  	  boolean checkstatus=  ele.isSelected();
    
    
    if (checkstatus == true) {
  	  ele.click();
    System.out.println("Radio Button is deselected");
    } else {
    System.out.println("Radio Button was already Deselected");
    }
	return checkstatus;
    }
      
      
      /** Deals with Tool Tip **/
      public static String getToolTip(WebElement toolTipofWebElement)throws InterruptedException {
    	  
    		  
    		  String tooltip = toolTipofWebElement.getAttribute("title");
    		  System.out.println("Tool text :  " + tooltip);
    		  return tooltip;
    		  }
      
      
      
      public static WebDriver  highlightelement(WebDriver driver,String EnterLocator) throws Exception {
    	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
      	  
          WebElement element=driver.findElement(getLocator(EnterLocator));
    	  
          for (int i = 0; i < 2; i++) {
  			JavascriptExecutor js = (JavascriptExecutor) driver;
  			js.executeScript(
  					"arguments[0].setAttribute('style', arguments[1]);",
  					element, "color: red; border: 3px solid red;");
  			js.executeScript(
  					"arguments[0].setAttribute('style', arguments[1]);",
  					element, "");
  		}
		return driver;

    	  }
      
      /** Uploading File Using Autoit  **/
      public static WebDriver uplodFile(WebDriver driver,String EnterLocator,String EnterPathOfTheFile) throws Exception{
    	  
    	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
    	  WebElement element=driver.findElement(getLocator(EnterLocator));
  		  element.click();
                 //Which calls the autoit exe file
  		  Runtime.getRuntime().exec(EnterPathOfTheFile);
    	  
    	  
		return driver;
    	  
      }
      
      /** Select value from dropdown by using selectValueByIndex(From External File)  **/
      public static WebDriver selectValueByIndex(WebDriver driver,String EnterLocator,String EnterIndex) throws Exception{
    	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
    	  
    	  
    	 int sss= Integer.parseInt(data.get(EnterIndex));
    	
  		  new Select(driver.findElement(getLocator(EnterLocator))).selectByIndex(sss);
  		  
    	  
		return driver;
    	  
      }
      
      /** Select value from dropdown by using selectValueByVisibleText(From External File)  **/
      public static WebDriver selectValueByVisibleText(WebDriver driver,String EnterLocator,String EnterVisibleText) throws Exception{
    	  threadSleep(driver, getLocator(EnterLocator));
  		  new Select(driver.findElement(getLocator(EnterLocator))).selectByVisibleText(data.get(EnterVisibleText));
    	  
		return driver;
    	  
      }
      
      /** Select value from dropdown by using selectValueByVisibleText(Static Data)  **/
      public static WebDriver selectValueByVisibleText_Normal(WebDriver driver,String EnterLocator,String EnterVisibleText) throws Exception{
    	  threadSleep(driver, getLocator(EnterLocator));
  		  new Select(driver.findElement(getLocator(EnterLocator))).selectByVisibleText(EnterVisibleText);
    	  
		return driver;
    	  
      }
      
      /** Verifying Text Present or Not In Texbox **/
      public static String verifyTextPresentInTextBox(WebDriver driver,String EnterLocator ) throws Exception{
    	threadSleep(driver, getLocator(EnterLocator));
    	
    	  String textInsideInputBox=driver.findElement(getLocator(EnterLocator)).getAttribute("value");
    	 
    	  
    	  
    	 
    	  boolean b=(boolean)textInsideInputBox.isEmpty() && (textInsideInputBox!=null) ;
    	  if(b==true){
    		  inputfield=" Yes : Input field is Empty";
    		 // System.out.println("Input field is Empty");
    	  }else{
    	      inputfield="Input field is Full With Text And The Text Is  :  "+ textInsideInputBox;
    		 // System.out.println("Input field is Full With Text And The Text Is  :  "+textInsideInputBox);
    	  }
    	  
    	  
  		return inputfield;
    	    	  
      }
      
      /** Verifying Text Present Or Not In a Page **/
      public static boolean verifyTextPresent(WebDriver driver,String EnterSearchText)throws Exception{
    	  
    	  
    	  boolean b=(boolean)driver.getPageSource().contains(EnterSearchText);
    	  System.out.println("The Status Of The Text After Searching In The Page Is  :  "+b);
		  return b;
    	  
    	  
      }
      
      /** Vefifying Element Present or Not **/
      public static boolean elementPresent(WebDriver driver,String EnterLocator) throws Exception{
    	  threadSleep(driver, getLocator(EnterLocator));
    	 
    	  boolean b=driver.findElements(getLocator(EnterLocator)).size() != 0;
    	  
    	  if(b==true){
    		  System.out.println("Element is Present");
    	  }else{
    		  System.out.println("Element is Not Present");
    	  }
    	  
    	  
    	 
    	  
		return b;
    	  
      }
      
      /** Deals With Right Click **/
      public static WebDriver rightClick(WebDriver driver,String EnterLocator)throws Exception{
    	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
    	  WebElement ele=driver.findElement(getLocator(EnterLocator));
    	  Actions action = new Actions(driver).contextClick(ele);
    	  action.build().perform();
    	  waitForPageToLoad(driver);
		  return driver;
      }
       
      /** Deals With VefifyImage **/
      public static WebDriver verifyImage(WebDriver driver,String EnterLocator ) throws Exception {
    	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
    		
    		WebElement ImageFile = driver.findElement(getLocator(EnterLocator));
    	        
    	        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
    	        if (!ImagePresent)
    	        {
    	             System.out.println("Image not displayed.");
    	        }
    	        else
    	        {
    	            System.out.println("Image displayed.");
    	        }
				return driver;
    		}
      
    /** This Method Is Used For Click On Any Element **/
      public static WebDriver clickRnD(WebDriver driver,String EnterLocator) throws Exception{
      	  data=DataReader.readData();
      	  
      	  GlobalFunctions.threadSleep(driver, getLocator(EnterLocator));
      	  driver.findElement(getLocator(EnterLocator)).click();
      	  	  
      	  return driver; 
      	  
      }
      
      
      /** This Method is used to get Current System Date & Time **/
      
      public static String getTime(){
    	  
    	  DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
		  Date d=new Date();
		  String time=df.format(d);
		return time;
      }
     
      
      
      /** Validating ScroolDown functionality **/
      public static WebDriver  ScroolDown(WebDriver driver){
    	  try{
    	  JavascriptExecutor jse = (JavascriptExecutor)driver;
       	  jse.executeScript("window.scrollBy(0,250)", "");
    	// jse.executeScript("scroll(0, 250);");
       	  test.log(LogStatus.INFO, GlobalUserDefinedMessages.ScrollDownY);
    	  }catch(Exception e){
    		  test.log(LogStatus.WARNING, GlobalUserDefinedMessages.ScrollDownN);
    	  }
          
		return driver;
    	  
      }
     /* *//** Validating ScroolUp functionality **//*
      public static WebDriver ScroolUp(WebDriver driver){
    	  try{
    	  JavascriptExecutor jse = (JavascriptExecutor)driver;
    	  boolean b=(boolean)  jse.executeScript("scroll(0, -250);");
    	  
         
        	 test.log(LogStatus.INFO, GlobalUserDefinedMessages.ScrollUpY);
    	  }catch(Exception E){
        	  test.log(LogStatus.WARNING, GlobalUserDefinedMessages.ScrollUpN);
         
    	  }
		return driver;
    	  
      }*/
      
      /** Method Used To Record Video **/
      
	public static WebDriver startVideoCapture(WebDriver driver) throws Exception {
     	 
    	  String TargetFolder=System.getProperty("user.dir")+"\\Data\\"+ "\\Video Capture\\";
    	 
    	//  String TargetFolder=System.getProperty("user.dir")+"\\Data\\"+ "\\Video Capture\\"+"AppLaud.html";
    	    // set the graphics configuration
    	    GraphicsConfiguration gc = GraphicsEnvironment
    	            .getLocalGraphicsEnvironment()
    	            .getDefaultScreenDevice()
    	            .getDefaultConfiguration();
    	         
    	    // initialize the screen recorder:
    	    // - default graphics configuration
    	    // - full screen recording
    	    // - record in AVI format
    	    // - 15 frames per second
    	    // - black mouse pointer
    	    // - no audio
    	    // - save capture to predefined location
    	         
    	    screenRecorder = new ScreenRecorder(gc,
    	            gc.getBounds(),
    	            new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
    	            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
    	                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
    	                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
    	                    QualityKey, 1.0f,
    	                    KeyFrameIntervalKey, 15 * 60),
    	            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
    	            null,
    	            new File(TargetFolder));
    	    screenRecorder.start();
			return driver;
    	}
	
	/** Method Used To Stop Record Video **/
	public static WebDriver stopVideoCapture(WebDriver driver){
		try {
			screenRecorder.stop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
		
	}
    
	/** Method Used To Convert Video From One Format To Another Format **/
	
	public static WebDriver videoConverter(WebDriver driver) throws IllegalArgumentException, InputFormatException, EncoderException{
		
			System.out.println("File Conversion Process Started .... Pls be Wait");
			File source = new File("D:\\AppLaudAutomation\\Automation\\AppLaud\\Data\\Video Capture\\TestingPurpose.avi");
			File target = new File("D:\\AppLaudAutomation\\Automation\\AppLaud\\Data\\Video Capture\\TestingPurpose.mp4");
			AudioAttributes audio = new AudioAttributes();
			//	audio.setCodec("libmp3lame"); libfaac
			audio.setCodec("libfaac");
			audio.setBitRate(new Integer(64000));
			audio.setChannels(new Integer(1));
			audio.setSamplingRate(new Integer(22050));
			VideoAttributes video = new VideoAttributes();
			video.setCodec("mpeg4");
			video.setBitRate(new Integer(160000));
			video.setFrameRate(new Integer(15));
			video.setSize(new VideoSize(400, 300));
			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setFormat("mp4");
			attrs.setAudioAttributes(audio);
			attrs.setVideoAttributes(video);
			Encoder encoder = new Encoder();
			encoder.encode(source, target, attrs);
			System.out.println("Buddy .... Done File Converted");
			return driver;
		}
	
      
      public static WebDriver login( WebDriver driver, String username , String password) throws AWTException{
    	  
    	 
   	   Robot robot1 = new Robot();
   	  
   			StringSelection stringSelection = new StringSelection(launchProperties("username"));
 		    System.out.println("This Is User Name "+launchProperties("username"));
   	   	     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
   	   	     clipboard.setContents(stringSelection, stringSelection);
   			    robot1.keyPress(KeyEvent.VK_CONTROL);
   			    robot1.keyPress(KeyEvent.VK_V);
   			    robot1.keyRelease(KeyEvent.VK_V);
   			    robot1.keyRelease(KeyEvent.VK_CONTROL);
   			    robot1.keyPress(KeyEvent.VK_TAB);
   			    robot1.delay(500);
   			  StringSelection stringSelection1 = new StringSelection(launchProperties("password"));
    	      System.out.println("This Is User Name "+launchProperties("username"));
     	 	  Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
     	 	  clipboard1.setContents(stringSelection1, stringSelection1);   	 		
     	 			 robot1.keyPress(KeyEvent.VK_CONTROL);
     	 			 robot1.keyPress(KeyEvent.VK_V);
     	 			 robot1.keyRelease(KeyEvent.VK_V);
     	 			 robot1.keyRelease(KeyEvent.VK_CONTROL);
     	 	      robot1.keyPress(KeyEvent.VK_ENTER);
   	    
   	   
		return driver;
       }
      
      
      
      
      /** RND Driver Script **/
      @Test
	  public static void DriverScript() throws Exception{
    	     String str;
	FileInputStream fi=new FileInputStream("D:\\AppLaud_WorkSpace\\FrameWork\\Data\\Test Data\\TestData.xls");
		Workbook w=Workbook.getWorkbook(fi);
		Sheet s=w.getSheet("Sheet1");
	for(int c=2; c<s.getColumns(); c++){	
		for (int i = 1; i < s.getRows(); i++) {
			try{
				if(s.getCell(2, i).getContents().equalsIgnoreCase("dropdown"))
				{
		new Select(driver.findElement(By.name(s.getCell(0, i).getContents()))).selectByVisibleText(s.getCell(c, i).getContents());			
				}
				else if(s.getCell(2, i).getContents().equalsIgnoreCase("textbox"))
				{
					
					 str=s.getCell(c, i).getContents();
					 
					 System.out.println("This Is Excel Value"+str);
					
		     driver.findElement(By.name(s.getCell(0, i).getContents())).sendKeys(s.getCell(c, i).getContents());	
		
		
				}
				else if(s.getCell(2, i).getContents().equalsIgnoreCase("button"))
				{
					driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
				}
				else if(s.getCell(2, i).getContents().equalsIgnoreCase("url"))
				{
					driver.get(s.getCell(0, i).getContents());
				}
				else if(s.getCell(2, i).getContents().equalsIgnoreCase("link"))
				{
				driver.findElement(By.linkText(s.getCell(0, i).getContents())).click();
				}
				else if(s.getCell(2, i).getContents().equalsIgnoreCase("alert"))
				{
					if(s.getCell(c, i).getContents().equalsIgnoreCase("ok"))
					{
					driver.switchTo().alert().accept();
					}else{
					driver.switchTo().alert().dismiss();
					}
				}
				else if(s.getCell(2, i).getContents().equalsIgnoreCase("wait"))
				{
					Thread.sleep(2000);
				}
				
			}catch(Exception e){}
		}
	}
		  
	  }
}


			


