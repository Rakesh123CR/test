package scripts;

import org.openqa.selenium.WebDriver;

import commonMethods.Keywords;
import commonMethods.Utils;

public class Burrow extends Keywords
{

	 String EnterFirstName = Utils.getDataFromTestData("ShippingAddress", "FirstName");
	 String EnterLastName = Utils.getDataFromTestData("ShippingAddress", "LastName");
	 String EnterEmail = Utils.getDataFromTestData("ShippingAddress", "Email");
	 String EnterPhone = Utils.getDataFromTestData("ShippingAddress", "Phone");
	 String EnterAddress = Utils.getDataFromTestData("ShippingAddress", "Address");
	 String EnterManualAddress = Utils.getDataFromTestData("ShippingAddress", "ManualAddress");
	 String EnterSuite = Utils.getDataFromTestData("ShippingAddress", "Suite");
	 String EnterCity = Utils.getDataFromTestData("ShippingAddress", "City");
	 String EnterZipCode = Utils.getDataFromTestData("ShippingAddress", "ZipCode");
	 String EnterCardNumber = Utils.getDataFromTestData("Payment", "CreditCardNumber");
	 String EnterNameOnCard = Utils.getDataFromTestData("Payment", "NameOnCard");
	 String EnterEXPMM = Utils.getDataFromTestData("Payment", "EXP MM");
	 String EnterEXPYYYY = Utils.getDataFromTestData("Payment", "EXP YYYY");
	 String EnterCVV = Utils.getDataFromTestData("Payment", "CVV");
	 String EnterCompany = Utils.getDataFromTestData("ShippingAddress", "Company");
	 String EnterBillingFirstName = Utils.getDataFromTestData("BillingAddress", "FirstName");
	 String EnterBillingLastName = Utils.getDataFromTestData("BillingAddress", "LastName");
	 String EnterBillingAddress = Utils.getDataFromTestData("BillingAddress", "Address");
	 String EnterBillingManualAddress = Utils.getDataFromTestData("BillingAddress", "ManualAddress");
	 String EnterBillingSuite = Utils.getDataFromTestData("BillingAddress", "Suite");
	 String EnterBillingCity = Utils.getDataFromTestData("BillingAddress", "City");
	 String EnterBillingZipCode = Utils.getDataFromTestData("BillingAddress", "ZipCode");
	 String EnterUserName = Utils.getDataFromTestData("Login", "UserName");
	 String EnterPassword = Utils.getDataFromTestData("Login", "Password");
	 String sofaInHomePage;
	 String sofaInCartPage;
	 String sofaInPlaceOrder;
	 String SofaAfterOrdering;
	 String subTotaoInCartPage;
	 String subTotalInPlaceOrder;
	 String Total;
	 String GettotalInPlaceOrder;
	 String TaxInPlaceOrder;
	 String TotalInPlaceOrder;
	private String screenshotName;
	
	
	
	 
public void launch(WebDriver driver,String URL) throws InterruptedException {
		
		get(driver,URL);
		//maximize(driver);
		wait(driver, "3");
		waitForElement(driver, burrowLogo);
		
}


//Adding the product to the cart
public void addToBoxLoveseat(WebDriver driver)
{
		waitForElement(driver, burrowLogo);
		click(driver, burrowLogo);
		waitForElement(driver, shopSofas);
		click(driver, shopSofas);
		waitForElement(driver, sofa);
		sofaInHomePage=getText(driver, sofa);
		click(driver, sofa);
		wait(driver, "3");
		waitForElement(driver, addToBox);
		click(driver, addToBox);
}

public void addToBoxArmChair(WebDriver driver)
{
		waitForElement(driver, burrowLogo);
		click(driver, burrowLogo);
		waitForElement(driver, shopSofas);
		click(driver, shopSofas);
		waitForElement(driver, armChair);
		sofaInHomePage=getText(driver, armChair);
		click(driver, armChair);
		wait(driver, "3");
		waitForElement(driver, addToBox);
		click(driver, addToBox);
}

//Checkout the added product in the cart
public void checkout(WebDriver driver)
{
	
		waitForElement(driver, yourBox);
		if(isDisplayed(driver, cartSofa))
		{
		verifyElementIsPresent(driver, cartSofa);
		sofaInCartPage=getText(driver, cartSofa);
		waitForElement(driver, cartSubTotal);
		subTotaoInCartPage=getText(driver, cartSubTotal);
		click(driver, checkout);
		}
		
		
			else if (isDisplayed(driver, cartArmChair)) 
			{
			verifyElementIsPresent(driver, cartArmChair);
			sofaInCartPage=getText(driver, cartArmChair);
			waitForElement(driver, cartSubTotal);
			subTotaoInCartPage=getText(driver, cartSubTotal);
			click(driver, checkout);
		}
}

//Clicking Continue as a guest user button
public void guestUser(WebDriver driver)
{
		waitForElement(driver,guest);
		click(driver, guest);
}

public void registeredUser(WebDriver driver)
{
		waitForElement(driver,userName);
		sendKeys(driver, userName, EnterUserName);
		waitForElement(driver, password);
		sendKeys(driver, password, EnterPassword);
		waitForElement(driver, rememberMe);
		click(driver, rememberMe);
		waitForElement(driver, login);
		click(driver, login);
		waitForElement(driver, firstName);
		sendKeys(driver, firstName, EnterFirstName);
		sendKeys(driver, lastName, EnterLastName);
		getAttribute(driver, email, "value");
		sendKeys(driver, phone, EnterPhone);
		sendKeys(driver, company, EnterCompany);
}

// Entering Shipping Details except address
public void shippingDetails(WebDriver driver)
{
		waitForElement(driver, firstName);
		sendKeys(driver, firstName, EnterFirstName);
		sendKeys(driver, lastName, EnterLastName);
		sendKeys(driver, email, EnterEmail);
		sendKeys(driver, phone, EnterPhone);
		sendKeys(driver, company, EnterCompany);
}



//Entering the Shipping address by using Google lookup
public void shippingAddressGoogle(WebDriver driver)
{
		//waitForElement(driver, addressCheckbox);
		//scrollUsingElement(driver, suite);
		if(isDisplayed(driver, address))
		{
			click(driver, addressCheckboxBeforeGoogleAddress);
		}
		waitForElement(driver, address1);
		sendKeys(driver, suite, EnterSuite);
		sendKeys(driver, address1, EnterAddress);
		click(driver, address1);
		waitForElement(driver, googleLookup);
		mouseOverAndClick(driver, googleLookup);
		wait(driver, "3");
		if(isDisplayed(driver, alertPopup))
		{
			waitForElement(driver, alertPopup);
			click(driver, alertPopup);
			/*click(driver, address1);
			keyboardArrowDown(driver);
			enter(driver);*/
		}
		if(isDisplayed(driver, alertPopup))
		{
			waitForElement(driver, alertPopup);
			click(driver, alertPopup);
		}
		waitForElement(driver, nextStep);
		wait(driver, "3");
		click(driver, nextStep);
}

public void shippingAddressManual(WebDriver driver)
{
	if(isDisplayed(driver, address1))
	{
		waitForElement(driver, addressCheckbox);
		click(driver, addressCheckbox);
	}
	/*else
	{
		waitForElement(driver, addressCheckboxBeforeGoogleAddress);
		click(driver, addressCheckboxBeforeGoogleAddress);
	}*/
	waitForElement(driver, address);
	sendKeys(driver, address, EnterManualAddress);
	sendKeys(driver, suite, EnterSuite);
	sendKeys(driver, city, EnterCity);
	click(driver, state);
	selectByIndex(driver, state, "4");
	sendKeys(driver, zipcode, EnterZipCode);
	waitForElement(driver, nextStep);
	click(driver, nextStep);
}

public void shippingAddressBothGoogleManual(WebDriver driver)
{
	if(isDisplayed(driver, address))
	{
		waitForElement(driver, addressCheckboxBeforeGoogleAddress);
		click(driver, addressCheckboxBeforeGoogleAddress);
	}
	sendKeys(driver, suite, EnterSuite);
	sendKeys(driver, address1, EnterAddress);
	click(driver, address1);
	waitForElement(driver, googleLookup);
	mouseOverAndClick(driver, googleLookup);
	wait(driver, "3");
	if(isDisplayed(driver, alertPopup))
	{
		waitForElement(driver, alertPopup);
		click(driver, alertPopup);
	}
	
	if(isDisplayed(driver, address1))
	{
		click(driver, address1);
		waitForElement(driver, googleLookup);
		click(driver, googleLookup);
		waitForElement(driver, alertPopup);
		click(driver, alertPopup);
	}
	
	wait(driver, "2");
	waitForElement(driver, addressCheckboxAfterGoogleAddress);
	//scrollUsingElement(driver, addressCheckboxAfterGoogleAddress);
	click(driver, addressCheckboxAfterGoogleAddress);
	waitForElement(driver, address);
	sendKeys(driver, address, EnterManualAddress);
	sendKeys(driver, suite, EnterSuite);
	sendKeys(driver, city, EnterCity);
	click(driver, state);
	selectByIndex(driver, state, "4");
	sendKeys(driver, zipcode, EnterZipCode);
	waitForElement(driver, nextStep);
	click(driver, nextStep);
}



//Entering the Shipping address by manually
public void shippingAddressManualAndSameBilling(WebDriver driver)
		{
		waitForElement(driver, nextStep);
		//scrollUsingElement(driver, addressCheckbox);
		if (isDisplayed(driver, address1)) 
		{
			waitForElement(driver, addressCheckbox);
			click(driver, addressCheckbox);
		}
		waitForElement(driver, address);
		sendKeys(driver, address, EnterManualAddress);
		sendKeys(driver, suite, EnterSuite);
		sendKeys(driver, city, EnterCity);
		click(driver, state);
		selectByIndex(driver, state, "4");
		sendKeys(driver, zipcode, EnterZipCode);
		waitForElement(driver, nextStep);
		click(driver, nextStep);
		waitForElement(driver, creditCard);
		wait(driver, "3");
		click(driver, creditCard);
		waitForElement(driver, cardNumber);
		wait(driver, "3");
		sendKeys(driver, cardNumber, EnterCardNumber);
		sendKeys(driver, nameOnCard, EnterNameOnCard);
		sendKeys(driver, expiryMonth, EnterEXPMM);
		sendKeys(driver, expiryYear, EnterEXPYYYY);
		sendKeys(driver, expiryCVV, EnterCVV);
		waitForElement(driver, sameAsShippingAddress);
		if(isDisplayed(driver, billingFirstName))
		{
			click(driver, sameAsShippingAddress);
			waitForElement(driver, nextStep);
			click(driver, nextStep);
		}
		else
		{
		waitForElement(driver, nextStep);
		click(driver, nextStep);
		}
}

//Clicking Same as shipping address checkbox in the payment section
public void paymentWithSameShippingAddress(WebDriver driver)
{
		
		wait(driver, "2");
		waitForElement(driver, sameAsShippingAddress);
		scrollUsingElement(driver, sameAsShippingAddress);
		click(driver, sameAsShippingAddress);
		waitForElement(driver, nextStep);
		click(driver, nextStep);
		wait(driver, "5");
}

public void cardDetails(WebDriver driver)
{
	wait(driver, "3");
	waitForElement(driver, creditCard);
	click(driver, creditCard);
	waitForElement(driver, cardNumber);
	wait(driver, "3");
	sendKeys(driver, cardNumber, EnterCardNumber);
	sendKeys(driver, nameOnCard, EnterNameOnCard);
	sendKeys(driver, expiryMonth, EnterEXPMM);
	sendKeys(driver, expiryYear, EnterEXPYYYY);
	sendKeys(driver, expiryCVV, EnterCVV);
		
}

public void BillingDetails(WebDriver driver)
{
	if(isDisplayed(driver, billingFirstName))
	{
		wait(driver, "1");
	}
	else
	{
		click(driver, sameAsShippingAddress);
	}
	waitForElement(driver, billingFirstName);
	wait(driver, "3");
	click(driver, billingFirstName);
	wait(driver, "3");
	actionType(driver, billingFirstName, EnterBillingFirstName);
	sendKeys(driver, billingLastName, EnterBillingLastName);
	wait(driver, "3");
}

public void BillingAddressGoogle(WebDriver driver)
{
	if(isDisplayed(driver, billingAddress))
	{
		scrollUsingElement(driver, dontSeeMyAddressBeforeGoogleAddress);
		click(driver, dontSeeMyAddressBeforeGoogleAddress);
	}
	waitForElement(driver, billingAddress1);
	sendKeys(driver, billingSuite, EnterBillingSuite);
	sendKeys(driver, billingAddress1, EnterBillingAddress);
	click(driver, billingAddress1);
	waitForElement(driver, googleLookup);
	mouseOverAndClick(driver, googleLookup);
	wait(driver, "3");
	if(isDisplayed(driver, alertPopup))
	{
		waitForElement(driver, alertPopup);
		click(driver, alertPopup);
	}
	waitForElement(driver, nextStep);
	wait(driver, "2");
	click(driver, nextStep);
}

public void BillingAddressManual(WebDriver driver)
{
	if(isDisplayed(driver, billingAddress1))
	{
		click(driver, dontSeeMyAddress);
	}
	scrollUsingElement(driver, billingAddress);
	waitForElement(driver, billingAddress);
	sendKeys(driver, billingAddress, EnterBillingManualAddress);
	sendKeys(driver, billingSuite, EnterBillingSuite);
	sendKeys(driver, billingCity, EnterBillingCity);
	click(driver, billingState);
	selectByIndex(driver, billingState, "31");
	sendKeys(driver, billingZip, EnterBillingZipCode);
	waitForElement(driver, nextStep);
	click(driver, nextStep);
}

public void BillingAddressBothGoogleManual(WebDriver driver)
{
	waitForElement(driver, sameAsShippingAddress);
	/*if(isElementSelected(driver, sameAsShippingAddress))
	{
		wait(driver, "2");
		click(driver, sameAsShippingAddress);
	}*/
	
	if(isDisplayed(driver, billingAddress))
	{
		click(driver, dontSeeMyAddressBeforeGoogleAddress);
	}
	waitForElement(driver, billingAddress1);
	sendKeys(driver, billingSuite, EnterBillingSuite);
	sendKeys(driver, billingAddress1, EnterBillingAddress);
	click(driver, billingAddress1);
	waitForElement(driver, googleLookup);
	mouseOverAndClick(driver, googleLookup);
	wait(driver, "3");
	if(isDisplayed(driver, alertPopup))
	{
		waitForElement(driver, alertPopup);
		click(driver, alertPopup);
	}	
	
	if (isDisplayed(driver, billingAddress)) 
	{
		waitForElement(driver, nextStep);
	}
	else
	{
		click(driver, dontSeeMyAddressAfterGoogleAddress);
	}
	waitForElement(driver, billingAddress);
	scrollUsingElement(driver, billingAddress);
	sendKeys(driver, billingAddress, EnterBillingManualAddress);
	sendKeys(driver, billingSuite, EnterBillingSuite);
	sendKeys(driver, billingCity, EnterBillingCity);
	click(driver, billingState);
	selectByIndex(driver, billingState, "31");
	sendKeys(driver, billingZip, EnterBillingZipCode);
	waitForElement(driver, nextStep);
	click(driver, nextStep);
	
}

//Placing the order
public void placeOrder(WebDriver driver)
{
		if(isDisplayed(driver, placeOrderSofa))
		{
		waitForElement(driver, placeOrderButton);
		verifyElementIsPresent(driver, placeOrderSofa);
		wait(driver, "3");
		sofaInPlaceOrder= getText(driver, placeOrderSofa);
		checkTwoString(driver, sofaInCartPage, sofaInPlaceOrder);
		verifyElementIsPresent(driver, placeOrderSubTotal);
		subTotalInPlaceOrder=getText(driver, placeOrderSubTotal);
		checkTwoString(driver, subTotaoInCartPage, subTotalInPlaceOrder);
		//Old Code
		/*char[] subTotalInPlaceOrderChar = new char[5]; 
        
        try { 
        	subTotalInPlaceOrder.getChars(1, 5, subTotalInPlaceOrderChar, 0);
            System.out.println(subTotalInPlaceOrderChar);
            }
        catch (Exception ex) { 
            System.out.println(ex); 
        }
        
        String S1 = new String(subTotalInPlaceOrderChar);
        double subTotalInPlaceOrderDouble = Double.parseDouble(S1);
        
		System.out.println(subTotalInPlaceOrderDouble);
        verifyElementIsPresent(driver, placeOrderTax);
		TaxInPlaceOrder=getText(driver, placeOrderTax);
		char[] TaxInPlaceOrderChar = new char[5]; 
        
        try { 
        	TaxInPlaceOrder.getChars(1, 5, TaxInPlaceOrderChar, 0);
            System.out.println(TaxInPlaceOrderChar);
            }
        catch (Exception ex) { 
            System.out.println(ex); 
        }
        String S2 = new String(TaxInPlaceOrderChar);
        double TaxInPlaceOrderDouble = Double.parseDouble(S2);
        System.out.println(TaxInPlaceOrderDouble);
        Double TotalDouble = subTotalInPlaceOrderDouble + TaxInPlaceOrderDouble;
        
        String Total = Double.toString(TotalDouble);
        System.out.println("CalculatedTotal="+Total);*/
		
		//New Code
		
		String replacestrtotal = subTotalInPlaceOrder.replace("$", "");
		replacestrtotal = replacestrtotal.replaceAll(",", "");
		TaxInPlaceOrder=getText(driver, placeOrderTax);
		String replacestrtax = TaxInPlaceOrder.replace("$", "");
		replacestrtax = replacestrtax.replaceAll(",", "");
		Double d1 = Double.parseDouble(replacestrtotal);
		System.out.println("Total = " + d1);
		Double d2 = Double.parseDouble(replacestrtax);
		System.out.println("Tax = " + d2);
		double d3 = d1 +d2;
		System.out.println("GrandTotalDouble = " + d3);
		Total = Double.toString(d3);
		System.out.println("GrandTotalDouble = " + d3);
		verifyElementIsPresent(driver, placeOrderTotal);
		GettotalInPlaceOrder=getText(driver, placeOrderTotal);
		System.out.println("ActualTotal="+GettotalInPlaceOrder);
		TotalInPlaceOrder = GettotalInPlaceOrder.replace("$", "");
		TotalInPlaceOrder = TotalInPlaceOrder.replaceAll(",", "");
		checkPartialText(driver, Total, TotalInPlaceOrder); 
		click(driver, placeOrderButton);
		wait(driver, "20");
		if(isDisplayed(driver, alertPopup))
		{
			click(driver, alertPopup);
			click(driver, placeOrderButton);
		}
		}
		else if (isDisplayed(driver, placeOrderArmChair)) 
		{
			waitForElement(driver, placeOrderButton);
			verifyElementIsPresent(driver, placeOrderArmChair);
			wait(driver, "3");
			sofaInPlaceOrder= getText(driver, placeOrderArmChair);
			checkTwoString(driver, sofaInCartPage, sofaInPlaceOrder);
			verifyElementIsPresent(driver, placeOrderSubTotal);
			subTotalInPlaceOrder=getText(driver, placeOrderSubTotal);
			checkTwoString(driver, subTotaoInCartPage, subTotalInPlaceOrder);
			//Old Code
			/*char[] subTotalInPlaceOrderChar = new char[5]; 
	        
	        try { 
	        	subTotalInPlaceOrder.getChars(1, 5, subTotalInPlaceOrderChar, 0);
	            System.out.println(subTotalInPlaceOrderChar);
	            }
	        catch (Exception ex) { 
	            System.out.println(ex); 
	        }
	        
	        String S1 = new String(subTotalInPlaceOrderChar);
	        double subTotalInPlaceOrderDouble = Double.parseDouble(S1);
	        
			System.out.println(subTotalInPlaceOrderDouble);
	        verifyElementIsPresent(driver, placeOrderTax);
			TaxInPlaceOrder=getText(driver, placeOrderTax);
			char[] TaxInPlaceOrderChar = new char[5]; 
	        
	        try { 
	        	TaxInPlaceOrder.getChars(1, 5, TaxInPlaceOrderChar, 0);
	            System.out.println(TaxInPlaceOrderChar);
	            }
	        catch (Exception ex) { 
	            System.out.println(ex); 
	        }
	        String S2 = new String(TaxInPlaceOrderChar);
	        double TaxInPlaceOrderDouble = Double.parseDouble(S2);
	        System.out.println(TaxInPlaceOrderDouble);
	        Double TotalDouble = subTotalInPlaceOrderDouble + TaxInPlaceOrderDouble;
	        
	        String Total = Double.toString(TotalDouble);
	        System.out.println("CalculatedTotal="+Total);*/
			
			//New Code
			
			String replacestrtotal = subTotalInPlaceOrder.replace("$", "");
			replacestrtotal = replacestrtotal.replaceAll(",", "");
			TaxInPlaceOrder=getText(driver, placeOrderTax);
			String replacestrtax = TaxInPlaceOrder.replace("$", "");
			replacestrtax = replacestrtax.replaceAll(",", "");
			Double d1 = Double.parseDouble(replacestrtotal);
			System.out.println("Total = " + d1);
			Double d2 = Double.parseDouble(replacestrtax);
			System.out.println("Tax = " + d2);
			double d3 = d1 +d2;
			System.out.println("GrandTotalDouble = " + d3);
			Total = Double.toString(d3);
			System.out.println("GrandTotalDouble = " + d3);
			verifyElementIsPresent(driver, placeOrderTotal);
			GettotalInPlaceOrder=getText(driver, placeOrderTotal);
			System.out.println("ActualTotal="+GettotalInPlaceOrder);
			TotalInPlaceOrder = GettotalInPlaceOrder.replace("$", "");
			TotalInPlaceOrder = TotalInPlaceOrder.replaceAll(",", "");
			checkPartialText(driver, Total, TotalInPlaceOrder); 
			click(driver, placeOrderButton);
			wait(driver, "20");
			if(isDisplayed(driver, alertPopup))
			{
				click(driver, alertPopup);
				click(driver, placeOrderButton);
			}
			}
		
		
		
}

public void orderAfterPlaced(WebDriver driver)
{
	waitForElement(driver, emailMeOrderDetails);
	verifyElementIsPresent(driver, orderNo);
	getText(driver, orderNo);
	verifyElementIsPresent(driver, sofaAfterOrder);
	SofaAfterOrdering=getText(driver, sofaAfterOrder);
	checkTwoString(driver, sofaInPlaceOrder, SofaAfterOrdering);
	verifyElementIsPresent(driver, grandTotal);
	getText(driver, grandTotal);
	click(driver, emailMeOrderDetails);
	waitForElement(driver, recieveEmailButton);
}

//Don't enter shipping address--edit payment--enter cardDetails--click same as shipping address check box--place order--capture error

public void withoutShippingBillingAddress(WebDriver driver)
{
	waitForElement(driver, editButton);
	click(driver, editButton);
	waitForElement(driver, creditCard);
	wait(driver, "3");
	click(driver, creditCard);
	waitForElement(driver, cardNumber);
	wait(driver, "3");
	sendKeys(driver, cardNumber, EnterCardNumber);
	sendKeys(driver, nameOnCard, EnterNameOnCard);
	sendKeys(driver, expiryMonth, EnterEXPMM);
	sendKeys(driver, expiryYear, EnterEXPYYYY);
	sendKeys(driver, expiryCVV, EnterCVV);
	waitForElement(driver, sameAsShippingAddress);
	click(driver, sameAsShippingAddress);
	waitForElement(driver, nextStep);
	click(driver, nextStep);
	waitForElement(driver, placeOrderButton);
	click(driver, placeOrderButton);
	waitForElement(driver, requiredError);
	getText(driver, requiredError);
	waitForElement(driver, alertPopup);
	screenshot(driver, "RequiredErrorMessageShippingBilling");
	click(driver, alertPopup);
			
}

//Enter shipping address by editing shipping section--uncheck same as shipping address in payemnt section--click next step--capture error

public void withShippingWithoutBillingAddress(WebDriver driver)
{
	waitForElement(driver, editButton1);
	click(driver, editButton1);
	
	//Shipping Details
	wait(driver, "3");
	waitForElement(driver, firstName);
	wait(driver, "3");
	click(driver, firstName);
	wait(driver, "3");
	sendKeys(driver, firstName, EnterFirstName);
	sendKeys(driver, lastName, EnterLastName);
	sendKeys(driver, email, EnterEmail);
	sendKeys(driver, phone, EnterPhone);
	sendKeys(driver, company, EnterCompany);
	
	//Shipping Address
	waitForElement(driver, address1);
	sendKeys(driver, suite, EnterSuite);
	sendKeys(driver, address1, EnterAddress);
	click(driver, address1);
	waitForElement(driver, googleLookup);
	mouseOverAndClick(driver, googleLookup);
	wait(driver, "3");
	if(isDisplayed(driver, alertPopup))
	{
		waitForElement(driver, alertPopup);
		click(driver, alertPopup);
		/*click(driver, address1);
		keyboardArrowDown(driver);
		enter(driver);*/
	}
	waitForElement(driver, nextStep);
	wait(driver, "2");
	click(driver, nextStep);
	
	//Billing Details
	waitForElement(driver, sameAsShippingAddress);
	waitForElement(driver, billingFirstName);
	scrollUsingElement(driver, billingFirstName);
	wait(driver, "3");
	clearAndType(driver, billingFirstName, EnterBillingFirstName);
	waitForElement(driver, billingLastName);
	clearAndType(driver, billingLastName, EnterBillingLastName);
	
	//Removing google billing Address 
	/*waitForElement(driver, editIcon);
	click(driver, editIcon);
	clear(driver, billingAddress1);
	clear(driver, billingSuite);
	waitForElement(driver, nextStep);
	click(driver, nextStep);
	if(isDisplayed(driver, placeOrderButton))
	{
	waitForElement(driver, placeOrderButton);
	click(driver, placeOrderButton);
	waitForElement(driver, requiredError);
	getText(driver, requiredError);
	waitForElement(driver, alertPopup);
	screenshot(driver, screenshotName);
	click(driver, alertPopup);
	}
	else
	{
		waitForElement(driver, billingFirstName);
		clearAndType(driver, billingFirstName, EnterBillingFirstName);
		clearAndType(driver, billingLastName, EnterBillingLastName);
		waitForElement(driver, nextStep);
		click(driver, nextStep);
		waitForElement(driver, placeOrderButton);
		click(driver, placeOrderButton);
		waitForElement(driver, requiredError);
		getText(driver, requiredError);
		waitForElement(driver, alertPopup);
		screenshot(driver, screenshotName);
		click(driver, alertPopup);
	}*/
	
	//Removing Manual Address
	waitForElement(driver, billingAddress);
	selectByIndex(driver, billingState, "0");
	wait(driver, "1");
	clear(driver, billingAddress);
	wait(driver, "1");
	clear(driver, billingSuite);
	wait(driver, "1");
	clear(driver, billingCity);
	wait(driver, "1");
	clear(driver, billingZip);
	waitForElement(driver, nextStep);
	click(driver, nextStep);
	screenshot(driver, "Toast MessageBilling");
	waitForElement(driver, dontSeeMyAddressBeforeGoogleAddress);
	click(driver, dontSeeMyAddressBeforeGoogleAddress);
	
			
}

public void withoutShippingWithBillingAddress(WebDriver driver)
{
	waitForElement(driver, editButton2);
	click(driver, editButton2);
	waitForElement(driver, sameAsShippingAddress);
	if(isElementSelected(driver, sameAsShippingAddress))
	{
		wait(driver, "2");
	click(driver, sameAsShippingAddress);
	}
	
	
	
	//Google lookup
	/*waitForElement(driver, billingAddress1);
	sendKeys(driver, billingSuite, EnterBillingSuite);
	sendKeys(driver, billingAddress1, EnterBillingAddress);
	click(driver, billingAddress1);
	waitForElement(driver, googleLookup);
	//keyboardArrowDown(driver);
	mouseOverAndClick(driver, googleLookup);
	wait(driver, "3");
	if(isDisplayed(driver, alertPopup))
	{
		waitForElement(driver, alertPopup);
		click(driver, alertPopup);
	}*/
	
	//Billing Details
		waitForElement(driver, billingFirstName);
		wait(driver, "3");
		click(driver, billingFirstName);
		wait(driver, "3");
		actionType(driver, billingFirstName, EnterBillingFirstName);
		sendKeys(driver, billingLastName, EnterBillingLastName);
	
	//Manual Billing Address
	waitForElement(driver, dontSeeMyAddress);
	click(driver, dontSeeMyAddress);
	scrollUsingElement(driver, billingAddress);
	waitForElement(driver, billingAddress);
	sendKeys(driver, billingAddress, EnterBillingManualAddress);
	sendKeys(driver, billingSuite, EnterBillingSuite);
	sendKeys(driver, billingCity, EnterBillingCity);
	click(driver, billingState);
	selectByIndex(driver, billingState, "31");
	sendKeys(driver, billingZip, EnterBillingZipCode);
	
	waitForElement(driver, nextStep);
	click(driver, nextStep);
	if(isDisplayed(driver, placeOrderButton))
	{
	waitForElement(driver, placeOrderButton);
	click(driver, placeOrderButton);
	waitForElement(driver, alertPopup);
	screenshot(driver, "RequiredErrorMessageShipping");
	click(driver, alertPopup);
	}
	else{
	
		waitForElement(driver, billingFirstName);
		wait(driver, "3");
		click(driver, billingFirstName);
		wait(driver, "3");
		clearAndType(driver, billingFirstName, EnterBillingFirstName);
		clearAndType(driver, billingLastName, EnterBillingLastName);
		waitForElement(driver, nextStep);
		click(driver, nextStep);
		if(isDisplayed(driver, placeOrderButton)){
		waitForElement(driver, placeOrderButton);
		click(driver, placeOrderButton);
		waitForElement(driver, alertPopup);
		screenshot(driver, "RequiredErrorMessageShipping");
		click(driver, alertPopup);
	}
	
}


}
}


