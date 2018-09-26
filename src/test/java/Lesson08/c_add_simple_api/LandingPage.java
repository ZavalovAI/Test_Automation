package Lesson08.c_add_simple_api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

import static Lesson08.c_add_simple_api.BaseTest.wd;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


class LandingPage extends BasePage implements LandingPageLocators {

       public LandingPage(WebDriver wd){
       super(wd);

        }

        void searchFor(String query) {
            $(searchField).click(); //-this text equels to: wd.findElement(By.id(search_query_top)).click();
            $(searchField).clear();
            $(searchField).sendKeys(query);
        }

        void visit(){
            navigatTo("http://automationpractice.com/index.php");
        }




        WebElement $(By locator) {
            return waitFor(visibilityOfElementLocated(locator));
        }

        WebElement $(String xpath){
            return $(By.xpath(xpath));
        }

        List<WebElement> $$(By locator){
            return waitFor(visibilityOfAllElementsLocatedBy(locator));
        }

        private <V> V waitFor(Function<? super WebDriver, V> condition){    //<V> - generics used in the method; V - method should return generic
            return (new WebDriverWait(wd, 10)).until(condition);
        }

        private <V> V waitFor(Function<? super WebDriver, V> condition, long timeout){    //<V> - generics used in the method; V - method should return generic
        return (new WebDriverWait(wd, timeout)).until(condition);
    }

    }

