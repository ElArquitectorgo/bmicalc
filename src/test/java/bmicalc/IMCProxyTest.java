package bmicalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;

public class IMCProxyTest {
    private IMCProxy proxy;
    
    @BeforeEach
    public void setUp() {
        proxy = new IMCProxy(new IMCAdapter(BMICalcImpl.getInstance()));
    }
    @Test
    public void imcProxyTest() {
        double altura = 1.5;
        double peso = 50;
        double expected = peso / Math.pow(altura, 2);
        Map<Double, String> res = proxy.imc(altura, peso);
        double imc = res.keySet().iterator().next();
        assertEquals(expected, imc);
    }
    @Test
    public void obesityAdapterTest() {
        boolean res = proxy.tieneObesidadAbdominal('F', 50);
        assertFalse(res);
    }
    @Test
    public void alturaMediaTest() {
        double[] alturas = {1.5, 1.6, 1.7, 1.8};
        for (double a : alturas) {
            proxy.imc(a, 50);
        }
        assertEquals(1.65, proxy.alturaMedia());
    }
    @Test
    public void pesoMedioTest() {
        double[] pesos = {50, 60, 70, 80};
        for (double p : pesos) {
            proxy.imc(1.5, p);
        }
        assertEquals(65, proxy.pesoMedio());
    }
    @Test
    public void imcMedioTest() {
        double[] alturas = {1.5, 1.6, 1.7, 1.8};
        double[] pesos = {50, 60, 70, 80};
        for (int i = 0; i < pesos.length; i++) {
            proxy.imc(alturas[i], pesos[i]);
        }
        double imcMedio = 0;
        for (int i = 0; i < pesos.length; i++) {
            imcMedio += pesos[i] / Math.pow(alturas[i], 2);
        }
        imcMedio /= pesos.length;

        assertEquals(imcMedio, proxy.imcMedio());
    }

    @Test
    public void numPacientesTest() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            proxy.imc(1.5, 50);
        }
        assertEquals(n, proxy.numPacientes());
    }
}
