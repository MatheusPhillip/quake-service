package interfaces;

import model.Game;

public interface IGameRepository {
	
	/*
	 *  RETORNA O GAME PELO ID PASSADO COMO PAR�METRO
	 */
	public Game getGameById(String id);
	public void showAllGamesScore();
}
