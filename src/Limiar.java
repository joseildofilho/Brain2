import java.util.Map;
import java.util.Vector;

/**
 * Created by root on 01/09/16.
 */
public class Limiar implements FuncaoAtivacao {

    @Override
    public double executar(double valor) {
        if(Math.round(valor) > 0) {
            return 1;
        }
        return 0;
    }

}
