package model.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Implementacion de LinkedQueue basada en el libro Algorithms 4th edition :https://algs4.cs.princeton.edu/home/


public class LinkedQueue<UBERTrip> implements Iterable<UBERTrip> 
{
    /*
    *
    *   Numero de elementos en la lista
    */
    private int n;     

     /*
    *   Primer nodo de la lista
    */   
    private Node primero;  

    /*
    *   Ultimo nodo de la lista
    */  
    private Node ultimo;     

    /*
    *   Metodo constructor privado de la clase Node
    */
    private class Node 
    {
        private UBERTrip UBERTrip;

        private Node siguiente;
    }

    /**
     * Inicializa una LinkedList Vacía
     */
    public LinkedQueue() 
    {
        primero = null;
        ultimo  = null;
        n = 0;
        assert check();
    }

    /**
     * Metodo para ver si la lista está vacía
     * @return true si está vacía
     */
    public boolean isEmpty() 
    {
        return primero == null;
    }

    /**
     * Retorna el numero de elementos en la LinkedList
     * @return el numero de UBERTrips en la LinkedList
     */
    public int size() 
    {
        return n;     
    }

    /**
     * Retorna el elemento agregado más viejo
     * @return El elemento agregado más viejo
     * @throws java.util.NoSuchElementException si el queue está vacío
     */
    public UBERTrip peek() 
    {
        if (isEmpty()) throw new NoSuchElementException("Desbordamiento de Queue");
        return primero.UBERTrip;
    }
    
    /**
     * Retorna el último elemento agregado
     * @return El último elemento agregado
     * @throws java.util.NoSuchElementException si el queue está vacío
     */
    public UBERTrip bottom() 
    {
        if (isEmpty()) throw new NoSuchElementException("Desbordamiento de Queue");
        return ultimo.UBERTrip;
    }

    /**
     * Agrega un elemento al final del queue
     * @param UBERTrip UBERTrip a agregar
     */
    public void agregar(UBERTrip UBERTrip) 
    {
        Node pUltimo = ultimo;
        ultimo = new Node();
        ultimo.UBERTrip = UBERTrip;
        ultimo.siguiente = null;
        if (isEmpty()) primero = ultimo;
        else           pUltimo.siguiente = ultimo;
        n++;
        assert check();
    }

    /**
     * Elimina y retorna el UBERTrip en esta queue que fue el ultimo agregado.
     * @return El elemento en esta queue que fue el ultimo agregado
     * @throws java.util.NoSuchElementException si el queue esta vacio
     */
    public UBERTrip eliminar() 
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        UBERTrip UBERTrip = primero.UBERTrip;
        primero = primero.siguiente;
        n--;
        if (isEmpty()) ultimo = null;   
        assert check();
        return UBERTrip;
    }

    /**
     * Returns a string representation of this queue.
     * @return the sequence of UBERTrips in FIFO order, separated by spaces
     */
    //METODO TO STRING
    public String toString() 
    {
        StringBuilder s = new StringBuilder();
        for (UBERTrip UBERTrip : this)
            s.append(UBERTrip + " ");
        return s.toString();
    } 

    // check internal invariants
    private boolean check() 
    {
        if (n < 0) {
            return false;
        }
        else if (n == 0) {
            if (primero != null) return false;
            if (ultimo  != null) return false;
        }
        else if (n == 1) {
            if (primero == null || ultimo == null) return false;
            if (primero != ultimo)                 return false;
            if (primero.siguiente != null)            return false;
        }
        else {
            if (primero == null || ultimo == null) return false;
            if (primero == ultimo)      return false;
            if (primero.siguiente == null) return false;
            if (ultimo.siguiente  != null) return false;

            // check internal consistency of instance variable n
            int numberOfNodes = 0;
            for (Node x = primero; x != null && numberOfNodes <= n; x = x.siguiente) {
                numberOfNodes++;
            }
            if (numberOfNodes != n) return false;

            // check internal consistency of instance variable last
            Node lastNode = primero;
            while (lastNode.siguiente != null) {
                lastNode = lastNode.siguiente;
            }
            if (ultimo != lastNode) return false;
        }

        return true;
    } 
 

    /**
     * Returns an iterator that iterates over the UBERTrips in this queue in FIFO order.
     * @return an iterator that iterates over the UBERTrips in this queue in FIFO order
     */
    public Iterator<UBERTrip> iterator()  
    {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    //Clase Iterator
    private class ListIterator implements Iterator<UBERTrip> {
        private Node current = primero;

        public boolean hasNext()  { return current != null;                     }


        public UBERTrip next() {
            if (!hasNext()) throw new NoSuchElementException();
            UBERTrip UBERTrip = current.UBERTrip;
            current = current.siguiente; 
            return UBERTrip;
        }
    }

}