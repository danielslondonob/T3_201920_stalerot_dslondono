package view;

import model.logic.MVCModelo;
import model.logic.UBERTrip;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu(int cantidadViajes, UBERTrip [] primeroUltimo)
		{
			System.out.println("\nConsulta de viajes UBER\n");
			
			System.out.println("Se registró la siguiente cantidad de viajes por hora del 2ndo trimestre:\n");
			
			System.out.println("Cantidad total de viajes: "+ cantidadViajes);
			
			UBERTrip primero=primeroUltimo[0];
			UBERTrip ultimo=primeroUltimo[1];
			
			System.out.println("Primer viaje \n Zona de origen: "+ primero.getSourceID()+" zona de destino: "+ primero.getDstID() + " hora: "+ primero.getHod() + " tiempo promedio: "+ primero.getMeanTravelTime());

			System.out.println("Último viaje \n Zona de origen: "+ ultimo.getSourceID()+" zona de destino: "+ ultimo.getDstID() + " hora: "+ ultimo.getHod() + " tiempo promedio: "+ ultimo.getMeanTravelTime());
			
			System.out.println("\nOprima 1 para , consultar los viajes de una hora dada luego oprimir tecla Return: (e.g., 1):\n");
			
			//Mostrar informacion usuario opción 1
			
			System.out.println("Oprima 2 para ordenar los viajes ascendentemente usando shell sort, luego oprimir tecla Return: (e.g., 2):\n");
			
			
			
			System.out.println("Oprima 3 para , luego oprimir tecla Return: (e.g., 3):\n");
			
			System.out.println("Oprima 4 para , luego oprimir tecla Return: (e.g., 4):\n");
			
			System.out.println("Oprima 5 para , luego oprimir tecla Return: (e.g., 5):\n");
			
			System.out.println("Oprima 6 para salir del programa, luego oprimir tecla Return: (e.g., 6):\n");
		}

	
}
