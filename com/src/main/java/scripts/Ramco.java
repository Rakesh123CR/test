package scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.openqa.selenium.support.FindBy;

import commonMethods.Keywords;
import commonMethods.OR;
import commonMethods.Utils;

public class Ramco extends Keywords {

	String dataUserName = Utils.getDataFromTestData("Login", "UserName");
	String dataPassword = Utils.getDataFromTestData("Login", "Password");
	String entercode = Utils.getDataFromTestData("Login", "Purchasecode");
	String wrongcustomer = Utils.getDataFromTestData("Login","WrongPurchasecode");
	String wrongrefno = Utils.getDataFromTestData("Goods","WrongRefno");
	String suppliercode = Utils.getDataFromTestData("Login", "Suppliercode");
	String CBPO = Utils.getDataFromTestData("Login", "NumType");
	String Part1name = Utils.getDataFromTestData("Login", "Part1");
	String Part2name = Utils.getDataFromTestData("Login", "Part2");
	String dataQuantity = Utils.getDataFromTestData("Login", "Quantity");
	String dataCOST = Utils.getDataFromTestData("Login", "Cost");
	String dataCostPerWindow = Utils.getDataFromTestData("Login", "Costper");
	String UOM = Utils.getDataFromTestData("Login", "UOM");
	String earliestdate = Utils.getDataFromTestData("Login", "Earliestdate");
	String inspection = Utils.getDataFromTestData("Login", "Inspection");
	String shipto = Utils.getDataFromTestData("Login", "Shipto");
	String tolerance = Utils.getDataFromTestData("Login", "Tolerance");
	String warehouse = Utils.getDataFromTestData("Login", "Warehouse");
	String Part2 = Utils.getDataFromTestData("Login", "Part2");
	String New = Utils.getDataFromTestData("Login", "New");
	String q2 = Utils.getDataFromTestData("Goods", "q2");
	String q1 = Utils.getDataFromTestData("Goods", "q1");
	String duty = Utils.getDataFromTestData("Goods", "duty");
	String Receivedserial = Utils.getDataFromTestData("Goods", "Receivedserial");
	String Receivedcondition = Utils.getDataFromTestData("Goods", "Receivedcondition");
	String Certificate = Utils.getDataFromTestData("Goods", "Certificate");
	String Certificate2 = Utils.getDataFromTestData("Goods", "Certificate2");
	String Certdate = Utils.getDataFromTestData("Goods", "Certdate");
	String Manfdate = Utils.getDataFromTestData("Goods", "Manfdate");
	String invoiceno = Utils.getDataFromTestData("Goods", "Invoiceno");
	String Package1 = Utils.getDataFromTestData("Resumption", "Package");
	String workcenter = Utils.getDataFromTestData("Resumption", "workcenter");
	String contractno = Utils.getDataFromTestData("Resumption", "contractno");
	String ATA = Utils.getDataFromTestData("Resumption", "ATA");
	String Description1 = Utils.getDataFromTestData("Resumption", "Description1");
	String yim = Utils.getDataFromTestData("Resumption", "yim");
	String Resource3 = Utils.getDataFromTestData("Resumption", "Resource");
	String Resource2 = Utils.getDataFromTestData("Resumption", "Resource2");
	String fromdate = Utils.getDataFromTestData("Resumption", "fromdate");
	String fromtime = Utils.getDataFromTestData("Resumption", "fromtime");
	String todate = Utils.getDataFromTestData("Resumption", "todate");
	String totime = Utils.getDataFromTestData("Resumption", "totime");
	String parthub = Utils.getDataFromTestData("Resumption", "Part#");
	String invamount = Utils.getDataFromTestData("Goods","InvoiceAmount");
	String part3 = Utils.getDataFromTestData("Resumption","part2");
	String disdesc1 = Utils.getDataFromTestData("Resumption","issuedesc1");
	String disdesc2 = Utils.getDataFromTestData("Resumption","issuedesc2");
	
	// String Package = Utils.getDataFromTestData("Resumption", "Manfdate");

	// String q2 = Utils.getDataFromTestData("Goods", "q2");

	public static String Verify;
	public String receiptstatus;
	public String receiptstatus1;
	public String receiptstatus2;
	public static String taskname;
	public static String vp;
	public static String log1;
	public static String log2;
	public static String serialstatus;
	public static String suppliertotal;

	public void login(WebDriver driver, String URL) throws InterruptedException {

		navigateUrl(driver, URL);
		// get(driver,);
		maximize(driver);
		wait(driver, "5");
		waitForElement(driver, userName);
		sendKeys(driver, userName, dataUserName);
		waitForElement(driver, password);
		sendKeys(driver, password, dataPassword);
		wait(driver, "3");
		click(driver, signin);
	}

	public void createorder(WebDriver driver) throws InterruptedException, AWTException {

		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		 //driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		wait(driver, "15");
		//waitForElement(driver, OR.Mainmenu);
		waitTillElementIsClickable(driver, Mainmenu);
		wait(driver, "1");
		actionClick(driver, Mainmenu);
		wait(driver, "3");
		//waitTillElementIsClickable(driver, scroller);
		//wait(driver, "1");
		//actionClick(driver, OR.scroller);
		waitTillElementIsClickable(driver, scroller2);
		for (int i = 0; i <= 7; i++) {
			
			elementClick(driver, OR.scroller2);
		}

		wait(driver, "2");
		waitTillElementIsClickable(driver, OR.procurement);
		actionClick(driver, OR.procurement);
		wait(driver, "3");
		waitTillElementIsClickable(driver, OR.purchaseorder);

		actionClick(driver, OR.purchaseorder);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		Robot r1 = new Robot();
		
		actionClick(driver,OR.Createpurchase);
		Thread.sleep(5000);
		sendKeys(driver, OR.Entercode,wrongcustomer);
		Thread.sleep(8000);
		wait(driver, "2");
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		wait(driver, "2");
		waitForElement(driver, OR.errormsg1);
		wait(driver, "2");
		elementDisplayed(driver, errormsg1);
		getTextWithoutFail(driver, errormsg1);
		wait(driver, "1");
		waitForElement(driver, OR.okbutton);
		click(driver, OR.okbutton);
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_BACK_SPACE);
		r1.keyRelease(KeyEvent.VK_BACK_SPACE);
		
		actionClick(driver, OR.Createpurchase);
		sendKeys(driver, OR.Entercode, entercode);
		// driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		wait(driver, "2");
		r1.keyPress(KeyEvent.VK_UP);
		r1.keyRelease(KeyEvent.VK_UP);
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		waitForElement(driver,OR.currency);
		elementClick(driver,OR.currency);
		Thread.sleep(1000);
		elementClick(driver,OR.cad);

