import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import rules.WebDriverRule;


/**
 * Created by mmenkov on 26.05.17.
 */
public class MarketTest {

    @Rule
    public WebDriverRule webDriverRule = new WebDriverRule();

    private WebDriver driver;
    @Before
    public void initDriver() {
        driver = webDriverRule.getDriver();
    }
    @Test
    public void tvTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        MarketPage marketPage = mainPage.getMarketPage();
        ElectronicsPage electronicsPage = marketPage.getElectronicsPage();
        SearchPage tvSearchPage = electronicsPage.getTVSearchPage();
        AdvancedSearchPage advancedSearchPage = tvSearchPage.getAdvancedSearchPage();
        advancedSearchPage.setPriceFrom("20000");
        advancedSearchPage.useCheckboxByName("LG");
        advancedSearchPage.useCheckboxByName("Samsung");
        SearchPage resultSearchPage = advancedSearchPage.getSearchPage();
        Assert.assertTrue(resultSearchPage.getResultList().size() == 12);
        String nameOfFirstElement = resultSearchPage.getResultList().get(0).getText();
        ResultPage resultPage = resultSearchPage.searchElementByName(nameOfFirstElement);
        Assert.assertEquals(resultPage.getResultElemetName(), nameOfFirstElement);
    }

    @Test
    public void headphonesTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        MarketPage marketPage = mainPage.getMarketPage();
        ElectronicsPage electronicsPage = marketPage.getElectronicsPage();
        SearchPage headphonesSearchPage = electronicsPage.getHeadphonesSearchPage();
        AdvancedSearchPage advancedSearchPage = headphonesSearchPage.getAdvancedSearchPage();
        advancedSearchPage.setPriceFrom("5000");
        advancedSearchPage.useCheckboxByName("Beats");
        SearchPage resultSearchPage = advancedSearchPage.getSearchPage();
        Assert.assertTrue(resultSearchPage.getResultList().size() == 12);
        String nameOfFirstElement = resultSearchPage.getResultList().get(0).getText();
        ResultPage resultPage = resultSearchPage.searchElementByName(nameOfFirstElement);
        Assert.assertEquals(resultPage.getResultElemetName(), nameOfFirstElement);
    }

}
