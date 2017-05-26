package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by mmenkov on 26.05.17.
 */
public class SearchPage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='n-filter-panel-aside__show-more']/a")
    private WebElement advabcedPageLink;

    @FindBy(xpath = "//span[@class='snippet-card__header-text']")
    private List<WebElement> resultList;

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement searchArrow;

    @FindBy(xpath = "//button/*[. = 'Найти']/..")
    private WebElement searchButton;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AdvancedSearchPage getAdvancedSearchPage() {
        advabcedPageLink.click();
        return new AdvancedSearchPage(driver);
    }

    public List<WebElement> getResultList() {
        return resultList;
    }

    public ResultPage searchElementByName(String name) {
        searchArrow.sendKeys(name);
        searchButton.click();
        return new ResultPage(driver);
    }
}
