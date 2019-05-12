package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test2", "test2", "test3");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

//    int max = 0;
//    for(GroupData g: after){
//      if(g.getId() > max){
//        max = g.getId();
//      }
//    }

    //change list into stream, compare object, selecting max and get ID
    int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();

    group.setId(max);
    before.add(group);
    Comparator<? super GroupData> getId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(getId);
    after.sort(getId);
    Assert.assertEquals(before, after);
  }

}