import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.xpath;

public class ResetPassword extends loginbasics{
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
            op.sendKeys("vini7");
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
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"Mot de passe\"]")).click();
            WebElement actuel = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
            actuel.click();
            actuel.sendKeys("12345Aa@");
            driver.hideKeyboard();
            WebElement newpassword = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
            newpassword.click();
            newpassword.sendKeys("123456Aa@");
            driver.hideKeyboard();
            WebElement confirm = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]"));
            confirm.click();
            confirm.sendKeys("123456Aa@");
            driver.hideKeyboard();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"Confirmer\"]")).click();
            boolean isDisplayed1 = driver.findElement(accessibilityId("//android.widget.ImageView[@content-desc=\"vinicus junior\n" +
                    "vini7\"]")).isDisplayed();
            if (isDisplayed) {
                System.out.println("reset password successful, 'vinicuis' is displayed on the screen.");
            } else {
                System.out.println("reset password unsuccessful, 'vinicuis' is not displayed on the screen.");
            }
            driver.quit();


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

