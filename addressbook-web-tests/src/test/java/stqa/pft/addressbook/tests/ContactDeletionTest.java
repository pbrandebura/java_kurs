package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getContactHelper().selectContactFromList();
    app.getContactHelper().deleteSelectedContact();
    // Below line probably doesn't work correctly
    app.getContactHelper().closeAlertPopup();
  }

  @Test
  public void testContactDeletionInEdit() throws Exception {
    app.getContactHelper().initContactModification();
    app.getContactHelper().deleteContactInEditView();
  }

}