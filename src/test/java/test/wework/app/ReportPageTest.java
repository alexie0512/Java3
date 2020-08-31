package test.wework.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import wework.app.weWorkMainPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexie Jing
 * @date 2020 8月 2020/8/30 18:37
 * @project Java3
 */
class ReportPageTest {
    private static wework.app.weWorkMainPage weWorkMainPage;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        weWorkMainPage =new weWorkMainPage("com.tencent.wework",".launch.WwMainActivity");
    }


    @Test
    void addDailyReport() {
        weWorkMainPage.toWorkBench()
                .swipeDown()
                .toReportPage()
                .addDailyReport("test");
    }

    @Test
    void deleteDailyReport() {
        weWorkMainPage.toWorkBench()
                .swipeDown()
                .toReportPage()
                .viewRecord("test")
                .deleteDailyReport();
    }
}