package rpis81.tolkachev.oop.model;

import java.time.LocalDate;
import java.util.Objects;

public class EntityAccount extends AbstractAccount {
    String name;

    //Конструкторы
    public EntityAccount (long number, String name){
        super(number, new EntityTariff(), LocalDate.now());
        this.name = Objects.requireNonNull(name,"Значение name не должно быть Null");
        Tariff tariff = new EntityTariff();
        tariff.add(new Service());
        setTariff(tariff);


    }

    public EntityAccount (long number, String name, Tariff tariff, LocalDate registrationDate){
        super(number, tariff, registrationDate);
        this.name = Objects.requireNonNull(name,"Значение name не должно быть Null");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = Objects.requireNonNull(name,"Значение name не должно быть Null");;
    }
}
