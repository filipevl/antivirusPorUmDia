import java.util.Random;

public class Setor{
    public Setor(boolean primeiroLado,boolean segundoLado,boolean terceiroLado,boolean quartoLado, boolean fonteDeInfeccao){
        this.primeiroLado=primeiroLado;
        this.segundoLado=segundoLado;
        this.terceiroLado=terceiroLado;
        this.quartoLado=quartoLado;
        this.fonteDeInfeccao=fonteDeInfeccao;
    }
    public Setor(){
        this.fonteDeInfeccao=false;
    }
    public Setor(boolean fonte){
        this.fonteDeInfeccao=true;
    }
    private boolean primeiroLado, segundoLado, terceiroLado, quartoLado,fonteDeInfeccao;

    public boolean getFonteDeInfeccao(){
        return this.fonteDeInfeccao;
    }

    public void setLados(){
        this.primeiroLado=sortear();
        this.segundoLado=sortear();
        this.terceiroLado=sortear();
        this.quartoLado=sortear();
    }

    public boolean sortear(){
        Random gerador = new Random();
        int a = gerador.nextInt(100);
        int b = gerador.nextInt(100);
        if((a+b)%2==0){
            return true;
        }else{
            return false;
        }
    }
}