package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class case2 {
    static WebDriver driver = null;
    private static By emailInput = By.xpath("//input[@id='Email']");
    private static By companyInput = By.name("Company");
    private static By dropdownInterest = By.id("Solution_Interest__c");
    private static By commentInput = By.cssSelector("#Sales_Contact_Comments__c");
    private static By tryBtn = By.linkText("Try it free");
    private static By dropdownError = By.cssSelector("select.mktoField.mktoInvalid");

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");

        driver.findElement(emailInput).sendKeys("maithianhtuyet05012002@gmail.com");
        driver.findElement(companyInput).sendKeys("ABC");
        driver.findElement(commentInput).sendKeys("Test without selecting interest");

        driver.findElement(tryBtn).click();

        try {
            WebElement errorDropdown = driver.findElement(dropdownError);
            if (errorDropdown.isDisplayed()) {
                System.out.println("Case2 passed: INTEREST dropdown validation error displayed.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Case2 failed: INTEREST dropdown validation error NOT displayed.");
        }

        driver.quit();
    }
}
}
