package wework.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexie Jing
 * @date 2020 8月 2020/8/30 17:16
 * @project Java3
 */
public class toDoPage extends BasePage {

    public toDoPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public toDoPage addToDo(String text){
        click(By.id("h9p"));
        sendKeys(byText("写下你的待办事项…"),text);
        click(byText("保存"));
        return this;
    }

    public toDoPage selectToDo(String text){
        //*[@text='todo1']/../../..//*[@resource-id='com.tencent.wework:id/h7w']
        click(By.xpath("//*[@text='"+text+"']/../../..//*[@resource-id='com.tencent.wework:id/h7w']"));
        return this;
    }

    public List<String> getlist(){
        click(byText("显示已完成事项"));
        return driver.findElements(By.id("h7b"))
                    .stream()
                    .map(x->x.getText())
                    .collect(Collectors.toList());
    }


}
