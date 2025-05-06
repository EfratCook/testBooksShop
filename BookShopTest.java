package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookShopTest extends BaseClass {
    LoginPage loginPage;
    MainPage mainPage;
    BookStor bookStor;

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
    }

    @Test
    public void loginTest() {
        loginPage.action("efi", "Ec61378!");
        mainPage.action();
    }

     @Test
     public void mainBookTest() {
         bookStor.action();
         bookStor.searchBook();
         bookStor.printAllBooks();

     }
     @AfterClass
    public void afterClass() {
        driver.quit();
     }
    }


