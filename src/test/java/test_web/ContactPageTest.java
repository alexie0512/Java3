package test_web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.ContactPage;
import page.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactPageTest {
    static MainPage main;
    static ContactPage contact;
    @BeforeAll
    static void init() {
        main = new MainPage();
        contact= main.toContact();
    }


    @Test()
    void testAddMember() {
        contact.addMember("AlexisTest02", "TestAccount02", "17821460513");
        //todo: assertion
    }


    @Test()
    void testSearchandDelete() {
        contact.searchContact("AlexisTest03").deleteContact();

    }

    @Test
    void testimportFromFile(){
        //todo:file:/C:/Users/Alexie%20Jing/IdeaProjects/Java3/target/classes/Template%20of%20batch%20import%20to%20Contacts.xlsx
        //System.out.println(this.getClass().getResource("/Template of batch import to Contacts.xlsx"));
        //contact.importFromFile(this.getClass().getResource("\\Template of batch import to Contacts.xlsx"));
        //"C:\\Users\\Alexie Jing\\IdeaProjects\\Java3\\src\\main\\resources\\Template of batch import to Contacts.xlsx"
        contact.importFromFile("C:\\Users\\Alexie Jing\\IdeaProjects\\Java3\\src\\main\\resources\\Template of batch import to Contacts.xlsx");
    }


    @Test
    void workflow(){
        String username = contact.addMember("AlexisTest02", "TestAccount02", "17821460513")
                .searchContact("AlexisTest02").getUserName();
        assertEquals(username,"AlexisTest02");
    }

    @Test
    void addanddeleteDepart(){
        contact.addDepartment("TestAddDept").findanddeleteDepartment("TestAddDept");
    }

    @Test
    void addanddeleteTag(){
        contact.addTag("TestAddTag").findanddeleteTag("TestAddTag");

    }


    @AfterAll
    static void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contact.quit();

    }
}
