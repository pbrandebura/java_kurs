package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("first_name").withMiddlename("middlename").withLastname("lastname")
              .withNickname("nickname").withHome_phonenumber("888888888").withEmail("lll@lll.ll").withGroup("test1"), true);
    }
  }

  @Test(enabled = true)
  public void testContactModification() throws Exception {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact =
            new ContactData().withId(modifiedContact.getId()).withFirstname("ModifiedName").withLastname("lastname").withEmail("oo@oo.oo");
    app.contact().modify(contact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}