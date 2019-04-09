package stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.addNewContact();
    app.fillContactForm(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll"));
    app.submitNewContact();
  }

}