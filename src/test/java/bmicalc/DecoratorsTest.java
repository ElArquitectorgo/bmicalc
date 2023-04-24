package bmicalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;

public class DecoratorsTest {
    IMCProxy proxy;
    private EurDecorator eurDec;
    private UsaDecorator usaDec;

    @BeforeEach
    public void setUp() {
        proxy = new IMCProxy(new IMCAdapter(BMICalcImpl.getInstance()));
        eurDec = new EurDecorator(proxy);
        usaDec = new UsaDecorator(proxy);
    }

    @Test
    public void imcUsaTest() {
        double altura = 1.50 * 3.28;
        double peso = 50 * 2.2;
        double expected = (peso / 2.2) / Math.pow((altura / 3.28), 2);
        Map<Double, String> res = usaDec.imc(altura, peso);
        double imc = res.keySet().iterator().next(); 
        assertEquals(expected, imc);
    }

    @Test
    public void imcEurTest() {
        double altura = 1.50;
        double peso = 50;
        double expected = (peso) / Math.pow((altura), 2);
        Map<Double, String> res = eurDec.imc(altura, peso);
        double imc = res.keySet().iterator().next(); 
        assertEquals(expected, imc);
    }

    @Test
    public void pesosMediostest() {
        double[] alturas = {1.5, 1.6, 1.7, 1.8};
        double[] pesos = {50, 60, 70, 80};
        for (int i = 0; i < pesos.length; i++) {
            eurDec.imc(alturas[i], pesos[i]);
        }

        double imcMedio = 0;
        for (int i = 0; i < pesos.length; i++) {
            imcMedio += pesos[i] / Math.pow(alturas[i], 2);
        }
        imcMedio /= pesos.length;
        assertEquals((int) (imcMedio * 1000), (int) (proxy.imcMedio() * 1000));
    }

    @Test
    public void numPacientesTest() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            eurDec.imc(1.5, 50);
            usaDec.imc(1.5 * 3.28, 2.2);
        }
        assertEquals(n * 2, proxy.numPacientes());
    }

    @Test
    public void conversionTest() {
        double[] alturas = {1.5, 1.6, 1.7, 1.8};
        double[] pesos = {50, 60, 70, 80};
        for (int i = 0; i < pesos.length; i++) {
            usaDec.imc(alturas[i] * 3.28, pesos[i] * 2.2);
        }
        for (int i = 0; i < pesos.length; i++) {
            eurDec.imc(alturas[i], pesos[i]);
        }
        double imcMedio = 0;
        for (int i = 0; i < pesos.length; i++) {
            imcMedio += pesos[i] / Math.pow(alturas[i], 2);
        }
        imcMedio /= pesos.length;

        assertEquals(imcMedio, proxy.imcMedio());
    }
}
