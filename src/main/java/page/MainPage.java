package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {

    public static ChromeDriver driver = null;


    public MainPage(){
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        
        //todo: 改成从文件读取

        driver.manage().addCookie(new Cookie("cookie: pgv_pvid", "6983151680"));
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "en"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.1012854905.1590652117"));
        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d", "1590652117,1590756055,1590990426"));
        driver.manage().addCookie(new Cookie("pgv_pvi", "4687210496"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "8791165101091529"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "3602408383"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.1528439743.1592968694"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "6UN7SPhhde_g6N_BJzxpNpUU8mKpW8L3MqhbKFc1sBvjVh9zpZzww3lHEPaBLtroSkaD7UJ7hWJyLjvGpdsxir6VFjAU0Qt-8DqUlEenEg9RhtjtghM_LNGBmgomHiAu6bEydWVzJAvc7qoHJDDNYahfHSkRHjET1nTYHCPLnM-yk7iJpXiI3-aAyBd2NxNf85Wzn_9G1nDbiVs92Hz7d-7NJh_2FjGFDuV_3xI7ztgqQZsbjFZihrc_H9oWIdi9ufMRxv_ZGcPL5nZ-n_Bxuw"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a8172312"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "fZ1aotcN8ZKz5qvSLCD4uatUsZxQu2sAlzFu20uycDTxT0nGdMUoHAvtj-eNm7qT"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325046121051"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688853084643378"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688853084643378"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));
        driver.manage().addCookie(new Cookie("_gat", "1"));

        System.out.println(driver.manage().getCookies());
        driver.get(url);
    }

    //From Main Page to Contact Page
    public ContactPage toContact(){
        //todo
        driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage();
    }
}
