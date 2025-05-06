package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class BookStor extends BaseClass{

    @FindBy(id = "searchBox")
    private WebElement searchBox;
    @FindBy(className = "rt-noData")
    private WebElement noElement;

    public void action() {
        searchBox.sendKeys("git Pocket");
        assertTrue(searchBox.findElements(By.xpath("//div[@class='rt-td']/img")).size()==1);
        searchBox.clear();
        searchBox.sendKeys("verySoft");
        List<WebElement>elements=searchBox.findElements(By.xpath("//div[@class='rt-td']/img"));
        assertTrue(elements.isEmpty());
        assertTrue(noElement.isDisplayed());

    }

    public List<WebElement> bookWebElementList(){
        return driver.findElements(By.className("rt-tr-group"));
    }

    public List<Book> bookList(List<WebElement> books){
        List<Book> bookList=new ArrayList<>();
        WebElement book;
        for(int i=0;i<books.size()-2;i++){
            book=books.get(i);

            bookList.add(new Book(driver.findElements(By.className("mr-2")).get(i).getText(),
                    driver.findElements(By.className("rt-td")).get(2*i+1).getText(),
                    driver.findElements(By.className("rt-td")).get(2*i+2).getText()));
        }
        return bookList;
    }
    public void printBookList(){
        List<Book> bookList=bookList(bookWebElementList());

        for(int i=0;i<bookList.size();i++){
            System.out.println(bookList.get(i).toString());
        }
    }
    }
