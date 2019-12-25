package tests.TestCases;

import utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        // 1. Go to “https://practice-cybertekschool.herokuapp.com”Step
        driver.get("https://practice-cybertekschool.herokuapp.com");
    }
     @Test
     public void test(){
        // 2. And click on “Autocomplete”.
         driver.findElement(By.linkText("Autocomplete")).click();
        // 3. Enter “United States of America” into country input box.
         driver.findElement(By.id("myCountry")).sendKeys("United States of America");
         driver.findElement(By.cssSelector("input[type='button']")).click();
        // 4. Verify that following message is displayed: “You selected: United States of America”
        WebElement Result = driver.findElement(By.id("result"));
        System.out.println(Result.getText());
         Assert.assertEquals(Result.getText(),"You selected: United States of America","Test Failed");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}




