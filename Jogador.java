import java.util.Random;
import java.util.Scanner;
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
                System.out.println(tab.getSetores()[j.x][j.y].getCima());
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
    public void atacar(Setor s,Jogador j) {
        if(s instanceof SetorNormal){
            Scanner ler = new Scanner(System.in);
            Inimigo inimigos[] = new Inimigo[5];
            int vet[] = new int[5];
            for(int i=0;i<s.getInimigos().length;i++){
                inimigos[i]=s.getInimigos()[i];
                if(inimigos[i]!=null){
                    vet[i]=1;
                }else{
                    vet[i]=0;
                }
            }
            System.out.printf("\n\n\t -Mapa de inimigos do setor[%d,%d]",j.x,j.y);
            for(int i=0;i<vet.length;i++){
                System.out.printf("\nPosicao %d: %d\n",i,vet[i]);
            }
            System.out.printf("\nDigite uma posicao de inimigos para atacar");
            int posicao = ler.nextInt();
            
            int resultado = s.getInimigos()[posicao].getDef()-this.atk;

            if(resultado>0){
                s.getInimigos()[posicao].setDef(resultado);
            }else{
                s.getInimigos()[posicao].setDef(0);
                return;
            }
        }else if(s instanceof SetorOculto){
            Inimigo inimigos[] = new Inimigo[5];
            int vet[] = new int[5];
            for(int i=0;i<s.getInimigos().length;i++){
                inimigos[i]=s.getInimigos()[i];
                if(inimigos[i]!=null){
                    vet[i]=1;
                }
            }
            Scanner ler = new Scanner(System.in);
            System.out.printf("\nDigite uma posicao de inimigos para atacar");
            int posicao = ler.nextInt();
            int num = getIntervalo(0, 10);
            if(num>3){
                int resultado = s.getInimigos()[posicao].getDef()-this.atk;

                if(resultado>0){
                    s.getInimigos()[posicao].setDef(resultado);
                }else{
                    s.getInimigos()[posicao].setDef(0);
                    return;
                }
            }else{
                return;
            }
        }
        
    }
    public void procurar(Setor j) {
        if(j instanceof SetorPrivado){
            return;
        }
        int num=getIntervalo(1, 6);
        if (num >= 1 || num <= 3) {
            System.out.printf("\n\n\tNada encontrado no setor\n\n");
        }
        if (num == 4) {
            System.out.printf("\n\nVoce ganhou 1 Def");
            setDef(this.def + 1);
        }
        if (num == 5) {
            System.out.printf("\n\nVoce ganhou 2 Def");
            setDef(this.def + 2);
        }
        if (num == 6) {
            System.out.printf("\n\nTodos os inimigos perdem 1 Def");
            Inimigo adv[] = new Inimigo[5];
            adv = j.getInimigos();
            for(int i=0;i<adv.length;i++){
                if(adv[i]!=null){
                    if(adv[i].getAtk()==0){
                        return;
                    }else{
                        adv[i].setDef(adv[i].getDef()-1);
                    }
                }else{
                    return;
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