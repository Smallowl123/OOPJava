package rpis81.tolkachev.oop.model;

import java.time.LocalDate;
import java.util.Objects;

public class IndividualAccount extends AbstractAccount {
    long number;
    Person person;
    Tariff tariff;
    //Конструкторы
    public IndividualAccount (long number, Person person) {
        super(number, new IndividualsTariff(), LocalDate.now());
        this.person = Objects.requireNonNull(person,"Значение person не должно быть Null");
        Tariff tariff = new IndividualsTariff();
        tariff.add(new Service());
        setTariff(tariff);

    }

    public IndividualAccount (long number, Person person, Tariff tariff, LocalDate registrationDate) {
        super(number, tariff, registrationDate);
        this.person = Objects.requireNonNull(person,"Значение person не должно быть Null");
    }
    //Методы
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = Objects.requireNonNull(person,"Значение person не должно быть Null");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Individual account: ");
        builder.append("\n");
        builder.append("holder: ");
        builder.append("\n");
        builder.append(person.toString());
        builder.append("\n");
        builder.append(super.toString());
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return 97 * super.hashCode() * person.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof IndividualAccount)) {
            return false;
        }
        IndividualAccount other = (IndividualAccount) obj;
        if(!Objects.equals(person, other.person)) {
            return super.equals(obj);
        }
        return false;
    }
}
