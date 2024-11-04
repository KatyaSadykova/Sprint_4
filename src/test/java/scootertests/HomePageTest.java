package scootertests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.HomePage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HomePageTest {
    private WebDriver driver;
    private final String site = "https://qa-scooter.praktikum-services.ru/";
    private final By question;
    private final By answer;
    private final By labelResult;
    private final String expected;

    public HomePageTest(By question, By answer, By labelResult, String expected) {
        this.question = question;
        this.answer = answer;
        this.labelResult = labelResult;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {

        return new Object[][]{
                {HomePage.Question_first, HomePage.Answer_first, HomePage.ITEM_ANSWER_FIRST, HomePage.TEXT_ANSWER_FIRST},
                {HomePage.Question_second, HomePage.Answer_second, HomePage.ITEM_ANSWER_SECOND, HomePage.TEXT_ANSWER_SECOND},
                {HomePage.Question_third, HomePage.Answer_third, HomePage.ITEM_ANSWER_THIRD, HomePage.TEXT_ANSWER_THIRD},
                {HomePage.Question_fourth, HomePage.Answer_fourth, HomePage.ITEM_ANSWER_FOURTH, HomePage.TEXT_ANSWER_FOURTH},
                {HomePage.Question_fifth, HomePage.Answer_fifth, HomePage.ITEM_ANSWER_FIFTH, HomePage.TEXT_ANSWER_FIFTH},
                {HomePage.Question_sixth, HomePage.Answer_sixth, HomePage.ITEM_ANSWER_SIXTH, HomePage.TEXT_ANSWER_SIXTH},
                {HomePage.Question_seventh, HomePage.Answer_seventh, HomePage.ITEM_ANSWER_SEVENTH, HomePage.TEXT_ANSWER_SEVENTH},
                {HomePage.Question_eighth, HomePage.Answer_eighth, HomePage.ITEM_ANSWER_EIGHTH, HomePage.TEXT_ANSWER_EIGHTH},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(site);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void checkQuestionsTest() {
        new HomePage(driver)
                .waitForLoadHomePage()
                .scrollToQuestions()
                .clickQuestion(question)
                .waitLoadAfterClickQuestion(labelResult);
        String result = driver.findElement(answer).getText();

        assertEquals(expected, result);
    }
}