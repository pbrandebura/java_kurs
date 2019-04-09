package stqa.pft.addressbook.tests;


import org.testng.annotations.*;

public class GroupRemoveTest extends TestBase {

  @Test
  public void testGroupRemove() throws Exception {
    app.goToGroupPage();
    app.selectFirstGroup();
    app.deleteSelectedGroup();
    app.goToGroupPage();
  }

}