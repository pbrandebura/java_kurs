package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void returnToGroupPage() {
    if (wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && wd.findElement(By.name("new")).getAttribute("value").equals("New group")) {
      return;
    }

    click(By.linkText("groups"));
  }

  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    if ((wd.findElements(By.name("selected[]")).get(index)).isSelected()) {
      return;
    }
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }


  public void createGroup(GroupData Group) {
    initGroupCreation();
    fillGroupForm(Group);
    submitGroupCreation();
    returnToGroupPage();

  }

  public boolean isThereGroup() {
    return isElementPresented(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}