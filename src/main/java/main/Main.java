package main;

import controller.GameController;

public class Main {

	public static void main(String[] args) {
		
		GameController gameController = new GameController();
		gameController.getGameById("game_2");
		gameController.showAllGamesScore();
	}

}
