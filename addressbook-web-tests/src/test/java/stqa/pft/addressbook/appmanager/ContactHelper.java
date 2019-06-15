package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
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
    //attach(By.name("photo"), contactData.getPhoto());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
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
    wd.findElement(By.cssSelector(String.format("a[href$='edit.php?id=%s']", id))).click();
  }

  public void goToDetailsPage(int id) {
    if (isElementPresented((By.name("print")))) {
      return;
    }
    wd.findElement(By.cssSelector(String.format("a[href$='view.php?id=%s']", id))).click();
  }

  public void returnToHomePage() {
    if (wd.getCurrentUrl().equals("http://localhost/addressbook/index.php")) {
      return;
    }
    click(By.linkText("home"));
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
    fillForm(Contact, creation);
    submitNewContact();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
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
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get((4)).getText();
      String postCode = cells.get(3).getText();
      ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones).withAllEmails(allEmails).withPostCode(postCode);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromDetailsPage(ContactData contact) {
    goToDetailsPage(contact.getId());
    List<String> lista = new ArrayList<>();

    String[] details = wd.findElement(By.cssSelector("#content")).getAttribute("innerText").split("\\r?\\n");
    for (String line : details) {
      lista.add(line);


    }
    String[] fullName = lista.get(0).split(" ");
    String nickname = lista.get(1);
    String postCode = lista.get(2);
    String home = lista.get(4).replaceAll("H:", "").replaceAll(" ", "");
    String mobile = lista.get(5).replaceAll("M:", "").replaceAll(" ", "");
    String work = lista.get(6).replaceAll("W:", "").replaceAll(" ", "");
    String email = lista.get(8);
    String postCode2 = lista.get(11);


    return new ContactData().withId(contact.getId()).withFirstname(fullName[0]).withMiddlename(fullName[1])
            .withLastname(fullName[2]).withNickname(nickname).withHomePhone(home).withMobilePhone(mobile)
            .withWorkPhone(work).withEmail(email).withPostCode(postCode).withPostCode2(postCode2);
  }


  public ContactData infoFromEditForm(ContactData contact) {
    returnToHomePage();
    initContactModification(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String postCode = wd.findElement(By.name("address")).getText();
    String postCode2 = wd.findElement(By.name("address2")).getText();
    returnToHomePage();


    return new ContactData().withId(contact.getId()).withFirstname(firstname).withMiddlename(middlename)
            .withLastname(lastname).withNickname(nickname).withHomePhone(home).withMobilePhone(mobile)
            .withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3)
            .withPostCode(postCode).withPostCode2(postCode2);
  }
}
