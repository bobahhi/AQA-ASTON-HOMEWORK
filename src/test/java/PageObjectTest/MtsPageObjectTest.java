package PageObjectTest;


import lesson2_10.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtsPageObjectTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("https://www.mts.by/");
        mainPage.acceptCookiesIfPresent();
    }

    @Test
    public void testPlaceholdersInAllTabs() {
        Map<String, Map<String, String>> expectedPlaceholders = Map.of(
                "Услуги связи", Map.of(
                        "connection-phone", "Номер телефона",
                        "connection-sum", "Сумма",
                        "connection-email", "E-mail для отправки чека"),
                "Домашний интернет", Map.of(
                        "internet-phone", "Номер абонента",
                        "internet-sum", "Сумма",
                        "internet-email", "E-mail для отправки чека"),
                "Рассрочка", Map.of(
                        "score-instalment", "Номер счета на 44",
                        "instalment-sum", "Сумма",
                        "instalment-email", "E-mail для отправки чека"),
                "Задолженность", Map.of(
                        "score-arrears", "Номер счета на 2073",
                        "arrears-sum", "Сумма",
                        "arrears-email", "E-mail для отправки чека"));

        for (String tabName : expectedPlaceholders.keySet()) {
            mainPage.selectPaymentTab(tabName);
            Map<String, String> actualPlaceholders = mainPage.getCurrentFormPlaceholders();
            Map<String, String> expected = expectedPlaceholders.get(tabName);
            assertEquals(expected, actualPlaceholders, "Плейсхолдеры не совпадают для вкладки: " + tabName);
        }
    }

    @Test
    public void testPaymentModalForServices() {
        mainPage.fillServiceConnectionForm("297777777", "10");
        mainPage.clickContinue();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}