package bmicalc.bdd;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private Factorial factCalc;
	private Integer result ;
	private boolean raiseException;
	
	@Before
	public void initialization() {
		factCalc = null;
	    result = null;
	    raiseException = false;
	}
	
	@Given("I have a factorial calculator")
	public void i_have_a_factorial_calculator() {
		factCalc = new Factorial();
	}
	
	@When("I compute the factorial of {int}")
	public void i_compute_the_factorial_of(Integer int1) {
	    result = factCalc.compute(int1);
	}
	
	@Then("The system returns {int}")
	public void the_system_returns(Integer int1) {
	    Assertions.assertEquals(int1, result);
	}
	
	@When("I compute the factorial of a negative number {int}")
	public void i_compute_the_factorial_of_a_negative_number(Integer int1) {
		try {
			result = factCalc.compute(int1);
		} catch (NegativeValueException e) {
			raiseException = true;
		}
	}
	
	@Then("The system raises an exception")
	public void the_system_raises_an_exception() {
	    Assertions.assertTrue(raiseException);
	}
}