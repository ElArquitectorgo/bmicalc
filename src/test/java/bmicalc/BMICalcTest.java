package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BMICalcTest {
	/*   - underweight for a bmi below 18.5
	 *   - normal for a bmi between 18.5 and 24.9
	 *   - overweight for a bmi between 25.0 and 29.9
	 *   - obese for a bmi above or equal 30.0
	 * */
 
	@Test
	void underweightCategoryTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double[] nums = {15, 18.49};
		for (int i = 0; i < nums.length; i++) {		
			ObesityCategory category = calc.getObesityCategory(nums[i]);
			assertEquals(ObesityCategory.UNDERWEIGHT, category);
		}
	}

	@Test
	void underweightNegativeCategoryTest() {
		BMICalcImpl calc = new BMICalcImpl();
		assertThrows(IllegalArgumentException.class, ()->calc.getObesityCategory(-5));
	}

	@Test
	void normalCategoryTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double[] nums = {18.5, 20, 24.9, 24.98};
		for (int i = 0; i < nums.length; i++) {		
			ObesityCategory category = calc.getObesityCategory(nums[i]);
			assertEquals(ObesityCategory.NORMAL, category);
		}
	}

	@Test
	void overweightCategoryTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double[] nums = {25.0, 27.7, 29.9, 29.95};
		for (int i = 0; i < nums.length; i++) {		
			ObesityCategory category = calc.getObesityCategory(nums[i]);
			assertEquals(ObesityCategory.OVERWEIGHT, category);
		}
	}

	@Test
	void obeseCategoryTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double[] nums = {30, 40, 50};
		for (int i = 0; i < nums.length; i++) {		
			ObesityCategory category = calc.getObesityCategory(nums[i]);
			assertEquals(ObesityCategory.OBESE, category);
		}
	}

	@Test
	void positiveMaleAbdominalObesityTest() {
		BMICalcImpl calc = new BMICalcImpl();
		boolean obesity = calc.abdominalObesity(95, Gender.MALE);
		assertTrue(obesity);
	}

	@Test
	void negativeMaleAbdominalObesityTest() {
		BMICalcImpl calc = new BMICalcImpl();
		boolean obesity = calc.abdominalObesity(80, Gender.MALE);
		assertFalse(obesity);
		obesity = calc.abdominalObesity(90, Gender.MALE);
		assertFalse(obesity);
	}

	@Test
	void positiveFemaleAbdominalObesityTest() {
		BMICalcImpl calc = new BMICalcImpl();
		boolean obesity = calc.abdominalObesity(85, Gender.FEMALE);
		assertTrue(obesity);
	}

	@Test
	void negativeFemaleAbdominalObesityTest() {
		BMICalcImpl calc = new BMICalcImpl();
		boolean obesity = calc.abdominalObesity(70, Gender.FEMALE);
		assertFalse(obesity);
		obesity = calc.abdominalObesity(80, Gender.FEMALE);
		assertFalse(obesity);
	}

	@Test
	void zeroAbdominalTest() {
		BMICalcImpl calc = new BMICalcImpl();
		assertThrows(IllegalArgumentException.class, ()->calc.abdominalObesity(0, Gender.MALE));
	}

	@Test
	void negativeInputAbdominalTest() {
		BMICalcImpl calc = new BMICalcImpl();
		assertThrows(IllegalArgumentException.class, ()->calc.abdominalObesity(-10, Gender.MALE));
		assertThrows(IllegalArgumentException.class, ()->calc.abdominalObesity(-1200, Gender.FEMALE));
	}

	@Test
	void bmiTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double mass = 50;
		double height = 1.50;
		double bmi = calc.calculateBodyMassIndex(mass, height);
		double expected = mass / Math.pow(height, 2);
		assertEquals(expected, bmi);
	}

	@Test
	void bmiNegativeMassTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double mass = -50;
		double height = 1.50;
		assertThrows(IllegalArgumentException.class, ()->calc.calculateBodyMassIndex(mass, height));
	}

	@Test
	void bmiNegativeHeightTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double mass = 50;
		double height = -1.50;
		assertThrows(IllegalArgumentException.class, ()->calc.calculateBodyMassIndex(mass, height));
	}

	@Test
	void bmiHeightEqualsToZeroTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double mass = 50;
		double height = 0;
		assertThrows(IllegalArgumentException.class, ()->calc.calculateBodyMassIndex(mass, height));
	}

	@Test
	void bmiIrrealest() {
		BMICalcImpl calc = new BMICalcImpl();
		double mass = 180;
		double height = 1.50;
		assertThrows(ArithmeticException.class, ()->calc.calculateBodyMassIndex(mass, height));
	}
	
}
