import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class loginbasics {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    private static final String NODE_PATH = "/usr/local/bin/node";
    private static final String APPIUM_JS_PATH = "/usr/local/lib/node_modules/appium/build/lib/main.js";
    private static final String APK_PATH = "/Users/takiacademy/IdeaProjects/appiumahmed/src/test/java/resources/linkefoot_staging 27.apk";

    @BeforeMethod
    public void AppiumTest() throws URISyntaxException, MalformedURLException, InterruptedException {
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File(NODE_PATH))
                .withAppiumJS(new File(APPIUM_JS_PATH)));

        service.start();
        if (!service.isRunning()) {
            throw new IllegalStateException("Appium server failed to start.");
        }

        int appiumPort = service.getUrl().getPort();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("sdk_gphone64_arm64");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setCapability("autoGrantPermissions", "true");
        options.setApp(APK_PATH);

        System.out.println("Appium server started...");
        driver = new AndroidDriver(new URI("http://127.0.0.1:" + appiumPort).toURL(), options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error while quitting the driver: " + e.getMessage());
            }
        }
        if (service != null && service.isRunning()) {
            try {
                service.stop();
                System.out.println("Appium server stopped...");
            } catch (Exception e) {
                System.err.println("Error while stopping Appium service: " + e.getMessage());
            }
        }
    }
}
