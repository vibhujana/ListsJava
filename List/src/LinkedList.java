import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private Node _head;
    private int _size;

    private static class Node {
        private Object _value;
        private Node _next;

        private Node(Object v){
            _value = v;
            _next = null;
        }
    }

    public LinkedList(){
        _head = null;
        _size = 0;
    }

    public void addToHead(Object newData){
        Node newNode = new Node(newData);
        newNode._next = _head;
        _head = newNode;
        _size++;
    }

    // O(n)
    public void addToTail(Object newData){
        Node current = _head;
        if(_size == 0){
            addToHead(newData);
            return;
        }
        for(int i = 0; i < _size - 1; i++){
            current = current._next;
        }
        Node newNode = new Node(newData);
        current._next = newNode;
        _size++;
    }

    // O(n)
    public void insert(int loc, Object newData){
        if(!isValid(loc)) {
            throw new IndexOutOfBoundsException(loc +" not in range for size " + _size);
        }
        if(loc == 0){
            addToHead(newData);
        }
        else if(loc == _size){
            addToTail(newData);
        }
        else{
            Node current = _head;
            for(int i = 0; i < loc - 1; i++){
                current = current._next;
            }
            Node temp = current._next; //created temp Node which stores the node after loc
            Node newNode = new Node(newData);
            current._next = newNode;
            newNode._next = temp; //after new node is set after current, set next to temp
            _size++;
        }
    }

    // O(1)
    void removeHead(){
        Node temp = _head;
        _head = _head._next;
        temp._next = null;
    }

    // O(n)
    public void remove(int loc){
        if(!isValid(loc)) {
            throw new IndexOutOfBoundsException(loc +" not in range for size " + _size);
        }
        if(loc == 0){
            removeHead();
        }
        else {
            Node previousNode = _head;
            for (int i = 0; i < loc - 1; i++) {
                previousNode = previousNode._next;
            }
            Node removeNode = previousNode._next;
            previousNode._next = removeNode != null ? removeNode._next : null;
            removeNode._next = null;
        }
        _size--;
    }

    // O(n)
    public Object get(int loc){
        if(!isValid(loc)) {
            throw new IndexOutOfBoundsException(loc +" not in range for size " + _size);
        }
        Node current = _head;
        for (int i = 0; i < loc; i++) {
            current = current._next;
        }
        return current != null ? current._value : null;
    }

    public List<Object> getAll(){
        List<Object> list = new ArrayList<Object>();
        Node current = _head;
        while(current != null){
            list.add(current._value);
            current = current._next;
        }
        return list;
    }

    //// O(n)?
    public boolean contains(Object val){
        Node t = _head;
        for(int i = 0; i < _size; i++){
            if(t._value == val){
                return true;
            }
            t = t._next;
        }
        return false;
    }

    // O(1)
    public int getSize(){
        return _size;
    }

    // O(1)
    private boolean isValid(int loc){
        return (loc >= 0 && loc <= _size) ? true : false;
    }

}