		/*
		 * driver.findElement(By.xpath("//input[@name='txtsupcode']")).sendKeys(Keys.
		 * ARROW_UP);
		 * driver.findElement(By.xpath("//input[@name='txtsupcode']")).sendKeys(Keys.
		 * ENTER);
		 */
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);

		// driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Thread.sleep(3000);

		actionType(driver, OR.Suppliercode, suppliercode);
		Thread.sleep(1000);

		actionClick(driver, OR.Go);
		
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Thread.sleep(3000);

		// waitTillElementIsClickable(driver,OR.Numdropdown);
		// waituntilElementclickable(pm.getCreatePurchase().getNumdropdown());
		// waitTillElementIsClickable(driver, OR.enternum);
		// combobox(driver,OR.enternum,CBPO);

		verifyElementIsPresent(driver, OR.Numdropdown);
		elementClick(driver, OR.Numdropdown);
		Thread.sleep(1000);
		elementClick(driver, OR.CBPO);

		/*
		 * verifyElementIsPresent(driver, OR.enternum); sendKeys(driver,
		 * OR.enternum,CBPO); r1.keyPress(KeyEvent.VK_ENTER);
		 * r1.keyRelease(KeyEvent.VK_ENTER);
		 */
		Thread.sleep(1000);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		// waitTillElementIsClickable(driver,OR.Quantity);
		// actionClick(driver,OR.Quantity);
		waitTillElementIsClickable(driver, OR.Partname);

		actionType1(driver, OR.Partname, Part1name);
		// getWindow(driver,OR.PartDescription);
		parentwindow(driver, PartDescription);
		click(driver, PartDescription);
		// scrollBottom(driver);

		
		  click(driver, one);
		  wait(driver, "2"); 
		  actionType1(driver, OR.uomwindow,UOM); 
		  wait(driver, "2"); 
		  actionType1(driver, OR.qtywindow, dataQuantity);
		  
		  wait(driver, "2");
		  actionType1(driver, OR.costWindow,dataCOST);
		  waitForElement(driver, costWindow);
		  actionType1(driver, costPerWindow, dataCostPerWindow);
		  waitForElement(driver, costPerWindow);
		  actionType1(driver, inspectionWindow, inspection);
		  waitForElement(driver, inspectionWindow); 
		  actionType1(driver, shipToWindow, shipto);
		  waitForElement(driver, shipToWindow);
		  actionType1(driver, toleranceWindow, tolerance); 
		  waitForElement(driver, toleranceWindow);
		  String date =getCurrentDate1();
		  wait(driver, "2");
		  waitForElement(driver, earliestWindow);
		  actionType1(driver,earliestWindow,date);
		  System.out.println(date);
		  waitForElement(driver, warehouseWindow);
		  actionType1(driver, warehouseWindow, warehouse); 
		  waitForElement(driver,close); 
		  click(driver, close);
		  wait(driver, "2");
		  for (int i = 0; i <= 20; i++) {
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
		  
		  WebElement element =driver.findElement(By.xpath("//div[text()='Earliest Due Date']"));
			  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
		
		  waitForElement(driver,scrolltable);
		  actionClick(driver,scrolltable);
		  
		  wait(driver, "1");
		  for (int i = 0; i <= 10; i++) {
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
			}
		  WebElement element3 =driver.findElement(By.xpath("//div[text()='Warehouse #']"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()",element3);
		  
	 
	     WebElement element1 =driver.findElement(By.xpath("//div[text()='Inspection Type']"));
	     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element1);
		  
	     WebElement element2 = driver.findElement(By.xpath("//div[text()='Ship To']"));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element2);
		 
		 WebElement element6 =driver.findElement(By.xpath("//div[text()='Tolerance Type']"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element6);
		 
		  wait(driver, "1");
		  for (int i = 0; i <= 10; i++) {
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
			}
		/*
		 * String date =getCurrentDate()+"PM"; System.out.println(date);
		 * actionType1(driver,earliestWindow, date);
		 */
		
		/*
		 * waitTillElementIsClickable(driver,OR.Orderqtylabel); wait(driver,"2");
		 * actionClick(driver,OR.Orderqtylabel); Thread.sleep(1000);
		 * //movetoElement(driver, OR.Quantity); wait(driver,"2");
		 * //actionClick(driver,OR.Quantity);
		 * actionType1(driver,OR.Quantity,dataQuantity);
		 * 
		 * 
		 * 
		 * // // actionClick(driver,OR.Quantity); // verifyElementIsPresent(driver,
		 * Quantity); // switchDefaultContent(driver);
		 * 
		 * // actionType1(driver,OR.Quantity,dataQuantity); // wait(driver,"5");
		 * 
		 * 
		 * waitTillElementIsClickable(driver,OR.UOMlabel); wait(driver,"1");
		 * actionClick(driver,OR.UOMlabel); Thread.sleep(1000); //
		 * actionClick(driver,OR.UOM); actionType1(driver,OR.UOM,UOM);
		 * 
		 * 
		 * waitTillElementIsClickable(driver,OR.Costlabel); wait(driver,"1");
		 * actionClick(driver,OR.Costlabel); Thread.sleep(1000); // actionClick(driver,
		 * OR.Cost); actionType1(driver,OR.Cost,dataQuantity);
		 * 
		 * for (int i = 0; i <= 20; i++) {
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN); }
		 * 
		 * for (int i = 0; i <= 10; i++) {
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT); }
		 * 
		 * 
		 * 
		 * waitTillElementIsClickable(driver,OR.Costperlabel); wait(driver,"1");
		 * actionClick(driver,OR.Costperlabel); Thread.sleep(1000);
		 * 
		 * // actionClick(driver,OR.Costper);
		 * actionType1(driver,OR.Costper,dataCostPerWindow);
		 * 
		 * for (int i = 0; i <= 10; i++) {
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT); }
		 * 
		 * WebElement element
		 * =driver.findElement(By.xpath("//div[text()='Earliest Due Date']"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView();",element);
		 * Thread.sleep(1000); waitTillElementIsClickable(driver,OR.earliestlabel);
		 * wait(driver,"1"); actionClick(driver,OR.earliestlabel); Thread.sleep(1000);
		 * actionClick(driver,OR.earliestduedate);
		 * actionType1(driver,OR.earliestduedate,earliestdate);
		 * 
		 * for (int i = 0; i <= 15; i++) {
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT); }
		 * WebElement element3
		 * =driver.findElement(By.xpath("//div[text()='Warehouse #']"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView();",element3);
		 * 
		 * waitTillElementIsClickable(driver,OR.warehouselabel); wait(driver,"1");
		 * actionClick(driver,OR.warehouselabel); Thread.sleep(1000); //
		 * actionClick(driver,OR.warehouse);
		 * 
		 * actionType1(driver,OR.warehouse,warehouse);
		 * 
		 * for (int i = 0; i <= 20; i++) {
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT); }
		 * WebElement element1
		 * =driver.findElement(By.xpath("//div[text()='Inspection Type']"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView();",element1);
		 * 
		 * // for (int i = 0; i <=30; i++) {
		 * //pm.getPartdetails().getScrolldown().sendKeys(Keys.ARROW_RIGHT); // }
		 * 
		 * 
		 * waitTillElementIsClickable(driver,OR.Inspectionlabel); wait(driver,"1");
		 * actionClick(driver,OR.Inspectionlabel); Thread.sleep(1000);
		 * //actionClick(driver, Inspection);
		 * actionType1(driver,OR.Inspection,inspection);
		 * 
		 * 
		 * 
		 * //for (int i = 0; i <= 25; i++) { // for (int i = 0; i <= 20; i++) {
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT); }
		 * 
		 * 
		 * WebElement element2 =
		 * driver.findElement(By.xpath("//div[text()='Ship To']"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView();",element2);
		 * 
		 * waitTillElementIsClickable(driver,OR.Shiptolabel); wait(driver,"1");
		 * actionClick(driver,OR.Shiptolabel); Thread.sleep(1000); //actionClick(driver,
		 * Shipto); actionType1(driver,OR.Shipto,shipto); //for (int i = 0; i <= 25;
		 * i++) { //pm.getPartdetails().getScrolldown().sendKeys(Keys.ARROW_RIGHT); }
		 * 
		 * WebElement element6
		 * =driver.findElement(By.xpath("//div[text()='Tolerance Type']"));
		 * ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
		 * element6);
		 * 
		 * waitTillElementIsClickable(driver,OR.Tolerancelabel); wait(driver,"1");
		 * actionClick(driver,OR.Tolerancelabel); Thread.sleep(1000);
		 * //actionClick(driver, Tolerance); actionType1(driver,OR.Tolerance,tolerance);
		 */
		 
		waitForElement(driver, OR.Checkbox);
		wait(driver, "2");
		click(driver, Checkbox);
		waitForElement(driver, createPurchaseButton);
		wait(driver, "2");
		click(driver, createPurchaseButton);
		wait(driver, "5");
		Thread.sleep(15000);
		waitForElement(driver, OR.SuccessMessage);
		wait(driver, "2");
		getTextWithoutFail(driver, SuccessMessage);
		wait(driver, "1");
		waitForElement(driver, OR.okbutton);
		click(driver, OR.okbutton);
		wait(driver, "2");
		r1.keyPress(KeyEvent.VK_HOME);
		r1.keyRelease(KeyEvent.VK_HOME);

		// waitForElement(driver, Status);
		// getText(driver, OR.Status);

		waitForElement(driver, OR.Purchaseid);
		wait(driver, "2");
		Verify = getTextWithoutFail(driver, Purchaseid);
	}

		/*
		 * wait(driver,"3");
		 * Verify=driver.findElement(By.xpath("(//span[@role='textbox'])[1]")).getText()
		 * ; System.out.println(Verify);
		 */

		
		
		
		
		
		
		
		

		
		
	public void editorder(WebDriver driver) throws InterruptedException, AWTException {

		scrollUsingElement(driver, OR.Purchaseedit);
		wait(driver, "2");
		// waitForElement(driver, Purchaseedit);

		elementClick(driver, OR.Purchaseedit);
		Robot r1 = new Robot();
		wait(driver, "2");
		waitForElement(driver, Purchaseeditdropbutton);
		// scrollUsingElement(driver,OR.Purchaseeditdropbutton);
		elementClick(driver, OR.Purchaseeditdropbutton);
		wait(driver, "2");
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		elementClick(driver, Sendid);
		actionType1(driver, Sendid, Ramco.Verify);
		wait(driver, "2");
		click(driver, OR.editpurchasebutton);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		
		waitTillElementIsClickable(driver, OR.Partname3);

		actionType1(driver, OR.Partname3, Part2name);
		// getWindow(driver,OR.PartDescription);
		parentwindow(driver, PartDescription);
		click(driver, PartDescription);

		click(driver, two);
		wait(driver, "2");
		//actionType1(driver, OR.Partnam, Part2);
		//wait(driver, "2");
		actionType1(driver, OR.uomwindow, UOM);
		wait(driver, "2");
		actionType1(driver, OR.qtywindow, dataQuantity);

		wait(driver, "2");
		actionType1(driver, OR.costWindow, dataCOST);
		wait(driver, "2");
		actionType1(driver, OR.New, New);
		waitForElement(driver, costWindow);
		actionType1(driver, costPerWindow, dataCostPerWindow);
		waitForElement(driver, costPerWindow);
		actionType1(driver, inspectionWindow, inspection);
		waitForElement(driver, inspectionWindow);
		 String date2=getCurrentDate1();
		  wait(driver, "2");
		  waitForElement(driver, earliestWindow);
		  actionType1(driver,earliestWindow,date2);
		  System.out.println(date2);
		//actionType1(driver, earliestWindow, earliestdate);
		waitForElement(driver, warehouseWindow);
		actionType1(driver, warehouseWindow, warehouse);
		waitForElement(driver, close1);
		click(driver, close1);
		wait(driver, "2");
		 for (int i = 0; i <= 5; i++) {
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
		  WebElement element =driver.findElement(By.xpath("//div[text()='Earliest Due Date']"));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
	
	  waitForElement(driver,scrolltable);
	  actionClick(driver,scrolltable);
	  
	  wait(driver, "1");
	  for (int i = 0; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
		}
	  WebElement element3 =driver.findElement(By.xpath("//div[text()='Warehouse #']"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()",element3);
	  
 
    WebElement element1 =driver.findElement(By.xpath("//div[text()='Inspection Type']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element1);
	  
     WebElement element2 = driver.findElement(By.xpath("//div[text()='Ship To']"));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element2);
	 
	 WebElement element6 =driver.findElement(By.xpath("//div[text()='Tolerance Type']"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element6);
	 

		actionClick(driver, EditCheckbox);
		wait(driver, "2");
		elementClick(driver, Finaleditbutton);
		wait(driver, "5");
		waitForElement(driver, OR.SuccessMessage);
		wait(driver, "2");
		getTextWithoutFail(driver, SuccessMessage);
		wait(driver, "1");
		waitForElement(driver, OR.okbutton);
		click(driver, OR.okbutton);
		wait(driver, "1");
		waitForElement(driver, OR.Edittermscondition);
		elementClick(driver, Edittermscondition);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		r1.keyPress(KeyEvent.VK_END);
		r1.keyRelease(KeyEvent.VK_END);
		wait(driver, "1");
		waitForElement(driver, OR.Edittermscondition1);
		elementClick(driver, Edittermscondition1);
		wait(driver, "1");
		waitForElement(driver, OR.okbutton);
		click(driver, OR.okbutton);
		wait(driver, "1");
		waitForElement(driver, OR.Purchaseedit);
		elementClick(driver, OR.Purchaseedit);
		wait(driver, "2");
	}
	
	public void authorizeorder(WebDriver driver) throws InterruptedException, AWTException {
		wait(driver, "2");
		elementClick(driver, AuthorizeDropdown);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		waitForElement(driver, verifyauthorizeid);
		elementClick(driver, verifyauthorizeid);
		Thread.sleep(2000);
		actionType1(driver, verifyauthorizeid, Ramco.Verify);
		Thread.sleep(2000);
		elementClick(driver, OR.search);

		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		waitForElement(driver, Authorizecheckbox);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		elementClick(driver, Authorizecheckbox);

		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		actionClick(driver, AuthorizeButton);

		Thread.sleep(2000);
		waitForElement(driver, OR.SuccessMessage);
		wait(driver, "2");
		getTextWithoutFail(driver, SuccessMessage);
		wait(driver, "1");
		waitForElement(driver, OR.okbutton);
		click(driver, OR.okbutton);
	}
	
	public void goodsinward(WebDriver driver) throws InterruptedException, AWTException {
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		wait(driver, "5");
		waitTillElementIsClickable(driver, Mainmenu);
		actionClick(driver, Mainmenu);
		wait(driver, "2");
		Robot r1 = new Robot();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// Thread.sleep(4000);
		actionClick(driver, OR.stock);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		actionClick(driver, OR.goods);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		actionClick(driver, OR.datareceipt);

		driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		waitForElement(driver, datarefno);
		elementClick(driver, datarefno);
		Thread.sleep(5000);
		sendKeys(driver, datarefno,wrongrefno);
		Thread.sleep(3000);
		elementClick(driver, go);
		waitForElement(driver, OR.errormsg);
		wait(driver, "2");
		getTextWithoutFail(driver, errormsg);
		wait(driver, "1");
		waitForElement(driver, OR.cancel);
		wait(driver, "1");
		click(driver, OR.cancel);
		elementClick(driver, datarefno);
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_BACK_SPACE);
		r1.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(5000);

		waitForElement(driver, datarefno);
		elementClick(driver, datarefno);
		Thread.sleep(4000);
		actionType1(driver, datarefno, Ramco.Verify);
		Thread.sleep(2000);
		elementClick(driver, go);
		Thread.sleep(8000);
		driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.SECONDS);
		Thread.sleep(19000);

		// driver.findElement(By.xpath("(//*[@data-recordindex='0']/tbody/tr/td[5]/div)[1]")).sendKeys("1");
		waitTillElementIsClickable(driver, goodsone);
		waitForElement(driver, goodsone);
		click(driver, goodsone);
		wait(driver, "2");
		actionType1(driver, OR.goodsqtywindow, q2);
		wait(driver, "2");
		click(driver, OR.goodsdutywindow);
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_BACK_SPACE);
		r1.keyRelease(KeyEvent.VK_BACK_SPACE);
		actionType1(driver, OR.goodsdutywindow, duty);
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);

		// waitForElement(driver,OR.overridetrigger);
		// mouseOverAndClick(driver,overridetrigger);
		// elementClick(driver,override);
		// clear(driver,OR.goodsdutywindow);
		// clearAndType1(driver,OR.goodsdutywindow,duty);
		//
		waitForElement(driver, goodsclose);
		click(driver, goodsclose);
		wait(driver, "2");
		waitForElement(driver, goodstwo);
		click(driver, goodstwo);
		wait(driver, "2");
		actionType1(driver, OR.goodsqtywindow, q1);
		wait(driver, "2");
		click(driver, OR.goodsdutywindow);
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_BACK_SPACE);
		r1.keyRelease(KeyEvent.VK_BACK_SPACE);
		actionType1(driver, OR.goodsdutywindow, duty);
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);

		// waitForElement(driver,OR.overridetrigger);
		// mouseOverAndClick(driver,overridetrigger);
		// elementClick(driver,override);
		// clear(driver,OR.goodsdutywindow);
		// clearAndType1(driver,OR.goodsdutywindow,duty);
		// actionType1(driver,OR.goodsdutywindow,duty);
		waitForElement(driver, goodsclose);
		click(driver, goodsclose);
		wait(driver, "2");

		/*
		 * Robot r2 = new Robot(); waitForElement(driver,qtylabel);
		 * actionClick(driver,qtylabel); Thread.sleep(5000);
		 * actionType1(driver,qtyreceipt,q2);
		 * 
		 * r1.keyPress(KeyEvent.VK_ENTER); r1.keyRelease(KeyEvent.VK_ENTER);
		 * 
		 * waitForElement(driver,dutylabel); actionClick(driver,dutylabel);
		 * Thread.sleep(5000); actionType1(driver,duty1,duty);
		 * r1.keyPress(KeyEvent.VK_ENTER); r1.keyRelease(KeyEvent.VK_ENTER);
		 * Thread.sleep(4000); actionType1(driver,qtyreceipt2,q1);
		 * r1.keyPress(KeyEvent.VK_ENTER); r1.keyRelease(KeyEvent.VK_ENTER);
		 * Thread.sleep(4000); actionType1(driver,duty2,duty);
		 */
		actionClick(driver, checkreceipt);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}

		actionClick(driver, recordbutton);
		Thread.sleep(8000);

		Thread.sleep(7000);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		wait(driver, "1");
		waitForElement(driver, OR.okbutton);
		click(driver, OR.okbutton);
	}
	
	
	public void confirmreceipt(WebDriver driver) throws InterruptedException, AWTException {
		wait(driver, "8");
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		actionClick(driver, seriallot);
		Thread.sleep(2000);
		/*
		 * click(driver,OR.serialwindowone); wait(driver,"2");
		 * actionType1(driver,OR.serialwindowreceived,Receivedserial); wait(driver,"2");
		 * actionType1(driver,OR.serialwindowcondition,Receivedcondition);
		 * r1.keyPress(KeyEvent.VK_ENTER); r1.keyRelease(KeyEvent.VK_ENTER);
		 * wait(driver,"2"); actionType1(driver,OR.serialwindowcerttype,Certificate);
		 * r1.keyPress(KeyEvent.VK_ENTER); r1.keyRelease(KeyEvent.VK_ENTER);
		 * wait(driver,"2"); actionType1(driver,OR.serialwindowcertno,Certificate2);
		 * wait(driver,"2"); actionType1(driver,OR.serialwindowcertdate,Certdate);
		 * wait(driver,"2"); actionType1(driver, serialwindowmfrdate,Manfdate);
		 * waitForElement(driver,close1); click(driver, close1); wait(driver,"2");
		 */

		wait(driver, "3");
		waitForElement(driver, receivedseriallabel);
		actionClick(driver, receivedseriallabel);
		wait(driver, "4");
		actionType1(driver, receivedserial, Receivedserial);
		wait(driver, "2");
		waitForElement(driver, receivedconditionlabel);
		wait(driver, "4");
		WebElement element9 = driver.findElement(By.xpath("//div[text()='Received Condition']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element9);
		//waitForElement(driver, receivedconditionlabel);
		actionClick(driver, receivedconditionlabel);
		wait(driver, "4");
		waitForElement(driver, receivedcondition);
		wait(driver, "4");
        click(driver, receivedcondition);
        wait(driver, "4");
		actionType1(driver, receivedcondition,Receivedcondition);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
		}
		wait(driver, "4");
		WebElement element8 = driver.findElement(By.xpath("//div[text()='Certificate Type']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element8);
		wait(driver, "4");
		waitForElement(driver, certtypelabel);
		wait(driver, "4");
		actionClick(driver, certtypelabel);
		wait(driver, "4");
		waitForElement(driver, certtype);
		click(driver, certtype);
		wait(driver, "4");
		actionType1(driver, certtype, Certificate);
		wait(driver, "4");
		WebElement element10 = driver.findElement(By.xpath("//div[text()='Certificate #']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element10);
		waitForElement(driver, certificatenolabel);
		actionClick(driver, certificatenolabel);
		Thread.sleep(2000);
		actionType1(driver, certificateno, Certificate2);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
		}
		wait(driver, "4");
		WebElement element11 = driver.findElement(By.xpath("//div[text()='Certificate Date']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element11);
		waitForElement(driver, certdatelabel);
		actionClick(driver, certdatelabel);
		Thread.sleep(3000);
		actionType1(driver, certdate, Certdate);

		wait(driver, "4");
		WebElement element12 = driver.findElement(By.xpath("//div[text()='Mfr. Date']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element12);
		waitForElement(driver, mfrlabel);
		actionClick(driver, mfrlabel);
		wait(driver, "4");
		actionType1(driver, mfrdate, Manfdate);

		receiptstatus = getText(driver, OR.receiptstatus);
		System.out.println("status=" + receiptstatus);

		Thread.sleep(3000);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		sendText11(driver, checkserial);
		Thread.sleep(2000);
		elementClick(driver, save);
		// Thread.sleep(8000);

		wait(driver, "8");
		waitForElement(driver, OR.okbutton);
		click(driver, OR.okbutton);

		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		Thread.sleep(4000);

		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		actionClick(driver, update);

		Thread.sleep(2000);

		sendText11(driver, checkserial);
		Thread.sleep(4000);

		actionClick(driver, confirm);
		Thread.sleep(90000);
		wait(driver,"30");
		wait(driver,"10");
		waitForElement(driver, OR.okbutton);
		click(driver, OR.okbutton);
		Thread.sleep(3000);

		for (int i = 0; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		elementDisplayed(driver, OR.receiptstatus);
		receiptstatus1 = getText(driver, OR.receiptstatus);
		System.out.println("status=" + receiptstatus1);
		wait(driver, "2");
		waitForElement(driver, OR.Purchaseedit);
		actionClick(driver, goodsinwardsmenu);
		wait(driver, "1");
		elementClick(driver, managegoods2);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		waitForElement(driver, datarefno);
		elementClick(driver, datarefno);
		Thread.sleep(2000);
		actionType1(driver, datarefno,Ramco.Verify);
		wait(driver, "1");
		elementClick(driver, OR.Go);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		wait(driver, "5");
		Thread.sleep(4000);
        waitForElement(driver, OR.receiptstatus);
		elementDisplayed(driver, OR.receiptstatus);
		receiptstatus2 = getTextWithoutFail(driver, OR.receiptstatus);
		System.out.println("status=" + receiptstatus2);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		wait(driver, "5");
	}
	
	
	public void supplierorder(WebDriver driver) throws InterruptedException, AWTException {
		
		waitTillElementIsClickable(driver, Mainmenu);
		actionClick(driver, Mainmenu);
		wait(driver, "3");
		waitTillElementIsClickable(driver, scroller2);
		for (int i = 0; i <= 15; i++) {
			
			elementClick(driver, OR.scroller2);
		}
		wait(driver, "2");
		waitTillElementIsClickable(driver, OR.payablemanagement);
		wait(driver, "2");
		actionClick(driver, OR.payablemanagement);
		wait(driver, "3");
		waitTillElementIsClickable(driver, OR.supplierorderinvoice);
		wait(driver, "2");
		actionClick(driver, OR.supplierorderinvoice);
		wait(driver, "3");
		waitTillElementIsClickable(driver, OR.maintaininvoice);
		actionClick(driver, OR.maintaininvoice);
		wait(driver, "3");
		waitForElement(driver, suppinvno);
		elementClick(driver, suppinvno);
		Thread.sleep(2000);
		actionType1(driver, OR.suppinvno, invoiceno);
		wait(driver, "1");
		 String date3=getCurrentDate1();
		  wait(driver, "2");
		  waitForElement(driver,OR.suppinvdate);
		  actionType1(driver,OR.suppinvdate,date3);
		  Robot r1 = new Robot();
		  System.out.println(date3);
		//actionType1(driver, OR.suppinvdate, earliestdate);
		//wait(driver, "3");
		
		waitTillElementIsClickable(driver, OR.supporder);
	//	elementClick(driver,supporder);
		Thread.sleep(2000);
		actionType1(driver, OR.supporder, Ramco.Verify);
		wait(driver, "1");
		Thread.sleep(3000);
		//waitTillElementIsClickable(driver, OR.suppcheckbox);
		actionClick(driver, OR.suppcheckbox);

		elementClick(driver, getdetails);
		
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		Thread.sleep(40000);
		
		/*
		 * verifyElementIsPresent(driver, OR.suppnumtrigger); elementClick(driver,
		 * OR.suppnumtrigger); Thread.sleep(1000); elementClick(driver, OR.sinv);
		 */
		for (int i = 0; i <= 5; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);
		}
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		waitForElement(driver,compute);
		waitTillElementIsClickable(driver, compute);
		elementClick(driver, compute);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		Thread.sleep(20000);
		
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		  wait(driver, "3");
		  waitForElement(driver,totalsuppamount);
			elementClick(driver, totalsuppamount);
		sendKeys(driver, totalsuppamount,invamount);
		
		Thread.sleep(5000);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		/*
		 * waitForElement(driver,totalreadamount); elementClick(driver,
		 * totalreadamount);
		 * 
		 * suppliertotal = getText(driver,totalreadamount);
		 * System.out.println(suppliertotal);
		 */
		
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		Thread.sleep(5000);
		  
		  
		 // scrollUsingElement(driver,totalsuppamount);
		

		/*
		 * for (int i = 0; i <= 10; i++) {
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN); }
		 */

		elementClick(driver, saveandauthorize);
		Thread.sleep(90000);
		Thread.sleep(50000);
		wait(driver, "10");
		waitForElement(driver, OR.okbutton);
		waitTillElementIsClickable(driver, okbutton);
		click(driver, OR.okbutton);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		Thread.sleep(5000);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		Thread.sleep(3000);
		 WebElement element3 =driver.findElement(By.xpath("//span[starts-with(@aria-labelledby,'dspstatus-ramcolabel-') and (@class='x-form-display-field x-form-display-field-default')]"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()",element3);
		waitForElement(driver,supplierorderstatus);
		elementDisplayed(driver, OR.supplierorderstatus);
		receiptstatus2 = getTextWithoutFail(driver, OR.supplierorderstatus);
		System.out.println("status=" + receiptstatus2);
		
		  actionClick(driver, usermenu); 
		  Thread.sleep(2000); 
		  actionClick(driver,signout);

	}

	
	
	

	public void aircraft(WebDriver driver) throws InterruptedException, AWTException {

		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		wait(driver, "8");
		waitForElement(driver, Mainmenu);
		actionClick(driver, Mainmenu);
		wait(driver, "2");

		waitForElement(driver, AircraftShopWork);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		actionClick(driver, AircraftShopWork);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		actionClick(driver, ExecutionHub);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		actionClick(driver, workreporting);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		Robot r11 = new Robot();

		elementClick(driver, creatework);
		// waitForElement(driver,Package);
		// doubleClick(driver,Package);
		wait(driver, "3");
		actionClick(driver, label);
		actionType1(driver, Package, Package1);

		r11.keyPress(KeyEvent.VK_ENTER);
		r11.keyRelease(KeyEvent.VK_ENTER);

		actionType1(driver, OR.yim, yim);

		actionClick(driver, itemgo);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		// doubleClick(driver,OR.workcenter);
		wait(driver, "3");
		click(driver, OR.workcenter);
		wait(driver, "3");
		r11.keyPress(KeyEvent.VK_DOWN);
		r11.keyRelease(KeyEvent.VK_DOWN);
		r11.keyPress(KeyEvent.VK_UP);
		r11.keyRelease(KeyEvent.VK_UP);
		r11.keyPress(KeyEvent.VK_ENTER);
		r11.keyRelease(KeyEvent.VK_ENTER);
		// keyboardArrowDown(driver);
		// keyboardArrowUp(driver);
		// keyboardArrowUp(driver);
		// enter(driver);
		// combobox(driver,OR.workcenter,workcenter);
		/*
		 * r11.keyPress(KeyEvent.VK_ENTER); r11.keyRelease(KeyEvent.VK_ENTER);
		 */

		actionType1(driver, OR.contractnumber, contractno);

		waitTillElementIsClickable(driver, createpackbutton);
		actionClick(driver, createpackbutton);

		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		// driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.SECONDS);
		 Thread.sleep(15000);
		//Thread.sleep(40000);
		actionClick(driver, atalabel);
		sendText11(driver, ata1);
		Thread.sleep(3000);
		actionType1(driver, ata1, ATA);
		Thread.sleep(3000);
		actionType1(driver, desc, Description1);
		
		//actionClick(driver, atalabel);
		sendText11(driver, ata2);
		Thread.sleep(3000);
		actionType1(driver, ata2, ATA);
		Thread.sleep(3000);
		actionType1(driver, desc2, Description1);

		/*
		 * elementClickusingActions(pm.getAircraftreporting().getAtalabel());
		 * sendText11(pm.getAircraftreporting().getAta2());
		 * elementinputValuesusingActions4(pm.getAircraftreporting().getAta2(),
		 * Datadriven.getConfigDatas("ATA"));
		 * elementinputValuesusingActions4(pm.getAircraftreporting().getDescription2(),
		 * "test2");
		 */
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		for (int i = 0; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		waitForElement(driver, checktask);
		Thread.sleep(3000);
		actionClick(driver, checktask);

		// elementClickusingActions(pm.getAircraftreporting().getCheck2());
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);

		// Thread.sleep(3000);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}

		elementClick(driver, OR.save);

		driver.manage().timeouts().pageLoadTimeout(80000, TimeUnit.SECONDS);
		Thread.sleep(90000);
		wait(driver, "3");
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}

		waitForElement(driver, OR.vpno);
		wait(driver, "2");
		vp = getText(driver, vpno);

		/*
		 * getText(driver,vpno); System.out.println("id=" + vp);
		 */
		waitForElement(driver, OR.taskname);
		wait(driver, "2");
		taskname = getText(driver, OR.taskname);
		/*
		 * taskname =getText(driver,OR.taskname); System.out.println("id=" + taskname);
		 */

		waitTillElementIsClickable(driver, Mainmenu);
		actionClick(driver, Mainmenu);
		wait(driver, "5");
		// driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);

		// Thread.sleep(3000);

		waitTillElementIsClickable(driver, AircraftWorkManagement2);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		actionClick(driver, AircraftWorkManagement2);

		// waituntilElementclickable(pm.getreporting().getWorkMonitoringandControl());
		Thread.sleep(3000);
		actionClick(driver, workmonitoring);
		// driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);

		Thread.sleep(3000);
		// waituntilElementclickable(pm.getreporting().getReviewWorkExecution());
		// driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		actionClick(driver, actualsmenu);

		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		sendKeys(driver, vpnofield, vp);
		System.out.println("id=" + vp);

		// Thread.sleep(3000);
		r11.keyPress(KeyEvent.VK_ENTER);
		r11.keyRelease(KeyEvent.VK_ENTER);
		// driver.findElement(By.xpath("//input[@name='txtwerarefdocnc' and
		// @class='x-form-field x-form-text x-form-text-default x-form-empty-field
		// x-form-empty-field-default']")).sendKeys(Keys.ENTER);
		// elementinputValuesusingActions43(pm.getreporting().getRefdoc(),vp);

		// elementClickusingActions(pm.getreporting().getRefsearch());

		Thread.sleep(1000);
		actionClick(driver, Resourceactual);

		sendKeys(driver, OR.taskfield, taskname);
		elementClick(driver, search1);

		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);

		waitTillElementIsClickable(driver, tab1);
		// driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		actionType1(driver, tab1, Resource3);

		/*
		 * waituntilElementclickable(pm.getreporting().getResourceTypelabel());
		 * elementClickusingActions(pm.getreporting().getResourceTypelabel());
		 * driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
		 * elementinputValuesusingActions4(pm.getreporting().getSkill1(),
		 * Datadriven.getConfigDatas("Resourcetype"));
		 * 
		 * for (int i = 0; i <= 5; i++) {
		 * pm.getPartdetails().getScrolldown().sendKeys(Keys.ARROW_RIGHT); }
		 */
		waitForElement(driver, fromdatelabel);
		actionClick(driver, fromdatelabel);
		Thread.sleep(2000);
		actionType1(driver, OR.fromdate, fromdate);

		waitForElement(driver, fromtimelabel);
		actionClick(driver, fromtimelabel);
		Thread.sleep(2000);
		actionType1(driver, OR.fromtime, fromtime);

		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
		}

		waitForElement(driver, todatelabel);
		actionClick(driver, todatelabel);
		Thread.sleep(2000);
		actionType1(driver, OR.todate, todate);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
		}
		waitForElement(driver, tottimelabel);
		actionClick(driver, tottimelabel);
		Thread.sleep(2000);
		actionType1(driver, OR.totime, totime);

		// driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
		Thread.sleep(3000);
		sendText11(driver, resourcecheckbox);

		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}

		elementClick(driver, reportestimates);

		wait(driver, "5");
		waitForElement(driver, OR.SuccessMessage);
		wait(driver, "2");
		getTextWithoutFail(driver, SuccessMessage);
		wait(driver, "1");
		waitForElement(driver, OR.okbutton);
		click(driver, OR.okbutton);
		wait(driver, "2");

		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		wait(driver, "5");
		waitTillElementIsClickable(driver, Mainmenu);
		actionClick(driver, Mainmenu);
		wait(driver, "2");

		waitTillElementIsClickable(driver, AircraftShopWork);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		actionClick(driver, AircraftShopWork);
		wait(driver, "2");
		actionClick(driver, ExecutionHub);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		wait(driver, "2");
		actionClick(driver, workreporting);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		wait(driver, "2");
		elementClick(driver,OR.edityim);
		wait(driver, "2");
	    actionType1(driver,OR.edityim, Ramco.vp);
	    wait(driver, "2");
		actionClick(driver,go1);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		Thread.sleep(3000);
		 wait(driver, "2");
		 waitTillElementIsClickable(driver, exclamatory);
		actionClick(driver,exclamatory);
		Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		wait(driver, "2");
        waitTillElementIsClickable(driver,OR.checktaskbox);
        wait(driver, "2");
        actionClick(driver, checktaskbox);
        wait(driver, "2");
        elementClick(driver,OR.requestpart);
        driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		wait(driver, "2");
		/*
		 * waitTillElementIsClickable(driver,OR.partshubone);
		 * elementClick(driver,partshubone);
		 */
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		
		waitForElement(driver,parthubpartslabel);
		actionClick(driver, parthubpartslabel);
		Thread.sleep(2000);
		actionType1(driver, OR.partqty,parthub);
		waitForElement(driver,reqqtylabelhub);
		actionClick(driver, reqqtylabelhub);
		Thread.sleep(2000);
		actionType1(driver, OR.reqqty,dataQuantity);
		waitForElement(driver,uomlabelhub);
		actionClick(driver,uomlabelhub);
		Thread.sleep(2000);
		actionType1(driver, OR.uom,UOM);
		
		/*
		 * waitForElement(driver, partnamewindow); wait(driver, "2");
		 * actionType1(driver,OR.partnamewindow,""); wait(driver, "2");
		 * waitForElement(driver,reqqtywindow); actionType1(driver,reqqtywindow,
		 * "keysToSend"); wait(driver, "2"); waitForElement(driver,uomwindow2);
		 * actionType1(driver,uomwindow2,"keysToSend"); wait(driver, "1");
		 * waitForElement(driver,OR.stockwindow);
		 * actionType1(driver,stockwindow,"keysToSend");
		 */
		waitForElement(driver,stockstatuslabel);
		actionClick(driver,stockstatuslabel);
		wait(driver, "2");
		actionClick(driver, OR.stocksta);
		wait(driver, "1");
		r11.keyPress(KeyEvent.VK_DOWN);
		r11.keyRelease(KeyEvent.VK_DOWN);
		for (int i = 0; i <=5; i++) {
		r11.keyPress(KeyEvent.VK_DOWN);
		r11.keyRelease(KeyEvent.VK_DOWN);
		}
		r11.keyPress(KeyEvent.VK_ENTER);
		r11.keyRelease(KeyEvent.VK_ENTER);
		waitForElement(driver,warehouselabel);
		actionClick(driver,warehouselabel);
		wait(driver, "3");
		actionClick(driver, OR.warehouse2);
		r11.keyPress(KeyEvent.VK_DOWN);
		r11.keyRelease(KeyEvent.VK_DOWN);
		for (int i = 0; i <=2; i++) {
		r11.keyPress(KeyEvent.VK_DOWN);
		r11.keyRelease(KeyEvent.VK_DOWN);
		}
		r11.keyPress(KeyEvent.VK_ENTER);
		r11.keyRelease(KeyEvent.VK_ENTER);
		for (int i = 0; i <= 20; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
		}
		elementClick(driver,need);
		 String date1 =getCurrentDate()+"PM";
		 wait(driver, "2");
		 actionType1(driver,need,date1);
		 System.out.println(date1);
		 
		 waitForElement(driver, checkboxafterfill);
		 wait(driver, "2");
		 actionClick(driver,checkboxafterfill);
		 driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
			wait(driver, "2");
			elementClick(driver,requestpart);
			driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
			wait(driver, "2");
			Thread.sleep(50000);
			 waitForElement(driver, checkboxafterfill);
			 wait(driver, "2");
			 actionClick(driver,checkboxafterfill);
			 waitForElement(driver,quicklink);
			 wait(driver, "2");
			 elementClick(driver,quicklink);
			 r11.keyPress(KeyEvent.VK_DOWN);
				r11.keyRelease(KeyEvent.VK_DOWN);
				for (int i = 0; i <=1; i++) {
				r11.keyPress(KeyEvent.VK_UP);
				r11.keyRelease(KeyEvent.VK_UP);
				}
				r11.keyPress(KeyEvent.VK_ENTER);
				r11.keyRelease(KeyEvent.VK_ENTER);
				wait(driver, "2");
				Thread.sleep(30000);
				for (int i = 0; i <= 20; i++) {
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				 waitForElement(driver,checkboxconfirmissue);
				 wait(driver, "2");
				 actionClick(driver,checkboxconfirmissue);
				 wait(driver, "2");
				 waitForElement(driver, confirmissue);
				 wait(driver, "2");
				 elementClick(driver,confirmissue);
				 Thread.sleep(60000);
				 waitForElement(driver, OR.okbutton);
					click(driver, OR.okbutton);
					 waitForElement(driver,back);
					 wait(driver, "2");
					 Thread.sleep(2000);
					 actionClick(driver,back);
					 driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
					 wait(driver, "3");
					 Thread.sleep(2000);
					 actionClick(driver,list);
					 Thread.sleep(2000);
					 waitForElement(driver,requestedbox);
					 wait(driver, "2");
					 actionClick(driver,requestedbox);
					 driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
					 Thread.sleep(5000);
					 waitForElement(driver,allbox);
					 wait(driver, "2");
					 actionClick(driver,allbox);
		/*
		 * driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		 * Thread.sleep(2000); waitForElement(driver,back); wait(driver, "2");
		 * actionClick(driver,back); Thread.sleep(2000);
		 * driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		 * waitForElement(driver,task2); wait(driver, "2"); actionClick(driver,task2);
		 * driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		 * wait(driver, "2"); Thread.sleep(2000); elementClick(driver,OR.requestpart);
		 * driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		 * //driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		 * wait(driver, "2");
		 */
						/*
						 * waitTillElementIsClickable(driver,OR.partshubone);
						 * elementClick(driver,partshubone);
						 */
						driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
						
						waitForElement(driver,parthubpartslabel);
						actionClick(driver, parthubpartslabel);
						Thread.sleep(2000);
						actionType1(driver, OR.partqty2,part3);
						waitForElement(driver,reqqtylabelhub);
						actionClick(driver, reqqtylabelhub);
						Thread.sleep(2000);
						actionType1(driver, OR.reqqty,dataQuantity);
						waitForElement(driver,uomlabelhub);
						actionClick(driver,uomlabelhub);
						Thread.sleep(2000);
						actionType1(driver, OR.uom,UOM);
						waitForElement(driver,stockstatuslabel);
						actionClick(driver,stockstatuslabel);
						wait(driver, "2");
						actionClick(driver, OR.stocksta);
						wait(driver, "1");
						r11.keyPress(KeyEvent.VK_DOWN);
						r11.keyRelease(KeyEvent.VK_DOWN);
						for (int i = 0; i <=5; i++) {
						r11.keyPress(KeyEvent.VK_DOWN);
						r11.keyRelease(KeyEvent.VK_DOWN);
						}
						r11.keyPress(KeyEvent.VK_ENTER);
						r11.keyRelease(KeyEvent.VK_ENTER);
						waitForElement(driver,warehouselabel);
						actionClick(driver,warehouselabel);
						wait(driver, "3");
						actionClick(driver, OR.warehouse2);
						r11.keyPress(KeyEvent.VK_DOWN);
						r11.keyRelease(KeyEvent.VK_DOWN);
						for (int i = 0; i <=2; i++) {
						r11.keyPress(KeyEvent.VK_DOWN);
						r11.keyRelease(KeyEvent.VK_DOWN);
						}
						r11.keyPress(KeyEvent.VK_ENTER);
						r11.keyRelease(KeyEvent.VK_ENTER);
						for (int i = 0; i <= 20; i++) {
							driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
						}
						elementClick(driver,need);
						 String date2 =getCurrentDate()+"PM";
						 wait(driver, "2");
						 actionType1(driver,need,date2);
						 System.out.println(date1);
						 
						 waitForElement(driver, checkboxafterfill);
						 wait(driver, "2");
						 actionClick(driver,checkboxafterfill);
						 driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
							driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
							wait(driver, "2");
							elementClick(driver,requestpart);
							driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
							wait(driver, "2");
							Thread.sleep(90000);
							 waitForElement(driver, checkboxhub2);
							 wait(driver, "2");
							 actionClick(driver,checkboxhub2);
							 waitForElement(driver,quicklink);
							 wait(driver, "2");
							 elementClick(driver,quicklink);
							 r11.keyPress(KeyEvent.VK_DOWN);
								r11.keyRelease(KeyEvent.VK_DOWN);
								for (int i = 0; i <=1; i++) {
								r11.keyPress(KeyEvent.VK_UP);
								r11.keyRelease(KeyEvent.VK_UP);
								}
								r11.keyPress(KeyEvent.VK_ENTER);
								r11.keyRelease(KeyEvent.VK_ENTER);
								wait(driver, "2");
								Thread.sleep(30000);
								for (int i = 0; i <= 20; i++) {
									driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
								}
								 waitForElement(driver,checkboxconfirmissue);
								 wait(driver, "2");
								 actionClick(driver,checkboxconfirmissue);
								 wait(driver, "2");
								 waitForElement(driver, confirmissue);
								 wait(driver, "2");
								 elementClick(driver,confirmissue);
								 Thread.sleep(60000);
								 waitForElement(driver, OR.okbutton);
									click(driver, OR.okbutton);
									 waitForElement(driver,back);
									 wait(driver, "2");
									 actionClick(driver,back);
									 waitForElement(driver,back);
									 wait(driver, "2");
									 actionClick(driver,back);
									 waitForElement(driver,discrepancy);
									 wait(driver, "2");
									 actionClick(driver,discrepancy);
									 driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
									 actionClick(driver,discrepancy);
									 actionClick(driver, disata1label);
										sendText11(driver,disata1);
										Thread.sleep(3000);
										actionType1(driver, disata1, ATA);
										Thread.sleep(3000);
										actionType1(driver, discdesc1,"landing");
										
										//actionClick(driver, atalabel);
										sendText11(driver, disata2);
										Thread.sleep(3000);
										actionType1(driver, disata2, ATA);
										Thread.sleep(3000);
										actionType1(driver, discdesc2,"hggayug");
										
										waitForElement(driver,disccheck1);
										wait(driver, "2");
										 actionClick(driver,disccheck1);
										 waitForElement(driver,disccheck2);
											wait(driver, "2");
											 actionClick(driver,disccheck2);
										
										elementClick(driver,save1);
										driver.manage().timeouts().pageLoadTimeout(80000, TimeUnit.SECONDS);
										Thread.sleep(60000);
										
										waitForElement(driver, OR.logitem1);
										wait(driver, "2");
										log1 = getText(driver, logitem1);
										
										waitForElement(driver, OR.logitem2);
										wait(driver, "2");
										log2 = getText(driver, logitem2);
										
										waitForElement(driver,disccheck1);
										wait(driver, "2");
										 actionClick(driver,disccheck1);
										 waitForElement(driver,disccheck2);
											wait(driver, "2");
											 actionClick(driver,disccheck2);
											 
										   elementClick(driver,OR.requestpart2);
									        driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		
		              wait(driver, "3"); 
		                   Thread.sleep(2000);
		                       actionClick(driver,list);
		                       Thread.sleep(2000); 
		                             waitForElement(driver,requestedbox);
		                       wait(driver, "2");
		                      actionClick(driver,requestedbox);
		 
											 
											 driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
											 
											 waitForElement(driver,sourcelabel);
												actionClick(driver, sourcelabel);
												Thread.sleep(2000);
												actionType1(driver, OR.source1,log1);
												
												waitForElement(driver,parthubpartslabel);
												actionClick(driver, parthubpartslabel);
												Thread.sleep(2000);
												actionType1(driver, OR.partqty,parthub);
												waitForElement(driver,reqqtylabelhub);
												actionClick(driver, reqqtylabelhub);
												Thread.sleep(2000);
												actionType1(driver, OR.reqqty,dataQuantity);
												waitForElement(driver,uomlabelhub);
												actionClick(driver,uomlabelhub);
												Thread.sleep(2000);
												actionType1(driver, OR.uom,UOM);
												
												
												
												
												waitForElement(driver,prioritylabel);
												actionClick(driver,prioritylabel);
												wait(driver, "2");
												actionClick(driver, OR.priority1);
												wait(driver, "1");
												r11.keyPress(KeyEvent.VK_DOWN);
												r11.keyRelease(KeyEvent.VK_DOWN);
												for (int i = 0; i <=3; i++) {
												r11.keyPress(KeyEvent.VK_DOWN);
												r11.keyRelease(KeyEvent.VK_DOWN);
												}
												r11.keyPress(KeyEvent.VK_ENTER);
												r11.keyRelease(KeyEvent.VK_ENTER);
												
												
												
												
												waitForElement(driver,stockstatuslabel);
												actionClick(driver,stockstatuslabel);
												wait(driver, "2");
												actionClick(driver, OR.stocksta);
												wait(driver, "1");
												r11.keyPress(KeyEvent.VK_DOWN);
												r11.keyRelease(KeyEvent.VK_DOWN);
												for (int i = 0; i <=5; i++) {
												r11.keyPress(KeyEvent.VK_DOWN);
												r11.keyRelease(KeyEvent.VK_DOWN);
												}
												r11.keyPress(KeyEvent.VK_ENTER);
												r11.keyRelease(KeyEvent.VK_ENTER);
												waitForElement(driver,warehouselabel);
												actionClick(driver,warehouselabel);
												wait(driver, "3");
												actionClick(driver, OR.warehouse2);
												r11.keyPress(KeyEvent.VK_DOWN);
												r11.keyRelease(KeyEvent.VK_DOWN);
												for (int i = 0; i <=2; i++) {
												r11.keyPress(KeyEvent.VK_DOWN);
												r11.keyRelease(KeyEvent.VK_DOWN);
												}
												r11.keyPress(KeyEvent.VK_ENTER);
												r11.keyRelease(KeyEvent.VK_ENTER);
												for (int i = 0; i <= 20; i++) {
													driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
												}
												elementClick(driver,need);
												 String date3 =getCurrentDate()+"PM";
												 wait(driver, "2");
												 actionType1(driver,need,date3);
												 System.out.println(date3);
												
												 waitForElement(driver,sourcelabel);
													actionClick(driver, sourcelabel);
													Thread.sleep(2000);
													actionType1(driver, OR.source2,log2);
												 
													 waitForElement(driver,parthubpartslabel);
														actionClick(driver, parthubpartslabel);
														Thread.sleep(2000);
														actionType1(driver, OR.partqty,part3);
														waitForElement(driver,reqqtylabelhub);
														actionClick(driver, reqqtylabelhub);
														Thread.sleep(2000);
														actionType1(driver, OR.reqqty,dataQuantity);
														
														WebElement element1 =driver.findElement(By.xpath("//div[text()='UOM']"));
														  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element1);
														
														
														
														
														waitForElement(driver,uomlabelhub);
														actionClick(driver,uomlabelhub);
														Thread.sleep(2000);
														actionType1(driver, OR.uom,UOM);
														
														waitForElement(driver,prioritylabel);
														actionClick(driver,prioritylabel);
														wait(driver, "2");
														actionClick(driver, OR.priority1);
														wait(driver, "1");
														r11.keyPress(KeyEvent.VK_DOWN);
														r11.keyRelease(KeyEvent.VK_DOWN);
														for (int i = 0; i <=3; i++) {
														r11.keyPress(KeyEvent.VK_DOWN);
														r11.keyRelease(KeyEvent.VK_DOWN);
														}
														r11.keyPress(KeyEvent.VK_ENTER);
														r11.keyRelease(KeyEvent.VK_ENTER);
														
														waitForElement(driver,stockstatuslabel);
														actionClick(driver,stockstatuslabel);
														wait(driver, "2");
														actionClick(driver, OR.stocksta);
														wait(driver, "1");
														r11.keyPress(KeyEvent.VK_DOWN);
														r11.keyRelease(KeyEvent.VK_DOWN);
														for (int i = 0; i <=5; i++) {
														r11.keyPress(KeyEvent.VK_DOWN);
														r11.keyRelease(KeyEvent.VK_DOWN);
														}
														r11.keyPress(KeyEvent.VK_ENTER);
														r11.keyRelease(KeyEvent.VK_ENTER);
														waitForElement(driver,warehouselabel);
														actionClick(driver,warehouselabel);
														wait(driver, "3");
														actionClick(driver, OR.warehouse2);
														r11.keyPress(KeyEvent.VK_DOWN);
														r11.keyRelease(KeyEvent.VK_DOWN);
														for (int i = 0; i <=2; i++) {
														r11.keyPress(KeyEvent.VK_DOWN);
														r11.keyRelease(KeyEvent.VK_DOWN);
														}
														r11.keyPress(KeyEvent.VK_ENTER);
														r11.keyRelease(KeyEvent.VK_ENTER);
														for (int i = 0; i <= 20; i++) {
															driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
														}
														elementClick(driver,need);
														 String date4 =getCurrentDate()+"PM";
														 wait(driver, "2");
														 actionType1(driver,need,date4);
														 System.out.println(date4);
														 
														 
														 waitForElement(driver, checkboxafterfill);
															 wait(driver, "2");
															 actionClick(driver,checkboxafterfill);
															 waitForElement(driver, checkboxhub2);
															 wait(driver, "2");
															 actionClick(driver,checkboxhub2);
															 
															 driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
																driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
																wait(driver, "2");
																elementClick(driver,requestpart);
																driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
																wait(driver, "2");
																Thread.sleep(50000);
																
																driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
																Thread.sleep(3000);
																 wait(driver, "2");
																 waitTillElementIsClickable(driver, exclamatory);
																actionClick(driver,exclamatory);
                      wait(driver, "3");
                        Thread.sleep(2000);
                        actionClick(driver,list);
													                       
			             wait(driver, "2");
			 		 waitTillElementIsClickable(driver,plus);            
			 		actionClick(driver,plus);

			 		  wait(driver, "2");
				 		 waitTillElementIsClickable(driver,searchplus);            
				 		actionClick(driver,searchplus);
				 		
				 		 wait(driver, "3");
	                        Thread.sleep(2000);
	                        actionClick(driver,list);
														
				 		
				 		
						
					 		
				 		
				 	
				 		waitForElement(driver,parthubpartslabel);
						actionClick(driver, parthubpartslabel);
						Thread.sleep(2000);
						actionType1(driver, OR.partqty4,parthub);
						waitForElement(driver,reqqtylabelhub);
						actionClick(driver, reqqtylabelhub);
						Thread.sleep(2000);
						actionType1(driver, OR.reqqty,dataQuantity);
						WebElement element12=driver.findElement(By.xpath("//div[text()='UOM']"));
						  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element12);
						
						waitForElement(driver,uomlabelhub);
						actionClick(driver,uomlabelhub);
						Thread.sleep(2000);
						actionType1(driver, OR.uom,UOM);
						
						
						
						
						waitForElement(driver,prioritylabel);
						actionClick(driver,prioritylabel);
						wait(driver, "2");
						actionClick(driver, OR.priority1);
						wait(driver, "1");
						r11.keyPress(KeyEvent.VK_DOWN);
						r11.keyRelease(KeyEvent.VK_DOWN);
						for (int i = 0; i <=3; i++) {
						r11.keyPress(KeyEvent.VK_DOWN);
						r11.keyRelease(KeyEvent.VK_DOWN);
						}
						r11.keyPress(KeyEvent.VK_ENTER);
						r11.keyRelease(KeyEvent.VK_ENTER);
						
						
						
						
						waitForElement(driver,stockstatuslabel);
						actionClick(driver,stockstatuslabel);
						wait(driver, "2");
						actionClick(driver, OR.stocksta);
						wait(driver, "1");
						r11.keyPress(KeyEvent.VK_DOWN);
						r11.keyRelease(KeyEvent.VK_DOWN);
						for (int i = 0; i <=5; i++) {
						r11.keyPress(KeyEvent.VK_DOWN);
						r11.keyRelease(KeyEvent.VK_DOWN);
						}
						r11.keyPress(KeyEvent.VK_ENTER);
						r11.keyRelease(KeyEvent.VK_ENTER);
						waitForElement(driver,warehouselabel);
						actionClick(driver,warehouselabel);
						wait(driver, "3");
						actionClick(driver, OR.warehouse2);
						r11.keyPress(KeyEvent.VK_DOWN);
						r11.keyRelease(KeyEvent.VK_DOWN);
						for (int i = 0; i <=2; i++) {
						r11.keyPress(KeyEvent.VK_DOWN);
						r11.keyRelease(KeyEvent.VK_DOWN);
						}
						r11.keyPress(KeyEvent.VK_ENTER);
						r11.keyRelease(KeyEvent.VK_ENTER);
						for (int i = 0; i <= 20; i++) {
							driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
						}
						elementClick(driver,need);
						 String date5 =getCurrentDate()+"PM";
						 wait(driver, "2");
						 actionType1(driver,need,date5);
						 System.out.println(date5);
						 
					
						 
						 waitForElement(driver,help);
							elementClick(driver,help);
							 Thread.sleep(5000);
							driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
							Thread.sleep(3000);
							actionClick(driver,search5);
							
							
							for (int i = 0; i <= 20; i++) {
								driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
							}
							
							 wait(driver, "2");
					 		 waitTillElementIsClickable(driver,helpcheckbox3);            
					 		actionClick(driver,helpcheckbox3);
					 		
					 		 wait(driver, "2");
					 		 waitTillElementIsClickable(driver,helpok);            
					 		actionClick(driver,helpok);
							
						 waitForElement(driver, checkboxafterfill);
						 wait(driver, "2");
						 actionClick(driver,checkboxafterfill);
					
						 	 driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
							driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
							wait(driver, "2");
							elementClick(driver,requestpart);
							Thread.sleep(70000);
							
							 waitForElement(driver,requestedbox);
		                       wait(driver, "2");
		                      actionClick(driver,requestedbox);		
                            driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
                            wait(driver, "2");
                            waitForElement(driver, checkboxafterfill);
   						 wait(driver, "2");
   						 actionClick(driver,checkboxafterfill);
							 waitForElement(driver,quicklink);
							 wait(driver, "2");
							 elementClick(driver,quicklink);
							 r11.keyPress(KeyEvent.VK_DOWN);
								r11.keyRelease(KeyEvent.VK_DOWN);
								for (int i = 0; i <=1; i++) {
								r11.keyPress(KeyEvent.VK_UP);
								r11.keyRelease(KeyEvent.VK_UP);
								}
								r11.keyPress(KeyEvent.VK_ENTER);
								r11.keyRelease(KeyEvent.VK_ENTER);
								wait(driver, "2");
								Thread.sleep(30000);
								for (int i = 0; i <= 20; i++) {
									driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
								}
								 waitForElement(driver,checkboxconfirmissue);
								 wait(driver, "2");
								 actionClick(driver,checkboxconfirmissue);
								 wait(driver, "2");
								 waitForElement(driver, confirmissue);
								 wait(driver, "2");
								 elementClick(driver,confirmissue);
								 Thread.sleep(60000);
								 waitForElement(driver, OR.okbutton);
									click(driver, OR.okbutton);
									   
				                       Thread.sleep(2000); 
				                            	                       
													                       
				                      waitForElement(driver,back);
										 wait(driver, "2");
										 actionClick(driver,back);		
										 
												
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                       
													                    
													 
																
															
		/*
		 * actionClick(driver, usermenu); Thread.sleep(2000); actionClick(driver,
		 * signout);
		 */
	}

}
