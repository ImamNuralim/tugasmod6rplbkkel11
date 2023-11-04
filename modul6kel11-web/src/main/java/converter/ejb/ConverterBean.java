package converter.ejb;

import java.text.DecimalFormat;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

@Stateless
@LocalBean
public class ConverterBean implements ConverterBeanLocal {
    
    private DecimalFormat twoDigits = new DecimalFormat("0.00");
    
    public String ctof(double c) {
        String result = twoDigits.format(((c * 9.0 / 5.0 + 32) * 100) / 100.0);
        return result;
    }
    
    public String ftoc(double f) {
        String result = twoDigits.format(((f - 32) * 5.0 / 9.0 * 100) / 100.0);
        return result;
    }
    
    public String ctor(double c) {
        String result = twoDigits.format((c * 4.0 / 5.0));
        return result;
    }
}
