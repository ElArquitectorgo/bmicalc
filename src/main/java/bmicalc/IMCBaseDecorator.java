package bmicalc;

import java.util.Map;

public abstract class IMCBaseDecorator implements IMCHospital{
    protected IMCProxy proxy;

    public IMCBaseDecorator(IMCProxy p) {
        proxy = p;
    }

    public abstract Map<Double, String> imc(double altura, double peso);
    public abstract boolean tieneObesidadAbdominal(char genero, double circunferencia);
    
}
