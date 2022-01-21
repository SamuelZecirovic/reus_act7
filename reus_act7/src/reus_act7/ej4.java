package reus_act7;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class ej4 {

	/**
	 * @param args
	 */
	public static Hashtable<String, int[]> productos = new Hashtable<String, int[]>();
	public static ArrayList<Integer> carrito = new ArrayList<Integer>();

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
				
			case "comprar":
				crearCarrito();
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
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad del producto nuevo"));
		int array[] = new int[2];
		array[0] = precio;
		array[1] = cantidad;
		productos.put(nombre, array);
	}

	public static void mostarProductos() {
		for (String i : productos.keySet()) {
			int[] info = productos.get(i).clone();
			System.out.println("producto: " + i + " precio: " + info[0] + " stock: " + info[1]);
		}
		System.out.println("--------------------------------------------------");
	}

	public static double iva(int producto, String ivaAplicado) {
		double precioCalculado = 0;
		switch (ivaAplicado) {
		case "21%":
			precioCalculado = producto + (producto * 0.21);
			break;
		case "4%":
			precioCalculado = producto + (producto * 0.04);
			break;
		default:
			System.out.println("Introduce un porcentaje valido");
			break;
		}
		return precioCalculado;
	}
	
	public static void factura() {
		String ivaAplicado = JOptionPane.showInputDialog("IVA aplicado: 21% o 4%");
		for (int i = 0; i < carrito.size(); i++) {
			System.out.println("Producto " + (i + 1) + " tiene un precio bruto de " + carrito.get(i)
					+ " y un precio con iva de " + iva(carrito.get(i), ivaAplicado));
		}
		System.out.println("Numero de productos comprados: " + carrito.size());
		cobrar();
	}

	public static void cobrar() {
		int total = 0;
		for (int i = 0; i < carrito.size(); i++) {
			total = total + carrito.get(i);
		}
		System.out.println("Total a pagar: " + total);
		int pagar = Integer.parseInt(JOptionPane.showInputDialog("Cantidad pagada"));
		System.out.println("Cambio a devolver: " + (pagar - total));
	}
	
	public static void crearCarrito() {
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos comprados"));
		for (int i = 0; i < cantidad; i++) {
			String producto = JOptionPane.showInputDialog("Que quieres comprar?");
			int precio[] =productos.get(producto);
			carrito.add(precio[0]);
		}
		factura();
	}

}
