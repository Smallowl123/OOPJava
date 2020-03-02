package rpis81.tolkachev.oop.model;

public class Service {
    String name;
    double cost;
//Конструкторы
    public Service(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public Service() {
        name = "Интернет 100мб/с";
        cost = 300;
    }
//Методы
    public String getName () {
        return(name);
    }

    public void setName (String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
