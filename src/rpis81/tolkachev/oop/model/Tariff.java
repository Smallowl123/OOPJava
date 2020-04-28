package rpis81.tolkachev.oop.model;

public interface Tariff {

    boolean add (Service service);
    boolean add (int index, Service service);
    Service get (int index);
    Service get (String serviceName);
    boolean hasService (String serviceName);
    Service set (int index, Service service);
    Service remove (int index);
    Service remove (String serviceName);
    int size();
    Service[] getServices();
    Service[] sortedServicesByCost ();
    double cost();
    Service[] getServices(ServiceTypes type);
    String toString();
    int hashCode();
    boolean equals(Object obj);
    Object clone() throws CloneNotSupportedException;
    boolean remove (Service service);
    int indexOf (Service service);
    int lastIndexOf (Service service);

}
