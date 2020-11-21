import java.util.Random;

public class Setor{
    public Setor(boolean esquerda,boolean cima,boolean direita,boolean baixo, boolean fonteDeInfeccao){
        this.esquerda=esquerda;
        this.cima=cima;
        this.direita=direita;
        this.baixo=baixo;
        this.fonteDeInfeccao=fonteDeInfeccao;
    }
    public Setor(){
        this.fonteDeInfeccao=false;
    }
    public Setor(boolean fonte){
        this.fonteDeInfeccao=true;
    }
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

    public void init(int numeroDeInimigos,int x,int y){
        for(int i=0;i<numeroDeInimigos;i++){
            vetor[i]=gerarInimigos(x,y);
        }
        setLados();
    }

    public void setLados(){
        this.esquerda=sortear();
        this.cima=sortear();
        this.direita=sortear();
        this.baixo=sortear();
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