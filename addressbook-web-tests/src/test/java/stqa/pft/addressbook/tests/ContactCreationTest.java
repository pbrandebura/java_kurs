package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("first_name").withMiddlename("middlename").withLastname("lastname")
            .withNickname("nickname").withHome_phonenumber("888888888").withEmail("lll@lll.ll").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}