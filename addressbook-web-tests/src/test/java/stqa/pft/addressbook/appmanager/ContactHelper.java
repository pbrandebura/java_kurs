package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewContact() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("home"), contactData.getHome_phonenumber());
    type(By.name("email"), contactData.getEmail());
  }

  public void initContactModification() {
    click(By.xpath("//*[@title='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContactFromList() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlertPopup() {
    if (isAlertPresent()) {
      wd.switchTo().alert();
      wd.switchTo().alert().accept();
    }
  }

  public void deleteContactInEditView() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
  }

}