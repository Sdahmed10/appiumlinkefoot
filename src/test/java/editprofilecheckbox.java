import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.xpath;


public class editprofilecheckbox extends loginbasics {
    @BeforeMethod
    public void setUpDriver() throws URISyntaxException, MalformedURLException, InterruptedException {
        AppiumTest();
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
            WebElement myaccount = driver.findElement(accessibilityId("Mon compte"));
            myaccount.click();
            boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 1800, "direction", "down", "percent",
                            3.0));
            WebElement description = driver.findElement(By.xpath("//android.widget.EditText[@text=\"udhd\"]"));
            description.click();
            description.clear();
            description.sendKeys("Test1");
            driver.hideKeyboard();

            WebElement save = driver.findElement(accessibilityId("Enregistrer les modifications"));
            save.click();

            WebElement errorMessage = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Vous devez être le tuteur légal ou le parent de ce joueur\"]"));
            Thread.sleep(3000);
            if (errorMessage.isDisplayed()) {
                System.out.println("Vous devez être le tuteur légal ou le parent de ce joueur" + errorMessage.getText());
            } else {
                System.out.println("modif successful.");
            }

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
