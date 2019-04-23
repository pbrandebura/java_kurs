package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
    app.getContactHelper().selectContactFromList();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertPopup();
  }

  @Test
  public void testContactDeletionInEdit() throws Exception {
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().deleteContactInEditView();
  }

}