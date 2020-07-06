package test.xueqiu.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import xueqiu.app.MainPage;
import xueqiu.app.SearchPage;
import xueqiu.app.SearchResultPage;
import xueqiu.app.TrendPage;

import java.net.MalformedURLException;

/**
 * @author Alexie Jing
 * @date 2020 7月 2020/7/1 13:17
 * @project Java3
 */
public class TrendPageTest {
    static MainPage main;
    static TrendPage trend;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        trend = new MainPage().toTrend();
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba,  BABA",
            "jd,   JD",
            "google,  GOOAV"
    })
    public void addStockTest(String keyword, String CODE){
        trend.trendtoSearch().searchAndReturn(keyword,CODE)
                .toStockResult().addStock(CODE).cancelSearchtoTrend();
    //toStockResult().addStock("JD").cancelSearchtoTrend();
                //addStock("jd","JD").deleteStock("JD");
    }

    @Test
    public void deleteStockTest(){
        trend.deleteSignleStock("JD"); //trend.deleteAllStock();
    }

    @Test
    public void deleteAllStockTest(){
        trend.deleteAllStock();
    }

    @AfterAll
    public static void quit(){
        trend.quit();
    }
}
