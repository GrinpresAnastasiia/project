package addressbook_tR.test;

import addressbook_tR.model.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGroupCreation extends TestBase {
    @Test
    public void testGroupCreation() {
        app.getGroupHelper().openGroupsPage();

        int before = app.getGroupHelper().getGroupsCount();

        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupName("name")
                .setGroupHeader("header")
                .setGroupFooter("footer"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before + 1);
    }

}


