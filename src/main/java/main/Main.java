package main;

import controller.GameController;

public class Main {

	public static void main(String[] args) {
		
		// INICIA O PARSER NO SEU CONSTRUTOR
		GameController gameController = new GameController();
		
		// PROCURA UM GAME POR ID
		gameController.getGameById("game_2");
		
		// MOSTRA TODOS OS JOGOS COM RANKING DE KILLS POR JOGADOR
		gameController.showAllGamesScore();
	}

}
