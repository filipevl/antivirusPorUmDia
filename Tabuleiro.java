import java.util.Random;

public class Tabuleiro{
    public Tabuleiro(){
    }
    private Setor[][] posicao = new Setor[5][5];
    public void init(Setor[][] posicao){
        Random gerador = new Random();
        int x,y,numInimigos;
        x = gerador.nextInt(6);
        y = gerador.nextInt(6);
        numInimigos = gerador.nextInt(6);
        do{
            if(x==3)
                x = gerador.nextInt(6);
            if(y==3)
                y = gerador.nextInt(6);
            if(numInimigos==0){
                numInimigos = gerador.nextInt(6);
            }
        }while(x==3 || y==3 || numInimigos==0);

        for(int aux1=0; aux1<5; aux1++){
            for(int aux2=0 ;aux2<5 ; aux2++){
                if(aux1==3 && aux2==3){
                    posicao[aux1][aux2] = new Setor(true,true,true,true,false); //Posição C
                }else if(aux1==x&&aux2==y){
                    posicao[aux1][aux2] = new Setor(true); //Fonte de infecção
                }else{
                    posicao[aux1][aux2] = new Setor();
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

    public Setor[][] getPosicao(){
        return posicao;
    }

}