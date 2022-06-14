import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void testAdd(){
        LinkedList list = new LinkedList();
        list.addToHead("5");
        list.addToTail(20);
        list.addToHead(true);
        list.addToTail(5.8);

        assertEquals(true, list.get(0));
        assertEquals("5", list.get(1));
        assertEquals(20, list.get(2));
        assertEquals(5.8, list.get(3));
        assertEquals(4, list.getSize());
    }

    @Test
    public void testContains(){
        LinkedList list = new LinkedList();
        list.addToHead(10);
        list.addToTail(20);
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertFalse(list.contains(30));
    }

    @Test
    public void testInsert(){
        LinkedList list = new LinkedList();
        list.addToHead(10);
        list.addToTail(30);
        list.insert(0,20);
        list.insert(3,100);
        assertEquals(10, list.get(1));
        assertEquals(20, list.get(0));
        assertEquals(30, list.get(2));
        assertEquals(100,list.get(3));

    }

    @Test
    public void testRemove(){
        LinkedList list = new LinkedList();
        list.addToTail(10);
        list.addToTail(20);
        list.addToTail(30);
        try{
            list.remove(30);
            assertTrue(false);
        }
        catch(IndexOutOfBoundsException e){
            //expected
        }
        list.removeHead();
        assertEquals(20, list.get(0));
    }

    @Test
    public void testAll(){
        LinkedList list = new LinkedList();
        for (int i = 0; i <=  7; i++) {
            list.addToTail(i+1);
        }
        list.insert(3,9);
        list.removeHead();
        list.remove(5);

        //2,3,9,4,5,7
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(9, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(7, list.get(5));
        assertEquals(8, list.get(6));

    }



}