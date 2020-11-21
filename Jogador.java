import java.util.Random;
public abstract class Jogador{
    public Jogador(int atk, int def){
        this.atk = atk;
        this.def = def;
        this.y = 3;
        this.x = 3;
    }
    protected int atk,def,x,y;

    public int getAtk(){
        return this.atk;
    }
    public int getDef(){
        return this.atk;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public abstract void setDef(int def);
    public abstract void setAtk(JogadorSimples j,int atk);

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void movimentar(Tabuleiro tab,JogadorSimples j,int posicao){
        // O método movimentar recebe como paramêtro o objeto do tipo tabuleiro e
        // um objeto do tipo jogador simples
        // Esse método trata inteiros da seguinte forma:
        // Case 1: o jogador que movimentar para cima
        // Case 2: o jogador que movimentar para baixo
        // Case 3: o jogador que movimentar para direita
        // Case 4: o jogador que movimentar para esquerda
        switch(posicao){
            case 1:
                if(tab.portaCimaAberta(tab.getPosicao(),getX(),getY())){
                    setY(getY()+1);
                }
                break;
            case 2:
                if(tab.portaBaixoAberta(tab.getPosicao(),getX(),getY())){
                    setY(getY()-1);
                }
                break;
            case 3:
                if(tab.portaDireitaAberta(tab.getPosicao(),getX(),getY())){
                    setY(getX()+1);
                }
                break;
            case 4:
                if(tab.portaEsquerdaAberta(tab.getPosicao(),getX(),getY())){
                    setY(getX()-1);
                }
                break;
            default:
                break;
        }
    }
    public void atacar(Inimigo i){
        i.setDef(getAtk()-getDef());
        return;
    }
    public int procurar(){
        Random gerador = new Random();
        int num = gerador.nextInt(7);
        if(num==0){
            num += 1;
        }
        if(num>=1||num<=3){
            return 0;
        }
        if(num==4){
            setDef(getDef()+1);
            return 0;
        }
        if(num==5){
            setDef(getDef()+2);
            return 0;
        }
        if(num==6){
            setDef(getDef()+1);
            return 0;
        }
    }}
}