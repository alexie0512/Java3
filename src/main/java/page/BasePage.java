package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Alexie Jing
 * @date 2020 6月 2020/6/24 13:54
 * Java3
 */

public class BasePage {
    public RemoteWebDriver driver;
    ChromeOptions options;

    WebDriverWait wait;

    public BasePage() {

/*        ChromeOptions options = new ChromeOptions();
        options.AddArguments("--lang=es");
        ChromeDriver driver = new ChromeDriver(options);*/
        options = new ChromeOptions();
        options.addArguments("--lang=es");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,5);
    }

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public void quit() {
        driver.quit();
    }

    public void click(By by){
        //todo:异常处理
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }


    public void sendKeys(By by, String Str){
        //todo：异常处理
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(Str);
    }


    public void upload(By by,String path){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(path);
    }


}
