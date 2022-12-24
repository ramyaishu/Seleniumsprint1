package tests;

import Utility.UtilityClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UtilityTest
{
    WebDriver driver;

    @BeforeTest
    public void init()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void selectDropDowncheck1()
    {
        WebElement element = driver.findElement(By.id("dropdowm-menu-1"));
        UtilityClass.selectByIndex(element,1);
        List<WebElement> list = UtilityClass.options(element);
        for (WebElement values:list)
        {
            System.out.println(values);
        }

    }
    @Test
    public void selectDropDowncheck2()
    {
        WebElement element = driver.findElement(By.id("dropdowm-menu-2"));
        UtilityClass.selectbyValue(element,"TestNG");
        List<WebElement> list = UtilityClass.options(element);
        for (WebElement values:list)
        {
            System.out.println(values);
        }

    }
    @Test
    public void selectDropDowncheck3()
    {
        WebElement element = driver.findElement(By.id("dropdowm-menu-3"));
        UtilityClass.selectByVisible(element,"HTML");
        List<WebElement> list = UtilityClass.options(element);
        for (WebElement values:list)
        {
            System.out.println(values);
        }
    }
    @Test
    public void checkCheckBox()
    {
       WebElement element =  driver.findElement(By.xpath("//input[@value='option-2']"));
        UtilityClass.click(element);
        Assert.assertTrue(element.isEnabled());
    }

    @Test
    public void checkRadioButton()
    {
        WebElement element = driver.findElement(By.xpath("//input[@value='yellow']"));
        UtilityClass.click(element);
        Assert.assertTrue(element.isSelected());
    }

 @Test
    public void checkSelectAndDisable()
    {
        WebElement element = driver.findElement(By.xpath("//input[@value='lettuce']"));
        UtilityClass.click(element);
        Assert.assertTrue(element.isSelected());
        WebElement element1 = driver.findElement(By.id("fruit-selects"));
        UtilityClass.selectByIndex(element1,3);
    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }

}
