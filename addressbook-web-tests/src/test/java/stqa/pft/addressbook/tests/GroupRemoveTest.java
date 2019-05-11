package stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupRemoveTest extends TestBase {

  @Test
  public void testGroupRemove() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }

}