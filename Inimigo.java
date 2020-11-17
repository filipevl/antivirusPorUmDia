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
    public int getDef() {
        return def;
    }
    public void setDef(int def){
        this.def = def;
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
    public void atacar(Jogador j1,Jogador j2){
        Random gerador = new Random();
        int num = gerador.nextInt(7);
        if(num==0){
            num += 1;
        }
        if(num%2==0){
            if(j1.getX()==getX()&&j1.getY()==getY()){
                j1.setDef(j1.getDef()-getAtk());
            }
            if(j2.getX()==getX()&&j2.getY()==getY()){
                j2.setDef(j2.getDef()-getAtk());
            }
        }else{
            return;
        }
    }
}