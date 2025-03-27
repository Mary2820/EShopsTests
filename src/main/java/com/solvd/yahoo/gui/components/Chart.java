package com.solvd.yahoo.gui.components;

import com.solvd.yahoo.utils.BrowserUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.*;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.util.List;

public class Chart extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(Chart.class);
    
    @FindBy(xpath = ".//*[@data-testid='tabs-container']//button")
    private List<ExtendedWebElement> periodFilter;

    @FindBy(xpath = ".//canvas")
    private ExtendedWebElement chartCanvas;

    public Chart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectPeriod(String chartPeriodName) {
        for (ExtendedWebElement period : periodFilter) {
            String current = period.getText();
            if (current.equalsIgnoreCase(chartPeriodName)) {
                period.click();
                LOGGER.info("period is clicked");
            }
        }
    }

    public void hoverAndClickOnPointOnChart(double xPercent, double yPercent) {
        waitToLoadChartCanvas();
        chartCanvas.scrollTo();
        pause(1.0);

        Point pointOnChart = getCoordinatesForClickOnChart(chartCanvas.getElement(), xPercent, yPercent);

        Robot robot = getRobot();
        robot.mouseMove(pointOnChart.x, pointOnChart.y);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(3);
    }


    private void waitToLoadChartCanvas() {
        waitUntil(ExpectedConditions.and(
            ExpectedConditions.presenceOfElementLocated(chartCanvas.getBy()),
            ExpectedConditions.visibilityOf(chartCanvas.getElement())
        ), 10);
    }

    private Robot getRobot() {
        try {
            return new Robot();
        } catch (AWTException e) {
            LOGGER.error("Failed to initialize Robot instance", e);
        }
        return null;
    }

    private Point getCoordinatesForClickOnChart(WebElement element, double xPercent, double yPercent) {
        Rectangle rect = element.getRect();
        Long scrollY = BrowserUtils.getScrollY(getDriver());
        Long windowY = BrowserUtils.getWindowY(getDriver());

        int targetX = rect.getX() + (int)(rect.getWidth() * xPercent );
        int targetY = rect.getY() - scrollY.intValue() + windowY.intValue() + (int)(rect.getHeight() * yPercent);

        System.out.println(new Point(targetX, targetY));
        return new Point(targetX, targetY);
    }
}
