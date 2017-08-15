import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Before;
import org.junit.Test;

public class AssertTests {
    ArrayList list;

    @Before
    public void init(){
        list = new ArrayList<String>(1000);
    }

    public void intialize(){
            list = new ArrayList<String>(1000);
            for (int i = 0; i < 1000; i++){
                list.add("element"+i);
            }
    }

    @Test
    //public boolean add(E e)
    //Appends the specified element to the end of this list.
        public void testAdd(){
            assertTrue(list.add("element0"));
            assertTrue(list.add("element1"));

            intialize();

            assertEquals(list.get(999), "element999");
            assertEquals(list.get(0), "element0");

        }

    @Test
    //public void add(int index, E element)
    //Inserts the specified element at the specified position in this list. Shifts the element currently at that position
    // (if any) and any subsequent elements to the right (adds one to their indices).
        public void testAddIndex(){
            list.add(0,"element0");
            list.add(1,"element1");
            list.add(2,"element2");
            list.add(1,"element4");

            assertEquals(list.get(0), "element0");
            assertEquals(list.get(1), "element4");
            assertEquals(list.get(2), "element1");
            assertEquals(list.get(3), "element2");

            intialize();

            assertEquals(list.get(999), "element999");
            assertEquals(list.get(0), "element0");
    }

        @Test(expected = IndexOutOfBoundsException.class)
        public void testAddIndexException() {
            list.add(1000,"element");
        }

    //public E remove(int index)
    //Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
        @Test
        public void testRemoveIndex(){
            intialize();

            assertEquals("element2", list.remove(2));
            assertEquals("element3", list.get(2));
        }

        @Test(expected = IndexOutOfBoundsException.class)
        public void testRemoveException() {
            list.remove(1000);
        }

    //public boolean remove(Object o)
    //Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element,
    //it is unchanged. More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i)))
    //(if such an element exists). Returns true if this list contained the specified element (or equivalently, if this list changed as a
    // result of the call).
        @Test
        public void testRemove(){
            intialize();

            assertTrue(list.remove("element0"));
            assertEquals(list.get(0), "element1");

            assertFalse(list.remove("element1000"));
        }
    //public void clear()
    //Removes all of the elements from this list. The list will be empty after this call returns.
        @Test
        public void testClear(){
            intialize();
            assertEquals(list.size(), 1000);

            list.clear();
            assertEquals(list.size(), 0);
        }
    //public E get(int index)
    //Returns the element at the specified position in this list.
        @Test
        public void testGet(){
            intialize();

            assertEquals(list.get(0), "element0");
            assertEquals(list.get(500), "element500");
            assertEquals(list.get(999), "element999");
        }

          @Test(expected = IndexOutOfBoundsException.class)
          public void testGetException() {
            intialize();
            list.get(1000);
          }
    //public boolean isEmpty()
    //Returns true if this list contains no elements.
        @Test
        public void testIsEmpty(){
            assertTrue(list.isEmpty());
            intialize();
            assertFalse(list.isEmpty());
        }
}