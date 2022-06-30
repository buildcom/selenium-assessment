package com.build.qa.build.selenium.CommonMethods;

import com.build.qa.build.selenium.framework.BaseFramework;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonMethods extends BaseFramework {


    public static void sendKey(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public static void waitAndClick(WebElement element){
        BaseFramework.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
