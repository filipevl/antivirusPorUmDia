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
    public void setAtk(Jogador j) {
        if(j.getDef()<getAtk()){
            j.setDef(0);
        }else{
            j.setDef(j.getDef()-getAtk());
        }
    }

    public void gerarValores(){
        Random gerador = new Random();
        atk=gerador.nextInt(4);
        def=gerador.nextInt(4);
    }
    public void atacar(){

    }
}