package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.LinkedQueue;
import model.data_structures.Queue;
import model.data_structures.Stack;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private LinkedQueue lista;
	private ArregloDinamico arreglo;
	private int nroHora;

	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		lista = new LinkedQueue<UBERTrip>();
		arreglo= new ArregloDinamico(10);
	}
	

	
	public int darTamanoLista()
	{
		return lista.size();
	}
	
	public int darNroHora()
	{
		return nroHora;
	}
	
	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(UBERTrip dato)
	{	
		lista.agregar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public UBERTrip eliminar()
	{
		UBERTrip viaje= (UBERTrip) lista.bottom();
		lista.eliminar();
		return viaje;
	}
	
	public void cargarArchivos() throws IOException
	{
		CSVReader reader = null;
		try 
		{
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-HourlyAggregate.csv"));

			
			reader.readNext();

			
			for(String[] nextLine : reader)
			{
				UBERTrip actual= new UBERTrip(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));
				lista.agregar(actual);
			}

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		finally{
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
	}
	
	public UBERTrip[] primeroUltimo()
	{
		UBERTrip[] datos= new  UBERTrip[2];
		
		datos [0]= (UBERTrip) lista.peek();
		datos[1]=(UBERTrip) lista.bottom();
		
		return datos;
	}
	
	public Comparable[] consultarHoraDada(int hora)
	{
		nroHora=hora;
		//REALIZAR
		return null;
		
	}
	
	
	

    private static boolean less(Comparable v, Comparable w)
    {  return v.compareTo(w) < 0;  }
    private static void exch(Comparable[] a, int i, int j)
    {  Comparable t = a[i]; a[i] = a[j]; a[j] = t;  }
	
	public Comparable[] shellSort(Comparable []a)
	{
		int N = a.length;
		int h = 1;
		while (h < N/3) h = 3*h + 1; 
		while (h >= 1)
		{  // h-sort the array.
			for (int i = h; i < N; i++)
			{  // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
					exch(a, j, j-h);
			}
			h = h/3; }
		
		return a;
	
	}
	

	  public static void merge(Comparable[] a, int lo, int mid, int hi)
	  {  // Merge a[lo..mid] with a[mid+1..hi].
	     int i = lo, j = mid+1;
	     for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].
	        aux[k] = a[k];
	     for (int k = lo; k <= hi; k++)  // Merge back to a[lo..hi].
	        if      (i > mid)              a[k] = aux[j++];
	        else if (j > hi )              a[k] = aux[i++];
	        else if (less(aux[j], aux[i])) a[k] = aux[j++];
	        else                           a[k] = aux[i++];
	}
	
	


}
