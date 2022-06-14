import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    private int size = 10;

    @Test
    public void testAdd(){
        HashTable hashTable = new HashTable();
        hashTable.add(5,"Vibhu");
        hashTable.add(17,"Mukund");
        hashTable.add(17,"Janardhanan");
        assertEquals("Janardhanan",hashTable.get(17));
        assertTrue(2 == hashTable.getNumItems());
    }

    @Test
    public void testRemove(){
        HashTable hashTable = new HashTable();
        hashTable.add(1,"Vibhu");
        hashTable.add(17,"Mukund");
        assertEquals("Vibhu",hashTable.get(1));
        hashTable.remove(1);
        assertTrue(1 == hashTable.getNumItems());
    }

    @Test
    public void testDouble(){
        HashTable hashTable = new HashTable();
        for(int i = 0; i < 100; i++){
            hashTable.add(i, i + "");
        }
        assertTrue(100 == hashTable.getNumItems());
        assertTrue(256 == hashTable.getBucketSize());
        for(int i = 0; i < 100; i++){
            assertEquals(i+"", hashTable.get(i));
        }
    }


    @Test
    public void testLargeLinkedList(){

        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < size; i++) {
            int value = i;
            linkedList.addToHead(value);
        }

        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            linkedList.get(i);
        }
        for (int i = 0; i < size; i++) {
            linkedList.removeHead();
        }


        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("linked");
        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
    }

    @Test
    public void testLargeArray(){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int value = i;
            arr[i] = i;
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            int j = arr[i];
        }
        for (int i = 0; i < size; i++) {
            removeTheElement(arr,0);
        }


        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("arr");
        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
    }

    @Test
    public void testHashTable(){
        HashTable hashTable = new HashTable();
        for (int i = 0; i < size; i++) {
            int value = i;
            hashTable.add(i,i);
        }

        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            hashTable.get(i);
        }
        for (int i = 0; i < size; i++) {
            hashTable.remove(i);
        }


        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("hash");
        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
        assertTrue(0 == hashTable.getNumItems());

    }

    public int[] removeTheElement(int[] arr, int index) {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

}
