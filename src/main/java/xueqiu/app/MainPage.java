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

    public MainPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public MainPage() throws MalformedURLException {
        super();

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
        click(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage(driver);

    }

    //到 trendPage
    public TrendPage toTrend(){
        click(By.xpath("//*[@text=\"行情\"]"));
        return new TrendPage(driver);
    }



}
