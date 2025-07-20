package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties pro;
	public Scanner sc;

  @SuppressWarnings("deprecation")
@BeforeClass(groups= {"Sanity","Regression","Master","DataDriven"})
  @Parameters({"Os","Browser"})
  public void setup(String os,String br) throws IOException {
	  
	  FileReader file=new FileReader("./src//test//resources//config.properties");
	  pro=new Properties();
	  pro.load(file);
	  sc=new Scanner(System.in);
	  
	  logger= LogManager.getLogger(this.getClass());
	  
	  if(pro.getProperty("execution_type").equalsIgnoreCase("remote")) {
		  
		  DesiredCapabilities cap=new DesiredCapabilities();
		  
		  if(os.equalsIgnoreCase("Windows")) {
			  cap.setPlatform(Platform.WIN11);
		  }
		  else if(os.equalsIgnoreCase("Mac")) {
			  cap.setPlatform(Platform.MAC);
		  }
		  else {
			  System.out.println("Default operating system");
			  return;
		  }
		  
		  switch(br.toLowerCase()) {
		  case "chrome": cap.setBrowserName("chrome"); break;
		  case "edge" : cap.setBrowserName("MicrosoftEdge"); break;
		  case "firefox" : cap.setBrowserName("firefox"); break;
		  default : System.out.println("No matching browser"); return;
		  }
		  driver=new RemoteWebDriver(new URL("http://192.168.1.4:4444/wd/hub"),cap);
	  }
	  if(pro.getProperty("execution_type").equalsIgnoreCase("Local")) {
	  
	  switch(br.toLowerCase()) {
	  case "chrome" :driver=new ChromeDriver();
	  break;
	  case "edge" :driver=new EdgeDriver();
	  break;
	  default: System.out.println("Invalid Browser option");
	  return;
	  }
	  }
	  
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get(pro.getProperty("URL"));
	  driver.manage().window().maximize();
	  
  }

  @AfterClass(groups= {"Sanity","Regression","Master","DataDriven"})
  public void tearDown() {
	  //driver.close();
	  driver.quit();
  }
  
  public String randomString() {
	  @SuppressWarnings("deprecation")
	  String GeneratedString= RandomStringUtils.randomAlphabetic(5); 
	  return GeneratedString;
  }
  
  public String randomNumber() {
	  @SuppressWarnings("deprecation")
	  String GeneratedNumber=RandomStringUtils.randomNumeric(10);
	  return GeneratedNumber;
  }
  
  @SuppressWarnings("deprecation")
public String randomAlphaNumeric() {
	  return(RandomStringUtils.randomAlphabetic(3)+"."+RandomStringUtils.randomNumeric(3)); 
  }
  
  public String checkTitle() {
	  return driver.getTitle();
  }
  
  public String CaptureScreen(String tname) throws IOException {
	  
	  String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			  
	  TakesScreenshot screenshot=(TakesScreenshot) driver;
	  File source=screenshot.getScreenshotAs(OutputType.FILE);
	  String SSpath=System.getProperty("user.dir")+"\\Screenshots\\"+tname+"_"+timeStamp+".png";
	  File target=new File(SSpath);
	  source.renameTo(target);
	  
	  return SSpath;
  }

}
