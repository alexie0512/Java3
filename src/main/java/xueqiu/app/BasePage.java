package xueqiu.app;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexie Jing
 * @date 2020 7月 2020/7/1 12:44
 * @project Java3
 */
public class BasePage {

    public AndroidDriver driver;
    WebDriverWait wait;

    public BasePage() {
    }

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void quit(){
        driver.quit();
    }

}
