package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bmicalc.BMICalcImpl;

public class Controlador implements ActionListener, MouseListener {
	
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
		else if (comando.equals("bmiHelp")) vista.updateMassLabel(-1);
		else if (comando.equals("categoryHelp")) vista.updateMassLabel(-1);
		else if (comando.equals("abdominalHelp")) vista.updateMassLabel(-1);
	}
	
	public void updateBMIResult(int n) {
		vista.updateMassLabel(n);
		int mass = vista.getMass();
		double height = vista.getBMISlider();
		double bmi = modelo.bmi(mass, height);
		vista.setBMIResult(bmi);
	}
	
	public void updateCategoryResult() {
		int bmi = vista.getCategoryBMI();
		String category = modelo.category(bmi);
		vista.updateCategoryResult(category);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String component = e.getComponent().getName();
		if (component == "bmiSlider") updateBMIResult(0);
		else if (component == "categorySlider") updateCategoryResult();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
