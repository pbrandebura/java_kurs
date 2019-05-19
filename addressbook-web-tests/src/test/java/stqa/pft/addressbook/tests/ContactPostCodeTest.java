package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPostCodeTest extends TestBase {
  @Test()
  public void testContactPostCode() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    app.goTo().homePage();
    assertThat(contact.getPostCode(), equalTo(((contactInfoFromEditForm.getPostCode()))));
  }



}
