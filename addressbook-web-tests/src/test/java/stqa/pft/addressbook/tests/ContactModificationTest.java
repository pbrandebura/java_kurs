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
      app.contact().create(new ContactData().withFirstname("first_name").withMiddlename("middlename").withLastname("lastname")
              .withNickname("nickname").withHome_phonenumber("888888888").withEmail("lll@lll.ll").withGroup("test1"), true);
    }
  }

  @Test(enabled = true)
  public void testContactModification() throws Exception {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().initContactModification(index);
    ContactData contact =
            new ContactData().withFirstname("ModifiedName").withLastname("lastname").withEmail("oo@oo.oo");
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