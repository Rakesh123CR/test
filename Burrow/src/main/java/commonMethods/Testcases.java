package commonMethods;

import java.io.File;
import java.io.IOException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import scripts.Burrow;
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

	
    Burrow burrow = new Burrow();

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
	
	
	
	
	//Checkout
	



	//TS_001
	@Test
	
	public void withoutAddress() throws IOException, JSONException, InterruptedException {
		
		burrow.launch(driver, appURL);
		/*
		 * burrow.addToBoxLoveseat(driver); burrow.checkout(driver);
		 * burrow.guestUser(driver); burrow.shippingDetails(driver);
		 * burrow.withoutShippingBillingAddress(driver);
		 */
		
	}
	
	
	/*
	 * //TS_002
	 * 
	 * @Test public void withoutShippingWithBillingAddress() throws IOException,
	 * JSONException, InterruptedException {
	 * 
	 * burrow.withoutShippingWithBillingAddress(driver);
	 * 
	 * }
	 * 
	 * //TS_003
	 * 
	 * @Test
	 * 
	 * public void withShippingWithoutBillingAddress() throws IOException,
	 * JSONException, InterruptedException {
	 * 
	 * burrow.withShippingWithoutBillingAddress(driver);
	 * 
	 * }
	 * 
	 * //TS_004
	 * 
	 * @Test public void guestUserGoogleShippingAddress() throws IOException,
	 * JSONException, InterruptedException {
	 * 
	 * burrow.paymentWithSameShippingAddress(driver); burrow.placeOrder(driver);
	 * burrow.orderAfterPlaced(driver); }
	 * 
	 * //TS_005
	 * 
	 * @Test public void guestUserManualShippingAddress() throws IOException,
	 * JSONException, InterruptedException {
	 * 
	 * //burrow.launch(driver, appURL); burrow.addToBoxLoveseat(driver);
	 * burrow.checkout(driver); burrow.guestUser(driver);
	 * burrow.shippingDetails(driver);
	 * burrow.shippingAddressManualAndSameBilling(driver);
	 * burrow.placeOrder(driver); burrow.orderAfterPlaced(driver); }
	 * 
	 * //TS_006
	 * 
	 * @Test public void guestUserDifferentGoogleAddress() throws IOException,
	 * JSONException, InterruptedException {
	 * 
	 * //burrow.launch(driver, appURL); burrow.addToBoxLoveseat(driver);
	 * burrow.checkout(driver); burrow.guestUser(driver);
	 * burrow.shippingDetails(driver); burrow.shippingAddressGoogle(driver);
	 * burrow.cardDetails(driver); burrow.BillingDetails(driver);
	 * burrow.BillingAddressGoogle(driver); burrow.placeOrder(driver);
	 * burrow.orderAfterPlaced(driver); }
	 * 
	 * //TS_007
	 * 
	 * @Test public void guestUserGoogleAndManualAddress() throws IOException,
	 * JSONException, InterruptedException {
	 * 
	 * //burrow.launch(driver, appURL); burrow.addToBoxLoveseat(driver);
	 * burrow.checkout(driver); burrow.guestUser(driver);
	 * burrow.shippingDetails(driver); burrow.shippingAddressGoogle(driver);
	 * burrow.cardDetails(driver); burrow.BillingDetails(driver);
	 * burrow.BillingAddressManual(driver); burrow.placeOrder(driver);
	 * burrow.orderAfterPlaced(driver); }
	 * 
	 * //TS_008
	 * 
	 * @Test public void guestUserManualAndGoogleAddress() throws IOException,
	 * JSONException, InterruptedException {
	 * 
	 * //burrow.launch(driver, appURL); burrow.addToBoxLoveseat(driver);
	 * burrow.checkout(driver); burrow.guestUser(driver);
	 * burrow.shippingDetails(driver); burrow.shippingAddressManual(driver);
	 * burrow.cardDetails(driver); burrow.BillingDetails(driver);
	 * burrow.BillingAddressGoogle(driver); burrow.placeOrder(driver);
	 * burrow.orderAfterPlaced(driver); }
	 * 
	 * //TS_009
	 * 
	 * @Test public void guestUserDifferentManualAddress() throws IOException,
	 * JSONException, InterruptedException {
	 * 
	 * //burrow.launch(driver, appURL); burrow.addToBoxLoveseat(driver);
	 * burrow.checkout(driver); burrow.guestUser(driver);
	 * burrow.shippingDetails(driver); burrow.shippingAddressManual(driver);
	 * burrow.cardDetails(driver); burrow.BillingDetails(driver);
	 * burrow.BillingAddressManual(driver); burrow.placeOrder(driver);
	 * burrow.orderAfterPlaced(driver); }
	 * 
	 * //TS_010
	 * 
	 * @Test public void guestUserShippingGoogleManualAddress() throws IOException,
	 * JSONException, InterruptedException {
	 * 
	 * //burrow.launch(driver, appURL); burrow.addToBoxLoveseat(driver);
	 * burrow.checkout(driver); burrow.guestUser(driver);
	 * burrow.shippingDetails(driver);
	 * burrow.shippingAddressBothGoogleManual(driver); burrow.cardDetails(driver);
	 * burrow.BillingDetails(driver); burrow.BillingAddressManual(driver);
	 * burrow.placeOrder(driver); burrow.orderAfterPlaced(driver); }
	 * 
	 * //TS_011
	 * 
	 * @Test public void guestUserBillingGoogleManualAddress() throws IOException,
	 * JSONException, InterruptedException {
	 * 
	 * //burrow.launch(driver, appURL); burrow.addToBoxLoveseat(driver);
	 * burrow.checkout(driver); burrow.guestUser(driver);
	 * burrow.shippingDetails(driver); burrow.shippingAddressGoogle(driver);
	 * burrow.cardDetails(driver); burrow.BillingDetails(driver);
	 * burrow.BillingAddressBothGoogleManual(driver); burrow.placeOrder(driver);
	 * burrow.orderAfterPlaced(driver); }
	 * 
	 * //TS_012
	 * 
	 * @Test public void guestUserShippingBillingBothGoogleManualAddress() throws
	 * IOException, JSONException, InterruptedException {
	 * 
	 * //burrow.launch(driver, appURL); burrow.addToBoxLoveseat(driver);
	 * burrow.checkout(driver); burrow.guestUser(driver);
	 * burrow.shippingDetails(driver);
	 * burrow.shippingAddressBothGoogleManual(driver); burrow.cardDetails(driver);
	 * burrow.BillingDetails(driver); burrow.BillingAddressBothGoogleManual(driver);
	 * burrow.placeOrder(driver); burrow.orderAfterPlaced(driver); }
	 * 
	 * //TS_013
	 * 
	 * @Test public void registeredUser() throws IOException, JSONException,
	 * InterruptedException {
	 * 
	 * //burrow.launch(driver, appURL); burrow.addToBoxLoveseat(driver);
	 * burrow.checkout(driver); burrow.registeredUser(driver);
	 * burrow.shippingAddressManualAndSameBilling(driver);
	 * burrow.placeOrder(driver); burrow.orderAfterPlaced(driver);
	 * 
	 * }
	 */
		
		
	@AfterTest
	public void teardown() throws Exception {
		driver.close();

	}
	

	

}
