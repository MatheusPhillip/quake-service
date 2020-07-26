package dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import interfaces.IGameRepository;
import model.Game;
import model.Player;
import model.QuakeParse;

public class GameRepository implements IGameRepository{
	
	private ArrayList<Game> games = new ArrayList<Game>();

	public GameRepository() {
		try {
			File file = new File("games.log");
			String path = file.getAbsolutePath();
			QuakeParse parse = new QuakeParse(path);
			for(Game game : parse.getGames()) {
				//games.put(game.getId(), game);
				games.add(game);
				bubbleSortPlayersScore(game.getPlayers());
			}
			//sortGamesById();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Game getGameById(String id) {
		for (Game game : games) {
			if(game.getId().equals(id)) {
				return game;
			}
		}          
		return null;
    }

	@Override
	public void showAllGamesScore() {
		
		for (Game game : games) {
			System.out.println("Resultado do " + game.getId() + ":");
			//game.showAllPlayersScore();
			System.out.println(game.toString());
		}
		/*
		for(Map.Entry<String, Game> game: games.entrySet()) {
			bubbleSortPlayersScore(game.getValue().getPlayers());
			System.out.println("Resultado do " + game.getValue().getId() + ":");
			//game.showAllPlayersScore();
			System.out.println(game.getValue().toString());
		}
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
