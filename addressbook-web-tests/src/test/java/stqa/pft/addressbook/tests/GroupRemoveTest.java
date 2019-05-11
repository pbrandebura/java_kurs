package stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;

public class GroupRemoveTest extends TestBase {

  @Test
  public void testGroupRemove() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}