package model.data_structures;

import java.util.Iterator;

public interface IStack <UBERTrip>
{
	//Lista de metodos de la clase Stack.java

	boolean isEmpty();

	int size();

	void push (UBERTrip UBERTrip);

	UBERTrip pop();

	UBERTrip peek();

	String toString();

	Iterator<UBERTrip> iterator();

	

}
