package rpis81.tolkachev.oop.model;

public class EntityAccount extends AbstractAccount {
    String name;

    //Конструкторы
    public EntityAccount (long number, String name){
        super(number, new EntityTariff());
        this.name = name;
        Tariff tariff = new EntityTariff();
        tariff.add(new Service());
        setTariff(tariff);

    }

    public EntityAccount (long number, String name, Tariff tariff){
        super(number, tariff);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
