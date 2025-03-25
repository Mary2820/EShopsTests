package com.solvd.yahoo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.locks.Condition;

public class Tooltip extends AbstractUIObject {
    @FindBy(xpath = ".//tr[1]/td[1]")
    private ExtendedWebElement dateField;

    @FindBy(xpath = "//tr[2]")
    private ExtendedWebElement closeField;

    @FindBy(xpath = "//tr[3]")
    private ExtendedWebElement openField;

    @FindBy(xpath = "//tr[4]")
    private ExtendedWebElement highField;

    @FindBy(xpath = "//tr[5]")
    private ExtendedWebElement lowField;

    @FindBy(xpath = "//tr[6]")
    private ExtendedWebElement volumeField;

    public Tooltip(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getDateFieldName() {
        waitUntil(ExpectedConditions.visibilityOf(dateField), 10);
        return dateField.getText();
    }

    public String getCloseFieldName() {
        return closeField.getText();
    }

    public String getOpenFieldName() {
        return openField.getText();
    }

    public String getHighFieldName() {
        return highField.getText();
    }

    public String getLowFieldName() {
        return lowField.getText();
    }

    public String getVolumeFieldName() {
        return volumeField.getText();
    }
}
