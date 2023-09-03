package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CourseCard {
    private WebElement card;

    public CourseCard(WebElement element){
        card = element;
    }

    public String getCourseName(){
        return card.findElement(By.tagName("H5")).getText();
    }


    public void click(){
        card.click();
    }
}
