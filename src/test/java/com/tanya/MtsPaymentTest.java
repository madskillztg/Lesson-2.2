package com.tanya;

import com.tanya.pages.PaymentPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class MtsPaymentTest {

    private WebDriver driver;
    private PaymentPage paymentPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        paymentPage = new PaymentPage(driver)
                .open()
                .closeCookies();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void shouldShowOnlinePaymentBlock() {
        String actualTitle = paymentPage.getPaymentTitle()
                .replaceAll("\\s+", " ")
                .trim()
                .toLowerCase();

        Assertions.assertEquals(
                "онлайн пополнение без комиссии",
                actualTitle
        );
    }

    @Test
    void shouldShowCommunicationServiceFieldPlaceholders() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        "Номер телефона",
                        paymentPage.getFieldPlaceholder("connection-phone")
                ),
                () -> Assertions.assertEquals(
                        "Сумма",
                        paymentPage.getFieldPlaceholder("connection-sum")
                ),
                () -> Assertions.assertEquals(
                        "E-mail для отправки чека",
                        paymentPage.getFieldPlaceholder("connection-email")
                )
        );
    }

    @Test
    void shouldShowHomeInternetFieldPlaceholders() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        "Номер абонента",
                        paymentPage.getFieldPlaceholder("internet-phone")
                ),
                () -> Assertions.assertEquals(
                        "Сумма",
                        paymentPage.getFieldPlaceholder("internet-sum")
                ),
                () -> Assertions.assertEquals(
                        "E-mail для отправки чека",
                        paymentPage.getFieldPlaceholder("internet-email")
                )
        );
    }

    @Test
    void shouldShowInstallmentFieldPlaceholders() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        "Номер счета на 44",
                        paymentPage.getFieldPlaceholder("score-instalment")
                ),
                () -> Assertions.assertEquals(
                        "Сумма",
                        paymentPage.getFieldPlaceholder("instalment-sum")
                ),
                () -> Assertions.assertEquals(
                        "E-mail для отправки чека",
                        paymentPage.getFieldPlaceholder("instalment-email")
                )
        );
    }

    @Test
    void shouldShowDebtFieldPlaceholders() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        "Номер счета на 2073",
                        paymentPage.getFieldPlaceholder("score-arrears")
                ),
                () -> Assertions.assertEquals(
                        "Сумма",
                        paymentPage.getFieldPlaceholder("arrears-sum")
                ),
                () -> Assertions.assertEquals(
                        "E-mail для отправки чека",
                        paymentPage.getFieldPlaceholder("arrears-email")
                )
        );
    }

    @Test
    void shouldOpenPaymentWindowForCommunicationService() {
        paymentPage.fillCommunicationServiceData("297777777", "10")
                .continueCommunicationPayment();

        Assertions.assertTrue(paymentPage.isPaymentWindowDisplayed());

        paymentPage.switchToPaymentFrame();

        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        "Номер карты",
                        paymentPage.getCardNumberLabel()
                ),
                () -> Assertions.assertEquals(
                        "Срок действия",
                        paymentPage.getCardExpirationLabel()
                ),
                () -> Assertions.assertEquals(
                        "CVC",
                        paymentPage.getCardCvcLabel()
                ),
                () -> Assertions.assertEquals(
                        "ММ / ГГ",
                        paymentPage.getCardExpirationPlaceholder()
                )
        );

        Assertions.assertEquals(
                "Оплатить 10.00 BYN",
                paymentPage.getPaymentButtonText()
        );

        Assertions.assertEquals(
                "10.00 BYN",
                paymentPage.getPaymentAmount()
        );

        Assertions.assertTrue(
                paymentPage.arePaymentSystemIconsDisplayed()
        );

        Assertions.assertEquals(
                "Оплата: Услуги связи Номер:375297777777",
                paymentPage.getPaymentPhoneNumber()
        );
    }
}

