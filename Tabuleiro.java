import java.util.Random;

public class Tabuleiro{
    private Setor[][] setores = new Setor[5][5];
    public Setor[][] getSetores(){
        return this.setores;
    }

    public void init(){
        int x = getIntervalo(0,5); //Posição x da fonte de infecção
        int y = getIntervalo(0,5); //Posição y da fonte de infecção
        int ab  = getIntervalo(1, 10);
        int cd  = getIntervalo(1, 10);
        int ef = getIntervalo(1, 10);

        do{
            if(x==2)
                x = getIntervalo(0,5);
            if(y==2)
                y = getIntervalo(0,5);
        }while(x==2 || y==2);
        
        for(int aux1 = 0 ; aux1 < 5 ; aux1++ ){
            for(int aux2 = 0 ; aux2 < 5 ; aux2++ ){
                if(aux1==2 && aux2==2) {
                    this.setores[aux1][aux2] = new SetorNormal('c'); //Posição C
                }else if(aux1 == x && aux2 == y ) {
                    this.setores[aux1][aux2] = new SetorNormal(true); //Fonte de infecção
                }else if( ab + cd + ef < 10 ) {
                    this.setores[aux1][aux2] = new SetorPrivado();
                }else if( ab + cd + ef < 20  && ab + cd + ef > 10 ) {
                    this.setores[aux1][aux2] = new SetorNormal();

                }else if( ab + cd + ef < 30 && ab + cd + ef > 20 ) {
                    this.setores[aux1][aux2] = new SetorOculto();
                }
            }
        }
        System.out.printf("\n\n\t-Matriz de setores criada com sucesso");
    }
    public void initSetor(int x,int y,int acao){ // acao representa qual movimento o jogador fará
        
        int numInimigos = getIntervalo(1, 5);
        Inimigo []inimigos = new Inimigo[numInimigos];

        for(int i=0;i<inimigos.length;i++){
            int atkDef = getIntervalo(1, 3);
            inimigos[i]= new Inimigo(atkDef,x,y);
        }
        this.setores[x][y].setInit();
        this.setores[x][y].setInimigo(inimigos);
        setLados(x, y, acao);
    }
    
    public boolean portaEsquerdaAberta(int posicaoX,int posicaoY){
        if(this.setores[posicaoX][posicaoY].getEsquerda()){
            return true;
        }else{
            return false;
        }
    }
    public boolean portaDireitaAberta(int posicaoX,int posicaoY){
        if(this.setores[posicaoX][posicaoY].getDireita()){
            return true;
        }else{
            return false;
        }
    }
    public boolean portaBaixoAberta(int posicaoX,int posicaoY){
        if(this.setores[posicaoX][posicaoY].getBaixo()){
            return true;
        }else{
            return false;
        }
    }
    public boolean portaCimaAberta(int posicaoX,int posicaoY){
        if(this.setores[posicaoX][posicaoY].getCima()){
            return true;
        }else{
            return false;
        }
    }

