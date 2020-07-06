package xueqiu.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

/**
 * @author Alexie Jing
 * @date 2020 7月 2020/7/1 13:18
 * @project Java3
 */
public class TrendPage extends BasePage {

    public TrendPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public TrendPage() throws MalformedURLException {
        super();

    }


    @Step("行情页到搜索页")
    public SearchPage trendtoSearch(){
        //driver.findElement(By.id("com.xueqiu.android:id/action_search")).click();
        click(By.id("com.xueqiu.android:id/action_search"));
        return new SearchPage(driver);
    }

    @Step("删除单个股票")
    public TrendPage deleteSignleStock(String CODE){
        //driver.findElement(By.id("com.xueqiu.android:id/edit_group")).click();
        //driver.findElement(By.xpath("//*[@text='"+CODE+"']/../../..//*[@resource-id=\"com.xueqiu.android:id/check\"]")).click();
        //driver.findElement(By.id("com.xueqiu.android:id/cancel_follow")).click();
        click(By.id("com.xueqiu.android:id/edit_group"));
        click(By.xpath("//*[@text='"+CODE+"']/../../..//*[@resource-id=\"com.xueqiu.android:id/check\"]"));
        click(By.id("com.xueqiu.android:id/cancel_follow"));
        //确定删除
        //driver.switchTo().alert().accept();
        driver.findElementByAndroidUIAutomator("resourceId(\"com.xueqiu.android:id/tv_right\")").click();
        //点击完成
        click(By.id("com.xueqiu.android:id/action_close"));
        return this;
    }

    @Step("删除所有股票")
    public TrendPage deleteAllStock(){
        //driver.findElement(By.id("com.xueqiu.android:id/edit_group")).click();
        //driver.findElement(By.id("com.xueqiu.android:id/check_all")).click();
        //driver.findElement(By.id("com.xueqiu.android:id/cancel_follow")).click();
        click(By.id("com.xueqiu.android:id/edit_group"));
        click(By.id("com.xueqiu.android:id/check_all"));
        click(By.id("com.xueqiu.android:id/cancel_follow"));
        //确定删除
        //driver.switchTo().alert().accept();
        driver.findElementByAndroidUIAutomator("resourceId(\"com.xueqiu.android:id/tv_right\")").click();
        //点击完成
        click(By.id("com.xueqiu.android:id/action_close"));
        return  this;
    }

}
