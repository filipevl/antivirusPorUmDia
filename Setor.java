import java.util.Random;
 
public abstract class Setor{
    private boolean esquerda, cima, direita, baixo,fonteDeInfeccao,init;
    private Inimigo[] vetor = new Inimigo[5];
    

    public Setor(char c){
        this.esquerda=true;
        this.cima=true;
        this.direita=true;
        this.baixo=true;
        this.fonteDeInfeccao=false;
        this.init = true;
    } // Construtor do setor C
    public Setor(boolean fonte){
        this.fonteDeInfeccao=true;
    } // Construtor setor infeccao
    public Setor(){
        this.fonteDeInfeccao=false;
        this.init = false;
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
    public boolean getInit(){
        return this.init;
    }

    public void setInit(){
        this.init = true;
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
        if(!setor[x][y].init){
            Inimigo []inimigos = new Inimigo[numeroDeInimigos];
            for(int i=0;i<inimigos.length;i++){
                inimigos[i]=gerarInimigos(x,y);
            }
            setVetor(inimigos);
            setLados(x,y,setor,acao); 
            setInit();
        }else{
            return;
        }
            
    }
    
    public void setLados(int x,int y,Setor[][] setor,int acao){
        Setor vizinhoEsquerda = setor[x][y-1];
        Setor vizinhoDireita = setor[x][y+1];
        Setor vizinhoCima = setor[x-1][y];
        Setor vizinhoBaixo = setor[x+1][y];
        switch (acao) {
            case 1: //Ir para cima
                setor[x][y].setBaixo(true);

                if(vizinhoEsquerda.getInit()){ //Vizinho de esquerda ja foi inicializado ?
                    if(vizinhoEsquerda.getDireita()){ //Porta direita do vizinho da esquerda
                        setor[x][y].setEsquerda(true);
                    }else{
                        setor[x][y].setEsquerda(sortear());
                    }
                }else{
                    setor[x][y].setEsquerda(sortear());
                }
                
                if(vizinhoDireita.getInit()){ //Vizinho da direita ja foi inicializado ?
                    if(vizinhoDireita.getEsquerda()){ //Porta esquerda do vizinho da direita
                        setor[x][y].setDireita(true);
                    }else{
                        setor[x][y].setDireita(sortear());
                    }
                }else{
                    setor[x][y].setDireita(sortear());
                }
                    
                if(vizinhoCima.getInit()){ //Vizinho de cima ja foi inicializado ?
                    if(vizinhoCima.getBaixo()){
                        setor[x][y].setCima(true);
                    }else{
                        setor[x][y].setCima(sortear());
                    }
                }else{
                    setor[x][y].setCima(sortear());
                }
                break;
            case 2: //Ir para baixo
                setor[x][y].setCima(true);

                if(vizinhoEsquerda.getInit()){ //Vizinho de esquerda ja foi inicializado ?
                    if(vizinhoEsquerda.getDireita()){ //Porta direita do vizinho da esquerda
                        setor[x][y].setEsquerda(true);
                    }
                    else{
                        setor[x][y].setEsquerda(sortear());
                    }
                }else{
                    setor[x][y].setEsquerda(sortear());
                }
                
                if(vizinhoDireita.getInit()){ //Vizinho da direita ja foi inicializado ?
                    if(vizinhoDireita.getEsquerda()){ //Porta esquerda do vizinho da direita
                        setor[x][y].setDireita(true);
                    }else{
                        setor[x][y].setDireita(sortear());
                    }
                }
                else{
                    setor[x][y].setDireita(sortear());
                }
                    
                  
                if(vizinhoBaixo.getInit()){ //Vizinho de baixo ja foi inicializado ?
                    if(vizinhoBaixo.getCima()){
                        setor[x][y].setBaixo(true);
                    }else{
                        setor[x][y].setBaixo(sortear());
                    }
                }else{
                    setor[x][y].setBaixo(sortear());
                }
                break;
            case 3: // Ir para direita
                setor[x][y].setEsquerda(true);

                if(vizinhoDireita.getInit()){ //Vizinho da direita ja foi inicializado ?
                    if(vizinhoDireita.getEsquerda()){ //Porta esquerda do vizinho da direita
                        setor[x][y].setDireita(true);
                    }else{
                        setor[x][y].setDireita(sortear());
                    }
                }else{
                    setor[x][y].setDireita(sortear());
                }
                    
                if(vizinhoCima.getInit()){ //Vizinho de cima ja foi inicializado ?
                    if(vizinhoCima.getBaixo()){
                        setor[x][y].setCima(true);
                    }else{
                        setor[x][y].setCima(sortear());
                    }
                }else{
                    setor[x][y].setCima(sortear());
                }

                if(vizinhoBaixo.getInit()){ //Vizinho de baixo ja foi inicializado ?
                    if(vizinhoBaixo.getCima()){
                        setor[x][y].setBaixo(true);
                    }else{
                        setor[x][y].setBaixo(sortear());
                    }
                }else{
                    setor[x][y].setBaixo(sortear());
                }

                break;
            case 4: // Ir para esquerda
                setor[x][y].setDireita(true);

                if(vizinhoCima.getInit()){ //Vizinho de cima ja foi inicializado ?
                    if(vizinhoCima.getBaixo()){
                        setor[x][y].setCima(true);
                    }else{
                        setor[x][y].setCima(sortear());
                    }
                }else{
                    setor[x][y].setCima(sortear());
                }

                if(vizinhoBaixo.getInit()){ //Vizinho de baixo ja foi inicializado ?
                    if(vizinhoBaixo.getCima()){
                        setor[x][y].setBaixo(true);
                    }else{
                        setor[x][y].setBaixo(sortear());
                    }
                }else{
                    setor[x][y].setBaixo(sortear());
                }

                if(vizinhoEsquerda.getInit()){ //Vizinho de esquerda ja foi inicializado ?
                    if(vizinhoEsquerda.getDireita()){ //Porta direita do vizinho da esquerda
                        setor[x][y].setEsquerda(true);
                    }
                    else{
                        setor[x][y].setEsquerda(sortear());
                    }
                }else{
                    setor[x][y].setEsquerda(sortear());
                }

                break;
            default:
                break;
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
    public Inimigo gerarInimigos(int x,int y){
        int atkDef = getIntervalo(1, 3);
        return new Inimigo(atkDef,x,y);
    }
    public boolean sortear(){
        int a = getIntervalo(1, 10);
        if(a>=3){
            return true;
        }else{
            return false;
        }
    }
}