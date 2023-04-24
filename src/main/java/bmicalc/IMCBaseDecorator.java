package bmicalc;

import java.util.Map;

public abstract class IMCBaseDecorator{
    protected IMCProxy proxy;

    public IMCBaseDecorator(IMCProxy p) {
        proxy = p;
    }

    abstract Map<Double, String> imc(double altura, double peso);
    abstract boolean tieneObesidadAbdominal(char genero, double circunferencia);
    
}
