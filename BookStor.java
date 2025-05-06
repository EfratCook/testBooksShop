package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class BookStor extends BaseClass {

    @FindBy(id = "searchBox")
    private WebElement searchBox;
    @FindBy(className = "rt-noData")
    private WebElement notFoundMessage;

    public void action() {
        searchBox.clear();
        searchBox.sendKeys("git Pocket");

        List<WebElement> foundBooks = driver.findElements(By.xpath("//div[@class='rt-td']/img"));
        assertTrue(foundBooks.size() == 1, "Expected exactly one book ");

        searchBox.clear();
        searchBox.sendKeys("verySoft");

        List<WebElement> notFound = driver.findElements(By.xpath("//div[@class='rt-td']/img"));
        assertTrue(notFound.isEmpty(), "Expected no books found");

        assertTrue(notFoundMessage.isDisplayed(), "Expected 'no data' message to be displayed");
    }

    public void searchBook() {
        searchBox.click();
        String searchBook = searchBox.getAttribute("value");
        for (int i = 0; i < searchBook.length(); i++) {
            searchBox.sendKeys(Keys.BACK_SPACE);
        }
    }

    public List<WebElement> WebElementListOfBooks() {
        return driver.findElements(By.className("rt-tr-group"));
    }

    public List<Book> arrayListOfBook(List<WebElement> books) {
        List<Book> bookList = new ArrayList<>();
        WebElement book;
        try {
            for (int i = 0; i < books.size() - 2; i++) {
                book = books.get(i);
                bookList.add(
                        new Book(
                                driver.findElements(By.className("mr-2")).get(i).getText(),
                                driver.findElements(By.className("rt-td")).get(2 * i + 1).getText(),
                                driver.findElements(By.className("rt-td")).get(2 * i + 2).getText()));
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return bookList;
    }

    public void printAllBooks() {
        List<Book> bookList = arrayListOfBook(WebElementListOfBooks());
        System.out.println("-------------My book list-----------------");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println();
            System.out.println(bookList.get(i).toString());
        }
    }
}

