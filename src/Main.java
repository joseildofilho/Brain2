import java.util.Collections;
import java.util.Vector;

/**
 * Created by root on 01/09/16.
 */
public class Main {
    public static void main(String[] args) {
        Neuronio neuronio = new Neuronio(new Limiar(),0,0.1);
        Vector<Vector<Double>> treinamento = new Vector<>();
        Vector<Double> entrada1 = new Vector<>(), entrada2 = new Vector<>(), entrada3 =  new Vector<>(), teste = new Vector<>();
        entrada1.add(1.0);
        entrada1.add(1.0);
        entrada1.add(1.0);

        entrada2.add(1.0);
        entrada2.add(1.0);
        entrada2.add(0.0);

        entrada3.add(0.0);
        entrada3.add(0.0);
        entrada3.add(0.0);

        treinamento.add(entrada1);
        treinamento.add(entrada2);
        treinamento.add(entrada3);

        neuronio.treinamento(treinamento);

        teste.add(0.0);
        teste.add(0.0);
        teste.add(1.0);

        System.out.println(neuronio.executar(teste));
        System.out.println(neuronio.executar(entrada3));


    }
}
