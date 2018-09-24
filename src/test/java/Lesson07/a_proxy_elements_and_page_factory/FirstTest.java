package Lesson07.a_proxy_elements_and_page_factory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class FirstTest {

    static WebDriver wd;

    @BeforeClass
    public static void setup() {
        wd = new ChromeDriver();
        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().setSize(new Dimension(1920, 1080));

    }

    @AfterClass
    public static void tearDown() {
        wd.quit();

    }

    @Test
    public void verifyFirstSearchResultShouldRefresh() {
        String query1 = "Dress";
        String query2 = "T-shirt";
        LandingPage landingPage = new LandingPage();

        landingPage.searchFor(query1);
            (new WebDriverWait(wd, 10))
            .until(textToBePresentInElement(landingPage.firstAdvice, query1));

        landingPage.searchFor(query2);
            (new WebDriverWait(wd, 10))
            .until(textToBePresentInElement(landingPage.firstAdvice, query2));

    }

     class LandingPage {

        @FindBy (id = "search_query_top")
        WebElement searchField;

        @FindBy (xpath = "//*[@id=\"index\"]/div[2]/ul/li[1]")
        WebElement firstAdvice;

         public LandingPage() {
             PageFactory.initElements(wd, this);
         }

         void searchFor(String query) {
            searchField.click(); //-this text equels to: wd.findElement(By.id(search_query_top)).click();
            searchField.clear();
            searchField.sendKeys(query);

        }

    }

}

