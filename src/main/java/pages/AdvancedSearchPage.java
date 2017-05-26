package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mmenkov on 26.05.17.
 */
public class AdvancedSearchPage {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id='glf-pricefrom-var']")
    private WebElement priceFromInput;

    @FindBy(xpath = "//a/span[. = 'Показать подходящие']/..")
    private WebElement searchPageLink;

    public AdvancedSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setPriceFrom(String priceFrom) {
        priceFromInput.sendKeys(priceFrom);
    }

    public void useCheckboxByName(String name) {
        driver.findElement(By.xpath("//label[. = '"+name+"']")).click();
    }

    public SearchPage getSearchPage(){
        searchPageLink.click();
        return new SearchPage(driver);
    }
}
