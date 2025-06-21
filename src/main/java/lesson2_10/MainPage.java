package lesson2_10;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.*;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By acceptCookiesBtn = By.xpath("//button[contains(text(), 'Принять')]");
    private final By cookieBanner = By.cssSelector(".cookie.show");
    private final By selectHeader = By.cssSelector(".select__header");
    private final By payTabs = By.cssSelector(".select__option");
    private final By activeForm = By.cssSelector(".pay-form.opened input[placeholder]");

    private final By phoneInput = By.id("connection-phone");
    private final By amountInput = By.id("connection-sum");
    private final By continueButton = By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesBtn));
            btn.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieBanner));
        } catch (TimeoutException _) {

        }
    }

    public void selectPaymentTab(String tabName) {
        driver.findElement(selectHeader).click();
        List<WebElement> tabs = driver.findElements(payTabs);
        for (WebElement tab : tabs) {
            if (tab.getText().trim().equals(tabName)) {
                tab.click();
                break;
            }
        }
    }

    public Map<String, String> getCurrentFormPlaceholders() {
        Map<String, String> placeholders = new HashMap<>();
        List<WebElement> inputs = driver.findElements(activeForm);
        for (WebElement input : inputs) {
            String id = input.getAttribute("id");
            String placeholder = input.getAttribute("placeholder");
            placeholders.put(id, placeholder);
        }
        return placeholders;
    }

    public void fillServiceConnectionForm(String phone, String amount) {
        selectPaymentTab("Услуги связи");
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).clear();
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(amountInput).clear();
        driver.findElement(amountInput).sendKeys(amount);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();

    }
}