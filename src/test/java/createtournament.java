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

public class createtournament extends loginbasics {
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
    public void main()  {
        driver.findElement(accessibilityId("Se connecter")).click();
        // Cliquer sur le champ de saisie
        WebElement op = driver.findElement(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        op.click();
        op.sendKeys("vini7");
        WebElement op1 = driver.findElement(xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        op1.click();
        op1.sendKeys("123456Aa@");
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
        WebElement myaccount = driver.findElement(accessibilityId("vinicus junior\n" +
                "vini7"));
        myaccount.click();
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 800, "direction", "down", "percent",
                        1.0));
        driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[35]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Voir plus\"]")).click();
        driver.findElement((AppiumBy.xpath("//android.view.View[@content-desc=\"+\n" +
                "Créer un nouveau\"]"))).click();
        WebElement nameoftournament = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
        nameoftournament.click();
        nameoftournament.sendKeys("Test");
        WebElement description = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        description.click();
        description.sendKeys("Test1111");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.ImageView")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"17, vendredi 17 mai 2024\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"OK\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.ImageView")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"25, samedi 25 mai 2024\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"OK\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.ImageView")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"31, vendredi 31 mai 2024\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"OK\"]")).click();

        boolean canScrollMore1 = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 800, "direction", "down", "percent",
                        3.0));
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Élimination directe\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"16\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Sélectionnez une catégorie d'âge\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"U16-U17\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.RadioButton[2]")).click();
        WebElement victoire = driver.findElement(xpath("//android.widget.ScrollView/android.view.View[25]"));
        for (int i = 0; i < 3; i++) {
            victoire.click();
        }
        WebElement egalite = driver.findElement(xpath("//android.widget.ScrollView/android.view.View[31]"));
        for (int i = 0; i < 1; i++) {
            egalite.click();
        }
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Créer une Annonce\"]")).click();
        boolean isDisplayed1 = driver.findElement(xpath("//android.widget.Button[@content-desc=\"Choisir les Participants\"]")).isDisplayed();
        if (isDisplayed1) {
            System.out.println("creation successfully");
        } else {
            System.out.println("creatio unsuccessful");
        }











    }
}
