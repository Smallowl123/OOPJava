package rpis81.tolkachev.oop.model;

public class IndividualAccount extends AbstractAccount {
    long number;
    Person person;
    Tariff tariff;
    //Конструкторы
    public IndividualAccount (long number, Person person) {
        super(number, new IndividualsTariff());
        this.person = person;
        Tariff tariff = new IndividualsTariff();
        tariff.add(new Service());
        setTariff(tariff);

    }

    public IndividualAccount (long number, Person person, Tariff tariff) {
        super(number, tariff);
        this.person = person;
    }
    //Методы
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
