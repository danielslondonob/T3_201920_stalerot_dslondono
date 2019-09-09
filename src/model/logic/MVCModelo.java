package model.logic;

import model.data_structures.ArregloDinamico;
import java.util.Iterator;
import model.data_structures.IArregloDinamico;
import model.data_structures.LinkedQueue;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.data_structures.IStack;
import model.data_structures.IQueue;
/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo 
{
	/**
	 * Atributos del modelo del mundo
	 */
	private Stack stack; 
	
	private Queue queue;
	
	private LinkedQueue linkedQueue; 
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		stack = new Stack();
		
		queue = new Queue(); 
		
		linkedQueue = new LinkedQueue(); 
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoPila()
	{
		return stack.size();
	}
	
	public int darTamanoCola()
	{
		return queue.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		stack.push(dato);
		queue.enqueue(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	//public String buscar(String dato)
	{
		//return datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar()
	{
		queue.dequeue();
		return (String)stack.pop();
	}
	
	
	//Punto 3.1 
	public Queue<UBERTrip> consultaPorHora(int hora)
	{
		Queue colaModelo= colaAPartirDe(hora);
		
		Queue clusterFinal= new Queue();
		Queue clusterAuxiliar= new Queue();
		
		int horaMax=0;
		
		Iterator iter= colaModelo.iterator();
		
		while(iter.hasNext())
		{
			UBERTrip actual= (UBERTrip)iter.next();
			
			if(actual.getHod()>=horaMax)
			{
				horaMax=actual.getHod();
				clusterAuxiliar.enqueue(actual);
			}
			else
			{
				if(clusterAuxiliar.size()>clusterFinal.size())
				{
					clusterFinal=clusterAuxiliar;
				}
				clusterAuxiliar= new Queue();
				clusterAuxiliar.enqueue(actual);
				horaMax=actual.getHod();
			}
		}
		
		return clusterFinal;
	}
	
	public Queue<UBERTrip> colaAPartirDe(int hora)
	{
		Queue colaNueva= new Queue();
		
		Iterator iter= queue.iterator();
		
		boolean empezar=false;
		
		while(iter.hasNext())
		{
			UBERTrip actual= (UBERTrip)iter.next();
			
			
			if(empezar)
			{
				colaNueva.enqueue(actual);
			}
			else if(actual.getHod()==hora)
			{
				empezar=true;
				colaNueva.enqueue(actual);
			}
		}
		
		return colaNueva;
	}
	
	public void ordenamientoQuickSort( int arr[], int inicio, int fin ) 
	{
		if( inicio < fin ) 
		{
			int indiceParticion = particion(arr, inicio, fin);
			
			ordenamientoQuickSort(arr, inicio, indiceParticion - 1);
			
			ordenamientoQuickSort(arr, indiceParticion + 1, fin );
		}
		
	}
	
	private int particion( int arr[], int inicio, int fin ) 
	{package model.logic;

import model.data_structures.ArregloDinamico;
import java.util.Iterator;
import model.data_structures.IArregloDinamico;
import model.data_structures.LinkedQueue;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.data_structures.IStack;
import model.data_structures.IQueue;
/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo 
{
	/**
	 * Atributos del modelo del mundo
	 */
	private Stack stack; 
	
	private Queue queue;
	
	private LinkedQueue linkedQueue; 
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		stack = new Stack();
		
		queue = new Queue(); 
		
		linkedQueue = new LinkedQueue(); 
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoPila()
	{
		return stack.size();
	}
	
	public int darTamanoCola()
	{
		return queue.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		stack.push(dato);
		queue.enqueue(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	//public String buscar(String dato)
	{
		//return datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar()
	{
		queue.dequeue();
		return (String)stack.pop();
	}
	
	
	//Punto 3.1 
	public Queue<UBERTrip> consultaPorHora(int hora)
	{
		Queue colaModelo= colaAPartirDe(hora);
		
		Queue clusterFinal= new Queue();
		Queue clusterAuxiliar= new Queue();
		
		int horaMax=0;
		
		Iterator iter= colaModelo.iterator();
		
		while(iter.hasNext())
		{
			UBERTrip actual= (UBERTrip)iter.next();
			
			if(actual.getHod()>=horaMax)
			{
				horaMax=actual.getHod();
				clusterAuxiliar.enqueue(actual);
			}
			else
			{
				if(clusterAuxiliar.size()>clusterFinal.size())
				{
					clusterFinal=clusterAuxiliar;
				}
				clusterAuxiliar= new Queue();
				clusterAuxiliar.enqueue(actual);
				horaMax=actual.getHod();
			}
		}
		
		return clusterFinal;
	}
	
	public Queue<UBERTrip> colaAPartirDe(int hora)
	{
		Queue colaNueva= new Queue();
		
		Iterator iter= queue.iterator();
		
		boolean empezar=false;
		
		while(iter.hasNext())
		{
			UBERTrip actual= (UBERTrip)iter.next();
			
			
			if(empezar)
			{
				colaNueva.enqueue(actual);
			}
			else if(actual.getHod()==hora)
			{
				empezar=true;
				colaNueva.enqueue(actual);
			}
		}
		
		return colaNueva;
	}
	
	public void ordenamientoQuickSort( int arr[], int inicio, int fin ) 
	{
		if( inicio < fin ) 
		{
			int indiceParticion = particion(arr, inicio, fin);
			
			ordenamientoQuickSort(arr, inicio, indiceParticion - 1);
			
			ordenamientoQuickSort(arr, indiceParticion + 1, fin );
		}
		
	}
	
	private int particion( int arr[], int inicio, int fin ) 
	{
		int pivot = arr[fin];		
		int i = inicio - 1;
		
		for( int j = inicio; j < fin; j++) 
		{
			if( arr[j] <= pivot ) 
			{
				i++;
				int cambioTemporal = arr[i];
				arr[i] = arr[j];
				arr[j] = cambioTemporal;
			}
		}
		
		int cambioTemporal = arr[i+1];
		arr[i+1] = arr[fin];
		arr[fin] = cambioTemporal;
		
		return i+1; 
		
	}
	
	
	
	


}
		int pivot = arr[fin];		
		int i = inicio - 1;
		
		for( int j = inicio; j < fin; j++) 
		{
			if( arr[j] <= pivot ) 
			{
				i++;
				int cambioTemporal = arr[i];
				arr[i] = arr[j];
				arr[j] = cambioTemporal;
			}
		}
		
		int cambioTemporal = arr[i+1];
		arr[i+1] = arr[fin];
		arr[fin] = cambioTemporal;
		
		return i+1; 
		
	}
	
	
	
	


}
package model.logic;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new ArregloDinamico(7);
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public MVCModelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}


}
