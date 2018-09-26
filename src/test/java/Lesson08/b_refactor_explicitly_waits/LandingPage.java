package Lesson08.b_refactor_explicitly_waits;

import Lesson08.a_move_page_object_to_separate_class.LandingPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


class LandingPage implements LandingPageLocators {

    private WebDriver wd;

    LandingPage(WebDriver wd) {
        this.wd = wd;
    }

    void searchFor(String query) {
        $(searchField).click(); //-this text equels to: wd.findElement(By.id(search_query_top)).click();
        $(searchField).clear();
        $(searchField).sendKeys(query);
    }

    void visit(){
        wd.get("http://automationpractice.com/index.php");
    }

    WebElement $(By locator) {
        return wd.findElement(locator);
    }
}

