package com.katarina.pages.pages.flightreservation;

import com.katarina.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightConfirmationPage extends AbstractPage {
    public FlightConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log= LoggerFactory.getLogger(FlightConfirmationPage.class);

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationElement));
        return this.flightConfirmationElement.isDisplayed();
    }

    @FindBy(css = "#flights-confirmation-section > div > div > div > form > div > div > div:nth-child(1) > div:nth-child(2) > p")
    private WebElement flightConfirmationElement;

    @FindBy(css = "#flights-confirmation-section > div > div > div > form > div > div > div:nth-child(3) > div:nth-child(2) > p")
    private WebElement totalPriceElement;

    public String getPrice() {
        String confirmation=this.flightConfirmationElement.getText();
        String price=this.totalPriceElement.getText();
        log.info("Flight confirmation number : {}",confirmation);
        log.info("Total price : {}",price);
        return price;
    }
}
