import java.util.Scanner;
public class Turno {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Tabuleiro tab = new Tabuleiro();
        tab.init(tab.getSetores());
        JogadorSimples p1 = new JogadorSimples();
        JogadorSuporte p2 = new JogadorSuporte();
        imprimir(tab);
        for(int i=0;i<25;i++){
            System.out.printf("\nCiclo:%d\n",i+1);
            System.out.printf("Posicao Jogador 1:[%d,%d]\t",p1.x,p1.y);
            System.out.printf("Posicao Jogador 2:[%d,%d]\n",p2.x,p2.y);
            boolean j1=false; //ref se o jogador 1 fez ou não suas duas jogadas
            boolean j2=false; //ref se o jogador 2 fez ou não suas duas jogadas
            do{
                for(int y=0;y<2;y++){
                    int acao;
                    System.out.printf("\n\n\t\tJogador 1:[%d,%d]\tCiclo:%d",p1.x,p1.y,i+1);
                    System.out.printf("\n1-Movimentar\n2-Atacar\n3-Procurar\n4-Sair do jogo\n");
                    System.out.printf("\n\n\nJogador 1, Digite sua %d opcao: ",y+1);
                    acao = s.nextInt();
                    switch(acao){
                        case 1:
                            int movimento;
                            do{
                                if(tab.getSetores()[p1.x][p1.y].getCima()){
                                    System.out.printf("\n1 - Cima");
                                }else{
                                    System.out.printf("\n1 - Porta de cima fechada");
                                }
                                if(tab.getSetores()[p1.x][p1.y].getBaixo()){
                                    System.out.printf("\n2 - Baixo");
                                }else{
                                    System.out.printf("\n2 - Porta de baixo fechada");
                                }
                                if(tab.getSetores()[p1.x][p1.y].getDireita()){
                                    System.out.printf("\n3 - Direita");
                                }else{
                                    System.out.printf("\n3 - Porta da Direita fechada");
                                }
                                if(tab.getSetores()[p1.x][p1.y].getEsquerda()){
                                    System.out.printf("\n4 - Esquerda");
                                }else{
                                    System.out.printf("\n4 - Porta da Esquerda fechada");
                                }
                                System.out.printf("\n5 - Cancelar operacao");
                                System.out.printf("\nJogador 1, Escolha um movimento: ");
                                movimento = s.nextInt();
                                switch(movimento){
                                    case 1:
                                        p1.movimentar(tab, p1, 1);
                                        break;
                                    case 2:
                                        p1.movimentar(tab, p1, 2);
                                        break;
                                    case 3:
                                        p1.movimentar(tab, p1, 3);
                                        break;
                                    case 4:
                                        p1.movimentar(tab, p1, 4);
                                        break;
                                    case 5:
                                        y--;
                                        break;
                                    default:
                                        System.out.printf("Opcao invalida");
                                        break;
                                }
                            }while(movimento > 5 || movimento < 0);
                            break;
                        case 2:
                            p1.atacar(tab.getSetores()[p1.x][p1.y], p1);
                            break;
                        case 3:
                            p1.procurar(tab.getSetores()[p1.x][p1.y]);
                            break;
                        case 4:
                            i=25;
                            acao=4;
                            y=1;
                            System.out.printf("\n\n\tVoce perdeu\n\n");
                            break;
                        default:
                            System.out.printf("\n\n\tOpcao invalida\n\n");
                            break;
                    }
                
                    if(y==1)
                        j1=true;
                    else
                        j1=false;
                }
            }while(!j1);
            do{
                for(int y=0;y<2;y++){
                    int acao;
                    System.out.printf("\n\n\t\tJogador 2:[%d,%d]\tCiclo:%d",p2.x,p2.y,i+1);
                    System.out.printf("\n1-Movimentar\n2-Atacar\n3-Procurar\n4-Recuperar Defesa\n5-Sair do jogo\n");
                    System.out.printf("\n\n\nJogador 2, Digite sua %d opcao: ",y+1);
                    acao = s.nextInt();
                    switch(acao){
                        case 1:
                            int movimento;
                            do{
                                if(tab.getSetores()[p1.x][p1.y].getCima()){
                                    System.out.printf("\n1 - Cima");
                                }else{
                                    System.out.printf("\n1 - Porta de cima fechada");
                                }
                                if(tab.getSetores()[p1.x][p1.y].getBaixo()){
                                    System.out.printf("\n2 - Baixo");
                                }else{
                                    System.out.printf("\n2 - Porta de baixo fechada");
                                }
                                if(tab.getSetores()[p1.x][p1.y].getDireita()){
                                    System.out.printf("\n3 - Direita");
                                }else{
                                    System.out.printf("\n3 - Porta da Direita fechada");
                                }
                                if(tab.getSetores()[p1.x][p1.y].getEsquerda()){
                                    System.out.printf("\n4 - Esquerda");
                                }else{
                                    System.out.printf("\n4 - Porta da Esquerda fechada");
                                }
                                System.out.printf("\n5 - Cancelar operacao");
                                System.out.printf("\nJogador 1, Escolha um movimento: ");
                                movimento = s.nextInt();
                                switch(movimento){
                                    case 1:
                                        p2.movimentar(tab, p2, 1);
                                        break;
                                    case 2:
                                        p2.movimentar(tab, p2, 2);
                                        break;
                                    case 3:
                                        p2.movimentar(tab, p2, 3);
                                        break;
                                    case 4:
                                        p2.movimentar(tab, p2, 4);
                                        break;
                                    case 5:
                                        y--;
                                        break;
                                    default:
                                        System.out.printf("Opcao invalida");
                                        break;
                                }
                            }while(movimento > 5 || movimento < 0);
                            break;
                        case 2:
                            p2.atacar(tab.getSetores()[p2.x][p2.y], p2);
                            break;
                        case 3:
                            p2.procurar(tab.getSetores()[p2.x][p2.y]);
                            break;
                        case 4:
                            p2.recuperarDefesaSimples(p1);
                            break;
                        case 5:
                            i=25;
                            acao=4;
                            y=1;
                            System.out.printf("\n\n\tVoce perdeu\n\n");
                            break;
                        default:
                            System.out.printf("\n\n\tOpcao invalida\n\n");
                            break;
                    }
                
                    if(y==1)
                        j2=true;
                    else
                        j2=false;
                }
            
            }while(!j2);
        }
        s.close();
    }

    public static void imprimir(Tabuleiro tab){
            System.out.println("    -Antivirus por um dia-\n");
            
            System.out.print("      1   2   3   4   5");
            
            System.out.println();
    
            for(int i = 1; i < tab.getSetores().length+1;i++){
                System.out.print("    |");
                
                for(int j = 0; j < tab.getSetores().length;j++){
                    System.out.print("---|");
                }
                System.out.println();
                
                System.out.print(i + "   |");
                
                for(int j = 0; j < tab.getSetores().length;j++){
                    System.out.print("   |");
                }
                
                System.out.println();
            }
            
            System.out.println("    |---|---|---|---|---|");
    }
    public static void tabuleiro(JogadorSimples j1, JogadorSuporte j2,Tabuleiro tab) {
        System.out.printf("------------------------------\n");
        System.out.printf("|    Antivirus por um dia    |\n");
        System.out.printf("------------------------------\n");
        System.out.printf("    1   2   3   4   5\n");
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

}