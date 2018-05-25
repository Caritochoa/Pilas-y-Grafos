package PilasyColas;

public class Arbol_binario {/*declaración del arbol*/
	
	Nodo raiz;
	
	public Arbol_binario() {
		raiz = null;
		
	}
	
	public void insertar(int key, Object valor) {/*metodo para insertar items al arbol*/
		Nodo n = new Nodo(key);
		n.valor = valor;
		
		if(raiz == null) {
			raiz = n;
		} 
		else {
			Nodo temporal = raiz;
			while(temporal != null){
				n.padre = temporal;
				if(n.llave >= temporal.llave) {
					temporal = temporal.derecho;					
				}
				else {
					temporal = temporal.izquierdo;
				}		
				
			}
			if(n.llave < n.padre.llave) {
				n.padre.izquierdo = n;				
			}
			else {
				n.padre.derecho = n;
			}
			
		}
		
	}
	public void recorrido_en_orden(Nodo x) {/* metodo para recorrer el arbol in order*/
		if(x != null) {
			recorrido_en_orden(x.izquierdo);
			System.out.println(x.llave);
			recorrido_en_orden(x.derecho);
		}
		}
	
	
	private static class Nodo {
		
		public Nodo padre;
		public Nodo derecho;
		public Nodo izquierdo;
		public int llave;
		public Object valor;
		
		public Nodo(int key) { /*constructor para inicializar los atributos*/
			llave = key;
			derecho = null;
			izquierdo = null;
			padre = null;
			valor = null;
		}
	
	public static void main(String[] args) {
		
		Arbol_binario  arbol1 = new Arbol_binario();
		
		arbol1.insertar(5, null);
		arbol1.insertar(8, null);
		arbol1.insertar(4, null);
		arbol1.insertar(10, null);
		arbol1.insertar(6, null);
		arbol1.insertar(2, null);
		arbol1.insertar(1, null);
		arbol1.insertar(3, null);
		
		arbol1.recorrido_en_orden(arbol1.raiz);/*empieza desde el nodo raiz y recorre todo el arbol*/
		
		arbol1.recorrido_en_orden(arbol1.raiz.izquierdo);
		

	}

}}
