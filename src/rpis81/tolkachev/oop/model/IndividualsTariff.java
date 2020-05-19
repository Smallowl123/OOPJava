package rpis81.tolkachev.oop.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class IndividualsTariff implements Tariff {
    private int count = 0;
    Service[] services;

    //Конструкторы
    public IndividualsTariff() {
        int defaultSize = 8;
        services = new Service[defaultSize];
    }

    public IndividualsTariff(int size) {
        services = new Service[size];
    }

    public IndividualsTariff(Service[] array) {
        services = array;
        for (Service service : services) {
            if (service != null) {
                count++;
            }
        }

    }

    //Методы
    public void increase() {               //Увеличить массив
        if (count == services.length) {
            Service[] increasedServices = new Service[services.length * 2];
            System.arraycopy(services, 0, increasedServices, 0, services.length);
            services = increasedServices;
        }
    }

    @Override
    public boolean add(Service service) {
        increase();
        for (int i = 0; i < services.length; i++) {
            if (services[i] == null) {
                services[i] = service;
                count++;
                break;
            }
        }
        return (true);
    }

    @Override
    public boolean add(int index, Service service) {
        if (index < 0 && index >= services.length){
            throw new IllegalAccountNumberException("Недопустимый индекс элемента");
        }
        increase();
        if (services[index] == null) {
            services[index] = service;
            count++;
        }
        return (true);
    }

    @Override
    public Service get(int index) {
        if (index < 0 && index >= services.length){
            throw new IllegalAccountNumberException("Недопустимый индекс элемента");
        }
        return (services[index]);
    }

    @Override
    public Service get(String serviceName) {
        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                return service;
            }
        }
        return (new Service());
    }

    @Override
    public boolean hasService(String serviceName) {
        for (Service service : services) {
            if (service != null) {
                if (service.getName().equals(serviceName)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Service set(int index, Service service) {
        if (index < 0 && index >= services.length){
            throw new IllegalAccountNumberException("Недопустимый индекс элемента");
        }
        Service replacedService = services[index];
        services[index] = service;
        return (replacedService);
    }

    public void makeArrayContinuityAgain() {               //Дефрагментатор
        Service[] newArray = new Service[services.length];
        int index = 0;
        for (Service service : services) {
            if (service != null) {
                newArray[index] = service;
                index++;
            }
        }
        services = newArray;
    }

    @Override
    public Service remove(int index) {
        if (index < 0 && index >= services.length){
            throw new IllegalAccountNumberException("Недопустимый индекс элемента");
        }
        Service removedService = services[index];
        services[index] = null;
        makeArrayContinuityAgain();
        count--;
        return (removedService);
    }

    @Override
    public Service remove(String serviceName) {
        for (int i = 0; i < services.length; i++) {
            if (services[i].getName().equals(serviceName)) {
                Service removedService = services[i];
                services[i] = null;
                count--;
                makeArrayContinuityAgain();
                return (removedService);
            }
        }
        return (new Service());
    }

    @Override
    public int size() {
        return (count);
    }

    @Override
    public Service[] getServices() {
        Service[] getServicesArray = new Service[count];
        int index = 0;
        for (Service service : services) {
            if (service != null) {
                getServicesArray[index] = service;
                index++;
            }
        }
        return (getServicesArray);
    }

    @Override
    public Service[] sortedServicesByCost() {
        Service[] sortingServices = getServices();
        for (int i = sortingServices.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortingServices[j].getCost() > sortingServices[j + 1].getCost()) {
                    Service tmp = sortingServices[j];
                    sortingServices[j] = sortingServices[j + 1];
                    sortingServices[j + 1] = tmp;
                }
            }
        }
        return (sortingServices);
    }

    @Override
    public double cost() {
        double cost = 50;
        for (Service service : getServices()) {
            if (isLessThenMonth(service)){
                cost += service.getCost()*Period.between(service.getActivationDate(),LocalDate.now()).getDays()/30;
            }
            else cost += service.getCost();
        }
        return (cost);
    }

    public boolean isLessThenMonth(Service service){
        Period period = Period.between(service.getActivationDate(),LocalDate.now());
        return period.getDays() < 30;
    }

    @Override
    public Service[] getServices(ServiceTypes type) {
        Service[] services = new Service[getServices().length];
        int index = 0;
        for (Service service : getServices()) {
            if (service.getType() == type) {
                services[index] = service;
                index++;
            }
        }
        Service[] getServicesArray = new Service[index];
        System.arraycopy(services, 0, getServicesArray, 0, services.length);
        return getServicesArray;
    }

    @Override
    public String toString() {
        Service[] services = getServices();
        StringBuilder builder = new StringBuilder();
        builder.append("services:");
        builder.append("\n");
        for (Service service : services){
            builder.append(service.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hash = 31;
        for (Service service : getServices()){
            hash ^= service.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof IndividualsTariff)) {
            return false;
        }
        IndividualsTariff other = (IndividualsTariff) obj;
        if(!Objects.equals(count, other.count)) {
            return false;
        }
        for (int i = 0; i < count; i++){
            if (!this.getServices()[i].equals(other.getServices()[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean remove(Service service) {
        for (int i = 0; i < services.length; i++) {
            if (services[i].equals(service)) {
                services[i] = null;
                count--;
                makeArrayContinuityAgain();
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf (Service service) {
        for (int i = 0; i < services.length; i++) {
            if (services[i] != null){
                if (services[i].equals(service)) {
                    return i;
                }
            }
        }
        return services.length * 10;
    }

    @Override
    public int lastIndexOf (Service service) {
        int last = services.length * 10;
        for (int i = 0; i < services.length; i++) {
            if (services[i] != null){
                if (services[i].equals(service)) {
                    last = i;
                }
            }
        }
        return last;
    }
}
