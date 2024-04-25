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

public class imageinsert extends loginbasics {
    @BeforeMethod
    public void setUpDriver() throws URISyntaxException, MalformedURLException, InterruptedException {
        AppiumTest();
    }
    @Test
    public void share() throws URISyntaxException, MalformedURLException {
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
            WebElement modifier = driver.findElement(accessibilityId("Modifier la photo"));
            modifier.click();
            WebElement importer = driver.findElement(accessibilityId("Importer à partir de la galerie"));
            importer.click();
            WebElement image = driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.documentsui:id/icon_thumb\"])[1]"));
            image.click();
            boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 1400, "direction", "down", "percent",
                            1.0));
            WebElement check = driver.findElement(By.xpath("//android.widget.CheckBox"));
            check.click();
            boolean canScrollMore1 = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 1400, "direction", "down", "percent",
                            3.0));
            WebElement save = driver.findElement(accessibilityId("Enregistrer les modifications"));
            save.click();
            boolean isDisplayed1 = driver.findElement(accessibilityId("marcos rashford\n" +
                    "rashford10")).isDisplayed();
            if (isDisplayed) {
                System.out.println("modif successful, 'rashford' is displayed on the screen.");
            } else {
                System.out.println("modif unsuccessful, 'rashford' is not displayed on the screen.");
            }
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}