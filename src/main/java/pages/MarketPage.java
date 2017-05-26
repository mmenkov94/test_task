package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mmenkov on 26.05.17.
 */
public class MarketPage {

    private final WebDriver driver;

    @FindBy(xpath = "//noindex/ul/li[1]")
    private WebElement electronicsLink;

    public MarketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ElectronicsPage getElectronicsPage() {
        electronicsLink.click();
        return new ElectronicsPage(driver);
    }
}
