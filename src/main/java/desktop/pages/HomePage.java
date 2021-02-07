package desktop.pages;

import abstractClasses.page.AbstractPage;

import static driver.SingletonDriver.getDriver;

public class HomePage extends AbstractPage {

    private static final String HOME_PAGE_URL = "https://www.bookdepository.com/";

    public HomePage openHomePage(){
        getDriver().get(HOME_PAGE_URL);
        return new HomePage();
    }
}
