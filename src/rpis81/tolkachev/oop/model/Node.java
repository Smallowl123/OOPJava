package rpis81.tolkachev.oop.model;

public class Node {
    private Node previous;
    private Node next;
    private Service value;

    public Node (Node previous, Node next, Service value){
        this.previous = previous;
        this.next = next;
        this.value = value;
    }

    public Node (Service value){
        this.previous = this;
        this.next = this;
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Service getValue(){
        return value;
    }

    public void setValue(Service value) {
        this.value = value;
    }
}
