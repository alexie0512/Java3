package xueqiu.app;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.applet.Main;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexie Jing
 * @date 2020 6月 2020/6/26 16:09
 * @project Java3
 */
public class SearchPage extends BasePage{

    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    public SearchPage() {

    }


    public SearchPage search(String keyword){
        MobileElement search = (MobileElement)driver.findElement(By.id("com.xueqiu.android:id/search_input_text"));
        search.sendKeys(keyword);
        return this;
    }

    public SearchResultPage searchAndReturn(String keyword, String CODE){
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(keyword);
        driver.findElement(By.xpath("//*[@text='"+CODE+"']")).click();
        return new SearchResultPage(driver);
    }



/*
    public MainPage cancelSearch() throws MalformedURLException {
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
        return new MainPage(driver);
    }
*/



    public List<String> getSearchList(){
        List<String> nameList = new ArrayList<>();
        for ( Object element : driver.findElements(By.id("name"))){
                nameList.add(((WebElement) element).getText());
        }
        return nameList;
        //return Arrays.asList("1","2","3");

    }

    public double getPrice(){
        //todo:独立出去一个select的 PO 方法
        MobileElement getprice = (MobileElement)driver.findElement(By.xpath("//*[@text=\"BABA\"]"));
        getprice.click();
        return Double.valueOf(driver.findElement(By.id("current_price")).getText());
    }
}
