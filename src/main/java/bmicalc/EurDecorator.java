package bmicalc;

import java.util.Map;

public class EurDecorator implements IMCHospital {
    private IMCProxy proxy;

    public EurDecorator(IMCProxy p) {
        proxy = p;
    }

    @Override
    public Map<Double, String> imc(double altura, double peso) {
        Map<Double, String> res = proxy.imc(altura, peso);
        double imc = res.keySet().iterator().next();
        proxy.addParameters(altura, peso, imc);
        System.out.println(String.format("La persona con altura %.2f metros y %.2f kilos de peso tiene un IMC de %.2f.", altura, peso, imc));
        return res;
    }

    @Override
    public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
        return proxy.tieneObesidadAbdominal(genero, circunferencia);
    }
}
