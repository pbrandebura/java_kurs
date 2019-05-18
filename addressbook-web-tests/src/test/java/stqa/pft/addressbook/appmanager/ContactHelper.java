package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewContact() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("home"), contactData.getHome_phonenumber());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresented(By.name("new_group")));
    }
  }

  public void initContactModification(int id) {
    if (isElementPresented((By.xpath("//*[@title='Edit']")))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
      return;
    }
    wd.findElement(By.cssSelector("a[href$='view.php?id=" + id + "']")).click();
  }

  public void submit() {
    click(By.name("update"));
  }

  public void selectContactFromList(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactFromListById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlertPopup() {
    wd.switchTo().alert().accept();
  }


  public void deleteContactInEditView() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void addNewContact() {
//    if (isElementPresented(By.name("theform"))
//            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
//      return;
//    }
    click(By.linkText("add new"));
  }

  public void goToModify() {
    click(By.name("modifiy"));
  }

  public void create(ContactData Contact, boolean creation) {
    addNewContact();
    fillForm(new ContactData().withFirstname("first_name").withMiddlename("middlename").withLastname("lastname")
            .withNickname("nickname").withHome_phonenumber("888888888").withEmail("lll@lll.ll").withGroup("new2"), true);
    submitNewContact();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    goToModify();
    fillForm(contact, false);
    submit();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    initContactModification(contact.getId());
    deleteSelectedContact();
    closeAlertPopup();
    contactCache = null;
  }

  public void deleteEditViewById(ContactData contact) {
    initContactModification(contact.getId());
    goToModify();
    deleteContactInEditView();
    contactCache = null;
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstname = element.findElement(By.xpath("td[3]")).getText();
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

}