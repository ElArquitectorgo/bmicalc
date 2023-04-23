package bmicalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrategyTest {
    @Test
    public void eurVersionPrintTest() {
        CalcVersion eurCalc = new EurVersion();
        double altura = 1.50;
        double peso = 50;
        double imc = 22.22;
        String expected = String.format("La persona con altura %.2f metros y %.2f kilos de peso tiene un IMC de %.2f.", altura, peso, imc);
        assertEquals(expected, eurCalc.printResult(altura, peso, imc));
    }
    @Test
    public void usaVersionPrintTest() {
        CalcVersion usaCalc = new UsaVersion();
        double altura = 1.50;
        double peso = 50;
        double imc = 22.22;
        String expected = String.format("The person with height %.2f meters and %.2f kilos of weight has an IMC of %.2f.", altura, peso, imc);
        assertEquals(expected, usaCalc.printResult(altura, peso, imc));
    }
    @Test
    public void heightConverterTest() {
        CalcVersion usaCalc = new UsaVersion();
        double altura = 90;
        double expected = altura / 3.28;
        assertEquals(expected, usaCalc.convertAltura(altura));
    }
    @Test
    public void weightConverterTest() {
        CalcVersion usaCalc = new UsaVersion();
        double peso = 90;
        double expected = peso / 2.2;
        assertEquals(expected, usaCalc.convertPeso(peso));
    }
}
