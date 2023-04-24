package bmicalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMCProxy implements IMCHospital, IMCStats {
    private IMCHospital calcHospital;
    private int numPacientes;
    private List<Double> alturas = new ArrayList<Double>();
    private List<Double> pesos = new ArrayList<Double>();
    private List<Double> imcs = new ArrayList<Double>();


    public IMCProxy(IMCHospital calc) {
        calcHospital = calc;
    }
    @Override
    public double alturaMedia() {
        double alturaMedia = 0;
        for (Double altura : alturas) {
            alturaMedia += altura;
        }
        alturaMedia /= alturas.size();
        return alturaMedia;
    }

    @Override
    public double pesoMedio() {
        double pesoMedio = 0;
        for (Double peso : pesos) {
            pesoMedio += peso;
        }
        pesoMedio /= pesos.size();
        return pesoMedio;
    }

    @Override
    public double imcMedio() {
        double imcMedio = 0;
        for (Double imc : imcs) {
            imcMedio += imc;
        }
        imcMedio /= imcs.size();
        return imcMedio;
    }

    @Override
    public int numPacientes() {
        return numPacientes;
    }

    @Override
    public Map<Double, String> imc(double altura, double peso) {
        Map<Double, String> res = calcHospital.imc(altura, peso);
        double imc = res.keySet().iterator().next(); 
        addParameters(altura, peso, imc);
        return res;
    }

    public void addParameters(double altura, double peso, double imc) {
        numPacientes++;
        alturas.add(altura);
        pesos.add(peso);
        imcs.add(imc);
    }

    @Override
    public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
        return calcHospital.tieneObesidadAbdominal(genero, circunferencia);
    }
}
