public class JogadorSuporte extends Jogador{
    public JogadorSuporte(){
        super(1,7);
    }

    public boolean existe(JogadorSimples j){
        if(j.getDef()>0){
            return true;
        }else{
            return false;
        }
    }

    public void setDef(int def){
        this.def = def;
    }

    public void recuperarDefesaSimples(JogadorSimples j){
        if(existe(j))
            if(j.getX()==getX()==j.getY()==jgetY());
            j.setDef(j.getDef()+2);
        else
            return;
    }
    public void recuperarDefesaSuporte(JogadoSuporte js){
        if(existe(j))
            if(js.getDef()>=1){
                js.setDef(js.getDef()+2);
        else
            return;
    }

    public void recuperarDefesa(Jogador j){
        if(existe(j))
            j.setDef(j.getDef()+2);
        else
            return;
    }


    public void setAtk(JogadorSimples j, int atk){
        if(existe(j)){
            if(j.getAtk()<getAtk()){
                this.atk = atk;
            }
        }
    }

}