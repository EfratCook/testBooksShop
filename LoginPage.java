package Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "userName")
    public WebElement userName;
    @FindBy(id = "password")
    public WebElement userPassword;
    @FindBy(id = "location")
    public WebElement location;
    @FindBy(id="login")
    public WebElement loginButton;

    public void action(String username2, String password2) {
        userName.sendKeys(username2);
        userPassword.sendKeys(password2);
        loginButton.click();
    }
}

