package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1");
    app.getContactHelper().createContact(contact, true);
    app.goTo().homePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> getId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(getId);
    after.sort(getId);
    Assert.assertEquals(before, after);
  }

}