package tests.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;


public class TestCase6 {
        private WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = BrowserFactory.getDriver("chrome");
            // 1. Go to "https://www.tempmailaddress.com/"Step
            driver.get("https://www.tempmailaddress.com/");
        }
    @Test
    public void test() {

        // 2. Copy and save email as a string.
        WebElement email = driver.findElement(By.cssSelector("[class='animace']"));
        String mail = email.getText();
        System.out.println(mail);
        // 3. Then go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        // 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        // 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys("Hatice");
        // 6. Enter email from the Step 2.Step
        driver.findElement(By.name("email")).sendKeys(mail);
        // 7. Click Sign Up
        driver.findElement(By.name("wooden_spoon")).click();
        // 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
        WebElement Result = driver.findElement(By.name("signup_message"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(), "Thank you for signing up. Click the button below to return to the home page.", "Test Failed");
        // 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.navigate().to("https://www.tempmailaddress.com/");
        // 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        WebElement receivedEmail =driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]"));
        System.out.println(receivedEmail.getText());
        // 11. Click on that email to open it.
        receivedEmail.click();
        // 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
        WebElement FromEmail = driver.findElement(By.id("odesilatel"));
        Assert.assertTrue(FromEmail.isDisplayed(), "do-not-reply@practice.cybertekschool.com");
        // 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        WebElement expectedMessage=driver.findElement(By.id("predmet"));
        String actualMessage ="Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertTrue(expectedMessage.isDisplayed(),"Thanks for subscribing to practice.cybertekschool.com!");
        System.out.println(expectedMessage.getText());
        }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    }

