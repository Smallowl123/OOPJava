package rpis81.tolkachev.oop.model;

public class IndividualsTariff implements Tariff {
    private int count = 0;
    Service[] services;

    //Конструкторы
    public IndividualsTariff() {
        services = new Service[8];
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
        increase();
        if (services[index] == null) {
            services[index] = service;
            count++;
        }
        return (true);
    }

    @Override
    public Service get(int index) {
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
            cost += service.getCost();
        }
        return (cost);
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
}
