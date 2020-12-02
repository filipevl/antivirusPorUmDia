import java.util.Scanner;
public class Turno {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Tabuleiro tab = new Tabuleiro();
        tab.init(tab.getSetores());
        JogadorSimples p1 = new JogadorSimples();
        JogadorSuporte p2 = new JogadorSuporte();
        for(int i=0;i<25;i++){
            System.out.print('\u000C');
            System.out.printf("\nCiclo:%d\n",i+1);
            System.out.printf("Posicao Jogador 1:[%d,%d]\t",p1.x,p1.y);
            System.out.printf("Posicao Jogador 2:[%d,%d]\n",p2.x,p2.y);
            boolean j1=false; //Diz se o jogador 1 fez ou não suas duas jogadas
            do{
                for(int y=0;y<2;y++){
                    int acao;
                    do{
                        System.out.printf("\n1-Movimentar\n2-Atacar\n3-Procurar\n4-Sair do jogo\n");
                        System.out.printf("\n\n\nJogador Simples, Escolha uma acao: ");
                        acao = s.nextInt();
                        switch(acao){
                            case 1:
                                int movimento;
                                do{
                                    System.out.print('\u000C');
                                    System.out.printf("\nJogador Simples, Escolha um movimento:\n");
                                    System.out.printf("\n1-Cima\n2-Baixo\n3-Esquerda\n4-Direita\n");
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
                                        default:
                                            System.out.printf("Opcao invalida");
                                            break;
                                    }
                                }while(movimento != 1 || movimento != 2 || movimento != 3 || movimento != 4);
                                break;
                            case 2:
                                // p1.atacar()
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
                    }while(acao>0||acao<4);
                    if(y==1)
                        j1=true;
                    else
                        j1=false;
                }
            }while(!j1);
        }
        s.close();
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

    public static void turnoP(JogadorSimples j1, JogadorSuporte j2, Inimigo i){
        
    }

}