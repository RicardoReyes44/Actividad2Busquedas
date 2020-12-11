import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class BusquedaBinaria{
	
	public void ejecutar(long array[], long dato) {
		binarySearch(array, dato, 0, array.length-1);
	}
	
	public boolean binarySearch(long[] data, long target, int low, int high) {
	if (low > high)
		return false;
	else {
		int mid = (low + high) / 2;
		if (target == data[mid])
			return true;
		else if (target < data[mid])
			return binarySearch(data, target, low, mid - 1);
		else
			return binarySearch(data, target, mid + 1, high);
	}
	}
	
}

public class Prueba {
	
     public static long[] ejecutar(long[] array) {
	}
	
	public static long[] quickSort(long[] array, int izq, int der){
		
	}
	
	public static long[] generar() {
		
		long array[] = new long[100];
		
		for(int i=0; i<100; i++) {
			array[i] = (long)(Math.random()*100+1);
		}
		
		
		
		return array;
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
