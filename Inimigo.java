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
    public void setAtk(short atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }
    public void setDef(short def) {
        this.def = def;
    }

    public void gerarValores(){
        Random gerador = new Random();
        for(int i = 1; i<2; i++){
            atk=gerador.nextInt(4);
            def=gerador.nextInt(4);
        }
    }
}