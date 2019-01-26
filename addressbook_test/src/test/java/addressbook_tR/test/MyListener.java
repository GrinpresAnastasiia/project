package addressbook_tR.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {
    public MyListener() {
        super();
    }
        //чтобы поставить Override (Code->Override Methods)
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            //super.beforeFindBy(by, element, driver);
            System.out.println("search: "+by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            //super.afterFindBy(by, element, driver);
            System.out.println(by+" found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            //super.onException(throwable, driver);
            System.out.println(throwable);
        }
     }

