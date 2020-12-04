import java.util.Random;

public class Tabuleiro{
    private Setor[][] setores = new Setor[5][5];
    public Setor[][] getSetores(){
        return this.setores;
    }

    public void init(Setor[][] setor){
        System.out.printf("\n\n\t -Inicializando matriz de setores");
        int x = getIntervalo(0,5); //Posição x da fonte de infecção
        int y = getIntervalo(0,5); //Posição y da fonte de infecção
        do{
            if(x==2)
                x = getIntervalo(0,5);
            if(y==2)
                y = getIntervalo(0,5);
        }while(x==2 || y==2);

        for(int aux1=0; aux1<5; aux1++){
            for(int aux2=0 ;aux2<5 ; aux2++){
                if(aux1==2 && aux2==2){
                    setor[aux1][aux2] = new SetorNormal('c'); //Posição C
                    System.out.printf("\nPosicao C criada");
                }
                if(aux1 == x && aux2 == y ) {
                    setor[aux1][aux2] = new SetorNormal(true); //Fonte de infecção
                    System.out.printf("\nFonte de infeccao criada");
                }
                int ab  = getIntervalo(1, 10);
                int cd  = getIntervalo(1, 10);
                int ef = getIntervalo(1, 10);
                if( ab + cd + ef < 10 ) {
                    setor[aux1][aux2] = new SetorPrivado();
                    System.out.printf("\nSetor privado criado");
                }
                if( ab + cd + ef < 20  && ab + cd + ef > 10 ) {
                    setor[aux1][aux2] = new SetorNormal();
                    System.out.printf("\nSetor normal criado");

                }
                if( ab + cd + ef < 30 && ab + cd + ef > 20 ) {
                    setor[aux1][aux2] = new SetorOculto();
                    System.out.printf("\nSetor oculto criado");
                }
            }
        }
        System.out.printf("\n\n\t-Matriz de setores criada com sucesso");
    }
    public void initSetor(int x,int y,int acao){ // acao representa qual movimento o jogador fará
        int numInimigos = getIntervalo(1, 5);
        getSetores()[x][y].init(numInimigos, x, y,getSetores(),acao);
    }
    

    public boolean portaEsquerdaAberta(int posicaoX,int posicaoY){
        if(getSetores()[posicaoX][posicaoY].getEsquerda()){
            return true;
        }else{
            return false;
        }
    }
    public boolean portaDireitaAberta(int posicaoX,int posicaoY){
        if(getSetores()[posicaoX][posicaoY].getDireita()){
            return true;
        }else{
            return false;
        }
    }
    public boolean portaBaixoAberta(int posicaoX,int posicaoY){
        if(getSetores()[posicaoX][posicaoY].getBaixo()){
            return true;
        }else{
            return false;
        }
    }
    public boolean portaCimaAberta(int posicaoX,int posicaoY){
        if(getSetores()[posicaoX][posicaoY].getCima()){
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