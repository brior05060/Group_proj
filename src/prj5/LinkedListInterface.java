// Virginia Tech Honor Code Pledge:
// Project 5 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Baz Atiyeh (90632952)

package prj5;

import java.util.Comparator;

/**
 * Provides the methods necessary for implementing a LinkedList.
 *
 * @param <T>
 *            The type of elements stored in the LinkedList.
 * @author baz atiyeh
 * @version Nov 18, 2024
 */
public interface LinkedListInterface<T>
{

    /**
     * Adds an element to the end of the list.
     *
     * @param data
     *            the data to add
     * @throws IllegalArgumentException
     *             if the data is null
     */
    public abstract void add(T data);


    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param data
     *            the element to remove
     * @return true if the element was successfully removed, false otherwise
     */
    public boolean remove(T data);


    /**
     * Retrieves the element at the specified index.
     *
     * @param index
     *            the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException
     *             if the index is invalid
     */
    public abstract T get(int index);


    /**
     * Checks if the list contains the specified element.
     *
     * @param data
     *            the data to search for
     * @return true if the list contains the element, false otherwise
     */
    public abstract boolean contains(T data);


    /**
     * Sorts the list using an insertion sort with the specified comparator.
     *
     * @param comparator
     *            the comparator to use for sorting
     */
    public abstract void insertionSort(Comparator<T> comparator);


    /**
     * Gets the size of the list.
     *
     * @return the number of elements in the list
     */
    public abstract int size();


    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public abstract boolean isEmpty();


    /**
     * Removes all elements from the list.
     *
     * @postcondition the size of the list is 0, and all elements are removed
     */
    public abstract void clear();


    /**
     * Finds the last occurrence of the specified element in the list.
     *
     * @param data
     *            the data to search for
     * @return the index of the last occurrence of the element, or -1 if not
     *             found
     */
    public abstract int lastIndexOf(T data);


    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    @Override
    public abstract String toString();
}
