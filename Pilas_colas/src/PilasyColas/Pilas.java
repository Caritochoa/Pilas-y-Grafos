package PilasyColas;

import java.util.*;

public class Pilas {

	public static void main(String[] args) {
		
		Stack<String> pila = new Stack<String>(); /*Declaracion de la pila*/
		
		pila.push("primero");
		printStack(pila);
				
		pila.push("segundo");
		printStack(pila);

		
		pila.push("tercero");
		printStack(pila);
		
				
		pila.pop();
		printStack(pila);
		
		pila.pop();
		printStack(pila);
		
		pila.pop();
		printStack(pila);
		

	
	
	}

	private static void printStack(Stack<String> pila) {
		
		if(pila.isEmpty()){
			System.out.println("La pila esta vacia");
		}
		else {
			System.out.printf("%s TOP\n", pila);
		}
			
			
		}
		
	}


