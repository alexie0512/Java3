package wework.app;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

/**
 * @author Alexie Jing
 * @date 2020 8月 2020/8/30 12:22
 * @project Java3
 */
public class weWorkMainPage extends BasePage{

    public weWorkMainPage(String appPackage, String appActivity) throws MalformedURLException {
        super(appPackage, appActivity);
    }

    public CalendarPage toCalendar(){
        click(By.xpath("//*[@text='日程']"));
        return new CalendarPage(driver);
    }

    public toDoPage toTODO(){
        click(byText("待办"));
        return new toDoPage(driver);
    }

    public workBench toWorkBench(){
        click(byText("工作台"));
        return new workBench(driver);
    }


}
