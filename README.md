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
## Instalação
## Clone
- Clone este repositório em sua máquina local usando o link: `https://github.com/MatheusPhillip/quake-service.git` 
## Setup
- Buscar um jogo por ID: <br />
__Passo 1__ <br />
Abra a classe `Main.java` localizada na pasta: `\QuakeProject\src\main\java\main` <br />
__Passo 2__ <br />
Na linha __13__ informe o ID do jogo desta forma: `gameController.getGameById("game_2");` <br />

- Exibir lista de jogos: <br />
__Passo 1__ <br />
Abra a classe `Main.java` localizada na pasta: `\QuakeProject\src\main\java\main` <br />
Na linha __16__ o método `gameController.showAllGamesScore()` será responsável por mostrar a lista de jogos <br />
Caso não queira ver essa lista, simplesmente comente a linha `//` <br />
