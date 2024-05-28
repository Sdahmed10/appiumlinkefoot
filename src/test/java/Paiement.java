import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.xpath;

public class Paiement extends loginbasics {
    private static final Logger log = LoggerFactory.getLogger(Paiement.class);
    AppiumDriverLocalService appiumDriverLocalService;

    @BeforeMethod
    public void setUpDriver() throws URISyntaxException, MalformedURLException, InterruptedException {
        appiumDriverLocalService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder());
        appiumDriverLocalService.start();
        AppiumTest();

    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        if (driver !=null ){
        driver.quit();
    }
    if(appiumDriverLocalService !=null){
        appiumDriverLocalService.stop();
    }
}
    private void login(){
        driver.findElement(accessibilityId("Se connecter")).click();
        System.out.println("Clicked on 'Se connecter' button");
        WebElement op = driver.findElement(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        op.click();
        op.sendKeys("Barnett");
        System.out.println("Entered username");
        WebElement op1 = driver.findElement(xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        op1.click();
        op1.sendKeys("12345Aa@");
        System.out.println("Entered password");
        driver.hideKeyboard();
        WebElement ok = driver.findElement(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
        ok.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//android.view.View[@content-desc=\"Communauté\"]")));
        System.out.println("Login successful, 'communauté' is displayed on the screen.");
    }
    @Test
    public  void Paiement1 () throws InterruptedException {
        try {
            login();
            WebElement profile = driver.findElement(accessibilityId("Profil\n" + "Onglet 5 sur 5"));
            profile.click();
            WebElement wallet = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mon portefeuille\"]"));
            wallet.click();
            WebElement alimenter = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Alimenter Balance\"]"));
            alimenter.click();
            WebElement alimenter1 = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Alimenter la Balance\"]"));
            alimenter1.click();
            WebElement montant = driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
            montant.click();
            montant.sendKeys("500");
            driver.hideKeyboard();
            WebElement save = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Confirmer\"]"));
            save.click();
            Thread.sleep(5000);
            boolean isDisplayed = driver.findElement(accessibilityId("Rechargement du portefeuille est effectué avec succès")).isDisplayed();
            if (isDisplayed) {
                System.out.println("Success message");
            } else {
                System.out.println("Failed message");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void Paiement2 () throws InterruptedException {
        try {
            login();
            WebElement profile = driver.findElement(accessibilityId("Profil\n" + "Onglet 5 sur 5"));
            profile.click();
            WebElement wallet = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mon portefeuille\"]"));
            wallet.click();
            WebElement alimenter = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Alimenter Balance\"]"));
            alimenter.click();
            WebElement alimenter1 = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Alimenter la Balance\"]"));
            alimenter1.click();
            WebElement montant = driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
            montant.click();
            montant.sendKeys("");
            driver.hideKeyboard();
            WebElement save = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Confirmer\"]"));
            save.click();
            Thread.sleep(5000);
            boolean isDisplayed = driver.findElement(xpath("R//android.view.View[@content-desc=\"Entrer un montant\"]")).isDisplayed();
            if (isDisplayed) {
                System.out.println("Success message: entrer un montant");
            } else {
                System.out.println("Failed message");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}