package gui;
import java.awt.EventQueue;
import bmicalc.BMICalcImpl;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalcImpl modelo = new BMICalcImpl();
					MainWindow vista = new MainWindow();
					Controlador controlador = new Controlador(modelo, vista);
					vista.registrarControlador(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}