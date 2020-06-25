package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

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
        driver.manage().addCookie(new Cookie("pgv_pvi", "4687210496"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.1528439743.1592968694"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "8791165101315584"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "227331390"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325046121051"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688853084643378"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688853084643378"));
        driver.manage().addCookie(new Cookie("wwrtx.logined", "true"));
        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d", "1590652117,1590756055,1590990426,1593007142"));
        driver.manage().addCookie(new Cookie("Hm_lpvt_9364e629af24cb52acc78b43e8c9f77d", "1593007142"));
        driver.manage().addCookie(new Cookie("_gat", "1"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "paj6q98ypEy8PRwqpWuzIsBmJ6DVuaAny4hX_29gT3Grh2Iixv4QXAEQPaK707eQc6Ct_0KQQvfEImTLYfXesz4_NL7Ze85n6eg2xBshmqUTdZAGWxyRYc6A_poSnJMTwgGyip30V8F6o-bU1yfC_Yp9Fs6xjN86dL6_Zjohu57WN91qH1o2WHIlICRiYRJisI5cBSS8rHec9y4iCEBhy2cgKHRNjgfWG0oJHZ5zIfd03qR88MzzQ7fkLGpXClzKtfi-GtK5Dii6IGb2-shfTw"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a2961289"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "fZ1aotcN8ZKz5qvSLCD4uUq1KDKoVcFIygVeV-IAG1Kmu92FxyJKxkC7VeU7qXTB"));


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
