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
 * @date 2020 6月 2020/6/26 16:00
 * @project Java3
 */
public class MainPage extends BasePage{
    public MainPage() throws MalformedURLException {
        super();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset", "true");

        //todo:等待优化
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public MainPage(AndroidDriver driver) {
    }

/*    //同意隐私协议
    public MainPage sendAgree(){
        //com.xueqiu.android:id/tv_agree
        MobileElement agree = (MobileElement) driver.findElement(By.id("om.xueqiu.android:id/tv_agree"));
        agree.click();
        return this;
    }*/

    //到 searchPage
    public SearchPage toSearch(){
        MobileElement search = (MobileElement)driver.findElement(By.id("com.xueqiu.android:id/home_search"));
        search.click();
        return new SearchPage(driver);

    }

    //到 trendPage
    public TrendPage toTrend(){
        MobileElement trend = (MobileElement)driver.findElement(By.xpath("//*[@text=\"行情\"]"));
        trend.click();
        return new TrendPage(driver);
    }



}
