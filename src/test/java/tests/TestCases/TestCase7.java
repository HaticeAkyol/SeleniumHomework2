package tests.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestCase7 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        //1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

    }
    @Test
    public void test(){
        // 2. And click on “File Upload".
        driver.findElement(By.linkText("File Upload")).click();
        // 3. Upload any file with .txt extension from your computer.
        driver.findElement(By.id("file-upload")).sendKeys("/Users/hatice akyol/Desktop/Practice");
        // 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();
        // 5. Verify that subject is: “File Uploaded!”
        WebElement Result = driver.findElement(By.xpath("//html//body//div//div//div//div//h3"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(), "File Uploaded!", "Test Failed");
        // 6. Verify that uploaded file name is displayed.
        // Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
        // Run this method against “Choose File” button.
        WebElement filename = driver.findElement(By.id("uploaded-files"));
        System.out.println(filename.getText());
        Assert.assertEquals(filename.getText(),"Practice","Test Failed");
        }
     @AfterMethod
     public void teardown(){ driver.quit();
    }
    }

