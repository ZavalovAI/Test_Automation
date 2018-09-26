package Lesson08.a_move_page_object_to_separate_class;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class FirstTest extends BaseTest {

    @Test
    public void verifyFirstSearchResultShouldRefresh() {
        String query1 = "Dress";
        String query2 = "T-shirt";
        LandingPage landingPage = new LandingPage(wd);

        landingPage.visit();

        landingPage.searchFor(query1);
        assertThat(textToBePresentInElementLocated(landingPage.firstAdvice, query1));

        landingPage.searchFor(query2);
        assertThat(textToBePresentInElementLocated(landingPage.firstAdvice, query2),15);

    }

    void assertThat(ExpectedCondition<Boolean> condition){
//        (new WebDriverWait(wd, 10))
//                .until(condition);
        assertThat(condition, 10);
    }
    void assertThat(ExpectedCondition<Boolean> condition, long timeout){
        (new WebDriverWait(wd, 10))
                .until(condition);
    }



}

