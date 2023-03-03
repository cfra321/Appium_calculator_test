package com.juaracoding.appium.page;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class Calculator {

    public AndroidDriver<MobileElement> driver;

    public Calculator(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Locator number
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"1\"]")
    private MobileElement btnSatu;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    private MobileElement btnDua;


    // locator aritmatika
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"plus\"]")
    private MobileElement btnTambah;

    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    private MobileElement btnSamaDengan;

    // locator result
    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    private MobileElement result;

    public void calcAdd() {
        btnSatu.click();
        btnTambah.click();
        btnDua.click();
        btnSamaDengan.click();
    }
    public String getTxtResult() {
        return result.getText();
    }

}
