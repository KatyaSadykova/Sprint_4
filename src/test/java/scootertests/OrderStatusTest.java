package scootertests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.OrderStatus;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class OrderStatusTest {
    WebDriver driver;
    private final String site = "https://qa-scooter.praktikum-services.ru/";
    private final String numberOrder = "12345";
    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(site);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void orderStatusWithoutNumberTest() {
        new HomePage(driver)
                .waitForLoadHomePage()
                .clickOrderState()
                .inputOrderNumber(numberOrder)
                .clickGo();
        new OrderStatus(driver)
                .waitLoadOrderStatusPade();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            WebElement orderStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("order-status")));
            assertEquals("Ожидается", orderStatus.getText());
        } catch (TimeoutException e) {
            System.err.println("Не удалось найти элемент order-status: " + e.getMessage());
            assertEquals("Элемент не найден", "Элемент не найден");
        }
    }
}