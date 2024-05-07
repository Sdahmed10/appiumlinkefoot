import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class CreateTryout extends loginbasics {
    AppiumDriverLocalService appiumDriverLocalService;
    @BeforeMethod
    public void setUpDriver() throws URISyntaxException, MalformedURLException, InterruptedException {
        appiumDriverLocalService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder());
        appiumDriverLocalService.start();
        AppiumTest();
    }
    private void stopAppiumServer() {
        if (appiumDriverLocalService != null) {
            appiumDriverLocalService.stop();
        }
    }
    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
    @Test
    public void createTryout() throws InterruptedException {
        try {
            driver.findElement(accessibilityId("Se connecter")).click();
            System.out.println("Clicked on 'Se connecter' button");
            // Cliquer sur le champ de saisie
            WebElement op = driver.findElement(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
            op.click();
            op.sendKeys("ahmedsdiri+15@takiacademyteam.com");
            System.out.println("Entered email");
            WebElement op1 = driver.findElement(xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
            op1.click();
            op1.sendKeys("12345Aa@");
            System.out.println("Entered password");
            driver.hideKeyboard();
            WebElement ok = driver.findElement(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
            ok.click();
            // Attente explicite pour le chargement de l'élément "Communauté"
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//android.view.View[@content-desc=\"Communauté\"]")));
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
            driver.findElement(AppiumBy.accessibilityId("Découvrir\n" +
                    "Onglet 3 sur 5")).click();
            System.out.println("Clicked on 'Découvrir' tab");
            driver.findElement(AppiumBy.accessibilityId("Créer un essai")).click();
            System.out.println("Clicked on 'Créer un essai' button");
            WebElement players = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[5]"));
            for (int i = 0; i < 6; i++) {
                players.click();
            }
            System.out.println("Clicked on 'players'");
            WebElement price = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[9]"));
            for (int i = 0; i < 5; i++) {
                price.click();
            }
            System.out.println("Clicked on 'price'");
            driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[10]/android.view.View")).click();
            driver.findElement(AppiumBy.accessibilityId("8, mercredi 8 mai 2024")).click();
            driver.findElement(AppiumBy.accessibilityId("OK")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[11]/android.view.View")).click();
            WebElement hour = driver.findElement(className("android.widget.SeekBar"));
            Actions action1 = new Actions(driver);
            action1.moveToElement(hour).click().pause(Duration.ofMillis(100)).click().perform();
            Thread.sleep(2000);
            driver.findElement(className("android.widget.EditText")).clear();
            Thread.sleep(2000);
            driver.findElement(className("android.widget.EditText")).sendKeys("9");
            driver.findElement(accessibilityId("OK")).click();
            driver.findElement(xpath("//android.widget.ScrollView/android.view.View[12]/android.widget.ImageView")).click();
            driver.findElement(xpath("//android.widget.Button[@content-desc=\"Sélectionner un emplacement\"]")).click();
            driver.findElement(AppiumBy.accessibilityId("Positions")).click();
            //driver.findElement(AppiumBy.accessibilityId("GK"))
            // List of accessibility IDs
            List<String> accessibilityIds = new ArrayList<>();
            accessibilityIds.add("GK");
            accessibilityIds.add("RM");
            accessibilityIds.add("LM");
            // Click on multiple elements with different accessibility ids
            for (String accessibilityId : accessibilityIds) {
                driver.findElement(AppiumBy.accessibilityId(accessibilityId)).click();
                Thread.sleep(1000); // Wait for a second
            }
            driver.findElement(AppiumBy.accessibilityId("OK")).click();
            WebElement max = driver.findElement(xpath("//android.widget.ScrollView/android.view.View[21]"));
            // Cliquer sur l'élément "max" en utilisant les coordonnées trouvées
            for (int i = 0; i < 4; i++) {
                max.click();
                Thread.sleep(500); // Attendre 1/2 seconde entre les clics
            }
            Thread.sleep(500);
            WebElement min = driver.findElement(xpath("//android.widget.ScrollView/android.view.View[17]"));
            for (int i = 0; i < 1; i++) {
                min.click();
            }
            driver.findElement(xpath("//android.widget.Button[@content-desc=\"Partager\"]")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


