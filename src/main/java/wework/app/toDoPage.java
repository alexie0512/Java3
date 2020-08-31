package wework.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @author Alexie Jing
 * @date 2020 8月 2020/8/30 17:16
 * @project Java3
 */
public class toDoPage extends BasePage {

    public toDoPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public toDoPage addToDo(){
        click(By.id("h9p"));
        sendKeys(By.id("B58"),"TODO1");
        click(byText("保存"));
        return this;
    }

    public toDoPage selectToDo(String text){
        //*[@text='todo1']/../../..//*[@resource-id='com.tencent.wework:id/h7w']
        click(By.xpath("//*[@text='"+text+"']/../../..//*[@resource-id='com.tencent.wework:id/h7w']"));
        return this;
    }





}
