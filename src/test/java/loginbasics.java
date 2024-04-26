import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class loginbasics {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @Test
    public void AppiumTest() throws URISyntaxException, MalformedURLException, InterruptedException {
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
        options.setApp("/Users/takiacademy/IdeaProjects/appiumahmed/src/test/java/resources/app-release 40.apk");
        System.out.println("Serveur Appium démarré...");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
    }
}

