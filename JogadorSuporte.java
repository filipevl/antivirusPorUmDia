public class JogadorSuporte extends Jogador{
    public JogadorSuporte(){
        super(2,6);
    }
    public void setAtk(int atk){
        this.atk = atk;
    }
    public void setDef(int def){
        this.atk = def;
    }
    public void recuperarDefesa(JogadorSimples jogador){
        if(jogador.def>=2){
            jogador.setDef(jogador.getDef()-2);
            setAtk(2);
        }else{
            setAtk(2);
        }
    }
}