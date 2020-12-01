public class SetorPrivado extends Setor{
    public SetorPrivado(){
        super();
    }
    public SetorPrivado(boolean esquerda,boolean cima,boolean direita,boolean baixo,boolean fonteDeInfeccao){
        super(esquerda, cima, direita, baixo, fonteDeInfeccao);
    }
    public SetorPrivado(boolean fonte){
        super(fonte);
    }
    // c. Setor privado: A restrição é que os jogadores não podem executar a ação de procurar no setor.

}