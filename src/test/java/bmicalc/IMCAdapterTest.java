package bmicalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Map;

public class IMCAdapterTest {
    @Test
    public void imcAdapterTest() {
        IMCAdapter calc = new IMCAdapter(BMICalcImpl.getInstance());
        double altura = 1.5;
        double peso = 50;
        double expected = peso / Math.pow(altura, 2);
        Map<Double, String> res = calc.imc(altura, peso);
        double imc = res.keySet().iterator().next();
        assertEquals(expected, imc);
    }
    @Test
    public void obesityAdapterTest() {
        IMCAdapter calc = new IMCAdapter(BMICalcImpl.getInstance());
        boolean res = calc.tieneObesidadAbdominal('F', 50);
        assertFalse(res);
    }
}
