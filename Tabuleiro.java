import java.util.Random;

public class Tabuleiro{
    public Tabuleiro(){
    }
    private Setor[][] posicao = new Setor[4][4];
    public void inicializa(Setor[][] posicao){
        Random gerador = new Random();
        int fonteInfeccao[] = new int[1];
        fonteInfeccao[0] = gerador.nextInt(4);
        fonteInfeccao[1] = gerador.nextInt(4);
        for(int x=0;x<5;x++){
            for(int y=0;y<5;y++){
                if(x==3&&y==3){
                    posicao[x][y] = new Setor(true,true,true,true,false); //Posição C
                }else if(x==fonteInfeccao[0]&&y==fonteInfeccao[1]){
                    posicao[x][y] = new Setor(true); //Fonte de infecção
                }else{
                    posicao[x][y] = new Setor();
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