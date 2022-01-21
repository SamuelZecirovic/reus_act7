package reus_act7;

import java.util.Hashtable;

import javax.swing.JOptionPane;

public class ej2 {

	public static Hashtable<String, Double> productos = new Hashtable<String, Double>();
	public static Hashtable<String, Double> compra = new Hashtable<String, Double>();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AñadirProductos();
		RealizarCompra();
		MostrarCompra();
		
		
	}
	
	public static void AñadirProductos() {
		productos.put("oreo",3.50);
		productos.put("pan",0.50);
		productos.put("fanta",1.45);
		productos.put("mandarinas",2.0);
		productos.put("leche",1.30);
		productos.put("pizza",2.50);
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
		double calculo = 0, pago= 0; 
		int cont = 0;
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
