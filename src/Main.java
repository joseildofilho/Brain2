public class Main {
    public static void main(String[] args) {
        Neuronio neuronio = new Neuronio(new Limiar(),0,1,2,1);
        double[][] treinamentoOR = {
                {1,1},{0,1},{0,0}
        };
        double[] rotulosOR = {1,1,0};
        double[] testeEntradaOR = {1,0};
        neuronio.treinamento(treinamentoOR,rotulosOR);
        neuronio.executar(testeEntradaOR);
        double[][] treinamentoAND = {
                {1,1},{0,1},{1,0},{0,0}
        };
        double[] rotulosAND = {1,0,0,0};
        double[] testeEntradaAND = {1,0};
        neuronio.treinamento(treinamentoAND,rotulosAND);
        neuronio.executar(testeEntradaAND);
    }
}
