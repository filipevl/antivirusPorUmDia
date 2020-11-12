public class JogadorSuporte extends Jogador{
    public JogadorSuporte(){
        super(2,6);
    }

    public boolean existe(JogadorSimples j){
        if(j.getAtk()>0&&j.getDef()>0){
            return true;
        }else{
            return false;
        }
    }

    public void setDef(int def){
        this.def = def;
    }

    public void recuperarDefesa(JogadorSimples j){
        if(existe(j)){
            if(j.getDef()>=2){
                j.setDef(j.getDef()-2);
                setAtk(j,2);
            }else{
                setAtk(j,2);
            }
        }else{
            return;
        }
    }

    public void setAtk(JogadorSimples j, int atk){
        if(existe(j)){
            if(j.getAtk()<getAtk()){
                this.atk = atk;
            }
        }
    }

}