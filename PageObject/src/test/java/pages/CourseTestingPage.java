package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseTestingPage extends BasePage {

    @FindBy(css = "h1.sc-1og4wiw-0.sc-s2pydo-1.bojQOq.diGrSa")
    private WebElement title;
    @FindBy(css = ".sc-1og4wiw-0.sc-s2pydo-3.jweyVs.dZDxRw")
    private WebElement description;
    @FindBy(css = ".sc-x072mc-0.sc-3cb1l3-1.hOtCic.galmep .sc-3cb1l3-3.jeNzke .sc-3cb1l3-4.kGoYMV:first-child")
    private WebElement startFrom;

    @FindBy(css = ".sc-x072mc-0.sc-3cb1l3-1.hOtCic.galmep .sc-3cb1l3-3.jeNzke .sc-3cb1l3-4.kGoYMV:nth-child(2)")
    private WebElement duration;

    private final By testingCource = By.cssSelector("sc-18q05a6-1 bwGwUO");


    public CourseTestingPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getStartFrom() {
        return startFrom.getText();
    }




    public String getDuration() {
        return duration.getText();
    }
}
