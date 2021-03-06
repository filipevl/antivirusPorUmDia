import java.util.Random;

public class Inimigo{
    private int atk, def,x,y;
    public Inimigo(int atkDef,int x,int y){
        this.atk = atkDef;
        this.def = atkDef;
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getAtk() {
        return atk;
    }
    public int getDef() {
        return def;
    }
    public void setDef(int def){
        this.def = def;
    }
    public void setAtk(Jogador j) {
        if(j.def<getAtk()){
            j.setDef(0);
        }else{
            j.setDef(j.def-getAtk());
        }
    }

    public void atacar(Jogador j1,Jogador j2){
        Random gerador = new Random();
        int num = gerador.nextInt(7);
        do{
            num = gerador.nextInt(7);
        }while(num==0);
        if(num%2==0){
            if(j1.x==getX()&&j1.y==getY()){
                j1.setDef(j1.def-getAtk());
            }
            if(j2.x==getX()&&j2.y==getY()){
                j2.setDef(j2.def-getAtk());
            }
        }else{
            return;
        }
    }

}