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
    public Setor(){
        this.fonteDeInfeccao=false;
    }

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
    public void setInimigo(Inimigo[] vetor){
        this.vetor=vetor;
    }
}