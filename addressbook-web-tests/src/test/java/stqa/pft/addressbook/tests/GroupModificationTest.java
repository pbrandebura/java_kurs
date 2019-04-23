package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectFirstGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("new2", "new2", null));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    app.getGroupHelper().goToHomepage();
  }
}