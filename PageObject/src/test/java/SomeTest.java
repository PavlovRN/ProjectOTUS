import components.EventsCard;
import data.EventsSortingData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CourseTestingPage;
import pages.EventsPage;
import pages.MainPage;

public class SomeTest {

    private WebDriver driver;

    @BeforeAll
    public static void install() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
         ChromeOptions options = new ChromeOptions();
         options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void setDown() {
        if (driver != null)
            driver.quit();
    }


    @Test
    public void testCourceTesting() {
        driver.get("https://otus.ru");
        CourseTestingPage page = new MainPage(driver)
                .menuClick(10)
                .getCards()
                .get(4)
                .click(driver);

        System.out.println("Описание = " + page.getDescription());
        System.out.println("Наименование = " + page.getTitle());
        System.out.println("Продолжительность = " + page.getDuration());
    }

    @Test
    public void quantityTestingCourses() {
        driver.get("https://otus.ru");
        int quantitycourses = new MainPage(driver)
                .menuClick(10)
                .getCards()
                .size();

        Assertions.assertEquals(12, quantitycourses);


    }

    @Test
    public void checkEventDateValidation(){
        driver.get("https://otus.ru");
        new MainPage(driver)
                .EventsPage();
        new EventsCard(driver)
                .checkVisibleEvents()
                .checkEventsDate();

    }

    @Test
        public void checkEventTypeValidation() {
        driver.get("https://otus.ru");
       new MainPage(driver)
               .EventsPage();
       new EventsCard(driver)
               .sortingEvents(EventsSortingData.OPEN_WEBINAR);
       new EventsPage(driver)
               .checkSortingByEvent(EventsSortingData.OPEN_WEBINAR);



    }
}

















