package model.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 *  Implementación tomada de:
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class Queue<Item> implements IQueue{
    private Node<Item> primero;    // comienzo del queue
    private Node<Item> ultimo;     // fin del queue
    private int n;               // numero de elementos en el queue

    // helper linked list class

    private static class Node<Item> 
    {
        private Item node;
        private Node<Item> next;
    }

    /**
     * Inicializa un queue vacío
     */
    public Queue() {
        primero = null;
        ultimo  = null;
        n = 0;
    }

    /**
     * Retorna true si el queue esta vacío
     *
     * @return {@code true} si el queue está vació; o sino {@code false} 
     */
    public boolean isEmpty() {
        return primero == null;
    }

    /**
     * Returns the number of UBERTrips in this queue.
     *
     * @return the number of UBERTrips in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the UBERTrip least recently added to this queue.
     *
     * @return the UBERTrip least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return primero.node;
    }

    /**
     * Adds the UBERTrip to this queue.
     *
     * @param  UBERTrip the UBERTrip to add
     */
    public void enqueue(Object objeto) {
        Node<Item> oldultimo = ultimo;
        ultimo = new Node<Item>();
        ultimo.node = (Item)objeto;
        ultimo.next = null;
        if (isEmpty()) primero = ultimo;
        else           oldultimo.next = ultimo;
        n++;
    }

    /**
     * Removes and returns the UBERTrip on this queue that was least recently added.
     *
     * @return the UBERTrip on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item objeto = primero.node;
        primero = primero.next;
        n--;
        if (isEmpty()) ultimo = null;   // to avoid loitering
        return objeto;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of UBERTrips in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Object objeto : this) {
            s.append(objeto);
            s.append(' ');
        }
        return s.toString();
    } 

    /**
     * Returns an iterator that iterates over the UBERTrips in this queue in FIFO order.
     *
     * @return an iterator that iterates over the UBERTrips in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return (Iterator<Item>) new ListIterator(primero);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> primero) {
            current = primero;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item UBERTrip = current.node;
            current = current.next; 
            return UBERTrip;
        }
    }



}
