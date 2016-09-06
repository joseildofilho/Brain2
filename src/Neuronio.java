import java.util.Random;

public class Neuronio {

    private double[] pesos;
    private FuncaoAtivacao funcaoAtivacao;
    private double bias;
    private double N;
    private int ciclesMax;

    public Neuronio(FuncaoAtivacao funcaoAtivacao, double bias, double n, int w,int m) {
        ciclesMax = m;
        pesos = new double[w];
        this.funcaoAtivacao = funcaoAtivacao;
        this.bias = bias;
        N = n;
        reiniciarPesos();
    }

    public Neuronio treinamento(double[][] conjuntoTreinamento, double[] rotulos) {

        int erro = conjuntoTreinamento.length;
        int cicles = ciclesMax;
        while((erro != 0) && (cicles != 0)) {
            for(int i = 0; i < conjuntoTreinamento.length; i++) {
                double[] w = conjuntoTreinamento[i];
                double f = funcaoAtivacao.executar(funcaoSoma(w));
                double diff = rotulos[i] - (f);
                if(diff < 0) {
                    ajustaPesos(w,diff);
                } else erro --;
            }
            if(erro != 0) {
                erro = conjuntoTreinamento.length;
            }
            cicles--;
        }
        System.out.println(ciclesMax-cicles);
        return this;
    }

    public double executar(double[] entrada) {
        double result = funcaoAtivacao.executar(funcaoSoma(entrada));
        System.out.println("Valor do teste:"+result);
        return result;
    }

    private void ajustaPesos(double[] conjuntoTreinamento, double erro) {
        for(int i = 0; i < conjuntoTreinamento.length; i++) {

            double calculo = N*conjuntoTreinamento[i]*erro;
            pesos[i] += calculo;
        }
    }

    private double funcaoSoma(double[] entradas) {
        double t = 0;
        for(int i = 0; i < entradas.length; i++) {
            t = t + (entradas[i]*pesos[i]) + bias;
        }
        return t;
    }

    public void reiniciarPesos() {
        Random r = new Random();
        for(int i = 0; i < pesos.length; i++) pesos[i] = r.nextDouble();
    }

}
