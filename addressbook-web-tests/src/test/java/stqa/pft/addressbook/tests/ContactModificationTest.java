package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() throws Exception {
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
    app.getContactHelper().initContactModification(before - 1);
    app.getContactHelper().fillContactForm(new ContactData("ModifiedName", null, "lastname", "nickname", "111111111", "oo@oo.oo", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomepage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}