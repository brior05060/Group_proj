// Virginia Tech Honor Code Pledge:
// Project 5 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Baz Atiyeh (90632952)

package prj5;

import java.util.Comparator;

/**
 * A singly linked list implementation for the Social Media Analytics
 * Dashboard project.
 *
 * @param <T>
 *            The type of object that this class will store.
 * 
 * @author baz atiyeh
 * @version Nov 18, 2024
 */
public class LinkedList<T> implements LinkedListInterface<T> {

    /**
     * Represents a node in the singly linked list.
     *
     * @param <D>
     *            The type of data stored in the node.
     */
    public static class Node<D> {

        private D data;
        private Node<D> next;

        /**
         * Creates a new node with the given data.
         *
         * @param data
         *            the data to store in the node
         */
        public Node(D data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Retrieves the data stored in the node.
         *
         * @return the data in the node
         */
        public D getData() {
            return data;
        }

        /**
         * Retrieves the next node in the list.
         *
         * @return the next node
         */
        public Node<D> next() {
            return next;
        }

        /**
         * Sets the next node.
         *
         * @param next
         *            the next node to link to
         */
        public void setNext(Node<D> next) {
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    /**
     * Creates an empty LinkedList.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param data
     *            the data to add to the list
     * @throws IllegalArgumentException
     *             if the data is null
     */
    @Override
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } 
        else 
        {
            Node<T> current = head;
            while (current.next() != null) {
                current = current.next();
            }
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param data
     *            the data to remove from the list
     * @throws IllegalArgumentException
     *             if the data is null
     */
    @Override
    public boolean remove(T data) {
        if (data == null || head == null) {
            return false;
        }

        if (data.equals(head.getData())) {
            head = head.next();
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next() != null) {
            if (data.equals(current.next().getData())) {
                current.setNext(current.next().next());
                size--;
                return true;
            }
            current = current.next();
        }

        return false;
    }


    /**
     * Retrieves the element at the specified index.
     *
     * @param index
     *            the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException
     *             if the index is invalid
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current.getData();
    }

    /**
     * Checks if the list contains the specified element.
     *
     * @param data
     *            the data to search for
     * @return true if the list contains the element, false otherwise
     */
    @Override
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (data.equals(current.getData())) {
                return true;
            }
            current = current.next();
        }
        return false;
    }

    /**
     * Sorts the list using an insertion sort with the specified comparator.
     *
     * @param comparator
     *            the comparator to use for sorting
     */
    @Override
    public void insertionSort(Comparator<T> comparator) {
        if (head == null || head.next() == null) {
            return;
        }
        Node<T> sorted = null;
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next();
            sorted = insertSorted(sorted, current, comparator);
            current = next;
        }
        head = sorted;
    }

    private Node<T> insertSorted(Node<T> sorted, 
        Node<T> newNode, Comparator<T> comparator) {
        if (sorted == null || comparator.compare(newNode.getData(),
            sorted.getData()) < 0) {
            newNode.setNext(sorted);
            return newNode;
        }
        Node<T> current = sorted;
        while (current.next() != null && comparator.compare(newNode.getData(),
            current.next().getData()) >= 0) {
            current = current.next();
        }
        newNode.setNext(current.next());
        current.setNext(newNode);
        return sorted;
    }

    /**
     * Retrieves the number of elements in the list.
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all elements from the list.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Finds the last occurrence of the specified element in the list.
     *
     * @param data
     *            the data to search for
     * @return the index of the last occurrence of the 
     * element, or -1 if not found
     */
    @Override
    public int lastIndexOf(T data) {
        int lastIndex = -1;
        int currentIndex = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next();
        }
        return lastIndex;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representing the list in the format "{A, B, C}"
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        Node<T> current = head;
        while (current != null) {
            result.append(current.getData());
            current = current.next();
            if (current != null)
            {
                result.append(", ");
            }
        }
        result.append("}");
        return result.toString();
    }
}
