package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mmenkov on 26.05.17.
 */
public class ElectronicsPage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='catalog-menu__list']/a[. = 'Телевизоры']")
    private WebElement tvLink;

    @FindBy(xpath = "//div[@class='catalog-menu__list']/a[. = 'Наушники и Bluetooth-гарнитуры']")
    private WebElement headphonesLink;

    public ElectronicsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SearchPage getTVSearchPage() {
        tvLink.click();
        return new SearchPage(driver);
    }

    public SearchPage getHeadphonesSearchPage() {
        headphonesLink.click();
        return new SearchPage(driver);
    }
}
