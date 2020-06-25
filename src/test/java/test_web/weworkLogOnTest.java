package test_web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class weworkLogOnTest {


    @Test
    void logOnWeChatWork() {

        String url = "https://work.weixin.qq.com/wework_admin/frame";
        ChromeDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.get(url);

// 方法一: document.cookie or console.log(document.cookie), it's not working as it's missing a few cookie
/*
        driver.manage().addCookie(new Cookie("pgv_pvid","6983151680"));
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan","en"));
        driver.manage().addCookie(new Cookie("_ga","GA1.2.1012854905.1590652117"));
        driver.manage().addCookie(new Cookie("_gid","GA1.2.516704005.1590990426"));
        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d","1590652117,1590756055,1590990426"));
        driver.manage().addCookie(new Cookie("Hm_lpvt_9364e629af24cb52acc78b43e8c9f77d","1590990426"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st","a3258907"));
        driver.manage().addCookie(new Cookie("wxpay.corpid","1970325046121051"));
        driver.manage().addCookie(new Cookie("wxpay.vid","1688853084643378"));
        driver.manage().addCookie(new Cookie("wwrtx.vid","1688853084643378"));
        driver.manage().addCookie(new Cookie("wwrtx.logined","true"));
*/


        //方法二: 利用curl 命令从给开发者工具中copy as curl 提取cookie
        //echo "" | awk 'BEGIN{RS="; ";FS="="}{print "driver.manage().addCookie(new Cookie(\""$1"\", \""$2"\"));"}'
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
}
