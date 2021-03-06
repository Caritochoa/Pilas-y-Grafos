package PilasyColas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GrafoLista { 
	
	ArrayList<Integer> listaAdy[];

	public GrafoLista(int nVertices) {
	
		listaAdy = new ArrayList[nVertices];

		for (int i = 0; i < nVertices; i++)
			listaAdy[i] = new ArrayList<Integer>();

	}

	public void agregarArista(int vOrigen, int vDestino) {
		listaAdy[vOrigen].add(vDestino);

	}

	public void eliminarArista(int vOrigen, int vDestino) {
		//Borramos del vertice origen
		listaAdy[vOrigen].remove(buscarEnLista(vOrigen,vDestino));
		//Borramos del vertice destino
		listaAdy[vDestino].remove(buscarEnLista(vDestino,vOrigen));

	}

	public void adyacentes(int vOrigen) {
		System.out.print(listaAdy[vOrigen]);

	}

	public boolean existeArista(int vOrigen, int vDestino) {
		if (listaAdy[vOrigen].contains(vDestino))
			return true;

		return false;

	}

	public int grado(int vOrigen) {
		return listaAdy[vOrigen].size();
		
	}

	public void vectorGrados() {
		for (int i = 0; i < listaAdy.length; i++)
			System.out.println("El grado del v�rtice [" + i + "] es: " + listaAdy[i].size());

	}

	public boolean existeCaminata() {
		for (int i = 0; i < listaAdy.length - 1; i++) {
			if (!existeArista(i, i + 1))
				return false;

		}
		return true;

	}

	private int buscarEnLista(int vertice,int buscar){
		Iterator it = listaAdy[vertice].iterator();
		int pos = 0;
		int valor;
		while(it.hasNext()){
			valor = (int) it.next();
			if(valor == buscar)
				return pos;

				pos++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		
				GrafoLista grafo1 = new GrafoLista(7);
				menuP(grafo1);

			}

			public static void menuP(GrafoLista grafo1) {
				Scanner teclado = new Scanner(System.in);
				int opc;

				do {
					System.out.println();
					System.out.println();
					System.out.println(" Men� Principal ");
					System.out.println("----------------");
					System.out.println("0.- Cargar Aristas de la clase.");
					System.out.println("1.- Agregar Arista.");
					System.out.println("2.- Eliminar Arista.");
					System.out.println("3.- Mostrar lista de Adyacencia.");
					System.out.println("4.- Mostrar matriz de Adyacencia.");
					System.out.println("5.- Comprobar caminata.");
					System.out.println("6.- Comprobar grado de un v�rtice.");
					System.out.println("7.- Mostrar vector de grado.");
					System.out.println("----------------");
					System.out.println("8.- Salir.");

					opc = teclado.nextInt();

					switch (opc) {
					case 0:
						cargarAristas(grafo1);
						break;
					case 1:
						System.out.println("\n\nAgregar Arista.");
						int origen, destino;
						System.out.print("\nInserte origen de la arista: ");
						origen = teclado.nextInt();
						System.out.print("\n\nInserte destino de la arista: ");
						destino = teclado.nextInt();
						
						grafo1.agregarArista(origen, destino);
						
						System.out.println("\n\nArista a�adida.");
						break;
					case 2:
						System.out.println("\n\nEliminar Arista.");
						System.out.print("\nInserte origen de la arista: ");
						origen = teclado.nextInt();
						System.out.print("\n\nInserte destino de la arista: ");
						destino = teclado.nextInt();
						
						grafo1.eliminarArista(origen, destino);
						
						System.out.println("\n\nArista eliminada.");
						break;
					case 3:
						mostrarListaAdy(grafo1);
						break;
					case 4:
						mostrarMatrizAdy(grafo1);
						break;
					case 5:
						if (grafo1.existeCaminata())
							System.out.print("\n\nSI existe caminata.");
						else
							System.out.print("\n\nNO existe caminata.");
						break;
					case 6:
						int opc2 = 1999;
						while(opc2 >= grafo1.listaAdy.length){
							System.out.print("\n\nIngrese v�rtice a comprobar grado: ");
							opc2 = teclado.nextInt();
						}
						System.out.println("El grado del v�rtice ["+opc2+"] es: "+grafo1.listaAdy[opc2].size());
						break;
					case 7:
						System.out.println("\n\nVector de Grado:");
						for (int i = 0; i < grafo1.listaAdy.length; i++)
							System.out.print("  " + i);
						System.out.println();
						for (int i = 0; i < grafo1.listaAdy.length; i++)
						System.out.print("  "+grafo1.listaAdy[i].size());
						break;
					case 8:
						System.exit(1);
						;
						break;

					default:
						break;
					}

				} while (opc != 8);
			}

			public static void cargarAristas(GrafoLista grafo1) {

				grafo1.agregarArista(0, 1);
				grafo1.agregarArista(0, 2);

				grafo1.agregarArista(1, 0);
				grafo1.agregarArista(1, 2);
				grafo1.agregarArista(1, 3);
				grafo1.agregarArista(1, 5);

				grafo1.agregarArista(2, 0);
				grafo1.agregarArista(2, 1);
				grafo1.agregarArista(2, 3);
				grafo1.agregarArista(2, 4);

				grafo1.agregarArista(3, 1);
				grafo1.agregarArista(3, 2);
				grafo1.agregarArista(3, 4);

				grafo1.agregarArista(4, 2);
				grafo1.agregarArista(4, 3);
				grafo1.agregarArista(4, 5);

				grafo1.agregarArista(5, 1);
				grafo1.agregarArista(5, 4);
				grafo1.agregarArista(5, 6);

				grafo1.agregarArista(6, 5);

				System.out.println("\n\nAristas cargadas.");

				
			}

			public static void mostrarListaAdy(GrafoLista grafo1) {
				System.out.println("\n\nLista de Adyacencia:");
				for (int i = 0; i < grafo1.listaAdy.length; i++)
					System.out.println("[" + i + "]: " + grafo1.listaAdy[i]);

			}

			public static void mostrarMatrizAdy(GrafoLista grafo1) {
				System.out.println("\n\nMatriz de Adyacencia:");
				System.out.print("   ");
				for (int i = 0; i < grafo1.listaAdy.length; i++)
					System.out.print("  " + i);
				System.out.println();
				for (int i = 0; i < grafo1.listaAdy.length; i++) {
					System.out.print("  " + i + "  ");
					for (int j = 0; j < grafo1.listaAdy.length; j++) {
						if (grafo1.existeArista(i, j))
							System.out.print(1 + "  ");
						else
							System.out.print(0 + "  ");
					}
					System.out.println();
				}

			}

		}
	
		
		
	
		
	
		
		


