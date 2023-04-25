package bmicalc;


public interface CardiovascularMetrics extends MetabolicMetrics {
	
	/**
	 * Calculate the Body Mass Index (BMI) of a person.
	 * BMI = mass (kg) / height^2 (m)
	 * 
	 * @param mass 	 Weight of the person.
	 * @param height Height of the person.
	 * @return 		 The Body Mass Index (BMI) value.
	 */
	public double calculateBodyMassIndex(double mass, double height);
	
	/**
	 * Categorize a person according to the BMI category:
	 *   - underweight for a bmi below 18.5
	 *   - normal for a bmi between 18.5 and 24.9
	 *   - overweight for a bmi between 25.0 and 29.9
	 *   - obese for a bmi above or equal 30.0
	 *   
	 * @param bmi Body Mass Index (BMI) value.
	 * @return	  String representing the BMI category.
	 */
	public String getObesityCategory(double bmi);
}
