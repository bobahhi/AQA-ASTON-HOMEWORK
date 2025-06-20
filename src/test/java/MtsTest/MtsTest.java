package MtsTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class MtsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");

        try {
            WebElement acceptCookiesBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Принять')]")));
            acceptCookiesBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptCookiesBtn));
        } catch (TimeoutException e) {
            System.out.println("Кнопка куки не найдена");
        }
    }

    @Test
    public void testCheckTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")));
        System.out.println("Название заголовока: " + title.getText());
    }

    @Test
    public void testCheckPaymentLogos() {
        List<WebElement> logos = driver.findElements(
                By.xpath("//img[contains(@alt, 'Visa') or contains(@alt, 'Mastercard') or contains(@alt, 'Белкарт')]"));
        for (WebElement logo : logos) {
            System.out.println("Логотип виден: " + logo.getAttribute("src"));
        }
    }

    @Test
    public void testService() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Подробнее о сервисе")));
        link.click();
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Успешный переход по ссылке: " + currentUrl);
    }

    @Test
    public void testButtonOperation() {
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("connection-phone")));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("connection-sum")));
        amountInput.clear();
        amountInput.sendKeys("10");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Продолжить')]")));
        continueButton.click();
        System.out.println("Кнопка <Продолжить> нажата");

    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}