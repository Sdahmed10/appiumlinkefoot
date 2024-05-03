import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.testng.Assert.*;
import static org.openqa.selenium.By.xpath;

public class exemple extends loginbasics {
    WebDriverWait wait;

    @BeforeMethod
    public void setUpDriver() throws URISyntaxException, MalformedURLException, InterruptedException {
        AppiumTest();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    @Test(alwaysRun = true)
    public void testSuccessfulLogin() {
        System.out.println("Starting successful login test...");
        driver.findElement(accessibilityId("Se connecter")).click();

        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("vini7");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("123456Aa@");
        driver.hideKeyboard();

        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        loginButton.click();

        assertTrue(isElementPresent(xpath("//android.view.View[@content-desc=\"Communauté\"]")),
                "Login unsuccessful, 'Communauté' is not displayed on the screen.");
    }

    @Test(alwaysRun = true)
    public void testFailedLogin() {
        System.out.println("Starting failed login test...");
        driver.findElement(accessibilityId("Se connecter")).click();

        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("vini777");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("123456Aa@");
        driver.hideKeyboard();

        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        loginButton.click();

        assertTrue(isElementPresent(xpath("//android.view.View[@content-desc=\"L'adresse e-mail ou le nom d'utilisateur ne peut pas être vide\"]")),
                "Error message is not displayed on the screen. Login failed as expected.");
        System.out.println("Error message is displayed on the screen. Login failed as expected.");
    }

    @Test(alwaysRun = true)
    public void testFailedLoginemptyusername() {
        System.out.println("Starting failed login with empty username test...");
        driver.findElement(accessibilityId("Se connecter")).click();

        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("123456Aa@");
        driver.hideKeyboard();

        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        loginButton.click();

        assertTrue(isElementPresent(xpath("//android.view.View[@content-desc=\"L'adresse e-mail ou le nom d'utilisateur ne peut pas être vide\"]")),
                "Error message is not displayed on the screen. Login failed as expected.");
        System.out.println("Error message is displayed on the screen. Login failed as expected.");
    }

    @Test(alwaysRun = true)
    public void testFailedLoginemptypassword() {
        System.out.println("Starting failed login with empty password test...");
        driver.findElement(accessibilityId("Se connecter")).click();

        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("vini777");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("");

        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        loginButton.click();

        assertTrue(isElementPresent(xpath("//android.view.View[@content-desc=\"L'adresse e-mail ou le nom d'utilisateur ne peut pas être vide\"]")),
                "Error message is not displayed on the screen. Login failed as expected.");
        System.out.println("Error message is displayed on the screen. Login failed as expected.");
    }

    @Test(alwaysRun = true)
    public void testFailedLoginemptyusernameandpassword() {
        System.out.println("Starting failed login with empty username and password test...");
        driver.findElement(accessibilityId("Se connecter")).click();

        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("");

        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        loginButton.click();

        assertTrue(isElementPresent(xpath("//android.view.View[@content-desc=\"L'adresse e-mail ou le nom d'utilisateur ne peut pas être vide\"]")),
                "Error message is not displayed on the screen. Login failed as expected.");
        System.out.println("Error message is displayed on the screen. Login failed as expected.");
    }
}
