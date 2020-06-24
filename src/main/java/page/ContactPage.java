package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactPage extends BasePage {
    By addmemberLocator = By.cssSelector(".ww_operationBar:nth-child(1) > .js_add_member");
    By searchmemberLocator = By.id("memberSearchInput");

    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    //addContact
    public ContactPage addMember(String username, String acctid, String mobile) {
        /* todo */
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


/*        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(addmemberLocator));

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(addmemberLocator));
        driver.findElement(addmemberLocator).click();

        //todo:就算可点击，仍然会有一定概率是点击不成功的
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(addmemberLocator));*/

        while(driver.findElements(By.name("username")).size()==0){
            click(addmemberLocator);
        }
        sendKeys(By.name("username"),username);
        sendKeys(By.name("acctid"),acctid);
        sendKeys(By.name("mobile"),mobile);
/*        driver.findElement(By.cssSelector(".js_btn_save")).click();*/
        click(By.cssSelector(".js_btn_save"));
        return this;

    }

    //searchContact
    public ContactPage searchContact(String searchStr) {
        /* todo */
        sendKeys(searchmemberLocator,searchStr);
/*        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("删除")));*/
        return this;
    }

    //deleteContact
    public ContactPage deleteContact() {
        click(By.cssSelector(".js_del_member"));
        click(By.linkText("确认"));
        return this;
    }

}
