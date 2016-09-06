public class Main {
    public static void main(String[] args) {
        Neuronio neuronio = new Neuronio(new Limiar(),0,0.1,2,10000);
        double[][] treinamentoOR = {
                {1,1},{0,1},{0,0}
        };
        double[] rotulosOR = {1,1,0};
        double[] testeEntradaOR = {1,0};
        neuronio.treinamento(treinamentoOR,rotulosOR);
        neuronio.executar(testeEntradaOR);
        neuronio.executar(new double[] {0.0,0.0});
        neuronio.executar(new double[] {0.0,1.0});
        neuronio.executar(new double[] {1.0,1.0});
        Neuronio neuronio1 = new Neuronio(new Limiar(),0,0.1,2,Integer.MAX_VALUE-100);
        double[][] treinamentoAND = {
                {1,0},{0,1},{1,1},{0,0}
        };
        double[] rotulosAND = {0,0,1,0};
        double[] testeEntradaAND = {0,0};
        neuronio1.treinamento(treinamentoAND,rotulosAND);
        neuronio1.executar(testeEntradaAND);
        neuronio1.executar(new double[] {1.0,0.0});
        neuronio1.executar(new double[] {0.0,1.0});
        neuronio1.executar(new double[] {1.0,1.0});
        Perceptron perceptron = new Perceptron();
    }
}
