package stqa.ptf.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    // tablice
    String[] langs = {"Java", "C#", "PHP", "Python"};

    for (int i = 0; i < langs.length; i++) {
      System.out.println("Print all elements of the collection: " + langs[i]);
    }

    for (String l : langs) {
      System.out.println("Printing elements of the collection: " + l);
    }

    // lista
    List<String> languages = Arrays.asList("Javal", "C#", "PHP", "Python");
//    languages.add("Java");
//    languages.add("PHP");
//    languages.add("C");

    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Elementy z listy: " + languages.get(i));
    }

    for (String k : languages) {
      System.out.println("Print elements of the list: " + k);
    }

    // lista bez podawania typu elementow
    List languages2 = Arrays.asList("Javal", "C#", "PHP", "Python");


    for (Object k : languages2) {
      System.out.println("Print elements of the list (as object): " + k);
    }
  }
}
