package bmicalc;

public class BMICalcImpl implements CardiovascularMetrics {

	public double calculateBodyMassIndex(double mass, double height) {
		if (mass <= 0 || height <= 0) throw new IllegalArgumentException("No puedes introducir valores nulos o negativos");
		else if (mass > height * 100) throw new ArithmeticException("Relación masa altura irreal");
		return mass / Math.pow(height, 2);
	}

	public ObesityCategory getObesityCategory(double bmi) {
		if (bmi <= 0) throw new IllegalArgumentException("BMI no puede ser nulo o negativo");
		ObesityCategory category;
		
		if (bmi < 18.5) category = ObesityCategory.UNDERWEIGHT;
		else if (18.5 <= bmi && bmi < 25) category = ObesityCategory.NORMAL;
		else if (25 <= bmi && bmi < 30) category = ObesityCategory.OVERWEIGHT;
		else category = ObesityCategory.OBESE;

		return category;
		
	}

	public boolean abdominalObesity(double waistCircumference, Gender gender) {
		if (waistCircumference <= 0) throw new IllegalArgumentException("No puedes introducir valores nulos o negativos");

		boolean hasObesity = (gender == Gender.MALE && waistCircumference > 90 || gender == Gender.FEMALE && waistCircumference > 80);
		return hasObesity;
	}

}
