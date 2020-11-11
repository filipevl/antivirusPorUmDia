public class Setor{
    public Setor(boolean primeiroLado,boolean segundoLado,boolean terceiroLado,boolean quartoLado, boolean fonteDeInfeccao){
        this.primeiroLado=primeiroLado;
        this.segundoLado=segundoLado;
        this.terceiroLado=terceiroLado;
        this.quartoLado=quartoLado;
        this.fonteDeInfeccao=fonteDeInfeccao;
    }
    public Setor(){}
    private boolean primeiroLado, segundoLado, terceiroLado, quartoLado,fonteDeInfeccao;

    public boolean getFonteDeInfeccao(){
        return this.fonteDeInfeccao;
    }
}