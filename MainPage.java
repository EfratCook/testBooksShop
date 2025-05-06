package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(id = "gotoStore")
    public WebElement buttonToBookStor;

    public void action() {
        buttonToBookStor.click();
    }
}
