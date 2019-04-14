package stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import stqa.pft.addressbook.appmanager.ApplicationManager;
import sun.plugin2.util.BrowserType;

public class TestBase {

  //replace inheritance with delegation
  protected final ApplicationManager app = new ApplicationManager(BrowserType.DEFAULT);

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}