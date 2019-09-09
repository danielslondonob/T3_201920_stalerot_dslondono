package model.data_structures;

import java.util.Iterator;

public interface IQueue <UBERTrip>
{
	//Metodos de la clase Queue.java

	
	boolean isEmpty();

	int size();

	Item peek();

	void enqueue(UBERTrip uberTrip);

	Item dequeue();

	String toString();

	Iterator<Item> iterator();



}
