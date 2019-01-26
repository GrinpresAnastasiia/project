package addressbook_tR.manage;

import addressbook_tR.test.MyListener;
import addressbook_tR.test.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager{
    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private Properties properties;
    private EventFiringWebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
        properties=new Properties();
    }

    public void start() throws IOException {

        if (browser.equals(BrowserType.CHROME))
        {
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX))
        {
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }
        else if(browser.equals(BrowserType.EDGE))
        {
            wd = new EventFiringWebDriver(new EdgeDriver());
        }
        wd.register(new MyListener());
        String target=System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%properties",target))));

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
    }
    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public void stop() {
        wd.quit();
    }


}
