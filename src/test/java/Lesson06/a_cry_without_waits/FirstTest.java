package Lesson06.a_cry_without_waits;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.StringContains.containsString;

public class FirstTest {

    static WebDriver wd;

    @BeforeClass
    public static void setup() {
        wd = new ChromeDriver();
//        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown() {
        wd.quit();

    }
        @Ignore
        @Test
    public void verifyFirstSearchResult() {

        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).sendKeys(("Dress"));
        wd.findElement(By.id("search_query_top")).submit();
        Assert.assertTrue("First result checking...", wd.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).getText()
                .contains("Dress"));
    }

    @Test
    public void verifyFirstSearchResult02() {

        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).sendKeys(("Dress"));
        wd.findElement(By.id("search_query_top")).submit();
        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"))
                .getText(), containsString("Dress"));
    }
}

