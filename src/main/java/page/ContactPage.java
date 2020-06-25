package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;


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

        while (driver.findElements(By.name("username")).size() == 0) {
            click(addmemberLocator);
        }
        sendKeys(By.name("username"), username);
        sendKeys(By.name("acctid"), acctid);
        sendKeys(By.name("mobile"), mobile);
        /*        driver.findElement(By.cssSelector(".js_btn_save")).click();*/
        click(By.cssSelector(".js_btn_save"));
        return this;

    }

    //searchContact
    public ContactPage searchContact(String searchStr) {
        /* todo */
        sendKeys(searchmemberLocator, searchStr);
/*        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("删除")));*/
        return this;
    }

    //deleteContact
    public ContactPage deleteContact() {
        click(By.cssSelector(".js_del_member"));
        click(By.linkText("Confirm"));
        return this;
    }


    //batchImportContacts
    public ContactPage importFromFile(String path) {
        //todo:
        click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
        click(By.linkText("File import"));

        upload(By.name("file"), path);
        click(By.id("submit_csv"));
        click(By.id("reloadContact"));
        return this;
    }

    public String getUserName() {
        return driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
    }

    //addDepartment
    public ContactPage addDepartment(String departName) {
        click(By.cssSelector(".member_colLeft_top_addBtn"));
        click(By.linkText("Add departments")); //Add departments
        click(By.name("name"));
        sendKeys(By.name("name"), departName);
        //click(By.xpath(""));
        click(By.linkText("Select the department")); //选择所属部门 //Select the department
        click(By.xpath("(//a[contains(text(),'Alexie_ServiceTestAccount')])[2]"));
        click(By.linkText("Confirm")); //Confirm //确定
        return this;
    }


    //find&deleteDepartment
    public ContactPage findanddeleteDepartment(String departName) {
        //driver.findElement(By.xpath("//a[contains(text(),\'"+departName+"\')]")).getAttribute("id");
        click(By.xpath("//a[contains(text(),'" + departName + "')]/span[@class=\"icon jstree-contextmenu-hover\"]"));
        click(By.xpath("//ul[@class=\"vakata-context jstree-contextmenu jstree-default-contextmenu\"]/li/a[contains(text(),'Delete')]"));
        click(By.linkText("Confirm"));
        return this;
    }

    //addTag
    public ContactPage addTag(String tag) {
        click(By.linkText("Tag"));
        click(By.cssSelector(".member_colLeft_top_addBtnWrap"));
        click(By.name("name"));
        sendKeys(By.name("name"), tag);
        click(By.linkText("Creator (and the admin group) only"));
        click(By.linkText("Creator (and the admin group) only"));
        click(By.linkText("Confirm"));
        return this;
    }


    //findanddeleteTag
    public ContactPage findanddeleteTag(String tag) {
        click(By.linkText("Tag")); //标签 //Tag
        /*     click(By.cssSelector(".member_tag_list_moreBtn"));*/
        click(By.xpath("//li[contains(text(),'" + tag + " ')]/a[@class=\"member_tag_list_moreBtn\"]"));
        click(By.xpath("//ul[@class=\"vakata-context jstree-contextmenu jstree-default-contextmenu\"]/li/a[contains(text(),'Delete')]"));
        click(By.linkText("Confirm"));
        return this;
    }

}
