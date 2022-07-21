package com.build.qa.build.selenium.CommonMethods;

import com.build.qa.build.selenium.framework.BaseFramework;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class CommonMethods extends BaseFramework {


    public static void sendKey(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public static void waitAndClick(WebElement element){
        BaseFramework.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitPageLoad(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static double getDoubleValue(String str){
      return Double.parseDouble(str);
    }


    public static  double getTotalPrice(String str){

       return  Double.parseDouble( str.substring(1, str.length()-1));


    }
}
