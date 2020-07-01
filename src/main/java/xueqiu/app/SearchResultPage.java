package xueqiu.app;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @author Alexie Jing
 * @date 2020 7月 2020/7/1 13:46
 * @project Java3
 */
public class SearchResultPage extends BasePage{


    public SearchResultPage(AndroidDriver driver) {
        super(driver);
    }

    public SearchResultPage() {

    }

    public SearchResultPage toStockResult(){
        driver.findElement(By.xpath("//*[@text=\"股票\"]")).click();
        return this;
    }

    //加自选
    public SearchResultPage addStock(String CODE){
        driver.findElement(By.xpath("//*[@text='"+CODE+"']/../../..//*[@resource-id=\"com.xueqiu.android:id/follow_btn\"]")).click();
        //点击下次再说
        //driver.findElement(By.id("com.xueqiu.android:id/tv_left")).click();
        return this;
    }
    public TrendPage cancelSearchtoTrend(){
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
        return new TrendPage(driver);
    }





}
