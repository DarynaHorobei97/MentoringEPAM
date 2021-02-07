package abstractClasses.fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WebDriverWaiter;

import static driver.SingletonDriver.getDriver;

public abstract class AbstractFragment extends WebDriverWaiter {

    private WebElement rootElement;


    public AbstractFragment() {

//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            getDriver().quit();
//        }));
        PageFactory.initElements(getDriver(), this);
    }

    public void setRootElement(WebElement element) {
        this.rootElement = element;
    }

    public WebElement getRootElement() {
        return rootElement;
    }

    public AbstractFragment selectElementByVisibleText(By locator, String text) {
        new Select(getDriver().findElement(locator)).selectByVisibleText(text);
        return this;
    }

    public AbstractFragment inputTextIntoField(By locator, String text) {
        getDriver().findElement(locator).sendKeys(text);
        return this;
    }

    public AbstractFragment clickOnButton(By locatorOfButton) {
        getDriver().findElement(locatorOfButton).click();
        return this;
    }

}
