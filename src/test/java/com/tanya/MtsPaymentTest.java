package com.tanya;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class MtsPaymentTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void openSite() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mts.by");
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }

    @Test
    void shouldShowOnlinePaymentBlock() {
        closeCookies();

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div.pay__wrapper h2")
                )
        );

        String actualText = title.getText()
                .replaceAll("\\s+", " ")
                .trim()
                .toLowerCase();

        Assertions.assertEquals(
                "онлайн пополнение без комиссии",
                actualText
        );
    }

    @Test
    void shouldShowPaymentSystemLogos() {
        closeCookies();

        var logos = driver.findElements(
                By.cssSelector("div.pay__partners img")
        );

        Assertions.assertFalse(
                logos.isEmpty(),
                "Логотипы платежных систем не найдены"
        );

        for (WebElement logo : logos) {
            Assertions.assertTrue(
                    logo.isDisplayed(),
                    "Один из логотипов не отображается"
            );
        }
    }

    @Test
    void shouldOpenServiceInformation() {
        closeCookies();

        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Подробнее о сервисе")
                )
        );

        String oldUrl = driver.getCurrentUrl();

        link.click();

        wait.until(
                ExpectedConditions.not(
                        ExpectedConditions.urlToBe(oldUrl)
                )
        );

        Assertions.assertTrue(
                driver.getCurrentUrl().contains("/help/")
        );
    }

    @Test
    void shouldContinueCommunicationServicePayment() {
        closeCookies();

        WebElement phoneInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("connection-phone")
                )
        );

        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement amountInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("connection-sum")
                )
        );

        amountInput.clear();
        amountInput.sendKeys("10");

        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(., 'Продолжить')]")
                )
        );

        Assertions.assertTrue(
                continueButton.isDisplayed(),
                "Кнопка «Продолжить» не отображается"
        );

        continueButton.click();

        Assertions.assertTrue(
                driver.getPageSource().contains("Оплата"),
                "После нажатия «Продолжить» информация об оплате не появилась"
        );
    }

    private void closeCookies() {
        var buttons = driver.findElements(
                By.xpath("//button[contains(., 'Принять')]")
        );

        if (!buttons.isEmpty() && buttons.get(0).isDisplayed()) {
            buttons.get(0).click();
        }
    }
}

