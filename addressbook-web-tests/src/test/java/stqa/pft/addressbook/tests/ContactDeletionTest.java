package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
    app.getContactHelper().selectContactFromList(before - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertPopup();
    app.getNavigationHelper().goToHomepage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);

  }

  @Test
  public void testContactDeletionInEdit() throws Exception {
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
    app.getContactHelper().initContactModification(before - 1);
    app.getContactHelper().deleteContactInEditView();
    app.getNavigationHelper().goToHomepage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }

}