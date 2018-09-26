package Lesson08.b_refactor_explicitly_waits;

import Lesson08.a_move_page_object_to_separate_class.BaseTest;
import Lesson08.a_move_page_object_to_separate_class.LandingPageLocators;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class FirstTest extends Lesson08.b_refactor_explicitly_waits.BaseTest {

    @Test
    public void verifyFirstSearchResultShouldRefresh() {
        String query1 = "Dress";
        String query2 = "T-shirt";
        LandingPage landingPage = new LandingPage(wd);
landingPage.visit();

        landingPage.searchFor(query1);
         (new WebDriverWait(wd, 10))
                .until(textToBePresentInElementLocated(landingPage.firstAdvice, query1));

        landingPage.searchFor(query2);
            (new WebDriverWait(wd, 10))
            .until(textToBePresentInElementLocated(landingPage.firstAdvice, query2));

    }

    class LandingPage implements Lesson08.b_refactor_explicitly_waits.LandingPageLocators {

         void searchFor(String query) {
            $(searchField).click(); //-this text equels to: wd.findElement(By.id(search_query_top)).click();
            $(searchField).clear();
            $(searchField).sendKeys(query);
        }

        WebElement $(By locator) {
            return wd.findElement(locator);
        }
    }

}

//*change a and b packages




