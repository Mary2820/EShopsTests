package com.solvd.yahoo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Chart extends AbstractUIObject {
    @FindBy(xpath = "//*[@data-testid='tabs-container']//button")
    private List<ExtendedWebElement> periodFilter;

    public Chart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = ".//canvas")
    private ExtendedWebElement chartCanvas;

    public void selectPeriod(String chartPeriodName) {
        for (ExtendedWebElement period : periodFilter) {
            String current = period.getText();
            if (current.equalsIgnoreCase(chartPeriodName)) {
                period.click();
            }
        }
    }

    public void hoverChartAndCheckTooltip(double xPercent, double yPercent) {
        waitToLoadChartCanvas();
        int width = chartCanvas.getSize().getWidth();
        int height = chartCanvas.getSize().getHeight();
        
        int x = (int)(width * xPercent);
        int y = (int)(height * yPercent);
        
        Actions actions = new Actions(getDriver());
        actions.moveToElement(chartCanvas.getElement(), x, y).perform();
    }

    private void waitToLoadChartCanvas() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(chartCanvas.getBy()), 10);
    }
}
