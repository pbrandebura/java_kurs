package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().list().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "test1"), true);
    }
  }

  @Test(enabled = true)
  public void testContactDeletion() throws Exception {
    int before = app.contact().count();
    int index = before - 1;
    app.goTo().homePage();
    app.contact().delete(index);
    app.goTo().homePage();
    int after = app.contact().count();
    //Assert.assertEquals(after, before - 1);
  }

  @Test(enabled = true)
  public void testContactDeletionInEdit() throws Exception {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.goTo().homePage();
    app.contact().deleteEditView(index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(after, before);
  }
}