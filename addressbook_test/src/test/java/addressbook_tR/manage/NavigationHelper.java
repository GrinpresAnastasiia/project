package addressbook_tR.manage;

import org.openqa.selenium.WebDriver;

public class NavigationHelper extends  HelperBase {
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void openSite(String url) {
        wd.get(url);
    }
}
