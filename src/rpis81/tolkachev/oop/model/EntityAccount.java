package rpis81.tolkachev.oop.model;

public class EntityAccount implements Account {
    String name;
    long number;
    Tariff tariff;

    //Конструкторы
    public EntityAccount (String name, long number){
        this.name = name;
        this.number = number;
        Tariff tariff = new EntityTariff();
        tariff.add(new Service());
        this.tariff = tariff;
    }

    public EntityAccount (String name, long number, Tariff tariff){
        this.name = name;
        this.number = number;
        this.tariff = tariff;
    }

    @Override
    public long getNumber() {
        return number;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }

    @Override
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
