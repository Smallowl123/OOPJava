package rpis81.tolkachev.oop.model;

public class Account {
    long number;
    Person person;
    IndividualsTariff tariff;
    //Конструкторы
    public Account (long number, Person person) {
        this.number = number;
        this.person = person;
        tariff.add(new Service());
    }

    public Account (long number, Person person, IndividualsTariff tariff) {
        this.number = number;
        this.person = person;
        this.tariff = tariff;
    }
    //Методы
    public long getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public IndividualsTariff getTariff() {
        return tariff;
    }

    public void setTariff(IndividualsTariff tariff) {
        this.tariff = tariff;
    }
}
