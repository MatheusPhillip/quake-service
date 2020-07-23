package dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.Game;
import model.QuakeParse;

public class GameRepository implements IGameRepository{
	
	private Map<String, Game> games = new HashMap<>();

	public GameRepository() {
		try {
			QuakeParse parse = new QuakeParse("C:\\Users\\Matheus\\Documents\\PropositoDigital\\games.log");
			for(Game game : parse.getGames()) {
				games.put(game.getId(), game);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Game getGameById(String id) {
		return games.get(id);
	}

	
}
