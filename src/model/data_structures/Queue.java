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

public class Queue<UBERTrip> implements IQueue,Iterable<UBERTrip> {
    private Node<UBERTrip> primero;    // comienzo del queue
    private Node<UBERTrip> ultimo;     // fin del queue
    private int n;               // numero de elementos en el queue

    // helper linked list class

    private static class Node<UBERTrip> 
    {
        private UBERTrip UBERTrip;
        private Node<UBERTrip> next;
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
    public UBERTrip peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return primero.UBERTrip;
    }

    /**
     * Adds the UBERTrip to this queue.
     *
     * @param  UBERTrip the UBERTrip to add
     */
    public void enqueue(Object UBERTrip) {
        Node<UBERTrip> oldultimo = ultimo;
        ultimo = new Node<UBERTrip>();
        ultimo.UBERTrip = (UBERTrip)UBERTrip;
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
    public UBERTrip dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        UBERTrip UBERTrip = primero.UBERTrip;
        primero = primero.next;
        n--;
        if (isEmpty()) ultimo = null;   // to avoid loitering
        return UBERTrip;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of UBERTrips in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (UBERTrip UBERTrip : this) {
            s.append(UBERTrip);
            s.append(' ');
        }
        return s.toString();
    } 

    /**
     * Returns an iterator that iterates over the UBERTrips in this queue in FIFO order.
     *
     * @return an iterator that iterates over the UBERTrips in this queue in FIFO order
     */
    public Iterator<UBERTrip> iterator()  {
        return new ListIterator(primero);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<UBERTrip> {
        private Node<UBERTrip> current;

        public ListIterator(Node<UBERTrip> primero) {
            current = primero;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public UBERTrip next() {
            if (!hasNext()) throw new NoSuchElementException();
            UBERTrip UBERTrip = current.UBERTrip;
            current = current.next; 
            return UBERTrip;
        }
    }



}
