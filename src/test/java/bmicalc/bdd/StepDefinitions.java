package bmicalc.bdd;

import org.junit.jupiter.api.Assertions;

import bmicalc.BMICalcImpl;
import bmicalc.CardiovascularMetrics;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private CardiovascularMetrics bmiCalc;
	private Double result ;
	
	@Before
	public void initialization() {
		bmiCalc = null;
	    result = null;
	}
	
	@Given("I have an IMC calculator")
	public void i_have_a_imc_calculator() {
		bmiCalc = new BMICalcImpl();
	}
	
	@When("I compute the IMC of {double} and {double}")
	public void i_compute_the_imc_of(Double d1, Double d2) {
	    result = bmiCalc.bmi(d1, d2);
	}

	@Then("The system returns {double}")
	public void the_system_returns(Double d) {
	    Assertions.assertEquals(d*100, Math.round(result*100));
	}
}