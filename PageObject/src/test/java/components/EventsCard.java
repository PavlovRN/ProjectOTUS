package components;

import data.CalendarData;
import data.EventsSortingData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EventsCard extends BasePage {

    public EventsCard(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dod_new-events__list.js-dod_new_events a")
    private List<WebElement> eventsList;

    @FindBy(css = ".dod_new-event__time")
    private List<WebElement> eventsDateList;

    @FindBy(css = ".dod_new-events-dropdown__input")
    private WebElement sortEventsMenu;

    private String sortEventsOpen = "div[class*='dod_new-events-dropdown_opened'] a[title='Открытый вебинар']";

    public EventsCard checkVisibleEvents() {

        for (WebElement element : eventsList) {
            Assertions.assertTrue(element.isDisplayed());
        }
        return this;
    }

    public EventsCard checkEventsDate() {

        List<String> eventsDateListString = new ArrayList<>();
        List<LocalDate> eventsDateListDate = new ArrayList<>();
        for (WebElement element : eventsDateList) {
            eventsDateListString.add(element.getText());
        }
        for (String string : eventsDateListString) {
            String date = string.split(" ")[0] + " ";
            String month = string.split(" ")[1];
            date += month.replaceAll("[а-я]+", CalendarData.getCalendarData(month).getId()) + " " + "2023";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d MM yyyy", Locale.ROOT));
            if (string.equals("Сейчас в эфире")) {
                eventsDateListDate.add(LocalDate.now());
            } else {
                eventsDateListDate.add(localDate);
            }
        }
        for (LocalDate localDate : eventsDateListDate) {
            Assertions.assertTrue(localDate
                    .isAfter(LocalDate.now()) || localDate.isEqual(LocalDate.now()));
        }
        return this;
    }

    public EventsCard sortingEvents(EventsSortingData eventsSortingData) {

        sortEventsMenu.click();
        String locator = String.format(sortEventsOpen, eventsSortingData.getNameFilter());
        loc(By.cssSelector(locator)).click();
        return this;
    }
}