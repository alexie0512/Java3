package test_web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.ContactPage;
import page.MainPage;

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
        contact.searchContact("AlexisTest02").deleteContact();

    }

    @AfterAll
    static void tearDown() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main.quit();

    }
}
