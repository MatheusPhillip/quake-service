package dao;

import model.Game;

public interface IGameRepository {
	
	/*
	 *  RETORNA O GAME PELO ID PASSADO COMO PARÂMETRO
	 */
	public Game getGameById(String id);
}
