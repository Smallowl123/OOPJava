package rpis81.tolkachev.oop.model;

public class IndividualsTariff {
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
    public void increase () {               //Увеличить массив
        if (count == services.length) {
            Service [] increasedServices = new Service[services.length * 2];
            System.arraycopy(services, 0, increasedServices, 0, services.length);
            services = increasedServices;
        }
    }

    public boolean add (Service service) {
        increase();
        for (int i = 0; i < services.length; i++) {
            if (services[i] == null) {
                services[i] = service;
                count++;
                break;
            }
        }
        return(true);
    }

    public boolean add (int index, Service service) {
        increase();
        if (services[index] == null) {
            services[index] = service;
            count++;
        }
        return(true);
    }

    public Service get (int index) {
        return (services[index]);
    }

    public Service get (String serviceName) {
        for (Service service : services) {
            if (service.name.equals(serviceName)) {
                return service;
            }
        }
        return (new Service());
    }

    public boolean hasService (String serviceName) {    //Какой-то косяк
        for (Service service : services) {
            if (service != null){
                if (service.name.equals(serviceName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Service set (int index, Service service) {
        Service replacedService = services[index];
        services[index] = service;
        return (replacedService);
    }

    public void makeArrayContinuityAgain () {               //Дефрагментатор
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

    public Service remove (int index) {
    Service removedService = services[index];
    services[index] = null;
    makeArrayContinuityAgain();
    count--;
    return (removedService);
    }

    public Service remove (String serviceName) {
        for (int i=0; i < services.length; i++) {
            if (services[i].name.equals(serviceName)) {
                Service removedService = services[i];
                services[i] = null;
                count--;
                return (removedService);
            }
        }
        return (new Service());
    }

    public int size() {
        return (count);
    }

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

    public Service[] sortedServicesByCost () {
        Service[] sortingServices = getServices();
        for(int i = sortingServices.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            if( sortingServices[j].cost > sortingServices[j+1].cost ){
                Service tmp = sortingServices[j];
                sortingServices[j] = sortingServices[j+1];
                sortingServices[j+1] = tmp;
            }
        }
    }
        return (sortingServices);
    }

    public double cost(){
        double cost = 50;
        for (Service service : getServices()){
            cost += service.cost;
        }
        return (cost);
    }


}
