import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class signup extends loginbasics{
    @BeforeMethod
    public void setUpDriver() throws URISyntaxException, MalformedURLException, InterruptedException {
        AppiumTest();
    }

    @Test
    public void signuptest(){
        try {
            driver.findElement(accessibilityId("S'inscrire")).click();
            driver.findElement(accessibilityId("Joueur")).click();
            boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 1400, "direction", "down", "percent",
                            2.0));
                WebElement name= driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
            name.click();
                name.sendKeys("pep");
            WebElement lastname= driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
            lastname.click();
            lastname.sendKeys("guardiola");
            WebElement username= driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[3]"));
            username.click();
            username.sendKeys("pep2");
            WebElement email= driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[4]"));
            email.click();
            email.sendKeys("hinimo2078@em2lab.com");
            WebElement password= driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[5]"));
            password.click();
            password.sendKeys("12345Aa@");
            WebElement confirmpassword= driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[6]"));
            confirmpassword.click();
            confirmpassword.sendKeys("12345Aa@");
            WebElement phone= driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[7]"));
            phone.click();
            phone.sendKeys("201458796");
            driver.hideKeyboard();
            driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[2]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Algeria\"]")).click();
            driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"Étape suivante\"]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"Email\n" +
                    "Votre code de vérification sera envoyé sur\n" +
                    "hinimo2078@em2lab.com\"]")).click();









    }catch (Exception e) {
            e.printStackTrace();
        }
}
}
