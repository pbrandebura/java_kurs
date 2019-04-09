package stqa.pft.addressbook;

import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    addNewContact();
    fillContactForm(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll"));
    submitNewContact();
  }

}