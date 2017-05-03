/*
 * Copyright 2014-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * A page for alerts as sample
 */
public class AlertPage extends BasePage {
    /**
     * The alert button
     */
//    @AndroidFindBy(name = "ALERT")
//    private MobileElement alertButton;
//
//    /**
//     * The toast button
//     */
//    @AndroidFindBy(name = "TOAST")
//    private MobileElement toastButton;

    
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"co.go.fynd:id/button_facebook\")")
	MobileElement FbButton;
    
    @AndroidFindBy(id="co.go.fynd:id/button_facebook")
    MobileElement facebookButton;
    
    @AndroidFindBy(id="com.android.chrome:id/terms_accept")
    MobileElement chromeAcceptButton; 
    
    @AndroidFindBy(id="com.android.chrome:id/negative_button")
    MobileElement chromeNoThanksButton;
    
    
    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.EditText\").instance(0)")
    MobileElement fbusername; 
    
    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"u_0_2\")")
    MobileElement password;
    
    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"u_0_6\")")
    MobileElement logIn;
    
    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    MobileElement FbAuthroization;
    
    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    MobileElement FbContinue;
    
    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"co.go.fynd:id/dialog_right_btn\")")
    MobileElement allowContactAccess;
  
    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\new UiSelector().resourceId(\"co.go.fynd:id/offer_image\")\")")
    MobileElement selectBanner;
    
    protected   Wait<WebDriver> wait;
    
    public AlertPage(AppiumDriver driver) {
        super(driver);
    }

//    /**
//     * Toast isn't directly supported by Appium. The recommended way is to
//     * take a screen shot and use a OCR program to read the toast content
//     */
//    public void clickToastButton() {
//        toastButton.click();
//    }

//    /**
//     * clicks the alert button
//     */
//    public void clickAlertsButton() {
//        alertButton.click();
//    }
 
    /**
     * clicks the facebook button
     * @throws InterruptedException 
     */
    public void clickFacebookButton() throws InterruptedException {
    	//waitgetForPageLoadAndroid(30).until(ExpectedConditions.presenceOfElementLocated(FbButton)).click();
    	facebookButton.click();
    	Thread.sleep(2000);
    	awsNexusMachineSetup();
    	
    	//localMachineSetup();
    	//allowContactAccess.click();
    	//Thread.sleep(3000);
    	//selectBanner();
    	//scroll(3);
    	//waitgetForPageLoadAndroid(30).until(ExpectedConditions.presenceOfElementLocated())
    }
    
    protected void awsNexusMachineSetup() throws InterruptedException{
    	chromeAcceptButton.click();
    	Thread.sleep(2000);
    	chromeNoThanksButton.click();
    	Thread.sleep(2000);
    	fbusername.sendKeys("pramod.kumar03@exclusively.com");
    	Thread.sleep(2000);
    	password.sendKeys("ah@2305208606");
    	Thread.sleep(2000);
    	logIn.click();
    	Thread.sleep(6000);
    	FbAuthroization.click();
    	Thread.sleep(5000);
    	FbContinue.click();
    	Thread.sleep(15000);
    	allowContactAccess.click();

    }
    
    
    
    protected void localMachineSetup() throws InterruptedException{
    	//chromeAcceptButton.click();
    	//Thread.sleep(2000);
    	//chromeNoThanksButton.click();
    	//Thread.sleep(2000);
    	//waitgetForPageLoadAndroid(30).until(ExpectedConditions.presenceOfElementLocated(fbusername));
    	fbusername.sendKeys("pramod.kumar03@exclusively.com");
    	Thread.sleep(2000);
    	password.sendKeys("ah@2305208606");
    	Thread.sleep(2000);
    	logIn.click();
    	Thread.sleep(6000);
    	FbAuthroization.click();
    	Thread.sleep(5000);
    	FbContinue.click();
    	Thread.sleep(15000);
    	allowContactAccess.click();

    }
    
	protected void scroll(int times) throws InterruptedException{
		
		Dimension dimensions = driver.manage().window().getSize();
		double screenHeightStart = (int) (dimensions.getHeight()*0.3 );
		int scrollStart = (int)screenHeightStart;
		double screenHeightEnd = (dimensions.getHeight()*0.1);
		int scrollEnd = (int)screenHeightEnd;
		for (int i = 1; i <= times; i++) {
			Thread.sleep(1000L);
			driver.swipe(0,scrollStart,0,scrollEnd,2000);
			System.out.println("scrolled : "+ i);
			
		}	
	}
	
	protected  Wait<WebDriver> waitgetForPageLoadAndroid(long waitTime){
		 try{
			wait = new WebDriverWait(driver, waitTime);
		}catch(Exception e) {
			
		}
		return wait;
	}
	
	protected void selectBanner() throws InterruptedException{
		//clicked on the first  banner
    	selectBanner.click();
		System.out.println("clicked on the first product");
		scroll(1);
	}
	
    
//	protected  Wait<WebDriver> waitgetForPageLoadAndroid(long waitTime){
//		 try{
//			wait = new WebDriverWait(driver, waitTime);
//		}catch(Exception e) {
//			
//		}
//		return wait;
//	}
    

    /**
     *
     * @return the message within the alert
     */
    public String getAlertText() {
        MobileElement alertMessage = (MobileElement) driver.findElementsByClassName("android.widget.TextView").get(1);
        return alertMessage.getText();
    }

//    /**
//     * accepts the alert
//     */
//    public void acceptAlertMessage() {
//        MobileElement alertOkButton = (MobileElement) driver.findElementsByClassName("android.widget.Button").get(0);
//        alertOkButton.click();
//    }
}