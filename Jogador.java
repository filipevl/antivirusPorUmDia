import java.util.Random;

public abstract class Jogador {
    protected int atk, def, x, y;
    public Jogador(int atk, int def) {
        this.atk = atk;
        this.def = def;
        this.y = 3;
        this.x = 3;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public abstract void setDef(int def);
    public abstract void setAtk(JogadorSimples j, int atk);

    public void movimentar(Tabuleiro tab, JogadorSimples j, int posicao) {
        // O método movimentar recebe como paramêtro o objeto do tipo tabuleiro e
        // um objeto do tipo jogador simples
        // Esse método trata inteiros da seguinte forma:
        // Case 1: o jogador que movimentar para cima
        // Case 2: o jogador que movimentar para baixo
        // Case 3: o jogador que movimentar para direita
        // Case 4: o jogador que movimentar para esquerda
        switch (posicao) {
            case 1:
                if (tab.portaCimaAberta(tab.getPosicao(), this.x, this.y)) {
                    if(this.y + 1 < 5){
                        setY(this.y + 1);
                    }
                    tab.initSetor(x, y,1);
                }
                break;
            case 2:
                if (tab.portaBaixoAberta(tab.getPosicao(), this.x, this.y)) {
                    if(this.y - 1>=0){
                        setY(this.y - 1);
                    }
                    tab.initSetor(x, y,2);
                }
                break;
            case 3:
                if (tab.portaDireitaAberta(tab.getPosicao(), this.x, this.y)) {
                    if(this.x + 1<5){
                        setY(this.x + 1);
                    }
                    tab.initSetor(x, y,3);
                }
                break;
            case 4:
                if (tab.portaEsquerdaAberta(tab.getPosicao(), this.x, this.y)) {
                    if(this.x-1>=0){
                        setY(this.x - 1);
                    }
                    tab.initSetor(x, y,4);
                }
                break;
            default:
                break;
        }
    }
    public void atacar(Inimigo i) {
        i.setDef(this.atk - this.def);
        return;
    }
    public void procurar(Setor j) {
        Random gerador = new Random();
        int num = gerador.nextInt(7);
        if (num == 0) {
            num += 1;
        }
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
                if(adv[i].getAtk()!=0){
                    return;
                }else{
                    adv[i].setDef(adv[i].getDef()-1);
                }
            }
        }
    }
}