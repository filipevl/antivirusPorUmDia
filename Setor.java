import java.util.Random;

public class Setor{
    public Setor(boolean esquerda,boolean cima,boolean direita,boolean baixo, boolean fonteDeInfeccao){
        this.esquerda=esquerda;
        this.cima=cima;
        this.direita=direita;
        this.baixo=baixo;
        this.fonteDeInfeccao=fonteDeInfeccao;
    } // Construtor do setor C
    public Setor(){
        this.fonteDeInfeccao=false;
    } // Construtor dos setores padrões
    public Setor(boolean fonte){
        this.fonteDeInfeccao=true;
    } // Construtor setor infeccao

    private boolean esquerda, cima, direita, baixo,fonteDeInfeccao;
    private Inimigo[] vetor = new Inimigo[4];

    public boolean getFonteDeInfeccao(){
        return this.fonteDeInfeccao;
    }

    public Inimigo gerarInimigos(int x,int y){
        Random gerador = new Random();
        int atkDef = gerador.nextInt(4);
        if(atkDef==0){
            atkDef += 1;
        }
        return new Inimigo(atkDef,x,y);
    }

    public void init(int numeroDeInimigos,int x,int y,Setor[][] setor,int acao){
        for(int i=0;i<numeroDeInimigos;i++){
            vetor[i]=gerarInimigos(x,y);
        }
        if(x==0||y==0){
            setor[x][y+1].setCima(false);
            setor[x][y+1].setEsquerda(false);
        }
        setLados(x,y,setor,acao);
        // Ação representa o movimento que está sendo feito
    }

    public void setLados(int x,int y,Setor[][] setor,int acao){
        // Case 1: o jogador que movimentar para cima
        // Case 2: o jogador que movimentar para baixo
        // Case 3: o jogador que movimentar para direita
        // Case 4: o jogador que movimentar para esquerda
        switch (acao) {
            case 1:
                setor[x][y+1].setBaixo(true);

                setor[x][y+1].setEsquerda(sortear());
                setor[x][y+1].setDireita(sortear());
                if(y+1<5){
                    setor[x][y+1].setCima(sortear());
                }else{
                    setor[x][y+1].setCima(false);
                }
                break;
            case 2:
                setor[x][y-1].setCima(true);

                setor[x][y-1].setEsquerda(sortear());
                setor[x][y-1].setDireita(sortear());
                if(y-1>0){
                    setor[x][y-1].setBaixo(sortear());
                }else{
                    setor[x][y-1].setBaixo(false);
                }
                break;
            case 3:
                setor[x+1][y].setEsquerda(true);
                setor[x+1][y].setDireita(sortear());
                setor[x+1][y].setCima(sortear());
                setor[x+1][y].setBaixo(sortear());
                break;
            case 4:
                setor[x-1][y].setEsquerda(sortear());
                setor[x-1][y].setDireita(true);
                setor[x-1][y].setCima(sortear());
                setor[x-1][y].setBaixo(sortear());
                break;
            default:
                break;
        }
    }

    public boolean getEsquerda(){
        return this.esquerda;
    }
    public boolean getCima(){
        return this.cima;
    }
    public boolean getBaixo(){
        return this.baixo;
    }
    public boolean getDireita(){
        return this.direita;
    }
    public void setDireita(boolean d){
        this.direita=d;
    }
    public void setEsquerda(boolean d){
        this.esquerda=d;
    }
    public void setCima(boolean d){
        this.cima=d;
    }
    public void setBaixo(boolean d){
        this.baixo=d;
    }

    public boolean sortear(){
        Random gerador = new Random();
        int a = gerador.nextInt(100);
        int b = gerador.nextInt(100);
        if((a+b)%2==0){
            return true;
        }else{
            return false;
        }
    }
}