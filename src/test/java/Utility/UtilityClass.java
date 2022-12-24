package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UtilityClass
{
    static Select select;
    public static boolean isdisplayed(WebElement element)
    {
        return element.isDisplayed();
    }
    public static boolean isselected(WebElement element)
    {
        return element.isSelected();

    }
    public static boolean isenabled(WebElement element)
    {
        return element.isEnabled();
    }
    public static void selectbyValue(WebElement element,String value)
    {
         select = new Select(element);
        String[] str  = {"JAVA", "C#", "Python", "SQL", "Eclipse", "Maven", "TestNG", "JUnit", "HTML", "CSS",
                "JavaScript", "JQuery","Apple","Pear","Grape","Orange"};
        for(int i=0;i<str.length;i++)
        {
            if(str.equals(value))
            {
                select.selectByValue(value);
            }
        }

    }
    public static void click(WebElement element)
    {
        element.click();
    }
    public static void selectByIndex(WebElement element,int index)
    {
        select = new Select(element);
        if(index == 0)
            select.selectByIndex(0);
        else if (index == 1)
            select.selectByIndex(1);
        else if (index == 2)
            select.selectByIndex(2);
        else if (index == 3)
            select.selectByIndex(3);

    }
    public static void selectByVisible(WebElement element,String value)
    {
      select= new Select(element);
        String[] str = { "JAVA", "C#", "Python", "SQL", "Eclipse", "Maven", "TestNG", "JUnit", "HTML", "CSS",
                "JavaScript", "JQuery","Apple","Pear","Grape","Orange" };
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(value)) {
                select.selectByVisibleText(value);
            }
        }
    }
    public static  List<WebElement> options(WebElement element)
    {
        select = new Select(element);
        List<WebElement> list = select.getOptions();
        return list;

    }



}
