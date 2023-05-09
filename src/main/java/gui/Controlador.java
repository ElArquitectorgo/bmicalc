package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bmicalc.BMICalcImpl;
import bmicalc.Gender;
import bmicalc.ObesityCategory;

public class Controlador implements ActionListener, MouseListener, ChangeListener {
	
	private BMICalcImpl modelo;
	private MainWindow vista;
	
	public Controlador(BMICalcImpl modelo, MainWindow vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equals("minusFive")) updateBMIResult(-5);
		else if (comando.equals("minusOne")) updateBMIResult(-1);
		else if (comando.equals("plusOne")) updateBMIResult(1);
		else if (comando.equals("plusFive")) updateBMIResult(5);
		else if (comando.equals("bmiHelp")) JOptionPane.showMessageDialog(vista,
                "Pulsa en los botones para añadir o restar kilos.\n"
                + "Mueve el deslizador para ajustar tu altura.\n"
                + "El resultado se muestra junto a su categoría.\n");
		else if (comando.equals("categoryHelp")) vista.updateMassLabel(-1);
		else if (comando.equals("abdominalHelp")) vista.updateMassLabel(-1);
		
		else if (comando.equals("male")) updateRadioButtons("male");
		else if (comando.equals("female")) updateRadioButtons("female");
	}
	
	public void updateBMIResult(int n) {
		vista.updateMassLabel(n);
		int mass = vista.getMass();
		double height = vista.getBMISlider();
		double bmi = modelo.calculateBodyMassIndex(mass, height);
		vista.setBMIResult(bmi);
		vista.updateCategoryResult(modelo.getObesityCategory(bmi));
	}
	
	public void updateCategoryResult() {
		int bmi = vista.getCategoryBMI();
		ObesityCategory category = modelo.getObesityCategory(bmi);
		vista.updateCategoryResult(category);
	}
	
	public void updateRadioButtons(String button) {
		vista.setRadioButton(button);
		updateObesityResult();
	}
	
	public void updateObesityResult() {
		char gender = vista.getRadioButton();
		double waistCircumference = vista.getObesitySlider();
		Gender genre = (gender == 'M') ? Gender.MALE : Gender.FEMALE;
		boolean result = modelo.abdominalObesity(waistCircumference, genre);
		vista.updateObesityResult(result);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Tengo que poner algo para el bad smell
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Tengo que poner algo para el bad smell
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String component = e.getComponent().getName();
		if (component.equals("bmiSlider")) updateBMIResult(0);
		else if (component.equals("categorySlider")) updateCategoryResult();
		else if (component.equals("obesitySlider")) updateObesityResult();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Tengo que poner algo para el bad smell
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Tengo que poner algo para el bad smell
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		vista.updateSliderLabels();
		
	}

}
