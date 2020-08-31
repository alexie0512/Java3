package test.wework.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import wework.app.weWorkMainPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexie Jing
 * @date 2020 8月 2020/8/31 11:04
 * @project Java3
 */
class toDoPageTest {
    private static weWorkMainPage weWorkMainPage;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        weWorkMainPage= new weWorkMainPage("com.tencent.wework",".launch.WwMainActivity");
    }

    @Test
    void addToDo() {
        weWorkMainPage.toTODO().addToDo("todoitem1");
    }

    @Test
    void selectToDo() {
        weWorkMainPage.toTODO().addToDo("todoitem2").selectToDo("todoitem1");
    }

    @Test
    void getlist() {
        System.out.println(weWorkMainPage.toTODO().getlist());
    }
}