import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.xpath;

public class EditGame extends loginbasics {
    AppiumDriverLocalService appiumDriverLocalService;
    ;

    @BeforeMethod
    public void setUpDriver() throws URISyntaxException, MalformedURLException, InterruptedException {
        appiumDriverLocalService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder());
        appiumDriverLocalService.start();
        AppiumTest();
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5000); // Attendre 5 secondes
            stopAppiumServer(); // Arrêter le serveur Appium
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
    public void edit1() throws URISyntaxException, MalformedURLException {
        try {
            driver.findElement(accessibilityId("Se connecter")).click();
            // Cliquer sur le champ de saisie
            WebElement op = driver.findElement(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
            op.click();
            op.sendKeys("rashford10");
            WebElement op1 = driver.findElement(xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
            op1.click();
            op1.sendKeys("12345Aa@");
            driver.hideKeyboard();
            WebElement ok = driver.findElement(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
            ok.click();
            boolean isDisplayed = driver.findElement(xpath("//android.view.View[@content-desc=\"Communauté\"]")).isDisplayed();
            if (isDisplayed) {
                System.out.println("Login successful, 'communauté' is displayed on the screen.");
            } else {
                System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
            }
            WebElement profile = driver
                    .findElement(accessibilityId("Profil\n" + "Onglet 5 sur 5"));
            profile.click();
            driver.findElement(AppiumBy.accessibilityId("marcos rashford\n" +
                    "rashford10")).click();
            boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 800, "direction", "down", "percent",
                            1.0));
            driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[35]")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Voir plus\"]")).click();
            driver.findElement(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"Modifier le match\"])[1]")).click();
            driver.findElement(AppiumBy.accessibilityId("Gérer le match")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Détails du match\"]")).click();
            driver.findElement(AppiumBy.accessibilityId("Modifier le match")).click();
            WebElement max = driver.findElement(xpath("//android.widget.ScrollView/android.view.View[19]"));
            for (int i = 1; i < 21; i++) {
                max.click();
            }
            driver.findElement(AppiumBy.accessibilityId("Edit")).click();
            boolean isDisplayed1 = driver.findElement(xpath("//android.view.View[@content-desc=\"Mis à jour avec succès\"]")).isDisplayed();
            if (isDisplayed1) {
                System.out.println("Mise a jour avec succes");
            } else {
                System.out.println("Echec");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
