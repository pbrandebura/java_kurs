package stqa.pft.addressbook.tests;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String home_phonenumber;
  private final String email;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String home_phonenumber, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.home_phonenumber = home_phonenumber;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getHome_phonenumber() {
    return home_phonenumber;
  }

  public String getEmail() {
    return email;
  }
}
