package bmicalc;

import java.util.Map;

public interface IMCHospital {
	
	/**
	 * Calculate the Body Mass Index (BMI) of a person.
	 * BMI = mass (kg) / height^2 (m)
	 * 
     * @param altura Height of the person.
	 * @param peso 	 Weight of the person.
     *
	 * @return 		 The Body Mass Index (BMI) value.
	 */
	public Map<Double, String> imc(double altura, double peso);
	
	/**
	 * Determine whether a person has abdominal obesity.
	 * A woman has abdominal obesity if her waist circumference is greater than 80 cm.
	 * A man has abdominal obesity if his waist circumference is greater than 90 cm.
	 *
	 * @param genero				Male ('M') or Female ('F').
	 * @param circunferencia	Waist circumference.
	 * 
	 * @return						True if the person has abdominal obesity, false otherwise.
	 */
	public boolean tieneObesidadAbdominal(char genero, double circunferencia);
}
