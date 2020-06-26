package test.xueqiu.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import xueqiu.app.MainPage;
import xueqiu.app.SearchPage;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexie Jing
 * @date 2020 6月 2020/6/26 16:22
 * @project Java3
 */
class SearchPageTest {
    static MainPage mainPage;
    static SearchPage searchPage;


    @BeforeAll
    static void beforeAll(){
        mainPage = new MainPage();
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba,  阿里巴巴",
            "jd,    京东"
    })
    void search(String keyword, String name) {
        //searchPage.search("alibaba").getSearchList()，"阿里巴巴"
        assertEquals(searchPage.search("alibaba").getSearchList().get(0),name);
    }

    @Test
    void getPrice() {
        assertTrue(searchPage.search("alibaba").getPrice()>200);
    }
}