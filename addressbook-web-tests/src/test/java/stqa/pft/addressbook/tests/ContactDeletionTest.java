package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test(enabled = false)
  public void testContactDeletion() throws Exception {
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
    app.getContactHelper().selectContactFromList(before - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertPopup();
    app.goTo().homePage();
    int after = app.getContactHelper().getContactCount();
    //Assert.assertEquals(after, before - 1);

  }

  @Test(enabled = false)
  public void testContactDeletionInEdit() throws Exception {
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    app.getContactHelper().deleteContactInEditView();
    app.goTo().homePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(after, before);
  }

}