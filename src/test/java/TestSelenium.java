import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestSelenium {
    public static WebDriver driver;

    @BeforeEach
    public static void initDriver(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testSearch(){
        //input[@class ="s_ipt"] 搜索框
        //input[@id="su"] 搜索按钮
        driver.get("https://www.baidu.com/");
/*        Actions actions = new Actions(driver);*/
        driver.findElement(By.xpath("//input[@class =\"s_ipt\"]")).sendKeys("霍格沃兹测试学院");
        driver.findElement(By.xpath("//input[@id=\"su\"]")).click();
    }

    @AfterEach
    public static void tearDown(){
        driver.quit();
    }
}