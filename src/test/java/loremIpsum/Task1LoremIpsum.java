package loremIpsum;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task1LoremIpsum {

    private WebDriver driver;

    @BeforeTest
    public void profileSetup(){
        System.setProperty("webdriver.chrome.driver" , "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://lipsum.com/");
    }

    @Test(priority = 1)
    public void checkThatParagraphContainsSearchWord() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Pyccкий']")).click();
        String firstElement = driver.findElement(xpath("(//div[@id='Panes']/child::div/child::p)[1]")).getText();
        assertTrue(firstElement.contains("рыба"));
    }

    @Test(priority = 2)
    public void checkThatParagraphStartsWithPhrase() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String firstParagraph = driver.findElement(xpath("//div[@id='lipsum']/p[1]")).getText();
        System.out.println(firstParagraph);
        assertTrue(firstParagraph.startsWith("Lorem ipsum dolor sit amet, consectetur adipiscing elit"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
