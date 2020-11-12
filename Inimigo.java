import java.util.Random;

public class Inimigo {
    public Inimigo(int atk, int def){
        this.atk = atk;
        this.def = def;
    }
    private int atk, def;

    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }

    public void gerarValores(){
        Random gerador = new Random();
        atk=gerador.nextInt(4);
        def=gerador.nextInt(4);
    }
    public void atacar(){

    }
}