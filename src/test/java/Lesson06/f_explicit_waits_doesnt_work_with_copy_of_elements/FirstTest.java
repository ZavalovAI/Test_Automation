package Lesson06.f_explicit_waits_doesnt_work_with_copy_of_elements;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

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
    public void verifyFirstSearchResult() throws InterruptedException{

        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).sendKeys("Dress");
        WebElement firstResult = wd.findElement(
                By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"));

            (new WebDriverWait(wd, 10))
                    .until(textToBePresentInElement(firstResult,"Dress"));

            wd.findElement(By.id("search_query_top")).click();
            wd.findElement(By.id("search_query_top")).clear();
            wd.findElement(By.id("search_query_top")).sendKeys("t-shirts");

            (new WebDriverWait(wd, 10))
                    .until(textToBePresentInElement(firstResult,
                            "T-shirts"));


    }

}

