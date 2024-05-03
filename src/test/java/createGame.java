import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.android.nativekey.AndroidKey.*;
import static org.openqa.selenium.By.xpath;

public class createGame extends loginbasics{

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
           driver.findElement(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")).click();
           driver.findElement(accessibilityId("Matches")).click();
           driver.findElement(accessibilityId("Créer un match")).click();
           WebElement team1 = driver.findElement(xpath("//android.widget.ScrollView/android.widget.ImageView[4]"));
           team1.click();
           team1.sendKeys("Team1");
           WebElement team2 = driver.findElement(xpath("//android.widget.ScrollView/android.widget.ImageView[5]"));
           team2.click();
           team2.sendKeys("Team2");
            driver.hideKeyboard();
            WebElement price= driver.findElement(xpath("//android.widget.ScrollView/android.view.View[8]"));
            for(int i=1; i<12; i++) {
                price.click();
            }
            driver.findElement(xpath("//android.widget.ScrollView/android.view.View[9]/android.widget.ImageView")).click();
            driver.findElement(xpath("//android.widget.Button[@content-desc=\"Sélectionner une date\n" +
                    "mar. 30 avr.\n" +
                    "Sélectionner une année\"]/android.widget.Button[2]")).click();
            driver.findElement(xpath("//android.widget.Button[@content-desc=\"1, mercredi 1 mai 2024\"]")).click();
            driver.findElement(accessibilityId("OK")).click();
            driver.findElement(xpath("//android.widget.ScrollView/android.view.View[10]/android.widget.ImageView")).click();
            WebElement hours = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[1]"));
            hours.click();
            WebElement hour = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"11\"]"));
            hour.click();
            driver.pressKey(new KeyEvent(ENTER));
            driver.pressKey(new KeyEvent(ENTER));
            hours.sendKeys("12");
            WebElement minutes = driver.findElement(accessibilityId("Sélectionner des minutes 32"));
            minutes.click();
            minutes.sendKeys("11");

        } catch (Exception e) {
                e.printStackTrace();
            }
    }
}





