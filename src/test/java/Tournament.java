import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.xpath;

public class Tournament extends loginbasics {
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
    public void main() {
        driver.findElement(accessibilityId("Se connecter")).click();
        // Cliquer sur le champ de saisie
        WebElement op = driver.findElement(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        op.click();
        op.sendKeys("fenb.captain");
        WebElement op1 = driver.findElement(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        op1.click();
        op1.sendKeys("12345678@Aa");
        WebElement ok = driver.findElement(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        ok.click();
        boolean isDisplayed = driver.findElement(xpath("//android.view.View[@content-desc=\"Communauté\"]")).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
        WebElement profile = driver.findElement(xpath("//android.widget.ImageView[@content-desc=\"Profile\n" +
                "Onglet 5 sur 5\"]"));
        profile.click();
        WebElement pro = driver.findElement(xpath("//android.view.View[@content-desc=\"Captain .\n" +
                "fenb.captain\"]"));
        pro.click();
        WebElement invit = driver.findElement(xpath("//android.widget.ScrollView/android.widget.ImageView[2]"));
        invit.click();
        WebElement affectations = driver.findElement(xpath("//android.view.View[@content-desc=\"Affectations\n" +
                "Onglet 3 sur 3\"]"));
        affectations.click();
        WebElement consulter = driver.findElement(xpath("//android.widget.Button[@content-desc=\"Consulter\"]"));
        consulter.click();
        WebElement choisir = driver.findElement(xpath("//android.widget.Button[@content-desc=\"Choisir les joueurs\"]"));
        choisir.click();
        WebElement search = driver.findElement(xpath("//android.widget.ScrollView/android.widget.ImageView[1]"));
        search.click();
        search.sendKeys("fenb.");
//        WebElement titulaire = driver.findElement(xpath("(//android.view.View[@content-desc=\"Titulaire\"])[1]"));
//        titulaire.click();
        for (int i = 1; i <= 6; i++) {
            WebElement titulaire = driver.findElement(xpath("(//android.view.View[@content-desc=\"Titulaire\"])[" + i + "]"));
            titulaire.click();
        }


    }
}
