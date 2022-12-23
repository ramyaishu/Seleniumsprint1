import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TakeScreenShot
{
    WebDriver driver;

    @Test
    public void screenShot() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[text()='Store']")).click();
        takeScreenshot();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[text()='About']")).click();
        takeScreenshot();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[text()='Gmail']")).click();
        takeScreenshot();
        driver.navigate().back();

    }

    private void takeScreenshot() throws IOException {
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
        String date =  simpleDateFormat.format(d);
        TakesScreenshot shot = (TakesScreenshot) driver;
        File file = shot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("./screenshots/"+date+".png"));
    }
    @Test
    public void tearDown()
    {
        driver.close();
    }
}
