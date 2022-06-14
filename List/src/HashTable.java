import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private LinkedList[] _hashTable;
    private int _numItems;

    private static class Pair {
        private int _key;
        private Object _value;

        public Pair(int key, Object value){
            _key = key;
            _value = value;
        }

        public int getKey() {
            return _key;
        }

        public Object getValue() {
            return _value;
        }

        public void setValue(Object _value) {
            this._value = _value;
        }
    }

    public HashTable(){
        _hashTable = new LinkedList[16];
        for(int i = 0; i < _hashTable.length; i++){
            _hashTable[i] = new LinkedList();
        }
        _numItems = 0;
    }

    public void add(int key, Object value){
        doubleSizeIfNeeded();
        int bucket = getBucket(key);
        Pair pair = new Pair(key,value);
        if(!overwriteIfKeyPresent(pair, bucket)) {
            _hashTable[bucket].addToHead(pair);
            _numItems++;

        }
    }

    private boolean overwriteIfKeyPresent(Pair pair, int bucket){
        LinkedList l = _hashTable[bucket];
        for(Object o : l.getAll()){
            Pair h = (Pair)o;
            if(h.getKey() == pair.getKey()){
                h.setValue(pair.getValue());
                return true;
            }
        }
        return false;
    }

    public Object get(int key){
        int bucket = getBucket(key);
        LinkedList l = _hashTable[bucket];
        for(Object o : l.getAll()){
            Pair h = (Pair)o;
            if(h.getKey() == key){
                return h.getValue();
            }
        }
        return null;
    }

    public void remove(int key){
        int bucket = getBucket(key);
        LinkedList list = _hashTable[bucket];
        for (int i = 0; i < list.getSize(); i++) {
            Pair pair = (Pair)list.get(i);
            if(pair.getKey() == key) {
                list.remove(i);
                _numItems--;
                return;
            }
        }
    }

    private int getBucket(int key){
        return key % _hashTable.length;
    }

    private void doubleSizeIfNeeded() {
        if(_numItems >= 0.75 * _hashTable.length) {
            LinkedList[] largerHashTable = new LinkedList[_hashTable.length * 2];
            for(int i = 0; i < largerHashTable.length; i++){
                largerHashTable[i] = new LinkedList();
            }

            for (int i = 0; i < _hashTable.length; i++) {
                LinkedList list = _hashTable[i];
                List<Object> l = list.getAll();
                for(Object o : l){
                    Pair h = (Pair)o;
                    int bucket = getBucket(h.getKey());
                    largerHashTable[bucket].addToHead(o);
                }
            }
            _hashTable = largerHashTable;
        }
    }

    public int getNumItems(){
        return _numItems;
    }

    public int getBucketSize(){
        return _hashTable.length;
    }

}
