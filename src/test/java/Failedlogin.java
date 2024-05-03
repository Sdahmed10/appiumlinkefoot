import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.xpath;

public class Failedlogin extends loginbasics{
    @BeforeMethod
    public void setUpDriver() throws URISyntaxException, MalformedURLException, InterruptedException {
        AppiumTest();
    }

    @Test
    public void edit1() throws URISyntaxException, MalformedURLException {
        try {
            driver.findElement(accessibilityId("Se connecter")).click();
// Cliquer sur le champ de saisie
            WebElement op = driver.findElement(xpath(
                    "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
            op.click();
            op.sendKeys("vini71");
            WebElement op1 = driver.findElement(xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
            op1.click();
            op1.sendKeys("12345Aa@");
            driver.hideKeyboard();
            WebElement ok = driver.findElement(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]"));
            ok.click();
            WebElement errorMessage = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Utilisateur non inscrit ou non vérifié\"]"));
            if(errorMessage.isDisplayed()) {
                System.out.println("Utilisateur non inscrit ou non vérifié: " + errorMessage.getText());
            } else {
                System.out.println("Login successful.");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
