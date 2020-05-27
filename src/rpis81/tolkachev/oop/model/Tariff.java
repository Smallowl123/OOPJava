package rpis81.tolkachev.oop.model;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public interface Tariff extends java.lang.Iterable<Service> , java.util.Collection<Service> {

    boolean add (Service service);
    boolean add (int index, Service service);
    Service get (int index);
    Service get (String serviceName);
    boolean hasService (String serviceName);
    Service set (int index, Service service);
    Service remove (int index);
    Service remove (String serviceName);
    int size();
    double cost();
    String toString();
    int hashCode();
    boolean equals(Object obj);
    Object clone() throws CloneNotSupportedException;
    boolean remove (Service service);
    int indexOf (Service service);
    int lastIndexOf (Service service);

    default List<Service> getServicesSortedByCost() {
        return Arrays.stream(toArray())
                .filter(Objects::nonNull)
                .sorted(Service::compareTo)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    default Collection<Service> getServices(ServiceTypes type){
        return Arrays.stream(toArray())
                .filter(Objects::nonNull)
                .filter(service -> service.getType() == type)
                .collect(Collectors.toCollection(LinkedList::new));
    }



    default public Iterator<Service> iterator() {
        return new ServiceIterator(toArray());
    }

    @Override
    default public boolean contains(Object o) {
        Service service = (Service) o;
        return hasService(service.getName());
    }

    @Override
    default public boolean isEmpty() {
        return toArray().length == 0;
    }

    @Override
    default public void clear() {
        iterator().forEachRemaining(this::remove);
    }

    @Override
    default boolean removeAll(Collection<?> collection) {
        int initialSize = size();
        iterator().forEachRemaining(service -> {
            if(collection.contains(service)) { remove(service); }
        });
        return initialSize > size();
    }

    @Override
    default public boolean addAll(Collection<? extends Service> c) {
        c.forEach(this::add);
        return size() >= c.size();
    }
    @Override
    default public boolean containsAll(Collection<?> c) {
        return c.stream().allMatch(this::contains);
    }

    @Override
    default public boolean retainAll(Collection<?> c) {
        int initialSize = size();
        iterator().forEachRemaining(service -> {
            if(!c.contains(service)) { remove(service); }
        });
        return initialSize > size();
    }

    @Override
    default public boolean remove(Object o) {
        int initialSize = size();
        remove(((Service) o));
        return initialSize > size();
    }

    @Override
    default public <T> T[] toArray(T[] a) {
        Service[] services = (Service[]) a;
        Arrays.sort(services);
        return (T[]) services;
    }

    public Service[] toArray();


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
