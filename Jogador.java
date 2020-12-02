import java.util.Random;

public abstract class Jogador {
    protected int atk, def, x, y;
    public Jogador(int atk, int def) {
        this.atk = atk;
        this.def = def;
        this.y = 2;
        this.x = 2;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public abstract void setDef(int def);
    // public abstract void setAtk(JogadorSimples j, int atk);

    public void movimentar(Tabuleiro tab, JogadorSimples j, int movimento) {
        switch (movimento) {
            case 1:
                if (tab.portaCimaAberta(tab.getSetores(), this.x, this.y)) {
                    if(this.x - 1 >= 0){
                        try{
                            setX(this.x - 1);
                        }
                        finally{
                            tab.initSetor(this.x, this.y,1);
                        }
                    }else{
                        System.out.printf("Porta fechada, movimento recusado");
                        return;
                    }
                }else{
                    System.out.printf("Porta de cima fechada -> Setor[%d,%d]",this.x,this.y);
                }
                break;
            case 2:
                if (tab.portaBaixoAberta(tab.getSetores(), this.x, this.y)) {
                    if(this.x + 1>=4){
                        try{
                            tab.initSetor(this.x, this.y,2);
                        }
                        finally{
                            setX(this.x + 1);
                        }
                    }else{
                        System.out.printf("Porta fechada");
                    }
                }else{
                    System.out.printf("Porta de baixo fechada -> Setor[%d,%d]",this.x,this.y);
                }
                break;
            case 3:
                if (tab.portaDireitaAberta(tab.getSetores(), this.x, this.y)) {
                    if(this.y + 1<=4){
                        try{
                            setY(this.y + 1);
                        }
                        finally{
                            tab.initSetor(this.x, this.y,3);
                        }
                    }else{
                        System.out.printf("Porta fechada");
                    }
                }else{
                    System.out.printf("Porta da direita fechada -> Setor[%d,%d]",this.x,this.y);
                }
                break;
            case 4:
                if (tab.portaEsquerdaAberta(tab.getSetores(), this.x, this.y)) {
                    if(this.y-1>=0){
                        try{
                            setY(this.y - 1);
                        }
                        finally{
                            tab.initSetor(this.x, this.y,4);
                        }
                    }else{
                        System.out.printf("Porta fechada");
                    }
                }else{
                    System.out.printf("Porta da esquerda fechada -> Setor[%d,%d]",this.x,this.y-1);
                }
                break;
            default:
                break;
        }
    }
    // public void atacar(Inimigo i) {
    //     int resultado = i.getDef()-this.atk;
    //     if(resultado>0){
    //         i.setDef(resultado);
    //     }else{
    //         return;
    //     }
    // }
    public void procurar(Setor j) {
        int num=getIntervalo(1, 6);
        if (num >= 1 || num <= 3) {
        }
        if (num == 4) {
            setDef(this.def + 1);
        }
        if (num == 5) {
            setDef(this.def + 2);
        }
        if (num == 6) {
            setDef(this.def + 1);
            Inimigo adv[] = new Inimigo[5];
            adv = j.getInimigos();
            for(int i=0;i<adv.length;i++){
                if(adv[i].getAtk()==0){
                    return;
                }else{
                    adv[i].setDef(adv[i].getDef()-1);
                }
            }
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