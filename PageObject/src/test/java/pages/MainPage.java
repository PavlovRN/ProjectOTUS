package pages;

import components.CourseCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(css = ".sc-gg1znw-0 > div")
    private List<WebElement> courses;
    private List<CourseCard> cards = new ArrayList<>();

    @FindBy(css = ".sc-pzx9cw-0")
    private WebElement menu;

    @FindBy(css = "a[href=\"/about\"] .sc-nrqod9-1")
    private WebElement aboutUs;

   // private WebElement teachingButton = driver.findElement(By.cssSelector(".sc-1youhxc-1.cMNIlZ"));
   private final String TEACHING = ".sc-1youhxc-1.cMNIlZ";
    private  WebElement events = driver.findElement(By.cssSelector(".sc-v5wu4-2.hKGuLv :nth-child(3)"));

    @FindBy(css = TEACHING)
    private WebElement teachingButton;


    public EventsPage EventsPage(){
        actions
                .moveToElement(teachingButton)
                .moveToElement(events)
                .click()
                .build()
                .perform();
        return new EventsPage(driver);
    }





    public MainPage(WebDriver driver) {
        super(driver);
        for (WebElement element : courses)
            cards.add(new CourseCard(element));
        url = "http://otus.ru";
    }

    public CatalogPage menuClick(int el) {
        String loc = "div:nth-child(" + el + ")";
        menu.findElement(By.cssSelector(loc)).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("catalog/"));

        return new CatalogPage(driver);
    }

    public AboutUsPage aboutUsClick() {
        aboutUs.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("about"));
        return new AboutUsPage(driver);
    }


    public List<CourseCard> getCards() {
        return cards;
    }
}
