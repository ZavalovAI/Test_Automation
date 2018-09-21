package Lesson06.c_implicitli_waits_help_for_first_appearing;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.StringContains.containsString;

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
    public void verifyFirstSearchResult() {

        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).sendKeys(("Dress"));

            Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"))
            .getText(), containsString("Dress"));

            wd.findElement(By.id("search_query_top")).click();
            wd.findElement(By.id("search_query_top")).clear();
            wd.findElement(By.id("search_query_top")).sendKeys(("Dress"));

            Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"))
            .getText(), containsString("T-short"));
    }

}

