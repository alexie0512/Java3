package wework.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

/**
 * @author Alexie Jing
 * @date 2020 8月 2020/8/30 17:42
 * @project Java3
 */
public class workBench extends BasePage {

    public workBench(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public workBench swipeDown() {
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
    }

    public ReportPage toReportPage(){
        click(byText("汇报"));
        return new ReportPage(driver);
    }


}
