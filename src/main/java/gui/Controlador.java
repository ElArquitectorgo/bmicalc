package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bmicalc.BMICalcImpl;

public class Controlador implements ActionListener {
	
	private BMICalcImpl modelo;
	private MainWindow vista;
	
	public Controlador(BMICalcImpl modelo, MainWindow vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("bmiHelp")) {
			vista.setResultado(30);
		} else if (comando.equals("categoryHelp")) {
			vista.setResultado(30);
		} else if (comando.equals("abdominalHelp")) {
			vista.setResultado(30);
		}
	}

}
