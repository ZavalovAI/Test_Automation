package Lesson07.a_proxy_elements_and_page_factory.e_add_basetest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println(String.format("Test '%s' - was Succeeded", description.getMethodName()));
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(String.format("Test '%s' - was Failed", description.getMethodName()));
            super.failed(e, description);
        }

        @Override
        protected void starting(Description description) {
            System.out.println(String.format("Test '%s' - was Started", description.getMethodName()));
            super.starting(description);
        }
    };

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

}
