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


public class editprofile extends loginbasics {
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
            op.sendKeys("walker22");
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
                    .findElement(xpath("//android.widget.ImageView[@content-desc=\"Profile\n" +
                            "Onglet 5 sur 5\"]"));
            profile.click();
            WebElement myaccount = driver.findElement(accessibilityId("Mon compte"));
            myaccount.click();
            boolean elementVisible = false;
            while (!elementVisible) {
                try {
                    WebElement descriptionField = driver.findElement(By.xpath("//android.widget.EditText[@text=\"Test1\"]"));
                    elementVisible = descriptionField.isDisplayed();
                } catch (Exception e) {
                    // Use scroll gesture for more control
                    ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                            "left", 100, "top", 500,
                            "width", 200, "height", 1500,
                            "direction", "down",
                            "percent", 5.0));
                }
            }
            WebElement description = driver.findElement(By.xpath("//android.widget.EditText[@text=\"Test1\"]"));
            description.click();
            description.clear();
            description.sendKeys("Joueur de football professionnel");
            driver.hideKeyboard();

            WebElement save = driver.findElement(accessibilityId("Enregistrer les modifications"));
            save.click();
            boolean isDisplayed1 = driver.findElement(accessibilityId("walker22\n" +
                    "walker22")).isDisplayed();
            if (isDisplayed1) {
                System.out.println("modif successful, 'walker22' is displayed on the screen.");
            } else {
                System.out.println("modif unsuccessful, 'walker22' is not displayed on the screen.");
            }
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
