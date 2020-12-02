public class JogadorSuporte extends Jogador{
    public JogadorSuporte(){
        super(1,7);
    }

    public boolean existe(JogadorSimples j){
        if(j.def>0){
            return true;
        }else{
            return false;
        }
    }

    public void setDef(int def){
        this.def = def;
    }

    public void recuperarDefesaSimples(JogadorSimples j){
        if(j.x == this.x && j.y == this.y)
            j.setDef(j.def+2);
    }
    public void recuperarDefesaSuporte(){
        if(this.def>=1)
            setDef(def+2);
    }

    public void recuperarDefesa(JogadorSimples j){
        if(existe(j))
            j.setDef(j.def+2);
        else
            return;
    }


//     public void setAtk(JogadorSimples j, int atk){
//         if(existe(j)){
//             if(j.atk<this.atk){
//                 this.atk = atk;
//             }
//         }
//     }

}