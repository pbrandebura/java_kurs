package stqa.pft.addressbook;


import org.testng.annotations.*;

public class GroupRemoveTest extends TestBase {

  @Test
  public void testGroupRemove() throws Exception {
    goToGroupPage();
    selectFirstGroup();
    deleteSelectedGroup();
    goToGroupPage();
  }

}