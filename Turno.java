public class Turno {
    public static void main(String args[]){
        // Maximo de 25 ciclos.
        // verificação se o jogador simples teve def =<0 antes que o Jogador Suporte jogue.

        /** Turno P1
             Atacar um inimigo. Por exemplo, suponha que P1 com ATK=2 ataque o
        inimigo 2 (3/3). Esse ataque reduz em 2 a DEF do inimigo, ou seja, o inimigo
        2 ficará com ATK/DEF igual a 3/1.
        b. Procurar no setor por itens. Esta procura consiste em sortear um número
        aleatório entre 1 e 6.
        i. Para números entre 1 e 3, nada é encontrado no setor.
        ii. Para número igual a 4, o jogador ganha 1 de DEF.
        iii. Para número igual a 5, o jogador ganha 2 de DEF.
        iv. Para número igual a 6, todos os inimigos do setor perdem 1 de DEF.
        * Cada opção acima (a,b) representa uma única ação, ou seja, o jogador pode:
        atacar duas vezes, atacar e procurar ou procurar duas vezes.
        */

        /*  Turno P2
            Após as duas ações do jogador P1, o turno do jogador P2 é iniciado. No seu turno,
        P2 pode realizar as mesmas ações descritas no Turno do P1. Além disso, o jogador P2
        pode optar por usar sua habilidade especial (recuperar defesa) no lugar das ações
        de atacar e procurar. Essa habilidade consiste em adicionar 2 a DEF dele ou do
        jogador P1, desde que P1 esteja NO MESMO SETOR que P2.
       -- Após finalizar os turnos de P1 e P2, os inimigos que estiverem vivos iniciam seu
        turno de ataque ***(única ação permitida)***. Cada inimigo ataca cada jogador uma única
        vez (somente os jogadores que estiverem no mesmo setor). Por exemplo, suponha
        que o inimigo 3 (2/2) ataque P1 (2/6) e P2 (1/7). Para cada ataque, um número
        aleatório entre 1 e 6 deve ser gerado. Se o número for par, o ataque é realizado;
        caso contrário, nada acontece. No caso do ataque ser destinado a P1, ele ficará com
        2/4, ou seja, a DEF do jogador atacado é reduzida pelo ATK do inimigo atacante. Em
        seguida, o inimigo 3 deve atacar P2 usando esse mesmo raciocínio. --
        Após todos os inimigos do setor finalizarem seu ataque, um novo ciclo é iniciado.
        Os jogadores P1 e P2 só podem se movimentar para outro setor, quando não
        existirem mais inimigos no setor em que eles se encontram. A Figura 3 mostra um
        exemplo em que P1 se movimentou para o Setor [2,4] e P2 para o Setor [3,5], em
        que novas portas e inimigos foram gerados.

        */
        int i = 0;
        Tabuleiro tab = new Tabuleiro();
        tab.init(tab.getPosicao()); // Gera uma matriz de setores
        JogadorSimples p1 = new JogadorSimples();
        JogadorSuporte p2 = new JogadorSuporte();
        do {
            tabuleiro(p1, p2,tab);
            i++;
        } while (i <= 25); // Número maximo de turno possíveis
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