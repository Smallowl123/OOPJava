package rpis81.tolkachev.oop.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;

public interface Tariff extends java.lang.Iterable<Service> {

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
    double cost();
    Service[] getServices(ServiceTypes type);
    String toString();
    int hashCode();
    boolean equals(Object obj);
    Object clone() throws CloneNotSupportedException;
    boolean remove (Service service);
    int indexOf (Service service);
    int lastIndexOf (Service service);

    default public Service[] sortedServicesByCost() {
        Service[] sortingServices = getServices();
        Arrays.sort(sortingServices);
        return (sortingServices);
    }

    default public Iterator<Service> iterator() {
        return new ServiceIterator(getServices());
    }

    public static class ServiceIterator implements java.util.Iterator<Service> {

        private int index;
        private final Service[] services;
        private final int defaultIndex = 0;


        public ServiceIterator (Service[] arrayOfServices) {
            services = arrayOfServices;
            index = defaultIndex;
        }

        public boolean hasNext() {
            return index < services.length;
        }

        @Override
        public Service next() {
            if(hasNext()) {
                return services[index++];
        }
        throw new NoSuchElementException("Элементов больше не осталось");
        }
    }
}
