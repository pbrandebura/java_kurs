package stqa.pft.addressbook.tests;


import org.testng.annotations.Test;

public class GroupRemoveTest extends TestBase {

  @Test
  public void testGroupRemove() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectFirstGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    app.getGroupHelper().goToHomepage();
  }

}