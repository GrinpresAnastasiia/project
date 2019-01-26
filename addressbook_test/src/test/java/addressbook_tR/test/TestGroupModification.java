package addressbook_tR.test;

import addressbook_tR.model.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestGroupModification extends TestBase
{
    @BeforeMethod
    public void preconditions()
    {
        app.getGroupHelper().openGroupsPage();
        if(!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }
    }
    @Test
    public void testGroupModification()
    {
        app.getGroupHelper().openGroupsPage();
        int before= app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupName("modifyed")
                .setGroupHeader("new")
                .setGroupFooter("space"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
        int after= app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after,before);
    }

}


