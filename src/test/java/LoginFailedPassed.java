import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.testng.Assert.*;
import static org.openqa.selenium.By.xpath;

public class LoginFailedPassed extends loginbasics {
WebDriverWait wait;
    @BeforeMethod
    public void setUpDriver() throws URISyntaxException, MalformedURLException, InterruptedException {
        AppiumTest();
        wait =  new WebDriverWait(driver, Duration.ofSeconds(30));

    }
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    @Test (alwaysRun = true)
    public void testSuccessfulLogin() throws InterruptedException{
        System.out.println("Starting successful login test...");
        driver.findElement(accessibilityId("Se connecter")).click();
        // Entrez les éléments de l'interface utilisateur pour le login avec succès
        System.out.println("Entering username and password...");
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("vini7");
        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("123456Aa@");
        driver.hideKeyboard();
        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        // Cliquer sur le bouton de connexion
        loginButton.click();
        // Ajoutez vos assertions ici pour vérifier que vous êtes connecté avec succès
        //System.out.println("Checking if 'Communauté' is displayed...");
        assertTrue(driver.findElement(xpath("//android.view.View[@content-desc=\"Communauté\"]"))
                .isDisplayed(), "Login unsuccessful, 'communauté' is not displayed on the screen.");

    }
    @Test (alwaysRun = true)
    public void testFailedLogin() throws InterruptedException {
        System.out.println("Starting failed login test...");
        driver.findElement(accessibilityId("Se connecter")).click();
        // Entrez les éléments de l'interface utilisateur pour le login échoué
        System.out.println("Entering invalid username and password...");
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("vini777");
        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("123456Aa@");
        driver.hideKeyboard();
        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        // Cliquer sur le bouton de connexion
        loginButton.click();
        // Ajoutez vos assertions ici pour vérifier que la connexion a échoué
        boolean isErrorMessageDisplayed = isElementPresent(accessibilityId("Utilisateur non inscrit ou non vérifié"));
        assertTrue(isErrorMessageDisplayed, "Error message is not displayed on the screen. Login failed as expected.");
        System.out.println("Error message is displayed on the screen. Login failed as expected.");
    }
    @Test (alwaysRun = true)
    public void testFailedLoginemptyusername() throws InterruptedException {
        System.out.println("Starting failed login with empty username test...");
        driver.findElement(accessibilityId("Se connecter")).click();
        // Entrez les éléments de l'interface utilisateur pour le login échoué
        System.out.println("Entering empty username...");
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("");
        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("123456Aa@");
        driver.hideKeyboard();
        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        // Cliquer sur le bouton de connexion
        loginButton.click();
        // Ajoutez vos assertions ici pour vérifier que la connexion a échoué
        boolean isErrorMessageDisplayed = isElementPresent(accessibilityId("L'adresse e-mail ou le nom d'utilisateur ne peut pas être vide"));
        assertTrue(isErrorMessageDisplayed, "Error message is not displayed on the screen. Login failed as expected.");
        System.out.println("Error message is displayed on the screen. Login failed as expected.");
    }
    @Test (alwaysRun = true)
    public void testFailedLoginemptypassword() throws InterruptedException {
        System.out.println("Starting failed login with empty password test...");
        driver.findElement(accessibilityId("Se connecter")).click();
        // Entrez les éléments de l'interface utilisateur pour le login échoué
        System.out.println("Entering invalid username and empty password...");
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("vini777");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("");
        driver.hideKeyboard();
        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        // Cliquer sur le bouton de connexion
        loginButton.click();
        // Ajoutez vos assertions ici pour vérifier que la connexion a échoué
        boolean isErrorMessageDisplayed = isElementPresent(accessibilityId("Veuillez saisir le mot de passe"));
        assertTrue(isErrorMessageDisplayed, "Error message is not displayed on the screen. Login failed as expected.");
        System.out.println("Error message is displayed on the screen. Login failed as expected.");
    }
    @Test (alwaysRun = true)
    public void testFailedLoginemptyusernameandpassword() throws InterruptedException {
        System.out.println("Starting failed login with empty username and password test...");
        driver.findElement(accessibilityId("Se connecter")).click();
        // Entrez les éléments de l'interface utilisateur pour le login échoué
        System.out.println("Entering empty username and empty password...");
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("");
        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("");
        driver.hideKeyboard();
        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        // Cliquer sur le bouton de connexion
        loginButton.click();
        // Ajoutez vos assertions ici pour vérifier que la connexion a échoué
        boolean isErrorMessageDisplayed = isElementPresent(accessibilityId("Veuillez saisir le mot de passe"));
        assertTrue(isErrorMessageDisplayed, "Error message is not displayed on the screen. Login failed as expected.");
        System.out.println("Error message is displayed on the screen. Login failed as expected.");
    }
    }



