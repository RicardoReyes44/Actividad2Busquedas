import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class BusquedaBinaria{
	int pasadas = 0;
	int comparaciones = 0;
	
	public void ejecutar(long array[], long dato) {
		
		long tInicio = System.nanoTime();
		
		binarySearch(array, dato, 0, array.length-1);
		
		long tFin = System.nanoTime();
		System.out.println("Pasadas: " + pasadas);
		System.out.println("Comparaciones: " + comparaciones);
		System.out.println("Tiempo de ejecucion: " + (tFin-tInicio));

	}
	
	public boolean binarySearch(long[] data, long target, int low, int high) {
		pasadas++;
	if (low > high) {
		comparaciones++;
		return false;
	}else {
		comparaciones++;
		int mid = (low + high) / 2;
		if (target == data[mid]) {
			comparaciones++;
			return true;
		}else if (target < data[mid]) {
			comparaciones++;
			return binarySearch(data, target, low, mid - 1);
		}else {
			comparaciones++;
			return binarySearch(data, target, mid + 1, high);
		}
	}
	}
}

class Hash{
	String[] arreglo;
	int tamaño;
	int contador;

	public Hash(int tam, String []arreglo) {
		tamaño = tam;
		this.arreglo = arreglo;
	}
	
	public void funcionHash(String[] cadArreglo, String[] arreglo) {
		int i;
		// Ciclo para asiganar a la varible elemento el valor de la cadena
		for (i = 0; i < cadArreglo.length; i++) {
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 20;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			// Mpetodo para solucionar una colision
			while (arreglo[indiceArreglo] != "-1") {
				indiceArreglo++;
				System.out.println("Colisión en el indice: " + (indiceArreglo - 1) + " cambiando por " + indiceArreglo);
				// Cambiar al indice siguiente y asi evitar la colision
				indiceArreglo %= tamaño; // Para volver a sacar el valor
			}
			arreglo[indiceArreglo] = elemento;
		}
	}

	// Metodo para mostrar la funcion hash
	public void mostrar() {
		int incremento = 0;
		int j;

		for (int i = 0; i < 1; i++) {
			incremento += 20;
			System.out.println("");
			System.out.println("------------------------------------------------------------------");
			for (j = incremento - 20; j < incremento; j++) {
				System.out.format(" | %3s " + " ", j);
			}
			System.out.println(" | ");
			System.out.println();
			for (j = incremento - 20; j < incremento; j++) {
				if (arreglo[j].equals("-1")) {
					System.out.println(" | ");
				} else {
					System.out.print(String.format(" | %3s" + " ", arreglo[j]));
				}
			}

			System.out.println("|");
			System.out.println("------------------------------------------------------------------");
			System.out.println("");
		}
	}

	// Metodo para buscar una clave de los elementos
	public String buscarClave(String elemento) {
		return null;
	}
}


public class Prueba {
	
    public static long[] ejecutar(long[] array) {
		
		long []ordenado = quickSort(array, 0, array.length-1);
		
		return ordenado;
	}
	
	public static long[] quickSort(long[] array, int izq, int der){
		long pivote = array[izq];
		int i = izq, j=der;
		long aux;
		
		while(i<j) {
			while(array[i]<=pivote && i<j) i++;
			while(array[j]>pivote) j--;
			if(i<j) {
				aux = array[i];
				array[i] = array[j];
				array[j] = aux;
			}
		}
		array[izq] = array[j];
		array[j] = pivote;
		
		if(izq<j-1)
			quickSort(array, izq, j-1);
		if(j+1<der)
			quickSort(array, j+1, der);
		
		return array;
	}
	
	public static long[] generar() {
		
		long array[] = new long[100];
		
		for(int i=0; i<100; i++) {
			array[i] = (long)(Math.random()*100+1);
		}
		
		return ejecutar(array);
	}

	public static void main(String[] args) {
		
		BusquedaBinaria bs = new BusquedaBinaria();
		Scanner entrada = new Scanner(System.in);
		
		long array[] = generar();
		
		do {
		try {
			System.out.println("--------------MENU--------------");
			System.out.println("1.- Busqueda Binaria");
			System.out.println("2.- Busqueda Hash");
			System.out.println("3.- Salir");
			System.out.print("Introduce opcion: ");
			byte opcion = entrada.nextByte();
			
			System.out.println("Array: " + Arrays.toString(array));
			
			if(opcion==1) {
				
				System.out.print("\nIntroduce numero a buscar: ");
				long numero = entrada.nextLong();
				bs.ejecutar(array, numero);
				
			}else if(opcion==2) {

				

			}else if(opcion==3) {
				
				break;
				
			}else {
				System.out.println("No existe esa opcion, prueba de nuevo");
			}
		}catch(InputMismatchException e) {
			System.out.println("Error en la entrada de datos <" + e + ">, vuevle a intentarlo");
		    entrada.nextLine();
		}System.out.println();
		}while(true);
		
		System.out.println("\n\nPrograma terminado");

	}

}
