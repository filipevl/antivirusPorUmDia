import java.util.Random;

public class Tabuleiro{
    private Setor[][] setores = new Setor[5][5];
    public Setor[][] getSetores(){
        return this.setores;
    }

    public void initSetor(int x,int y,int acao){ // acao representa qual movimento o jogador fará
        int numInimigos = getIntervalo(1, 5);
        getSetores()[x][y].init(numInimigos, x, y,getSetores(),acao);
    }
    public void init(Setor[][] posicao){
        int x = getIntervalo(1,5); //Posição x da fonte de infecção
        int y = getIntervalo(1,5); //Posição y da fonte de infecção
        do{
            if(x==2)
                x = getIntervalo(1,5);
            if(y==2)
                y = getIntervalo(1,5);
        }while(x==2 || y==2);

        for(int aux1=0; aux1<=4; aux1++){
            for(int aux2=0 ;aux2<=4 ; aux2++){
                if(aux1==2 && aux2==2){
                    posicao[aux1][aux2] = new SetorNormal('c'); //Posição C
                }
                else if(aux1 == x && aux2 == y ) {
                    posicao[aux1][aux2] = new SetorNormal(true); //Fonte de infecção
                }
                else{
                    int ab  = getIntervalo(1, 10);
                    int cd  = getIntervalo(1, 10);
                    int ef = getIntervalo(1, 10);
                    if( ab + cd + ef < 10 ) {
                        posicao[aux1][aux2] = new SetorPrivado();
                    }
                    else if( ab + cd + ef < 20  && ab + cd + ef > 10 ) {
                        posicao[aux1][aux2] = new SetorNormal();
                    }
                    else if( ab + cd + ef < 30 && ab + cd + ef > 20 ) {
                        posicao[aux1][aux2] = new SetorOculto();
                    }
                    
                }
            }
        }
    }

    public boolean portaEsquerdaAberta(Setor[][] posicao,int posicaoX,int posicaoY){
        if(posicao[posicaoX][posicaoY].getEsquerda()){
            return true;
        }else{
            return false;
        }
    }
    public boolean portaDireitaAberta(Setor[][] posicao,int posicaoX,int posicaoY){
        if(posicao[posicaoX][posicaoY].getDireita()){
            return true;
        }else{
            return false;
        }
    }
    public boolean portaBaixoAberta(Setor[][] posicao,int posicaoX,int posicaoY){
        if(posicao[posicaoX][posicaoY].getBaixo()){
            return true;
        }else{
            return false;
        }
    }
    public boolean portaCimaAberta(Setor[][] posicao,int posicaoX,int posicaoY){
        if(posicao[posicaoX][posicaoY].getCima()){
            return true;
        }else{
            return false;
        }
    }

    
    public int getIntervalo(int x,int y){
        Random gerador = new Random();
        int num = gerador.nextInt(y+1);
        do{
            num = gerador.nextInt(y+1);
        }while(num<x);
        return num;
    }
}