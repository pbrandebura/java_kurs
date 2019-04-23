package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    if (isElementPresented(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresented(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void goToHomepage() {
    if (wd.getCurrentUrl().equals("http://localhost/addressbook/index.php")) {
      return;
    }
    click(By.linkText("home"));
  }

}