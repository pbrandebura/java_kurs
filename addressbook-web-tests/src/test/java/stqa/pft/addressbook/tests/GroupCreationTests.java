package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData("test2", "test2", "test3");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);
    
    before.add(group);
    Comparator<? super GroupData> getId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(getId);
    after.sort(getId);
    Assert.assertEquals(before, after);
  }

}