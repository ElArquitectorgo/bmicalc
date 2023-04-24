package bmicalc;

import java.util.Map;

public class UsaDecorator implements IMCHospital {
    private IMCProxy proxy;

    public UsaDecorator(IMCProxy p) {
        proxy = p;
    }

    @Override
    public Map<Double, String> imc(double altura, double peso) {
        Map<Double, String> res = proxy.imc(convertFootToMeters(altura), convertPoundToKg(peso));
        double imc = res.keySet().iterator().next();
        System.out.println(String.format("The person with height %.2f meters and %.2f kilos of weight has an IMC of %.2f.", altura, peso, imc));
        return res;
    }

    @Override
    public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
        // La conversión es a metros pero nuestro método obesidad usa cm, por eso dividimos.
        circunferencia = convertFootToMeters(circunferencia) / 100;
        return proxy.tieneObesidadAbdominal(genero, circunferencia);
    }

    private double convertFootToMeters(double altura) {
        return altura /= 3.28;
    }
    private double convertPoundToKg(double peso) {
        return peso /= 2.2;
    }
    
}
