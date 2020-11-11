public abstract class Jogador{
    public Jogador(short atk, short def){
        this.atk = atk;
        this.def = def;
        this.y = 3;
        this.x = 3;
    }
    protected short atk,def,x,y;

    public short getAtk(){
        return this.atk;
    }
    public short getDef(){
        return this.atk;
    }
    public short getX(){
        return this.x;
    }
    public short getY(){
        return this.y;
    }

    public void setAtk(short atk){
        this.atk = atk;
    }
    public abstract void setDef(short def){
        this.atk = def;
    }
    public void setX(short x){
        this.x = x;
    }
    public void setY(short y){
        this.y = y;
    }
    public abstract void setAtk(short atk){
        this.atk = atk;
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