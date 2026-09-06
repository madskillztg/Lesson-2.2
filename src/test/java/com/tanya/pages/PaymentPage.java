package com.tanya.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    private static final String SITE_URL = "https://mts.by";
    private static final By COOKIE_ACCEPT_BUTTON =
            By.xpath("//button[contains(., 'Принять')]");
    private static final By PAYMENT_TITLE =
            By.cssSelector("div.pay__wrapper h2");
    private static final By CONNECTION_PHONE =
            By.id("connection-phone");
    private static final By CONNECTION_SUM =
            By.id("connection-sum");
    private static final By CONNECTION_CONTINUE_BUTTON =
            By.xpath("//button[contains(., 'Продолжить')]");

    private static final By CARD_NUMBER =
            By.id("cc-number");

    private static final By CARD_EXPIRATION =
            By.cssSelector("input[formcontrolname='expirationDate']");

    private static final By CARD_CVC =
            By.cssSelector("input[formcontrolname='cvc']");

    private static final By PAYMENT_BUTTON =
            By.cssSelector("button[type='submit']");

    private static final By PAYMENT_PHONE =
            By.xpath("//span[contains(., 'Номер:')]");

    private static final By PAYMENT_AMOUNT =
            By.xpath("//span[contains(., 'BYN')]");

    private static final By PAYMENT_SYSTEM_ICONS =
            By.cssSelector("div.cards-brands__container img");

    private static final By PAYMENT_IFRAME =
            By.cssSelector("iframe");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public PaymentPage switchToPaymentFrame() {
        wait.until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(PAYMENT_IFRAME)
        );
        return this;
    }

    public PaymentPage open() {
        driver.get(SITE_URL);
        return this;
    }

    public PaymentPage closeCookies() {
        List<WebElement> buttons = driver.findElements(COOKIE_ACCEPT_BUTTON);

        if (!buttons.isEmpty() && buttons.get(0).isDisplayed()) {
            buttons.get(0).click();
        }

        return this;
    }

    public String getPaymentTitle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(PAYMENT_TITLE)
        ).getText();
    }

    public PaymentPage fillCommunicationServiceData(
            String phoneNumber,
            String paymentAmount
    ) {
        WebElement phoneField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(CONNECTION_PHONE)
        );
        phoneField.clear();
        phoneField.sendKeys(phoneNumber);

        WebElement sumField = driver.findElement(CONNECTION_SUM);
        sumField.clear();
        sumField.sendKeys(paymentAmount);

        return this;
    }

    public PaymentPage continueCommunicationPayment() {
        wait.until(
                ExpectedConditions.elementToBeClickable(CONNECTION_CONTINUE_BUTTON)
        ).click();

        return this;
    }

    public boolean isPaymentWindowDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(PAYMENT_IFRAME)
        ).isDisplayed();
    }

    public String getFieldPlaceholder(String fieldId) {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id(fieldId))
        ).getAttribute("placeholder");
    }

    public String getCardExpirationPlaceholder() {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(CARD_EXPIRATION)
        ).getAttribute("placeholder");
    }

    public String getCardNumberLabel() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[contains(., 'Номер карты')]")
                )
        ).getText();
    }

    public String getCardExpirationLabel() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[contains(., 'Срок действия')]")
                )
        ).getText();
    }

    public String getCardCvcLabel() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[contains(., 'CVC')]")
                )
        ).getText();
    }

    public String getPaymentButtonText() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(PAYMENT_BUTTON)
                ).getText()
                .replaceAll("\\s+", " ")
                .trim();
    }

    public String getPaymentPhoneNumber() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(PAYMENT_PHONE)
                ).getText()
                .replaceAll("\\s+", " ")
                .trim();
    }

    public String getPaymentAmount() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(PAYMENT_AMOUNT)
        ).getText().trim();
    }

    public boolean arePaymentSystemIconsDisplayed() {
        List<WebElement> icons = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(PAYMENT_SYSTEM_ICONS)
        );

        return !icons.isEmpty();
    }
}




