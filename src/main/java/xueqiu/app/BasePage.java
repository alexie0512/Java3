package xueqiu.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
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

    public static AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    public BasePage() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset", "true");

        //todo:等待优化
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,5);
    }

    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,5);
    }


    public MobileElement find(By by){
        return driver.findElement(by);
    }

    public void sendKeys(By by, String key){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(key);
    }

    //todo:
    public void waitElement(){

    }

    public void click(By by){
        //wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }



    public static void quit(){
        driver.quit();
    }

}
