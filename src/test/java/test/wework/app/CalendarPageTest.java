package test.wework.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import wework.app.weWorkMainPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexie Jing
 * @date 2020 8月 2020/8/30 12:33
 * @project Java3
 */
class CalendarPageTest {
    private static weWorkMainPage weWorkMainPage;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        weWorkMainPage =new weWorkMainPage("com.tencent.wework",".launch.WwMainActivity");
    }

    @Test
    void addCalendar() {
        assertTrue(
                weWorkMainPage.toCalendar()
                        .AddCalendar("上班打卡2",null)
                        .getCalendar(null)
                        .contains("上班打卡"));
    }

    @Test
    void getCalendar() {
        assertTrue(
                weWorkMainPage.toCalendar()
                        .getCalendar(null)
                        .contains("上班打卡"));
    }
}