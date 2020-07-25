package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import interfaces.IGameRepository;
import model.Game;
import model.Player;
import model.QuakeParse;

public class GameRepository implements IGameRepository{
	
	private Map<String, Game> games = new HashMap<>();

	public GameRepository() {
		try {
			QuakeParse parse = new QuakeParse("C:\\Users\\Matheus\\Documents\\PropositoDigital\\QuakeProject\\games.log");
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

	@Override
	public void showAllGamesScore() {
		for(Map.Entry<String, Game> game: games.entrySet()) {
			bubbleSortPlayersScore(game.getValue().getPlayers());
			System.out.println("Resultado do " + game.getValue().getId() + ":");
			//game.showAllPlayersScore();
			System.out.println(game.getValue().toString());
		}
		/*
		for(Game game : games.values()) {
			bubbleSortPlayersScore(game.getPlayers());
			System.out.println("Resultado do " + game.getId() + ":");
			//game.showAllPlayersScore();
			System.out.println(game.toString());
		}
		*/
		
	}
	
	private void bubbleSortPlayersScore(ArrayList<Player> players) {
		boolean change;
	    do {
	        change = false;
	        for (int i = 0; i < players.size() - 1; i++) {
	             if (players.get(i).getScore() < players.get(i + 1).getScore()) {
	                 Player playerAux = new Player(players.get(i).getNickName());
	                 playerAux.setScore(players.get(i).getScore());
	                 players.get(i).setNickName(players.get(i+1).getNickName());
	                 players.get(i).setScore(players.get(i+1).getScore());
	                 players.get(i+1).setNickName(playerAux.getNickName());
	                 players.get(i+1).setScore(playerAux.getScore());
	                 change = true;
	             }
	        }
	    } while (change);
	}

	
	
	

	
}
