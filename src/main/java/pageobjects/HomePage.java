package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageobjects.constants.CreateOrderButton.DOWN_BUTTON;
import static pageobjects.constants.CreateOrderButton.UP_BUTTON;

public class HomePage {
    WebDriver driver;
    private final By homeHeader = By.className("Home_Header__iJKdX");
    private final By upOrderButton = By.className("Button_Button__ra12g");
    private final By downOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By questionsHeader = By.className("Home_FourPart__1uthg");
    private final By orderState = By.xpath(".//button[text()='Статус заказа']");
    private final By numberOrder = By.xpath(".//input[@placeholder='Введите номер заказа']");
    private final By buttonGo = By.xpath(".//button[text()='Go!']");
    private final By yandexButton = By.xpath(".//*[@alt='Yandex']");

    public static final By Question_first = By.id("accordion__heading-0");
    public static final By Question_second = By.id("accordion__heading-1");
    public static final By Question_third = By.id("accordion__heading-2");
    public static final By Question_fourth = By.id("accordion__heading-3");
    public static final By Question_fifth = By.id("accordion__heading-4");
    public static final By Question_sixth = By.id("accordion__heading-5");
    public static final By Question_seventh = By.id("accordion__heading-6");
    public static final By Question_eighth = By.id("accordion__heading-7");

    public static final By Answer_first = By.id("accordion__panel-0");
    public static final By Answer_second = By.id("accordion__panel-1");
    public static final By Answer_third = By.id("accordion__panel-2");
    public static final By Answer_fourth = By.id("accordion__panel-3");
    public static final By Answer_fifth = By.id("accordion__panel-4");
    public static final By Answer_sixth = By.id("accordion__panel-5");
    public static final By Answer_seventh = By.id("accordion__panel-6");
    public static final By Answer_eighth = By.id("accordion__panel-7");


    public static final By ITEM_ANSWER_FIRST = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-0']");
    public static final By ITEM_ANSWER_SECOND = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-1']");
    public static final By ITEM_ANSWER_THIRD = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-2']");
    public static final By ITEM_ANSWER_FOURTH = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-3']");
    public static final By ITEM_ANSWER_FIFTH = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-4']");
    public static final By ITEM_ANSWER_SIXTH = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-5']");
    public static final By ITEM_ANSWER_SEVENTH = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-6']");
    public static final By ITEM_ANSWER_EIGHTH = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-7']");


    public static final String TEXT_ANSWER_FIRST = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String TEXT_ANSWER_SECOND = "Пока что у нас так: один заказ — один самокат. " +
            "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String TEXT_ANSWER_THIRD = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
            "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
            "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String TEXT_ANSWER_FOURTH = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String TEXT_ANSWER_FIFTH = "Пока что нет! Но если что-то срочное — " +
            "всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String TEXT_ANSWER_SIXTH = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
            "даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String TEXT_ANSWER_SEVENTH = "Да, пока самокат не привезли. Штрафа не будет, " +
            "объяснительной записки тоже не попросим. Все же свои.";
    public static final String TEXT_ANSWER_EIGHTH = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания загрузки главной страницы
    public HomePage waitForLoadHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(driver -> (driver.findElement(homeHeader).getText() != null
                && !driver.findElement(homeHeader).getText().isEmpty()
        ));
        return this;
    }

    //метод ожидания загрузки ответа на вопрос
    public void waitLoadAfterClickQuestion(By accordionLabel) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(accordionLabel).getText() != null
                && !driver.findElement(accordionLabel).getText().isEmpty()
        ));
    }

    //метод прокрутки к блоку "Вопросы о важном"
    public HomePage scrollToQuestions() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsHeader));
        return this;
    }

    //метод прокрутки ко второй кнопке "Заказать"
    public HomePage scrollToDownOrderButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(downOrderButton));
        return this;
    }

    public HomePage clickUpOrderButton() {
        driver.findElement(upOrderButton).click();
        return this;
    }

    public HomePage clickDownOrderButton() {
        driver.findElement(downOrderButton).click();
        return this;
    }

    public void clickCreateOrderButton(Enum button) {
        if (button.equals(UP_BUTTON)) {
            clickUpOrderButton();
        } else if (button.equals(DOWN_BUTTON)) {
            scrollToDownOrderButton();
            clickDownOrderButton();
        }
    }

    public HomePage clickQuestion(By question) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(question))
                .click();
        return this;
    }

    public HomePage clickOrderState() {
        driver.findElement(orderState).click();
        return this;
    }

    public HomePage inputOrderNumber(String number) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(numberOrder))
                .sendKeys(number);
        return this;
    }

    public HomePage clickGo() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(buttonGo))
                .click();
        return this;
    }

    public void clickYandexButton() {
        driver.findElement(yandexButton).click();
    }
}
