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
    public void movimentar(){
        //Implementar Método
    }
    public void atacar(){
        //Implementar Método

    }
    public void procurar(){
        //Implementar Método

    }
}