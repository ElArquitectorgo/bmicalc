package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JButton bmiHelpButton;
	private JButton categoryHelpButton;
	private JButton abdominalHelpButton;
	private JLabel obesityResult;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("BMI", null, panel, null);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("BMI:");
		panel.add(lblNewLabel);
		
		JLabel bmiResult = new JLabel("20");
		bmiResult.setFont(new Font("Tahoma", Font.PLAIN, 32));
		bmiResult.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(bmiResult);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton minusFiveButton = new JButton("-5");
		panel_3.add(minusFiveButton);
		
		JButton minusOneButton = new JButton("-1");
		panel_3.add(minusOneButton);
		
		JLabel massLabel = new JLabel("70 kg");
		panel_3.add(massLabel);
		
		JButton plusOneButton = new JButton("+1");
		panel_3.add(plusOneButton);
		
		JButton plusFiveButton = new JButton("+5");
		panel_3.add(plusFiveButton);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JSlider bmiSlider = new JSlider();
		bmiSlider.setMinimum(100);
		bmiSlider.setValue(175);
		bmiSlider.setMaximum(250);
		panel_4.add(bmiSlider);
		
		JLabel bmiSliderLabel = new JLabel("1.70");
		panel_4.add(bmiSliderLabel);
		
		bmiHelpButton = new JButton("Help");
		panel.add(bmiHelpButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Category", null, panel_1, null);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Category:");
		panel_1.add(lblNewLabel_4);
		
		JLabel categoryResult = new JLabel("Normal");
		categoryResult.setFont(new Font("Tahoma", Font.PLAIN, 32));
		categoryResult.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(categoryResult);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JSlider categorySlider = new JSlider();
		categorySlider.setValue(25);
		categorySlider.setMaximum(50);
		panel_5.add(categorySlider);
		
		JLabel categorySliderLabel = new JLabel("25");
		panel_5.add(categorySliderLabel);
		
		categoryHelpButton = new JButton("Help");
		panel_1.add(categoryHelpButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Abdominal obesity", null, panel_2, null);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Obesity:");
		panel_2.add(lblNewLabel_6);
		
		obesityResult = new JLabel("No");
		obesityResult.setHorizontalAlignment(SwingConstants.CENTER);
		obesityResult.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_2.add(obesityResult);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Género:");
		panel_6.add(lblNewLabel_7);
		
		JRadioButton maleButton = new JRadioButton("M");
		panel_6.add(maleButton);
		
		JRadioButton femaleButton = new JRadioButton("F");
		panel_6.add(femaleButton);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JSlider abdominalSlider = new JSlider();
		abdominalSlider.setValue(100);
		abdominalSlider.setMaximum(150);
		abdominalSlider.setMinimum(50);
		panel_7.add(abdominalSlider);
		
		JLabel abdominalSliderLabel = new JLabel("70 cm");
		panel_7.add(abdominalSliderLabel);
		
		abdominalHelpButton = new JButton("Help");
		panel_2.add(abdominalHelpButton);
		
		pack();
		setVisible(true);
	}

	public void registrarControlador(Controlador controlador) {
		bmiHelpButton.addActionListener(controlador);
		bmiHelpButton.setActionCommand("bmiHelp");
		categoryHelpButton.addActionListener(controlador);
		categoryHelpButton.setActionCommand("categoryHelp");
		abdominalHelpButton.addActionListener(controlador);
		abdominalHelpButton.setActionCommand("abdominalHelp");
	}
	
	public void setResultado(int n) {
		obesityResult.setText("Yes");
	}

}
