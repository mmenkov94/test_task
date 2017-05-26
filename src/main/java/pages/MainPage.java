package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mmenkov on 26.05.17.
 */
public class MainPage {

    private static final String MAIN_PAGE_URL = "https://yandex.ru";

    private final WebDriver driver;

    @FindBy(xpath = "//div[@class = 'home-arrow__tabs']//a[@data-id='market']")
    private WebElement marketLink;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void open() {
        driver.get(MAIN_PAGE_URL);
    }
    public MarketPage getMarketPage() {
        marketLink.click();
        return new MarketPage(driver);
    }
}

