package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().createContact
            (new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
  }

}