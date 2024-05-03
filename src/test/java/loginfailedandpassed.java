import io.appium.java_client.AppiumBy;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.xpath;

public class loginfailedandpassed extends loginbasics {



    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        driver.findElement(accessibilityId("Se connecter")).click();
// Entrez les éléments de l'interface utilisateur pour le login avec succès
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("vini7");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("123456Aa@");
        driver.hideKeyboard();
        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
// Cliquer sur le bouton de connexion
        loginButton.click();


// Ajoutez vos assertions ici pour vérifier que vous êtes connecté avec succès
        boolean isDisplayed = driver.findElement(xpath("//android.view.View[@content-desc=\"Communauté\"]")).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
    }

    @Test
    public void testFailedLogin() throws InterruptedException {
        driver.findElement(accessibilityId("Se connecter")).click();
        // Entrez les éléments de l'interface utilisateur pour le login échoué
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("vini777");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("123456Aa@");
        driver.hideKeyboard();
        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        // Cliquer sur le bouton de connexion
        loginButton.click();


        // Ajoutez vos assertions ici pour vérifier que la connexion a échoué
        boolean isDisplayed = driver.findElement(xpath("//android.view.View[@content-desc=\"Communauté\"]")).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
    }

    @Test
    public void testFailedLoginemptyusername() throws InterruptedException{
        driver.findElement(accessibilityId("Se connecter")).click();
        // Entrez les éléments de l'interface utilisateur pour le login échoué
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("123456Aa@");
        driver.hideKeyboard();
        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));


        // Cliquer sur le bouton de connexion
        loginButton.click();

        // Ajoutez vos assertions ici pour vérifier que la connexion a échoué
        boolean isDisplayed = driver.findElement(xpath("//android.view.View[@content-desc=\"Communauté\"]")).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
    }

    @Test
    public void testFailedLoginemptypassword() throws InterruptedException{
        driver.findElement(accessibilityId("Se connecter")).click();
        // Entrez les éléments de l'interface utilisateur pour le login échoué
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("vini777");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("");
        driver.hideKeyboard();
        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));


        // Cliquer sur le bouton de connexion
        loginButton.click();

        // Ajoutez vos assertions ici pour vérifier que la connexion a échoué
        boolean isDisplayed = driver.findElement(xpath("//android.view.View[@content-desc=\"Communauté\"]")).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
    }

    @Test
    public void testFailedLoginemptyusernameandpassword() throws InterruptedException{

        driver.findElement(accessibilityId("Se connecter")).click();
        // Entrez les éléments de l'interface utilisateur pour le login échoué
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        usernameField.click();
        usernameField.sendKeys("");

        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        passwordField.click();
        passwordField.sendKeys("");
        driver.hideKeyboard();
        WebElement loginButton = driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));


        // Cliquer sur le bouton de connexion
        loginButton.click();

        // Ajoutez vos assertions ici pour vérifier que la connexion a échoué
        boolean isDisplayed = driver.findElement(xpath("//android.view.View[@content-desc=\"Communauté\"]")).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
            }








    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    }


