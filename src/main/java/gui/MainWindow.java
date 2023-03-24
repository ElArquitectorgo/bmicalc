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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JLabel bmiResult;
	private JButton minusFiveButton;
	private JButton minusOneButton;
	private JButton plusOneButton;
	private JButton plusFiveButton;
	private JLabel massLabel;
	private JSlider bmiSlider;
	private JButton bmiHelpButton;
	
	private JLabel categoryResult;
	private JSlider categorySlider;
	private JButton categoryHelpButton;
	
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private JSlider obesitySlider;
	private JButton obesityHelpButton;
	private JLabel obesityResult;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 272);
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
		
		bmiResult = new JLabel("22.86");
		bmiResult.setFont(new Font("Tahoma", Font.PLAIN, 32));
		bmiResult.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(bmiResult);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		minusFiveButton = new JButton("-5");
		panel_3.add(minusFiveButton);
		
		minusOneButton = new JButton("-1");
		panel_3.add(minusOneButton);
		
		massLabel = new JLabel("70 kg");
		panel_3.add(massLabel);
		
		plusOneButton = new JButton("+1");
		panel_3.add(plusOneButton);
		
		plusFiveButton = new JButton("+5");
		panel_3.add(plusFiveButton);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		bmiSlider = new JSlider();
		bmiSlider.setMaximum(250);
		bmiSlider.setValue(175);
		bmiSlider.setMinimum(100);
		panel_4.add(bmiSlider);
		
		JLabel bmiSliderLabel = new JLabel(String.valueOf((double) bmiSlider.getValue() / 100));
		panel_4.add(bmiSliderLabel);
		
		bmiSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bmiSliderLabel.setText(String.valueOf((double) bmiSlider.getValue() / 100));
			}
		});
		
		bmiHelpButton = new JButton("Help");
		panel.add(bmiHelpButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Category", null, panel_1, null);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Category:");
		panel_1.add(lblNewLabel_4);
		
		categoryResult = new JLabel("Overweight");
		categoryResult.setFont(new Font("Tahoma", Font.PLAIN, 32));
		categoryResult.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(categoryResult);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		categorySlider = new JSlider();
		categorySlider.setMinimum(10);
		categorySlider.setValue(25);
		categorySlider.setMaximum(40);
		panel_5.add(categorySlider);
		
		JLabel categorySliderLabel = new JLabel(String.valueOf(categorySlider.getValue()));
		panel_5.add(categorySliderLabel);
		
		categorySlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				categorySliderLabel.setText(String.valueOf(categorySlider.getValue()));
			}
		});
		
		categoryHelpButton = new JButton("Help");
		panel_1.add(categoryHelpButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Abdominal obesity", null, panel_2, null);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Obesity:");
		panel_2.add(lblNewLabel_6);
		
		obesityResult = new JLabel("Yes");
		obesityResult.setHorizontalAlignment(SwingConstants.CENTER);
		obesityResult.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_2.add(obesityResult);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Género:");
		panel_6.add(lblNewLabel_7);
		
		maleButton = new JRadioButton("M");
		maleButton.setSelected(true);
		panel_6.add(maleButton);
		
		femaleButton = new JRadioButton("F");
		panel_6.add(femaleButton);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		obesitySlider = new JSlider();
		obesitySlider.setValue(100);
		obesitySlider.setMaximum(150);
		obesitySlider.setMinimum(50);
		panel_7.add(obesitySlider);
		
		JLabel obesitySliderLabel = new JLabel(String.valueOf(obesitySlider.getValue()));
		panel_7.add(obesitySliderLabel);
		
		obesitySlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				obesitySliderLabel.setText(String.valueOf(obesitySlider.getValue()));
			}
		});
		
		obesityHelpButton = new JButton("Help");
		panel_2.add(obesityHelpButton);
		
		//pack();
		setVisible(true);
	}

	public void registrarControlador(Controlador controlador) {
		// BMI
		minusFiveButton.addActionListener(controlador);
		minusFiveButton.setActionCommand("minusFive");
		minusOneButton.addActionListener(controlador);
		minusOneButton.setActionCommand("minusOne");
		plusOneButton.addActionListener(controlador);
		plusOneButton.setActionCommand("plusOne");
		plusFiveButton.addActionListener(controlador);
		plusFiveButton.setActionCommand("plusFive");
		bmiSlider.setName("bmiSlider");
		bmiSlider.addMouseListener(controlador);
		bmiHelpButton.addActionListener(controlador);
		bmiHelpButton.setActionCommand("bmiHelp");
		
		// Category
		maleButton.addActionListener(controlador);
		maleButton.setActionCommand("male");
		femaleButton.addActionListener(controlador);
		femaleButton.setActionCommand("female");
		categorySlider.setName("categorySlider");
		categorySlider.addMouseListener(controlador);
		categoryHelpButton.addActionListener(controlador);
		categoryHelpButton.setActionCommand("categoryHelp");
		
		// Abdominal
		obesitySlider.addMouseListener(controlador);
		obesitySlider.setName("obesitySlider");
		obesityHelpButton.addActionListener(controlador);
		obesityHelpButton.setActionCommand("abdominalHelp");
	}
	
	public void updateMassLabel(int n) {
		try {
			int mass = Integer.parseInt(massLabel.getText().split(" ")[0]);
			if (mass + n < 0) throw new Exception("La masa no puede ser negativa");
			mass += n;
			massLabel.setText(String.valueOf(mass) + " kg");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setRadioButton(String button) {
		if (button == "male") {
			maleButton.setSelected(true);
			femaleButton.setSelected(false);
		} else if (button == "female") {
			maleButton.setSelected(false);
			femaleButton.setSelected(true);
		}
	}
	
	public int getMass() {
		return Integer.parseInt(massLabel.getText().split(" ")[0]);
	}
	
	public double getBMISlider() {
		return (double) bmiSlider.getValue() / 100;
	}
	
	public void setBMIResult(double result) {
		bmiResult.setText(String.format("%.2f", result));
	}
	
	public void updateCategoryResult(String result) {
		categoryResult.setText(result);
	}
	
	public int getCategoryBMI() {
		return categorySlider.getValue();
	}
	
	public void updateObesityResult(boolean result) {
		String str = result ? "Yes":"No";
		obesityResult.setText(str);
	}
	
	public char getRadioButton() {
		if (maleButton.isSelected()) return 'M';
		return 'F';
	}
	
	public int getObesitySlider() {
		return obesitySlider.getValue();
	}

}
