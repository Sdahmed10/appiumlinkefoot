import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class restartAppium {
    private static AppiumDriverLocalService service;

    public static void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingAnyFreePort();
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public static void stopServer() {
        if (service != null) {
            service.stop();
        }
    }

    public static void main(String[] args) {
        startServer();
        // Your test code here
        stopServer();
    }
}
