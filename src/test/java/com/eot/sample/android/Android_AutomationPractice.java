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

public class Android_AutomationPractice {
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
        System.out.println("Start time: " + new Date().toString());
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email_create")).sendKeys("abc12243@gmail.com");
        driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
        driver.findElement(By.id("id_gender1")).click();
        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys("abcd");
        driver.findElement(By.id("customer_lastname")).sendKeys("dcba");
        driver.findElement(By.id("passwd")).sendKeys("abcabc123");
        driver.findElement(By.id("days")).click();
        {
          WebElement dropdown = driver.findElement(By.id("days"));
          dropdown.findElement(By.xpath("//option[. = 'regexp:17\\s+']")).click();
        }
        driver.findElement(By.cssSelector("#days > option:nth-child(18)")).click();
        driver.findElement(By.id("months")).click();
        {
          WebElement dropdown = driver.findElement(By.id("months"));
          dropdown.findElement(By.xpath("//option[. = 'regexp:October\\s']")).click();
        }
        driver.findElement(By.cssSelector("#months > option:nth-child(11)")).click();
        driver.findElement(By.id("years")).click();
        {
          WebElement dropdown = driver.findElement(By.id("years"));
          dropdown.findElement(By.xpath("//option[. = 'regexp:2005\\s+']")).click();
        }
        driver.findElement(By.cssSelector("#years > option:nth-child(19)")).click();
        driver.findElement(By.id("address1")).sendKeys("1234, PO 123, D LLP");
        driver.findElement(By.id("city")).sendKeys("Dallas");
        driver.findElement(By.id("id_state")).click();
        {
          WebElement dropdown = driver.findElement(By.id("id_state"));
          dropdown.findElement(By.xpath("//option[. = 'Texas']")).click();
        }
        driver.findElement(By.id("postcode")).sendKeys("01223");
        driver.findElement(By.id("phone_mobile")).sendKeys("9876543210");
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.cssSelector("#submitAccount > span")).click();
        Assert.True(driver.findElement(By.xpath("//span[contains(text(),'abcd dcba')]")).isDisplayed());
        
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