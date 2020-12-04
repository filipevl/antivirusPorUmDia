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

    public void movimentar(Tabuleiro tab, Jogador j, int movimento) {
        switch (movimento) {
            case 1: // Ir para cima
                if (tab.getSetores()[j.x][j.y].getCima()) {
                    if(this.x - 1 > -1){
                        setX(this.x - 1);
                        tab.initSetor(this.x, this.y,1);
                    }else{
                        System.out.printf("\n\nPorta fechada, movimento recusado\n\n");
                        return;
                    }
                }else{
                    System.out.printf("\n\nPorta fechada, movimento recusado\n\n");
                }
                break;
            case 2: // Ir para baixo
                if (tab.getSetores()[j.x][j.y].getBaixo()) {
                    if(this.x + 1<5){
                        setX(this.x + 1);
                        tab.initSetor(this.x, this.y,2);  
                    }else{
                        System.out.printf("\n\nPorta fechada, movimento recusado\n\n");
                        return;
                    }
                }else{
                    System.out.printf("\n\nPorta fechada, movimento recusado\n\n");
                }
                break;
            case 3: //Ir para direita
                if (tab.getSetores()[j.x][j.y].getDireita()) {
                    if(this.y + 1<5){
                        setY(this.y + 1);
                        tab.initSetor(this.x, this.y,3);
                    }else{
                        System.out.printf("\n\nPorta fechada, movimento recusado\n\n");
                        return;
                    }
                }else{
                    System.out.printf("\n\nPorta fechada, movimento recusado\n\n");
                }
                break;
            case 4: //Ir para esquerda
                if (tab.getSetores()[j.x][j.y].getEsquerda()) {
                    if(this.y-1>-1){
                            setY(this.y - 1);
                            tab.initSetor(this.x, this.y,4);
                    }else{
                        System.out.printf("\n\nPorta fechada, movimento recusado\n\n");
                        return;
                    }
                }else{
                    System.out.printf("\n\nPorta fechada, movimento recusado\n\n");
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