package test.xueqiu.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import xueqiu.app.BaseTestDemo;

import java.time.Duration;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class TestDemo extends BaseTestDemo {


    //参数化用例
    private static Stream<Arguments> byNameGetPrice(){
        return Stream.of(Arguments.of("alibaba","BABA", 210d),
                Arguments.of("wangyi","NTES",250d),
                Arguments.of("baidu","BIDU",180d),
                Arguments.of("谷歌","GOOGL",300d));
    }

    @ParameterizedTest
    @MethodSource("byNameGetPrice")
    public void searchByNameTest(String name, String code, double price) {

        //显示等待
        wait = new WebDriverWait(driver,10,1000);

        //定位首页搜索框
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        //定位搜索页搜索框，输入alibaba
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(name);
        //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]").click();

        //显示等待元素可见， 点击股票代码
        //driver.findElement(By.xpath("//*[@text=\"BABA\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='"+code+"']"))).click();

        //获取股票价格
        System.out.println(driver.findElement(By.id("current_price")).getAttribute("text"));


        //获取香港股票价格
        //*[@text="09988"]/../../..//*[@resource-id="com.xueqiu.android:id/current_price"]
        String price_tag = driver.findElement(By.xpath("//*[@text='"+code+"']/../../..//*[@resource-id=\"com.xueqiu.android:id/current_price\"]")).getAttribute("text");

        //点击取消，返回首页
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();

        assertThat("Price Comparison",Double.parseDouble(price_tag),greaterThan(price));
    }




    @Test
    public void searchAlibabaTest() {

        //显示等待
        wait = new WebDriverWait(driver,10,1000);


        //定位首页搜索框
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        //定位搜索页搜索框，输入alibaba
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
        //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]").click();

        //显示等待元素可见， 点击股票代码
        //driver.findElement(By.xpath("//*[@text=\"BABA\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text=\"BABA\"]"))).click();

        //获取股票价格
        System.out.println(driver.findElement(By.id("current_price")).getAttribute("text"));

        //获取香港股票价格
        //*[@text="09988"]/../../..//*[@resource-id="com.xueqiu.android:id/current_price"]
        System.out.println(driver.findElement(By.xpath("//*[@text=\"09988\"]/../../..//*[@resource-id=\"com.xueqiu.android:id/current_price\"]")).getAttribute("text"));

    }

    @Test
    public void elementAttributeTest() {

        //定位首页搜索框
        WebElement home_search = driver.findElement(By.id("com.xueqiu.android:id/home_search"));

        //判断首页搜索框是否 enabled, 如果为true则打印坐标
        if (home_search.getAttribute("enabled").equals("true")) {
            System.out.println(home_search.getLocation());
            home_search.click();
            //定位搜索页搜索框
            WebElement search_input_text = driver.findElement(By.id("com.xueqiu.android:id/search_input_text"));

            //判断搜索页输入框是否显示，显示则打印搜索成功，否则失败
            if (search_input_text.getAttribute("displayed").equals("true")) {
                search_input_text.sendKeys("alibaba");
                System.out.println("搜索成功！");
            } else {
                System.out.println("搜索失败！");
            }
        }
    }

    //ScrollTest
    @Test
    public void ScrollTest() {
    }


    //SwipeTest
    @Test
    public void swipeTest() {
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
    }

    //SwipeUnclocKTest: 需要下载手势密码锁。skip

    @Test
    public void swipeUnlockTest() {
        // todo:~
    }

    @Test
    public void uiautomatorSelectTest() {
        try {
            AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
            Thread.sleep(5000);

            //点击交易， resourceId定位
            driver.findElementByAndroidUIAutomator("resourceId(\"com.xueqiu.android:id/tab_name\").text(\"交易\")").click();
            Thread.sleep(5000);

            //点击行情， className定位
            driver.findElementByAndroidUIAutomator("className(\"android.widget.TextView\").text(\"行情\")").click();
            Thread.sleep(5000);

            //通过兄弟节点找到子节点
            driver.findElementByAndroidUIAutomator("resourceId(\"com.xueqiu.android:id/tab_name\").fromParent(text(\"我的\"))").click();
            Thread.sleep(3000);

            //通过父节点找到子节点
            driver.findElementByAndroidUIAutomator("resourceId(\"com.xueqiu.android:id/scroll_view\").childSelector(text(\"热门\"))").click();
            Thread.sleep(3000);

            //实现滚动查找元素，在关注页，点击“雪球路演 ”
            driver.findElementByAndroidUIAutomator("resourceId(\"com.xueqiu.android:id/scroll_view\").childSelector(text(\"关注\"))").click();
            Thread.sleep(3000);
            //new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text("查找的文本").instance(0));
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"雪球路演\").instance(0));").click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void assertTest(){

    }

}
