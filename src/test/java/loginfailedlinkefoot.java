import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import static io.appium.java_client.AppiumBy.*;


public class loginfailedlinkefoot {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @Test
    public void AppiumTest() throws URISyntaxException, MalformedURLException {
        // AndroidDriver or IOSDriver
        // Appium code --> Appium Server --> Mobile
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")));
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 2 XL API 33");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setCapability("autoGrantPermissions", "true");
        options.setApp("/Users/takiacademy/eclipse-workspace/Ahmedappium/src/test/java/resources/app-release 36.apk");
        System.out.println("Serveur Appium démarré...");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        // Xpath; id, accessibilityId, classname,
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
    }
        @AfterMethod
        public void teardown() {
            driver.quit();
            service.stop();
        }

    }




