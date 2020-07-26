package dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
			QuakeParse parse = new QuakeParse(path); // PARSE TRABALHA PARA O REPOSITÓRIO
			for(Game game : parse.getGames()) {		 // SALVA OS JOGOS ENCONTRADOS PELO PARSE
				games.add(game);
				bubbleSortPlayersScore(game.getPlayers());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 *  RETORNA O JOGO PROCURADO PELO SEU ID
	 */
	@Override
	public Game getGameById(String id) {
		for (Game game : games) {
			if(game.getId().equals(id)) {
				return game;
			}
		}          
		return null;
    }
	
	/*
	 * MOSTRA O RESULTADO DE TODOS OS JOGOS
	 */

	@Override
	public void showAllGamesScore() {
		
		for (Game game : games) {
			System.out.println("Resultado do " + game.getId() + ":");
			System.out.println(game.toString());
		}
	}
	
	/*
	 *  ORDENA OS JOGADORES DE CADA JOGO PELA PONTUAÇÃO DE CADA JOGADOR
	 *  MAIOR PONTUAÇÃO PRIMEIRO
	 */
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
