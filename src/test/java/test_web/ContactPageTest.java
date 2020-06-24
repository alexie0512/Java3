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
        contact.addMember("AlexisTest03", "TestAccount03", "17821460514");
        //todo: assertion
    }


    @Test()
    void testSearchandDelete() {
        contact.searchContact("AlexisTest03").deleteContact();

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
