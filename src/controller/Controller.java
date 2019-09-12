package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import model.data_structures.Queue;
import model.logic.MVCModelo;
import model.logic.UBERTrip;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;
	
	/* Instancia de la Vista*/
	private MVCView view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}
		
	public void run() 
	{
		try {
			modelo.cargarArchivos();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin )
		{
			//Esperar 3,5 segundos para que el usuario pueda leer
			try {
				Thread.sleep(3500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UBERTrip[]primeroUltimo=modelo.primeroUltimo();

			view.printMenu(modelo.darTamanoLista(),primeroUltimo);

			int option = lector.nextInt();
			switch(option){
			case 1: 
				

				break;


			case 2: 
				
				UBERTrip[] viajes=(UBERTrip[]) modelo.shellSort(modelo.consultarHoraDada(modelo.darNroHora()));
				
				//double tiempo=modelo.calcularTiempo();
				System.out.println("Tiempo que utilizó el algoritmo: "+ tiempo);
				
				
				int i=1;
				
				while(i<10)
				{
					System.out.println("Viaje numero: " + i+ "   tiempo promedio: "+ viajes[i].getMeanTravelTime());
					i++;
				}
				
				int j=viajes.length-10;
				
				while(j<viajes.length)
				{
					System.out.println("Viaje numero: " + j+ "   tiempo promedio: "+ viajes[j].getMeanTravelTime());
					j++;
				}

				break;	
				
			case 3: 
				
				UBERTrip[] viajes=(UBERTrip[]) modelo.merge(modelo.consultarHoraDada(modelo.darNroHora()));
				
				//double tiempo=modelo.calcularTiempo();
				System.out.println("Tiempo que utilizó el algoritmo: "+ tiempo);
				
				
				i=1;
				
				while(i<10)
				{
					System.out.println("Viaje numero: " + i+ "   tiempo promedio: "+ viajes[i].getMeanTravelTime());
					i++;
				}
				
				j=viajes.length-10;
				
				while(j<viajes.length)
				{
					System.out.println("Viaje numero: " + j+ "   tiempo promedio: "+ viajes[j].getMeanTravelTime());
					j++;
				}
				


				break;
				
			case 4: 


				break;
				
			case 5: 


				break;

			case 6:
				System.out.println("--------- \nHasta pronto! \n ");
				lector.close();
				fin = true;
				break;

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}