package com.solvd.yahoo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class BrowserUtils {
    public static Long getScrollY(WebDriver driver) {
        return (Long) ((JavascriptExecutor) driver)
                .executeScript("return window.scrollY;");
    }

    public static Long getWindowY(WebDriver driver) {
        return (Long) ((JavascriptExecutor) driver)
                .executeScript("return window.screenY;");
    }
} 