package commonMethods;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import scripts.Ramco;
import atu.testng.reports.exceptions.ATUReporterException;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class Testcases extends Config {
	{
		System.setProperty("atu.reporter.config", System.getProperty("user.dir") + "/atu.properties");
	}
	public String appURL;
	public String usernameValue;
	public String passwordValue;
	public String project_Name;
	public String version_Name;
	public String environment;
	public String browser;
	public WebDriver driver;

	
	File f = new File(report_folder_create + "\\reports");

	
    Ramco ram = new Ramco();

	@BeforeClass
	public void getDataFromConfig() throws ATUReporterException, IOException, InterruptedException {
		
		appURL = Utils.getDataFromTestConfig("URL");
		browser = Utils.getDataFromTestConfig("AppBrowser");
		usernameValue = Utils.getDataFromTestConfig("Username").trim();
		passwordValue = Utils.getDataFromTestConfig("Password").trim();
		project_Name = Utils.getDataFromTestConfig("Project_Name");
		version_Name = Utils.getDataFromTestConfig("Version_Name");
		environment = Utils.getDataFromTestConfig("Environment");
		driver=getWebDriver(browser);
	}
	//TS_001
	@Test
	
	public void login() throws IOException, JSONException, InterruptedException {
		
		ram.login(driver,appURL);
		
		
	}
	
	
	//TS_002
	
	  @Test 
	  public void CreatePurchaseOrder() throws IOException, JSONException,
	  InterruptedException, AWTException {
	  
	  ram.createorder(driver);
	  
	  }
	//TS_003
	  @Test 
	  public void EditPurchaseOrder() throws IOException, JSONException,
	  InterruptedException, AWTException {
	  
	  ram.editorder(driver);
	  
	  }
	//TS_004
	  @Test 
	  public void Authorizeorder() throws IOException, JSONException,
	  InterruptedException, AWTException {
	  
	  ram.authorizeorder(driver);
	  
	  }
	//TS_005
	  @Test 
	  public void GoodsInward() throws IOException, JSONException,
	  InterruptedException, AWTException {
	  
	  ram.goodsinward(driver);
	  
	  }
	//TS_006
	  @Test 
	  public void ConfirmReceipt() throws IOException, JSONException,
	  InterruptedException, AWTException {
	  
	  ram.confirmreceipt(driver);
	  
	  }
	
	//TS_007
	  @Test 
	  public void Supplierorder() throws IOException, JSONException,
	  InterruptedException, AWTException {
	  
	  ram.supplierorder(driver);
	  
	  }
	  
	  
	  @Test 
	  public void Aircraft() throws IOException, JSONException,
	  InterruptedException, AWTException {
	  
	  ram.aircraft(driver);
	  
	  }
	  
	
		
	@AfterTest
	public void teardown() throws Exception {
		driver.close();

	}
	

	

}
