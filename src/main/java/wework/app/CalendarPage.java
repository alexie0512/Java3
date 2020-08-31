package wework.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexie Jing
 * @date 2020 8月 2020/8/30 12:22
 * @project Java3
 */
public class CalendarPage extends BasePage{

    public CalendarPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public CalendarPage AddCalendar(String name, String time){
        click(By.id("h9p"));
        sendKeys(By.id("b58"),name);
        click(byText("保存"));
        return this;
    }

    public List<String> getCalendar(String time){
        if(time!=null){
            //todo:选择日期
        }
        return driver.findElements(By.id("gr5"))
                .stream()
                .map(x->x.getText())
                .collect(Collectors.toList());
    }


    public CalendarPage delCalendar(String text){
        click(byText(text));
        click(By.id("bi_"));
        driver.findElementByAndroidUIAutomator("resourceId(\"com.tencent.wework:id/bci\")").click();
        return this;

    }
}
