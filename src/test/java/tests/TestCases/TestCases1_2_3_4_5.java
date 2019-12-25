package tests.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCases1_2_3_4_5 {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        // 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        // 2. Click on “Registration Form”Step
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();
    }
    // 3. Enter “wrong_dob” into date of birth input box.
    @Test
    public void test1() {
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/11/190");
        // 4. Verify that warning message is displayed: “The date of birth is not valid”
        WebElement Result = driver.findElement(By.cssSelector("[data-bv-validator='date']"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(),"The date of birth is not valid","Test Failed");
    }

    @Test
    public void test2(){
        // 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
        WebElement Result = driver.findElement(By.cssSelector(".form-group:nth-of-type(11)"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(),"Select programming languages\n"+"C++\n" + "Java\n" + "JavaScript","Test Failed");

    }

    @Test
    public void test3(){
        // 3. Enter only one alphabetic character into first name input box.
        // 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
        driver.findElement(By.name("firstname")).sendKeys("a");
        WebElement Result = driver.findElement(By.cssSelector("small[data-bv-validator='stringLength']"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(),"first name must be more than 2 and less than 64 characters long","Test Failed");
        BrowserUtils.wait(3);
    }
    @Test
    public void Test4() throws InterruptedException {
        // 3. Enter only one alphabetic character into last name input box.
        // 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("b");
        WebElement Result = driver.findElement(By.cssSelector("small[data-bv-result='INVALID']:nth-of-type(2)"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(),"The last name must be more than 2 and less than 64 characters long");


    }
    @Test
    public void Test5(){
        // 3. Enter any valid first name.Step
        driver.findElement(By.cssSelector("input[name='firstname")).sendKeys("Hatice");
        // 4. Enter any valid last name.Step
        driver.findElement(By.cssSelector("input[name='lastname")).sendKeys("Akyol");
        // 5. Enter any valid user name.Step
        driver.findElement(By.cssSelector("input[name='username")).sendKeys("hatakyol");
        driver.findElement(By.cssSelector("input[name='email")).sendKeys("email@email.com");
        // 6. Enter any valid password.Step
        driver.findElement(By.cssSelector("input[name='password")).sendKeys("user1234");
        // 7. Enter any valid phone number.Step
        driver.findElement(By.cssSelector("input[name='phone")).sendKeys("571-000-0000");
        // 8. Select gender.Step
        driver.findElement(By.cssSelector("input[value='female']")).click();
        // 9. Enter any valid date of birth.Step
        driver.findElement(By.cssSelector("input[placeholder='MM/DD/YYYY']")).sendKeys("11/03/1980");
        // 10. Select any department.Step
        Select select = new Select (driver.findElement(By.cssSelector("select[name='department']")));
        select.selectByVisibleText("Accounting Office");
        // 11. Enter any job title.Step
        Select select1 = new Select (driver.findElement(By.cssSelector("select[name='job_title']")));
        select1.selectByVisibleText("Designer");
        // 12. Select java as a programming language.
        driver.findElement(By.id("inlineCheckbox1")).click();
        // 13. Click Sign up.Step
        driver.findElement(By.id("wooden_spoon")).click();
        // 14. Verify that following success message is displayed: “You've successfully completed registration!”
        WebElement Result = driver.findElement(By.tagName("p"));
        System.out.println(Result.getText());
        Assert.assertEquals(Result.getText(),"You've successfully completed registration!");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}


