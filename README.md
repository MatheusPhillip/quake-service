# Quake Arena 3 Parser
> Este projeto visa lêr o conteúdo do arquivo games.log,
> identificando e categorizando suas informações.
> Para cada jogo encontrado ele exibirá algo como:
```
game_1: {
    total_kills: 45;
    players: ["Dono da bola", "Isgalamido", "Zeh"]
    kills: {
      "Dono da bola": 5,
      "Isgalamido": 18,
      "Zeh": 20
    }
  }
```
---
## Solução Proposta
> Para este projeto eu fiz com que o parse fosse instanciado dentro da classe GameRepository, pois ele serve ao jogo,
> logo, o GameRepository utiliza do parse para identificar e salvar os jogos.
> Tentei não ir além do pedido, por isso não fiz nada extravagante. Tirando a parte de salvar em arquivo, pois, primeiramente,
> achei que era para ser feito, e como não atrapalha no projeto eu optei por não remover.
> Tive dificuldades na questão de organização, mas percebo que não faz sentido a clase Player possuir "score" como atributo, já
> que um player, necessariamente, não possue tal característica, mas como Player faz referência a um player de um determinado game, 
> e não no game em si (Quake 3 Arena, neste caso), optei por fazer desta forma.
---
## Instalação
## Clone
- Clone este repositório em sua máquina local usando o link: `https://github.com/MatheusPhillip/quake-service.git` 
## Setup
- Inicializando o projeto: <br />
__Passo 1__ <br />
Inicialize o projeto através da classe principal: `Main.java` <br />
Após a inicialização será criado um arquivo denominado __games_parse.txt__ na pasta do projeto com todos os jogos identificados. <br />

- Buscar um jogo por ID: <br />
__Passo 1__ <br />
Abra a classe `Main.java` localizada na pasta: `\QuakeProject\src\main\java\main` <br />
__Passo 2__ <br />
Na linha __13__ informe o ID do jogo, desta forma: `gameController.getGameById("game_2");` e inicialize o projeto <br />

- Exibir a lista de jogos: <br />
__Passo 1__ <br />
Abra a classe `Main.java` localizada na pasta: `\QuakeProject\src\main\java\main` <br />
Na linha __16__ o método `gameController.showAllGamesScore()` será responsável por mostrar a lista de jogos <br />
Caso não queira ver essa lista, simplesmente comente a linha `//` <br />

