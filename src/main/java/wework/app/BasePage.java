package wework.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexie Jing
 * @date 2020 7月 2020/7/1 12:44
 * @project Java3
 */
public class BasePage {

    public static AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    String appPackage;
    String appActivity;
    private int timeOutInSecondsDefault= 60;

    public BasePage(String appPackage, String appActivity) throws MalformedURLException {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        startApp(appPackage, appActivity);
    }

    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSecondsDefault);
    }

    public void startApp(String appPackage, String appActivity) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("udid", "");
        desiredCapabilities.setCapability("dontStopAppOnReset", "true");
        desiredCapabilities.setCapability("skipLogcatCapture", "true");
        //todo:等待优化
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, timeOutInSecondsDefault);
    }

    public By byText(String text){
        return By.xpath("//*[@text='"+text+"']");
    }

    public MobileElement find(By by) {
        return driver.findElement(by);
    }

    public MobileElement find(String text) {

        return driver.findElement(By.xpath("//*[@text='"+text+"']"));
    }


    public void sendKeys(By by, String key) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(key);
    }

    //todo:
    public void waitElement() {

    }

    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void click(String text ) {
        //wait.until(ExpectedConditions.elementToBeClickable(by));
        find(text).click();
    }

/*    public BasePage swipeDown() {
        try {
            int height = driver.manage().window().getSize().getHeight();
            int width = driver.manage().window().getSize().getWidth();
            Thread.sleep(10000);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point((int) (width * 0.5), (int) (height * 0.8)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                    .moveTo(PointOption.point((int) (width * 0.5), (int) (height * 0.2))).release().perform();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }*/

    public static void quit() {
        driver.quit();
    }

}
