package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mmenkov on 26.05.17.
 */
public class ResultPage {

    private final WebDriver driver;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement resultElementName;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getResultElemetName() {
        return resultElementName.getText();
    }
}
