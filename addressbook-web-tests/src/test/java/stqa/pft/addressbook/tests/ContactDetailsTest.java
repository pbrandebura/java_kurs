package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTest extends TestBase {

  @Test(enabled = false)
  public void testContactDetails() {
    ContactData contact = app.contact().all().iterator().next();
    app.contact().goToDetailsPage(contact.getId());
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);
    assertThat(contactInfoFromDetailsPage, equalTo((contactInfoFromEditForm)));
  }

}
