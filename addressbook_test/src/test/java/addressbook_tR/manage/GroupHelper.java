package addressbook_tR.manage;


import addressbook_tR.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver wd) {
        super(wd);

    }

    public void returnToGroupsPage() {
        click(By.cssSelector("i a[href='group.php']"));
    }

    public void deleteGroup() {
        click(By.xpath("//*[@id=\"content\"]/form/input[2]"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void openGroupsPage() {
        click(By.cssSelector("[href='group.php']"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }


    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void initGroupModification() {
        click(By.xpath("//*[@id='content']/form/input[3]"));
    }


    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup() {
        initGroupCreation();
        fillGroupForm(new Group()
                .setGroupName("name")
                .setGroupHeader("header")
                .setGroupFooter("footer"));
        submitGroupCreation();
        returnToGroupsPage();
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


}
