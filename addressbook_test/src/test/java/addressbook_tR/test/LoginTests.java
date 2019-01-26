package addressbook_tR.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void testLogin(){
        app.getGroupHelper().click(By.xpath("//*[@onclick='document.logout.submit();']"));

        app.getGroupHelper().type(By.name("user"),"admin");
        app.getGroupHelper().type(By.name("pass"), "secret");

        app.getGroupHelper().click(By.cssSelector("[type=submit]"));


    }

}
