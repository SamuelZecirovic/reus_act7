package reus_act7;

import java.util.Hashtable;

import javax.swing.JOptionPane;

public class ej3 {

	public static Hashtable<String, Double[][]> productos = new Hashtable<String, Double[][]>();
	public static Hashtable<String, Double> compra = new Hashtable<String, Double>();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CrearProductos();
		AñadirProductos();
		RealizarCompra();
		MostrarCompra();
		
		
	}
	
	public static void CrearProductos() {
		
		double preciostock[][] = {{3.50,5},{0.50,5},{1.45,5},{2,5},{1.30,5},{2.50,5},{1.50,5},{1.20,5},{0.85,5},{0.60,5}};
		
		productos.put("oreo",preciostock[1][1]);
		productos.put("pan",preciostock[2][2]);
		productos.put("fanta",preciostock[3][3]);
		productos.put("mandarinas",preciostock[4][4]);
		productos.put("leche",preciostock[5][5]);
		productos.put("pizza",preciostock[6][6]);
		productos.put("croquetas",preciostock[7][7]);
		productos.put("natillas",preciostock[8][8]);
		productos.put("patatas",preciostock[9][9]);
		productos.put("manzanas",preciostock[10][10]);
	}
	
	public static void AñadirProductos() {
		
		String producto = JOptionPane.showInputDialog("nombre del producto");
		double precio = Integer.parseInt(JOptionPane.showInputDialog("precio del producto"));
		//String tipoiva =  JOptionPane.showInputDialog("el producto tendra un iva de 21%? (responda con si/no)");
		//boolean esiva = tipoiva.equalsIgnoreCase("si");
		
		productos.put(producto, precio);
	}
	
	public static void RealizarCompra() {
		
		Boolean salir = false;
		
		do {
		
			String producto = JOptionPane.showInputDialog("escoja que desea comprar (oreo,pan,fanta,mandarinas,leche,pizza) o dele a finalizar");
			int unidades = 0; 
	
			Double precio = 0.0; 
			
			switch (producto) {
				case "pan":
				case "mandarinas":
				case "leche":
					unidades = Integer.parseInt(JOptionPane.showInputDialog("cuantas unidades desa comprar (kg en caso de fruta/vegetales)"));
					for (int i = 0; i < unidades; i++) {
						precio = productos.get(producto);
						precio = precio*0.04 + precio;
						compra.put(producto + " x " + (i+1),precio);
					}
					
				break;
				
				case "oreo":
				case "fanta":
				case "pizza":
					
					unidades = Integer.parseInt(JOptionPane.showInputDialog("cuantas unidades desa comprar (kg en caso de fruta/vegetales)"));

					for (int i = 0; i < unidades; i++) {
						precio = productos.get(producto);
						precio = precio*0.21 + precio;
						compra.put(producto + " x " + (i+1),precio);
					}
	
				break;
				
				case "finalizar":
					salir = true;
				break;
		
				default:
					System.out.println("el producto no existe");
					break;
			}
		}while(salir == false);

	}
	
	public static void MostrarCompra() {
		double calculo = 0, pago= 0, cont = 0;
		for (String i : compra.keySet()) {
			
			System.out.println(i +" : "+ compra.get(i));
			calculo = calculo + compra.get(i);
			cont++;
		}

		System.out.println("ha comprado " + cont + " articulos");
		
		do {
		System.out.println("el total sera de " + calculo + "€");
		pago = Integer.parseInt(JOptionPane.showInputDialog("con cuanto pagara? (recuerde pagar la cantidad pedida o mas)"));
		System.out.println("ha pagado: " + pago+ "€" );
		}while(pago < calculo);
		System.out.println("tenga aqui su cambio: " + (pago - calculo));
		
	}

}
