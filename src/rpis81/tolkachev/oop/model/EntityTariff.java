package rpis81.tolkachev.oop.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Objects;

public class EntityTariff implements Tariff{
    private Node head;
    private Node tail;
    private int size;
    final public int defaultSize = 2;

    public EntityTariff(){
        head = new Node(null, tail,null);
        tail = new Node(head, null, null);
        size = defaultSize;
    }

    public EntityTariff(Service[] services){
        head = new Node(null, tail,null);
        tail = new Node(head, null, null);
        size = defaultSize;
        for (int i = 1; i < services.length; i++) {
            addNode(services[i]);
            size++;
        }
    }

    private Node getNode(int index){
        if (index < 0 && index >= size){
            throw new IndexOutOfBoundsException("Недопустимый индекс элемента");
        }
        else
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
        if (index < 0 && index >= size){
            throw new IndexOutOfBoundsException("Недопустимый индекс элемента");
        }
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
        if (index < 0 && index >= size){
            throw new IndexOutOfBoundsException("Недопустимый индекс элемента");
        }
        Node node = getNode(index), nextNode = node.getNext(), previousNode = node.getPrevious();
        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);
        size--;
        return node;
    }

    private Service setNode (int index, Service service){
        if (index < 0 && index >= size){
            throw new IndexOutOfBoundsException("Недопустимый индекс элемента");
        }
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
        if (index < 0 && index >= size){
            throw new IndexOutOfBoundsException("Недопустимый индекс элемента");
        }
        return addNode(index, service);
    }

    @Override
    public Service get (int index){
        if (index < 0 && index >= size){
            throw new IndexOutOfBoundsException("Недопустимый индекс элемента");
        }
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
        if (index < 0 && index >= size){
            throw new IndexOutOfBoundsException("Недопустимый индекс элемента");
        }
        return setNode(index, service);
    }

    @Override
    public Service remove (int index){
        if (index < 0 && index >= size){
            throw new IndexOutOfBoundsException("Недопустимый индекс элемента");
        }
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
        return size - 1;
    }

    @Override
    public Service[] toArray() {
        Service[] spaces = new Service[size];
        for(int i = 0; i < size; i++) {
            spaces[i] = get(i);
        }
        return Arrays.stream(spaces).filter(Objects::nonNull).toArray(Service[]::new);
    }

    @Override
    public double cost(){
        double cost = 50;
        for (Service service : toArray()) {
            if (isLessThenMonth(service)){
                cost += service.getCost()*Period.between(service.getActivationDate(),LocalDate.now()).getDays()/30;
            }
            else cost += service.getCost();
        }
        return (cost);
    }

    public boolean isLessThenMonth(Service service){
        Period period = Period.between(service.getActivationDate(), LocalDate.now());
        return period.getDays() < 30;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("services:");
        builder.append("\n");
        iterator().forEachRemaining(service ->
        {
            builder.append(service.toString());
            builder.append("\n");
        });
        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hash = 31;
        for (Service service : toArray()){
            hash ^= service.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof EntityTariff)) {
            return false;
        }
        EntityTariff other = (EntityTariff) obj;
        if(!Objects.equals(size, other.size)) {
            return false;
        }
        for (int i = 0; i < size - 1; i++){
            if (!this.toArray()[i].equals(other.toArray()[i])){
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
    public boolean remove (Service service){
        for (int i = 0; i < size - 1; i++){
            if (get(i).equals(service)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf (Service service){
        for (int i = 0; i < size - 1; i++){
            if (get(i).equals(service)) {
                return i;
            }
        }
        return size * 10;
    }

    @Override
    public int lastIndexOf (Service service){
        int last = size * 10;
        for (int i = 0; i < size - 1; i++){
            if (get(i).equals(service)) {
                last = i;
            }
        }
        return last;
    }
}
