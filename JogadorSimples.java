public class JogadorSimples extends Jogador{
    public JogadorSimples(){
        super(2,6);
    }
    public void setAtk(JogadorSimples j,int atk){
        this.atk = atk;
    }
    public void setDef(int def){
        this.def = def;
    }
}