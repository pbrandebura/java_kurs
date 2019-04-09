package stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().addNewContact();
    app.getContactHelper().fillContactForm(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll"));
    app.getContactHelper().submitNewContact();
  }

}