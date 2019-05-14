package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() throws Exception {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group =
            new GroupData().withId(before.get(index).getId()).withName("test1").withHeader("test3").withFooter("test3");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> getId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(getId);
    after.sort(getId);
    Assert.assertEquals(before, after);
  }

}