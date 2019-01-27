import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Draggable extends TestBase
{
    @Test
    public void testDraggableActions()
    {
        wd.navigate().to("https://jqueryui.com/draggable/");
        WebElement box=wd.findElement(By.id("draggable"));
        new Actions(wd).moveToElement(box).clickAndHold().moveByOffset(0,250).release()
                        .pause(2000).clickAndHold(box).moveByOffset(250,-250).release().perform();
    }
}
