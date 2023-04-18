package bmicalc;

import java.util.HashMap;
import java.util.Map;

public class IMCAdapter implements IMCHospital {
    private BMICalc calc;

    public IMCAdapter(BMICalc bmiCalc) {
        calc = bmiCalc;
    }

    @Override
    public Map<Double, String> imc(double altura, double peso) {
        double bmi = calc.bmi(peso, altura);
        String category = calc.category(bmi);

        Map<Double, String> res = new HashMap<>();
        res.put(bmi, category);

        return res;
    }

    @Override
    public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
        return calc.abdominalObesity(circunferencia, genero);
    }

}