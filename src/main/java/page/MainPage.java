package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {
    public MainPage() {
        super();
        String url = "https://work.weixin.qq.com/wework_admin/frame#index";
        driver.get(url);
        driver.manage().deleteAllCookies();

        //todo: 改成从文件读取

        driver.manage().addCookie(new Cookie("pgv_pvid", "6983151680"));
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "en"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.1012854905.1590652117"));
        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d", "1590652117,1590756055,1590990426"));
        driver.manage().addCookie(new Cookie("pgv_pvi", "4687210496"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.1528439743.1592968694"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "8791165101315584"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "227331390"));
        driver.manage().addCookie(new Cookie("_gat", "1"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "llfyvIV3k3yes2c-gxHWdz-ciC97MevmCkNuxiWNIOS8Ekt0CwCKwqYQV9gTFDtcDvGGgPV8HbxdWuBRw8vb42uro5wH0zpa6xXpSeyrpNOc314J39Ck5P76kkoIneYbqgpsySODwG1uDS-PKKmT6Yx476zvelEisoe2aC3zNaiRL9hzolUy5cABSnjT-MshO3X27feDnq_SD8Z1Uh65Jql3qlNIuKbPU-xjLQ9zrXiEVd8m0PG2mGRwi_1kq34Utf3_qOz43dQOvGKPVwS5zw"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a1852661"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "fZ1aotcN8ZKz5qvSLCD4uYZ5w1gUuTsoCZ3N5vubd0Effgkyut-GwHhfxkWOsxL2"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325046121051"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688853084643378"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688853084643378"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));

        System.out.println(driver.manage().getCookies());
        driver.get(url);
    }

    //From Main Page to Contact Page
    public ContactPage toContact() {
        //todo
        click(By.cssSelector("#menu_contacts"));
        return new ContactPage(driver);
    }

}
