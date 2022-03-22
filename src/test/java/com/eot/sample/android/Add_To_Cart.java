package com.eot.sample.android;

import com.eot.utils.*;
import io.appium.java_client.*;
import io.appium.java_client.remote.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.*;
import org.testng.*;
import org.testng.annotations.*;

import java.lang.reflect.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Add_To_Cart {
    private AppiumDriver driver;

    @BeforeMethod
    public void beforeMethod(Method method) {
        DriverUtils.setChromeDriverForConnectedDevice();
        driver = setupMobileWeb();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (null != driver) {
            System.out.println("Close the driver");
            driver.quit();
        }
    }


    @Test()
    public void appiumWebTest() throws InterruptedException {
    	driver.get("http://automationpractice.com/index.php");
        
        driver.findElement(By.linkext("T-shirts")).click();
        driver.findElement(By.cssSelector(".ajax_add_to_cart_button > span")).click();
        {
          WebElement element = driver.findElement(By.cssSelector(".ajax_add_to_cart_button > span"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).clickAndHold().perform();
        }
        {
          WebElement element = driver.findElement(By.cssSelector(".layer_cart_overlay"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".button-medium:nth-child(2) > span")).click();
        driver.findElement(By.cssSelector(".icon-plus")).click();
        System.out.println(driver.findElement(By.tagName("input")).getText());
        driver.findElement(By.cssSelector(".icon-trash")).click();
    }

    private AppiumDriver setupMobileWeb() {
        DesiredCapabilities dc = new DesiredCapabilities(new ChromeOptions());
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        dc.setCapability("chromedriverExecutable", System.getProperty("webdriver.chrome.driver"));

        // Open browser.
        AppiumDriver driver = null;
        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }
}