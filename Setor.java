import java.util.Random;

public abstract class Setor{
    private boolean esquerda, cima, direita, baixo,fonteDeInfeccao;
    private Inimigo[] vetor = new Inimigo[5];

    public Setor(char c){
        this.esquerda=true;
        this.cima=true;
        this.direita=true;
        this.baixo=true;
        this.fonteDeInfeccao=false;
    } // Construtor do setor C
    public Setor(boolean fonte){
        this.fonteDeInfeccao=true;
    } // Construtor setor infeccao
    public Setor(){}

    public Inimigo[] getInimigos(){
        return this.vetor;
    }
    public boolean getFonteDeInfeccao(){
        return this.fonteDeInfeccao;
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
    
    public void setLados(int x,int y,Setor[][] setor,int acao){
        switch (acao) {
            case 1:
                setor[x-1][y].setBaixo(true);

                setor[x-1][y].setEsquerda(sortear());
                setor[x-1][y].setDireita(sortear());

                if(x-1>=0){
                    setor[x-1][y].setCima(sortear());
                }else{
                    setor[0][y].setCima(false);
                }
                
                break;
            case 2:
                setor[x+1][y].setCima(true);

                setor[x+1][y].setEsquerda(sortear());
                setor[x+1][y].setDireita(sortear());

                if(x<=4){
                    setor[x+1][y].setBaixo(sortear());
                }else{
                    setor[4][y].setBaixo(false);
                }
                break;
            case 3:
                setor[x][y+1].setEsquerda(true);

                setor[x][y+1].setCima(sortear());
                setor[x][y+1].setBaixo(sortear());

                if(y<=4){
                    setor[x][y+1].setDireita(sortear());
                }else{
                    setor[x][4].setDireita(false);
                }
                break;
            case 4:
                setor[x][y-1].setDireita(true);

                setor[x][y-1].setCima(sortear());
                setor[x][y-1].setBaixo(sortear());
                
                if(y-1>=0){
                    setor[x][y-1].setEsquerda(sortear());
                }else{
                    setor[x][0].setEsquerda(false);
                }
                break;
            default:
                break;
        }
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
    public void setVetor(Inimigo[] vetor){
        this.vetor=vetor;
    }
    
    public void init(int numeroDeInimigos,int x,int y,Setor[][] setor,int acao){
        Inimigo []inimigos = new Inimigo[numeroDeInimigos];
        for(int i=0;i<inimigos.length;i++){
            inimigos[i]=gerarInimigos(x,y);
        }
        setLados(x,y,setor,acao);    
        setVetor(inimigos);
        System.out.printf("Setor:%d,%d\nInimigos%d\n",x,y,inimigos.length);       
    }
    
    
    public Inimigo gerarInimigos(int x,int y){
        int atkDef = getIntervalo(1, 3);
        return new Inimigo(atkDef,x,y);
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
    public int getIntervalo(int x,int y){
        Random gerador = new Random();
        int num = gerador.nextInt(y+1);
        do{
            num = gerador.nextInt(y+1);
        }while(num<x);
        return num;
    }
}