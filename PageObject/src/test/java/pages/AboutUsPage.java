package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BasePage{

    @FindBy(css = ".sc-1vwyfow-5")
    private WebElement aboutUsText;






    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    public String getAboutUsText() {

        return aboutUsText.getText();
    }
}
