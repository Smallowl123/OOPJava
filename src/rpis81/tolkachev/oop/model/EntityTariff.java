package rpis81.tolkachev.oop.model;

public class EntityTariff implements Tariff{
    private Node head;
    private Node tail;
    private int size;

    public EntityTariff(){
        head = new Node(null, tail,null);
        tail = new Node(head, null, null);
        size = 2;
    }

    public EntityTariff(Service[] services){
        head = new Node(null, tail,null);
        tail = new Node(head, null, null);
        size = 2;
        for (int i = 1; i < services.length; i++) {
            addNode(services[i]);
            size++;
        }
    }

    private Node getNode(int index){
        if (index == 0) return head;
        Node node = head;
        for (int i = 0; i < index; i++){
            node = (node.getNext() != null) ? node.getNext() : node;
        }
        return node;
    }

    private boolean addNode (Service service){
        if (head.getValue() == null){
            head.setValue(service);
            return true;
        }
        else
        {
        Node previousNode, node = head;
        while (node.getNext() != tail && node != head) {
            previousNode = node;
            node = node.getNext();
            node.setPrevious(previousNode);
            node.getPrevious().setNext(node);
        }
        node.setNext (new Node(node, tail, service));
        tail.setPrevious(node.getNext());
        size++;
        return true;
        }

    }

    private boolean addNode (int index, Service service){
        if (getNode(index) == head){
            addNode(head.getValue());
            head.setValue(service);
            return true;
        }
        else
        {
        Node node = getNode(index), nextNode = node.getNext(), previousNode = node.getPrevious();
        Node insertedNode = new Node(previousNode, nextNode, service);
        previousNode.setNext(insertedNode);
        node.setPrevious(insertedNode);
        size++;
        return true;
        }
    }

    private Node removeNode (int index){
        Node node = getNode(index), nextNode = node.getNext(), previousNode = node.getPrevious();
        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);
        size--;
        return node;
    }

    private Service setNode (int index, Service service){
        Node node = getNode(index);
        Service replacedService = node.getValue();
        node.setValue(service);
        return replacedService;
    }

    @Override
    public boolean add (Service service){
        return addNode(service);
    }

    @Override
    public boolean add (int index, Service service){
        return addNode(index, service);
    }

    @Override
    public Service get (int index){
        return getNode(index).getValue();
    }

    @Override
    public Service get (String serviceName){
        for (int i = 0; i < size; i++){
            if (getNode(i).getValue().getName().equals(serviceName) && getNode(i).getValue().getName() != null) {
                return getNode(i).getValue();
            }
        }
        return new Service();
    }

    @Override
    public boolean hasService (String serviceName){
        for (int i = 0; i < size; i++){
            if (getNode(i).getValue().getName().equals(serviceName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Service set (int index, Service service){
        return setNode(index, service);
    }

    @Override
    public Service remove (int index){
        return removeNode(index).getValue();
    }

    @Override
    public Service remove (String serviceName){
        for (int i = 0; i < size; i++){
            if (get(i).getName().equals(serviceName)) {
                return removeNode(i).getValue();
            }
        }
        return new Service();
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Service[] getServices(){
        Service[] services = new Service[size - 1];
        for (int i = 0; i < size - 1; i++){
            services[i] = get(i);
        }
        return services;
    }

    @Override
    public Service[] sortedServicesByCost (){
        Service[] sortingServices = getServices();
        for(int i = sortingServices.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( sortingServices[j].getCost() > sortingServices[j+1].getCost() ){
                    Service tmp = sortingServices[j];
                    sortingServices[j] = sortingServices[j+1];
                    sortingServices[j+1] = tmp;
                }
            }
        }
        return (sortingServices);
    }

    @Override
    public double cost(){
        double cost = 50;
        for (Service service : getServices()){
            cost += service.getCost();
        }
        return (cost);
    }
}
