package rpis81.tolkachev.oop.model;

import java.time.LocalDate;
import java.util.Objects;

public final class Service implements java.lang.Cloneable, java.lang.Comparable<Service> {
    final String name;
    final double cost;
    final ServiceTypes type;
    final LocalDate activationDate;
    final String defaultName = "Интернет 100мб/с";
    final double defaultCost = 300;
    final ServiceTypes defaultType = ServiceTypes.INTERNET;
    final LocalDate actualDate = LocalDate.now();

//Конструкторы
    public Service(String name, double cost, ServiceTypes type, LocalDate activationDate) {
        this.name = Objects.requireNonNull(name,"Значение name не должно быть Null");
        if (cost >= 0) {
            this.cost = cost;
        }
        else throw new IllegalArgumentException("Значение cost не должно быть отрицательным");
        this.type = Objects.requireNonNull(type,"Значение type не должно быть Null");
        this.activationDate = Objects.requireNonNull(activationDate,"Значение activationData не должно быть Null");
    }

    public Service() {
        name = defaultName;
        cost = defaultCost;
        type = defaultType;
        activationDate = actualDate;
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

    public LocalDate getActivationDate() {
        return activationDate;
    }

    @Override
    public String toString() {
        return String.format("%s %f.р %s", name, cost, activationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, type, activationDate);
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
                Objects.equals(type, other.type) &&
                Objects.equals(activationDate, other.activationDate);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Service service) {
        return (int) (cost - service.cost);
    }
}
