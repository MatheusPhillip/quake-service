package controller;

import dao.GameRepository;
import dao.IGameRepository;

public class GameController {

private IGameRepository game = new GameRepository();
	
	public void getGameById(String id) {
		System.out.println(game.getGameById(id));
	}
	
}
