package bmicalc;

public class UsaVersion implements CalcVersion {

    @Override
    public Double convertAltura(double altura) {
        return altura / 3.28;
    }

    @Override
    public Double convertPeso(double peso) {
        return peso / 2.2;
    }

    @Override
    public String printResult(double altura, double peso, double imc) {
        // No se especifica si este mensaje debe dar la altura y el peso en sistema imperial
        return String.format("The person with height %.2f meters and %.2f kilos of weight has an IMC of %.2f.", altura, peso, imc);
    }
    
}
