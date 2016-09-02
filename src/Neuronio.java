import java.util.Random;
import java.util.Vector;

/**
 * Created by root on 01/09/16.
 */
public class Neuronio {

    private Vector<Double> pesos;
    private FuncaoAtivacao funcaoAtivacao;
    private double bias;
    private double N;
    private boolean treinado = false;

    public Neuronio(FuncaoAtivacao funcaoAtivacao, double bias, double n) {
        pesos = new Vector<>();
        this.funcaoAtivacao = funcaoAtivacao;
        this.bias = bias;
        N = n;
    }

    public Neuronio treinamento(Vector<Vector<Double>> conjuentoTreinamento) {
        conjuentoTreinamento.forEach(a->{
            treinar(a,a.remove(0));
        });
        treinado = true;
        return this;
    }

    public void treinar(Vector<Double> conjuntoTreinamento,double rotulo) {
        if(pesos.size() == 0) conjuntoTreinamento.forEach(a -> pesos.add(new Random().nextDouble()));
        double erro;
        double result = funcaoAtivacao.executar(funcaoSoma(conjuntoTreinamento));
        System.out.println(result+" "+pesos.get(0)+" "+pesos.get(1));
        erro = rotulo - result;
        System.out.println("valor do erro:"+erro);
        if (erro > 0) ajustaPesos(conjuntoTreinamento, erro);

    }

    public double executar(Vector<Double> entrada) {
        entrada.remove(0);
        return funcaoAtivacao.executar(funcaoSoma(entrada));
    }

    private void ajustaPesos(Vector<Double> conjuntoTreinamento, double erro) {
        for(int i = 0; i < conjuntoTreinamento.size(); i++) {
            double calculo = pesos.get(i) + (N*conjuntoTreinamento.get(i)*erro);
            pesos.set(i,calculo);
        }
    }

    private double funcaoSoma(Vector<Double> entradas) {
        double t = 0;
        for(int i = 0; i < entradas.size(); i++) {
            t = t + (entradas.get(i)*pesos.get(i)) + bias;
        }
        return t;
    }

}
