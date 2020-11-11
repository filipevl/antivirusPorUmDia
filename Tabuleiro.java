public class Tabuleiro{
    public Tabuleiro(){
    }
    private Setor[][] posicao = new Setor[4][4];
    public void inicializa(Setor[][] posicao){
        for(short x=0;x<5;x++){
            for(short y=0;y<5;y++){
                if(x==3&&y==3){
                    posicao[x][y] = new Setor(true,true,true,true,false); //Posição C
                }
                posicao[x][y] = new Setor();
            }
        }
    }

    public Setor[][] getPosicao(){
        return posicao;
    }
}