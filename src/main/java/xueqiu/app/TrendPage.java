package xueqiu.app;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @author Alexie Jing
 * @date 2020 7月 2020/7/1 13:18
 * @project Java3
 */
public class TrendPage extends BasePage {

    public TrendPage(AndroidDriver driver) {
        super(driver);
    }

    public TrendPage() {

    }

    public SearchPage trendtoSearch(){
        driver.findElement(By.id("com.xueqiu.android:id/action_search")).click();
        return new SearchPage(driver);
    }

    public TrendPage deleteSignleStock(String CODE){
        driver.findElement(By.id("com.xueqiu.android:id/edit_group")).click();
        driver.findElement(By.xpath("//*[@text='"+CODE+"']/../../..//*[@resource-id=\"com.xueqiu.android:id/check\"]")).click();
        driver.findElement(By.id("com.xueqiu.android:id/cancel_follow")).click();
        //确定删除
        //driver.switchTo().alert().accept();
        driver.findElementByAndroidUIAutomator("resourceId(\"com.xueqiu.android:id/tv_right\")").click();
        //点击完成
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
        return this;
    }

    public TrendPage deleteAllStock(){
        driver.findElement(By.id("com.xueqiu.android:id/edit_group")).click();
        driver.findElement(By.id("com.xueqiu.android:id/check_all")).click();
        driver.findElement(By.id("com.xueqiu.android:id/cancel_follow")).click();
        //确定删除
        //driver.switchTo().alert().accept();
        driver.findElementByAndroidUIAutomator("resourceId(\"com.xueqiu.android:id/tv_right\")").click();
        //点击完成
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
        return  this;
    }

}
