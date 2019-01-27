import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Droppable extends TestBase{

    @Test
    public void testDroppableActions()
    {
        wd.navigate().to("https://jqueryui.com/droppable/");
        new Actions(wd).moveToElement(wd.findElement(By.id("draggable")))
              .clickAndHold().moveToElement(wd.findElement(By.id("droppable"))).release().perform();
    }



}
