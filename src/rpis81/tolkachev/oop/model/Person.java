package rpis81.tolkachev.oop.model;

import java.util.Objects;

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

    @Override
    public String toString() {
        return String.format("%s %s", fName, sName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fName) * Objects.hashCode(sName);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person)obj;
        return Objects.equals(fName, other.fName) &&
                Objects.equals(sName, other.sName);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
