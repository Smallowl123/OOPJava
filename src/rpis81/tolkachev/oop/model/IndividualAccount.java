package rpis81.tolkachev.oop.model;

public class IndividualAccount implements Account {
    long number;
    Person person;
    Tariff tariff;
    //Конструкторы
    public IndividualAccount (long number, Person person) {
        this.number = number;
        this.person = person;
        Tariff tariff = new IndividualsTariff();
        tariff.add(new Service());
        this.tariff = tariff;

    }

    public IndividualAccount (long number, Person person, IndividualsTariff tariff) {
        this.number = number;
        this.person = person;
        this.tariff = tariff;
    }
    //Методы
    @Override
    public long getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }

    @Override
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
