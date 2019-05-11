package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewContact() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
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

  public void initContactModification(int index) {
    if (isElementPresented((By.xpath("//*[@title='Edit']")))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
      return;
    }
    wd.findElements(By.xpath("//*[@title='Edit']")).get(index).click();

  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContactFromList(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlertPopup() {
    wd.switchTo().alert().accept();
  }


  public void deleteContactInEditView() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
  }

  public void addNewContact() {
//    if (isElementPresented(By.name("theform"))
//            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
//      return;
//    }
    click(By.linkText("add new"));
  }

  public void createContact(ContactData Contact, boolean creation) {
    addNewContact();
    fillContactForm(new ContactData("first_name", "middlename", "lastname", "nickname", "888888888", "lll@lll.ll", "new2"), true);
    submitNewContact();
  }

  public boolean isThereContact() {
    return isElementPresented(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      String firstname = element.getText();
      String lastname = element.getText();
      String email = element.getText();
      ContactData contact = new ContactData(firstname, null, lastname, null, null, email, null);
      contacts.add(contact);
    }
    return contacts;
  }
}