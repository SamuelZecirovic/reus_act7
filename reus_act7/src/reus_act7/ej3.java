package reus_act7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JOptionPane;

public class ej3 {

	/**
	 * @param args
	 */
	public static Hashtable<String,int[]> productos = new Hashtable<String,int[]>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		baseDeDatos();
		String accion;
		do {
			accion = JOptionPane.showInputDialog("Que deseas hacer: \nmostrar \nañadir  \nsalir");

			switch (accion) {
			case "mostrar":
				mostarProductos();
				break;
			case "anadir":
				crearProducto();
				break;
			case "salir":
				System.exit(0);
				break;
			default:
				System.out.println("Introduce una accion valida");
				break;
			}
		} while (accion != "salir");

	}

	public static void baseDeDatos() {
		
		String nombres[] = {"oreo","pizza","pan","fanta","mandarinas","leche","croquetas","natillas","patatas","manzanas"};
		for (int i = 0; i < 10; i++) {
			int array[] = new int[2];
			productos.put(nombres[i], array);
			for(int j = 0; j < 2 ; j++) {
				double random = Math.random() * (10 - 1) + 0;
				array[j]=(int) random;
			}
				
		}
		
	}

	public static void crearProducto() {
		String nombre = JOptionPane.showInputDialog("Nombre del producto nuevo");
		int precio = Integer.parseInt(JOptionPane.showInputDialog("Precio del producto nuevo"));
		int cantidad =Integer.parseInt(JOptionPane.showInputDialog("Cantidad del producto nuevo"));
		int array[] = new int[2] ; 
		array[0] = precio;
		array[1] = cantidad;
		productos.put(nombre, array);
	}

	public static void mostarProductos() {
		for (String i : productos.keySet()) {
			int[] info = productos.get(i).clone();
			System.out.println("producto: " + i + " precio: "+info[0]+" stock: "+info[1]);
		}
		System.out.println("----------------");

	}

	

}