package rpis81.tolkachev.oop.model;

import java.util.Objects;

public final class Service implements java.lang.Cloneable {
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

    @Override
    public String toString() {
        return String.format("%s %f.р", name, cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, type);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Service)) {
            return false;
        }
        Service other = (Service)obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(cost, other.cost) &&
                Objects.equals(type, other.type);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
