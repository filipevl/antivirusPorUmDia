public class SetorOculto extends Setor{
    public SetorOculto(){
        super();
    }
    public SetorOculto(boolean esquerda,boolean cima,boolean direita,boolean baixo,boolean fonteDeInfeccao){
        super(esquerda, cima, direita, baixo, fonteDeInfeccao);
    }
    public SetorOculto(boolean fonte){
        super(fonte);
    }
    // b. Setor oculto: A restrição neste setor é que quando o jogador efetuar um ataque, o vírus pode ou não ser eliminado (aleatório), pois o jogador não sabe a localização exata do vírus no setor.

}