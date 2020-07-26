package controller;

import dao.GameRepository;
import interfaces.IGameRepository;

public class GameController {

	private IGameRepository game = new GameRepository();
	
	
	public void getGameById(String id) {
		if(game.getGameById(id) != null) {
			System.out.println(game.getGameById(id));
		}
		else {
			System.out.println("Não foi encontrado um game com ID: " + id);
		}
	}
	
	public void showAllGamesScore() {
		game.showAllGamesScore();
	}
}
