package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() throws Exception {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("ModifiedName", "middlename", "lastname", "nickname", "111111111", "oo@oo.oo"));
    app.getContactHelper().submitContactModification();
  }
}