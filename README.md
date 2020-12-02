# Projeto Final SIN-141 - Programa Orientada a Objetos

Antivírus por um dia é um jogo de tabuleiro desktop colaborativo projetado para dois
jogadores. Esse jogo foi inventado por Clausius Reis e tem como objetivo percorrer os
setores da memória de um computador infectados por vírus. O jogador assume o papel de
antivírus, que deve avançar pelos setores, eliminando os vírus que encontrar, até que o
setor com a fonte de infecção seja alcançado. Mas tome cuidado, os vírus podem te destruir
no caminho.

## Regras do Jogo

O jogo possui dois personagens principais, os jogadores e os inimigos (vírus), e é baseado em um sistema de turnos para combate. Mais informações sobre o jogo são apresentadas nas próximas subseções.

### Jogadores

O jogo é formado por dois tipos de jogadores: simples e de suporte.
1. Cada jogador possui um valor para ataque (ATK) e um valor de defesa (DEF), sendo que o poder de ataque e defesa dos jogadores são fixos. O jogador simples deve ter ATK=2 e DEF=6 e o jogador de suporte deve ter ATK=1 e DEF=7.
2. O jogador simples não possui habilidades especiais, já o jogador de suporte, possui a capacidade de recuperar 2 pontos de sua defesa ou da defesa de outro jogador que esteja no mesmo setor.
3. O jogador de suporte deve sempre possuir ataque menor que o jogador simples.
4. O jogador de suporte não pode existir sem um jogador simples.
5. O jogador simples pode executar as seguintes ações no jogo: movimentar, atacar e procurar.
6. O jogador de suporte pode executar as seguintes ações no jogo: movimentar, atacar, procurar e recuperar defesa.
7. As ações dos itens 6 e 7 serão detalhadas na seção Turno.