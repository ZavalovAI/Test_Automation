package Lesson07.a_proxy_elements_and_page_factory.f_move_locators_to_interfaces;

import org.openqa.selenium.By;

public interface LandingPageLocators {

    By searchField = By.id("search_query_top");
    By firstAdvice = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");
}
