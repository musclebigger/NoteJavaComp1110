package ADT;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class ListTest {

    public abstract <T> List<T> createList();//factory method to test & ArrayListTest

    @Test
    public void testAdd(){
        List<Integer> list = createList();
        assertEquals(0,list.size());
        list.add(42);
        assertEquals(1, list.size());
        list.add(17);
        assertEquals(2,list.size());
        Integer v = Integer.valueOf(111);
        list.add(v);
        Assertions.assertTrue(v== list.get(2));
    }

    @Test
    public void testGet(){
        List<Integer> list = createList();
        list.add(42);
        assertEquals(42,list.get(0));
        list.add(17);
        assertEquals(17,list.get(1));
    }

    @Test
    public void testGetOutOfRange(){
        List<Integer> list = createList();
        assertThrows(IndexOutOfBoundsException.class,()->{
            list.get(0);
        });
    }

    @Test
    public void testRemove(){
        List<Integer> list = createList();
        list.add(42);
        list.add(17);
        assertEquals(2,list.size());
        list.remove(0);
        assertEquals(1,list.size());
        assertEquals(17,list.get(0));
    }

    @Test
    public void testRemoveDuplicate(){
        List<Integer> list = createList();
        list.add(42);
        list.add(17);
        list.add(42);
        assertEquals(3,list.size());
        list.remove(0);
        assertEquals(2,list.size());
        assertEquals(17,list.get(0));
    }

    @Test
    public void testRemoveOutOfRange(){
        List<Integer>list = createList();
        assertThrows(IndexOutOfBoundsException.class,()->{list.remove(0);});
    }

    @Test
    public void testReserve(){//odd and even number reverse
        List<Integer>evenList = createList();
        evenList.add(42);
        evenList.add(17);
        evenList.reverse();
        assertEquals(17,evenList.get(0));
        assertEquals(42,evenList.get(1));

        List<Integer>oddList = createList();
        oddList.add(42);
        oddList.add(21);
        oddList.add(14);
        oddList.add(7);
        oddList.add(1);
        oddList.reverse();
        assertEquals(1,oddList.get(0));
        assertEquals(7,oddList.get(1));
        assertEquals(14,oddList.get(2));
        assertEquals(21,oddList.get(3));
        assertEquals(42,oddList.get(4));

        List<Integer> emptyList = createList();
        assertEquals(0,emptyList.size());
        emptyList.reverse();
        assertEquals(0, emptyList.size() );
    }
}
