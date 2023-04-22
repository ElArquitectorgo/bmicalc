package bmicalc;

public class EurVersion implements CalcVersion {

    @Override
    public Double convertAltura(double altura) {
        return altura;
    }

    @Override
    public Double convertPeso(double peso) {
        return peso;
    }

    @Override
    public String printResult(double altura, double peso, double imc) {
        return String.format("La persona con altura %.2f metros y %.2f kilos de peso tiene un IMC de %.2f.", altura, peso, imc);
    }
    
}
