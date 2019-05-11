package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() throws Exception {
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    app.getContactHelper().fillContactForm(new ContactData("ModifiedName", null, "lastname", "nickname", "111111111", "oo@oo.oo", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomepage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

  }
}