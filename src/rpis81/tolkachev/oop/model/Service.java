package rpis81.tolkachev.oop.model;

public final class Service {
    final String name;
    final double cost;
    final ServiceTypes type;
//Конструкторы
    public Service(String name, double cost, ServiceTypes type) {
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public Service() {
        name = "Интернет 100мб/с";
        cost = 300;
        type = ServiceTypes.INTERNET;
    }
//Методы
    public String getName () {
        return(name);
    }

    public double getCost() {
        return cost;
    }

    public ServiceTypes getType(){
        return type;
    }
}
