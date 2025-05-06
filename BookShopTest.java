package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookShopTest {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    BookStor bookStor;
    Book book;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        bookStor = PageFactory.initElements(driver, BookStor.class);
        book = PageFactory.initElements(driver, Book.class);
    }

    @Test
    public void test01() throws InterruptedException {
        loginPage.action("efi","Ec61378!");
        mainPage.action();
        bookStor.action();


        Thread.sleep(5000);
    }



}
