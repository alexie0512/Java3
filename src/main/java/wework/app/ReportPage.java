package wework.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;

/**
 * @author Alexie Jing
 * @date 2020 8月 2020/8/30 17:59
 * @project Java3
 */
public class ReportPage extends BasePage{

    public ReportPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    public void swipeDown() {
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

    public ReportPage addDailyReport(String text){
        click(byText("日报"));
        sendKeys(byText("请输入"),text);
        swipeDown();
        click(By.xpath("//*[@content-desc='提交']"));
        driver.findElementByAndroidUIAutomator("resourceId(\"com.tencent.wework:id/bca\")").click();
        click(By.id("bci"));
        //回到汇报>新建首页
        click(By.id("h9e"));
        return this;
    }

    public ReportPage deleteDailyReport(){
        click(By.id("h9p"));
        driver.findElementByAndroidUIAutomator("text(\"删除\")").click();
        click(byText("确定"));
        return this;
    }

    public ReportPage viewRecord(String text){
        click(byText("记录"));
        click(byText("我提交的"));
        click(By.xpath("//*[@text='今日工作："+text+"']/../.."));
        return this;
    }

}
