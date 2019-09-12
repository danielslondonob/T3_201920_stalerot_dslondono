package model.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Implementacion de LinkedQueue basada en el libro Algorithms 4th edition :https://algs4.cs.princeton.edu/home/


public interface ILinkedQueue<Item> extends Iterable<Item> 
{
    boolean isEmpty();

    int size();

    Item peek();

    Item bottom();

    void agregar(Item item);

    Item eliminar();

    String toString();

    boolean check();

    Iterator<Item> iterator();

}