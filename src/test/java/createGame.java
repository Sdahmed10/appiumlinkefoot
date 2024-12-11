import com.google.common.collect.ImmutableMap;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.className;
import static org.openqa.selenium.By.xpath;

public class createGame extends loginbasics{
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
            if (driver != null) {
                driver.quit();
            }
            if (appiumDriverLocalService != null) {
                appiumDriverLocalService.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            for(int i=0; i<5; i++) {
                price.click();
            }
            driver.findElement(xpath("//android.widget.ScrollView/android.view.View[9]/android.widget.ImageView")).click();
            driver.findElement(xpath("//android.widget.Button[@content-desc=\"25, vendredi 25 octobre 2024\"]")).click();
            driver.findElement(accessibilityId("OK")).click();
            driver.hideKeyboard();
            driver.findElement(xpath("//android.widget.ScrollView/android.view.View[10]/android.widget.ImageView")).click();
            WebElement hour = driver.findElement(className("android.widget.SeekBar"));
            Actions action1 = new Actions(driver);
            action1.moveToElement(hour).click().pause(100).click().perform();
            Thread.sleep(2000);
            driver.findElement(className("android.widget.EditText"))
                    .clear();
            Thread.sleep(2000);
            driver.findElement(className("android.widget.EditText"))
                    .sendKeys("9");
            driver.findElement(accessibilityId("OK")).click();
            driver.hideKeyboard();
            driver.findElement(xpath("//android.widget.ScrollView/android.view.View[11]/android.widget.ImageView")).click();
            driver.findElement(xpath("//android.widget.Button[@content-desc=\"Sélectionner un emplacement\"]")).click();
            driver.hideKeyboard();
            Thread.sleep(2000);
            WebElement max = driver.findElement(xpath("//android.widget.ScrollView/android.view.View[19]"));
            for(int i = 1; i < 10; i++) {
                max.click();
            }
            Thread.sleep(2000);
            WebElement des = driver.findElement(xpath("//android.widget.EditText"));
            des.click();
            des.sendKeys("Test");
            WebElement min = driver.findElement(xpath("//android.widget.ScrollView/android.view.View[15]"));
            for(int i = 0; i < 1; i++) {
                min.click();
            }
            Thread.sleep(2000);
//            boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
//                    ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 600, "direction", "up", "percent",
//                            2.0));
            driver.findElement(xpath("//android.widget.Button[@content-desc=\"Partager\"]")).click();
            Thread.sleep(1000);
            boolean isDisplayed1 = driver.findElement(xpath("//android.view.View[@content-desc=\"Match créé avec succès\"]")).isDisplayed();
            if (isDisplayed1) {
                System.out.println("Match cree avec succes");
            } else {
                System.out.println("erreur de creation du match");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}