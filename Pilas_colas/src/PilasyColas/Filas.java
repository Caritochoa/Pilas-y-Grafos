package PilasyColas;

import java.util.*;

public class Filas {

	public static void main(String[] args) {
		
		PriorityQueue<String>fila = new PriorityQueue<String>();/*Declaracion de la cola*/
		
		fila.offer("first");
		fila.offer("second");
		fila.offer("third");
		
		System.out.printf("%s", fila);
		/*System.out.println();*/
		
		fila.poll();
		System.out.printf("%s", fila);
	}

}
