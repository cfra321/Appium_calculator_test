package com.juaracoding.appium;

import java.net.MalformedURLException;
import java.net.URL;
import com.juaracoding.appium.page.Calculator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestCalculator {

    private static AndroidDriver<MobileElement> driver;
    private Calculator calculator;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_2_API_24");
        capabilities.setCapability("uuid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @BeforeMethod
    public void pageObject(){
        calculator=new Calculator(driver);
    }
    @Test
    public void testAdd(){
        calculator.calcAdd();
        System.out.println("Hasil = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(),"3");
        calculator.clear();
    }

    @Test
    public void testSub() {
        calculator.calcSubtraction();
        System.out.println("Hasil = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(),"1");
        calculator.clear();
    }
    @Test
    public void testdiv() {
        calculator.calcDivision();
        System.out.println("Hasil = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(),"2");
        calculator.clear();
    }

    @Test
    public void testMul() {
        calculator.calcMultiplication();
        System.out.println("Hasil = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(),"8");
        calculator.clear();
    }
    @AfterClass
    public void closeApp() {
        driver.quit();
    }


}