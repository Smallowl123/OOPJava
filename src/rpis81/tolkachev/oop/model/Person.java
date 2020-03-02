package rpis81.tolkachev.oop.model;

public class Person {
    String fName;
    String sName;
    //Конструкторы
    public Person (String fName, String sName) {
    this.fName = fName;
    this.sName = sName;
    }
    //Методы
    public String getFName() {
        return fName;
    }

    public String getSName() {
        return sName;
    }
}
