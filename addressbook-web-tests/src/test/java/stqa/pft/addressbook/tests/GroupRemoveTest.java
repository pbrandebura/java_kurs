package stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;

public class GroupRemoveTest extends TestBase {

  @Test
  public void testGroupRemove() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }
    app.getGroupHelper().selectFirstGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    app.getNavigationHelper().goToHomepage();
  }

}