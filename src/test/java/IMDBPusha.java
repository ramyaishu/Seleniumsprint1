import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class IMDBPusha
{
     WebDriver driver;

     @BeforeTest
     public void init()
     {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

     }

    @Test
    public void testIMDB() throws IOException
    {
        driver.get("https://www.imdb.com/");
        driver.findElement(By.xpath("//input[@id='suggestion-search']")).sendKeys("Pusha_The Rise", Keys.ENTER);
        driver.findElement(By.xpath("//a[text()='Pushpa: The Rise - Part 1']")).click();
        WebElement title = driver.findElement(By.xpath("//h1[text()='Pushpa: The Rise - Part 1']"));
        System.out.println(title.getText());
        WebElement element = driver.findElement(By.xpath("//span[text()='Box office']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        System.out.println(element.getText());
    }

    @Test
    public void testWiki()
    {
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("Pushpa: The Rise",Keys.ENTER);
        WebElement title = driver.findElement(By.xpath("//i[text()='Pushpa: The Rise'][1]"));
        System.out.println(title.getText());
        WebElement releaseDate = driver.findElement(By.xpath("//div[@class='plainlist']//li//child::span//parent::li"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",releaseDate);
        System.out.println(releaseDate.getText());
        WebElement e= driver.findElement(By.linkText("India"));
        js.executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();

    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }


}
