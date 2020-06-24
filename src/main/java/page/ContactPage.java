package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactPage {
    By addmemberLocator = By.cssSelector(".ww_operationBar:nth-child(1) > .js_add_member");
    By searchmemberLocator = By.id("memberSearchInput");
    long time;


    //addContact
    public ContactPage addMember(String username, String acctid, String mobile) {
        //todo
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new WebDriverWait(MainPage.driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(addmemberLocator));

        new WebDriverWait(MainPage.driver, 10)
                .until(ExpectedConditions.elementToBeClickable(addmemberLocator));
        MainPage.driver.findElement(addmemberLocator).click();

        new WebDriverWait(MainPage.driver, 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(addmemberLocator));

        MainPage.driver.findElement(By.name("username")).sendKeys(username);
        MainPage.driver.findElement(By.name("acctid")).sendKeys(acctid);
        MainPage.driver.findElement(By.name("mobile")).sendKeys(mobile);
        MainPage.driver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;

    }

    //searchContact
    public ContactPage searchContact(String searchStr) {
        //todo
        MainPage.driver.findElement(searchmemberLocator).sendKeys(searchStr);
        new WebDriverWait(MainPage.driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("删除")));
        return this;
    }

    //deleteContact
    public ContactPage deleteContact() {
        try {
            Thread.sleep(4000);
            MainPage.driver.findElement(By.linkText("删除")).click();
            MainPage.driver.findElement(By.linkText("确认")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

}
