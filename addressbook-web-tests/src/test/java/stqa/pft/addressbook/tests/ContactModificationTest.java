package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test(enabled = false)
  public void testContactModification() throws Exception {
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData("ModifiedName", null, "lastname", "nickname", "111111111", "oo@oo.oo", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomepage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> getId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(getId);
    after.sort(getId);
    Assert.assertEquals(before, after);
  }
}