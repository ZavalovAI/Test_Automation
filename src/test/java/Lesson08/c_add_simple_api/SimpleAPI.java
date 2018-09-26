package Lesson08.c_add_simple_api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.function.Function;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class simpleAPI {

    abstract WebDriver getWebDriver();

    void navigateTo(String url){

        wd.get(url);
    }


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

    private <V> V waitFor(Function<? super WebDriver, V> condition){
        return (new WebDriverWait(wd, 10)).until(condition);
    }

    private <V> V waitFor(Function<? super WebDriver, V> condition, long timeout) {
        return (new WebDriverWait(wd, timeout)).until(condition);


    void assertThat(ExpectedCondition<Boolean> condition) {
//        (new WebDriverWait(wd, 10))
//                .until(condition);
        assertThat(condition, 10);
    }

    void assertThat(ExpectedCondition<Boolean> condition, long timeout) {
        (new WebDriverWait(wd, 10))
                .until(condition);

    }
}