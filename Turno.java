public class Turno {
    public static void main(String args[]){
        int i = 0;
        Tabuleiro tab = new Tabuleiro();
        tab.init(tab.getPosicao()); // Gera uma matriz de setores
        JogadorSimples p1 = new JogadorSimples();
        // JogadorSuporte p2 = new JogadorSuporte();
        do {
            Setor setor = tab.getPosicao()[p1.x][p1.y];
            p1.movimentar(tab, p1, 1);
            p1.procurar(setor);
            System.out.printf("Defesa:%d\nAtaque:%d\n", p1.def,p1.atk);
            i++;
        } while (i <= 25); // Número maximo de turno possíveis

    }


    public static void tabuleiro(JogadorSimples j1, JogadorSuporte j2,Tabuleiro tab) {
        cabecalho(tab.getPosicao(),j1,j2);
        System.out.printf("  |---|---|---|---|---|\t\t\t \n");
        System.out.printf("1 |   |   |   |   |   |\t\t\t    Setor[%d,%d]\n",j1.x,j1.y);
        System.out.printf("  |---|---|---|---|---|\t\t\t \n");
        System.out.printf("2 |   |   |   |   |   |\t\t\t |------*------|\n");
        System.out.printf("  |---|---|-*-|---|---|\t\t\t |             |\n");
        System.out.printf("3 |   |   * C *   |   |\t\t\t |             |\n");
        System.out.printf("  |---|---|-*-|---|---|\t\t\t *             *\n");
        System.out.printf("4 |   |   |   |   |   |\t\t\t | P1       P2 |\n");
        System.out.printf("  |---|---|---|---|---|\t\t\t | %d/%d     %d/%d |\n",j1.atk,j1.def,j2.atk,j2.def);
        System.out.printf("5 |   | X |   |   |   |\t\t\t |------*------|\n");
        System.out.printf("  |---|---|---|---|---|\t\t\t \n");
    }

    public static void cabecalho(Setor[][] setor,JogadorSimples j1, JogadorSuporte j2){
        char[][] matriz = new char[5][4]; // primeira posicao faz referencia ao setor, segunda posicao a porta 0->cima,1->baixo,2->esquerda,3->direita
        System.out.printf("------------------------------\n");
        System.out.printf("|    Antivirus por um dia    |\n");
        System.out.printf("------------------------------\n");
        System.out.printf("    1   2   3   4   5\n");
        for(int i=0;i<5;i++){
            for(int y=0;y<5;y++){
                if(setor[i][y].getCima()){
                    matriz[i][0]='*';
                }else{
                    matriz[i][0]='-';
                }
                if(setor[i][y].getBaixo()){
                    matriz[i][1]='*';
                }else{
                    matriz[i][1]='-';
                }
                if(setor[i][y].getEsquerda()){
                    matriz[i][2]='*';
                }else{
                    matriz[i][2]='-';
                }
                if(setor[i][y].getDireita()){
                    matriz[i][3]='*';
                }else{
                    matriz[i][3]='-';
                }   
            }
            
        }
        System.out.printf("  |-%c-|-%c-|-%c-|-%c-|-%c-|\t\t\t \n",matriz[0][0],matriz[0][1],matriz[0][2],matriz[0][3],matriz[0][4]);
        System.out.printf("1 %c %c %c %c %c %c %c %c %c\t\t\t    Setor[%d,%d]\n",matriz[0][0],matriz[0][1],matriz[0][2],matriz[0][3],matriz[0][4],j1.x,j1.y);
        System.out.printf("  |-%c-|-%c-|-%c-|-%c-|-%c-|\t\t\t \n",matriz[2][2],matriz[1][2],matriz[2][2],matriz[3][2],matriz[4][2]);
    }
    public static void setores(Setor[][] setor){
        for(int i=0;i<15;i++){
            System.out.printf("%d  |-",i/3);
            if(setor[0][0].getEsquerda()){
                /* Função que retona esse quadrado com as condições
                |---|
                |   |
                |---|
                */
            }
        }
    }

    public static void turnoP(JogadorSimples j1, JogadorSuporte j2, Inimigo i){
        
    }


    // 1   2   3   4   5
    // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Setor.getCima()" because "<parameter1>[<local4>][<local5>]" i
    // s null
    //         at Turno.cabecalho(Turno.java:77)
    //         at Turno.tabuleiro(Turno.java:55)
    //         at Turno.main(Turno.java:47)
}