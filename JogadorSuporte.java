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
        if(j.x == this.x && j.y == this.y) {
            System.out.printf("Defesa P1 recuperada em 2 pontos");
            j.setDef(j.def+2);
            recuperarDefesaSuporte();
        }
        else{
            recuperarDefesaSuporte();
        }
    }
    public void recuperarDefesaSuporte(){
        if(this.def>=1){
            setDef(def+2);
            System.out.printf("Defesa P2 recuperada em 2 pontos");
        }else{
            return;
        }
    }

    public void recuperarDefesa(JogadorSimples j){
        if(existe(j))
            j.setDef(j.def+2);
        else
            return;
    }

}