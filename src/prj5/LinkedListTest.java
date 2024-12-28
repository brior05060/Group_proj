// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Baz Atiyeh (90632952)

package prj5;

import student.TestCase;
import java.util.Comparator;

/**
 * Test class for LinkedList.
 * 
 * @author baz atiyeh
 * @version Nov 18, 2024
 */
public class LinkedListTest
    extends TestCase
{
    private LinkedList<String> list;

    /**
     * Sets up the test cases.
     */
    public void setUp()
    {
        list = new LinkedList<>();
    }


    /**
     * Tests that adding elements works as expected.
     */
    public void testAdd()
    {
        list.add("First");
        assertEquals(1, list.size());
        assertEquals("First", list.get(0));

        list.add("Second");
        assertEquals(2, list.size());
        assertEquals("Second", list.get(1));
    }


    /**
     * Tests that adding null data throws an exception.
     */
    public void testAddNull()
    {
        try
        {
            list.add(null);
            fail("Expected IllegalArgumentException for null data.");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Data cannot be null.", e.getMessage());
        }
    }


    /**
     * Tests removing the head node.
     */
    public void testRemoveHead()
    {
        list.add("First");
        list.add("Second");
        list.add("Third");

        // Remove head
        assertTrue(list.remove("First"));
        assertEquals(2, list.size());
        assertEquals("Second", list.get(0));
    }


    /**
     * Tests removing a middle node.
     */
    public void testRemoveMiddle()
    {
        list.add("First");
        list.add("Second");
        list.add("Third");

        // Remove middle
        assertTrue(list.remove("Second"));
        assertEquals(2, list.size());
        assertEquals("First", list.get(0));
        assertEquals("Third", list.get(1));
    }


    /**
     * Tests removing a non-existent element.
     */
    public void testRemoveNonExistent()
    {
        list.add("First");
        list.add("Second");

        assertFalse(list.remove("NonExistent"));
        assertEquals(2, list.size());
    }


    /**
     * Tests removing an element from an empty list.
     */
    public void testRemoveFromEmptyList()
    {
        assertFalse(list.remove("NonExistent"));
        assertTrue(list.isEmpty());
        assertFalse(list.remove(null));
    }


    /**
     * Tests sorting an empty list.
     */
    public void testSortEmptyList()
    {
        list.insertionSort((a, b) -> a.compareTo(b));
        assertTrue(list.isEmpty());
    }


    /**
     * Tests sorting a list with one element.
     */
    public void testSortSingleElement()
    {
        list.add("Only");
        list.insertionSort((a, b) -> a.compareTo(b));
        assertEquals("Only", list.get(0));
    }


    /**
     * Tests sorting a list with multiple elements.
     */
    public void testSortMultipleElements()
    {
        list.add("Charlie");
        list.add("Alice");
        list.add("Bob");
        list.add("Zach");

        list.insertionSort((a, b) -> a.compareTo(b));

        assertEquals("Alice", list.get(0));
        assertEquals("Bob", list.get(1));
        assertEquals("Charlie", list.get(2));
        assertEquals("Zach", list.get(3));
    }


    /**
     * Tests getting elements at specific indices.
     */
    public void testGet()
    {
        list.add("First");
        list.add("Second");
        list.add("Third");

        assertEquals("First", list.get(0));
        assertEquals("Second", list.get(1));
        assertEquals("Third", list.get(2));

        // Test invalid index
        Exception exception = null;
        try
        {
            list.get(3);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);
        
        try
        {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests clearing the list.
     */
    public void testClear()
    {
        list.add("First");
        list.add("Second");
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }


    /**
     * Tests checking if the list contains specific elements.
     */
    public void testContains()
    {
        list.add("First");
        list.add("Second");
        assertTrue(list.contains("First"));
        assertFalse(list.contains("NonExistent"));
    }


    /**
     * Tests the last index of an element in the list.
     */
    public void testLastIndexOf()
    {
        list.add("First");
        list.add("Second");
        list.add("First");

        assertEquals(2, list.lastIndexOf("First"));
        assertEquals(1, list.lastIndexOf("Second"));
        assertEquals(-1, list.lastIndexOf("NonExistent"));
    }


    /**
     * Tests the isEmpty method.
     */
    public void testIsEmpty()
    {
        assertTrue(list.isEmpty());
        list.add("First");
        assertFalse(list.isEmpty());
    }


    /**
     * Tests the toString method.
     */
    public void testToString()
    {
        list.add("First");
        list.add("Second");
        list.add("Third");
        assertEquals("{First, Second, Third}", list.toString());
    }
    
}
