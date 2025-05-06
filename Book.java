package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Book {
    WebDriver driver;
    private String publisher;
    private String author;
    private String title;

    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }


    public String toString() {
        return "title" +title + "author:" + author + "publisher:"+publisher;
    }

}
