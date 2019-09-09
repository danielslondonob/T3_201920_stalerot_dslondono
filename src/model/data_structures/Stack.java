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
public class Stack<UBERTrip> implements  IStack,Iterable<UBERTrip> {
    private Node<UBERTrip> primero;     // parte superior del stack 
    private int n;                // tamaño del stack

    // helper linked list class
    private static class Node<UBERTrip> 
    {
        private UBERTrip UBERTrip;
        private Node<UBERTrip> siguiente;
    }

    /**
     * Inicializa un stack vacío
     */
    public Stack() 
    {
        primero = null;
        n = 0;
    }

    /**
     * Retorna true si el stack está vacío
     *
     * @return true si el stack está vació; o sino false.
     */
    public boolean isEmpty() 
    {
        return primero == null;
    }

    /**
     * Retorna el numero de elementos en el stack
     *
     * @return el numero de elementos en el stack
     */
    public int size() {
        return n;
    }

    /**
     * Agrega un UBERTrip al stack
     *
     * @param  UBERTrip el UBERTrip para agregar
     */
    public void push(Object UBERTrip) {
    
        Node<UBERTrip> oldprimero = primero;
        primero = new Node<UBERTrip>();
        primero.UBERTrip = (UBERTrip)UBERTrip;
        primero.siguiente = oldprimero;
        n++;
    }

    /**
     * Removes and returns the UBERTrip most recently added to this stack.
     *
     * @return the UBERTrip most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public UBERTrip pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        UBERTrip UBERTrip = primero.UBERTrip;        // save UBERTrip to return
        primero = primero.siguiente;            // delete primero node
        n--;
        return UBERTrip;                   // return the saved UBERTrip
    }


    /**
     * Returns (but does not remove) the UBERTrip most recently added to this stack.
     *
     * @return the UBERTrip most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public UBERTrip peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return primero.UBERTrip;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of UBERTrips in this stack in LIFO order, separated by spaces
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
     * Returns an iterator to this stack that iterates through the UBERTrips in LIFO order.
     *
     * @return an iterator to this stack that iterates through the UBERTrips in LIFO order
     */
    public Iterator<UBERTrip> iterator() {
        return new ListIterator(primero);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<UBERTrip> {
        private Node<UBERTrip> current;

        public ListIterator(Node<UBERTrip> primero) {
            current = primero;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public UBERTrip next() {
            if (!hasNext()) throw new NoSuchElementException();
            UBERTrip UBERTrip = current.UBERTrip;
            current = current.siguiente; 
            return UBERTrip;
        }
    }


}
