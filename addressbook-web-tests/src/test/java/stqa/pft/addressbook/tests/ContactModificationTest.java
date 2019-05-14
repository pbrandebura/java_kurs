package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().list().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
  }

  @Test(enabled = true)
  public void testContactModification() throws Exception {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.goTo().homePage();
    app.contact().initContactModification(index);
    ContactData contact =
            new ContactData("ModifiedName", null, "lastname", "nickname", "111111111", "oo@oo.oo", null);
    app.contact().fillForm(contact, false);
    app.contact().submit();
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> getId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(getId);
    after.sort(getId);
    Assert.assertEquals(before, after);
  }
}