package bmicalc;

public class BMICalcImpl implements CardiovascularMetrics {

	public double bmi(double mass, double height) {
		if (mass <= 0 || height <= 0) throw new IllegalArgumentException("No puedes introducir valores nulos o negativos");
		else if (mass > height * 100) throw new ArithmeticException("Relación masa altura irreal");
		return mass / Math.pow(height, 2);
	}

	public String category(double bmi) {
		if (bmi <= 0) throw new IllegalArgumentException("BMI no puede ser nulo o negativo");
		String category = "";
		
		if (bmi < 18.5) category = "Underweight";
		else if (18.5 <= bmi && bmi < 25) category = "Normal";
		else if (25 <= bmi && bmi < 30) category = "Overweight";
		else if (bmi >= 30) category = "Obese";

		return category;
		
	}

	public boolean abdominalObesity(double waistCircumference, char gender) {
		if (waistCircumference <= 0) throw new IllegalArgumentException("No puedes introducir valores nulos o negativos");
		if (gender != 'M' && gender != 'F') throw new IllegalArgumentException("Género mal especificado, se esperaba 'M' o 'F'");

		boolean hasObesity = (gender == 'M' && waistCircumference > 90 || gender == 'F' && waistCircumference > 80);
		return hasObesity;
	}

}
