import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.By.xpath;

public class JoinGame extends loginbasics {
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
            Thread.sleep(5000); // Attendre 5 secondes
            stopAppiumServer(); // Arrêter le serveur Appium
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void stopAppiumServer() {
        if (appiumDriverLocalService != null) {
            appiumDriverLocalService.stop();
        }
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

    @Test(alwaysRun = true)
    public void join() throws URISyntaxException, MalformedURLException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(accessibilityId("Se connecter")).click();
        // Cliquer sur le champ de saisie
        WebElement op = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")));
        op.click();
        op.sendKeys("rashford10");
        WebElement op1 = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.ScrollView/android.widget.EditText[2]")));
        op1.click();
        op1.sendKeys("12345Aa@");
        driver.hideKeyboard();
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]")));
        ok.click();
        boolean isDisplayed = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.view.View[@content-desc=\"Communauté\"]"))).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")));
        profile.click();
        WebElement matches = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Matches")));
        matches.click();
        WebElement join = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"Rejoindre le match\"])[1]")));
        join.click();
        WebElement success = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Rejoindre le match")));
        success.click();
        boolean isDisplayed1 = driver.findElement(xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).isDisplayed();
        if (isDisplayed1) {
            System.out.println("joint avec succes");
        } else {
            System.out.println("Echec");
        }
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).click();
    }

    @Test(alwaysRun = true)
    public void join1() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(accessibilityId("Se connecter")).click();
        // Cliquer sur le champ de saisie
        WebElement op = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")));
        op.click();
        op.sendKeys("vini7");
        WebElement op1 = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.ScrollView/android.widget.EditText[2]")));
        op1.click();
        op1.sendKeys("12345Aa@");
        driver.hideKeyboard();
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]")));
        ok.click();
        boolean isDisplayed = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.view.View[@content-desc=\"Communauté\"]"))).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")));
        profile.click();
        WebElement matches = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Matches")));
        matches.click();
        WebElement join = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"Rejoindre le match\"])[1]")));
        join.click();
        WebElement success = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Rejoindre le match")));
        success.click();
        boolean isDisplayed1 = driver.findElement(xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).isDisplayed();
        if (isDisplayed1) {
            System.out.println("joint avec succes");
        } else {
            System.out.println("Echec");
        }
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).click();
    }

    @Test(alwaysRun = true)
    public void join2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(accessibilityId("Se connecter")).click();
        // Cliquer sur le champ de saisie
        WebElement op = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")));
        op.click();
        op.sendKeys("Becka");
        WebElement op1 = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.ScrollView/android.widget.EditText[2]")));
        op1.click();
        op1.sendKeys("12345Aa@");
        driver.hideKeyboard();
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]")));
        ok.click();
        boolean isDisplayed = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.view.View[@content-desc=\"Communauté\"]"))).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")));
        profile.click();
        WebElement matches = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Matches")));
        matches.click();
        WebElement join = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"Rejoindre le match\"])[1]")));
        join.click();
        WebElement success = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Rejoindre le match")));
        success.click();
        boolean isDisplayed1 = driver.findElement(xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).isDisplayed();
        if (isDisplayed1) {
            System.out.println("joint avec succes");
        } else {
            System.out.println("Echec");
        }
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).click();
    }

    @Test(alwaysRun = true)
    public void join3() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(accessibilityId("Se connecter")).click();
        // Cliquer sur le champ de saisie
        WebElement op = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")));
        op.click();
        op.sendKeys("Kane");
        WebElement op1 = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.ScrollView/android.widget.EditText[2]")));
        op1.click();
        op1.sendKeys("12345Aa@");
        driver.hideKeyboard();
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]")));
        ok.click();
        boolean isDisplayed = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.view.View[@content-desc=\"Communauté\"]"))).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")));
        profile.click();
        WebElement matches = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Matches")));
        matches.click();
        WebElement join = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"Rejoindre le match\"])[1]")));
        join.click();
        WebElement success = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Rejoindre le match")));
        success.click();
        boolean isDisplayed1 = driver.findElement(xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).isDisplayed();
        if (isDisplayed1) {
            System.out.println("joint avec succes");
        } else {
            System.out.println("Echec");
        }
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).click();
    }

    @Test(alwaysRun = true)
    public void join4() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(accessibilityId("Se connecter")).click();
        // Cliquer sur le champ de saisie
        WebElement op = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")));
        op.click();
        op.sendKeys("ben yedder");
        WebElement op1 = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.ScrollView/android.widget.EditText[2]")));
        op1.click();
        op1.sendKeys("123456Aa@");
        driver.hideKeyboard();
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]")));
        ok.click();
        boolean isDisplayed = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.view.View[@content-desc=\"Communauté\"]"))).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")));
        profile.click();
        WebElement matches = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Matches")));
        matches.click();
        WebElement join = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"Rejoindre le match\"])[1]")));
        join.click();
        WebElement success = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Rejoindre le match")));
        success.click();
        boolean isDisplayed1 = driver.findElement(xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).isDisplayed();
        if (isDisplayed1) {
            System.out.println("joint avec succes");
        } else {
            System.out.println("Echec");
        }
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).click();
    }

    @Test(alwaysRun = true)
    public void join5() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(accessibilityId("Se connecter")).click();
        // Cliquer sur le champ de saisie
        WebElement op = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")));
        op.click();
        op.sendKeys("messii");
        WebElement op1 = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.widget.ScrollView/android.widget.EditText[2]")));
        op1.click();
        op1.sendKeys("123456Aa@");
        driver.hideKeyboard();
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(xpath("(//android.view.View[@content-desc=\"Se connecter\"])[2]")));
        ok.click();
        boolean isDisplayed = wait.until(ExpectedConditions.elementToBeClickable(xpath("//android.view.View[@content-desc=\"Communauté\"]"))).isDisplayed();
        if (isDisplayed) {
            System.out.println("Login successful, 'communauté' is displayed on the screen.");
        } else {
            System.out.println("Login unsuccessful, 'communauté' is not displayed on the screen.");
        }
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")));
        profile.click();
        WebElement matches = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Matches")));
        matches.click();
        WebElement join = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"Rejoindre le match\"])[1]")));
        join.click();
        WebElement success = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Rejoindre le match")));
        success.click();
        boolean isDisplayed1 = driver.findElement(xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).isDisplayed();
        if (isDisplayed1) {
            System.out.println("joint avec succes");
        } else {
            System.out.println("Echec");
        }
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Continuer\"]")).click();
    }


}





