package model.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Implementacion de LinkedQueue basada en el libro Algorithms 4th edition :https://algs4.cs.princeton.edu/home/


public interface LinkedQueue<UBERTrip> implements Iterable<UBERTrip> 
{
    boolean isEmpty();

    int size();

    UBERTrip peek();

    UBERTrip bottom();

    void agregar(UBERTrip UBERTrip);

    UBERTrip eliminar();

    String toString();

    boolean check();

    Iterator<UBERTrip> iterator();

}