    public void setLados(int x,int y,int acao){
        Setor vizinhoEsquerda = getVizinhoEsquerda(x, y);
        Setor vizinhoDireita = getVizinhoDireita(x, y);
        Setor vizinhoCima = getVizinhoCima(x, y);
        Setor vizinhoBaixo = getVizinhoBaixo(x, y);
        switch (acao) {
            case 1: //Ir para cima
                this.setores[x][y].setBaixo(true);

                if(vizinhoEsquerda.getInit()){
                    if(vizinhoEsquerda.getDireita()){ //Porta direita do vizinho da esquerda
                        this.setores[x][y].setEsquerda(true);
                    }else{
                        this.setores[x][y].setEsquerda(sortear());
                    }
                }else{
                    this.setores[x][y].setEsquerda(sortear());
                }
                
                if(vizinhoDireita.getInit()){
                    if(vizinhoDireita.getEsquerda()){ //Porta esquerda do vizinho da direita
                        this.setores[x][y].setDireita(true);
                    }else{
                        this.setores[x][y].setDireita(sortear());
                    }
                }else{
                    this.setores[x][y].setDireita(sortear());
                }
                    
                if(vizinhoCima.getInit()){  
                    if(vizinhoCima.getBaixo()){
                        this.setores[x][y].setCima(true);
                    }else{
                        this.setores[x][y].setCima(sortear());
                    }
                }else{
                    this.setores[x][y].setCima(sortear());
                }
                break;
            case 2: //Ir para baixo
                this.setores[x][y].setCima(true);

                if(vizinhoEsquerda.getInit()){
                        if(vizinhoEsquerda.getDireita()){ //Porta direita do vizinho da esquerda
                            this.setores[x][y].setEsquerda(true);
                        }else{
                            this.setores[x][y].setEsquerda(sortear());
                        }
                }else{
                    this.setores[x][y].setEsquerda(sortear());
                }
                    
                if(vizinhoDireita.getInit()){
                    if(vizinhoDireita.getEsquerda()){ //Porta esquerda do vizinho da direita
                        this.setores[x][y].setDireita(true);
                    }else{
                        this.setores[x][y].setDireita(sortear());
                    }
                }else{
                    this.setores[x][y].setDireita(sortear());
                }

                if(vizinhoBaixo.getInit()){
                    if(vizinhoBaixo.getCima()){
                        this.setores[x][y].setBaixo(true);
                    }else{
                        this.setores[x][y].setBaixo(sortear());
                    }
                }else{
                    this.setores[x][y].setBaixo(sortear());
                } 
                break;
            case 3: // Ir para direita
                this.setores[x][y].setEsquerda(true);
                
                if(vizinhoDireita.getInit()){
                    if(vizinhoDireita.getEsquerda()){ //Porta esquerda do vizinho da direita
                        this.setores[x][y].setDireita(true);
                    }else{
                        this.setores[x][y].setDireita(sortear());
                    }
                }else{
                    this.setores[x][y].setDireita(sortear());
                }
                    
                if(vizinhoCima.getInit()){
                    if(vizinhoCima.getBaixo()){
                        this.setores[x][y].setCima(true);
                    }else{
                        this.setores[x][y].setCima(sortear());
                    }
                }else{
                    this.setores[x][y].setCima(sortear());
                }
                    
                if(vizinhoBaixo.getInit()){
                    if(vizinhoBaixo.getCima()){
                        this.setores[x][y].setBaixo(true);
                    }else{
                        this.setores[x][y].setBaixo(sortear());
                    }
                }else{
                    this.setores[x][y].setBaixo(sortear());
                }
                break;
            case 4: // Ir para esquerda
                this.setores[x][y].setDireita(true);
                
                if(vizinhoCima.getInit()){
                    if(vizinhoCima.getBaixo()){
                        this.setores[x][y].setCima(true);
                    }else{
                        this.setores[x][y].setCima(sortear());
                    }
                }else{
                    this.setores[x][y].setCima(sortear());
                }
                    
                if(vizinhoBaixo.getInit()){
                    if(vizinhoBaixo.getCima()){
                        this.setores[x][y].setBaixo(true);
                    }else{
                        this.setores[x][y].setBaixo(sortear());
                    }
                }else{
                    this.setores[x][y].setBaixo(sortear());
                }
                    
                if(vizinhoEsquerda.getInit()){
                    if(vizinhoEsquerda.getDireita()){ //Porta direita do vizinho da esquerda
                        this.setores[x][y].setEsquerda(true);
                    }
                    else{
                        this.setores[x][y].setEsquerda(sortear());
                    }
                }else{
                    this.setores[x][y].setEsquerda(sortear());
                }
                break;
            default:
                break;
        }
    }

    public Setor getVizinhoEsquerda(int x,int y){
        if(y-1<0){
            return this.setores[x][0];
        }else{
            return this.setores[x][y-1];
        }
    }
    public Setor getVizinhoDireita(int x,int y){
        if(y+1>4){
            return this.setores[x][4];
        }else{
            return this.setores[x][y+1];
        }
    }
    public Setor getVizinhoCima(int x,int y){
        if(x-1<0){
            return this.setores[0][y];
        }else{
            return this.setores[x-1][y];
        }
    }
    public Setor getVizinhoBaixo(int x,int y){
        if(x+1>4){
            return this.setores[4][y];
        }else{
            return this.setores[x+1][y];
        }
    }
    public boolean sortear(){
        int a = getIntervalo(1, 10);
        if(a>=3){
            return true;
        }else{
            return false;
        }
    }
    public int getIntervalo(int x,int y){
        Random gerador = new Random();
        int num = gerador.nextInt(y);
        do{
            num = gerador.nextInt(y);
        }while(num<x);
        return num;
    }
}