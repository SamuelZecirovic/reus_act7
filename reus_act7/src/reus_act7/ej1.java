package reus_act7;

import java.util.Hashtable;

import javax.swing.JOptionPane;

public class ej1 {
	
	
	public static Hashtable<String, int[]> alumno = new Hashtable<String, int[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CompletarNotas();
		MostrarNotas();
		
	}
	
	public static void CompletarNotas() {
		int nalumnos = Integer.parseInt(JOptionPane.showInputDialog("numero de alumnos"));
		int nasignaturas = Integer.parseInt(JOptionPane.showInputDialog("numero de asignaturas"));
		int[] notas= new int[nasignaturas];
		
		for (int i = 0; i < nalumnos; i++) {
			String nombreAlumno = JOptionPane.showInputDialog("nombre alumno");
			//String nombreAlumno = "alumno"+(i+1);
			
			for (int j = 0; j < nasignaturas; j++) {
				int nota = Integer.parseInt(JOptionPane.showInputDialog("nota"));	
				notas[j]=nota;
			}
			alumno.put(nombreAlumno,notas);
		}
		
		
		
	}
	
	public static void MostrarNotas() {

		for (String i : alumno.keySet()) {
			int calculo = 0;
			int media = 0;
			System.out.println("------------------------------------");
			System.out.println("notas de: " + i);
			
			for (int j = 0; j < alumno.get(i).length; j++) {
				System.out.println(alumno.get(i)[j]);
				calculo = calculo + alumno.get(i)[j];
			}
			media = calculo / alumno.get(i).length;
			System.out.println("la media es de " +media);
		}
		
	}

}

