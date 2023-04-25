package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BMICalcTest {
	
	@Test
	@DisplayName("Example Test Method.")
	public void bmi() {
		assertEquals(true, true);
	}

	/*   - underweight for a bmi below 18.5
	 *   - normal for a bmi between 18.5 and 24.9
	 *   - overweight for a bmi between 25.0 and 29.9
	 *   - obese for a bmi above or equal 30.0
	 * */
 
	@Test
	public void underweightCategoryTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double[] nums = {15, 18.49};
		for (int i = 0; i < nums.length; i++) {		
			ObesityCategory category = calc.getObesityCategory(nums[i]);
			assertEquals(category, ObesityCategory.UNDERWEIGHT);
		}
	}

	@Test
	public void underweightNegativeCategoryTest() {
		BMICalcImpl calc = new BMICalcImpl();
		assertThrows(IllegalArgumentException.class, ()->calc.getObesityCategory(-5));
	}

	@Test
	public void normalCategoryTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double[] nums = {18.5, 20, 24.9, 24.98};
		for (int i = 0; i < nums.length; i++) {		
			ObesityCategory category = calc.getObesityCategory(nums[i]);
			assertEquals(category, ObesityCategory.NORMAL);
		}
	}

	@Test
	public void overweightCategoryTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double[] nums = {25.0, 27.7, 29.9, 29.95};
		for (int i = 0; i < nums.length; i++) {		
			ObesityCategory category = calc.getObesityCategory(nums[i]);
			assertEquals(category, ObesityCategory.OVERWEIGHT);
		}
	}

	@Test
	public void obeseCategoryTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double[] nums = {30, 40, 50};
		for (int i = 0; i < nums.length; i++) {		
			ObesityCategory category = calc.getObesityCategory(nums[i]);
			assertEquals(category, ObesityCategory.OBESE);
		}
	}

	@Test
	public void positiveMaleAbdominalObesityTest() {
		BMICalcImpl calc = new BMICalcImpl();
		boolean obesity = calc.abdominalObesity(95, Gender.MALE);
		assertTrue(obesity);
	}

	@Test
	public void negativeMaleAbdominalObesityTest() {
		BMICalcImpl calc = new BMICalcImpl();
		boolean obesity = calc.abdominalObesity(80, Gender.MALE);
		assertFalse(obesity);
		obesity = calc.abdominalObesity(90, Gender.MALE);
		assertFalse(obesity);
	}

	@Test
	public void positiveFemaleAbdominalObesityTest() {
		BMICalcImpl calc = new BMICalcImpl();
		boolean obesity = calc.abdominalObesity(85, Gender.FEMALE);
		assertTrue(obesity);
	}

	@Test
	public void negativeFemaleAbdominalObesityTest() {
		BMICalcImpl calc = new BMICalcImpl();
		boolean obesity = calc.abdominalObesity(70, Gender.FEMALE);
		assertFalse(obesity);
		obesity = calc.abdominalObesity(80, Gender.FEMALE);
		assertFalse(obesity);
	}

	@Test
	public void zeroAbdominalTest() {
		BMICalcImpl calc = new BMICalcImpl();
		assertThrows(IllegalArgumentException.class, ()->calc.abdominalObesity(0, Gender.MALE));
	}

	@Test
	public void negativeInputAbdominalTest() {
		BMICalcImpl calc = new BMICalcImpl();
		assertThrows(IllegalArgumentException.class, ()->calc.abdominalObesity(-10, Gender.MALE));
		assertThrows(IllegalArgumentException.class, ()->calc.abdominalObesity(-1200, Gender.FEMALE));
	}

	@Test
	public void bmiTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double mass = 50;
		double height = 1.50;
		double bmi = calc.calculateBodyMassIndex(mass, height);
		double expected = mass / Math.pow(height, 2);
		assertEquals(bmi, expected);
	}

	@Test
	public void bmiNegativeMassTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double mass = -50;
		double height = 1.50;
		assertThrows(IllegalArgumentException.class, ()->calc.calculateBodyMassIndex(mass, height));
	}

	@Test
	public void bmiNegativeHeightTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double mass = 50;
		double height = -1.50;
		assertThrows(IllegalArgumentException.class, ()->calc.calculateBodyMassIndex(mass, height));
	}

	@Test
	public void bmiHeightEqualsToZeroTest() {
		BMICalcImpl calc = new BMICalcImpl();
		double mass = 50;
		double height = 0;
		assertThrows(IllegalArgumentException.class, ()->calc.calculateBodyMassIndex(mass, height));
	}

	@Test
	public void bmiIrrealest() {
		BMICalcImpl calc = new BMICalcImpl();
		double mass = 180;
		double height = 1.50;
		assertThrows(ArithmeticException.class, ()->calc.calculateBodyMassIndex(mass, height));
	}
	
}
